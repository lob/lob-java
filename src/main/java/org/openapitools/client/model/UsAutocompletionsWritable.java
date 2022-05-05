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
 * UsAutocompletionsWritable
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UsAutocompletionsWritable {
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
  * An optional ZIP Code input used to filter suggestions. Matches partial entries. 
  * @return zipCode
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "An optional ZIP Code input used to filter suggestions. Matches partial entries. ")
  
  public String getZipCode() {
      return zipCode;
  }
  
  

  public static final String SERIALIZED_NAME_GEO_IP_SORT = "geo_ip_sort";

  @SerializedName(SERIALIZED_NAME_GEO_IP_SORT)
  

  private Boolean geoIpSort;

  /**
  * If `true`, sort suggestions by proximity to the IP set in the `X-Forwarded-For` header. 
  * @return geoIpSort
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "If `true`, sort suggestions by proximity to the IP set in the `X-Forwarded-For` header. ")
  
  public Boolean getGeoIpSort() {
      return geoIpSort;
  }
  
  


  /*
  public UsAutocompletionsWritable addressPrefix(String addressPrefix) {
    
    this.addressPrefix = addressPrefix;
    return this;
  }
  */


  public void setAddressPrefix(String addressPrefix) {
    this.addressPrefix = addressPrefix;
  }



  /*
  public UsAutocompletionsWritable city(String city) {
    
    this.city = city;
    return this;
  }
  */


  public void setCity(String city) {
    this.city = city;
  }



  /*
  public UsAutocompletionsWritable state(String state) {
    
    this.state = state;
    return this;
  }
  */


  public void setState(String state) {
    this.state = state;
  }



  /*
  public UsAutocompletionsWritable zipCode(String zipCode) {
    
    this.zipCode = zipCode;
    return this;
  }
  */


  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }



  /*
  public UsAutocompletionsWritable geoIpSort(Boolean geoIpSort) {
    
    this.geoIpSort = geoIpSort;
    return this;
  }
  */


  public void setGeoIpSort(Boolean geoIpSort) {
    this.geoIpSort = geoIpSort;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsAutocompletionsWritable usAutocompletionsWritable = (UsAutocompletionsWritable) o;
    return Objects.equals(this.addressPrefix, usAutocompletionsWritable.addressPrefix) &&
        Objects.equals(this.city, usAutocompletionsWritable.city) &&
        Objects.equals(this.state, usAutocompletionsWritable.state) &&
        Objects.equals(this.zipCode, usAutocompletionsWritable.zipCode) &&
        Objects.equals(this.geoIpSort, usAutocompletionsWritable.geoIpSort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressPrefix, city, state, zipCode, geoIpSort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    addressPrefix: ").append(toIndentedString(addressPrefix)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    geoIpSort: ").append(toIndentedString(geoIpSort)).append("\n");
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

