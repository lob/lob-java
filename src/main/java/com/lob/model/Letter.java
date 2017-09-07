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

public class Letter extends APIResource {

    public static final String ENDPOINT = "letters";

    @JsonProperty private final String id;
    @JsonProperty private final String description;
    @JsonProperty private final Address to;
    @JsonProperty private final Address from;
    @JsonProperty private final boolean doubleSided;
    @JsonProperty private final String addressPlacement;
    @JsonProperty private final boolean returnEnvelope;
    @JsonProperty private final int perforatedPage;
    @JsonProperty private final String extraService;
    @JsonProperty private final boolean color;
    @JsonProperty private final String url;
    @JsonProperty private final String templateId;
    @JsonProperty private final String templateVersionId;
    @JsonProperty private final String carrier;
    @JsonProperty private final List<TrackingEvent> trackingEvents;
    @JsonProperty private final List<Thumbnail> thumbnails;
    @JsonProperty private final String size;
    @JsonProperty private final String mailType;
    @JsonProperty private final DateTime expectedDeliveryDate;
    @JsonProperty private final DateTime dateCreated;
    @JsonProperty private final DateTime dateModified;
    @JsonProperty private final DateTime sendDate;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final boolean deleted;
    @JsonProperty private final String object;

    @JsonCreator
    public Letter(
            @JsonProperty("id") final String id,
            @JsonProperty("description") final String description,
            @JsonProperty("to") final Address to,
            @JsonProperty("from") final Address from,
            @JsonProperty("double_sided") final boolean doubleSided,
            @JsonProperty("address_placement") final String addressPlacement,
            @JsonProperty("return_envelope") final boolean returnEnvelope,
            @JsonProperty("perforated_page") final int perforatedPage,
            @JsonProperty("extra_service") final String extraService,
            @JsonProperty("color") final boolean color,
            @JsonProperty("url") final String url,
            @JsonProperty("template_id") final String templateId,
            @JsonProperty("template_version_id") final String templateVersionId,
            @JsonProperty("carrier") final String carrier,
            @JsonProperty("tracking_events") final List<TrackingEvent> trackingEvents,
            @JsonProperty("thumbnails") final List<Thumbnail> thumbnails,
            @JsonProperty("size") final String size,
            @JsonProperty("mail_type") final String mailType,
            @JsonProperty("expected_delivery_date") final DateTime expectedDeliveryDate,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("send_date") final DateTime sendDate,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.description = description;
        this.to = to;
        this.from = from;
        this.doubleSided = doubleSided;
        this.addressPlacement = addressPlacement;
        this.returnEnvelope = returnEnvelope;
        this.perforatedPage = perforatedPage;
        this.extraService = extraService;
        this.color = color;
        this.url = url;
        this.templateId = templateId;
        this.templateVersionId = templateVersionId;
        this.carrier = carrier;
        this.trackingEvents = trackingEvents;
        this.thumbnails = thumbnails;
        this.size = size;
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

    public boolean getDoubleSided() {
        return doubleSided;
    }

    public String getAddressPlacement() {
        return addressPlacement;
    }

    public boolean getReturnEnvelope() {
        return returnEnvelope;
    }

    public int getPerforatedPage() {
        return perforatedPage;
    }

    public String getExtraService() {
        return extraService;
    }

    public boolean getColor() {
        return color;
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

    public boolean isDeleted() {
        return deleted;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", to=" + to +
                ", from=" + from +
                ", doubleSided=" + doubleSided +
                ", addressPlacement=" + addressPlacement +
                ", returnEnvelope=" + returnEnvelope +
                ", perforatedPage=" + perforatedPage +
                ", extraService=" + extraService +
                ", color=" + color +
                ", url='" + url + '\'' +
                ", templateId='" + templateId + '\'' +
                ", templateVersionId='" + templateVersionId + '\'' +
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

    public static LetterCreator creator() {
        return new LetterCreator();
    }

    public static final class LetterCreator {
        private Map<String, Object> params = new HashMap<String, Object>();
        private boolean isMultipart = false;

        public LetterCreator() {
        }

        public LetterCreator setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public LetterCreator setTo(String to) {
            params.put("to", to);
            return this;
        }

        public LetterCreator setTo(Address.AddressCreator to) {
            params.put("to", to.build());
            return this;
        }

        public LetterCreator setFrom(String from) {
            params.put("from", from);
            return this;
        }

        public LetterCreator setFrom(Address.AddressCreator from) {
            params.put("from", from.build());
            return this;
        }

        public LetterCreator setDoubleSided(boolean doubleSided) {
            params.put("double_sided", doubleSided);
            return this;
        }

        public LetterCreator setAddressPlacement(String addressPlacement) {
            params.put("address_placement", addressPlacement);
            return this;
        }

        public LetterCreator setReturnEnvelope(boolean returnEnvelope) {
            params.put("return_envelope", returnEnvelope);
            return this;
        }

        public LetterCreator setPerforatedPage(int perforatedPage) {
            params.put("perforated_page", perforatedPage);
            return this;
        }

        public LetterCreator setExtraService(String extraService) {
            params.put("extra_service", extraService);
            return this;
        }

        public LetterCreator setColor(boolean color) {
            params.put("color", color);
            return this;
        }

        public LetterCreator setFile(String file) {
            params.put("file", file);
            return this;
        }

        public LetterCreator setFile(File file) {
            isMultipart = true;
            params.put("file", file);
            return this;
        }

        public LetterCreator setMergeVariables(Map<String, String> mergeVariables) {
            params.put("merge_variables", mergeVariables);
            return this;
        }

        public LetterCreator setSize(String size) {
            params.put("size", size);
            return this;
        }

        public LetterCreator setMailType(String mailType) {
            params.put("mail_type", mailType);
            return this;
        }

        public LetterCreator setSendDate(DateTime sendDate) {
            params.put("send_date", sendDate);
            return this;
        }

        public LetterCreator setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }


        public LobResponse<Letter> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public LobResponse<Letter> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            if (isMultipart) {
                return request(RequestMethod.POST, RequestType.MULTIPART, ENDPOINT, params, Letter.class, options);
            }

            return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, params, Letter.class, options);
        }
    }

    public static LobResponse<Letter> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static LobResponse<Letter> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", ENDPOINT, id), null, Letter.class, options);
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
        return request(RequestMethod.GET, RequestType.NORMAL, ENDPOINT, params, LetterCollection.class, options);
    }

    public static LobResponse<Letter> delete(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return delete(id, null);
    }

    public static LobResponse<Letter> delete(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.DELETE, RequestType.NORMAL, String.format("%s/%s", ENDPOINT, id), null, Letter.class, options);
    }

}
