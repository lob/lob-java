package com.lob.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.net.APIResource;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Area extends APIResource {
    public static final String ENDPOINT = "areas";

    @JsonProperty private final String id;
    @JsonProperty private final String description;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final List<ZipCode> zipCodes;
    @JsonProperty private final int addresses;
    @JsonProperty private final String price;
    @JsonProperty private final String frontTemplateId;
    @JsonProperty private final String backTemplateId;
    @JsonProperty private final String frontTemplateVersionId;
    @JsonProperty private final String backTemplateVersionId;
    @JsonProperty private final String url;
    @JsonProperty private final String targetType;
    @JsonProperty private final List<Thumbnail> thumbnails;
    @JsonProperty private final String expectedDeliveryDate;
    @JsonProperty private final List<TrackingEvent> trackings;
    @JsonProperty private final String dateCreated;
    @JsonProperty private final String dateModified;
    @JsonProperty private final String object;

    public Area(@JsonProperty("id") final String id,
                @JsonProperty("description") final String description,
                @JsonProperty("metadata") final Map<String, String> metadata,
                @JsonProperty("zip_codes") final List<ZipCode> zipCodes,
                @JsonProperty("addresses") final int addresses,
                @JsonProperty("price") final String price,
                @JsonProperty("url") final String url,
                @JsonProperty("front_template_id") final String frontTemplateId,
                @JsonProperty("back_template_id") final String backTemplateId,
                @JsonProperty("front_template_version_id") final String frontTemplateVersionId,
                @JsonProperty("back_template_version_id") final String backTemplateVersionId,
                @JsonProperty("target_types") final String targetType,
                @JsonProperty("thumbnails") final List<Thumbnail> thumbnails,
                @JsonProperty("expected_delivery_date") final String expectedDeliveryDate,
                @JsonProperty("trackings") final List<TrackingEvent> trackings,
                @JsonProperty("date_created") final String dateCreated,
                @JsonProperty("date_modified") final String dateModified,
                @JsonProperty("object") final String object) {
        this.id = id;
        this.description = description;
        this.metadata = metadata;
        this.zipCodes = zipCodes;
        this.addresses = addresses;
        this.price = price;
        this.url = url;
        this.frontTemplateId = frontTemplateId;
        this.backTemplateId = backTemplateId;
        this.frontTemplateVersionId = frontTemplateVersionId;
        this.backTemplateVersionId = backTemplateVersionId;
        this.targetType = targetType;
        this.thumbnails = thumbnails;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.trackings = trackings;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.object = object;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public List<ZipCode> getZipCodes() {
        return zipCodes;
    }

    public int getAddresses() {
        return addresses;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public String getFrontTemplateId() {
        return frontTemplateId;
    }

    public String getBackTemplateId() {
        return backTemplateId;
    }

    public String getFrontTemplateVersionId() {
        return frontTemplateVersionId;
    }

    public String getBackTemplateVersionId() {
        return backTemplateVersionId;
    }

    public String getTargetType() {
        return targetType;
    }

    public List<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public List<TrackingEvent> getTrackings() {
        return trackings;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", zipCodes='" + zipCodes + '\'' +
                ", addresses='" + addresses + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                ", frontTemplateId='" + frontTemplateId + '\'' +
                ", backTemplateId='" + backTemplateId + '\'' +
                ", frontTemplateVersionId='" + frontTemplateVersionId + '\'' +
                ", backTemplateVersionId='" + backTemplateVersionId + '\'' +
                ", targetType='" + targetType + '\'' +
                ", thumbnails='" + thumbnails + '\'' +
                ", expectedDeliveryDate='" + expectedDeliveryDate + '\'' +
                ", trackings='" + trackings + '\'' +
                ", thumbnails='" + thumbnails + '\'' +
                ", expectedDeliveryDate='" + expectedDeliveryDate + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", dateModified='" + dateModified + '\'' +
                ", metadata='" + metadata + '\'' +
                ", object='" + object + '\'' +
                '}';
    }
    public static AreaCreator creator() { return new AreaCreator(); }

    public static final class AreaCreator {
        private Map<String, Object> params = new HashMap<String, Object>();
        private boolean isMultipart = false;

        public AreaCreator() {
        }

        public AreaCreator setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public AreaCreator setRoutes(String routes) {
            params.put("routes", routes);
            return this;
        }

        public AreaCreator setTargetType(String targeType) {
            params.put("target_type", targeType);
            return this;
        }

        public AreaCreator setFront(String front) {
            params.put("front", front);
            return this;
        }

        public AreaCreator setFront(File front) {
            isMultipart = true;
            params.put("front", front);
            return this;
        }

        public AreaCreator setBack(String back) {
            params.put("back", back);
            return this;
        }

        public AreaCreator setBack(File back) {
            isMultipart = true;
            params.put("back", back);
            return this;
        }

        public AreaCreator setMergeVariables(Map<String, String> mergeVariables) {
            params.put("merge_variables", mergeVariables);
            return this;
        }

        public AreaCreator setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }

    }
}
