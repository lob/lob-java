# lob-java

[![Maven Central](https://img.shields.io/maven-central/v/com.lob/lob-java.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.lob%22%20AND%20a%3A%22lob-java%22)
[![Build Status](https://secure.travis-ci.org/lob/lob-java.svg)](https://travis-ci.org/lob/lob-java)
[![Coverage Status](https://coveralls.io/repos/lob/lob-java/badge.svg?branch=master)](https://coveralls.io/r/lob/lob-java)

Java wrapper for the [Lob.com](http://lob.com) API. See the full Lob.com [API Documentation](https://lob.com/docs/java).  For best results, be sure that you're using [the latest version](https://lob.com/docs/java#version) of the Lob API and the latest version of the java wrapper.

lob-java uses Guava's [ListenableFuture](https://code.google.com/p/guava-libraries/wiki/ListenableFutureExplained), the Ning [AsyncHttpClient](https://github.com/AsyncHttpClient/async-http-client), and the [Jackson](https://github.com/FasterXML/jackson) serialization library to make robust, asynchronous integration with Lob's API easy.

## Table of Contents

- [Getting Started](#getting-started)
  - [Registration](#registration)
  - [Installation](#installation)
  - [Usage](#usage)
- [Examples](#examples)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [Testing](#testing)

## Getting Started

Here's a general overview of the Lob services available, click through to read more.

- [Postcards API](https://lob.com/services/postcards)
- [Letters API](https://lob.com/services/letters)
- [Checks API](https://lob.com/services/checks)
- [Area Mail API](https://lob.com/services/area)
- [Address Verification API](https://lob.com/verification/address)

### Registration

First, you will need to first create an account at [Lob.com](https://dashboard.lob.com/#/register) and obtain your Test and Live API Keys.

Once you have created an account, you can access your API Keys from the [Settings Panel](https://dashboard.lob.com/#/settings).

### Installation

Include the following in your `pom.xml` for Maven:

```
<dependencies>
  <dependency>
    <groupId>com.lob</groupId>
    <artifactId>lob-java</artifactId>
    <version>3.3.0</version>
  </dependency>
  ...
</dependencies>
```

### Usage

We've provided examples in the `lob-java-examples/` package that has examples of how to use the lob-java wrapper with some of our core endpoints.

#### Project Structure

- **lob-java** contains the actual client for interacting with Lob's API. It depends on:
  - guava
  - asynchttpclient
  - netty
  - joda-money
  - joda-time
  - jackson-annotations
  - two jackson-databind packages
- **lob-java-examples** contains usage examples and is not intended to be consumed by your code.

#### Initialization and Configuration

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

#### Callbacks
Please ensure any callbacks attached to the `ListenableFuture`s returned from the `LobClient` have a dedicated `Executor`
for their execution. Otherwise, the callbacks will be executed on internal I/O threads, adversely affecting performance.

## Examples

We've provided various examples for you to try out [here](https://github.com/lob/lob-java/tree/master/lob-java-examples/src/main/java/com/lob/examples).

There are simple scripts to demonstrate how to create all the core Lob objects (checks, letters, postcards, etc.) As well as more complex examples that utilize other libraries and external files:

- [Verifying Addresses in a CSV](https://github.com/lob/lob-java/blob/master/lob-java-examples/src/main/java/com/lob/examples/CsvVerificationExample.java)
- [Async Job Example](https://github.com/lob/lob-java/blob/master/lob-java-examples/src/main/java/com/lob/examples/AsyncJobExample.java)

## API Documentation

- [Introduction](https://lob.com/docs/java#introduction)
- [Versioning](https://lob.com/docs/java#version)
- [Errors](https://lob.com/docs/java#errors)
- [Rate Limiting](https://lob.com/docs/java#rate-limits)
- [Metadata](https://lob.com/docs/java#metadata)
- **Addresses**
  - [Address Book](https://lob.com/docs/java#addresses)
    - [Create an Address](https://lob.com/docs/java#addresses_create)
    - [Retrieve an Address](https://lob.com/docs/java#addresses_retrieve)
    - [Delete an Address](https://lob.com/docs/java#addresses_delete)
    - [List all Addresses](https://lob.com/docs/java#addresses_list)
  - [Address Verification API](https://lob.com/docs/java#verify)
    - [Verify an Address](https://lob.com/docs/java#verify_create)
- **Postcards API**
  - [Postcards](https://lob.com/docs/java#postcards)
    - [Create a Postcard](https://lob.com/docs/java#postcards_create)
    - [Retrieve a Postcard](https://lob.com/docs/java#postcards_retrieve)
    - [List all Postcards](https://lob.com/docs/java#postcards_list)
- **Letters API**
  - [Letters](https://lob.com/docs/java#letters)
    - [Create a Letter](https://lob.com/docs/java#letters_create)
    - [Retrieve a Letter](https://lob.com/docs/java#letters_retrieve)
    - [List all Letters](https://lob.com/docs/java#letters_list)
- **Checks API**
  - [Checks](https://lob.com/docs/java#checks)
    - [Create a Check](https://lob.com/docs/java#checks_create)
    - [Retrieve a Check](https://lob.com/docs/java#checks_retrieve)
    - [List all Checks](https://lob.com/docs/java#checks_list)
  - [Bank Accounts](https://lob.com/docs/java#bank-accounts)
    - [Create a Bank Account](https://lob.com/docs/java#bankaccounts_create)
    - [Retrieve a Bank Account](https://lob.com/docs/java#bankaccounts_retrieve)
    - [Delete a Bank Account](https://lob.com/docs/java#bankaccounts_delete)
    - [Verify a Bank Account](https://lob.com/docs/java#bankaccounts_verify)
    - [List all Bank Accounts](https://lob.com/docs/java#bankaccounts_list)
- **Area Mail API**
  - [Areas](https://lob.com/docs/java#areas)
    - [Create an Area Mailing](https://lob.com/docs/java#areas_create)
    - [Retrieve an Area Mailing](https://lob.com/docs/java#areas_retrieve)
    - [List all Area Mailings](https://lob.com/docs/java#areas_list)
  - [Routes](https://lob.com/docs/java#routes)
    - [Retrieve a Zip Code](https://lob.com/docs/java#routes_retrieve)
    - [List all Zip Codes](https://lob.com/docs/java#routes_list)
- **Resources**
  - [Countries](https://lob.com/docs/java#countries)
    - [List all Countries](https://lob.com/docs/java#countries_list)
  - [States](https://lob.com/docs/java#states)
    - [List all States](https://lob.com/docs/java#states_list)
- **Appendix**
  - [API Changelog](https://lob.com/docs/java#changelog)
  - [HTML Examples](https://lob.com/docs/java#html-examples)
  - [Image Prepping](https://lob.com/docs/java#prepping)

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Make sure the tests pass
6. Open up coverage/index.html in your browser and add tests if required
7. Create new Pull Request

## Testing

You can run all tests with the command `mvn test` in the main directory.

=======================

Copyright &copy; 2013 Lob.com

Released under the MIT License, which can be found in the repository in `LICENSE.txt`.
