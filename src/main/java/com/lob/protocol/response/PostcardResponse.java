package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.PostcardId;
import com.lob.id.StringId;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

public class PostcardResponse extends AbstractLobResponse {
    @JsonProperty private final PostcardId id;
    @JsonProperty private final String message;
    @JsonProperty private final String size;
    @JsonProperty private final AddressResponse to;
    @JsonProperty private final AddressResponse from;
    @JsonProperty private final Money price;
    @JsonProperty private final String url;
    @JsonProperty private final DateTime expectedDeliveryDate;
    @JsonProperty private final List<ThumbnailResponse> thumbnails;
    @JsonProperty private final TrackingResponse tracking;

    @JsonCreator
    public PostcardResponse(
            @JsonProperty("id") final PostcardId id,
            @JsonProperty("message") final String message,
            @JsonProperty("size") final String size,
            @JsonProperty("to") final AddressResponse to,
            @JsonProperty("from") final AddressResponse from,
            @JsonProperty("price") final Money price,
            @JsonProperty("url") final String url,
            @JsonProperty("expected_delivery_date") final DateTime expectedDeliveryDate,
            @JsonProperty("thumbnails") final List<ThumbnailResponse> thumbnails,
            @JsonProperty("tracking") final TrackingResponse tracking,
            @JsonProperty("description") final String description,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(description, dateCreated, dateModified, metadata, object);
        this.id = id;
        this.message = message;
        this.size = size;
        this.to = to;
        this.from = from;
        this.price = price;
        this.url = url;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.thumbnails = thumbnails;
        this.tracking = tracking;
    }

    public PostcardId getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getSize() {
        return size;
    }

    public AddressResponse getTo() {
        return to;
    }

    public AddressResponse getFrom() {
        return from;
    }

    @Deprecated
    public Money getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public DateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public List<ThumbnailResponse> getThumbnails() {
        return thumbnails;
    }

    public TrackingResponse getTracking() {
        return tracking;
    }

    @Override
    public String toString() {
        return "PostcardResponse{" +
            "id=" + id +
            ", message='" + message + '\'' +
            ", size=" + size +
            ", to=" + to +
            ", from=" + from +
            ", price='" + price + '\'' +
            ", url='" + url + '\'' +
            ", expectedDeliveryDate='" + expectedDeliveryDate + '\'' +
            ", thumbnails='" + thumbnails + '\'' +
            ", tracking='" + tracking + '\'' +
            super.toString();
    }
}
