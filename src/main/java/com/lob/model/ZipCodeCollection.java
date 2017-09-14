package com.lob.model;

        import com.fasterxml.jackson.annotation.JsonCreator;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import java.util.List;

public class ZipCodeCollection extends LobCollection<ZipCode> {

    @JsonCreator
    public ZipCodeCollection(
            @JsonProperty("data") final List<ZipCode> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
        super(data, count, object);
    }
}