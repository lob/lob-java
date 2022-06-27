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
import com.lob.model.EngineHtml;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
/**
 * TemplateVersion
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TemplateVersion {
  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `vrsn_`.
  * @return id
  **/
  
  @javax.annotation.Nonnull
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^vrsn_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";

  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  

  private String description;
  /**
  * An internal description that identifies this resource. Must be no longer than 255 characters. 
  * @return description
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "An internal description that identifies this resource. Must be no longer than 255 characters. ")
  
  public String getDescription() {
      return description;
  }
  
  

  public static final String SERIALIZED_NAME_HTML = "html";

  @SerializedName(SERIALIZED_NAME_HTML)
  

  private String html;
  /**
  * An HTML string of less than 100,000 characters to be used as the `published_version` of this template. See [here](#section/HTML-Examples) for guidance on designing HTML templates. Please see endpoint specific documentation for any other product-specific HTML details: - [Postcards](https://docs.lob.com/#tag/Postcards/operation/postcard_create) - `front` and `back` - [Self Mailers](https://docs.lob.com/#tag/Self-Mailers/operation/self_mailer_create) - `inside` and `outside` - [Letters](https://docs.lob.com/#tag/Letters/operation/letter_create) - `file` - [Checks](https://docs.lob.com/#tag/Checks/operation/check_create) - `check_bottom` and `attachment` - [Cards](https://docs.lob.com/#tag/Cards/operation/card_create) - `front` and `back`  If there is a syntax error with your variable names within your HTML, then an error will be thrown, e.g. using a `{{#users}}` opening tag without the corresponding closing tag `{{/users}}`. 
  * @return html
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "An HTML string of less than 100,000 characters to be used as the `published_version` of this template. See [here](#section/HTML-Examples) for guidance on designing HTML templates. Please see endpoint specific documentation for any other product-specific HTML details: - [Postcards](https://docs.lob.com/#tag/Postcards/operation/postcard_create) - `front` and `back` - [Self Mailers](https://docs.lob.com/#tag/Self-Mailers/operation/self_mailer_create) - `inside` and `outside` - [Letters](https://docs.lob.com/#tag/Letters/operation/letter_create) - `file` - [Checks](https://docs.lob.com/#tag/Checks/operation/check_create) - `check_bottom` and `attachment` - [Cards](https://docs.lob.com/#tag/Cards/operation/card_create) - `front` and `back`  If there is a syntax error with your variable names within your HTML, then an error will be thrown, e.g. using a `{{#users}}` opening tag without the corresponding closing tag `{{/users}}`. ")
  
  public String getHtml() {
      return html;
  }
  
  

  public static final String SERIALIZED_NAME_ENGINE = "engine";

  @SerializedName(SERIALIZED_NAME_ENGINE)
  

  private EngineHtml engine = EngineHtml.LEGACY;
  /**
  * Get engine
  * @return engine
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public EngineHtml getEngine() {
      return engine;
  }
  
  

  public static final String SERIALIZED_NAME_SUGGEST_JSON_EDITOR = "suggest_json_editor";

  @SerializedName(SERIALIZED_NAME_SUGGEST_JSON_EDITOR)
  

  private Boolean suggestJsonEditor;
  /**
  * Used by frontend, true if the template uses advanced features. 
  * @return suggestJsonEditor
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Used by frontend, true if the template uses advanced features. ")
  
  public Boolean getSuggestJsonEditor() {
      return suggestJsonEditor;
  }
  
  

  public static final String SERIALIZED_NAME_MERGE_VARIABLES = "merge_variables";

  @SerializedName(SERIALIZED_NAME_MERGE_VARIABLES)
  

  private Object mergeVariables;
  /**
  * Used by frontend, an object representing the keys of every merge variable present in the template. It has one key named 'keys', and its value is an array of strings. 
  * @return mergeVariables
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Used by frontend, an object representing the keys of every merge variable present in the template. It has one key named 'keys', and its value is an array of strings. ")
  
  public Object getMergeVariables() {
      return mergeVariables;
  }
  
  

  public static final String SERIALIZED_NAME_DATE_CREATED = "date_created";

  @SerializedName(SERIALIZED_NAME_DATE_CREATED)
  

  private OffsetDateTime dateCreated;
  /**
  * A timestamp in ISO 8601 format of the date the resource was created.
  * @return dateCreated
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A timestamp in ISO 8601 format of the date the resource was created.")
  
  public OffsetDateTime getDateCreated() {
      return dateCreated;
  }
  
  

  public static final String SERIALIZED_NAME_DATE_MODIFIED = "date_modified";

  @SerializedName(SERIALIZED_NAME_DATE_MODIFIED)
  

  private OffsetDateTime dateModified;
  /**
  * A timestamp in ISO 8601 format of the date the resource was last modified.
  * @return dateModified
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A timestamp in ISO 8601 format of the date the resource was last modified.")
  
  public OffsetDateTime getDateModified() {
      return dateModified;
  }
  
  

  public static final String SERIALIZED_NAME_DELETED = "deleted";

  @SerializedName(SERIALIZED_NAME_DELETED)
  

  private Boolean deleted;
  /**
  * Only returned if the resource has been successfully deleted.
  * @return deleted
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Only returned if the resource has been successfully deleted.")
  
  public Boolean getDeleted() {
      return deleted;
  }
  
  

  /**
   * Value is resource type.
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    VERSION("version");

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
  

  private ObjectEnum _object = ObjectEnum.VERSION;
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
  public TemplateVersion id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public TemplateVersion description(String description) {
    
    this.description = description;
    return this;
  }
  */


  public void setDescription(String description) {
    this.description = description;
  }



  /*
  public TemplateVersion html(String html) {
    
    this.html = html;
    return this;
  }
  */


  public void setHtml(String html) {
    this.html = html;
  }



  /*
  public TemplateVersion engine(EngineHtml engine) {
    
    this.engine = engine;
    return this;
  }
  */


  public void setEngine(EngineHtml engine) {
    this.engine = engine;
  }



  /*
  public TemplateVersion suggestJsonEditor(Boolean suggestJsonEditor) {
    
    this.suggestJsonEditor = suggestJsonEditor;
    return this;
  }
  */


  public void setSuggestJsonEditor(Boolean suggestJsonEditor) {
    this.suggestJsonEditor = suggestJsonEditor;
  }



  /*
  public TemplateVersion mergeVariables(Object mergeVariables) {
    
    this.mergeVariables = mergeVariables;
    return this;
  }
  */


  public void setMergeVariables(Object mergeVariables) {
    this.mergeVariables = mergeVariables;
  }



  /*
  public TemplateVersion dateCreated(OffsetDateTime dateCreated) {
    
    this.dateCreated = dateCreated;
    return this;
  }
  */


  public void setDateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }



  /*
  public TemplateVersion dateModified(OffsetDateTime dateModified) {
    
    this.dateModified = dateModified;
    return this;
  }
  */


  public void setDateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
  }



  /*
  public TemplateVersion deleted(Boolean deleted) {
    
    this.deleted = deleted;
    return this;
  }
  */


  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }



  /*
  public TemplateVersion _object(ObjectEnum _object) {
    
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
    TemplateVersion templateVersion = (TemplateVersion) o;
    return Objects.equals(this.id, templateVersion.id) &&
        Objects.equals(this.description, templateVersion.description) &&
        Objects.equals(this.html, templateVersion.html) &&
        Objects.equals(this.engine, templateVersion.engine) &&
        Objects.equals(this.suggestJsonEditor, templateVersion.suggestJsonEditor) &&
        Objects.equals(this.mergeVariables, templateVersion.mergeVariables) &&
        Objects.equals(this.dateCreated, templateVersion.dateCreated) &&
        Objects.equals(this.dateModified, templateVersion.dateModified) &&
        Objects.equals(this.deleted, templateVersion.deleted) &&
        Objects.equals(this._object, templateVersion._object);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, html, engine, suggestJsonEditor, mergeVariables, dateCreated, dateModified, deleted, _object);
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
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    html: ").append(toIndentedString(html)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    suggestJsonEditor: ").append(toIndentedString(suggestJsonEditor)).append("\n");
    sb.append("    mergeVariables: ").append(toIndentedString(mergeVariables)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
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

