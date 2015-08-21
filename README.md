# lob-java

[![Maven Central](https://img.shields.io/maven-central/v/com.lob/lob-java.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.lob%22%20AND%20a%3A%22lob-java%22)
[![Build Status](https://secure.travis-ci.org/lob/lob-java.png)](https://travis-ci.org/lob/lob-java)
[![Coverage Status](https://coveralls.io/repos/javadev/lob-java/badge.png?branch=master)](https://coveralls.io/r/javadev/lob-java)

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

- [Simple Postcard Service](https://lob.com/services/postcards)
- [Simple Letter Service](https://lob.com/services/letters)
- [Simple Check Service](https://lob.com/services/checks)
- [Simple Print Service](https://lob.com/services/sps)
- [Simple Area Mail](https://lob.com/services/sam)
- [Address Verification](https://lob.com/verification/address)

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
    <version>2.2.0</version>
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
- [Metadata](https://lob.com/docs/java#metadata)
- **Addresses**
  - [Address Book](https://lob.com/docs/java#addresses)
    - [Create an Address](https://lob.com/docs/java#addresses_create)
    - [Retrieve an Address](https://lob.com/docs/java#addresses_retrieve)
    - [Delete an Address](https://lob.com/docs/java#addresses_delete)
    - [List all Addresses](https://lob.com/docs/java#addresses_list)
  - [Simple Address Verification](https://lob.com/docs/java#verify)
    - [Verify an Address](https://lob.com/docs/java#verify_create)
- **Simple Postcard Service**
  - [Postcards](https://lob.com/docs/java#postcards)
    - [Create a Postcard](https://lob.com/docs/java#postcards_create)
    - [Retrieve a Postcard](https://lob.com/docs/java#postcards_retrieve)
    - [List all Postcards](https://lob.com/docs/java#postcards_list)
- **Simple Letter Service**
  - [Letters](https://lob.com/docs/java#letters)
    - [Create a Letter](https://lob.com/docs/java#letters_create)
    - [Retrieve a Letter](https://lob.com/docs/java#letters_retrieve)
    - [List all Letters](https://lob.com/docs/java#letters_list)
- **Simple Check Service**
  - [Checks](https://lob.com/docs/java#checks)
    - [Create a Check](https://lob.com/docs/java#checks_create)
    - [Retrieve a Check](https://lob.com/docs/java#checks_retrieve)
    - [List all Checks](https://lob.com/docs/java#checks_list)
  - [Bank Accounts](https://lob.com/docs/java#bank-accounts)
    - [Create a Bank Account](https://lob.com/docs/java#bankaccounts_create)
    - [Retrieve a Bank Account](https://lob.com/docs/java#bankaccounts_retrieve)
    - [List all Bank Accounts](https://lob.com/docs/java#bankaccounts_list)
    - [Verify a Bank Account](https://lob.com/docs/java#bankaccounts_verify)
    - [Delete a Bank Account](https://lob.com/docs/java#bankaccounts_delete)
- **Simple Print Service**
  - [Jobs](https://lob.com/docs/java#jobs)
    - [Create a Job](https://lob.com/docs/java#jobs_create)
    - [Create a MultiObject Job](https://lob.com/docs/java#jobs_multi)
    - [Retrieve a Job](https://lob.com/docs/java#jobs_retrieve)
    - [List all Jobs](https://lob.com/docs/java#jobs_list)
  - [Objects](https://lob.com/docs/java#objects)
    - [Create an Object](https://lob.com/docs/java#objects_create)
    - [Retrieve an Object](https://lob.com/docs/java#objects_retrieve)
    - [Delete an Object](https://lob.com/docs/java#objects_delete)
    - [List all Objects](https://lob.com/docs/java#objects_list)
  - [Settings](https://lob.com/docs/java#settings)
    - [Retrieve a Setting](https://lob.com/docs/java#settings_retrieve)
    - [List all Settings](https://lob.com/docs/java#settings_list)
- **Simple Area Mail**
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
  - [HTML Examples](https://lob.com/docs/java#html-examples)
  - [Image Prepping](https://lob.com/docs/java#prepping)
  - [SPS Templates](https://lob.com/docs/java#sps-templates)

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
