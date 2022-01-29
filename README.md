# lob-java

[![Maven Central](https://img.shields.io/maven-central/v/com.lob/lob-java.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.lob%22%20AND%20a%3A%22lob-java%22)
[![Build Status](https://secure.travis-ci.org/lob/lob-java.svg)](https://travis-ci.org/lob/lob-java)
[![Coverage Status](https://coveralls.io/repos/lob/lob-java/badge.svg?branch=master)](https://coveralls.io/r/lob/lob-java)

Java wrapper for the [Lob.com](https://lob.com) API. See the full Lob.com [API Documentation](https://lob.com/docs/java).  For best results, be sure that you're using [the latest version](https://lob.com/docs/java#version) of the Lob API and the latest version of the java wrapper.

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Getting Started](#getting-started)
  - [Registration](#registration)
  - [Installation](#installation)
  - [Usage](#usage)
    - [Initialization and Configuration](#initialization-and-configuration)
- [Testing](#testing)

## Getting Started

Here's a general overview of the Lob services available, click through to read more.

- [Postcards API](https://lob.com/products/print-mail/postcards)
- [Letters API](https://lob.com/products/print-mail/letters)
- [Checks API](https://lob.com/products/print-mail/checks)
- [Address Verification API](https://lob.com/products/address-verification)

Please read through the official [API Documentation](https://docs.lob.com/) to get a complete sense of what to expect from each endpoint.

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
    <version>12.2.0</version>
  </dependency>
  ...
</dependencies>
```

Gradle:

```groovy
compile 'com.lob:lob-java:12.2.0'
```

### Usage

We've provided examples in a separate repository [lob-java-examples](https://github.com/lob/lob-java-examples). It has examples of how to use the lob-java wrapper with some of our core endpoints.

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

## Testing

You can run all tests with the command `LOB_API_KEY=<your_test_api_key> mvn test` in the main directory.

=======================

Copyright &copy; 2020 Lob.com

Released under the MIT License, which can be found in the repository in `LICENSE.txt`.
