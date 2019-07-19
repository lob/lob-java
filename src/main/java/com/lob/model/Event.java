package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lob.net.APIResource;

import java.time.ZonedDateTime;

public class Event {

    @JsonProperty private final String id;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "object")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = Postcard.class, name = "postcard"),
        @JsonSubTypes.Type(value = Letter.class, name = "letter"),
        @JsonSubTypes.Type(value = Check.class, name = "check"),
        @JsonSubTypes.Type(value = Address.class, name = "address"),
        @JsonSubTypes.Type(value = BankAccount.class, name = "bank_account")
    })

    @JsonProperty private final APIResource body;
    @JsonProperty private final String referenceId;
    @JsonProperty private final EventType eventType;
    @JsonProperty private final ZonedDateTime dateCreated;
    @JsonProperty private final String object;

    @JsonCreator
    public Event(
            @JsonProperty("id") final String id,
            @JsonProperty("body") final APIResource body,
            @JsonProperty("reference_id") final String referenceId,
            @JsonProperty("event_type") final EventType eventType,
            @JsonProperty("date_created") final ZonedDateTime dateCreated,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.body = body;
        this.referenceId = referenceId;
        this.eventType = eventType;
        this.dateCreated = dateCreated;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public APIResource getBody() {
        return body;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                ", referenceId='" + referenceId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", object='" + object + '\'' +
                '}';
    }
}
