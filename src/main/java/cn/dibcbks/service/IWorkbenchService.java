package cn.dibcbks.service;

import org.springframework.ui.ModelMap;

public interface IWorkbenchService {

	String workbench(ModelMap modelMap);

	String unitInfo(ModelMap modelMap);

	String practitioners(ModelMap modelMap);

	String procurement(ModelMap modelMap);

	String manufacturingInspection(ModelMap modelMap);

	String distribution(ModelMap modelMap);

	String disinfection(ModelMap modelMap);

	String check(ModelMap modelMap);

	String detectionReport(ModelMap modelMap);

	String videoSurveillance(ModelMap modelMap);

}
