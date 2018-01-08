package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class TrackingEvent {

    @JsonProperty private final String id;
    @JsonProperty private final String name;
    @JsonProperty private final String location;
    @JsonProperty private final ZonedDateTime time;
    @JsonProperty private final ZonedDateTime dateCreated;
    @JsonProperty private final ZonedDateTime dateModified;
    @JsonProperty private final String object;

    @JsonCreator
    public TrackingEvent(
            @JsonProperty("id") final String id,
            @JsonProperty("name") final String name,
            @JsonProperty("location") final String location,
            @JsonProperty("time") final ZonedDateTime time,
            @JsonProperty("date_created") final ZonedDateTime dateCreated,
            @JsonProperty("date_modified") final ZonedDateTime dateModified,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.time = time;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "TrackingEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", object=" + object +
                '}';
    }

}
