package com.lob.model;

import java.util.List;

public class BankAccountCollection extends LobObject {
	List<Bank_account> data;
	Integer count;
	
	public List<Bank_account> getData() {
		return data;
	}
	public void setData(List<Bank_account> data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}