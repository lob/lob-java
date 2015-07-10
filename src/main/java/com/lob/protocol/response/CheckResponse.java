package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.CheckId;
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
    @JsonProperty private final BankAccountResponse bankAccount;
    @JsonProperty private final String status;
    @JsonProperty private final String message;
    @JsonProperty private final Money price;
    @JsonProperty private final String url;
    @JsonProperty private final TrackingResponse tracking;
    @JsonProperty private final DateTime expectedDeliveryDate;
    @JsonProperty private final List<ThumbnailResponse> thumbnails;

    @JsonCreator
    public CheckResponse(
            @JsonProperty("id") final CheckId id,
            @JsonProperty("check_number") final int checkNumber,
            @JsonProperty("memo") final String memo,
            @JsonProperty("amount") final Money amount,
            @JsonProperty("to") final AddressResponse to,
            @JsonProperty("bank_account") final BankAccountResponse bankAccount,
            @JsonProperty("status") final String status,
            @JsonProperty("message") final String message,
            @JsonProperty("price") final Money price,
            @JsonProperty("url") final String url,
            @JsonProperty("tracking") final TrackingResponse tracking,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("expected_delivery_date") final DateTime expectedDeliveryDate,
            @JsonProperty("thumbnails") final List<ThumbnailResponse> thumbnails,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(dateCreated, dateModified, metadata, object);
        this.id = id;
        this.checkNumber = checkNumber;
        this.memo = memo;
        this.amount = amount;
        this.to = to;
        this.bankAccount = bankAccount;
        this.status = status;
        this.message = message;
        this.price = price;
        this.url = url;
        this.tracking = tracking;
        this.expectedDeliveryDate = expectedDeliveryDate;
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

    public Money getAmount() {
        return amount;
    }

    public AddressResponse getTo() {
        return to;
    }

    public BankAccountResponse getBankAccount() {
        return bankAccount;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Money getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public TrackingResponse getTracking() {
        return tracking;
    }

    public DateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
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
            ", bankAccount=" + bankAccount +
            ", status='" + status + '\'' +
            ", message='" + message + '\'' +
            ", price=" + price +
            ", url='" + url + '\'' +
            ", tracking=" + tracking +
            ", expectedDeliveryDate=" + expectedDeliveryDate +
            ", thumbnails=" + thumbnails +
            super.toString();
    }
}
