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
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.IntlSuggestions;

/**
 * IntlAutocompletions
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IntlAutocompletions {
  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `intl_auto_`.
  * @return id
  **/
  
  @javax.annotation.Nullable
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^intl_auto_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_SUGGESTIONS = "suggestions";

  @SerializedName(SERIALIZED_NAME_SUGGESTIONS)
  private List<IntlSuggestions> suggestions = null;
  public List<IntlSuggestions> getSuggestions() {     
    if (this.suggestions == null) {
      this.suggestions = new ArrayList<IntlSuggestions>();
    }
    return this.suggestions; 
  }


  /*
  public IntlAutocompletions id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public IntlAutocompletions suggestions(List<IntlSuggestions> suggestions) {
    
    this.suggestions = suggestions;
    return this;
  }
  */

  public IntlAutocompletions addSuggestionsItem(IntlSuggestions suggestionsItem) {
    if (this.suggestions == null) {
      this.suggestions = new ArrayList<IntlSuggestions>();
    }
    this.suggestions.add(suggestionsItem);
    return this;
  }


  public void setSuggestions(List<IntlSuggestions> suggestions) {
    this.suggestions = suggestions;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntlAutocompletions intlAutocompletions = (IntlAutocompletions) o;
    return Objects.equals(this.id, intlAutocompletions.id) &&
        Objects.equals(this.suggestions, intlAutocompletions.suggestions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, suggestions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    suggestions: ").append(toIndentedString(suggestions)).append("\n");
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
