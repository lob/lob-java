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

public class Template extends APIResource {

    public static final String RESOURCE = "templates";

    public static class TemplateVersion {
        @JsonProperty private final String id;
        @JsonProperty private final boolean suggestJsonEditor;
        @JsonProperty private final String description;
        @JsonProperty private final String engine;
        @JsonProperty private final String html;
        @JsonProperty private final ZonedDateTime dateCreated;
        @JsonProperty private final ZonedDateTime dateModified;
        @JsonProperty private final String object;

        @JsonCreator
        public TemplateVersion(
                @JsonProperty("id") final String id,
                @JsonProperty("suggest_json_editor") final boolean suggestJsonEditor,
                @JsonProperty("description") final String description,
                @JsonProperty("engine") final String engine,
                @JsonProperty("html") final String html,
                @JsonProperty("date_created") final ZonedDateTime dateCreated,
                @JsonProperty("date_modified") final ZonedDateTime dateModified,
                @JsonProperty("object") final String object
        ) {
            this.id = id;
            this.suggestJsonEditor = suggestJsonEditor;
            this.description = description;
            this.engine = engine;
            this.html = html;
            this.dateCreated = dateCreated;
            this.dateModified = dateModified;
            this.object = object;
        }

        public String getId() {
            return id;
        }

        public boolean getSuggestJsonEditor() {
            return suggestJsonEditor;
        }

        public String getDescription() {
            return description;
        }

        public String getEngine() {
            return engine;
        }

        public String getHtml() {
            return html;
        }

        public ZonedDateTime getDateCreated() {
            return dateCreated;
        }

        public ZonedDateTime getDateModified() {
            return dateModified;
        }

        public String getObject() {
            return object;
        }
    }

    @JsonProperty private final String id;
    @JsonProperty private final String description;
    @JsonProperty private final List<TemplateVersion> versions;
    @JsonProperty private final TemplateVersion publishedVersion;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final ZonedDateTime dateCreated;
    @JsonProperty private final ZonedDateTime dateModified;
    @JsonProperty private final String object;

    @JsonCreator
    public Template(
            @JsonProperty("id") final String id,
            @JsonProperty("description") final String description,
            @JsonProperty("versions") final List<TemplateVersion> versions,
            @JsonProperty("published_version") final TemplateVersion publishedVersion,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("date_created") final ZonedDateTime dateCreated,
            @JsonProperty("date_modified") final ZonedDateTime dateModified,
            @JsonProperty("object") final String object
    ) {
        this.id = id;
        this.description = description;
        this.versions = versions;
        this.publishedVersion = publishedVersion;
        this.metadata = metadata;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<TemplateVersion> getVersions() { return versions; }

    public TemplateVersion getPublishedVersion() { return publishedVersion; }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }

    public String getObject() {
        return object;
    }


    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();
        private boolean isMultipart = false;
        private ObjectMapper objectMapper = new ObjectMapper();

        public RequestBuilder() {
        }

        public Template.RequestBuilder setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public Template.RequestBuilder setHtml(String html) {
            params.put("html", html);
            return this;
        }

        public Template.RequestBuilder setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }

        public Template.RequestBuilder setEngine(String engine) {
            params.put("engine", engine);
            return this;
        }

        public LobResponse<Template> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public LobResponse<Template> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, Template.class, options);
        }
    }

    public static LobResponse<Template> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static LobResponse<Template> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Template.class, options);
    }

    public static LobResponse<TemplateCollection> list() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static LobResponse<TemplateCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static LobResponse<TemplateCollection> list(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static LobResponse<TemplateCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, TemplateCollection.class, options);
    }

    public static LobResponse<Template> delete(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return delete(id, null);
    }

    public static LobResponse<Template> delete(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.DELETE, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Template.class, options);
    }
}
