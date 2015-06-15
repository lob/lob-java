package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.lob.Util.defensiveCopy;

public class ServiceResponseList implements Iterable<ServiceResponse> {
    @JsonProperty private final List<ServiceResponse> data;
    @JsonProperty private final String object;

    @JsonCreator
    public ServiceResponseList(
            @JsonProperty("data") final List<ServiceResponse> data,
            @JsonProperty("object") final String object) {
        this.data = data;
        this.object = object;
    }

    public List<ServiceResponse> getData() {
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

    public ServiceResponse get(final int index) {
        return data.get(index);
    }

    @Override
    public Iterator<ServiceResponse> iterator() {
        return defensiveCopy(data).iterator();
    }

    @Override
    public String toString() {
        return "ServiceResponseList{" +
            "data=" + data +
            ", object='" + object + '\'' +
            '}';
    }
}
