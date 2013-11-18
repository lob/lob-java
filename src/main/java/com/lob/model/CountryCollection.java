package com.lob.model;

import java.util.List;

public class CountryCollection extends LobObject {
	List<Country> data;
	Integer count;
	
	public List<Country> getData() {
		return data;
	}
	public void setData(List<Country> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}