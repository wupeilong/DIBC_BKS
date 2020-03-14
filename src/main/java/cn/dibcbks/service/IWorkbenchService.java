package cn.dibcbks.service;

import org.springframework.ui.ModelMap;

public interface IWorkbenchService {

	String workbench(ModelMap modelMap);

	String unitInfo(ModelMap modelMap);

	String practitioners(ModelMap modelMap);

	String purchaseReport(ModelMap modelMap);

	String manufacturingInspection(ModelMap modelMap);

	String deliveryDistribution(ModelMap modelMap);

	String cleaningDisinfection(ModelMap modelMap);

	String regulatory(ModelMap modelMap);

	String inspectionReport(ModelMap modelMap);

	String videoSurveillance(ModelMap modelMap);

}
