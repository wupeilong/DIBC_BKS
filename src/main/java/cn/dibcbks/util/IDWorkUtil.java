package cn.dibcbks.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;


/**
 * Twitter的分布式自增ID算法生成工具类
 */
public class IDWorkUtil {
    /**
     * 开始时间截 (2019-03-01)
     */
    private static final long twepoch = 1551412574452L;

    /**
     * 机器id所占的位数
     */
    private static final long workerIdBits = 5L;

    /**
     * 数据标识id所占的位数
     */
    private static final long datacenterIdBits = 5L;

    /**
     * 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
     */
    private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /**
     * 支持的最大数据标识id，结果是31
     */
    private static final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /**
     * 序列在id中占的位数
     */
    private static final long sequenceBits = 12L;

    /**
     * 机器ID向左移12位
     */
    private static final long workerIdShift = sequenceBits;

    /**
     * 数据标识id向左移17位(12+5)
     */
    private static final long datacenterIdShift = sequenceBits + workerIdBits;

    /**
     * 时间截向左移22位(5+5+12)
     */
    private static final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    /**
     * 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
     */
    private static final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     * 工作机器ID(0~31)
     */
    private static long workerId;

    /**
     * 数据中心ID(0~31)
     */
    private static long datacenterId;

    /**
     * 毫秒内序列(0~4095)
     */
    private static long sequence = 0L;

    /**
     * 上次生成ID的时间截
     */
    private static long lastTimestamp = -1L;

    /**
     * 构造函数
     *
     * @param workerId     工作ID (0~31)
     * @param datacenterId 数据中心ID (0~31)
     */
    public IDWorkUtil(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    /**
     * 获得下一个ID (该方法是线程安全的)
     *
     * @return SnowflakeId
     */
    public static synchronized long nextId() {
        long timestamp = timeGen();

        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            //毫秒内序列溢出
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        //时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }

        //上次生成ID的时间截
        lastTimestamp = timestamp;

        //移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift) //
                | (datacenterId << datacenterIdShift) //
                | (workerId << workerIdShift) //
                | sequence;
    }

    /**
     * 返回25位ID给调用方
     *
     * @return
     */
    public static String getProductId() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String startStr = sf.format(new Date());
        StringBuilder sb = new StringBuilder();
        return sb.append(startStr).append(String.valueOf(IDWorkUtil.nextId()).substring(7)).toString();
    }


    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    protected static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒为单位的当前时间
     *
     * @return 当前时间(毫秒)
     */
    protected static long timeGen() {
        return System.currentTimeMillis();

    }

    /**
     * @author: wupeilong
     * @description: 生成默认的账户名称
     * @date: 2019/3/15 0015 14:55
     * @param: []
     * @return: java.lang.String
     */
    public static String getDefaultUserName() {
        StringBuilder sb = new StringBuilder("MSC");
        return sb.append(String.valueOf(IDWorkUtil.nextId()).substring(10)).toString();
    }

    /**
     * @author: wupeilong
     * @description: 生成用户唯一编码
     * @date: 2019/3/15 0015 14:55
     * @param: []
     * @return: java.lang.String
     */
    public static String getUniqueCode() {
        return String.valueOf(IDWorkUtil.nextId()).substring(11);
    }

    /**
     * @author: wupeilong
     * @description: 生成默认取餐编码
     * @date: 2019/3/15 0015 14:55
     * @param: []
     * @return: java.lang.String
     */
    public static String getTakeFoodCode() {
        return String.valueOf(IDWorkUtil.nextId()).substring(14);
    }

    /**
     *  生成产品或中央厨房编码，如：000001 或 0001
     * @param num
     * @param num
     * @return
     */
    public static String getProductCode(Integer initialValue,Integer number){
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumIntegerDigits(number);
        nf.setMinimumIntegerDigits(number);
        return nf.format(initialValue);
    }

    public static void main(String[] args) {
        //System.out.println(getDefaultUserName());
        System.out.println(getUniqueCode());
        /*
        题目: 将颜色数组 红色,绿色,蓝色 转成 JSON 字符串
        */
//       Integer[] colors = {1,2,3};
       List<Integer>  colors = new ArrayList<>();
       colors.add(1);
       colors.add(3);
       colors.add(5);
       System.err.println(colors);
       String fromObject = JSONArray.toJSONString(colors);
       System.err.println(fromObject.toString());
       JSONArray jsonArray = JSONArray.parseArray(fromObject.toString());
       System.err.println(jsonArray);
    }

}
