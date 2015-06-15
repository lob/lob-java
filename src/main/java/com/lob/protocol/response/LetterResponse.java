package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.LetterId;
import com.lob.protocol.request.LetterRequest;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.Map;

public class LetterResponse extends AbstractLobResponse {
    @JsonProperty private final LetterId id;
    @JsonProperty private final String description;
    @JsonProperty private final AddressResponse to;
    @JsonProperty private final AddressResponse from;
    @JsonProperty private final boolean color;
    @JsonProperty private final boolean doubleSided;
    @JsonProperty private final int pages;
    @JsonProperty private final boolean template;
    @JsonProperty private final Money price;
    @JsonProperty private final String status;
    @JsonProperty private final String url;
    @JsonProperty private final DateTime expectedDeliveryDate;

    @JsonCreator
    public LetterResponse(
            @JsonProperty("id") final LetterId id,
            @JsonProperty("description") final String description,
            @JsonProperty("to") final AddressResponse to,
            @JsonProperty("from") final AddressResponse from,
            @JsonProperty("color") final boolean color,
            @JsonProperty("double_sided") final boolean doubleSided,
            @JsonProperty("pages") final int pages,
            @JsonProperty("template") final boolean template,
            @JsonProperty("price") final Money price,
            @JsonProperty("status") final String status,
            @JsonProperty("url") final String url,
            @JsonProperty("expected_delivery_date") final DateTime expectedDeliveryDate,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(dateCreated, dateModified, metadata, object);
        this.id = id;
        this.description = description;
        this.to = to;
        this.from = from;
        this.color = color;
        this.doubleSided = doubleSided;
        this.pages = pages;
        this.template = template;
        this.price = price;
        this.status = status;
        this.url = url;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public LetterId getId() { return id; }

    public String getDescription() { return description; }

    public AddressResponse getTo() { return to; }

    public AddressResponse getFrom() { return from; }

    public boolean isColor() { return color; }

    public boolean isDoubleSided() { return doubleSided; }

    public int getPages() { return pages; }

    public boolean isTemplate() { return template; }

    public Money getPrice() { return price; }

    public String getStatus() { return status; }

    public String getUrl() { return url; }

    public DateTime getExpectedDeliveryDate() { return expectedDeliveryDate; }

    @Override
    public String toString() {
        return "LetterResponse{" +
                "id=" + id +
                ", description='" + description + "'" +
                ", to=" + to +
                ", from=" + from +
                ", color=" + color +
                ", doubleSided=" + doubleSided +
                ", pages=" + pages +
                ", template=" + template +
                ", price='" + price + "'" +
                ", status='" + status + "'" +
                ", url='" + url + "'" +
                ", expectedDeliveryDate='" + expectedDeliveryDate + "'" +
                super.toString();

    }
}
