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
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * BankAccountVerify
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BankAccountVerify {
  public static final String SERIALIZED_NAME_AMOUNTS = "amounts";

  @SerializedName(SERIALIZED_NAME_AMOUNTS)
  private List<Integer> amounts = new ArrayList<Integer>();
  public List<Integer> getAmounts() {
    if (this.amounts == null) {
      this.amounts = new ArrayList<Integer>();
    }
    return this.amounts;
  }


  /*
  public BankAccountVerify amounts(List<Integer> amounts) {
    
    this.amounts = amounts;
    return this;
  }
  */

  public BankAccountVerify addAmountsItem(Integer amountsItem) {
    this.amounts.add(amountsItem);
    return this;
  }


  public void setAmounts(List<Integer> amounts) {
    this.amounts = amounts;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankAccountVerify bankAccountVerify = (BankAccountVerify) o;
    return Objects.equals(this.amounts, bankAccountVerify.amounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    amounts: ").append(toIndentedString(amounts)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("amounts", amounts);
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

