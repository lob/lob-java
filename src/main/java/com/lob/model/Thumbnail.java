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

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * Thumbnail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Thumbnail {
  public static final String SERIALIZED_NAME_SMALL = "small";

  @SerializedName(SERIALIZED_NAME_SMALL)
  

  private String small;
  /**
  * A [signed link](#section/Asset-URLs) served over HTTPS. The link returned will expire in 30 days to prevent mis-sharing. Each time a GET request is initiated, a new signed URL will be generated.
  * @return small
  **/
  
  @javax.annotation.Nullable
  
  public String getSmall() { return small; }

  public void setSmall (String small) throws IllegalArgumentException {
    if(!small.matches("^https://lob-assets.com/(letters|postcards|bank-accounts|checks|self-mailers|cards)/[a-z]{3,4}_[a-z0-9]{15,16}('|_signature)(.pdf|_thumb_[a-z]+_[0-9]+.png|.png)?(version=[a-z0-9]*&)expires=[0-9]{10}&signature=[a-zA-Z0-9-_]+")) {
      throw new IllegalArgumentException("Invalid small provided");
    }

    this.small = small;
  }
  
  

  public static final String SERIALIZED_NAME_MEDIUM = "medium";

  @SerializedName(SERIALIZED_NAME_MEDIUM)
  

  private String medium;
  /**
  * A [signed link](#section/Asset-URLs) served over HTTPS. The link returned will expire in 30 days to prevent mis-sharing. Each time a GET request is initiated, a new signed URL will be generated.
  * @return medium
  **/
  
  @javax.annotation.Nullable
  
  public String getMedium() { return medium; }

  public void setMedium (String medium) throws IllegalArgumentException {
    if(!medium.matches("^https://lob-assets.com/(letters|postcards|bank-accounts|checks|self-mailers|cards)/[a-z]{3,4}_[a-z0-9]{15,16}('|_signature)(.pdf|_thumb_[a-z]+_[0-9]+.png|.png)?(version=[a-z0-9]*&)expires=[0-9]{10}&signature=[a-zA-Z0-9-_]+")) {
      throw new IllegalArgumentException("Invalid medium provided");
    }

    this.medium = medium;
  }
  
  

  public static final String SERIALIZED_NAME_LARGE = "large";

  @SerializedName(SERIALIZED_NAME_LARGE)
  

  private String large;
  /**
  * A [signed link](#section/Asset-URLs) served over HTTPS. The link returned will expire in 30 days to prevent mis-sharing. Each time a GET request is initiated, a new signed URL will be generated.
  * @return large
  **/
  
  @javax.annotation.Nullable
  
  public String getLarge() { return large; }

  public void setLarge (String large) throws IllegalArgumentException {
    if(!large.matches("^https://lob-assets.com/(letters|postcards|bank-accounts|checks|self-mailers|cards)/[a-z]{3,4}_[a-z0-9]{15,16}('|_signature)(.pdf|_thumb_[a-z]+_[0-9]+.png|.png)?(version=[a-z0-9]*&)expires=[0-9]{10}&signature=[a-zA-Z0-9-_]+")) {
      throw new IllegalArgumentException("Invalid large provided");
    }

    this.large = large;
  }
  
  


  /*
  public Thumbnail small(String small) {
    
    this.small = small;
    return this;
  }
  */





  /*
  public Thumbnail medium(String medium) {
    
    this.medium = medium;
    return this;
  }
  */





  /*
  public Thumbnail large(String large) {
    
    this.large = large;
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
    Thumbnail thumbnail = (Thumbnail) o;
    return Objects.equals(this.small, thumbnail.small) &&
        Objects.equals(this.medium, thumbnail.medium) &&
        Objects.equals(this.large, thumbnail.large);
  }

  @Override
  public int hashCode() {
    return Objects.hash(small, medium, large);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    small: ").append(toIndentedString(small)).append("\n");
    sb.append("    medium: ").append(toIndentedString(medium)).append("\n");
    sb.append("    large: ").append(toIndentedString(large)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("small", small);
      localMap.put("medium", medium);
      localMap.put("large", large);
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

