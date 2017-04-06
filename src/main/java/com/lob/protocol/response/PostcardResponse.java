package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lob.id.PostcardId;
import com.lob.protocol.serializer.DateTimeSerializer;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

import static com.lob.Util.defensiveCopy;

public class PostcardResponse extends AbstractLobResponse {
    @JsonProperty private final PostcardId id;
    @JsonProperty private final String message;
    @JsonProperty private final String size;
    @JsonProperty private final AddressResponse to;
    @JsonProperty private final AddressResponse from;
    @JsonProperty private final Money price;
    @JsonProperty private final String url;
    @JsonProperty private final DateTime expectedDeliveryDate;
    @JsonProperty private final String mailType;
    @JsonProperty private final String sendDate;
    @JsonProperty private final List<ThumbnailResponse> thumbnails;
    @JsonProperty private final String carrier;
    @JsonProperty private final List<TrackingEventResponse> trackingEvents;

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
            @JsonProperty("mail_type") final String mailType,
            @JsonProperty("send_date") final String sendDate,
            @JsonProperty("thumbnails") final List<ThumbnailResponse> thumbnails,
            @JsonProperty("carrier") final String carrier,
            @JsonProperty("tracking_events") final List<TrackingEventResponse> trackingEvents,
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
        this.mailType = mailType;
        this.sendDate = sendDate;
        this.thumbnails = thumbnails;
        this.carrier = carrier;
        this.trackingEvents = trackingEvents;
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

    @JsonSerialize(using=DateTimeSerializer.class)
    public DateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public String getMailType() {
        return mailType;
    }

    public String getSendDate() {
        return sendDate;
    }

    public List<ThumbnailResponse> getThumbnails() {
        return defensiveCopy(this.thumbnails);
    }

    public String getCarrier() {
        return carrier;
    }

    public List<TrackingEventResponse> getTrackingEvents() {
        return defensiveCopy(this.trackingEvents);
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
            ", mailType='" + mailType + '\'' +
            ", sendDate=" + sendDate +
            ", thumbnails='" + thumbnails + '\'' +
            ", carrier='" + carrier + '\'' +
            ", trackingEvents='" + trackingEvents + '\'' +
            super.toString();
    }
}
