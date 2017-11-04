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

public class Letter extends APIResource {

    public static final String RESOURCE = "letters";

    public static class CustomEnvelope {

        @JsonProperty private final String id;
        @JsonProperty private final String url;
        @JsonProperty private final String object;

        @JsonCreator
        public CustomEnvelope(
                @JsonProperty("id") final String id,
                @JsonProperty("url") final String url,
                @JsonProperty("object") final String object) {
            this.id = id;
            this.url = url;
            this.object = object;
        }

        public String getId() {
            return id;
        }

        public String getUrl() {
            return url;
        }

        public String getObject() {
            return object;
        }
    }

    @JsonProperty private final String id;
    @JsonProperty private final String description;
    @JsonProperty private final Address to;
    @JsonProperty private final Address from;
    @JsonProperty private final boolean color;
    @JsonProperty private final boolean doubleSided;
    @JsonProperty private final String addressPlacement;
    @JsonProperty private final boolean returnEnvelope;
    @JsonProperty private final Integer perforatedPage;
    @JsonProperty private final String extraService;
    @JsonProperty private final String mailType;
    @JsonProperty private final String url;
    @JsonProperty private final String templateId;
    @JsonProperty private final String templateVersionId;
    @JsonProperty private final String carrier;
    @JsonProperty private final String trackingNumber;
    @JsonProperty private final List<TrackingEvent> trackingEvents;
    @JsonProperty private final List<Thumbnail> thumbnails;
    @JsonProperty private final CustomEnvelope customEnvelope;
    @JsonProperty private final LocalDate expectedDeliveryDate;
    @JsonProperty private final ZonedDateTime dateCreated;
    @JsonProperty private final ZonedDateTime dateModified;
    @JsonProperty private final ZonedDateTime sendDate;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final boolean deleted;
    @JsonProperty private final String object;

    @JsonCreator
    public Letter(
            @JsonProperty("id") final String id,
            @JsonProperty("description") final String description,
            @JsonProperty("to") final Address to,
            @JsonProperty("from") final Address from,
            @JsonProperty("color") final boolean color,
            @JsonProperty("double_sided") final boolean doubleSided,
            @JsonProperty("address_placement") final String addressPlacement,
            @JsonProperty("return_envelope") final boolean returnEnvelope,
            @JsonProperty("perforated_page") final Integer perforatedPage,
            @JsonProperty("extra_service") final String extraService,
            @JsonProperty("mail_type") final String mailType,
            @JsonProperty("url") final String url,
            @JsonProperty("template_id") final String templateId,
            @JsonProperty("template_version_id") final String templateVersionId,
            @JsonProperty("carrier") final String carrier,
            @JsonProperty("tracking_number") final String trackingNumber,
            @JsonProperty("tracking_events") final List<TrackingEvent> trackingEvents,
            @JsonProperty("thumbnails") final List<Thumbnail> thumbnails,
            @JsonProperty("custom_envelope") final CustomEnvelope customEnvelope,
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
        this.color = color;
        this.doubleSided = doubleSided;
        this.addressPlacement = addressPlacement;
        this.returnEnvelope = returnEnvelope;
        this.perforatedPage = perforatedPage;
        this.extraService = extraService;
        this.mailType = mailType;
        this.url = url;
        this.templateId = templateId;
        this.templateVersionId = templateVersionId;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.trackingEvents = trackingEvents;
        this.thumbnails = thumbnails;
        this.customEnvelope = customEnvelope;
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

    public boolean isColor() {
        return color;
    }

    public boolean isDoubleSided() {
        return doubleSided;
    }

    public String getAddressPlacement() {
        return addressPlacement;
    }

    public boolean isReturnEnvelope() {
        return returnEnvelope;
    }

    public Integer getPerforatedPage() {
        return perforatedPage;
    }

    public String getExtraService() {
        return extraService;
    }

    public String getMailType() {
        return mailType;
    }

    public String getUrl() {
        return url;
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getTemplateVersionId() {
        return templateVersionId;
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

    public CustomEnvelope getCustomEnvelope() {
        return customEnvelope;
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
        return "Letter{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", to=" + to +
                ", from=" + from +
                ", color=" + color +
                ", doubleSided=" + doubleSided +
                ", addressPlacement='" + addressPlacement + '\'' +
                ", returnEnvelope=" + returnEnvelope +
                ", perforatedPage=" + perforatedPage +
                ", extraService='" + extraService + '\'' +
                ", mailType='" + mailType + '\'' +
                ", url='" + url + '\'' +
                ", templateId='" + templateId + '\'' +
                ", templateVersionId='" + templateVersionId + '\'' +
                ", carrier='" + carrier + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", trackingEvents=" + trackingEvents +
                ", thumbnails=" + thumbnails +
                ", customEnvelope=" + customEnvelope +
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

        public RequestBuilder setColor(boolean color) {
            params.put("color", color);
            return this;
        }

        public RequestBuilder setFile(String file) {
            params.put("file", file);
            return this;
        }

        public RequestBuilder setFile(File file) {
            isMultipart = true;
            params.put("file", file);
            return this;
        }

        public RequestBuilder setMergeVariables(Map<String, String> mergeVariables) {
            params.put("merge_variables", mergeVariables);
            return this;
        }

        public RequestBuilder setDoubleSided(boolean doubleSided) {
            params.put("double_sided", doubleSided);
            return this;
        }

        public RequestBuilder setAddressPlacement(String addressPlacement) {
            params.put("address_placement", addressPlacement);
            return this;
        }

        public RequestBuilder setReturnEnvelope(boolean returnEnvelope) {
            params.put("return_envelope", returnEnvelope);
            return this;
        }

        public RequestBuilder setPerforatedPage(int perforatedPage) {
            params.put("perforated_page", perforatedPage);
            return this;
        }

        public RequestBuilder setMailType(String mailType) {
            params.put("mail_type", mailType);
            return this;
        }

        public RequestBuilder setExtraService(String extraService) {
            params.put("extra_service", extraService);
            return this;
        }

        public RequestBuilder setCustomEnvelope(String customEnvelope) {
            params.put("custom_envelope", customEnvelope);
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


        public LobResponse<Letter> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public LobResponse<Letter> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            if (isMultipart) {
                return request(RequestMethod.POST, RequestType.MULTIPART, RESOURCE, params, Letter.class, options);
            }

            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, Letter.class, options);
        }
    }

    public static LobResponse<Letter> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static LobResponse<Letter> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Letter.class, options);
    }

    public static LobResponse<LetterCollection> list() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static LobResponse<LetterCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static LobResponse<LetterCollection> list(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static LobResponse<LetterCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, LetterCollection.class, options);
    }

    public static LobResponse<Letter> delete(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return delete(id, null);
    }

    public static LobResponse<Letter> delete(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.DELETE, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Letter.class, options);
    }

}
