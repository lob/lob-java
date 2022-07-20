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
import com.lob.model.MailType;
import com.lob.model.SelfMailerSize;
import com.lob.model.TrackingEventCertified;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
/**
 * SelfMailer
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SelfMailer {
  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `sfm_`.
  * @return id
  **/
  
  @javax.annotation.Nonnull
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^sfm_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_TO = "to";

  @SerializedName(SERIALIZED_NAME_TO)
  
  private String to;
  public  String getTo() {
    return to;
  }

  public void setTo(String to) {
    
    this.to = to;
  }
  
  
  public void setTo(Address to) {
    Gson gson = new Gson();
    this.to = gson.toJson(to);
  }
  public static final String SERIALIZED_NAME_FROM = "from";

  @SerializedName(SERIALIZED_NAME_FROM)
  
  private String from;
  public  String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    
    this.from = from;
  }
  
  
  public void setFrom(Address from) {
    Gson gson = new Gson();
    this.from = gson.toJson(from);
  }
  public static final String SERIALIZED_NAME_SIZE = "size";

  @SerializedName(SERIALIZED_NAME_SIZE)
  

  private SelfMailerSize size = SelfMailerSize._6X18_BIFOLD;
  /**
  * Get size
  * @return size
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public SelfMailerSize getSize() {
      return size;
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
  
  

  public static final String SERIALIZED_NAME_OUTSIDE_TEMPLATE_ID = "outside_template_id";

  @SerializedName(SERIALIZED_NAME_OUTSIDE_TEMPLATE_ID)
  

  private String outsideTemplateId;
  /**
  * The unique ID of the HTML template used for the outside of the self mailer.
  * @return outsideTemplateId
  **/
  
  @javax.annotation.Nullable
  
  public String getOutsideTemplateId() { return outsideTemplateId; }

  public void setOutsideTemplateId (String outsideTemplateId) throws IllegalArgumentException {
    if(!outsideTemplateId.matches("^tmpl_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid outside_template_id provided");
    }

    this.outsideTemplateId = outsideTemplateId;
  }
  
  

  public static final String SERIALIZED_NAME_INSIDE_TEMPLATE_ID = "inside_template_id";

  @SerializedName(SERIALIZED_NAME_INSIDE_TEMPLATE_ID)
  

  private String insideTemplateId;
  /**
  * The unique ID of the HTML template used for the inside of the self mailer.
  * @return insideTemplateId
  **/
  
  @javax.annotation.Nullable
  
  public String getInsideTemplateId() { return insideTemplateId; }

  public void setInsideTemplateId (String insideTemplateId) throws IllegalArgumentException {
    if(!insideTemplateId.matches("^tmpl_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid inside_template_id provided");
    }

    this.insideTemplateId = insideTemplateId;
  }
  
  

  public static final String SERIALIZED_NAME_OUTSIDE_TEMPLATE_VERSION_ID = "outside_template_version_id";

  @SerializedName(SERIALIZED_NAME_OUTSIDE_TEMPLATE_VERSION_ID)
  

  private String outsideTemplateVersionId;
  /**
  * The unique ID of the specific version of the HTML template used for the outside of the self mailer.
  * @return outsideTemplateVersionId
  **/
  
  @javax.annotation.Nullable
  
  public String getOutsideTemplateVersionId() { return outsideTemplateVersionId; }

  public void setOutsideTemplateVersionId (String outsideTemplateVersionId) throws IllegalArgumentException {
    if(!outsideTemplateVersionId.matches("^vrsn_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid outside_template_version_id provided");
    }

    this.outsideTemplateVersionId = outsideTemplateVersionId;
  }
  
  

  public static final String SERIALIZED_NAME_INSIDE_TEMPLATE_VERSION_ID = "inside_template_version_id";

  @SerializedName(SERIALIZED_NAME_INSIDE_TEMPLATE_VERSION_ID)
  

  private String insideTemplateVersionId;
  /**
  * The unique ID of the specific version of the HTML template used for the inside of the self mailer.
  * @return insideTemplateVersionId
  **/
  
  @javax.annotation.Nullable
  
  public String getInsideTemplateVersionId() { return insideTemplateVersionId; }

  public void setInsideTemplateVersionId (String insideTemplateVersionId) throws IllegalArgumentException {
    if(!insideTemplateVersionId.matches("^vrsn_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid inside_template_version_id provided");
    }

    this.insideTemplateVersionId = insideTemplateVersionId;
  }
  
  

  /**
   * Value is resource type.
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    SELF_MAILER("self_mailer");

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
  

  private ObjectEnum _object = ObjectEnum.SELF_MAILER;
  /**
  * Value is resource type.
  * @return _object
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Value is resource type.")
  
  public ObjectEnum getObject() {
      return _object;
  }
  
  

  public static final String SERIALIZED_NAME_TRACKING_EVENTS = "tracking_events";

  @SerializedName(SERIALIZED_NAME_TRACKING_EVENTS)
  private List<TrackingEventCertified> trackingEvents = null;
  public List<TrackingEventCertified> getTrackingEvents() {     
    if (this.trackingEvents == null) {
      this.trackingEvents = new ArrayList<TrackingEventCertified>();
    }
    return this.trackingEvents; 
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
  
  


  /*
  public SelfMailer id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public SelfMailer to(String to) {
    
    this.to = to;
    return this;
  }
  */





  /*
  public SelfMailer from(String from) {
    
    this.from = from;
    return this;
  }
  */





  /*
  public SelfMailer size(SelfMailerSize size) {
    
    this.size = size;
    return this;
  }
  */


  public void setSize(SelfMailerSize size) {
    this.size = size;
  }



  /*
  public SelfMailer description(String description) {
    
    this.description = description;
    return this;
  }
  */


  public void setDescription(String description) {
    this.description = description;
  }



  /*
  public SelfMailer metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }
  */

  public SelfMailer putMetadataItem(String key, String metadataItem) {
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
  public SelfMailer mailType(MailType mailType) {
    
    this.mailType = mailType;
    return this;
  }
  */


  public void setMailType(MailType mailType) {
    this.mailType = mailType;
  }



  /*
  public SelfMailer mergeVariables(Object mergeVariables) {
    
    this.mergeVariables = mergeVariables;
    return this;
  }
  */


  public void setMergeVariables(Object mergeVariables) {
    this.mergeVariables = mergeVariables;
  }



  /*
  public SelfMailer sendDate(OffsetDateTime sendDate) {
    
    this.sendDate = sendDate;
    return this;
  }
  */


  public void setSendDate(OffsetDateTime sendDate) {
    this.sendDate = sendDate;
  }



  /*
  public SelfMailer outsideTemplateId(String outsideTemplateId) {
    
    this.outsideTemplateId = outsideTemplateId;
    return this;
  }
  */





  /*
  public SelfMailer insideTemplateId(String insideTemplateId) {
    
    this.insideTemplateId = insideTemplateId;
    return this;
  }
  */





  /*
  public SelfMailer outsideTemplateVersionId(String outsideTemplateVersionId) {
    
    this.outsideTemplateVersionId = outsideTemplateVersionId;
    return this;
  }
  */





  /*
  public SelfMailer insideTemplateVersionId(String insideTemplateVersionId) {
    
    this.insideTemplateVersionId = insideTemplateVersionId;
    return this;
  }
  */





  /*
  public SelfMailer _object(ObjectEnum _object) {
    
    this._object = _object;
    return this;
  }
  */


  public void setObject(ObjectEnum _object) {
    this._object = _object;
  }



  /*
  public SelfMailer trackingEvents(List<TrackingEventCertified> trackingEvents) {
    
    this.trackingEvents = trackingEvents;
    return this;
  }
  */

  public SelfMailer addTrackingEventsItem(TrackingEventCertified trackingEventsItem) {
    if (this.trackingEvents == null) {
      this.trackingEvents = new ArrayList<TrackingEventCertified>();
    }
    this.trackingEvents.add(trackingEventsItem);
    return this;
  }


  public void setTrackingEvents(List<TrackingEventCertified> trackingEvents) {
    this.trackingEvents = trackingEvents;
  }



  /*
  public SelfMailer url(String url) {
    
    this.url = url;
    return this;
  }
  */





  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelfMailer selfMailer = (SelfMailer) o;
    return Objects.equals(this.id, selfMailer.id) &&
        Objects.equals(this.to, selfMailer.to) &&
        Objects.equals(this.from, selfMailer.from) &&
        Objects.equals(this.size, selfMailer.size) &&
        Objects.equals(this.description, selfMailer.description) &&
        Objects.equals(this.metadata, selfMailer.metadata) &&
        Objects.equals(this.mailType, selfMailer.mailType) &&
        Objects.equals(this.mergeVariables, selfMailer.mergeVariables) &&
        Objects.equals(this.sendDate, selfMailer.sendDate) &&
        Objects.equals(this.outsideTemplateId, selfMailer.outsideTemplateId) &&
        Objects.equals(this.insideTemplateId, selfMailer.insideTemplateId) &&
        Objects.equals(this.outsideTemplateVersionId, selfMailer.outsideTemplateVersionId) &&
        Objects.equals(this.insideTemplateVersionId, selfMailer.insideTemplateVersionId) &&
        Objects.equals(this._object, selfMailer._object) &&
        Objects.equals(this.trackingEvents, selfMailer.trackingEvents) &&
        Objects.equals(this.url, selfMailer.url);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, to, from, size, description, metadata, mailType, mergeVariables, sendDate, outsideTemplateId, insideTemplateId, outsideTemplateVersionId, insideTemplateVersionId, _object, trackingEvents, url);
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
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    mailType: ").append(toIndentedString(mailType)).append("\n");
    sb.append("    mergeVariables: ").append(toIndentedString(mergeVariables)).append("\n");
    sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
    sb.append("    outsideTemplateId: ").append(toIndentedString(outsideTemplateId)).append("\n");
    sb.append("    insideTemplateId: ").append(toIndentedString(insideTemplateId)).append("\n");
    sb.append("    outsideTemplateVersionId: ").append(toIndentedString(outsideTemplateVersionId)).append("\n");
    sb.append("    insideTemplateVersionId: ").append(toIndentedString(insideTemplateVersionId)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    trackingEvents: ").append(toIndentedString(trackingEvents)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("}");
    return sb.toString();
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

