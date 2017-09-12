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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;

public class Check extends APIResource {

    public static final String ENDPOINT = "checks";

    @JsonProperty private final String id;
    @JsonProperty private final String description;
    @JsonProperty private final Address to;
    @JsonProperty private final Address from;
    @JsonProperty private final BankAccount bankAccount;
    @JsonProperty private final int checkNumber;
    @JsonProperty private final String message;
    @JsonProperty private final String memo;
    @JsonProperty private final float amount;
    @JsonProperty private final String url;
    @JsonProperty private final String checkBottomTemplateId;
    @JsonProperty private final String attachmentTemplateId;
    @JsonProperty private final String checkBottomVersionId;
    @JsonProperty private final String attachmentTemplateVersionId;
    @JsonProperty private final String carrier;
    @JsonProperty private final List<TrackingEvent> trackingEvents;
    @JsonProperty private final List<Thumbnail> thumbnails;
    @JsonProperty private final String size;
    @JsonProperty private final String mailType;
    @JsonProperty private final DateTime expectedDeliveryDate;
    @JsonProperty private final DateTime dateCreated;
    @JsonProperty private final DateTime dateModified;
    @JsonProperty private final String trackingNumber;
    @JsonProperty private final DateTime sendDate;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final boolean deleted;
    @JsonProperty private final String object;

    @JsonCreator
    public Check(
            @JsonProperty("id") final String id,
            @JsonProperty("description") final String description,
            @JsonProperty("bank_account") final BankAccount bankAccount,
            @JsonProperty("to") final Address to,
            @JsonProperty("from") final Address from,
            @JsonProperty("check_number") final int checkNumber,
            @JsonProperty("message") final String message,
            @JsonProperty("url") final String url,
            @JsonProperty("amount") final float amount,
            @JsonProperty("memo") final String memo,
            @JsonProperty("check_bottom_template_id") final String checkBottomTemplateId,
            @JsonProperty("attachment_template_id") final String attachmentTemplateId,
            @JsonProperty("check_bottom_template_version_id") final String checkBottomVersionId,
            @JsonProperty("attachment_template_version_id") final String attachmentTemplateVersionId,
            @JsonProperty("carrier") final String carrier,
            @JsonProperty("tracking_events") final List<TrackingEvent> trackingEvents,
            @JsonProperty("thumbnails") final List<Thumbnail> thumbnails,
            @JsonProperty("size") final String size,
            @JsonProperty("mail_type") final String mailType,
            @JsonProperty("expected_delivery_date") final DateTime expectedDeliveryDate,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("send_date") final DateTime sendDate,
            @JsonProperty("tracking_number") final String trackingNumber,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.description = description;
        this.bankAccount = bankAccount;
        this.to = to;
        this.from = from;
        this.checkNumber = checkNumber;
        this.message = message;
        this.memo = memo;
        this.amount = amount;
        this.url = url;
        this.checkBottomTemplateId = checkBottomTemplateId;
        this.attachmentTemplateId = attachmentTemplateId;
        this.checkBottomVersionId = checkBottomVersionId;
        this.attachmentTemplateVersionId = attachmentTemplateVersionId;
        this.carrier = carrier;
        this.trackingEvents = trackingEvents;
        this.thumbnails = thumbnails;
        this.size = size;
        this.mailType = mailType;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.sendDate = sendDate;
        this.trackingNumber = trackingNumber;
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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public Address getTo() {
        return to;
    }

    public Address getFrom() {
        return from;
    }

    public int getCheckNumber() { return checkNumber; }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }

    public String getCheckBottomTemplateId() {
        return checkBottomTemplateId;
    }

    public String getAttachmentTemplateId() {
        return attachmentTemplateId;
    }

    public String getCheckBottomVersionId() {
        return checkBottomVersionId;
    }

    public String getAttachmentTemplateVersionId() {
        return attachmentTemplateVersionId;
    }

    public float getAmount() {
        return amount;
    }

    public String getMemo() {
        return memo;
    }

    public String getCarrier() {
        return carrier;
    }

    public List<TrackingEvent> getTrackingEvents() {
        return trackingEvents;
    }

    public List<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public String getSize() {
        return size;
    }

    public String getMailType() {
        return mailType;
    }

    public DateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DateTime getDateModified() {
        return dateModified;
    }

    public DateTime getSendDate() {
        return sendDate;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public String getTrackingNumber() { return trackingNumber; }

    public boolean isDeleted() {
        return deleted;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", bankAccount=" + bankAccount +
                ", to=" + to +
                ", from=" + from +
                ", checkNumber=" + checkNumber +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", memo='" + memo + '\'' +
                ", amount='" + amount + '\'' +
                ", checkBottomTemplateId='" + checkBottomTemplateId + '\'' +
                ", attachmentTemplateId='" + attachmentTemplateId + '\'' +
                ", checkBottomVersionId='" + checkBottomVersionId + '\'' +
                ", attachmentTemplateVersionId='" + attachmentTemplateVersionId + '\'' +
                ", carrier='" + carrier + '\'' +
                ", trackingEvents='" + trackingEvents + '\'' +
                ", thumbnails='" + thumbnails + '\'' +
                ", size='" + size + '\'' +
                ", mailType='" + mailType + '\'' +
                ", expectedDeliveryDate=" + expectedDeliveryDate +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", sendDate=" + sendDate +
                ", mailType='" + mailType + '\'' +
                ", metadata=" + metadata +
                ", deleted=" + deleted +
                ", object=" + object +
                '}';
    }

    public static CheckCreator creator() {
        return new CheckCreator();
    }

    public static final class CheckCreator {
        private Map<String, Object> params = new HashMap<String, Object>();
        private boolean isMultipart = false;

        public CheckCreator() {
        }

        public CheckCreator setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public CheckCreator setBankaccount(BankAccount bankAccount) {
            params.put("bank_account", bankAccount.getId());
            return this;
        }

        public CheckCreator setTo(String to) {
            params.put("to", to);
            return this;
        }

        public CheckCreator setTo(Address.AddressCreator to) {
            params.put("to", to.build());
            return this;
        }

        public CheckCreator setFrom(String from) {
            params.put("from", from);
            return this;
        }

        public CheckCreator setFrom(Address.AddressCreator from) {
            params.put("from", from.build());
            return this;
        }

        public CheckCreator setCheckNumber(int checkNumber) {
            params.put("check_number", checkNumber);
            return this;
        }

        public CheckCreator setAmount(float amount) {
            params.put("amount", amount);
            return this;
        }

        public CheckCreator setMemo(String memo) {
            params.put("memo", memo);
            return this;
        }

        public CheckCreator setCheckBottom(String checkBottom) {
            params.put("check_bottom", checkBottom);
            return this;
        }

        public CheckCreator setCheckBottom(File checkBottom) {
            isMultipart = true;
            params.put("check_bottom", checkBottom);
            return this;
        }

        public CheckCreator setAttachment(String attachment) {
            params.put("attachment", attachment);
            return this;
        }

        public CheckCreator setAttachment(File attachment) {
            isMultipart = true;
            params.put("attachment", attachment);
            return this;
        }

        public CheckCreator setLogo(String logo) {
            params.put("logo", logo);
            return this;
        }

        public CheckCreator setLogo(File logo) {
            isMultipart = true;
            params.put("logo", logo);
            return this;
        }

        public CheckCreator setMergeVariables(Map<String, String> mergeVariables) {
            params.put("merge_variables", mergeVariables);
            return this;
        }

        public CheckCreator setMessage(String message) {
            params.put("message", message);
            return this;
        }

        public CheckCreator setSize(String size) {
            params.put("size", size);
            return this;
        }

        public CheckCreator setMailType(String mailType) {
            params.put("mail_type", mailType);
            return this;
        }

        public CheckCreator setSendDate(DateTime sendDate) {
            params.put("send_date", sendDate);
            return this;
        }

        public CheckCreator setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }


        public LobResponse<Check> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public LobResponse<Check> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            if (isMultipart) {
                return request(RequestMethod.POST, RequestType.MULTIPART, ENDPOINT, params, Check.class, options);
            }

            return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, params, Check.class, options);
        }
    }

    public static LobResponse<Check> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static LobResponse<Check> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", ENDPOINT, id), null, Check.class, options);
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
        return request(RequestMethod.GET, RequestType.NORMAL, ENDPOINT, params, CheckCollection.class, options);
    }

    public static LobResponse<Check> delete(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return delete(id, null);
    }

    public static LobResponse<Check> delete(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.DELETE, RequestType.NORMAL, String.format("%s/%s", ENDPOINT, id), null, Check.class, options);
    }

}
