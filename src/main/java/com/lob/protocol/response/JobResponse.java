package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.JobId;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

import static com.lob.Util.defensiveCopy;

public class JobResponse extends AbstractLobResponse {
    @JsonProperty("id") private final JobId id;
    @JsonProperty("price") private final String price;
    @JsonProperty("to") private final AddressResponse to;
    @JsonProperty("from") private final AddressResponse from;
    @JsonProperty("tracking") private final TrackingResponse tracking;
    @JsonProperty("service") private final ServiceResponse service;
    @JsonProperty("objects") private final List<LobObjectResponse> objects;

    @JsonCreator
    public JobResponse(
            @JsonProperty("id") final JobId id,
            @JsonProperty("price") final String price,
            @JsonProperty("to") final AddressResponse to,
            @JsonProperty("from") final AddressResponse from,
            @JsonProperty("tracking") final TrackingResponse tracking,
            @JsonProperty("service") final ServiceResponse service,
            @JsonProperty("objects") final List<LobObjectResponse> objects,
            @JsonProperty("description") final String description,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(description, dateCreated, dateModified, metadata, object);
        this.id = id;
        this.price = price;
        this.to = to;
        this.from = from;
        this.tracking = tracking;
        this.service = service;
        this.objects = objects;
    }

    public JobId getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public AddressResponse getTo() {
        return to;
    }

    public AddressResponse getFrom() {
        return from;
    }

    public TrackingResponse getTracking() {
        return tracking;
    }

    public ServiceResponse getService() {
        return service;
    }

    public List<LobObjectResponse> getObjects() {
        return defensiveCopy(objects);
    }

    @Override
    public String toString() {
        return "JobResponse{" +
            "id=" + id +
            ", price='" + price + '\'' +
            ", to=" + to +
            ", from=" + from +
            ", tracking='" + tracking + '\'' +
            ", service=" + service +
            ", objects=" + objects +
            super.toString();
    }
}
