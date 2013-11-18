package com.lob.model;

import java.util.List;

public class PackagingCollection extends LobObject {
	List<Packaging> data;
	Integer count;
	
	public List<Packaging> getData() {
		return data;
	}
	public void setData(List<Packaging> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}