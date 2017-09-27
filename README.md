# lob-java

[![Maven Central](https://img.shields.io/maven-central/v/com.lob/lob-java.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.lob%22%20AND%20a%3A%22lob-java%22)
[![Build Status](https://secure.travis-ci.org/lob/lob-java.svg)](https://travis-ci.org/lob/lob-java)
[![Coverage Status](https://coveralls.io/repos/lob/lob-java/badge.svg?branch=master)](https://coveralls.io/r/lob/lob-java)

Java wrapper for the [Lob.com](http://lob.com) API. See the full Lob.com [API Documentation](https://lob.com/docs/java).  For best results, be sure that you're using [the latest version](https://lob.com/docs/java#version) of the Lob API and the latest version of the java wrapper.

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

Please read through the official [API Documentation](#api-documentation) to get a complete sense of what to expect from each endpoint.

### Registration

First, you will need to first create an account at [Lob.com](https://dashboard.lob.com/#/register) and obtain your Test and Live API Keys.

Once you have created an account, you can access your API Keys from the [Settings Panel](https://dashboard.lob.com/#/settings).

### Installation

Include the following in your `pom.xml` for Maven:

```xml
<dependencies>
  <dependency>
    <groupId>com.lob</groupId>
    <artifactId>lob-java</artifactId>
    <version>7.0.0</version>
  </dependency>
  ...
</dependencies>
```

Gradle:

```groovy
compile 'com.lob:lob-java:7.0.0'
```

### Usage

We've provided examples in the `lob-java-examples/` package that has examples of how to use the lob-java wrapper with some of our core endpoints.

#### Initialization and Configuration
```java
import com.lob;

Lob.init("yourApiKey");
```

You may optionally set an API version. This is useful for testing your code against new API versions before you upgrade.
```java
import com.lob;

Lob.init("yourApiKey", "yourApiVersion");
```

## API Documentation

- [Introduction](https://lob.com/docs/java#introduction)
- [Versioning](https://lob.com/docs/java#version)
- [Errors](https://lob.com/docs/java#errors)
- [Rate Limiting](https://lob.com/docs/java#rate-limits)
- [Webhooks](https://lob.com/docs/java#webhooks)
- [Cancellation Windows](https://lob.com/docs/java#cancellation)
- [Scheduled Mailings](https://lob.com/docs/java#scheduled)
- [Metadata](https://lob.com/docs/java#metadata)
- [HTML Templates](https://lob.com/docs/java#templates)
- [Asset URLs](https://lob.com/docs/java#urls)
- **Addresses**
  - [Address Book](https://lob.com/docs/java#addresses)
    - [The Address Object](https://lob.com/docs/java#addresses_object)
    - [Create an Address](https://lob.com/docs/java#addresses_create)
    - [Retrieve an Address](https://lob.com/docs/java#addresses_retrieve)
    - [Delete an Address](https://lob.com/docs/java#addresses_delete)
    - [List all Addresses](https://lob.com/docs/java#addresses_list)
- **US Verification API**
  - [US Verification API](https://lob.com/docs/java#us_verifications)
    - [The US Verification Object](https://lob.com/docs/java#us_verifications_object)
    - [Verify a US Address](https://lob.com/docs/java#us_verifications_create)
- **Int'l Verification API**
  - [International Verifications](https://lob.com/docs/java#intl_verifications)
    - [Verify an International Address](https://lob.com/docs/java#intl_verifications_create)
- **Postcards API**
  - [Postcards](https://lob.com/docs/java#postcards)
    - [The Postcard Object](https://lob.com/docs/java#postcards_object)
    - [Create a Postcard](https://lob.com/docs/java#postcards_create)
    - [Retrieve a Postcard](https://lob.com/docs/java#postcards_retrieve)
    - [Cancel a Postcard](https://lob.com/docs/java#postcards_delete)
    - [List all Postcards](https://lob.com/docs/java#postcards_list)
- **Letters API**
  - [Letters](https://lob.com/docs/java#letters)
    - [The Letter Object](https://lob.com/docs/java#letters_object)
    - [Create a Letter](https://lob.com/docs/java#letters_create)
    - [Retrieve a Letter](https://lob.com/docs/java#letters_retrieve)
    - [Cancel a Letter](https://lob.com/docs/java#letters_delete)
    - [List all Letters](https://lob.com/docs/java#letters_list)
- **Checks API**
  - [Checks](https://lob.com/docs/java#checks)
    - [The Check Object](https://lob.com/docs/java#checks_object)
    - [Create a Check](https://lob.com/docs/java#checks_create)
    - [Retrieve a Check](https://lob.com/docs/java#checks_retrieve)
    - [Cancel a Check](https://lob.com/docs/java#checks_delete)
    - [List all Checks](https://lob.com/docs/java#checks_list)
  - [Bank Accounts](https://lob.com/docs/java#bank-accounts)
    - [The Bank Account Object](https://lob.com/docs/java#bankaccounts_object)
    - [Create a Bank Account](https://lob.com/docs/java#bankaccounts_create)
    - [Retrieve a Bank Account](https://lob.com/docs/java#bankaccounts_retrieve)
    - [Delete a Bank Account](https://lob.com/docs/java#bankaccounts_delete)
    - [Verify a Bank Account](https://lob.com/docs/java#bankaccounts_verify)
    - [List all Bank Accounts](https://lob.com/docs/java#bankaccounts_list)
- **Area Mail API**
  - [Areas](https://lob.com/docs/java#areas)
    - [The Area Object](https://lob.com/docs/java#areas_object)
    - [Create an Area Mailing](https://lob.com/docs/java#areas_create)
    - [Retrieve an Area Mailing](https://lob.com/docs/java#areas_retrieve)
    - [List all Area Mailings](https://lob.com/docs/java#areas_list)
  - [Routes](https://lob.com/docs/java#routes)
    - [The Routes Object](https://lob.com/docs/java#routes_object)
    - [Retrieve Routes](https://lob.com/docs/java#routes_retrieve)
    - [List all Routes](https://lob.com/docs/java#routes_list)
- **Resources**
  - [Countries](https://lob.com/docs/java#countries)
    - [List all Countries](https://lob.com/docs/java#countries_list)
  - [States](https://lob.com/docs/java#states)
    - [List all States](https://lob.com/docs/java#states_list)
- **Appendix**
  - [API Changelog](https://lob.com/docs/java#changelog)
  - [The Tracking Event Object](https://lob.com/docs/java#tracking_event_object)
  - [Events](https://lob.com/docs/java#events)
  - [HTML Examples](https://lob.com/docs/java#html-examples)
  - [Image Prepping](https://lob.com/docs/java#prepping)
  - [US Verification Details](https://lob.com/docs/java#us_verification_details)


## Testing

You can run all tests with the command `mvn test` in the main directory.

=======================

Copyright &copy; 2017 Lob.com

Released under the MIT License, which can be found in the repository in `LICENSE.txt`.
