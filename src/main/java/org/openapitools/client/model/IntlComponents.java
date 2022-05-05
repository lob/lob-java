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


package org.openapitools.client.model;

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

/**
 * A nested object containing a breakdown of each component of an address.
 */
@ApiModel(description = "A nested object containing a breakdown of each component of an address.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IntlComponents {
  public static final String SERIALIZED_NAME_PRIMARY_NUMBER = "primary_number";

  @SerializedName(SERIALIZED_NAME_PRIMARY_NUMBER)
  

  private String primaryNumber;

  /**
  * The numeric or alphanumeric part of an address preceding the street name. Often the house, building, or PO Box number.
  * @return primaryNumber
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The numeric or alphanumeric part of an address preceding the street name. Often the house, building, or PO Box number.")
  
  public String getPrimaryNumber() {
      return primaryNumber;
  }
  
  

  public static final String SERIALIZED_NAME_STREET_NAME = "street_name";

  @SerializedName(SERIALIZED_NAME_STREET_NAME)
  

  private String streetName;

  /**
  * The name of the street.
  * @return streetName
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The name of the street.")
  
  public String getStreetName() {
      return streetName;
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
  * The [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2) two letter code for the state. 
  * @return state
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2) two letter code for the state. ")
  
  public String getState() {
      return state;
  }
  
  

  public static final String SERIALIZED_NAME_POSTAL_CODE = "postal_code";

  @SerializedName(SERIALIZED_NAME_POSTAL_CODE)
  

  private String postalCode;

  /**
  * The postal code.
  * @return postalCode
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The postal code.")
  
  public String getPostalCode() {
      return postalCode;
  }
  
  


  /*
  public IntlComponents primaryNumber(String primaryNumber) {
    
    this.primaryNumber = primaryNumber;
    return this;
  }
  */


  public void setPrimaryNumber(String primaryNumber) {
    this.primaryNumber = primaryNumber;
  }



  /*
  public IntlComponents streetName(String streetName) {
    
    this.streetName = streetName;
    return this;
  }
  */


  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }



  /*
  public IntlComponents city(String city) {
    
    this.city = city;
    return this;
  }
  */


  public void setCity(String city) {
    this.city = city;
  }



  /*
  public IntlComponents state(String state) {
    
    this.state = state;
    return this;
  }
  */


  public void setState(String state) {
    this.state = state;
  }



  /*
  public IntlComponents postalCode(String postalCode) {
    
    this.postalCode = postalCode;
    return this;
  }
  */


  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntlComponents intlComponents = (IntlComponents) o;
    return Objects.equals(this.primaryNumber, intlComponents.primaryNumber) &&
        Objects.equals(this.streetName, intlComponents.streetName) &&
        Objects.equals(this.city, intlComponents.city) &&
        Objects.equals(this.state, intlComponents.state) &&
        Objects.equals(this.postalCode, intlComponents.postalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(primaryNumber, streetName, city, state, postalCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    primaryNumber: ").append(toIndentedString(primaryNumber)).append("\n");
    sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
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

