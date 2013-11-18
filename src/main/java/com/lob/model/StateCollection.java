package com.lob.model;

import java.util.List;

public class StateCollection extends LobObject {
	List<State> data;
	Integer count;
	
	public List<State> getData() {
		return data;
	}
	public void setData(List<State> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}