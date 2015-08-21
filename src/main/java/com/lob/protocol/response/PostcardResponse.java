package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.PostcardId;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.Map;

public class PostcardResponse extends AbstractLobResponse {
    @JsonProperty private final PostcardId id;
    @JsonProperty private final String message;
    @JsonProperty private final String url;
    @JsonProperty private final SettingResponse setting;
    @JsonProperty private final AddressResponse to;
    @JsonProperty private final AddressResponse from;
    @JsonProperty private final Money price;
    @JsonProperty private final TrackingResponse tracking;

    @JsonCreator
    public PostcardResponse(
            @JsonProperty("id") final PostcardId id,
            @JsonProperty("message") final String message,
            @JsonProperty("setting") final SettingResponse setting,
            @JsonProperty("to") final AddressResponse to,
            @JsonProperty("from") final AddressResponse from,
            @JsonProperty("price") final Money price,
            @JsonProperty("url") final String url,
            @JsonProperty("tracking") final TrackingResponse tracking,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("description") final String description,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(description, dateCreated, dateModified, metadata, object);
        this.id = id;
        this.message = message;
        this.setting = setting;
        this.to = to;
        this.from = from;
        this.price = price;
        this.url = url;
        this.tracking = tracking;
    }

    public PostcardId getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }

    public TrackingResponse getTracking() {
        return tracking;
    }

    public SettingResponse getSetting() {
        return setting;
    }

    public AddressResponse getTo() {
        return to;
    }

    public AddressResponse getFrom() {
        return from;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PostcardResponse{" +
            "id=" + id +
            ", message='" + message + '\'' +
            ", setting=" + setting +
            ", to=" + to +
            ", from=" + from +
            ", price='" + price + '\'' +
            super.toString();
    }
}
