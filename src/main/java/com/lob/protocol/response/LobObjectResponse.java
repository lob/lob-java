package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.LobObjectId;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

import static com.lob.Util.defensiveCopy;

public class LobObjectResponse extends AbstractLobResponse {
    @JsonProperty private final LobObjectId id;
    @JsonProperty private final int quantity;
    @JsonProperty private final int pages;
    @JsonProperty private final String url;
    @JsonProperty private final List<ThumbnailResponse> thumbnails;
    @JsonProperty private final SettingResponse setting;

    @JsonCreator
    public LobObjectResponse(
            @JsonProperty("id") final LobObjectId id,
            @JsonProperty("quantity") final int quantity,
            @JsonProperty("pages") final int pages,
            @JsonProperty("url") final String url,
            @JsonProperty("thumbnails") final List<ThumbnailResponse> thumbnails,
            @JsonProperty("description") final String description,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("setting") final SettingResponse setting,
            @JsonProperty("object") final String object) {
        super(description, dateCreated, dateModified, metadata, object);
        this.id = id;
        this.quantity = quantity;
        this.pages = pages;
        this.url = url;
        this.thumbnails = thumbnails;
        this.setting = setting;
    }

    public LobObjectId getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPages() {
        return pages;
    }

    public String getUrl() {
        return url;
    }

    public List<ThumbnailResponse> getThumbnails() {
        return defensiveCopy(thumbnails);
    }

    public SettingResponse getSetting() {
        return setting;
    }

    @Override
    public String toString() {
        return "LobObjectResponse{" +
            "id=" + id +
            ", quantity=" + quantity +
            ", pages=" + pages +
            ", url='" + url + '\'' +
            ", thumbnails=" + thumbnails +
            ", setting=" + setting +
            super.toString();
    }
}
