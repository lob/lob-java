package com.lob.model;

import java.util.Map;

public class EventData extends LobObject {
	Map<String, java.lang.Object> previousAttributes;
	LobObject object;
	
	public Map<String, java.lang.Object> getPreviousAttributes() {
		return previousAttributes;
	}
	
	public void setPreviousAttributes(Map<String, java.lang.Object> previousAttributes) {
		this.previousAttributes = previousAttributes;
	}

	public LobObject getObject() {
		return object;
	}

	public void setObject(LobObject object) {
		this.object = object;
	}
}
