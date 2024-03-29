/*
 * Lob
 * The Lob API is organized around REST. Our API is designed to have predictable, resource-oriented URLs and uses HTTP response codes to indicate any API errors. <p> Looking for our [previous documentation](https://lob.github.io/legacy-docs/)? 
 *
 * The version of the OpenAPI document: 1.3.0
 * Contact: lob-openapi@lob.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.lob.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.lob.model.Address;
import com.lob.model.AddressDomesticExpanded;
import com.lob.model.MailType;
import com.lob.model.PostcardSize;
import com.lob.model.PscUseType;
import com.lob.model.Thumbnail;
import com.lob.model.TrackingEventNormal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * Postcard
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Postcard {
  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `psc_`.
  * @return id
  **/
  
  @javax.annotation.Nonnull
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^psc_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_TO = "to";

  @SerializedName(SERIALIZED_NAME_TO)
  

  private Address to;
  /**
  * Get to
  * @return to
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public Address getTo() {
      return to;
  }
  
  

  public static final String SERIALIZED_NAME_FROM = "from";

  @SerializedName(SERIALIZED_NAME_FROM)
  

  private AddressDomesticExpanded from;
  /**
  * Get from
  * @return from
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public AddressDomesticExpanded getFrom() {
      return from;
  }
  
  

  /**
   * Gets or Sets carrier
   */
  @JsonAdapter(CarrierEnum.Adapter.class)
  public enum CarrierEnum {
    USPS("USPS");

    private String value;

    CarrierEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CarrierEnum fromValue(String value) {
      for (CarrierEnum b : CarrierEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CarrierEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CarrierEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CarrierEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CarrierEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CARRIER = "carrier";

  @SerializedName(SERIALIZED_NAME_CARRIER)
  

  private CarrierEnum carrier = CarrierEnum.USPS;
  /**
  * Get carrier
  * @return carrier
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public CarrierEnum getCarrier() {
      return carrier;
  }
  
  

  public static final String SERIALIZED_NAME_THUMBNAILS = "thumbnails";

  @SerializedName(SERIALIZED_NAME_THUMBNAILS)
  private List<Thumbnail> thumbnails = null;
  public List<Thumbnail> getThumbnails() {
    if (this.thumbnails == null) {
      this.thumbnails = new ArrayList<Thumbnail>();
    }
    return this.thumbnails;
  }

  public static final String SERIALIZED_NAME_SIZE = "size";

  @SerializedName(SERIALIZED_NAME_SIZE)
  

  private PostcardSize size = PostcardSize._4X6;
  /**
  * Get size
  * @return size
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public PostcardSize getSize() {
      return size;
  }
  
  

  public static final String SERIALIZED_NAME_EXPECTED_DELIVERY_DATE = "expected_delivery_date";

  @SerializedName(SERIALIZED_NAME_EXPECTED_DELIVERY_DATE)
  

  private LocalDate expectedDeliveryDate;
  /**
  * A date in YYYY-MM-DD format of the mailpiece's expected delivery date based on its `send_date`.
  * @return expectedDeliveryDate
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A date in YYYY-MM-DD format of the mailpiece's expected delivery date based on its `send_date`.")
  
  public LocalDate getExpectedDeliveryDate() {
      return expectedDeliveryDate;
  }
  
  

  public static final String SERIALIZED_NAME_DATE_CREATED = "date_created";

  @SerializedName(SERIALIZED_NAME_DATE_CREATED)
  

  private OffsetDateTime dateCreated;
  /**
  * A timestamp in ISO 8601 format of the date the resource was created.
  * @return dateCreated
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A timestamp in ISO 8601 format of the date the resource was created.")
  
  public OffsetDateTime getDateCreated() {
      return dateCreated;
  }
  
  

  public static final String SERIALIZED_NAME_DATE_MODIFIED = "date_modified";

  @SerializedName(SERIALIZED_NAME_DATE_MODIFIED)
  

  private OffsetDateTime dateModified;
  /**
  * A timestamp in ISO 8601 format of the date the resource was last modified.
  * @return dateModified
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A timestamp in ISO 8601 format of the date the resource was last modified.")
  
  public OffsetDateTime getDateModified() {
      return dateModified;
  }
  
  

  public static final String SERIALIZED_NAME_DELETED = "deleted";

  @SerializedName(SERIALIZED_NAME_DELETED)
  

  private Boolean deleted;
  /**
  * Only returned if the resource has been successfully deleted.
  * @return deleted
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Only returned if the resource has been successfully deleted.")
  
  public Boolean getDeleted() {
      return deleted;
  }
  
  

  public static final String SERIALIZED_NAME_FRONT_TEMPLATE_ID = "front_template_id";

  @SerializedName(SERIALIZED_NAME_FRONT_TEMPLATE_ID)
  

  private String frontTemplateId;
  /**
  * The unique ID of the HTML template used for the front of the postcard.
  * @return frontTemplateId
  **/
  
  @javax.annotation.Nullable
  
  public String getFrontTemplateId() { return frontTemplateId; }

  public void setFrontTemplateId (String frontTemplateId) throws IllegalArgumentException {
    if(!frontTemplateId.matches("^tmpl_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid front_template_id provided");
    }

    this.frontTemplateId = frontTemplateId;
  }
  
  

  public static final String SERIALIZED_NAME_BACK_TEMPLATE_ID = "back_template_id";

  @SerializedName(SERIALIZED_NAME_BACK_TEMPLATE_ID)
  

  private String backTemplateId;
  /**
  * The unique ID of the HTML template used for the back of the postcard.
  * @return backTemplateId
  **/
  
  @javax.annotation.Nullable
  
  public String getBackTemplateId() { return backTemplateId; }

  public void setBackTemplateId (String backTemplateId) throws IllegalArgumentException {
    if(!backTemplateId.matches("^tmpl_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid back_template_id provided");
    }

    this.backTemplateId = backTemplateId;
  }
  
  

  public static final String SERIALIZED_NAME_FRONT_TEMPLATE_VERSION_ID = "front_template_version_id";

  @SerializedName(SERIALIZED_NAME_FRONT_TEMPLATE_VERSION_ID)
  

  private String frontTemplateVersionId;
  /**
  * The unique ID of the specific version of the HTML template used for the front of the postcard.
  * @return frontTemplateVersionId
  **/
  
  @javax.annotation.Nullable
  
  public String getFrontTemplateVersionId() { return frontTemplateVersionId; }

  public void setFrontTemplateVersionId (String frontTemplateVersionId) throws IllegalArgumentException {
    if(!frontTemplateVersionId.matches("^vrsn_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid front_template_version_id provided");
    }

    this.frontTemplateVersionId = frontTemplateVersionId;
  }
  
  

  public static final String SERIALIZED_NAME_BACK_TEMPLATE_VERSION_ID = "back_template_version_id";

  @SerializedName(SERIALIZED_NAME_BACK_TEMPLATE_VERSION_ID)
  

  private String backTemplateVersionId;
  /**
  * The unique ID of the specific version of the HTML template used for the back of the postcard.
  * @return backTemplateVersionId
  **/
  
  @javax.annotation.Nullable
  
  public String getBackTemplateVersionId() { return backTemplateVersionId; }

  public void setBackTemplateVersionId (String backTemplateVersionId) throws IllegalArgumentException {
    if(!backTemplateVersionId.matches("^vrsn_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid back_template_version_id provided");
    }

    this.backTemplateVersionId = backTemplateVersionId;
  }
  
  

  public static final String SERIALIZED_NAME_TRACKING_EVENTS = "tracking_events";

  @SerializedName(SERIALIZED_NAME_TRACKING_EVENTS)
  private List<TrackingEventNormal> trackingEvents = null;
  public List<TrackingEventNormal> getTrackingEvents() {
    if (this.trackingEvents == null) {
      this.trackingEvents = new ArrayList<TrackingEventNormal>();
    }
    return this.trackingEvents;
  }

  /**
   * Gets or Sets _object
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    POSTCARD("postcard");

    private String value;

    ObjectEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ObjectEnum fromValue(String value) {
      for (ObjectEnum b : ObjectEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ObjectEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ObjectEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ObjectEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ObjectEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_OBJECT = "object";

  @SerializedName(SERIALIZED_NAME_OBJECT)
  

  private ObjectEnum _object = ObjectEnum.POSTCARD;
  /**
  * Get _object
  * @return _object
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public ObjectEnum getObject() {
      return _object;
  }
  
  

  public static final String SERIALIZED_NAME_URL = "url";

  @SerializedName(SERIALIZED_NAME_URL)
  

  private String url;
  /**
  * A [signed link](#section/Asset-URLs) served over HTTPS. The link returned will expire in 30 days to prevent mis-sharing. Each time a GET request is initiated, a new signed URL will be generated.
  * @return url
  **/
  
  @javax.annotation.Nonnull
  
  public String getUrl() { return url; }

  public void setUrl (String url) throws IllegalArgumentException {
    if(!url.matches("^https://(lob-assets|lob-assets-staging)\\.com/(letters|postcards|bank-accounts|checks|self-mailers|cards)/[a-z]{3,4}_[a-z0-9]{15,16}(\\.pdf|_thumb_[a-z]+_[0-9]+\\.png)\\?(version=[a-z0-9-]*&)?expires=[0-9]{10}&signature=[a-zA-Z0-9-_]+$")) {
      throw new IllegalArgumentException("Invalid url provided");
    }

    this.url = url;
  }
  
  

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";

  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  

  private String description;
  /**
  * An internal description that identifies this resource. Must be no longer than 255 characters. 
  * @return description
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "An internal description that identifies this resource. Must be no longer than 255 characters. ")
  
  public String getDescription() {
      return description;
  }
  
  

  public static final String SERIALIZED_NAME_METADATA = "metadata";

  @SerializedName(SERIALIZED_NAME_METADATA)
  private Map<String, String> metadata = null;
  public Map<String, String> getMetadata() {
    if (this.metadata == null) {
      this.metadata = new HashMap<String,String>();
    }
    return this.metadata;
  }

  public static final String SERIALIZED_NAME_MAIL_TYPE = "mail_type";

  @SerializedName(SERIALIZED_NAME_MAIL_TYPE)
  

  private MailType mailType = MailType.FIRST_CLASS;
  /**
  * Get mailType
  * @return mailType
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public MailType getMailType() {
      return mailType;
  }
  
  

  public static final String SERIALIZED_NAME_MERGE_VARIABLES = "merge_variables";

  @SerializedName(SERIALIZED_NAME_MERGE_VARIABLES)
  

  private Object mergeVariables;
  /**
  * You can input a merge variable payload object to your template to render dynamic content. For example, if you have a template like: `{{variable_name}}`, pass in `{\"variable_name\": \"Harry\"}` to render `Harry`. `merge_variables` must be an object. Any type of value is accepted as long as the object is valid JSON; you can use `strings`, `numbers`, `booleans`, `arrays`, `objects`, or `null`. The max length of the object is 25,000 characters. If you call `JSON.stringify` on your object, it can be no longer than 25,000 characters. Your variable names cannot contain any whitespace or any of the following special characters: `!`, `\"`, `#`, `%`, `&`, `'`, `(`, `)`, `*`, `+`, `,`, `/`, `;`, `<`, `=`, `>`, `@`, `[`, `\\`, `]`, `^`, `` ` ``, `{`, `|`, `}`, `~`. More instructions can be found in [our guide to using html and merge variables](https://lob.com/resources/guides/general/using-html-and-merge-variables). Depending on your [Merge Variable strictness](https://dashboard.lob.com/#/settings/account) setting, if you define variables in your HTML but do not pass them here, you will either receive an error or the variable will render as an empty string.
  * @return mergeVariables
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "You can input a merge variable payload object to your template to render dynamic content. For example, if you have a template like: `{{variable_name}}`, pass in `{\"variable_name\": \"Harry\"}` to render `Harry`. `merge_variables` must be an object. Any type of value is accepted as long as the object is valid JSON; you can use `strings`, `numbers`, `booleans`, `arrays`, `objects`, or `null`. The max length of the object is 25,000 characters. If you call `JSON.stringify` on your object, it can be no longer than 25,000 characters. Your variable names cannot contain any whitespace or any of the following special characters: `!`, `\"`, `#`, `%`, `&`, `'`, `(`, `)`, `*`, `+`, `,`, `/`, `;`, `<`, `=`, `>`, `@`, `[`, `\\`, `]`, `^`, `` ` ``, `{`, `|`, `}`, `~`. More instructions can be found in [our guide to using html and merge variables](https://lob.com/resources/guides/general/using-html-and-merge-variables). Depending on your [Merge Variable strictness](https://dashboard.lob.com/#/settings/account) setting, if you define variables in your HTML but do not pass them here, you will either receive an error or the variable will render as an empty string.")
  
  public Object getMergeVariables() {
      return mergeVariables;
  }
  
  

  public static final String SERIALIZED_NAME_SEND_DATE = "send_date";

  @SerializedName(SERIALIZED_NAME_SEND_DATE)
  

  private OffsetDateTime sendDate;
  /**
  * A timestamp in ISO 8601 format which specifies a date after the current time and up to 180 days in the future to send the letter off for production. Setting a send date overrides the default [cancellation window](#section/Cancellation-Windows) applied to the mailpiece. Until the `send_date` has passed, the mailpiece can be canceled. If a date in the format `2017-11-01` is passed, it will evaluate to midnight UTC of that date (`2017-11-01T00:00:00.000Z`). If a datetime is passed, that exact time will be used. A `send_date` passed with no time zone will default to UTC, while a `send_date` passed with a time zone will be converted to UTC.
  * @return sendDate
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A timestamp in ISO 8601 format which specifies a date after the current time and up to 180 days in the future to send the letter off for production. Setting a send date overrides the default [cancellation window](#section/Cancellation-Windows) applied to the mailpiece. Until the `send_date` has passed, the mailpiece can be canceled. If a date in the format `2017-11-01` is passed, it will evaluate to midnight UTC of that date (`2017-11-01T00:00:00.000Z`). If a datetime is passed, that exact time will be used. A `send_date` passed with no time zone will default to UTC, while a `send_date` passed with a time zone will be converted to UTC.")
  
  public OffsetDateTime getSendDate() {
      return sendDate;
  }
  
  

  public static final String SERIALIZED_NAME_USE_TYPE = "use_type";

  @SerializedName(SERIALIZED_NAME_USE_TYPE)
  

  private PscUseType useType;
  /**
  * Get useType
  * @return useType
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public PscUseType getUseType() {
      return useType;
  }
  
  


  /*
  public Postcard id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public Postcard to(Address to) {
    
    this.to = to;
    return this;
  }
  */


  public void setTo(Address to) {
    this.to = to;
  }



  /*
  public Postcard from(AddressDomesticExpanded from) {
    
    this.from = from;
    return this;
  }
  */


  public void setFrom(AddressDomesticExpanded from) {
    this.from = from;
  }



  /*
  public Postcard carrier(CarrierEnum carrier) {
    
    this.carrier = carrier;
    return this;
  }
  */


  public void setCarrier(CarrierEnum carrier) {
    this.carrier = carrier;
  }



  /*
  public Postcard thumbnails(List<Thumbnail> thumbnails) {
    
    this.thumbnails = thumbnails;
    return this;
  }
  */

  public Postcard addThumbnailsItem(Thumbnail thumbnailsItem) {
    if (this.thumbnails == null) {
      this.thumbnails = new ArrayList<Thumbnail>();
    }
    this.thumbnails.add(thumbnailsItem);
    return this;
  }


  public void setThumbnails(List<Thumbnail> thumbnails) {
    this.thumbnails = thumbnails;
  }



  /*
  public Postcard size(PostcardSize size) {
    
    this.size = size;
    return this;
  }
  */


  public void setSize(PostcardSize size) {
    this.size = size;
  }



  /*
  public Postcard expectedDeliveryDate(LocalDate expectedDeliveryDate) {
    
    this.expectedDeliveryDate = expectedDeliveryDate;
    return this;
  }
  */


  public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
    this.expectedDeliveryDate = expectedDeliveryDate;
  }



  /*
  public Postcard dateCreated(OffsetDateTime dateCreated) {
    
    this.dateCreated = dateCreated;
    return this;
  }
  */


  public void setDateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }



  /*
  public Postcard dateModified(OffsetDateTime dateModified) {
    
    this.dateModified = dateModified;
    return this;
  }
  */


  public void setDateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
  }



  /*
  public Postcard deleted(Boolean deleted) {
    
    this.deleted = deleted;
    return this;
  }
  */


  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }



  /*
  public Postcard frontTemplateId(String frontTemplateId) {
    
    this.frontTemplateId = frontTemplateId;
    return this;
  }
  */





  /*
  public Postcard backTemplateId(String backTemplateId) {
    
    this.backTemplateId = backTemplateId;
    return this;
  }
  */





  /*
  public Postcard frontTemplateVersionId(String frontTemplateVersionId) {
    
    this.frontTemplateVersionId = frontTemplateVersionId;
    return this;
  }
  */





  /*
  public Postcard backTemplateVersionId(String backTemplateVersionId) {
    
    this.backTemplateVersionId = backTemplateVersionId;
    return this;
  }
  */





  /*
  public Postcard trackingEvents(List<TrackingEventNormal> trackingEvents) {
    
    this.trackingEvents = trackingEvents;
    return this;
  }
  */

  public Postcard addTrackingEventsItem(TrackingEventNormal trackingEventsItem) {
    if (this.trackingEvents == null) {
      this.trackingEvents = new ArrayList<TrackingEventNormal>();
    }
    this.trackingEvents.add(trackingEventsItem);
    return this;
  }


  public void setTrackingEvents(List<TrackingEventNormal> trackingEvents) {
    this.trackingEvents = trackingEvents;
  }



  /*
  public Postcard _object(ObjectEnum _object) {
    
    this._object = _object;
    return this;
  }
  */


  public void setObject(ObjectEnum _object) {
    this._object = _object;
  }



  /*
  public Postcard url(String url) {
    
    this.url = url;
    return this;
  }
  */





  /*
  public Postcard description(String description) {
    
    this.description = description;
    return this;
  }
  */


  public void setDescription(String description) {
    this.description = description;
  }



  /*
  public Postcard metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }
  */

  public Postcard putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<String,String>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }


  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }



  /*
  public Postcard mailType(MailType mailType) {
    
    this.mailType = mailType;
    return this;
  }
  */


  public void setMailType(MailType mailType) {
    this.mailType = mailType;
  }



  /*
  public Postcard mergeVariables(Object mergeVariables) {
    
    this.mergeVariables = mergeVariables;
    return this;
  }
  */


  public void setMergeVariables(Object mergeVariables) {
    this.mergeVariables = mergeVariables;
  }



  /*
  public Postcard sendDate(OffsetDateTime sendDate) {
    
    this.sendDate = sendDate;
    return this;
  }
  */


  public void setSendDate(OffsetDateTime sendDate) {
    this.sendDate = sendDate;
  }



  /*
  public Postcard useType(PscUseType useType) {
    
    this.useType = useType;
    return this;
  }
  */


  public void setUseType(PscUseType useType) {
    this.useType = useType;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Postcard postcard = (Postcard) o;
    return Objects.equals(this.id, postcard.id) &&
        Objects.equals(this.to, postcard.to) &&
        Objects.equals(this.from, postcard.from) &&
        Objects.equals(this.carrier, postcard.carrier) &&
        Objects.equals(this.thumbnails, postcard.thumbnails) &&
        Objects.equals(this.size, postcard.size) &&
        Objects.equals(this.expectedDeliveryDate, postcard.expectedDeliveryDate) &&
        Objects.equals(this.dateCreated, postcard.dateCreated) &&
        Objects.equals(this.dateModified, postcard.dateModified) &&
        Objects.equals(this.deleted, postcard.deleted) &&
        Objects.equals(this.frontTemplateId, postcard.frontTemplateId) &&
        Objects.equals(this.backTemplateId, postcard.backTemplateId) &&
        Objects.equals(this.frontTemplateVersionId, postcard.frontTemplateVersionId) &&
        Objects.equals(this.backTemplateVersionId, postcard.backTemplateVersionId) &&
        Objects.equals(this.trackingEvents, postcard.trackingEvents) &&
        Objects.equals(this._object, postcard._object) &&
        Objects.equals(this.url, postcard.url) &&
        Objects.equals(this.description, postcard.description) &&
        Objects.equals(this.metadata, postcard.metadata) &&
        Objects.equals(this.mailType, postcard.mailType) &&
        Objects.equals(this.mergeVariables, postcard.mergeVariables) &&
        Objects.equals(this.sendDate, postcard.sendDate) &&
        Objects.equals(this.useType, postcard.useType);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, to, from, carrier, thumbnails, size, expectedDeliveryDate, dateCreated, dateModified, deleted, frontTemplateId, backTemplateId, frontTemplateVersionId, backTemplateVersionId, trackingEvents, _object, url, description, metadata, mailType, mergeVariables, sendDate, useType);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    carrier: ").append(toIndentedString(carrier)).append("\n");
    sb.append("    thumbnails: ").append(toIndentedString(thumbnails)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    expectedDeliveryDate: ").append(toIndentedString(expectedDeliveryDate)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    frontTemplateId: ").append(toIndentedString(frontTemplateId)).append("\n");
    sb.append("    backTemplateId: ").append(toIndentedString(backTemplateId)).append("\n");
    sb.append("    frontTemplateVersionId: ").append(toIndentedString(frontTemplateVersionId)).append("\n");
    sb.append("    backTemplateVersionId: ").append(toIndentedString(backTemplateVersionId)).append("\n");
    sb.append("    trackingEvents: ").append(toIndentedString(trackingEvents)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    mailType: ").append(toIndentedString(mailType)).append("\n");
    sb.append("    mergeVariables: ").append(toIndentedString(mergeVariables)).append("\n");
    sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
    sb.append("    useType: ").append(toIndentedString(useType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("id", id);
      localMap.put("to", to);
      localMap.put("from", from);
      localMap.put("carrier", carrier);
      localMap.put("thumbnails", thumbnails);
      localMap.put("size", size);
      localMap.put("expected_delivery_date", expectedDeliveryDate);
      localMap.put("date_created", dateCreated);
      localMap.put("date_modified", dateModified);
      localMap.put("deleted", deleted);
      localMap.put("front_template_id", frontTemplateId);
      localMap.put("back_template_id", backTemplateId);
      localMap.put("front_template_version_id", frontTemplateVersionId);
      localMap.put("back_template_version_id", backTemplateVersionId);
      localMap.put("tracking_events", trackingEvents);
      localMap.put("object", _object);
      localMap.put("url", url);
      localMap.put("description", description);
      localMap.put("metadata", metadata);
      localMap.put("mail_type", mailType);
      localMap.put("merge_variables", mergeVariables);
      localMap.put("send_date", sendDate);
      localMap.put("use_type", useType);
      return localMap;
    }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

