package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

import static com.lob.Util.defensiveCopy;

public abstract class AbstractResponseList<T> implements Iterable<T> {
    @JsonProperty private final List<T> data;
    @JsonProperty private final String object;

    @JsonCreator
    public AbstractResponseList(
            @JsonProperty("data") final List<T> data,
            @JsonProperty("object") final String object) {
        this.data = data;
        this.object = object;
    }

    public List<T> getData() {
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

    public Iterator<T> iterator() {
        return defensiveCopy(data).iterator();
    }

    public T get(final int index) {
        return data.get(index);
    }

    @Override
    public String toString() {
        return "{" +
            "data=" + data +
            ", object='" + object + '\'' +
            '}';
    }
}
