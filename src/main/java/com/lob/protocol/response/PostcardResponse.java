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
    @JsonProperty private final String status;
    @JsonProperty private final SettingResponse setting;
    @JsonProperty private final AddressResponse to;
    @JsonProperty private final AddressResponse from;
    @JsonProperty private final Money price;

    @JsonCreator
    public PostcardResponse(
            @JsonProperty("id") final PostcardId id,
            @JsonProperty("message") final String message,
            @JsonProperty("status") final String status,
            @JsonProperty("setting") final SettingResponse setting,
            @JsonProperty("to") final AddressResponse to,
            @JsonProperty("from") final AddressResponse from,
            @JsonProperty("price") final Money price,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(dateCreated, dateModified, metadata, object);
        this.id = id;
        this.message = message;
        this.status = status;
        this.setting = setting;
        this.to = to;
        this.from = from;
        this.price = price;
    }

    public PostcardId getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
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
            ", status='" + status + '\'' +
            ", setting=" + setting +
            ", to=" + to +
            ", from=" + from +
            ", price='" + price + '\'' +
            super.toString();
    }
}
