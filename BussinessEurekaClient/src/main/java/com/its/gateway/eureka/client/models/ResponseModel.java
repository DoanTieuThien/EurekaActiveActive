package com.its.gateway.eureka.client.models;

import java.io.Serializable;

public class ResponseModel implements Serializable {
	private String code;
	private String des;
	private Object payload;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}
}
