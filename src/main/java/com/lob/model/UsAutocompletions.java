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
import com.lob.model.Suggestions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * UsAutocompletions
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UsAutocompletions {
  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `us_auto_`.
  * @return id
  **/
  
  @javax.annotation.Nullable
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^us_auto_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_SUGGESTIONS = "suggestions";

  @SerializedName(SERIALIZED_NAME_SUGGESTIONS)
  private List<Suggestions> suggestions = null;
  public List<Suggestions> getSuggestions() {
    if (this.suggestions == null) {
      this.suggestions = new ArrayList<Suggestions>();
    }
    return this.suggestions;
  }

  /**
   * Value is resource type.
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    US_AUTOCOMPLETION("us_autocompletion");

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
  

  private ObjectEnum _object = ObjectEnum.US_AUTOCOMPLETION;
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
  public UsAutocompletions id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public UsAutocompletions suggestions(List<Suggestions> suggestions) {
    
    this.suggestions = suggestions;
    return this;
  }
  */

  public UsAutocompletions addSuggestionsItem(Suggestions suggestionsItem) {
    if (this.suggestions == null) {
      this.suggestions = new ArrayList<Suggestions>();
    }
    this.suggestions.add(suggestionsItem);
    return this;
  }


  public void setSuggestions(List<Suggestions> suggestions) {
    this.suggestions = suggestions;
  }



  /*
  public UsAutocompletions _object(ObjectEnum _object) {
    
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
    UsAutocompletions usAutocompletions = (UsAutocompletions) o;
    return Objects.equals(this.id, usAutocompletions.id) &&
        Objects.equals(this.suggestions, usAutocompletions.suggestions) &&
        Objects.equals(this._object, usAutocompletions._object);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, suggestions, _object);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    suggestions: ").append(toIndentedString(suggestions)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("id", id);
      localMap.put("suggestions", suggestions);
      localMap.put("object", _object);
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

