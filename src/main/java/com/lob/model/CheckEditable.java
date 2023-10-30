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
import com.lob.model.ChkUseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * CheckEditable
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CheckEditable {
  public static final String SERIALIZED_NAME_FROM = "from";

  @SerializedName(SERIALIZED_NAME_FROM)
  
  private String from;
  public  String getFrom() {
    return from;
  }


  public void setFrom(String from) {
    

    this.from = from;
  }
  
  
  public void setFrom(AddressDomestic from) {
    Gson gson = new Gson();

    this.from = gson.toJson(from);
  }
  public static final String SERIALIZED_NAME_TO = "to";

  @SerializedName(SERIALIZED_NAME_TO)
  
  private String to;
  public  String getTo() {
    return to;
  }


  public void setTo(String to) {
    

    this.to = to;
  }
  
  
  public void setTo(AddressDomestic to) {
    Gson gson = new Gson();

    this.to = gson.toJson(to);
  }
  public static final String SERIALIZED_NAME_BANK_ACCOUNT = "bank_account";

  @SerializedName(SERIALIZED_NAME_BANK_ACCOUNT)
  

  private String bankAccount;
  /**
  * Get bankAccount
  * @return bankAccount
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(required = true, value = "")
  
  public String getBankAccount() {
      return bankAccount;
  }
  
  

  public static final String SERIALIZED_NAME_AMOUNT = "amount";

  @SerializedName(SERIALIZED_NAME_AMOUNT)
  

  private Float amount;
  /**
  * The payment amount to be sent in US dollars.
  * maximum: 999999.99
  * @return amount
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "The payment amount to be sent in US dollars.")
  
  public Float getAmount() {
      return amount;
  }
  
  

  public static final String SERIALIZED_NAME_LOGO = "logo";

  @SerializedName(SERIALIZED_NAME_LOGO)
  

  private String logo;
  /**
  * Accepts a remote URL or local file upload to an image to print (in grayscale) in the upper-left corner of your check.
  * @return logo
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Accepts a remote URL or local file upload to an image to print (in grayscale) in the upper-left corner of your check.")
  
  public String getLogo() {
      return logo;
  }
  
  

  public static final String SERIALIZED_NAME_CHECK_BOTTOM = "check_bottom";

  @SerializedName(SERIALIZED_NAME_CHECK_BOTTOM)
  

  private String checkBottom;
  /**
  * The artwork to use on the bottom of the check page.  Notes: - HTML merge variables should not include delimiting whitespace. - PDF, PNG, and JPGs must be sized at 8.5\"x11\" at 300 DPI, while supplied HTML will be rendered and trimmed to fit on a 8.5\"x11\" page. - The check bottom will always be printed in black & white. - Must conform to [this template](https://s3-us-west-2.amazonaws.com/public.lob.com/assets/templates/check_bottom_template.pdf).  Need more help? Consult our [HTML examples](#section/HTML-Examples).
  * @return checkBottom
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The artwork to use on the bottom of the check page.  Notes: - HTML merge variables should not include delimiting whitespace. - PDF, PNG, and JPGs must be sized at 8.5\"x11\" at 300 DPI, while supplied HTML will be rendered and trimmed to fit on a 8.5\"x11\" page. - The check bottom will always be printed in black & white. - Must conform to [this template](https://s3-us-west-2.amazonaws.com/public.lob.com/assets/templates/check_bottom_template.pdf).  Need more help? Consult our [HTML examples](#section/HTML-Examples).")
  
  public String getCheckBottom() {
      return checkBottom;
  }
  
  

  public static final String SERIALIZED_NAME_ATTACHMENT = "attachment";

  @SerializedName(SERIALIZED_NAME_ATTACHMENT)
  

  private String attachment;
  /**
  * A document to include with the check.
  * @return attachment
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A document to include with the check.")
  
  public String getAttachment() {
      return attachment;
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
  
  

  public static final String SERIALIZED_NAME_METADATA = "metadata";

  @SerializedName(SERIALIZED_NAME_METADATA)
  private Map<String, String> metadata = null;
  public Map<String, String> getMetadata() {
    if (this.metadata == null) {
      this.metadata = new HashMap<String,String>();
    }
    return this.metadata;
  }

  public static final String SERIALIZED_NAME_MERGE_VARIABLES = "merge_variables";

  @SerializedName(SERIALIZED_NAME_MERGE_VARIABLES)
  

  private Object mergeVariables;
  /**
  * You can input a merge variable payload object to your template to render dynamic content. For example, if you have a template like: `{{variable_name}}`, pass in `{\"variable_name\": \"Harry\"}` to render `Harry`. `merge_variables` must be an object. Any type of value is accepted as long as the object is valid JSON; you can use `strings`, `numbers`, `booleans`, `arrays`, `objects`, or `null`. The max length of the object is 25,000 characters. If you call `JSON.stringify` on your object, it can be no longer than 25,000 characters. Your variable names cannot contain any whitespace or any of the following special characters: `!`, `\"`, `#`, `%`, `&`, `'`, `(`, `)`, `*`, `+`, `,`, `/`, `;`, `<`, `=`, `>`, `@`, `[`, `\\`, `]`, `^`, `` ` ``, `{`, `|`, `}`, `~`. More instructions can be found in [our guide to using html and merge variables](https://lob.com/resources/guides/general/using-html-and-merge-variables). Depending on your [Merge Variable strictness](https://dashboard.lob.com/#/settings/account) setting, if you define variables in your HTML but do not pass them here, you will either receive an error or the variable will render as an empty string.
  * @return mergeVariables
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "You can input a merge variable payload object to your template to render dynamic content. For example, if you have a template like: `{{variable_name}}`, pass in `{\"variable_name\": \"Harry\"}` to render `Harry`. `merge_variables` must be an object. Any type of value is accepted as long as the object is valid JSON; you can use `strings`, `numbers`, `booleans`, `arrays`, `objects`, or `null`. The max length of the object is 25,000 characters. If you call `JSON.stringify` on your object, it can be no longer than 25,000 characters. Your variable names cannot contain any whitespace or any of the following special characters: `!`, `\"`, `#`, `%`, `&`, `'`, `(`, `)`, `*`, `+`, `,`, `/`, `;`, `<`, `=`, `>`, `@`, `[`, `\\`, `]`, `^`, `` ` ``, `{`, `|`, `}`, `~`. More instructions can be found in [our guide to using html and merge variables](https://lob.com/resources/guides/general/using-html-and-merge-variables). Depending on your [Merge Variable strictness](https://dashboard.lob.com/#/settings/account) setting, if you define variables in your HTML but do not pass them here, you will either receive an error or the variable will render as an empty string.")
  
  public Object getMergeVariables() {
      return mergeVariables;
  }
  
  

  public static final String SERIALIZED_NAME_SEND_DATE = "send_date";

  @SerializedName(SERIALIZED_NAME_SEND_DATE)
  

  private OffsetDateTime sendDate;
  /**
  * A timestamp in ISO 8601 format which specifies a date after the current time and up to 180 days in the future to send the letter off for production. Setting a send date overrides the default [cancellation window](#section/Cancellation-Windows) applied to the mailpiece. Until the `send_date` has passed, the mailpiece can be canceled. If a date in the format `2017-11-01` is passed, it will evaluate to midnight UTC of that date (`2017-11-01T00:00:00.000Z`). If a datetime is passed, that exact time will be used. A `send_date` passed with no time zone will default to UTC, while a `send_date` passed with a time zone will be converted to UTC.
  * @return sendDate
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A timestamp in ISO 8601 format which specifies a date after the current time and up to 180 days in the future to send the letter off for production. Setting a send date overrides the default [cancellation window](#section/Cancellation-Windows) applied to the mailpiece. Until the `send_date` has passed, the mailpiece can be canceled. If a date in the format `2017-11-01` is passed, it will evaluate to midnight UTC of that date (`2017-11-01T00:00:00.000Z`). If a datetime is passed, that exact time will be used. A `send_date` passed with no time zone will default to UTC, while a `send_date` passed with a time zone will be converted to UTC.")
  
  public OffsetDateTime getSendDate() {
      return sendDate;
  }
  
  

  /**
   * Checks must be sent &#x60;usps_first_class&#x60;
   */
  @JsonAdapter(MailTypeEnum.Adapter.class)
  public enum MailTypeEnum {
    USPS_FIRST_CLASS("usps_first_class");

    private String value;

    MailTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MailTypeEnum fromValue(String value) {
      for (MailTypeEnum b : MailTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<MailTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MailTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MailTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return MailTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_MAIL_TYPE = "mail_type";

  @SerializedName(SERIALIZED_NAME_MAIL_TYPE)
  

  private MailTypeEnum mailType = MailTypeEnum.USPS_FIRST_CLASS;
  /**
  * Checks must be sent `usps_first_class`
  * @return mailType
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Checks must be sent `usps_first_class`")
  
  public MailTypeEnum getMailType() {
      return mailType;
  }
  
  

  public static final String SERIALIZED_NAME_MEMO = "memo";

  @SerializedName(SERIALIZED_NAME_MEMO)
  

  private String memo;
  /**
  * Text to include on the memo line of the check.
  * @return memo
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Text to include on the memo line of the check.")
  
  public String getMemo() {
      return memo;
  }
  
  

  public static final String SERIALIZED_NAME_CHECK_NUMBER = "check_number";

  @SerializedName(SERIALIZED_NAME_CHECK_NUMBER)
  

  private Integer checkNumber;
  /**
  * An integer that designates the check number.
  * minimum: 1
  * maximum: 500000000
  * @return checkNumber
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "An integer that designates the check number.")
  
  public Integer getCheckNumber() {
      return checkNumber;
  }
  
  

  public static final String SERIALIZED_NAME_MESSAGE = "message";

  @SerializedName(SERIALIZED_NAME_MESSAGE)
  

  private String message;
  /**
  * Max of 400 characters to be included at the bottom of the check page.
  * @return message
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Max of 400 characters to be included at the bottom of the check page.")
  
  public String getMessage() {
      return message;
  }
  
  

  public static final String SERIALIZED_NAME_BILLING_GROUP_ID = "billing_group_id";

  @SerializedName(SERIALIZED_NAME_BILLING_GROUP_ID)
  

  private String billingGroupId;
  /**
  * An optional string with the billing group ID to tag your usage with. Is used for billing purposes. Requires special activation to use. See [Billing Group API](https://lob.github.io/lob-openapi/#tag/Billing-Groups) for more information.
  * @return billingGroupId
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "An optional string with the billing group ID to tag your usage with. Is used for billing purposes. Requires special activation to use. See [Billing Group API](https://lob.github.io/lob-openapi/#tag/Billing-Groups) for more information.")
  
  public String getBillingGroupId() {
      return billingGroupId;
  }
  
  

  public static final String SERIALIZED_NAME_USE_TYPE = "use_type";

  @SerializedName(SERIALIZED_NAME_USE_TYPE)
  

  private ChkUseType useType;
  /**
  * Get useType
  * @return useType
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(required = true, value = "")
  
  public ChkUseType getUseType() {
      return useType;
  }
  
  


  /*
  public CheckEditable from(Object from) {
    
    this.from = from;
    return this;
  }
  */





  /*
  public CheckEditable to(Object to) {
    
    this.to = to;
    return this;
  }
  */





  /*
  public CheckEditable bankAccount(String bankAccount) {
    
    this.bankAccount = bankAccount;
    return this;
  }
  */


  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }



  /*
  public CheckEditable amount(Float amount) {
    
    this.amount = amount;
    return this;
  }
  */


  public void setAmount(Float amount) {
    this.amount = amount;
  }



  /*
  public CheckEditable logo(String logo) {
    
    this.logo = logo;
    return this;
  }
  */


  public void setLogo(String logo) {
    this.logo = logo;
  }



  /*
  public CheckEditable checkBottom(String checkBottom) {
    
    this.checkBottom = checkBottom;
    return this;
  }
  */


  public void setCheckBottom(String checkBottom) {
    this.checkBottom = checkBottom;
  }



  /*
  public CheckEditable attachment(String attachment) {
    
    this.attachment = attachment;
    return this;
  }
  */


  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }



  /*
  public CheckEditable description(String description) {
    
    this.description = description;
    return this;
  }
  */


  public void setDescription(String description) {
    this.description = description;
  }



  /*
  public CheckEditable metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }
  */

  public CheckEditable putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<String,String>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }


  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }



  /*
  public CheckEditable mergeVariables(Object mergeVariables) {
    
    this.mergeVariables = mergeVariables;
    return this;
  }
  */


  public void setMergeVariables(Object mergeVariables) {
    this.mergeVariables = mergeVariables;
  }



  /*
  public CheckEditable sendDate(OffsetDateTime sendDate) {
    
    this.sendDate = sendDate;
    return this;
  }
  */


  public void setSendDate(OffsetDateTime sendDate) {
    this.sendDate = sendDate;
  }



  /*
  public CheckEditable mailType(MailTypeEnum mailType) {
    
    this.mailType = mailType;
    return this;
  }
  */


  public void setMailType(MailTypeEnum mailType) {
    this.mailType = mailType;
  }



  /*
  public CheckEditable memo(String memo) {
    
    this.memo = memo;
    return this;
  }
  */


  public void setMemo(String memo) {
    this.memo = memo;
  }



  /*
  public CheckEditable checkNumber(Integer checkNumber) {
    
    this.checkNumber = checkNumber;
    return this;
  }
  */


  public void setCheckNumber(Integer checkNumber) {
    this.checkNumber = checkNumber;
  }



  /*
  public CheckEditable message(String message) {
    
    this.message = message;
    return this;
  }
  */


  public void setMessage(String message) {
    this.message = message;
  }



  /*
  public CheckEditable billingGroupId(String billingGroupId) {
    
    this.billingGroupId = billingGroupId;
    return this;
  }
  */


  public void setBillingGroupId(String billingGroupId) {
    this.billingGroupId = billingGroupId;
  }



  /*
  public CheckEditable useType(ChkUseType useType) {
    
    this.useType = useType;
    return this;
  }
  */


  public void setUseType(ChkUseType useType) {
    this.useType = useType;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckEditable checkEditable = (CheckEditable) o;
    return Objects.equals(this.from, checkEditable.from) &&
        Objects.equals(this.to, checkEditable.to) &&
        Objects.equals(this.bankAccount, checkEditable.bankAccount) &&
        Objects.equals(this.amount, checkEditable.amount) &&
        Objects.equals(this.logo, checkEditable.logo) &&
        Objects.equals(this.checkBottom, checkEditable.checkBottom) &&
        Objects.equals(this.attachment, checkEditable.attachment) &&
        Objects.equals(this.description, checkEditable.description) &&
        Objects.equals(this.metadata, checkEditable.metadata) &&
        Objects.equals(this.mergeVariables, checkEditable.mergeVariables) &&
        Objects.equals(this.sendDate, checkEditable.sendDate) &&
        Objects.equals(this.mailType, checkEditable.mailType) &&
        Objects.equals(this.memo, checkEditable.memo) &&
        Objects.equals(this.checkNumber, checkEditable.checkNumber) &&
        Objects.equals(this.message, checkEditable.message) &&
        Objects.equals(this.billingGroupId, checkEditable.billingGroupId) &&
        Objects.equals(this.useType, checkEditable.useType);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, bankAccount, amount, logo, checkBottom, attachment, description, metadata, mergeVariables, sendDate, mailType, memo, checkNumber, message, billingGroupId, useType);
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
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    logo: ").append(toIndentedString(logo)).append("\n");
    sb.append("    checkBottom: ").append(toIndentedString(checkBottom)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    mergeVariables: ").append(toIndentedString(mergeVariables)).append("\n");
    sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
    sb.append("    mailType: ").append(toIndentedString(mailType)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    checkNumber: ").append(toIndentedString(checkNumber)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    billingGroupId: ").append(toIndentedString(billingGroupId)).append("\n");
    sb.append("    useType: ").append(toIndentedString(useType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("from", from);
      localMap.put("to", to);
      localMap.put("bank_account", bankAccount);
      localMap.put("amount", amount);
      localMap.put("logo", logo);
      localMap.put("check_bottom", checkBottom);
      localMap.put("attachment", attachment);
      localMap.put("description", description);
      localMap.put("metadata", metadata);
      localMap.put("merge_variables", mergeVariables);
      localMap.put("send_date", sendDate);
      localMap.put("mail_type", mailType);
      localMap.put("memo", memo);
      localMap.put("check_number", checkNumber);
      localMap.put("message", message);
      localMap.put("billing_group_id", billingGroupId);
      localMap.put("use_type", useType);
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

