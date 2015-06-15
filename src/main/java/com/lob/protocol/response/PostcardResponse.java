package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.PostcardId;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.Map;

public class PostcardResponse extends AbstractLobResponse {
    @JsonProperty private final PostcardId id;
    @JsonProperty private final String name;
    @JsonProperty private final String message;
    @JsonProperty private final String status;
    @JsonProperty private final SettingResponse setting;
    @JsonProperty private final AddressResponse to;
    @JsonProperty private final AddressResponse from;
    @JsonProperty private final Money price;
    @JsonProperty private final boolean fullBleed;
    @JsonProperty private final boolean template;

    @JsonCreator
    public PostcardResponse(
            @JsonProperty("id") final PostcardId id,
            @JsonProperty("name") final String name,
            @JsonProperty("message") final String message,
            @JsonProperty("status") final String status,
            @JsonProperty("setting") final SettingResponse setting,
            @JsonProperty("to") final AddressResponse to,
            @JsonProperty("from") final AddressResponse from,
            @JsonProperty("price") final Money price,
            @JsonProperty("full_bleed") final boolean fullBleed,
            @JsonProperty("template") final boolean template,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(dateCreated, dateModified, metadata, object);
        this.id = id;
        this.name = name;
        this.message = message;
        this.status = status;
        this.setting = setting;
        this.to = to;
        this.from = from;
        this.price = price;
        this.fullBleed = fullBleed;
        this.template = template;
    }

    public PostcardId getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public boolean isFullBleed() {
        return fullBleed;
    }

    public boolean isTemplate() {
        return template;
    }

    @Override
    public String toString() {
        return "PostcardResponse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", message='" + message + '\'' +
            ", status='" + status + '\'' +
            ", setting=" + setting +
            ", to=" + to +
            ", from=" + from +
            ", price='" + price + '\'' +
            ", fullBleed=" + fullBleed +
            ", template=" + template +
            super.toString();
    }
}
