package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BillingGroupCollection extends LobCollection<BillingGroup> {

	@JsonCreator
	public BillingGroupCollection(
			@JsonProperty("data") final List<BillingGroup> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
		super(data, count, object);
	}

}
