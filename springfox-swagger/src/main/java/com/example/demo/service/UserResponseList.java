package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

public class UserResponseList {
	
	Integer totalPages;
	Long totalCount;
	Integer pageNo;
	List<UserResponseDto> users = new ArrayList<UserResponseDto>();
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long l) {
		this.totalCount = l;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public List<UserResponseDto> getUsers() {
		return users;
	}
	public void setUsers(List<UserResponseDto> users) {
		this.users = users;
	}

}
