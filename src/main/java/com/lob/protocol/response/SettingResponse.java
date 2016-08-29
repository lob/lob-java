package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.SettingId;

public class SettingResponse extends AbstractResponse {
	@JsonProperty private final SettingId id;
	@JsonProperty private final String type;
	@JsonProperty private final String description;
	@JsonProperty private final String paper;
	@JsonProperty private final String width;
	@JsonProperty private final String length;
	@JsonProperty private final String color;
	@JsonProperty private final String notes;
	@JsonProperty private final String object;

    @JsonCreator
    public SettingResponse(
            @JsonProperty("id") final SettingId id,
            @JsonProperty("type") final String type,
            @JsonProperty("description") final String description,
            @JsonProperty("paper") final String paper,
            @JsonProperty("width") final String width,
            @JsonProperty("length") final String length,
            @JsonProperty("color") final String color,
            @JsonProperty("notes") final String notes,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.paper = paper;
        this.width = width;
        this.length = length;
        this.color = color;
        this.notes = notes;
        this.object = object;
    }

    public SettingId getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getPaper() {
        return paper;
    }

    public String getWidth() {
        return width;
    }

    public String getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }

    public String getNotes() {
        return notes;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "SettingResponse{" +
            "id=" + id +
            ", type='" + type + '\'' +
            ", description='" + description + '\'' +
            ", paper='" + paper + '\'' +
            ", width='" + width + '\'' +
            ", length='" + length + '\'' +
            ", color='" + color + '\'' +
            ", notes='" + notes + '\'' +
            ", object='" + object + '\'' +
            '}';
    }
}
