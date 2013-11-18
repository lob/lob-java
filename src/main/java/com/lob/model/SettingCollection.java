package com.lob.model;

import java.util.List;

public class SettingCollection extends LobObject {
	List<Setting> data;
	Integer count;
	
	public List<Setting> getData() {
		return data;
	}
	public void setData(List<Setting> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}