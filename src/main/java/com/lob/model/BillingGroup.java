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

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class BillingGroup extends APIResource {

	public static final String RESOURCE = "billing_groups";

	@JsonProperty private final String id;
	@JsonProperty private final String name;
	@JsonProperty private final String description;
	@JsonProperty private final ZonedDateTime dateCreated;
	@JsonProperty private final ZonedDateTime dateModified;
	@JsonProperty private final Boolean deleted;
	@JsonProperty private final String object;

	@JsonCreator
	public BillingGroup(
			@JsonProperty("id") final String id,
			@JsonProperty("name") final String name,
			@JsonProperty("description") final String description,
			@JsonProperty("date_created") final ZonedDateTime dateCreated,
			@JsonProperty("date_modified") final ZonedDateTime dateModified,
			@JsonProperty("deleted") final Boolean deleted,
			@JsonProperty("object") final String object) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.deleted = deleted;
		this.object = object;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public ZonedDateTime getDateModified() {
		return dateModified;
	}

	public Boolean isDeleted() {
		return deleted;
	}

	public String getObject() {
		return object;
	}

	@Override
	public String toString() {
		return "BillingGroup{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", dateCreated=" + dateCreated +
				", dateModified=" + dateModified +
				", deleted=" + deleted +
				", object='" + object + '\'' +
				'}';
	}

	public static final class RequestBuilder {
		private Map<String, Object> params = new HashMap<String, Object>();

		public RequestBuilder() {
		}

        public RequestBuilder setName(String name) {
            params.put("name", name);
            return this;
        }

		public RequestBuilder setDescription(String description) {
            params.put("description", description);
            return this;
        }

		public Map<String, Object> build() {
			return params;
		}

		public LobResponse<BillingGroup> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

		public LobResponse<BillingGroup> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
			return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, BillingGroup.class, options);
        }
	}

	public static LobResponse<BillingGroup> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
		return retrieve(id, null);
	}

	public static LobResponse<BillingGroup> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, BillingGroup.class, options);
    }

    public static LobResponse<BillingGroupCollection> list() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static LobResponse<BillingGroupCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static LobResponse<BillingGroupCollection> list(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static LobResponse<BillingGroupCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, BillingGroupCollection.class, options);
    }

}
