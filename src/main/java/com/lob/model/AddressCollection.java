package com.lob.model;

import java.util.List;

public class AddressCollection extends LobObject {
	List<Address> data;
	Integer count;
	
	public List<Address> getData() {
		return data;
	}
	public void setData(List<Address> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}