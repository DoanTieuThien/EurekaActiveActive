package com.its.register.eureka.server.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.http.EurekaApplications;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.its.register.eureka.server.model.ResponseModel;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.eureka.EurekaServerContext;

@RestController
@CrossOrigin("*")
@RequestMapping("/gateway")
public class QueryBusinessAliveController {
	private static final Logger log = LoggerFactory.getLogger(QueryBusinessAliveController.class);

	@Autowired
	private EurekaServerContext eurekaApplication;

	@RequestMapping("/query-business-alive")
	public ResponseModel queryBusinessAlive(HttpServletRequest request) {
		ResponseModel res = new ResponseModel();
		String remoteAddress = request.getRemoteAddr();

		try {
			log.info("Found request from client " + remoteAddress);
			List<Application> applications = this.eurekaApplication.getRegistry().getSortedApplications();

			if (applications == null || applications.size() == 0) {
				throw new Exception("No found any business alive");
			}
			int size = applications.size();
			Random random = new Random();
			int index = random.nextInt(size);
			Application app = applications.get(index);
			log.info("query info of app " + app.getName() + " from client " + remoteAddress);
			List<InstanceInfo> instanceList = app.getInstances();
			
			if (instanceList == null || instanceList.size() == 0) {
				throw new Exception("No found any business alive");
			}
			
			int instanceSize = instanceList.size();
			index = random.nextInt(instanceSize);
			InstanceInfo instance = instanceList.get(index);
			
			log.info("query info of instance " + instance.getIPAddr() + " from client " + remoteAddress);
			res.setCode("API-00000");
			res.setMessage("SUCCESS");
			res.setPayload("http://" + instance.getIPAddr() + ":" + instance.getPort());
			log.info("successed request from client " + remoteAddress);
		} catch (Exception exp) {
			res.setCode("API-99999");
			res.setMessage("Error: " + exp.getMessage());
			log.error("error process " + remoteAddress, exp);
		}
		log.info("Finished request from client " + remoteAddress);
		return res;
	}
}
