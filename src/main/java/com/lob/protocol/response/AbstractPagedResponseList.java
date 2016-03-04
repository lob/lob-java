package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

import static com.lob.Util.defensiveCopy;

public abstract class AbstractPagedResponseList<T> implements Iterable<T> {
    @JsonProperty private final List<T> data;
    @JsonProperty private final String object;
    @JsonProperty private final int count;

    @JsonCreator
    public AbstractPagedResponseList(
            @JsonProperty("data") final List<T> data,
            @JsonProperty("object") final String object,
            @JsonProperty("count") final int count) {
        this.data = data;
        this.object = object;
        this.count = count;
    }

    public List<T> getData() {
        return defensiveCopy(data);
    }

    public String getObject() {
        return object;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public T get(final int index) {
        return data.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return defensiveCopy(data).iterator();
    }

    @Override
    public String toString() {
        return "data=" + data +
            ", object='" + object + '\'' +
            ", count=" + count;
    }
}
