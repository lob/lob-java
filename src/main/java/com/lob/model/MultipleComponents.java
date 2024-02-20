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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * MultipleComponents
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MultipleComponents {
  public static final String SERIALIZED_NAME_RECIPIENT = "recipient";

  @SerializedName(SERIALIZED_NAME_RECIPIENT)
  

  private String recipient;
  /**
  * The intended recipient, typically a person's or firm's name.
  * @return recipient
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The intended recipient, typically a person's or firm's name.")
  
  public String getRecipient() {
      return recipient;
  }
  
  

  public static final String SERIALIZED_NAME_PRIMARY_LINE = "primary_line";

  @SerializedName(SERIALIZED_NAME_PRIMARY_LINE)
  

  private String primaryLine;
  /**
  * The primary delivery line (usually the street address) of the address. Combination of the following applicable `components`: * `primary_number` * `street_predirection` * `street_name` * `street_suffix` * `street_postdirection` * `secondary_designator` * `secondary_number` * `pmb_designator` * `pmb_number` 
  * @return primaryLine
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "The primary delivery line (usually the street address) of the address. Combination of the following applicable `components`: * `primary_number` * `street_predirection` * `street_name` * `street_suffix` * `street_postdirection` * `secondary_designator` * `secondary_number` * `pmb_designator` * `pmb_number` ")
  
  public String getPrimaryLine() {
      return primaryLine;
  }
  
  

  public static final String SERIALIZED_NAME_SECONDARY_LINE = "secondary_line";

  @SerializedName(SERIALIZED_NAME_SECONDARY_LINE)
  

  private String secondaryLine;
  /**
  * The secondary delivery line of the address. This field is typically empty but may contain information if `primary_line` is too long. 
  * @return secondaryLine
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The secondary delivery line of the address. This field is typically empty but may contain information if `primary_line` is too long. ")
  
  public String getSecondaryLine() {
      return secondaryLine;
  }
  
  

  public static final String SERIALIZED_NAME_URBANIZATION = "urbanization";

  @SerializedName(SERIALIZED_NAME_URBANIZATION)
  

  private String urbanization;
  /**
  * Only present for addresses in Puerto Rico. An urbanization refers to an area, sector, or development within a city. See [USPS documentation](https://pe.usps.com/text/pub28/28api_008.htm#:~:text=I51.,-4%20Urbanizations&text=In%20Puerto%20Rico%2C%20identical%20street,placed%20before%20the%20urbanization%20name.) for clarification. 
  * @return urbanization
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Only present for addresses in Puerto Rico. An urbanization refers to an area, sector, or development within a city. See [USPS documentation](https://pe.usps.com/text/pub28/28api_008.htm#:~:text=I51.,-4%20Urbanizations&text=In%20Puerto%20Rico%2C%20identical%20street,placed%20before%20the%20urbanization%20name.) for clarification. ")
  
  public String getUrbanization() {
      return urbanization;
  }
  
  

  public static final String SERIALIZED_NAME_CITY = "city";

  @SerializedName(SERIALIZED_NAME_CITY)
  

  private String city;
  /**
  * Get city
  * @return city
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public String getCity() {
      return city;
  }
  
  

  public static final String SERIALIZED_NAME_STATE = "state";

  @SerializedName(SERIALIZED_NAME_STATE)
  

  private String state;
  /**
  * The [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2:US) two letter code or subdivision name for the state. `city` and `state` are required if no `zip_code` is passed.
  * @return state
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2:US) two letter code or subdivision name for the state. `city` and `state` are required if no `zip_code` is passed.")
  
  public String getState() {
      return state;
  }
  
  

  public static final String SERIALIZED_NAME_ZIP_CODE = "zip_code";

  @SerializedName(SERIALIZED_NAME_ZIP_CODE)
  

  private String zipCode;
  /**
  * Required if `city` and `state` are not passed in. If included, must be formatted as a US ZIP or ZIP+4 (e.g. `94107`, `941072282`, `94107-2282`).
  * @return zipCode
  **/
  
  @javax.annotation.Nullable
  
  public String getZipCode() { return zipCode; }

  public void setZipCode (String zipCode) throws IllegalArgumentException {
    if(!zipCode.matches("^\\d{5}((-)?\\d{4})?$")) {
      throw new IllegalArgumentException("Invalid zip_code provided");
    }

    this.zipCode = zipCode;
  }
  
  

  public static final String SERIALIZED_NAME_TRANSIENT_ID = "transient_id";

  @SerializedName(SERIALIZED_NAME_TRANSIENT_ID)
  

  private String transientId;
  /**
  * ID that is returned in the response body for the verification 
  * @return transientId
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "ID that is returned in the response body for the verification ")
  
  public String getTransientId() {
      return transientId;
  }
  
  


  /*
  public MultipleComponents recipient(String recipient) {
    
    this.recipient = recipient;
    return this;
  }
  */


  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }



  /*
  public MultipleComponents primaryLine(String primaryLine) {
    
    this.primaryLine = primaryLine;
    return this;
  }
  */


  public void setPrimaryLine(String primaryLine) {
    this.primaryLine = primaryLine;
  }



  /*
  public MultipleComponents secondaryLine(String secondaryLine) {
    
    this.secondaryLine = secondaryLine;
    return this;
  }
  */


  public void setSecondaryLine(String secondaryLine) {
    this.secondaryLine = secondaryLine;
  }



  /*
  public MultipleComponents urbanization(String urbanization) {
    
    this.urbanization = urbanization;
    return this;
  }
  */


  public void setUrbanization(String urbanization) {
    this.urbanization = urbanization;
  }



  /*
  public MultipleComponents city(String city) {
    
    this.city = city;
    return this;
  }
  */


  public void setCity(String city) {
    this.city = city;
  }



  /*
  public MultipleComponents state(String state) {
    
    this.state = state;
    return this;
  }
  */


  public void setState(String state) {
    this.state = state;
  }



  /*
  public MultipleComponents zipCode(String zipCode) {
    
    this.zipCode = zipCode;
    return this;
  }
  */





  /*
  public MultipleComponents transientId(String transientId) {
    
    this.transientId = transientId;
    return this;
  }
  */


  public void setTransientId(String transientId) {
    this.transientId = transientId;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MultipleComponents multipleComponents = (MultipleComponents) o;
    return Objects.equals(this.recipient, multipleComponents.recipient) &&
        Objects.equals(this.primaryLine, multipleComponents.primaryLine) &&
        Objects.equals(this.secondaryLine, multipleComponents.secondaryLine) &&
        Objects.equals(this.urbanization, multipleComponents.urbanization) &&
        Objects.equals(this.city, multipleComponents.city) &&
        Objects.equals(this.state, multipleComponents.state) &&
        Objects.equals(this.zipCode, multipleComponents.zipCode) &&
        Objects.equals(this.transientId, multipleComponents.transientId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipient, primaryLine, secondaryLine, urbanization, city, state, zipCode, transientId);
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
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    primaryLine: ").append(toIndentedString(primaryLine)).append("\n");
    sb.append("    secondaryLine: ").append(toIndentedString(secondaryLine)).append("\n");
    sb.append("    urbanization: ").append(toIndentedString(urbanization)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    transientId: ").append(toIndentedString(transientId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("recipient", recipient);
      localMap.put("primary_line", primaryLine);
      localMap.put("secondary_line", secondaryLine);
      localMap.put("urbanization", urbanization);
      localMap.put("city", city);
      localMap.put("state", state);
      localMap.put("zip_code", zipCode);
      localMap.put("transient_id", transientId);
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

