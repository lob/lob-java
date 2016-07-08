package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.TrackingId;
import org.joda.time.DateTime;

import java.util.Collection;

import static com.lob.Util.defensiveCopy;

public class TrackingEventResponse {
    @JsonProperty("name") private final String name;
    @JsonProperty("location") private final String location;
    @JsonProperty("time") private final DateTime time;
    @JsonProperty("date_created") private final DateTime dateCreated;
    @JsonProperty("date_modified") private final DateTime dateModified;
    @JsonProperty("object") private final String object;

    @JsonCreator
    public TrackingEventResponse(
        @JsonProperty("name") final String name,
        @JsonProperty("location") final String location,
        @JsonProperty("time") final DateTime time,
        @JsonProperty("date_created") final DateTime dateCreated,
        @JsonProperty("date_modified") final DateTime dateModified,
        @JsonProperty("object") final String object) {
            this.name = name;
            this.location = location;
            this.time = time;
            this.dateCreated = dateCreated;
            this.dateModified = dateModified;
            this.object = object;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public DateTime getTime() {
        return time;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DateTime getDateModified() {
        return dateModified;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "TrackingEventResponse{" +
            "name='" + name + '\'' +
            ", location='" + location + '\'' +
            ", time='" + time + '\'' +
            ", dateCreated=" + dateCreated +
            ", dateModified=" + dateModified +
            ", object='" + object + '\'' +
            '}';
    }
}
