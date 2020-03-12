package cn.dibcbks.entity;

/**
 * 单位视频地址信息表
 * @author Administrator
 *
 */
public class VideoAddress {
	private Integer unitId;//单位ID
	private String videoAddress;//视频地址
	private String cameraPosition;//摄像机位
	public VideoAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoAddress(Integer unitId, String videoAddress, String cameraPosition) {
		super();
		this.unitId = unitId;
		this.videoAddress = videoAddress;
		this.cameraPosition = cameraPosition;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getVideoAddress() {
		return videoAddress;
	}
	public void setVideoAddress(String videoAddress) {
		this.videoAddress = videoAddress;
	}
	public String getCameraPosition() {
		return cameraPosition;
	}
	public void setCameraPosition(String cameraPosition) {
		this.cameraPosition = cameraPosition;
	}
	@Override
	public String toString() {
		return "VideoAddress [unitId=" + unitId + ", videoAddress=" + videoAddress + ", cameraPosition="
				+ cameraPosition + "]";
	}
	
}
