package com.demo.smart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.smart.model.CommonModel;
import com.demo.smart.model.SmartFeature;
import com.demo.smart.model.SmartModel;
import com.demo.smart.repositories.CommonModelRepository;
import com.demo.smart.repositories.SmartFeatureRepository;
import com.demo.smart.repositories.SmartModelRepository;

@RestController
public class SmartController {
	@Autowired
	private SmartModelRepository smartModelRepository;
	@Autowired
	private CommonModelRepository commonModelRepository;
	@Autowired
	private SmartFeatureRepository smartFeatureRepository;

	@GetMapping("/")
	public ModelAndView getHome(
			@RequestParam final Map<String, String> queryParams) {
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}

	@GetMapping("/loadData")
	public ModelAndView loadData(
			@RequestParam final Map<String, String> queryParams) {
		ModelAndView modelAndView = new ModelAndView("home");
		SmartModel smartModel = new SmartModel();
		List<CommonModel> devices = new ArrayList<>();
		CommonModel device = new CommonModel("Remotely Controllable Camera",
				"device", "smartModel");
		devices.add(device);
		devices = commonModelRepository.saveAllAndFlush(devices);
		smartModel.setDevices(devices);

		List<CommonModel> services = new ArrayList<>();
		CommonModel service = new CommonModel("Open Weather Map", "service",
				"smartModel");
		services.add(service);
		service = new CommonModel("IMDB Movie Database", "service",
				"smartModel");
		services.add(service);
		services = commonModelRepository.saveAllAndFlush(services);
		smartModel.setServices(services);

		// smart features
		List<SmartFeature> smartFeatures = new ArrayList<>();

		SmartFeature smartFeature = new SmartFeature();
		List<CommonModel> smartFeatureDevices = new ArrayList<>();
		CommonModel smartFeatureDevice = new CommonModel(
				"Take Camera Screenshot", "device", "smartFeature");
		smartFeatureDevices.add(smartFeatureDevice);
		smartFeatureDevice = new CommonModel("Get Camera Live Video URL",
				"device", "smartFeature");
		smartFeatureDevices.add(smartFeatureDevice);
		smartFeatureDevice = new CommonModel("Get Calories burned for a day",
				"device", "smartFeature");
		smartFeatureDevices.add(smartFeatureDevice);

		smartFeatureDevices = commonModelRepository
				.saveAllAndFlush(smartFeatureDevices);
		smartFeature.setDevices(smartFeatureDevices);

		List<CommonModel> smartFeatureServices = new ArrayList<>();
		CommonModel smartFeatureService = new CommonModel(
				"Get Weekly Forecast in a City", "service", "smartFeature");
		smartFeatureServices.add(smartFeatureService);
		smartFeatureService = new CommonModel("Get Daily Forecast for a State",
				"service", "smartFeature");
		smartFeatureServices.add(smartFeatureService);

		smartFeatureService = new CommonModel("Search Movie", "service",
				"smartFeature");
		smartFeatureServices.add(smartFeatureService);

		smartFeatureServices = commonModelRepository
				.saveAllAndFlush(smartFeatureServices);
		smartFeature.setServices(smartFeatureServices);

		smartFeatures.add(smartFeature);
		smartFeatures = smartFeatureRepository.saveAllAndFlush(smartFeatures);
		smartModel.setSmartFeatures(smartFeatures);

		smartModelRepository.saveAndFlush(smartModel);

		return modelAndView;
	}

}
