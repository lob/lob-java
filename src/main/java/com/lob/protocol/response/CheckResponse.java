package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lob.id.CheckId;
import com.lob.protocol.serializer.DateTimeSerializer;
import com.lob.protocol.serializer.MoneySerializer;
import org.joda.money.Money;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

import static com.lob.Util.defensiveCopy;

public class CheckResponse extends AbstractLobResponse {
    @JsonProperty private final CheckId id;
    @JsonProperty private final int checkNumber;
    @JsonProperty private final String memo;
    @JsonProperty private final Money amount;
    @JsonProperty private final AddressResponse to;
    @JsonProperty private final AddressResponse from;
    @JsonProperty private final BankAccountResponse bankAccount;
    @JsonProperty private final String message;
    @JsonProperty private final String url;
    @JsonProperty private final String carrier;
    @JsonProperty private final String trackingNumber;
    @JsonProperty private final List<TrackingEventResponse> trackingEvents;
    @JsonProperty private final DateTime expectedDeliveryDate;
    @JsonProperty private final String mailType;
    @JsonProperty private final List<ThumbnailResponse> thumbnails;

    @JsonCreator
    public CheckResponse(
            @JsonProperty("id") final CheckId id,
            @JsonProperty("check_number") final int checkNumber,
            @JsonProperty("memo") final String memo,
            @JsonProperty("amount") final Money amount,
            @JsonProperty("to") final AddressResponse to,
            @JsonProperty("from") final AddressResponse from,
            @JsonProperty("bank_account") final BankAccountResponse bankAccount,
            @JsonProperty("message") final String message,
            @JsonProperty("url") final String url,
            @JsonProperty("carrier") final String carrier,
            @JsonProperty("tracking_number") final String trackingNumber,
            @JsonProperty("tracking_events") final List<TrackingEventResponse> trackingEvents,
            @JsonProperty("description") final String description,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("expected_delivery_date") final DateTime expectedDeliveryDate,
            @JsonProperty("mail_type") final String mailType,
            @JsonProperty("thumbnails") final List<ThumbnailResponse> thumbnails,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(description, dateCreated, dateModified, metadata, object);
        this.id = id;
        this.checkNumber = checkNumber;
        this.memo = memo;
        this.amount = amount;
        this.to = to;
        this.from = from;
        this.bankAccount = bankAccount;
        this.message = message;
        this.url = url;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.trackingEvents = trackingEvents;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.mailType = mailType;
        this.thumbnails = thumbnails;
    }

    public CheckId getId() {
        return id;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public String getMemo() {
        return memo;
    }

    @JsonSerialize(using=MoneySerializer.class)
    public Money getAmount() {
        return amount;
    }

    public AddressResponse getTo() {
        return to;
    }

    public AddressResponse getFrom() {
        return from;
    }

    public BankAccountResponse getBankAccount() {
        return bankAccount;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public List<TrackingEventResponse> getTrackingEvents() {
        return defensiveCopy(this.trackingEvents);
    }

    @JsonSerialize(using=DateTimeSerializer.class)
    public DateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public String getMailType() {
        return mailType;
    }

    public List<ThumbnailResponse> getThumbnails() {
        return defensiveCopy(this.thumbnails);
    }

    @Override
    public String toString() {
        return "CheckResponse{" +
            "id=" + id +
            ", checkNumber=" + checkNumber +
            ", memo='" + memo + '\'' +
            ", amount=" + amount +
            ", to=" + to +
            ", from=" + from +
            ", bankAccount=" + bankAccount +
            ", message='" + message + '\'' +
            ", url='" + url + '\'' +
            ", carrier='" + carrier + '\'' +
            ", trackingNumber='" + trackingNumber + '\'' +
            ", trackingEvents='" + trackingEvents + '\'' +
            ", expectedDeliveryDate=" + expectedDeliveryDate +
            ", mailType=" + mailType +
            ", thumbnails=" + thumbnails +
            super.toString();
    }
}
