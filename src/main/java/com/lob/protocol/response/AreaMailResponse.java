package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.AreaMailId;
import com.lob.protocol.request.TargetType;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.Collection;
import java.util.Map;

public class AreaMailResponse extends AbstractLobResponse {
    @JsonProperty private final AreaMailId id;
    @JsonProperty private final String status;
    @JsonProperty private final Money price;
    @JsonProperty private final String url;
    @JsonProperty private final TargetType targetType;
    @JsonProperty private final int numAddresses;
    @JsonProperty private final Collection<ZipCodeRouteResponse> zipCodeRouteResponses;
    @JsonProperty private final Collection<ThumbnailResponse> thumbnails;
    @JsonProperty private final DateTime expectedDeliveryDate;

    @JsonCreator
    public AreaMailResponse(
            @JsonProperty("id") final AreaMailId id,
            @JsonProperty("status") final String status,
            @JsonProperty("price") final Money price,
            @JsonProperty("url") final String url,
            @JsonProperty("target_type") final TargetType targetType,
            @JsonProperty("addresses") final int numAddresses,
            @JsonProperty("zip_codes") final Collection<ZipCodeRouteResponse> zipCodeRouteResponses,
            @JsonProperty("thumbnails") final Collection<ThumbnailResponse> thumbnails,
            @JsonProperty("expected_delivery_date") final DateTime expectedDeliveryDate,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(dateCreated, dateModified, metadata, object);
        this.id = id;
        this.status = status;
        this.price = price;
        this.url = url;
        this.targetType = targetType;
        this.numAddresses = numAddresses;
        this.zipCodeRouteResponses = zipCodeRouteResponses;
        this.thumbnails = thumbnails;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public AreaMailId getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Money getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public int getNumAddresses() {
        return numAddresses;
    }

    public Collection<ZipCodeRouteResponse> getZipCodeRouteResponses() {
        return zipCodeRouteResponses;
    }

    public Collection<ThumbnailResponse> getThumbnails() {
        return thumbnails;
    }

    public DateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    @Override
    public String toString() {
        return "AreaMailResponse{" +
            "id=" + id +
            ", status='" + status + '\'' +
            ", price=" + price +
            ", url='" + url + '\'' +
            ", targetType=" + targetType +
            ", numAddresses=" + numAddresses +
            ", zipCodeRouteCollections=" + zipCodeRouteResponses +
            ", thumbnails=" + thumbnails +
            ", expectedDeliveryDate=" + expectedDeliveryDate +
            super.toString();
    }
}
