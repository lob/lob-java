package com.lob.model;

import java.util.List;

public class PostcardCollection extends LobObject {
	List<Postcard> data;
	Integer count;
	
	public List<Postcard> getData() {
		return data;
	}
	public void setData(List<Postcard> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}