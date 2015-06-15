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
    @JsonProperty private final String name;
    @JsonProperty private final int quantity;
    @JsonProperty private final boolean fullBleed;
    @JsonProperty private final boolean doubleSided;
    @JsonProperty private final boolean template;
    @JsonProperty private final String url;
    @JsonProperty private final List<ThumbnailResponse> thumbnails;
    @JsonProperty private final SettingResponse setting;

    @JsonCreator
    public LobObjectResponse(
            @JsonProperty("id") final LobObjectId id,
            @JsonProperty("name") final String name,
            @JsonProperty("quantity") final int quantity,
            @JsonProperty("full_bleed") final boolean fullBleed,
            @JsonProperty("double_sided") final boolean doubleSided,
            @JsonProperty("template") final boolean template,
            @JsonProperty("url") final String url,
            @JsonProperty("thumbnails") final List<ThumbnailResponse> thumbnails,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("setting") final SettingResponse setting,
            @JsonProperty("object") final String object) {
        super(dateCreated, dateModified, metadata, object);
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.fullBleed = fullBleed;
        this.doubleSided = doubleSided;
        this.template = template;
        this.url = url;
        this.thumbnails = thumbnails;
        this.setting = setting;
    }

    public LobObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isFullBleed() {
        return fullBleed;
    }

    public boolean isDoubleSided() {
        return doubleSided;
    }

    public boolean isTemplate() {
        return template;
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
            ", name='" + name + '\'' +
            ", quantity=" + quantity +
            ", fullBleed=" + fullBleed +
            ", doubleSided=" + doubleSided +
            ", template=" + template +
            ", url='" + url + '\'' +
            ", thumbnails=" + thumbnails +
            ", setting=" + setting +
            super.toString();
    }
}
