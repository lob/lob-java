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
import com.lob.model.Letter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
/**
 * LetterList
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LetterList {
  public static final String SERIALIZED_NAME_DATA = "data";

  @SerializedName(SERIALIZED_NAME_DATA)
  private List<Letter> data = null;
  public List<Letter> getData() {     
    if (this.data == null) {
      this.data = new ArrayList<Letter>();
    }
    return this.data; 
  }

  public static final String SERIALIZED_NAME_OBJECT = "object";

  @SerializedName(SERIALIZED_NAME_OBJECT)
  

  private String _object;
  /**
  * Value is type of resource.
  * @return _object
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Value is type of resource.")
  
  public String getObject() {
      return _object;
  }
  
  

  public static final String SERIALIZED_NAME_NEXT_URL = "next_url";

  @SerializedName(SERIALIZED_NAME_NEXT_URL)
  

  private String nextUrl;
  /**
  * url of next page of items in list.
  * @return nextUrl
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "url of next page of items in list.")
  
  public String getNextUrl() {
      return nextUrl;
  }
  
  public String getNextPageToken(){
    if (this.nextUrl == null) {
        return null;
    }
    
    String[] queryPartitionArray = this.nextUrl.split("\\?");
    if (queryPartitionArray.length < 2) {
        return null;
    }
    
    String[] paramPartitionArray = queryPartitionArray[1].split("\\&");
    String beforeParamString = Arrays
      .stream(paramPartitionArray)
      .filter(x -> x.contains("after="))
      .findFirst()
      .orElse(null);
      
    if (beforeParamString == null) {
        return null;
    }
    return beforeParamString.split("after=")[1];
      
  }

  public static final String SERIALIZED_NAME_PREVIOUS_URL = "previous_url";

  @SerializedName(SERIALIZED_NAME_PREVIOUS_URL)
  

  private String previousUrl;
  /**
  * url of previous page of items in list.
  * @return previousUrl
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "url of previous page of items in list.")
  
  public String getPreviousUrl() {
      return previousUrl;
  }
  public String getPreviousPageToken(){
    if (this.previousUrl == null) {
        return null;
    }
    
    String[] queryPartitionArray = this.previousUrl.split("\\?");
    if (queryPartitionArray.length < 2) {
        return null;
    }
    
    String[] paramPartitionArray = queryPartitionArray[1].split("\\&");
    String beforeParamString = Arrays
      .stream(paramPartitionArray)
      .filter(x -> x.contains("before="))
      .findFirst()
      .orElse(null);
      
    if (beforeParamString == null) {
        return null;
    }
    return beforeParamString.split("before=")[1];
      
  }
  

  public static final String SERIALIZED_NAME_COUNT = "count";

  @SerializedName(SERIALIZED_NAME_COUNT)
  

  private Integer count;
  /**
  * number of resources in a set
  * @return count
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "number of resources in a set")
  
  public Integer getCount() {
      return count;
  }
  
  

  public static final String SERIALIZED_NAME_TOTAL_COUNT = "total_count";

  @SerializedName(SERIALIZED_NAME_TOTAL_COUNT)
  

  private Integer totalCount;
  /**
  * indicates the total number of records. Provided when the request specifies an \"include\" query parameter
  * @return totalCount
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "indicates the total number of records. Provided when the request specifies an \"include\" query parameter")
  
  public Integer getTotalCount() {
      return totalCount;
  }
  
  


  /*
  public LetterList data(List<Letter> data) {
    
    this.data = data;
    return this;
  }
  */

  public LetterList addDataItem(Letter dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Letter>();
    }
    this.data.add(dataItem);
    return this;
  }


  public void setData(List<Letter> data) {
    this.data = data;
  }



  /*
  public LetterList _object(String _object) {
    
    this._object = _object;
    return this;
  }
  */


  public void setObject(String _object) {
    this._object = _object;
  }



  /*
  public LetterList nextUrl(String nextUrl) {
    
    this.nextUrl = nextUrl;
    return this;
  }
  */


  public void setNextUrl(String nextUrl) {
    this.nextUrl = nextUrl;
  }



  /*
  public LetterList previousUrl(String previousUrl) {
    
    this.previousUrl = previousUrl;
    return this;
  }
  */


  public void setPreviousUrl(String previousUrl) {
    this.previousUrl = previousUrl;
  }



  /*
  public LetterList count(Integer count) {
    
    this.count = count;
    return this;
  }
  */


  public void setCount(Integer count) {
    this.count = count;
  }



  /*
  public LetterList totalCount(Integer totalCount) {
    
    this.totalCount = totalCount;
    return this;
  }
  */


  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LetterList letterList = (LetterList) o;
    return Objects.equals(this.data, letterList.data) &&
        Objects.equals(this._object, letterList._object) &&
        Objects.equals(this.nextUrl, letterList.nextUrl) &&
        Objects.equals(this.previousUrl, letterList.previousUrl) &&
        Objects.equals(this.count, letterList.count) &&
        Objects.equals(this.totalCount, letterList.totalCount);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, _object, nextUrl, previousUrl, count, totalCount);
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
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    nextUrl: ").append(toIndentedString(nextUrl)).append("\n");
    sb.append("    previousUrl: ").append(toIndentedString(previousUrl)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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

