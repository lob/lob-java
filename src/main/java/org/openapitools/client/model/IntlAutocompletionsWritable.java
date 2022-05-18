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
import org.openapitools.client.model.CountryExtended;

/**
 * IntlAutocompletionsWritable
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IntlAutocompletionsWritable {
  public static final String SERIALIZED_NAME_ADDRESS_PREFIX = "address_prefix";

  @SerializedName(SERIALIZED_NAME_ADDRESS_PREFIX)
  

  private String addressPrefix;
  /**
  * Only accepts numbers and street names in an alphanumeric format. 
  * @return addressPrefix
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Only accepts numbers and street names in an alphanumeric format. ")
  
  public String getAddressPrefix() {
      return addressPrefix;
  }
  
  

  public static final String SERIALIZED_NAME_CITY = "city";

  @SerializedName(SERIALIZED_NAME_CITY)
  

  private String city;
  /**
  * An optional city input used to filter suggestions. Case insensitive and does not match partial abbreviations. 
  * @return city
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "An optional city input used to filter suggestions. Case insensitive and does not match partial abbreviations. ")
  
  public String getCity() {
      return city;
  }
  
  

  public static final String SERIALIZED_NAME_STATE = "state";

  @SerializedName(SERIALIZED_NAME_STATE)
  

  private String state;
  /**
  * An optional state input used to filter suggestions. Case insensitive and does not match partial abbreviations. 
  * @return state
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "An optional state input used to filter suggestions. Case insensitive and does not match partial abbreviations. ")
  
  public String getState() {
      return state;
  }
  
  

  public static final String SERIALIZED_NAME_ZIP_CODE = "zip_code";

  @SerializedName(SERIALIZED_NAME_ZIP_CODE)
  

  private String zipCode;
  /**
  * An optional Zip Code input used to filter suggestions. Matches partial entries. 
  * @return zipCode
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "An optional Zip Code input used to filter suggestions. Matches partial entries. ")
  
  public String getZipCode() {
      return zipCode;
  }
  
  

  public static final String SERIALIZED_NAME_COUNTRY = "country";

  @SerializedName(SERIALIZED_NAME_COUNTRY)
  

  private CountryExtended country;
  /**
  * Get country
  * @return country
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public CountryExtended getCountry() {
      return country;
  }
  
  


  /*
  public IntlAutocompletionsWritable addressPrefix(String addressPrefix) {
    
    this.addressPrefix = addressPrefix;
    return this;
  }
  */


  public void setAddressPrefix(String addressPrefix) {
    this.addressPrefix = addressPrefix;
  }



  /*
  public IntlAutocompletionsWritable city(String city) {
    
    this.city = city;
    return this;
  }
  */


  public void setCity(String city) {
    this.city = city;
  }



  /*
  public IntlAutocompletionsWritable state(String state) {
    
    this.state = state;
    return this;
  }
  */


  public void setState(String state) {
    this.state = state;
  }



  /*
  public IntlAutocompletionsWritable zipCode(String zipCode) {
    
    this.zipCode = zipCode;
    return this;
  }
  */


  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }



  /*
  public IntlAutocompletionsWritable country(CountryExtended country) {
    
    this.country = country;
    return this;
  }
  */


  public void setCountry(CountryExtended country) {
    this.country = country;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntlAutocompletionsWritable intlAutocompletionsWritable = (IntlAutocompletionsWritable) o;
    return Objects.equals(this.addressPrefix, intlAutocompletionsWritable.addressPrefix) &&
        Objects.equals(this.city, intlAutocompletionsWritable.city) &&
        Objects.equals(this.state, intlAutocompletionsWritable.state) &&
        Objects.equals(this.zipCode, intlAutocompletionsWritable.zipCode) &&
        Objects.equals(this.country, intlAutocompletionsWritable.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressPrefix, city, state, zipCode, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    addressPrefix: ").append(toIndentedString(addressPrefix)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
