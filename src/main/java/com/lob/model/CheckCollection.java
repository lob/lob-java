package com.lob.model;

import java.util.List;

public class CheckCollection extends LobObject {
	List<Check> data;
	Integer count;
	
	public List<Check> getData() {
		return data;
	}
	public void setData(List<Check> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}