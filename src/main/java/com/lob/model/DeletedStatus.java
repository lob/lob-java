package com.lob.model;

public class DeletedStatus extends LobObject {
	int deleted;
	public String getMessage() {
		return String.valueOf(deleted);
	}	
}
