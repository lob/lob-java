package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.RateLimitException;
import com.lob.net.APIResource;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Area extends APIResource {

    public static final String RESOURCE = "areas";

    public static class Tracking {

        @JsonProperty private final String id;
        @JsonProperty private final String tracking_number;
        @JsonProperty private final String carrier;
        @JsonProperty private final List<TrackingEvent> events;
        @JsonProperty private final String object;

        @JsonCreator
        public Tracking(
                @JsonProperty("id") final String id,
                @JsonProperty("tracking_number") final String tracking_number,
                @JsonProperty("carrier") final String carrier,
                @JsonProperty("events") final List<TrackingEvent> events,
                @JsonProperty("object") final String object) {
            this.id = id;
            this.tracking_number = tracking_number;
            this.carrier = carrier;
            this.events = events;
            this.object = object;
        }

        public String getId() {
            return id;
        }

        public String getTracking_number() {
            return tracking_number;
        }

        public String getCarrier() {
            return carrier;
        }

        public List<TrackingEvent> getEvents() {
            return events;
        }

        public String getObject() {
            return object;
        }

    }

    @JsonProperty private final String id;
    @JsonProperty private final String description;
    @JsonProperty private final String price;
    @JsonProperty private final String url;
    @JsonProperty private final String targetType;
    @JsonProperty private final int addresses;
    @JsonProperty private final List<Routes> zipCodes;
    @JsonProperty private final List<Thumbnail> thumbnails;
    @JsonProperty private final List<Tracking> trackings;
    @JsonProperty private final String expectedDeliveryDate;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final String dateCreated;
    @JsonProperty private final String dateModified;
    @JsonProperty private final boolean deleted;
    @JsonProperty private final String object;

    @JsonCreator
    public Area(@JsonProperty("id") final String id,
                @JsonProperty("description") final String description,
                @JsonProperty("price") final String price,
                @JsonProperty("url") final String url,
                @JsonProperty("addresses") final int addresses,
                @JsonProperty("target_type") final String targetType,
                @JsonProperty("zip_codes") final List<Routes> zipCodes,
                @JsonProperty("thumbnails") final List<Thumbnail> thumbnails,
                @JsonProperty("trackings") final List<Tracking> trackings,
                @JsonProperty("expected_delivery_date") final String expectedDeliveryDate,
                @JsonProperty("metadata") final Map<String, String> metadata,
                @JsonProperty("date_created") final String dateCreated,
                @JsonProperty("date_modified") final String dateModified,
                @JsonProperty("deleted") final boolean deleted,
                @JsonProperty("object") final String object) {
        this.id = id;
        this.description = description;
        this.metadata = metadata;
        this.zipCodes = zipCodes;
        this.addresses = addresses;
        this.price = price;
        this.url = url;
        this.targetType = targetType;
        this.thumbnails = thumbnails;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.trackings = trackings;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.deleted = deleted;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public String getTargetType() {
        return targetType;
    }

    public int getAddresses() {
        return addresses;
    }

    public List<Routes> getZipCodes() {
        return zipCodes;
    }

    public List<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public List<Tracking> getTrackings() {
        return trackings;
    }

    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", zipCodes='" + zipCodes + '\'' +
                ", addresses='" + addresses + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                ", targetType='" + targetType + '\'' +
                ", thumbnails='" + thumbnails + '\'' +
                ", expectedDeliveryDate='" + expectedDeliveryDate + '\'' +
                ", trackings='" + trackings + '\'' +
                ", thumbnails='" + thumbnails + '\'' +
                ", expectedDeliveryDate='" + expectedDeliveryDate + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", dateModified='" + dateModified + '\'' +
                ", metadata='" + metadata + '\'' +
                ", object='" + object + '\'' +
                '}';
    }


    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();
        private boolean isMultipart = false;

        public RequestBuilder() {
        }

        public RequestBuilder setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public RequestBuilder setRoutes(String routes) {
            params.put("routes", routes);
            return this;
        }

        public RequestBuilder setRoutes(List<String> routes) {
            params.put("routes", routes);
            return this;
        }

        public RequestBuilder setTargetType(String targeType) {
            params.put("target_type", targeType);
            return this;
        }

        public RequestBuilder setFront(String front) {
            params.put("front", front);
            return this;
        }

        public RequestBuilder setFront(File front) {
            isMultipart = true;
            params.put("front", front);
            return this;
        }

        public RequestBuilder setBack(String back) {
            params.put("back", back);
            return this;
        }

        public RequestBuilder setBack(File back) {
            isMultipart = true;
            params.put("back", back);
            return this;
        }

        public RequestBuilder setMergeVariables(Map<String, String> mergeVariables) {
            params.put("merge_variables", mergeVariables);
            return this;
        }

        public RequestBuilder setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }

        public LobResponse<Area> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public LobResponse<Area> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            if (isMultipart) {
                return request(RequestMethod.POST, RequestType.MULTIPART, RESOURCE, params, Area.class, options);
            }

            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, Area.class, options);
        }
    }

    public static LobResponse<Area> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static LobResponse<Area> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Area.class, options);
    }

    public static LobResponse<AreaCollection> list() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static LobResponse<AreaCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static LobResponse<AreaCollection> list(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static LobResponse<AreaCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, AreaCollection.class, options);
    }
}
