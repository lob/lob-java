package com.lob.model;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class LobRawJsonObjectDeserializer implements JsonDeserializer<LobRawJsonObject> {
	public LobRawJsonObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		LobRawJsonObject object = new LobRawJsonObject();
		object.json = json.getAsJsonObject();
		return object;
	}

}
