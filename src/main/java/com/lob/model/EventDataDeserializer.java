package com.lob.model;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.lob.net.APIResource;

public class EventDataDeserializer implements JsonDeserializer<EventData> {

	@SuppressWarnings("rawtypes")
	static Map<String, Class> objectMap = new HashMap<String, Class>();
    static {
        objectMap.put("address", Address.class);
        objectMap.put("bank_account", Bank_account.class);
        objectMap.put("check", Check.class);
        objectMap.put("country", Country.class);
        objectMap.put("object", Object.class);
        objectMap.put("packaging", Packaging.class);
        objectMap.put("postcard", Postcard.class);
        objectMap.put("service", Service.class);
        objectMap.put("setting", Setting.class);
        objectMap.put("state", State.class);
    }
    
    private java.lang.Object deserializeJsonPrimitive(JsonPrimitive element) {
    	if (element.isBoolean()) {
    		return element.getAsBoolean();
    	} else if (element.isNumber()) {
    		return element.getAsNumber();
    	} else {
    		return element.getAsString();
    	}
    }
    
    private java.lang.Object[] deserializeJsonArray(JsonArray arr) {
    	java.lang.Object[] elems = new java.lang.Object[arr.size()];
    	Iterator<JsonElement> elemIter = arr.iterator();
    	int i = 0;
    	while (elemIter.hasNext()) {
    		JsonElement elem = elemIter.next();
    		elems[i++] = deserializeJsonElement(elem);
    	}
    	return elems;
    }
    
    private java.lang.Object deserializeJsonElement(JsonElement element) {
    	if (element.isJsonNull()) {
    		return null;
    	} else if (element.isJsonObject()) {
			Map<String, java.lang.Object> valueMap = new HashMap<String, java.lang.Object>();
			populateMapFromJSONObject(valueMap, element.getAsJsonObject());
			return valueMap;
		} else if (element.isJsonPrimitive()) {
			return deserializeJsonPrimitive(element.getAsJsonPrimitive());
		} else if (element.isJsonArray()) {
			return deserializeJsonArray(element.getAsJsonArray());
		} else {
			System.err.println("Unknown JSON element type for element " + element + ". " +
					"If you're seeing this messaage, it's probably a bug in the Stripe Java " +
					"library. Please contact us by email at support@stripe.com.");
			return null;
		}
	}
    
    private void populateMapFromJSONObject(Map<String, java.lang.Object> objMap, JsonObject jsonObject) {
		for(Map.Entry<String, JsonElement> entry: jsonObject.entrySet()) {
			String key = entry.getKey();
			JsonElement element = entry.getValue();
			objMap.put(key, deserializeJsonElement(element));
		}
    }

	@SuppressWarnings("unchecked")
	public EventData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		EventData eventData = new EventData();
		JsonObject jsonObject = json.getAsJsonObject();
		for(Map.Entry<String, JsonElement> entry: jsonObject.entrySet()) {
			String key = entry.getKey();
			JsonElement element = entry.getValue();
			if("previous_attributes".equals(key)) {
				Map<String, java.lang.Object> previousAttributes = new HashMap<String, java.lang.Object>();
				populateMapFromJSONObject(previousAttributes, element.getAsJsonObject());
				eventData.setPreviousAttributes(previousAttributes);
			} else if ("object".equals(key)) {
				String type = element.getAsJsonObject().get("object").getAsString();
				Class<LobObject> cl = objectMap.get(type);
				LobObject object = APIResource.gson.fromJson(entry.getValue(), cl != null ? cl : LobRawJsonObject.class);
				eventData.setObject(object);
			}
		}
		return eventData;
	}
}
