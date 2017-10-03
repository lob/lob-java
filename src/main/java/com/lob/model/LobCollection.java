package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class LobCollection<T> {
    @JsonProperty private final List<T> data;
    @JsonProperty private final int count;
    @JsonProperty private final String object;

    @JsonCreator
    public LobCollection(List<T> data, final int count, final String object) {
        this.data = data;
        this.count = count;
        this.object = object;
    }

    public List<T> getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
            "data=" + data +
            ", count=" + count +
            ", object=" + object +
            '}';

    }

}
