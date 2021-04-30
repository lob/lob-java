package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.ParsingException;
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

public class SelfMailer extends APIResource {

    public static final String RESOURCE = "self_mailers";

    @JsonProperty private final String id;
    @JsonProperty private final String description;
    @JsonProperty private final Address to;
    @JsonProperty private final Address from;
    @JsonProperty private final String url;
    @JsonProperty private final String outsideTemplateId;
    @JsonProperty private final String insideTemplateId;
    @JsonProperty private final String outsideTemplateVersionId;
    @JsonProperty private final String insideTemplateVersionId;
    @JsonProperty private final String carrier;
    @JsonProperty private final List<TrackingEvent> trackingEvents;
    @JsonProperty private final List<Thumbnail> thumbnails;
    @JsonProperty private final String size;
    @JsonProperty private final String mailType;
    @JsonProperty private final Map<String, Object> mergeVariables;
    @JsonProperty private final LocalDate expectedDeliveryDate;
    @JsonProperty private final ZonedDateTime dateCreated;
    @JsonProperty private final ZonedDateTime dateModified;
    @JsonProperty private final ZonedDateTime sendDate;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final boolean deleted;
    @JsonProperty private final String object;

    @JsonCreator
    public SelfMailer(
            @JsonProperty("id") final String id,
            @JsonProperty("description") final String description,
            @JsonProperty("to") final Address to,
            @JsonProperty("from") final Address from,
            @JsonProperty("url") final String url,
            @JsonProperty("outside_template_id") final String outsideTemplateId,
            @JsonProperty("inside_template_id") final String insideTemplateId,
            @JsonProperty("outside_template_version_id") final String outsideTemplateVersionId,
            @JsonProperty("inside_template_version_id") final String insideTemplateVersionId,
            @JsonProperty("carrier") final String carrier,
            @JsonProperty("tracking_events") final List<TrackingEvent> trackingEvents,
            @JsonProperty("thumbnails") final List<Thumbnail> thumbnails,
            @JsonProperty("size") final String size,
            @JsonProperty("mail_type") final String mailType,
            @JsonProperty("merge_variables") final Map<String, Object> mergeVariables,
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
        this.url = url;
        this.outsideTemplateId = outsideTemplateId;
        this.insideTemplateId = insideTemplateId;
        this.outsideTemplateVersionId = outsideTemplateVersionId;
        this.insideTemplateVersionId = insideTemplateVersionId;
        this.carrier = carrier;
        this.trackingEvents = trackingEvents;
        this.thumbnails = thumbnails;
        this.size = size;
        this.mailType = mailType;
        this.mergeVariables = mergeVariables;
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

    public String getUrl() {
        return url;
    }

    public String getOutsideTemplateId() {
        return outsideTemplateId;
    }

    public String getInsideTemplateId() {
        return insideTemplateId;
    }

    public String getOutsideTemplateVersionId() {
        return outsideTemplateVersionId;
    }

    public String getInsideTemplateVersionId() {
        return insideTemplateVersionId;
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

    public Map<String, Object> getMergeVariables() {
        return mergeVariables;
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
        return "SelfMailer{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", to=" + to +
                ", from=" + from +
                ", url='" + url + '\'' +
                ", outsideTemplateId='" + outsideTemplateId + '\'' +
                ", insideTemplateId='" + insideTemplateId + '\'' +
                ", outsideTemplateVersionId='" + outsideTemplateVersionId + '\'' +
                ", insideTemplateVersionId='" + insideTemplateVersionId + '\'' +
                ", carrier='" + carrier + '\'' +
                ", trackingEvents='" + trackingEvents + '\'' +
                ", thumbnails='" + thumbnails + '\'' +
                ", size='" + size + '\'' +
                ", mailType='" + mailType + '\'' +
                ", mergeVariables=" + mergeVariables +
                ", expectedDeliveryDate=" + expectedDeliveryDate +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", sendDate=" + sendDate +
                ", mailType='" + mailType + '\'' +
                ", metadata=" + metadata +
                ", deleted=" + deleted +
                ", object='" + object + '\'' +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();
        private boolean isMultipart = false;
        private ObjectMapper objectMapper = new ObjectMapper();

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

        public RequestBuilder setOutside(File outside) {
            isMultipart = true;
            params.put("outside", outside);
            return this;
        }

        public RequestBuilder setOutside(String inside) {
            params.put("outside", inside);
            return this;
        }

        public RequestBuilder setInside(String inside) {
            params.put("inside", inside);
            return this;
        }

        public RequestBuilder setInside(File outside) {
            isMultipart = true;
            params.put("inside", outside);
            return this;
        }

        public RequestBuilder setMergeVariables(Map mergeVariables) throws ParsingException {
            try {
                params.put("merge_variables", objectMapper.writeValueAsString(mergeVariables));
                return this;
            } catch (JsonProcessingException e) {
               throw new ParsingException(e);
            }
        }

        public RequestBuilder setSize(String size) {
            params.put("size", size);
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


        public LobResponse<SelfMailer> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public LobResponse<SelfMailer> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            if (isMultipart) {
                return request(RequestMethod.POST, RequestType.MULTIPART, RESOURCE, params, SelfMailer.class, options);
            }

            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, SelfMailer.class, options);
        }

    }

    public static LobResponse<SelfMailer> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static LobResponse<SelfMailer> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, SelfMailer.class, options);
    }

    public static LobResponse<SelfMailerCollection> list() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static LobResponse<SelfMailerCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static LobResponse<SelfMailerCollection> list(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static LobResponse<SelfMailerCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, SelfMailerCollection.class, options);
    }

    public static LobResponse<SelfMailer> delete(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return delete(id, null);
    }

    public static LobResponse<SelfMailer> delete(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.DELETE, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, SelfMailer.class, options);
    }

}
