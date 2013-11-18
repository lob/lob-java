package com.lob.model;

import java.util.List;

public class ObjectCollection extends LobObject {
	List<Object> data;
	Integer count;
	
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}