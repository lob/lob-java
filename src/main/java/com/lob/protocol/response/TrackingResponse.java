package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.TrackingId;

import java.util.List;

public class TrackingResponse {
    @JsonProperty("id") private final TrackingId id;
    @JsonProperty("tracking_number") private final String trackingNumber;
	@JsonProperty("carrier") private final String carrier;
	@JsonProperty("events") private final List<TrackingEventResponse> events;
	@JsonProperty("object") private final String object;

    @JsonCreator
    public TrackingResponse(
        @JsonProperty("id") final TrackingId id,
        @JsonProperty("tracking_number") final String trackingNumber,
        @JsonProperty("carrier") final String carrier,
        @JsonProperty("events") final List<TrackingEventResponse> events,
        @JsonProperty("object") final String object) {
            this.id = id;
            this.trackingNumber = trackingNumber;
            this.carrier = carrier;
            this.events = events;
            this.object = object;
    }

    public TrackingId getId() {
        return id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public List<TrackingEventResponse> getEvents() {
        return events;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "TrackingResponse{" +
            "id='" + id + '\'' +
            ", trackingNumber='" + trackingNumber + '\'' +
            ", carrier='" + carrier + '\'' +
            ", events=" + events +
            ", object='" + object + '\'' +
            '}';
    }
}