

# InlineResponse200


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;ex_&#x60;. | 
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the export was created | 
**dateModified** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the export was last modified | 
**deleted** | **Boolean** | Returns as &#x60;true&#x60; if the resource has been successfully deleted. | 
**s3Url** | **String** | The URL for the generated export file. | 
**state** | [**StateEnum**](#StateEnum) | The state of the export file, which can be &#x60;in_progress&#x60;, &#x60;failed&#x60; or &#x60;succeeded&#x60;. | 
**type** | [**TypeEnum**](#TypeEnum) | The export file type, which can be &#x60;all&#x60;, &#x60;failures&#x60; or &#x60;successes&#x60;. | 
**uploadId** | **String** | Unique identifier prefixed with &#x60;upl_&#x60;. | 



## Enum: StateEnum

Name | Value
---- | -----
IN_PROGRESS | &quot;in_progress&quot;
FAILED | &quot;failed&quot;
SUCCEEDED | &quot;succeeded&quot;



## Enum: TypeEnum

Name | Value
---- | -----
ALL | &quot;all&quot;
FAILURES | &quot;failures&quot;
SUCCESSES | &quot;successes&quot;



