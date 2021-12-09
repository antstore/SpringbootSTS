package com.example.demo.controller;

import com.example.demo.service.UserResponseList;

public class UserResponse {
	
	boolean status;
	public boolean isStatus() {
		return status;
	}
	UserResponseList obj;

	public UserResponseList getObj() {
		return obj;
	}

	public void setObj(UserResponseList obj) {
		this.obj = obj;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	String success;

	public UserResponse(boolean statusTrue, String success) {
		this.status = statusTrue;
		this.success =success;
	}

	public void setData(UserResponseList obj) {
		//this.setData(obj);
	}

}
