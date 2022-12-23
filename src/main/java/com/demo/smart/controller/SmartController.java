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
	
// this methd is to load test data into the sytem
	@GetMapping("/loadData")
	public ModelAndView loadData(
			@RequestParam final Map<String, String> queryParams) {
		
		// logic here is that we are going to have SmartModel which will have list of smartFeatures and also list of services and devices.
		// Now as services and devices has common properties thus we are using CommonModel object for this purpose
		// As you can see, this program requires SmartFeature also have list of services and devices, we are reusing same CommonModel to support
				
		ModelAndView modelAndView = new ModelAndView("home");
		
		// creating the instance of SmartModel
		SmartModel smartModel = new SmartModel();
		
		// creating the instance of SmartModel devices and setting test value
		List<CommonModel> devices = new ArrayList<>();
		CommonModel device = new CommonModel("Remotely Controllable Camera",
				"device", "smartModel");
		devices.add(device);
		// before setting it to smart model, we are saving it to DB
		devices = commonModelRepository.saveAllAndFlush(devices);
		smartModel.setDevices(devices);
		//

		// creating the instance of SmartModel services and setting test value
		List<CommonModel> services = new ArrayList<>();
		CommonModel service = new CommonModel("Open Weather Map", "service",
				"smartModel");
		services.add(service);
		service = new CommonModel("IMDB Movie Database", "service",
				"smartModel");
		services.add(service);
		// before setting it to smart model, we are saving it to DB
		services = commonModelRepository.saveAllAndFlush(services);
		smartModel.setServices(services);
		//

		// smart features
		// creating the instance of SmartFeatures and setting test value
		List<SmartFeature> smartFeatures = new ArrayList<>();

		
		SmartFeature smartFeature = new SmartFeature();
		
		// creating the instance of SmartFeatures devices and setting test value
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
		// before setting it to smart features, we are saving it to DB
		smartFeatureDevices = commonModelRepository
				.saveAllAndFlush(smartFeatureDevices);
		smartFeature.setDevices(smartFeatureDevices);


		// creating the instance of SmartFeatures services and setting test value
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

		// before setting it to smart features, we are saving it to DB
		smartFeatureServices = commonModelRepository
				.saveAllAndFlush(smartFeatureServices);
		smartFeature.setServices(smartFeatureServices);

		smartFeatures.add(smartFeature);
		
		// before setting it to smart model, we are saving it to DB
		smartFeatures = smartFeatureRepository.saveAllAndFlush(smartFeatures);
		smartModel.setSmartFeatures(smartFeatures);
		//

		// saving all info to DB
		smartModelRepository.saveAndFlush(smartModel);

		return modelAndView;
	}

}
