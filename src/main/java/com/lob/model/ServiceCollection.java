package com.lob.model;

import java.util.List;

public class ServiceCollection extends LobObject {
	List<Service> data;
	Integer count;
	
	public List<Service> getData() {
		return data;
	}
	public void setData(List<Service> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}