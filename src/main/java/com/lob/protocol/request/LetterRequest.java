package com.lob.protocol.request;

import com.lob.LobParamsBuilder;
import com.lob.Or;
import com.lob.id.AddressId;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import static com.lob.Util.checkNotNull;

public class LetterRequest extends AbstractDataFieldRequest implements HasLobParams {
    private final static String FILE = "file";

    private final String description;
    private final Or<AddressId, AddressRequest> to;
    private final Or<AddressId, AddressRequest> from;
    private final LobParam file;
    private final Boolean color;
    private final Boolean doubleSided;
    private final Boolean template;

    public LetterRequest(
            final String description,
            final Or<AddressId, AddressRequest> to,
            final Or<AddressId, AddressRequest> from,
            final LobParam file,
            final Boolean color,
            final Boolean doubleSided,
            final Boolean template,
            final Map<String, String> metadata,
            final Map<String, String> data) {

        super(metadata, data);
        this.description = description;
        this.to = checkNotNull(to, "to is required");
        this.from = checkNotNull(from, "from is required");
        this.file = checkNotNull(file, "file is required");
        this.color = checkNotNull(color, "color is required");
        this.doubleSided = doubleSided;
        this.template = template;
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return super.beginParams()
            .put("description", description)
            .put("to", to)
            .put("from", from)
            .put(file)
            .put("color", color)
            .put("double_sided", doubleSided)
            .put("template", template)
            .build();
    }

    public String getDescription() { return description; }

    public Or<AddressId, AddressRequest> getTo() { return to; }

    public Or<AddressId, AddressRequest> getFrom() { return from; }

    public LobParam getFile() { return file; }

    public Boolean isColor() { return color; }

    public Boolean isDoubleSided() { return doubleSided; }

    public Boolean isTemplate() { return template; }

    @Override
    public String toString() {
        return "LetterRequest{" +
            "description='" + description + "'" +
            ", to=" + to +
            ", from=" + from +
            ", file=" + file +
            ", color=" + color +
            ", doubleSided=" + doubleSided +
            ", template=" + template +
            super.toString();
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String description;
        private Or<AddressId, AddressRequest> to;
        private Or<AddressId, AddressRequest> from;
        private LobParam file;
        private Boolean color;
        private Boolean doubleSided;
        private Boolean template;
        private Map<String, String> metadata;
        private Map<String, String> data;

        private Builder() {}

        private Builder description(final String description) {
            this.description= description;
            return this;
        }

        public Builder to(final AddressId to) {
            this.to = Or.typeA(to);
            return this;
        }

        public Builder to(final AddressRequest to) {
            this.to = Or.typeB(to);
            return this;
        }

        public Builder to(final Or<AddressId, AddressRequest> to) {
            this.to = to;
            return this;
        }

        public Builder from(final AddressId from) {
            this.from = Or.typeA(from);
            return this;
        }

        public Builder from(final AddressRequest from) {
            this.from = Or.typeB(from);
            return this;
        }

        public Builder from(final Or<AddressId, AddressRequest> from) {
            this.from = from;
            return this;
        }

        public Builder file(final String file) {
            this.file = LobParam.strings(FILE, file);
            return this;
        }

        public Builder file(final File file) {
            this.file = LobParam.file(FILE, file);
            return this;
        }

        public Builder file(final LobParam file) {
            this.file = file;
            return this;
        }

        public Builder color(final Boolean color) {
            this.color = color;
            return this;
        }

        public Builder doubleSided(final Boolean doubleSided) {
            this.doubleSided = doubleSided;
            return this;
        }

        public Builder template(final Boolean template) {
            this.template = template;
            return this;
        }

        public Builder metadata(final Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder data(final Map<String, String> data) {
            this.data = data;
            return this;
        }

        public Builder butWith() {
            return new Builder()
                .description(description)
                .to(to)
                .from(from)
                .file(file)
                .color(color)
                .doubleSided(doubleSided)
                .template(template)
                .metadata(metadata)
                .data(data);
        }

        public LetterRequest build() {
            return new LetterRequest(description, to, from, file, color, doubleSided, template, metadata, data);
        }
    }
}