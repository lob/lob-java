# Migrate from version < v13.0.0

This guide illustrates differences between Lob’s the legacy versions of this SDK and the new current version.

In this guide we compare how `v12.*.*` and >=`v13.0.0` implement the following method pattern.

- CREATE
- LIST
- GET
- DELETE
- VERIFY (BANK ACCOUNTS)
- UPDATE (TEMPLATES)

## INSTALL

Similar to the legacy version, simply update your POM file dependency as follows:

```xml
<dependency>
    <groupId>com.lob</groupId>
    <artifactId>lob-java</artifactId>
    <version>13.0.0</version>
</dependency>
```

If you are using the Spring framework, you will also need to add the following two blocks:
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

## IMPORT AND INITIALIZE

```java
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.HttpBasicAuth;
import com.lob.api.client.*;

public class Controller {
    private final ApiClient lobClient;

    Controller() {
        ApiClient client = Configuration.getDefaultApiClient();
        HttpBasicAuth basicAuth = (HttpBasicAuth) client.getAuthentication("basicAuth");
        basicAuth.setUsername("<<YOUR API KEY HERE>>");

        this.lobClient = client;
    }
}
```

You then instantiate the specific resource API that you need access to as follows:

```java
AddressesApi apiInstance = new AddressesApi(this.lobClient);
```

## METHODS

The new SDK version abstracts the request/response interaction out of the calling code such that you create the resource and pass it to the corresponding API in a try/catch such that any non-success is an `ApiException` that must be handled.

### COMPARE CREATE METHODS

Here is a sample of a legacy lob-java CREATE function:

```java
LobResponse<Address> response = new Address.RequestBuilder()
        .setDescription("Harry - Office")
        .setName("Harry Zhang")
        .setCompany("Lob")
        .setLine1("210 King St")
        .setLine2("# 6100")
        .setCity("San Francisco")
        .setState("CA")
        .setZip("94107")
        .setCountry("US")
        .setPhone("555-555-5555")
        .setEmail("harry@lob.com")
        .create();

Address address = response.getResponseBody();
```

Here is a sample of the updated CREATE method

```java
try {
    AddressEditable address = new AddressEditable();
    address.setName("Harry Zhang");
    address.setCompany("Lob");
    address.setEmail("harry@lob.com");
    address.setPhone("5555555555");
    address.setAddressLine1("210 King St");
    address.setAddressLine2("# 6100");
    address.setAddressCity("San Francisco");
    address.setAddressState("CA");
    address.setAddressZip("94107");
    address.setAddressCountry(CountryExtended.US);
    
    apiInstance.addressCreate(address);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### COMPARE CREATE METHODS WITH INLINE RECORDS

In these create operations, the required Address records are created alongside the record they are associated with.

```java
LobResponse<Letter> response = new Letter.RequestBuilder()
        .setDescription("Demo Letter")
        .setFile("https://s3-us-west-2.amazonaws.com/public.lob.com/assets/us_letter_1pg.pdf")
        .setColor(true)
        .setTo(
                new Address.RequestBuilder()
                        .setName("Harry Zhang")
                        .setLine1("210 King St Ste 6100")
                        .setCity("San Francisco")
                        .setState("CA")
                        .setZip("94107")
        )
        .setFrom("adr_210a8d4b0b76d77b")
        .create();

Letter letter = response.getResponseBody();
```

The same letter can be created as follows:

```java
try {
    AddressEditable addressTo = new AddressEditable();
    addressTo.setName("Harry Zhang");
    addressTo.setAddressLine1("210 King St");
    addressTo.setAddressLine2("# 6100");
    addressTo.setAddressCity("San Francisco");
    addressTo.setAddressState("CA");
    addressTo.setAddressZip("94107");

    LetterEditable letterRaw = new LetterEditable();
    letterRaw.setDescription("Demo Letter");
    letterRaw.setTo(addressTo);
    letterRaw.setFrom("adr_210a8d4b0b76d77b");
    letterRaw.setFile("https://s3-us-west-2.amazonaws.com/public.lob.com/assets/us_letter_1pg.pdf");
    letterRaw.setColor(true);

    Letter letter = apiInstance.create(letterRaw, null);
} catch (ApiException e) {
    e.printStackTrace();
        }
```

### COMPARE LIST METHODS

Here is a sample of a legacy lob-java LIST method:

```java
Map<String, Object> params = new HashMap<>();
    params.put("limit", 2);

    LobResponse<AddressCollection> response = Address.list(params);
    AddressCollection addresses = response.getResponseBody();
```

Here is a sample of the updated LIST method:

```java
try {
    AddressList addresses = apiInstance.list(2, null, null, null, null, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### COMPARE GET BY ID METHOD

Here is a sample of a legacy GET method:

```java
LobResponse<Address> response = Address.retrieve("adr_fa85158b26c3eb7c");
        Address address = response.getResponseBody();
```

Here is a sample of the updated SDK GET by ID method:

```java
try {
    Address address = apiInstance.get("adr_fa85158b26c3eb7c");
} catch (ApiException e) {
    e.printStackTrace();
}
```

### COMPARE DELETE METHOD

Here is a sample of the legacy DELETE method:

```java
LobResponse<Address> response = Address.delete("adr_43769b47aed248c2");
        Address address = response.getResponseBody();
```

Here is a sample of the updated SDK DELETE method:

```java
try {
    AddressDeletion address = apiInstance.delete("adr_fa85158b26c3eb7c");
} catch (ApiException e) {
    e.printStackTrace();
}
```

### COMPARE BANK ACCOUNT VERIFY

​Here is a sample of the legacy Bank Account Verify method

```java
LobResponse<BankAccount> response = BankAccount.verify(newBankAccount.getId(), Arrays.asList(25, 63));
        BankAccount bankAccount = response.getResponseBody();
```

Here is a sample of the updated SDK Bank Account Verify method:

```java
try {
        BankAccountVerify verification = new BankAccountVerify();
        verification.addAmountsItem(11);
        verification.addAmountsItem(35);
        BankAccount account = apiInstance.verify("bank_8cad8df5354d33f", verification);
} catch (ApiException e) {
        e.printStackTrace();
}
```

### TEMPLATE UPDATE METHOD

The Template Update endpoint updates the description and/or published version of the template with a given id. This is how it is done:

```java
try {
    TemplateUpdate templateUpdate = new TemplateUpdate();
    templateUpdate.setDescription("Updated Example");
    templateUpdate.setPublishedVersion("vrsn_a");

    Template template = apiInstance.update("tmpl_c94e83ca2cd5121", templateUpdate);
} catch (ApiException e) {
    e.printStackTrace();
}
```
