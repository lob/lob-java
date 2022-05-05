

# LobError

Lob uses RESTful HTTP response codes to indicate success or failure of an API request.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**message** | **String** | A human-readable message with more details about the error |  [optional]
**statusCode** | [**StatusCodeEnum**](#StatusCodeEnum) | A conventional HTTP status code. |  [optional]
**code** | [**CodeEnum**](#CodeEnum) | A pre-defined string identifying an error. |  [optional]



## Enum: StatusCodeEnum

Name | Value
---- | -----
NUMBER_401 | 401
NUMBER_403 | 403
NUMBER_404 | 404
NUMBER_413 | 413
NUMBER_422 | 422
NUMBER_429 | 429
NUMBER_500 | 500



## Enum: CodeEnum

Name | Value
---- | -----
BAD_REQUEST | &quot;bad_request&quot;
CONFLICT | &quot;conflict&quot;
FEATURE_LIMIT_REACHED | &quot;feature_limit_reached&quot;
INTERNAL_SERVER_ERROR | &quot;internal_server_error&quot;
INVALID | &quot;invalid&quot;
NOT_DELETABLE | &quot;not_deletable&quot;
NOT_FOUND | &quot;not_found&quot;
REQUEST_TIMEOUT | &quot;request_timeout&quot;
SERVICE_UNAVAILABLE | &quot;service_unavailable&quot;
UNRECOGNIZED_ENDPOINT | &quot;unrecognized_endpoint&quot;
UNSUPPORTED_LOB_VERSION | &quot;unsupported_lob_version&quot;
ADDRESS_LENGTH_EXCEEDS_LIMIT | &quot;address_length_exceeds_limit&quot;
BANK_ACCOUNT_ALREADY_VERIFIED | &quot;bank_account_already_verified&quot;
BANK_ERROR | &quot;bank_error&quot;
CUSTOM_ENVELOPE_INVENTORY_DEPLETED | &quot;custom_envelope_inventory_depleted&quot;
DELETED_BANK_ACCOUNT | &quot;deleted_bank_account&quot;
FAILED_DELIVERABILITY_STRICTNESS | &quot;failed_deliverability_strictness&quot;
FILE_PAGES_BELOW_MIN | &quot;file_pages_below_min&quot;
FILE_PAGES_EXCEED_MAX | &quot;file_pages_exceed_max&quot;
FILE_SIZE_EXCEEDS_LIMIT | &quot;file_size_exceeds_limit&quot;
FOREIGN_RETURN_ADDRESS | &quot;foreign_return_address&quot;
INCONSISTENT_PAGE_DIMENSIONS | &quot;inconsistent_page_dimensions&quot;
INVALID_BANK_ACCOUNT | &quot;invalid_bank_account&quot;
INVALID_BANK_ACCOUNT_VERIFICATION | &quot;invalid_bank_account_verification&quot;
INVALID_CHECK_INTERNATIONAL | &quot;invalid_check_international&quot;
INVALID_COUNTRY_COVID | &quot;invalid_country_covid&quot;
INVALID_FILE | &quot;invalid_file&quot;
INVALID_FILE_DIMENSIONS | &quot;invalid_file_dimensions&quot;
INVALID_FILE_DOWNLOAD_TIME | &quot;invalid_file_download_time&quot;
INVALID_FILE_URL | &quot;invalid_file_url&quot;
INVALID_IMAGE_DPI | &quot;invalid_image_dpi&quot;
INVALID_INTERNATIONAL_FEATURE | &quot;invalid_international_feature&quot;
INVALID_PERFORATION_RETURN_ENVELOPE | &quot;invalid_perforation_return_envelope&quot;
INVALID_TEMPLATE_HTML | &quot;invalid_template_html&quot;
MERGE_VARIABLE_REQUIRED | &quot;merge_variable_required&quot;
MERGE_VARIABLE_WHITESPACE | &quot;merge_variable_whitespace&quot;
PAYMENT_METHOD_UNVERIFIED | &quot;payment_method_unverified&quot;
PDF_ENCRYPTED | &quot;pdf_encrypted&quot;
SPECIAL_CHARACTERS_RESTRICTED | &quot;special_characters_restricted&quot;
UNEMBEDDED_FONTS | &quot;unembedded_fonts&quot;
EMAIL_REQUIRED | &quot;email_required&quot;
INVALID_API_KEY | &quot;invalid_api_key&quot;
PUBLISHABLE_KEY_NOT_ALLOWED | &quot;publishable_key_not_allowed&quot;
RATE_LIMIT_EXCEEDED | &quot;rate_limit_exceeded&quot;
UNAUTHORIZED | &quot;unauthorized&quot;
UNAUTHORIZED_TOKEN | &quot;unauthorized_token&quot;



