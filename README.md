# lob-java

This is the java wrapper for the Lob.com API.

## Frameworks
lob-java uses Guava's [ListenableFuture](https://code.google.com/p/guava-libraries/wiki/ListenableFutureExplained), the Ning
 [AsyncHttpClient](https://github.com/AsyncHttpClient/async-http-client), and the [Jackson](https://github.com/FasterXML/jackson) serialization
 library to make robust, asynchronous integration with Lob's API easy.

## Table of Contents

- [Installation](#installation)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [Supported Image Types](#supported-image-types)
- [Initialization and Configuration](#initialization-and-configuration)
- [API Reference](#api-reference)
- [Testing](#testing)

## Installation

Include the following in your `pom.xml` for Maven:

```
<dependencies>
  <dependency>
    <groupId>com.lob</groupId>
    <artifactId>lob-java-client</artifactId>
    <version>2.0.0-SNAPSHOT</version>
  </dependency>
  ...
</dependencies>
```

## Project Structure

- **lob-java** contains the actual client for interacting with Lob's API. It depends on **guava**, **asynchttpclient**, **joda-money**, **joda-time**, **jackson-annotations**, and two **jackson-databind** packages.
- **lob-java-examples** contains usage examples and is not intended to be consumed by your code.

## Usage

We've provided examples in the `lob-java-examples/` package that has examples of
how to use the lob-java wrapper with some of our core endpoints.

## Supported Image Types
The Lob.com API supports the following image types:

- PDF
- PNG
- JPEG

For more information on prepping the images please see the [Lob documentation](https://lob.com/docs/python#prepping).

## HTML Support

The Lob.com API also supports HTML strings in lieu of a file of the above type. See below for examples of submitting with HTML strings.

For templates and more information regarding HTML, please see the [Lob documentation](https://lob.com/docs/python#html-fonts).

## Initialization and Configuration

To initialize the wrapper, create an instance of `AsyncLobClient` as follows:

```java
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;

final LobClient client = AsyncLobClient.createDefault("yourApiKey");
```

You can customize your http client configuration by passing in an `AsyncHttpClientConfiguration`:

```java
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;

final AsyncHttpClientConfiguration.Builder configBuilder = new AsyncHttpClientConfiguration.Builder();

// configuration...

final LobClient client = AsyncLobClient.create("yourApiKey", configBuilder.build());
```

You may optionally set an API version. This is useful for testing your code against new API versions before you upgrade.

Note that setting the API version only affects future instances of `LobClient`s, so be sure to set it before creating your client.

```java
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;

Lob.setApiVersion("apiVersion");
final LobClient client = AsyncLobClient.createDefault("yourApiKey");
```

## API Reference
- [Simple Print Service](#simple-print-service)
  - [Job](#job)
    - [Job creation](#job-creation)
    - [Job listing](#job-listing)
    - [Job retrieval](#job-retrieval)
  - [Address](#address)
    - [Address creation](#address-creation)
    - [Address listing](#address-listing)
    - [Address retrieval](#address-retrieval)
    - [Address deletion](#address-deletion)
  - [Country](#country)
    - [Country listing](#country-listing)
  - [State](#state)
    - [State listing](#state-listing)
  - [Lob Object](#lob-object)
    - [Lob Object creation](#lob-object-creation)
    - [Lob Object listing](#lob-object-listing)
    - [Lob Object retrieval](#lob-object-retrieval)
    - [Lob Object deletion](#lob-object-deletion)
  - [Setting](#setting)
    - [Setting listing](#setting-listing)
    - [Setting retrieval](#setting-retrieval)
  - [Services](#service)
    - [Services listing](#service-listing)
- [Simple Postcard Service](#simple-postcard-service)
  - [Postcard](#postcard)
    - [Postcard creation](#postcard-creation)
    - [Postcard listing](#postcard-listing)
    - [Postcard retrieval](#postcard-retrieval)
- [Simple Letter Service](#simple-letter-service)
  - [Letter](#letter)
    - [Letter creation](#letter-creation)
    - [Letter listing](#letter-listing)
    - [Letter retrieval](#letter-retrieval)
- [Simple Check Service](#simple-check-service)
  - [Check](#check)
    - [Check creation](#check-creation)
    - [Check listing](#check-listing)
    - [Check retrieval](#check-retrieval)
  - [BankAccount](#bankaccount)
    - [BankAccount creation](#bankaccount-creation)
    - [BankAccount listing](#bankaccount-listing)
    - [BankAccount retrieval](#bankaccount-retrieval)
- [Simple Area Mail](#simple-area-mail)
  - [Area](#area)
    - [Area creation](#area-creation)
    - [Area listing](#area-listing)
    - [Area retrieval](#area-retrieval)
  - [Route](#route)
    - [Route listing](#route-listing)
- [Address Verification](#address-verification)
  - [Verification](#verification)
    - [Verification creation](#verification-creation)

## Simple Print Service

### Job

#### Job listing

```java
// Returns a list of Job objects
final ListenableFuture<JobResponseList> jobs = client.getJobs();

// Can specify count and offset as well
final int count = 5;
final int offset = 1;
final ListenableFuture<JobResponseList> jobs = client.getJobs(count, offset);
```

#### Job retrieval

```java
// Retrieve a specific job by id
final ListenableFuture<JobResponse> job = client.getJob(<id>);
```

#### Job creation

```java
// Create Job Using IDs for Address and Object
final JobRequest.Builder jobBuilder = JobRequest.builder();

final JobRequest jobRequest = builder
    .to(<addressId>)
    .from(<addressId)
    .objectId(<objectId>)
    .build();

final ListenableFuture<JobResponse> job = client.createJob(jobRequest);

// Create a Job Using Lob Java Objects
final AddressResponseList addresses = client.getAddresses(2).get();
final LobObject object = client.getLobObjects(1).get().get(0);

final JobRequest jobRequest = JobRequest.builder()
    .to(addresses.get(0))
    .from(addresses.get(1))
    .object(object)
    .build();

final ListenableFuture<JobResponse> job = client.createJob(jobRequest);

// Create Job Using Inline Address and Object
final JobRequest jobRequest = JobRequest.builder()
    .to(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        st.city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .from(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .object(LobObjectRequest.builder()
        .file("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
        .setting(200)
        .build())
    .build();

final ListenableFuture<JobResponse> jobResponse = client.createJob(jobRequest);

// Create a Multi-Object Job
final JobRequest jobRequest = JobRequest.builder()
    .to(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .from(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .objects(
        LobObjectRequest.builder()
            .file("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
            .setting(201)
            .build(),
        LobObjectRequest.builder()
            .file("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
            .setting(200)
            .build())
    .build();

final ListenableFuture<JobResponse> jobResponse = client.createJob(jobRequest);

```

### Address

#### Address listing

```java
// List addresses
final ListenableFuture<AddressResponseList> addresses = client.getAddresses();

// List Addresses with Count and Offset
final int count = 5;
final int offset = 2;

final ListenableFuture<AddressResponseList> addresses = client.getAddresses(count, offset);
```

#### Address retrieval
```java
// You can query an address with its `ID`
final ListenableFuture<AddressResponse> address = client.getAddress(<id>);
```

#### Address creation
```java
// Basic Address Create
final AddressRequest addressRequest = AddressRequest.builder()
    .name("Joe Smith")
    .line1("104, Printing Boulevard")
    .city("Boston")
    .state("MA")
    .zip("12345")
    .country("US")
    .build();

final ListenableFuture<AddressResponse> address = client.createAddress(addressRequest);

// Create Address with Optional Parameters
final AddressRequest addressRequest = AddressRequest.builder()
    .name("Joe Smith")
    .email("support@lob.com")
    .phone("555-555-5555")
    .line1("104, Printing Boulevard")
    .line2("Sunset Town")
    .city("Boston")
    .state("MA")
    .zip("12345")
    .country("US")
    .build();

final ListenableFuture<AddressResponse> address = client.createAddress(addressRequest);
```

#### Address deletion
```java
// Delete an address
final ListenableFuture<AddressDeleteResponse> deleteResponse = client.deleteAddress(<id>);
```

### Country

#### Country listing
```java
// Returns a list of Country objects
final ListenableFuture<CountryResponseList> countries = client.getCountries();
```

### State

#### State listing
```java
// Returns a list of State objects
final ListenableFuture<StateResponseList> states = client.getStates();
```

### Lob Object

#### Lob Object listing

```java
// Returns a list of lob objects
final ListenableFuture<LobObjectResponseList> objects = client.getLobObjects();

// Can specify count and offset
final int count = 4;
final int offset = 2;
final ListenableFuture<LobObjectResponseList> objects = client.getLobObjects(count, offset);
```

#### Lob Object retrieval

```java
// Retrieve a specifc object
final ListenableFuture<LobObjectResponse> object = client.getLobObject(<id>);
```

#### Lob Object creation

```java
// Create an Object using a URL
final LobObjectRequest objectRequest = LobObjectRequest.builder()
    .file("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
    .setting(200)
    .quantity(1)
    .build();
final ListenableFuture<LobObjectResponse> object = client.createLobObject(objectRequest);

// Create an Object using a local file
final File file = new File("/path/to/local/file");
final LobObjectRequest objectRequest = LobObjectRequest.builder()
    .file(file)
    .setting(200)
    .quantity(1)
    .build();
final ListenableFuture<LobObjectResponse> object = client.createLobObject(objectRequest);

// Create an Object using HTML
final LobObjectRequest objectRequest = LobObjectRequest.builder()
    .file("<html style="margin: 130px; font-size: 50;">HTML here</html>")
    .setting(200)
    .quantity(1)
    .build();
final ListenableFuture<LobObjectResponse> object = client.createLobObject(objectRequest);
```

#### Lob Object deletion

```java
// Delete an object via its ID
final ListenableFuture<LobObjectDeleteResponse> objectDeleteResponse = client.deleteLobObject(<id>);
```

### Setting

#### Setting listing

```java
// List All Settings
final ListenableFuture<SettingResponseList> settings = client.getSettings();
```

#### Setting retrieval

```java
// Retrieve a Setting
final ListenableFuture<SettingResponseList> settings = client.getSetting(SettingId.parse(100));
```

### Service

#### Service listing

```java
// List All Services
final ListenableFuture<ServiceResponseList> services = client.getServices();
```

## Simple Postcard Service

### Postcard

#### Postcard listing

```java
// Returns a list of Postcard objects
final ListenableFuture<PostcardResponseList> postcards = client.getPostcards();

// Can specify count and offset
final int count = 4;
final int offset = 2;
final ListenableFuture<PostcardResponseList> postcards = client.getPostcards(count, offset);
```

#### Postcard retrieval
```java
// Retrieve a specific postcard by id
final ListenableFuture<PostcardResponse> postcard = client.getPostcard(<id>);
```

#### Postcard creation
```java
// Create a Postcard Using IDs for Address
final PostcardRequest postcardRequest = PostcardRequest.builder()
    .to(<addressId>)
    .from(<addressId>)
    .front("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
    .back("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
    .build();
final ListenableFuture<PostcardResponse> postcard = client.createPostcard(postcardRequest);

// Create a Postcard Using Lob Java Objects
final AddressResponseList addresses = client.getAddresses(2).get();

final PostcardRequest postcardRequest = PostcardRequest.builder()
    .to(addresses.get(0))
    .from(addresses.get(1))
    .front("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
    .back("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
    .build();
final ListenableFuture<PostcardResponse> postcard = client.createPostcard(postcardRequest);

// Create Postcard Using Inline Addresses
final PostcardRequest postcardRequest = PostcardRequest.builder()
    .to(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .from(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .front("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
    .back("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
    .build();
final ListenableFuture<PostcardResponse> postcard = client.createPostcard(postcardRequest);

// Create Postcard Using Inline Addresses and Local File
final File file = new File("/path/to/local/file");
final PostcardRequest postcardRequest = PostcardRequest.builder()
    .to(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .from(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .front(file)
    .back(file)
    .build();
final ListenableFuture<PostcardResponse> postcard = client.createPostcard(postcardRequest);

// Create a Postcard Using HTML
final PostcardRequest postcardRequest = PostcardRequest.builder()
    .to(<addressId>)
    .from(<addressId>)
    .front("<html style="margin: 130px; font-size: 50;">Front HTML</html>")
    .back("<html style="margin: 130px; font-size: 50;">Back HTML</html>")
    .build();
final ListenableFuture<PostcardResponse> postcard = client.createPostcard(postcardRequest);

// Create Postcard with Message Instead of Back
final PostcardRequest postcardRequest = PostcardRequest.builder()
    .to(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .from(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .front(file)
    .message("Hello, this is the message!")
    .build();
final ListenableFuture<PostcardResponse> postcard = client.createPostcard(postcardRequest);
```

## Simple Letter Service

### Letter

#### Letter listing

```java
// Returns a list of Letter objects
final ListenableFuture<LetterResponseList> letters = client.getLetters();

// Can specify count and offset
final int count = 4;
final int offset = 2;
final ListenableFuture<LetterResponseList> letters = client.getLetters(count, offset);
```

#### Letter retrieval
```java
// Retrieve a specific postcard by id
final ListenableFuture<LetterResponse> letters = client.getLetter(<id>);
```

#### Letter creation
```java
// Create a Letter Using IDs for Address
final LetterRequest letterRequest = LetterRequest.builder()
    .to(<addressId>)
    .from(<addressId>)
    .file("https://s3-us-west-2.amazonaws.com/lob-assets/letter-goblue.pdf")
    .color(true)
    .build();
final ListenableFuture<LetterResponse> letter = client.createLetter(letterRequest);

// Create Letter Using Inline Addresses
final LetterRequest letterRequest = LetterRequest.builder()
    .to(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .from(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .file("https://s3-us-west-2.amazonaws.com/lob-assets/letter-goblue.pdf")
    .color(true)
    .build();
final ListenableFuture<LetterResponse> letter = client.createLetter(letterRequest);

// Create Letter Using Inline Addresses and Local File
final File file = new File("/path/to/local/file");
final LetterRequest letterRequest = LetterRequest.builder()
    .to(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .from(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .file(file)
    .color(true)
    .build();
final ListenableFuture<LetterResponse> letter = client.createLetter(letterRequest);

// Create a Letter Using HTML
final LetterRequest letterRequest = LetterRequest.builder()
    .to(<addressId>)
    .from(<addressId>)
    .file("<html style="margin: 130px; font-size: 50;">Front HTML</html>")
    .color(true)
    .build();
final ListenableFuture<LetterResponse> letter = client.createLetter(letterRequest);

final ListenableFuture<LetterResponse> letter = client.createLetter(letterRequest);
```

## Simple Check Service

### Check

#### Check listing
```java
// Returns a list of Check objects
final ListenableFuture<CheckResponseList> checks = client.getChecks();

// Can specify count and offset
final int count = 4;
final int offset = 2;
final ListenableFuture<CheckResponseList> checks = client.getChecks(count, offset);
```

#### Check retrieval
```java
// Retrieve a specific Check by id
final ListenableFuture<CheckResponse> check = client.getCheck(<id>);
```

#### Check creation

```java
// Create Check with Address Id
final CheckRequest checkRequest = CheckRequest.builder()
    .to(<addressId>)
    .bankAccount(<bankAccountId>)
    .amount(1000)
    .memo("Services Rendered")
    .logo("https://s3-us-west-2.amazonaws.com/lob-assets/lob_check_logo.png")
    .build();
final ListenableFuture<CheckResponse> check = client.createCheck(checkRequest);

// Create Check with Inline Address
final CheckRequest checkRequest = CheckRequest.builder()
    .to(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .bankAccount(<bankAccountId>)
    .amount(1000)
    .memo("Services Rendered")
    .logo("https://s3-us-west-2.amazonaws.com/lob-assets/lob_check_logo.png")
    .build();
final ListenableFuture<CheckResponse> check = client.createCheck(checkRequest);
```

### BankAccount

#### BankAccount listing

```java
// Returns a list of BankAccount objects
final ListenableFuture<BankAccountResponseList> bankAccounts = client.getBankAccounts();

// Can specify count and offset
final int count = 4;
final int offset = 2;
final ListenableFuture<BankAccountResponseList> bankAccounts = client.getBankAccounts(count, offset);
```

#### BankAccount retrieval

```java
// Retrieve a specific BankAccount by id
final ListenableFuture<BankAccountResponse> bankAccount = client.getBankAccount(<id>);
```

#### BankAccount creation

```java
// Create Bank Account Using Address Ids
final BankAccountRequest bankAccountRequest = BankAccountRequest.builder()
    .routingNumber("123456789")
    .accountNumber("123456789")
    .signatory("John Doe")
    .bankAddress(<addressId>)
    .accountAddress(<addressId>)
    .build();
final ListenableFuture<BankAccountResponse> bankAccount = client.createBankAccount(bankAccountRequest);

// Create Bank Account with Inline Addresses
final BankAccountRequest bankAccountRequest = BankAccountRequest.builder()
    .routingNumber("123456789")
    .accountNumber("123456789")
    .signatory("John Doe")
    .bankAddress(AddressRequest.builder()
        .line1("123 Wall Street")
        .city("San Francisco")
        .state("CA")
        .zip("94158")
        .country("US")
        .build())
    .accountAddress(AddressRequest.builder()
        .name("Lob")
        .line1("185 Berry Street")
        .line2("Suite 1510")
        .city("San Francisco")
        .state("CA")
        .zip("94107")
        .country("US")
        .build())
    .build();
final ListenableFuture<BankAccountResponse> bankAccount = client.createBankAccount(bankAccountRequest);
```

#### BankAccount deletion

```java
// Delete a specific BankAccount by id
final ListenableFuture<BankAccountDeleteResponse> bankAccountDeleteResponse = client.deleteBankAccount(<id>);
```


## Simple Area Mail

### Area

#### Area listing

```java
// List areas
final ListenableFuture<AreaMailResponseList> areaMails = client.getAreaMails();

// Can specify count and offset
final int count = 4;
final int offset = 2;
final ListenableFuture<AreaMailResponseList> areaMails = client.getAreaMails(count, offset);
```

#### Area retrieval

```java
// You can query an area with its `ID`
final ListenableFuture<AreaMailResponse> areaMail = client.getAreaMail(<id>);
```

#### Area creation

```java
// Basic Area Create with Zip Codes
final AreaMailRequest areaMailRequest = AreaMailRequest.builder()
    .front("https://s3-us-west-2.amazonaws.com/lob-assets/areafront.pdf")
    .back("https://s3-us-west-2.amazonaws.com/lob-assets/areafront.pdf")
    .routesForZips("94158", "60031")
    .targetType(TargetType.ALL)
    .build();
final ListenableFuture<AreaMailResponse> areaMail = client.createAreaMail(areaMailRequest);

// Basic Area Create with Routes Object
final ZipCodeRouteResponseList routes = client.getZipCodeRoutes(
    ZipCodeRouteRequest.builder()
        .addStringZips("94158", "60031")
        .build())
    .get();
final AreaMailRequest areaMailRequest = AreaMailRequest.builder()
    .front("https://s3-us-west-2.amazonaws.com/lob-assets/areafront.pdf")
    .back("https://s3-us-west-2.amazonaws.com/lob-assets/areafront.pdf")
    .routes(routes)
    .targetType(TargetType.ALL)
    .build();
final ListenableFuture<AreaMailResponse> areaMail = client.createAreaMail(areaMailRequest);

// Basic Area Create with HTML
final AreaMailRequest areaMailRequest = AreaMailRequest.builder()
    .front("<html style="margin: 130px; font-size: 50;">Front HTML</html>")
    .back("<html style="margin: 130px; font-size: 50;">Back HTML</html>")
    .routesForZips("94158", "60031")
    .targetType(TargetType.ALL)
    .build();
final ListenableFuture<AreaMailResponse> areaMail = client.createAreaMail(areaMailRequest);

// Create Area without Optional Parameters
final AreaMailRequest areaMailRequest = AreaMailRequest.builder()
    .front("https://s3-us-west-2.amazonaws.com/lob-assets/areafront.pdf")
    .back("https://s3-us-west-2.amazonaws.com/lob-assets/areafront.pdf")
    .routesForZips("94158")
    .build();
final ListenableFuture<AreaMailResponse> areaMail = client.createAreaMail(areaMailRequest);
```

### Route

#### Route listing

```java
// Retrieve routes for given zip codes
final ListenableFuture<ZipCodeRouteResponseList> zipCodeRoutes = client.getZipCodeRoutes(
    ZipCodeRouteRequest.builder()
        .addStringZips("94158", "60031")
        .build());
```

## Address Verification

###  Verification

#### Verification creation
```java
// You can verify an address using the following code:
System.out.println(client.verifyAddress(VerifyAddressRequest.builder()
    .line1("185 Berry Street")
    .line2("Suite 1510")
    .city("San Francisco")
    .state("CA")
    .zip("94107")
    .country("US")
    .build()).get());
```
This will output:
```bash
{
  "address": {
    "address_city": "SAN FRANCISCO",
    "address_country": "US",
    "address_line1": "185 BERRY ST STE 1510",
    "address_line2": "",
    "address_state": "CA",
    "address_zip": "94107-5705"
  },
}
```

## Testing

You can run all tests with the command `mvn test` in the main directory.
