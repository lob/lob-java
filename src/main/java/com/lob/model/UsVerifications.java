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
import com.lob.model.UsVerificationOrError;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * UsVerifications
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UsVerifications {
  public static final String SERIALIZED_NAME_ADDRESSES = "addresses";

  @SerializedName(SERIALIZED_NAME_ADDRESSES)
  private List<UsVerificationOrError> addresses = new ArrayList<UsVerificationOrError>();
  public List<UsVerificationOrError> getAddresses() {
    if (this.addresses == null) {
      this.addresses = new ArrayList<UsVerificationOrError>();
    }
    return this.addresses;
  }

  public static final String SERIALIZED_NAME_ERRORS = "errors";

  @SerializedName(SERIALIZED_NAME_ERRORS)
  

  private Boolean errors;
  /**
  * Indicates whether any errors occurred during the verification process.
  * @return errors
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "Indicates whether any errors occurred during the verification process.")
  
  public Boolean getErrors() {
      return errors;
  }
  
  


  /*
  public UsVerifications addresses(List<UsVerificationOrError> addresses) {
    
    this.addresses = addresses;
    return this;
  }
  */

  public UsVerifications addAddressesItem(UsVerificationOrError addressesItem) {
    this.addresses.add(addressesItem);
    return this;
  }


  public void setAddresses(List<UsVerificationOrError> addresses) {
    this.addresses = addresses;
  }



  /*
  public UsVerifications errors(Boolean errors) {
    
    this.errors = errors;
    return this;
  }
  */


  public void setErrors(Boolean errors) {
    this.errors = errors;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsVerifications usVerifications = (UsVerifications) o;
    return Objects.equals(this.addresses, usVerifications.addresses) &&
        Objects.equals(this.errors, usVerifications.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addresses, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("addresses", addresses);
      localMap.put("errors", errors);
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

