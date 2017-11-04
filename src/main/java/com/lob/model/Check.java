package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.RateLimitException;
import com.lob.net.APIResource;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check extends APIResource {

    public static final String RESOURCE = "checks";

    @JsonProperty private final String id;
    @JsonProperty private final String description;
    @JsonProperty private final Address to;
    @JsonProperty private final Address from;
    @JsonProperty private final BankAccount bankAccount;
    @JsonProperty private final int checkNumber;
    @JsonProperty private final String memo;
    @JsonProperty private final float amount;
    @JsonProperty private final String message;
    @JsonProperty private final String url;
    @JsonProperty private final String checkBottomTemplateId;
    @JsonProperty private final String checkBottomTemplateVersionId;
    @JsonProperty private final String attachmentTemplateId;
    @JsonProperty private final String attachmentTemplateVersionId;
    @JsonProperty private final String carrier;
    @JsonProperty private final String trackingNumber;
    @JsonProperty private final List<TrackingEvent> trackingEvents;
    @JsonProperty private final List<Thumbnail> thumbnails;
    @JsonProperty private final String mailType;
    @JsonProperty private final LocalDate expectedDeliveryDate;
    @JsonProperty private final ZonedDateTime dateCreated;
    @JsonProperty private final ZonedDateTime dateModified;
    @JsonProperty private final ZonedDateTime sendDate;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final boolean deleted;
    @JsonProperty private final String object;

    @JsonCreator
    public Check(
            @JsonProperty("id") final String id,
            @JsonProperty("description") final String description,
            @JsonProperty("to") final Address to,
            @JsonProperty("from") final Address from,
            @JsonProperty("bank_account") final BankAccount bankAccount,
            @JsonProperty("check_number") final int checkNumber,
            @JsonProperty("memo") final String memo,
            @JsonProperty("amount") final float amount,
            @JsonProperty("message") final String message,
            @JsonProperty("url") final String url,
            @JsonProperty("check_bottom_template_id") final String checkBottomTemplateId,
            @JsonProperty("check_bottom_template_version_id") final String checkBottomTemplateVersionId,
            @JsonProperty("attachment_template_id") final String attachmentTemplateId,
            @JsonProperty("attachment_template_version_id") final String attachmentTemplateVersionId,
            @JsonProperty("carrier") final String carrier,
            @JsonProperty("tracking_number") final String trackingNumber,
            @JsonProperty("tracking_events") final List<TrackingEvent> trackingEvents,
            @JsonProperty("thumbnails") final List<Thumbnail> thumbnails,
            @JsonProperty("mail_type") final String mailType,
            @JsonProperty("expected_delivery_date") final LocalDate expectedDeliveryDate,
            @JsonProperty("date_created") final ZonedDateTime dateCreated,
            @JsonProperty("date_modified") final ZonedDateTime dateModified,
            @JsonProperty("send_date") final ZonedDateTime sendDate,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.description = description;
        this.to = to;
        this.from = from;
        this.bankAccount = bankAccount;
        this.checkNumber = checkNumber;
        this.memo = memo;
        this.amount = amount;
        this.message = message;
        this.url = url;
        this.checkBottomTemplateId = checkBottomTemplateId;
        this.checkBottomTemplateVersionId = checkBottomTemplateVersionId;
        this.attachmentTemplateId = attachmentTemplateId;
        this.attachmentTemplateVersionId = attachmentTemplateVersionId;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.trackingEvents = trackingEvents;
        this.thumbnails = thumbnails;
        this.mailType = mailType;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.sendDate = sendDate;
        this.metadata = metadata;
        this.deleted = deleted;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Address getTo() {
        return to;
    }

    public Address getFrom() {
        return from;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public String getMemo() {
        return memo;
    }

    public float getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }

    public String getCheckBottomTemplateId() {
        return checkBottomTemplateId;
    }

    public String getCheckBottomTemplateVersionId() {
        return checkBottomTemplateVersionId;
    }

    public String getAttachmentTemplateId() {
        return attachmentTemplateId;
    }

    public String getAttachmentTemplateVersionId() {
        return attachmentTemplateVersionId;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public List<TrackingEvent> getTrackingEvents() {
        return trackingEvents;
    }

    public List<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public String getMailType() {
        return mailType;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }

    public ZonedDateTime getSendDate() {
        return sendDate;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", to=" + to +
                ", from=" + from +
                ", bankAccount=" + bankAccount +
                ", checkNumber=" + checkNumber +
                ", memo='" + memo + '\'' +
                ", amount=" + amount +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", checkBottomTemplateId='" + checkBottomTemplateId + '\'' +
                ", checkBottomVersionId='" + checkBottomTemplateVersionId + '\'' +
                ", attachmentTemplateId='" + attachmentTemplateId + '\'' +
                ", attachmentTemplateVersionId='" + attachmentTemplateVersionId + '\'' +
                ", carrier='" + carrier + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", trackingEvents=" + trackingEvents +
                ", thumbnails=" + thumbnails +
                ", mailType='" + mailType + '\'' +
                ", expectedDeliveryDate=" + expectedDeliveryDate +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", sendDate=" + sendDate +
                ", metadata=" + metadata +
                ", deleted=" + deleted +
                ", object='" + object + '\'' +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();
        private boolean isMultipart = false;

        public RequestBuilder() {
        }

        public RequestBuilder setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public RequestBuilder setTo(String to) {
            params.put("to", to);
            return this;
        }

        public RequestBuilder setTo(Address.RequestBuilder to) {
            params.put("to", to.build());
            return this;
        }

        public RequestBuilder setFrom(String from) {
            params.put("from", from);
            return this;
        }

        public RequestBuilder setFrom(Address.RequestBuilder from) {
            params.put("from", from.build());
            return this;
        }

        public RequestBuilder setBankAccount(String bankAccount) {
            params.put("bank_account", bankAccount);
            return this;
        }

        public RequestBuilder setMemo(String memo) {
            params.put("memo", memo);
            return this;
        }

        public RequestBuilder setCheckNumber(int checkNumber) {
            params.put("check_number", checkNumber);
            return this;
        }

        public RequestBuilder setAmount(float amount) {
            params.put("amount", amount);
            return this;
        }

        public RequestBuilder setMessage(String message) {
            params.put("message", message);
            return this;
        }

        public RequestBuilder setLogo(String logo) {
            params.put("logo", logo);
            return this;
        }

        public RequestBuilder setLogo(File logo) {
            isMultipart = true;
            params.put("logo", logo);
            return this;
        }

        public RequestBuilder setCheckBottom(String checkBottom) {
            params.put("check_bottom", checkBottom);
            return this;
        }

        public RequestBuilder setCheckBottom(File checkBottom) {
            isMultipart = true;
            params.put("check_bottom", checkBottom);
            return this;
        }

        public RequestBuilder setAttachment(String attachment) {
            params.put("attachment", attachment);
            return this;
        }

        public RequestBuilder setAttachment(File attachment) {
            isMultipart = true;
            params.put("attachment", attachment);
            return this;
        }

        public RequestBuilder setMailType(String mailType) {
            params.put("mail_type", mailType);
            return this;
        }

        public RequestBuilder setSendDate(String sendDate) {
            params.put("send_date", sendDate);
            return this;
        }

        public RequestBuilder setSendDate(ZonedDateTime sendDate) {
            params.put("send_date", sendDate);
            return this;
        }


        public RequestBuilder setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }

        public RequestBuilder setMergeVariables(Map<String, String> mergeVariables) {
            params.put("merge_variables", mergeVariables);
            return this;
        }

        public RequestBuilder setSize(String size) {
            params.put("size", size);
            return this;
        }

        public LobResponse<Check> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public LobResponse<Check> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            if (isMultipart) {
                return request(RequestMethod.POST, RequestType.MULTIPART, RESOURCE, params, Check.class, options);
            }

            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, Check.class, options);
        }
    }

    public static LobResponse<Check> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static LobResponse<Check> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Check.class, options);
    }

    public static LobResponse<CheckCollection> list() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static LobResponse<CheckCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static LobResponse<CheckCollection> list(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static LobResponse<CheckCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, CheckCollection.class, options);
    }

    public static LobResponse<Check> delete(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return delete(id, null);
    }

    public static LobResponse<Check> delete(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.DELETE, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Check.class, options);
    }

}
