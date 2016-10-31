package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.LetterId;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

import static com.lob.Util.defensiveCopy;

public class LetterResponse extends AbstractLobResponse {
    @JsonProperty private final LetterId id;
    @JsonProperty private final AddressResponse to;
    @JsonProperty private final AddressResponse from;
    @JsonProperty private final boolean color;
    @JsonProperty private final boolean doubleSided;
    @JsonProperty private final int pages;
    @JsonProperty private final String addressPlacement;
    @JsonProperty private final String extraService;
    @JsonProperty private final boolean returnEnvelope;
    @JsonProperty private final Integer perforatedPage;
    @JsonProperty private final Money price;
    @JsonProperty private final String url;
    @JsonProperty private final DateTime expectedDeliveryDate;
    @JsonProperty private final String mailType;
    @JsonProperty private final List<ThumbnailResponse> thumbnails;
    @JsonProperty private final String carrier;
    @JsonProperty private final String trackingNumber;
    @JsonProperty private final List<TrackingEventResponse> trackingEvents;

    @JsonCreator
    public LetterResponse(
            @JsonProperty("id") final LetterId id,
            @JsonProperty("to") final AddressResponse to,
            @JsonProperty("from") final AddressResponse from,
            @JsonProperty("color") final boolean color,
            @JsonProperty("double_sided") final boolean doubleSided,
            @JsonProperty("pages") final int pages,
            @JsonProperty("address_placement") final String addressPlacement,
            @JsonProperty("extra_service") final String extraService,
            @JsonProperty("return_envelope") final boolean returnEnvelope,
            @JsonProperty("perforated_page") final Integer perforatedPage,
            @JsonProperty("price") final Money price,
            @JsonProperty("url") final String url,
            @JsonProperty("expected_delivery_date") final DateTime expectedDeliveryDate,
            @JsonProperty("mail_type") final String mailType,
            @JsonProperty("thumbnails") final List<ThumbnailResponse> thumbnails,
            @JsonProperty("carrier") final String carrier,
            @JsonProperty("tracking_number") final String trackingNumber,
            @JsonProperty("tracking_events") final List<TrackingEventResponse> trackingEvents,
            @JsonProperty("description") final String description,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(description, dateCreated, dateModified, metadata, object);
        this.id = id;
        this.to = to;
        this.from = from;
        this.color = color;
        this.doubleSided = doubleSided;
        this.pages = pages;
        this.addressPlacement = addressPlacement;
        this.extraService = extraService;
        this.returnEnvelope = returnEnvelope;
        this.perforatedPage = perforatedPage;
        this.price = price;
        this.url = url;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.mailType = mailType;
        this.thumbnails = thumbnails;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.trackingEvents = trackingEvents;
    }

    public LetterId getId() { return id; }

    public AddressResponse getTo() { return to; }

    public AddressResponse getFrom() { return from; }

    public boolean isColor() { return color; }

    public boolean isDoubleSided() { return doubleSided; }

    @Deprecated
    public int getPages() { return pages; }

    public String getAddressPlacement() { return addressPlacement; }

    public String getExtraService() { return extraService; }

    public boolean isReturnEnvelope() { return returnEnvelope; }

    public Integer getPerforatedPage() { return perforatedPage; }

    @Deprecated
    public Money getPrice() { return price; }

    public String getUrl() { return url; }

    public DateTime getExpectedDeliveryDate() { return expectedDeliveryDate; }

    public String getMailType() { return mailType; }

    public List<ThumbnailResponse> getThumbnails() { return defensiveCopy(this.thumbnails); }

    public String getCarrier() { return carrier; }

    public String getTrackingNumber() { return trackingNumber; }

    public List<TrackingEventResponse> getTrackingEvents() { return defensiveCopy(this.trackingEvents); }

    @Override
    public String toString() {
        return "LetterResponse{" +
                "id=" + id +
                ", to=" + to +
                ", from=" + from +
                ", color=" + color +
                ", doubleSided=" + doubleSided +
                ", pages=" + pages +
                ", addressPlacement=" + addressPlacement +
                ", extraService=" + extraService +
                ", returnEnvelope=" + returnEnvelope +
                ", perforatedPage=" + perforatedPage +
                ", price='" + price + "'" +
                ", url='" + url + "'" +
                ", expectedDeliveryDate='" + expectedDeliveryDate + "'" +
                ", mailType='" + mailType + "'" +
                ", thumbnails='" + thumbnails + "'" +
                ", carrier='" + carrier + "'" +
                ", trackingNumber='" + trackingNumber + "'" +
                ", trackingEvents='" + trackingEvents + "'" +
                super.toString();

    }
}
