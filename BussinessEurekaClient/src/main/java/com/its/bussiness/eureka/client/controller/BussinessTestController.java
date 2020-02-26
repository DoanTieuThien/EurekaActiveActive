package com.its.bussiness.eureka.client.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.its.gateway.eureka.client.models.ResponseModel;

@RestController
@CrossOrigin("*")
@RequestMapping("/bussiness-test")
public class BussinessTestController {
	
	@GetMapping("/test")
	public ResponseModel testBussiness() {
		ResponseModel response = new ResponseModel();

		try {
			response.setCode("BU-00000");
			response.setDes("SUCCESSED");
			response.setPayload("Hello i am bussiness node 1");
		} catch (Exception exp) {
			exp.printStackTrace();
			response.setCode("BU-99999");
			response.setDes(exp.getMessage());
		}
		return response;
	}
}
