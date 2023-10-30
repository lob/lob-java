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
import com.lob.model.TrackingEventDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * TrackingEventCertified
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TrackingEventCertified {
  /**
   * a Certified letter tracking event
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    CERTIFIED("certified");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";

  @SerializedName(SERIALIZED_NAME_TYPE)
  

  private TypeEnum type;
  /**
  * a Certified letter tracking event
  * @return type
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "a Certified letter tracking event")
  
  public TypeEnum getType() {
      return type;
  }
  
  

  /**
   * Name of tracking event for Certified letters. Letters sent with USPS Certified Mail are fully tracked by USPS, therefore their tracking events have an additional details object with more detailed information about the tracking event. Some certified tracking event names have multiple meanings, noted in the list here. See the description of the details object for the full set of combined certified tracking event name meanings.    * &#x60;Mailed&#x60; - Package has been accepted into the carrier network for delivery.    * &#x60;In Transit&#x60; - Maps to four distinct stages of transit.    * &#x60;In Local Area&#x60; - Package is at a location near the end destination.    * &#x60;Processed for Delivery&#x60; - Maps to two distinct stages of delivery.    * &#x60;Pickup Available&#x60; - Package is available for pickup at carrier location.    * &#x60;Delivered&#x60; - Package has been delivered.    * &#x60;Re-Routed&#x60; - Package has been forwarded.    * &#x60;Returned to Sender&#x60; - Package is to be returned to sender.    * &#x60;Issue&#x60; - Maps to (at least) 15 possible issues, some of which are actionable. 
   */
  @JsonAdapter(NameEnum.Adapter.class)
  public enum NameEnum {
    MAILED("Mailed"),
    
    IN_TRANSIT("In Transit"),
    
    IN_LOCAL_AREA("In Local Area"),
    
    PROCESSED_FOR_DELIVERY("Processed for Delivery"),
    
    PICKUP_AVAILABLE("Pickup Available"),
    
    DELIVERED("Delivered"),
    
    RE_ROUTED("Re-Routed"),
    
    RETURNED_TO_SENDER("Returned to Sender"),
    
    ISSUE("Issue");

    private String value;

    NameEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static NameEnum fromValue(String value) {
      for (NameEnum b : NameEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<NameEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final NameEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public NameEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return NameEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_NAME = "name";

  @SerializedName(SERIALIZED_NAME_NAME)
  

  private NameEnum name;
  /**
  * Name of tracking event for Certified letters. Letters sent with USPS Certified Mail are fully tracked by USPS, therefore their tracking events have an additional details object with more detailed information about the tracking event. Some certified tracking event names have multiple meanings, noted in the list here. See the description of the details object for the full set of combined certified tracking event name meanings.    * `Mailed` - Package has been accepted into the carrier network for delivery.    * `In Transit` - Maps to four distinct stages of transit.    * `In Local Area` - Package is at a location near the end destination.    * `Processed for Delivery` - Maps to two distinct stages of delivery.    * `Pickup Available` - Package is available for pickup at carrier location.    * `Delivered` - Package has been delivered.    * `Re-Routed` - Package has been forwarded.    * `Returned to Sender` - Package is to be returned to sender.    * `Issue` - Maps to (at least) 15 possible issues, some of which are actionable. 
  * @return name
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "Name of tracking event for Certified letters. Letters sent with USPS Certified Mail are fully tracked by USPS, therefore their tracking events have an additional details object with more detailed information about the tracking event. Some certified tracking event names have multiple meanings, noted in the list here. See the description of the details object for the full set of combined certified tracking event name meanings.    * `Mailed` - Package has been accepted into the carrier network for delivery.    * `In Transit` - Maps to four distinct stages of transit.    * `In Local Area` - Package is at a location near the end destination.    * `Processed for Delivery` - Maps to two distinct stages of delivery.    * `Pickup Available` - Package is available for pickup at carrier location.    * `Delivered` - Package has been delivered.    * `Re-Routed` - Package has been forwarded.    * `Returned to Sender` - Package is to be returned to sender.    * `Issue` - Maps to (at least) 15 possible issues, some of which are actionable. ")
  
  public NameEnum getName() {
      return name;
  }
  
  

  public static final String SERIALIZED_NAME_DETAILS = "details";

  @SerializedName(SERIALIZED_NAME_DETAILS)
  

  private TrackingEventDetails details;
  /**
  * Get details
  * @return details
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public TrackingEventDetails getDetails() {
      return details;
  }
  
  

  public static final String SERIALIZED_NAME_LOCATION = "location";

  @SerializedName(SERIALIZED_NAME_LOCATION)
  

  private String location;
  /**
  * The zip code in which the event occurred if it exists, otherwise will be the name of a Regional Distribution Center if it exists, otherwise will be null. 
  * @return location
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The zip code in which the event occurred if it exists, otherwise will be the name of a Regional Distribution Center if it exists, otherwise will be null. ")
  
  public String getLocation() {
      return location;
  }
  
  

  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `evnt_`.
  * @return id
  **/
  
  @javax.annotation.Nonnull
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^evnt_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_TIME = "time";

  @SerializedName(SERIALIZED_NAME_TIME)
  

  private OffsetDateTime time;
  /**
  * A timestamp in ISO 8601 format of the date USPS registered the event.
  * @return time
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A timestamp in ISO 8601 format of the date USPS registered the event.")
  
  public OffsetDateTime getTime() {
      return time;
  }
  
  

  public static final String SERIALIZED_NAME_DATE_CREATED = "date_created";

  @SerializedName(SERIALIZED_NAME_DATE_CREATED)
  

  private OffsetDateTime dateCreated;
  /**
  * A timestamp in ISO 8601 format of the date the resource was created.
  * @return dateCreated
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "A timestamp in ISO 8601 format of the date the resource was created.")
  
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
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "A timestamp in ISO 8601 format of the date the resource was last modified.")
  
  public OffsetDateTime getDateModified() {
      return dateModified;
  }
  
  

  /**
   * Gets or Sets _object
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    TRACKING_EVENT("tracking_event");

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
  

  private ObjectEnum _object = ObjectEnum.TRACKING_EVENT;
  /**
  * Get _object
  * @return _object
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "")
  
  public ObjectEnum getObject() {
      return _object;
  }
  
  


  /*
  public TrackingEventCertified type(TypeEnum type) {
    
    this.type = type;
    return this;
  }
  */


  public void setType(TypeEnum type) {
    this.type = type;
  }



  /*
  public TrackingEventCertified name(NameEnum name) {
    
    this.name = name;
    return this;
  }
  */


  public void setName(NameEnum name) {
    this.name = name;
  }



  /*
  public TrackingEventCertified details(TrackingEventDetails details) {
    
    this.details = details;
    return this;
  }
  */


  public void setDetails(TrackingEventDetails details) {
    this.details = details;
  }



  /*
  public TrackingEventCertified location(String location) {
    
    this.location = location;
    return this;
  }
  */


  public void setLocation(String location) {
    this.location = location;
  }



  /*
  public TrackingEventCertified id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public TrackingEventCertified time(OffsetDateTime time) {
    
    this.time = time;
    return this;
  }
  */


  public void setTime(OffsetDateTime time) {
    this.time = time;
  }



  /*
  public TrackingEventCertified dateCreated(OffsetDateTime dateCreated) {
    
    this.dateCreated = dateCreated;
    return this;
  }
  */


  public void setDateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }



  /*
  public TrackingEventCertified dateModified(OffsetDateTime dateModified) {
    
    this.dateModified = dateModified;
    return this;
  }
  */


  public void setDateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
  }



  /*
  public TrackingEventCertified _object(ObjectEnum _object) {
    
    this._object = _object;
    return this;
  }
  */


  public void setObject(ObjectEnum _object) {
    this._object = _object;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrackingEventCertified trackingEventCertified = (TrackingEventCertified) o;
    return Objects.equals(this.type, trackingEventCertified.type) &&
        Objects.equals(this.name, trackingEventCertified.name) &&
        Objects.equals(this.details, trackingEventCertified.details) &&
        Objects.equals(this.location, trackingEventCertified.location) &&
        Objects.equals(this.id, trackingEventCertified.id) &&
        Objects.equals(this.time, trackingEventCertified.time) &&
        Objects.equals(this.dateCreated, trackingEventCertified.dateCreated) &&
        Objects.equals(this.dateModified, trackingEventCertified.dateModified) &&
        Objects.equals(this._object, trackingEventCertified._object);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, name, details, location, id, time, dateCreated, dateModified, _object);
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
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("type", type);
      localMap.put("name", name);
      localMap.put("details", details);
      localMap.put("location", location);
      localMap.put("id", id);
      localMap.put("time", time);
      localMap.put("date_created", dateCreated);
      localMap.put("date_modified", dateModified);
      localMap.put("object", _object);
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

