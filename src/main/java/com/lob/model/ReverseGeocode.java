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
import com.lob.model.GeocodeAddresses;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
/**
 * ReverseGeocode
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ReverseGeocode {
  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `us_reverse_geocode_`.
  * @return id
  **/
  
  @javax.annotation.Nullable
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^us_reverse_geocode_[a-zA-Z0-9_]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_ADDRESSES = "addresses";

  @SerializedName(SERIALIZED_NAME_ADDRESSES)
  private List<GeocodeAddresses> addresses = null;
  public List<GeocodeAddresses> getAddresses() {     
    if (this.addresses == null) {
      this.addresses = new ArrayList<GeocodeAddresses>();
    }
    return this.addresses; 
  }

  /**
   * Value is resource type.
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    US_REVERSE_GEOCODE_LOOKUP("us_reverse_geocode_lookup");

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
  

  private ObjectEnum _object = ObjectEnum.US_REVERSE_GEOCODE_LOOKUP;
  /**
  * Value is resource type.
  * @return _object
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Value is resource type.")
  
  public ObjectEnum getObject() {
      return _object;
  }
  
  


  /*
  public ReverseGeocode id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public ReverseGeocode addresses(List<GeocodeAddresses> addresses) {
    
    this.addresses = addresses;
    return this;
  }
  */

  public ReverseGeocode addAddressesItem(GeocodeAddresses addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<GeocodeAddresses>();
    }
    this.addresses.add(addressesItem);
    return this;
  }


  public void setAddresses(List<GeocodeAddresses> addresses) {
    this.addresses = addresses;
  }



  /*
  public ReverseGeocode _object(ObjectEnum _object) {
    
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
    ReverseGeocode reverseGeocode = (ReverseGeocode) o;
    return Objects.equals(this.id, reverseGeocode.id) &&
        Objects.equals(this.addresses, reverseGeocode.addresses) &&
        Objects.equals(this._object, reverseGeocode._object);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, addresses, _object);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
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

