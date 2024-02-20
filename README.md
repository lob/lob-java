# lob-java

Lob
- API version: 1.3.0

The Lob API is organized around REST. Our API is designed to have predictable, resource-oriented URLs and uses HTTP response codes to indicate any API errors.<p> Looking for our [legacy Java SDK](https://github.com/lob/lob-java/tree/12.3.7-Legacy)?

For more information, please visit [https://support.lob.com/](https://support.lob.com/)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Getting Started

### Registration

First, you will need to first create an account at [Lob.com](https://dashboard.lob.com/#/register) and obtain your Test and Live API Keys.

Once you have created an account, you can access your API Keys from the [Settings Panel](https://dashboard.lob.com/#/settings).

### Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

#### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.lob</groupId>
  <artifactId>lob-java</artifactId>
  <version>13.0.0</version>
</dependency>
```

##### Projects using the Spring framework

Some versions of the Spring framework introduce a dependency collision that prevents the Lob SDK from functioning correctly. In order to correct this, please add the following two blocks to your project's POM along with the dependency mentioned above.

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.squareup.okhttp3</groupId>
            <artifactId>okhttp</artifactId>
            <version>4.9.1</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```
and
```xml
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.9.1</version>
</dependency>
```

#### Gradle users

Add this dependency to your project's build file:

```groovy
implementation "com.github.lob:lob-java:13.0.0"
```

#### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/lob-java-13.0.0.jar`
* `target/lib/*.jar`


## First API Call

```java
package com.company.app;

import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.model.*;
import com.lob.api.client.AddressesApi;

public class App
{
    public static void main( String[] args )
    {

        ApiClient lobClient = Configuration.getDefaultApiClient();

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) lobClient.getAuthentication("basicAuth");
        basicAuth.setUsername("<YOUR_LOB_API_KEY>");

        AddressesApi apiInstance = new AddressesApi(lobClient);
        AddressEditable addressEditable = new AddressEditable();
        addressEditable.setDescription("Harry - Office");
        addressEditable.setName("Harry Zhang");
        addressEditable.setCompany("Lob");
        addressEditable.setAddressLine1("2261 Market Street");
        addressEditable.setAddressCity("San Francisco");
        addressEditable.setAddressState("CA");
        addressEditable.setAddressZip("94114");
        addressEditable.setAddressCountry(CountryExtended.US);
        addressEditable.setPhone("555-555-5555");
        addressEditable.setEmail("harry@lob.com");

        try {
            Address result = apiInstance.create(addressEditable);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AddressesApi#addressCreate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
 }
```

## API Documentation

The full and comprehensive documentation of Lob's APIs is available [here](https://docs.lob.com/).

## Testing

### Unit Tests

```bash
$ mvn test "-Dtest=%regex[.*ApiTest.*]"
```

### Integration Tests

Integration tests run against a live deployment of the Lob API and require multiple valid API keys with access to specific features. As such, it is not expected that these tests will pass for every user in every environment.

To run integration tests:

```bash
$ LOB_API_TEST_KEY=<<YOUR TEST KEY>> LOB_API_LIVE_KEY=<<YOUR LIVE KEY>> mvn test "-Dtest=%regex[.*SpecTest.*]"
```

#### A cleaner alternative if you are going to run integration tests frequently

Run this the first time:

```bash
$ echo "LOB_API_TEST_KEY=<<YOUR TEST KEY>> LOB_API_LIVE_KEY=<<YOUR LIVE KEY>>" > LOCAL.env
```

Then, to run the integration tests:

```bash
$ env $(cat LOCAL.env) mvn test "-Dtest=%regex[.*SpecTest.*]"
```

## Documentation for Authorization

Authentication schemes defined for the API:
### basicAuth

- **Type**: HTTP basic authentication

## Multithreading Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

lob-openapi@lob.com

