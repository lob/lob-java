package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

import static com.lob.Util.defensiveCopy;

public class SettingResponseList {
    @JsonProperty private final List<SettingResponse> data;
    @JsonProperty private final String object;

    @JsonCreator
    public SettingResponseList(
            @JsonProperty("data") final List<SettingResponse> data,
            @JsonProperty("object") final String object) {
        this.data = data;
        this.object = object;
    }

    public List<SettingResponse> getData() {
        return defensiveCopy(data);
    }

    public String getObject() {
        return object;
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public Iterator<SettingResponse> iterator() {
        return defensiveCopy(data).iterator();
    }

    public SettingResponse get(final int index) {
        return data.get(index);
    }

    @Override
    public String toString() {
        return "SettingResponseList{" +
            "data=" + data +
            ", object='" + object + '\'' +
            '}';
    }
}
