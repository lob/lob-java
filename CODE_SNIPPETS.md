# Code Snippets

## Address Api

### Create
```bash
curl https://api.lob.com/v1/addresses \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Harry - Office" \
  -d "name=Harry Zhang" \
  -d "company=Lob" \
  -d "email=harry@lob.com" \
  -d "phone=5555555555" \
  -d "address_line1=210 King St" \
  -d "address_line2=# 6100" \
  -d "address_city=San Francisco" \
  -d "address_state=CA" \
  -d "address_zip=94107" \
  -d "address_country=US"
```

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

### Retrieve
```bash
curl https://api.lob.com/v1/addresses/adr_fa85158b26c3eb7c \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    Address address = apiInstance.get("adr_fa85158b26c3eb7c");
} catch (ApiException e) {
    e.printStackTrace();
}
```

### List
```bash
curl -X GET "https://api.lob.com/v1/addresses/?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    AddressList addresses = apiInstance.list(2, null, null, null, null, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Delete
```bash
curl -X DELETE https://api.lob.com/v1/addresses/adr_43769b47aed248c2 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    AddressDeletion address = apiInstance.delete("adr_fa85158b26c3eb7c");
} catch (ApiException e) {
    e.printStackTrace();
}
```

## Postcards Api

### Create
```bash
curl https://api.lob.com/v1/postcards \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d 'description=Demo Postcard job' \
  -d 'to[name]=Harry Zhang' \
  -d 'to[address_line1]=210 King St' \
  -d 'to[address_line2]=# 6100' \
  -d 'to[address_city]=San Francisco' \
  -d 'to[address_state]=CA' \
  -d 'to[address_zip]=94107' \
  -d 'from=adr_210a8d4b0b76d77b' \
  --data-urlencode 'front=<html style="padding: 1in; font-size: 50;">Front HTML for {{name}}</html>' \
  --data-urlencode 'back=<html style="padding: 1in; font-size: 20;">Back HTML for {{name}}</html>' \
  -d 'merge_variables[name]=Harry'
```

```java
try {
    AddressEditable toAddress = new AddressEditable();
    toAddress.setDescription("Harry - Office");
    toAddress.setName("Harry Zhang");
    toAddress.setCompany("Lob");
    toAddress.setEmail("harry@lob.com");
    toAddress.setPhone("5555555555");
    toAddress.setAddressLine1("210 King St");
    toAddress.setAddressLine2("# 6100");
    toAddress.setAddressCity("San Francisco");
    toAddress.setAddressState("CA");
    toAddress.setAddressZip("94107");
    toAddress.setAddressCountry(CountryExtended.US);

    AddressEditable fromAddress = new AddressEditable();
    fromAddress.setDescription("Harry - Office");
    fromAddress.setName("Harry Zhang");
    fromAddress.setCompany("Lob");
    fromAddress.setEmail("harry@lob.com");
    fromAddress.setPhone("5555555555");
    fromAddress.setAddressLine1("210 King St");
    fromAddress.setAddressLine2("# 6100");
    fromAddress.setAddressCity("San Francisco");
    fromAddress.setAddressState("CA");
    fromAddress.setAddressZip("94107");
    fromAddress.setAddressCountry(CountryExtended.US);

    PostcardEditable postcardRaw = new PostcardEditable();
    postcardRaw.setDescription("demo");
    postcardRaw.setTo(toAddress);
    postcardRaw.setFrom(fromAddress);
    postcardRaw.setFront("tmpl_a1234dddg");
    postcardRaw.setBack("tmpl_a1234dddg");
    postcardRaw.setSize(PostcardSize._6X9);
    postcardRaw.setMailType(MailType.FIRST_CLASS);

    Postcard postcard = apiInstance.create(postcardRaw, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Retrieve
```bash
curl https://api.lob.com/v1/postcards/psc_5c002b86ce47537a \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    Postcard postcard = apiInstance.get("psc_208e45e48d271294");
} catch (ApiException e) {
    e.printStackTrace();
}
```

### List
```bash
curl -X GET "https://api.lob.com/v1/postcards?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    PostcardList postcards = apiInstance.list(2, null, null, null, null, null, null, null, null, null, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Cancel
```bash
curl -X DELETE https://api.lob.com/v1/postcards/psc_5c002b86ce47537a \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    PostcardDeletion address = apiInstance.cancel("psc_208e45e48d271294");
} catch (ApiException e) {
    e.printStackTrace();
}
```

## SelfMailers Api

### Create
```bash
curl https://api.lob.com/v1/self_mailers \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Demo Self Mailer job" \
  -d "to[name]=Harry Zhang" \
  -d "to[address_line1]=210 King St" \
  -d "to[address_city]=San Francisco" \
  -d "to[address_state]=CA" \
  -d "to[address_zip]=94107" \
  -d "from=adr_210a8d4b0b76d77b" \
  --data-urlencode "inside=<html style='padding: 1in; font-size: 50;'>Inside HTML for {{name}}</html>" \
  --data-urlencode "outside=<html style='padding: 1in; font-size: 20;'>Outside HTML for {{name}}</html>" \
  -d "merge_variables[name]=Harry"
```

```java
try {
    AddressEditable toAddress = new AddressEditable();
    toAddress.setDescription("Harry - Office");
    toAddress.setName("Harry Zhang");
    toAddress.setCompany("Lob");
    toAddress.setEmail("harry@lob.com");
    toAddress.setPhone("5555555555");
    toAddress.setAddressLine1("210 King St");
    toAddress.setAddressLine2("# 6100");
    toAddress.setAddressCity("San Francisco");
    toAddress.setAddressState("CA");
    toAddress.setAddressZip("94107");
    toAddress.setAddressCountry(CountryExtended.US);

    AddressEditable fromAddress = new AddressEditable();
    fromAddress.setDescription("Harry - Office");
    fromAddress.setName("Harry Zhang");
    fromAddress.setCompany("Lob");
    fromAddress.setEmail("harry@lob.com");
    fromAddress.setPhone("5555555555");
    fromAddress.setAddressLine1("210 King St");
    fromAddress.setAddressLine2("# 6100");
    fromAddress.setAddressCity("San Francisco");
    fromAddress.setAddressState("CA");
    fromAddress.setAddressZip("94107");
    fromAddress.setAddressCountry(CountryExtended.US);

    SelfMailerEditable mailerRaw = new SelfMailerEditable();
    mailerRaw.setTo(toAddress);
    mailerRaw.setFrom(objectMapper.writeValueAsString(fromAddress));

    SelfMailer selfMailer = apiInstance.create(mailerRaw, null);
} catch (ApiException | JsonProcessingException e) {
    e.printStackTrace();
}
```

### Retrieve
```bash
curl -X GET "https://api.lob.com/v1/self_mailers/sfm_8ffbe811dea49dcf" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    SelfMailer selfMailer = apiInstance.get("sfm_8ffbe811dea49dcf");
} catch (ApiException e) {
    e.printStackTrace();
}
```

### List
```bash
curl -X GET "https://api.lob.com/v1/self_mailers?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    SelfMailerList selfMailer = apiInstance.list(2, null, null, null, null, null, null, null, null, null, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Delete
```bash
curl -X DELETE https://api.lob.com/v1/self_mailers/sfm_8ffbe811dea49dcf \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    SelfMailerDeletion selfMailer = apiInstance.delete("sfm_8ffbe811dea49dcf");
} catch (ApiException e) {
    e.printStackTrace();
}
```

## Letters Api

### Create
```bash
curl https://api.lob.com/v1/letters \
  -u YOUR_API_KEY \
  -d 'description=Demo Letter' \
  -d 'to[name]=Harry Zhang' \
  -d 'to[address_line1]=210 King St' \
  -d 'to[address_line2]=# 6100' \
  -d 'to[address_city]=San Francisco' \
  -d 'to[address_state]=CA' \
  -d 'to[address_zip]=94107' \
  -d 'from=adr_210a8d4b0b76d77b' \
  --data-urlencode 'file=<html style="padding-top: 3in; margin: .5in;">HTML Letter for {{name}}</html>' \
  -d 'merge_variables[name]=Harry' \
  -d 'color=true' \
  -d 'cards[]=card_c51ae96f5cebf3e'

```

```java
try {
    AddressEditable addressTo = new AddressEditable();
    addressTo.setName("Harry Zhang");
    addressTo.setCompany("Lob");
    addressTo.setEmail("harry@lob.com");
    addressTo.setPhone("5555555555");
    addressTo.setAddressLine1("210 King St");
    addressTo.setAddressLine2("# 6100");
    addressTo.setAddressCity("San Francisco");
    addressTo.setAddressState("CA");
    addressTo.setAddressZip("94107");
    addressTo.setAddressCountry(CountryExtended.US);

    AddressEditable addressFrom = new AddressEditable();
    addressFrom.setName("Harry Zhang");
    addressFrom.setCompany("Lob");
    addressFrom.setEmail("harry@lob.com");
    addressFrom.setPhone("5555555555");
    addressFrom.setAddressLine1("210 King St");
    addressFrom.setAddressLine2("# 6100");
    addressFrom.setAddressCity("San Francisco");
    addressFrom.setAddressState("CA");
    addressFrom.setAddressZip("94107");
    addressFrom.setAddressCountry(CountryExtended.US);

    LetterEditable letterRaw = new LetterEditable();
    letterRaw.setDescription("demo");
    letterRaw.setTo(addressTo);
    letterRaw.setFrom(addressFrom);
    letterRaw.setFile("https://s3-us-west-2.amazonaws.com/public.lob.com/assets/us_letter_1pg.pdf");
    letterRaw.setColor(true);
    letterRaw.setExtraService(LetterEditable.ExtraServiceEnum.CERTIFIED);

    Letter letter = apiInstance.create(letterRaw, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Retrieve
```bash
curl https://api.lob.com/v1/letters/ltr_4868c3b754655f90 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    Letter letter = apiInstance.get("ltr_4868c3b754655f90");
} catch (ApiException e) {
    e.printStackTrace();
}
```

### List
```bash
curl -X GET "https://api.lob.com/v1/letters?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    LetterList letters = apiInstance.list(2, null, null, null, null, null, null, null, null, null, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Cancel
```bash
curl -X DELETE https://api.lob.com/v1/letters/ltr_4868c3b754655f90 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    LetterDeletion letter = apiInstance.cancel("ltr_4868c3b754655f90");
} catch (ApiException e) {
    e.printStackTrace();
}
```

## Checks Api

### Create
```bash
curl https://api.lob.com/v1/checks \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d 'description=Demo Check' \
  -d 'to[name]=Harry Zhang' \
  -d 'to[address_line1]=210 King St' \
  -d 'to[address_line2]=# 6100' \
  -d 'to[address_city]=San Francisco' \
  -d 'to[address_state]=CA' \
  -d 'to[address_zip]=94107' \
  -d 'from=adr_210a8d4b0b76d77b' \
  -d 'bank_account=bank_8cad8df5354d33f' \
  -d 'amount=22.50' \
  -d 'memo=rent' \
  --data-urlencode 'logo=https://s3-us-west-2.amazonaws.com/public.lob.com/assets/check_logo.png' \
  --data-urlencode 'check_bottom=<h1 style="padding-top:4in;">Demo Check for {{name}}</h1>' \
  -d 'merge_variables[name]=Harry'
```

```java
try {
    AddressEditable addressTo = new AddressEditable();
    addressTo.setName("Harry Zhang");
    addressTo.setCompany("Lob");
    addressTo.setEmail("harry@lob.com");
    addressTo.setPhone("5555555555");
    addressTo.setAddressLine1("210 King St");
    addressTo.setAddressLine2("# 6100");
    addressTo.setAddressCity("San Francisco");
    addressTo.setAddressState("CA");
    addressTo.setAddressZip("94107");
    addressTo.setAddressCountry(CountryExtended.US);

    AddressEditable addressFrom = new AddressEditable();
    addressFrom.setName("Harry Zhang");
    addressFrom.setCompany("Lob");
    addressFrom.setEmail("harry@lob.com");
    addressFrom.setPhone("5555555555");
    addressFrom.setAddressLine1("210 King St");
    addressFrom.setAddressLine2("# 6100");
    addressFrom.setAddressCity("San Francisco");
    addressFrom.setAddressState("CA");
    addressFrom.setAddressZip("94107");
    addressFrom.setAddressCountry(CountryExtended.US);

    CheckEditable checkRaw = new CheckEditable();
    checkRaw.setFrom(addressFrom);
    checkRaw.setTo(addressTo);
    checkRaw.setAmount(100f);
    checkRaw.setBankAccount("bank_8cad8df5354d33f");

    Check check = apiInstance.create(checkRaw, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Retrieve
```bash
curl https://api.lob.com/v1/checks/chk_534f10783683daa0 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    Check check = apiInstance.get("chk_534f10783683daa0");
} catch (ApiException e) {
    e.printStackTrace();
}
```

### List
```bash
curl -X GET "https://api.lob.com/v1/checks?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    CheckList checks = apiInstance.list(2, null, null, null, null, null, null, null, null, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Cancel
```bash
curl -X DELETE https://api.lob.com/v1/checks/chk_534f10783683daa0 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    CheckDeletion check = apiInstance.cancel("chk_534f10783683daa0");
} catch (ApiException e) {
    e.printStackTrace();
}
```

## BankAccounts Api

### Create
```bash
curl https://api.lob.com/v1/bank_accounts \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Test Bank Account" \
  -d "routing_number=322271627" \
  -d "account_number=123456789" \
  -d "signatory=John Doe" \
  -d "account_type=company"
```

```java
try {
    BankAccountWritable accountRaw = new BankAccountWritable();
    accountRaw.setDescription("Test Bank Account");
    accountRaw.setRoutingNumber("322271627");
    accountRaw.setAccountNumber("123456789");
    accountRaw.setSignatory("Jane Doe");
    accountRaw.setAccountType(BankTypeEnum.INDIVIDUAL);

    BankAccount account = apiInstance.create(accountRaw);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Retrieve
```bash
curl https://api.lob.com/v1/bank_accounts/bank_8cad8df5354d33f \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    BankAccount account = apiInstance.get("bank_8cad8df5354d33f");
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Verify
```bash
curl https://api.lob.com/v1/bank_accounts/bank_dfceb4a2a05b57e/verify \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "amounts[]=25" \
  -d "amounts[]=63"
```

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

### List
```bash
curl -X GET "https://api.lob.com/v1/bank_accounts?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    BankAccountList accounts = apiInstance.list(2, null, null, null, null, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Delete
```bash
curl -X DELETE https://api.lob.com/v1/bank_accounts/bank_3e64d9904356b20 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
try {
    BankAccountDeletion account = apiInstance.delete("bank_8cad8df5354d33f");
} catch (ApiException e) {
    e.printStackTrace();
}
```

## Templates Api

### Create
```bash
curl https://api.lob.com/v1/templates \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Test Template" \
  --data-urlencode "html=<html>HTML for {{name}}</html>"
```

```java
This feature is not currently supported by this library.
```

### Retrieve
```bash
curl https://api.lob.com/v1/templates/tmpl_c94e83ca2cd5121 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
This feature is not currently supported by this library.
```

### List
```bash
curl -X GET "https://api.lob.com/v1/templates?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
This feature is not currently supported by this library.
```

### Update
```bash
curl https://api.lob.com/v1/templates/tmpl_c94e83ca2cd5121 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Updated description" \
  -d "published_version=vrsn_362184d96d9b0c9"
```

```java
This feature is not currently supported by this library.
```

### Delete
```bash
curl -X DELETE https://api.lob.com/v1/templates/tmpl_df934eeda694203 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
This feature is not currently supported by this library.
```

## TemplateVersions Api

### Create
```bash
curl https://api.lob.com/v1/templates/tmpl_4aa14648113e45b/versions \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Second Version" \
  --data-urlencode "html=<html>Second HTML for {{name}}</html>"
```

```java
This feature is not currently supported by this library.
```

### Retrieve
```bash
curl https://api.lob.com/v1/templates/tmpl_c94e83ca2cd5121/versions/vrsn_534e339882d2282 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
This feature is not currently supported by this library.
```

### List
```bash
curl -X GET "https://api.lob.com/v1/templates/tmpl_ea6e6a1abf01703/versions?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
This feature is not currently supported by this library.
```

### Update
```bash
curl https://api.lob.com/v1/templates/tmpl_c94e83ca2cd5121/versions/vrsn_534e339882d2282 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Updated description"
```

```java
This feature is not currently supported by this library.
```

### Delete
```bash
curl -X DELETE https://api.lob.com/v1/templates/tmpl_4aa14648113e45b/versions/vrsn_534e339882d2282 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
This feature is not currently supported by this library.
```

## UsVerifications Api

### Bulk Verify
```bash
curl https://api.lob.com/v1/bulk/us_verifications \
-u <YOUR LIVE API KEY>: \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'addresses[0][primary_line]=210 King Street' \
--data-urlencode 'addresses[0][city]=San Francisco' \
--data-urlencode 'addresses[0][state]=CA' \
--data-urlencode 'addresses[0][zip_code]=94017'
```

```java
try {
    MultipleComponentsList bulkVerify = new MultipleComponentsList();
    MultipleComponents address = new MultipleComponents();
    address.setPrimaryLine("210 King Street");
    address.setCity("San Francisco");
    address.setState("CA");
    address.setZipCode("94107");

    bulkVerify.addAddressesItem(address);
    apiInstance.verifyBulk(bulkVerify, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

### Single Verify
```bash
curl https://api.lob.com/v1/us_verifications \
  -u <YOUR_LIVE_API_KEY>: \
  -d "primary_line=210 King Street" \
  -d "city=San Francisco" \
  -d "state=CA" \
  -d "zip_code=94107"
```

```java
try {
    UsVerificationsWritable singleVerify = new UsVerificationsWritable();
    singleVerify.setPrimaryLine("210 King Street");
    singleVerify.setCity("San Francisco");
    singleVerify.setState("CA");
    singleVerify.setZipCode("94107");

    UsVerification verified = apiInstance.verifySingle(singleVerify, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

## USAutoCompletions Api

### Autocomplete
```bash
curl https://api.lob.com/v1/us_autocompletions \
  -u <YOUR_LIVE_API_KEY>: \
  -d "address_prefix=185 B" \
  -d "city=San Francisco" \
  -d "state=CA"
  -d "zip_code=94107"
```

```java
try {
    UsAutocompletionsWritable autoCompletionWritable = new UsAutocompletionsWritable();
    autoCompletionWritable.setAddressPrefix("185 B");
    autoCompletionWritable.setCity("San Francisco");
    autoCompletionWritable.setState("CA");
    autoCompletionWritable.setZipCode("94107");

    apiInstance.autocomplete(autoCompletionWritable);
} catch (ApiException e) {
    e.printStackTrace();
}
```

## Reverse Geocode Lookups Api

### Reverse Geocode Lookup
```bash
curl https://api.lob.com/v1/us_reverse_geocode_lookups \
  -u <YOUR_LIVE_API_KEY>: \
  -d "latitude=37.7749" \
  -d "longitude=122.4194" \
```

```java
try {
    Location location = new Location();
    location.setLatitude(37.7749f);
    location.setLongitude(122.4194f);

    apiInstance.lookup(location, null);
} catch (ApiException e) {
    e.printStackTrace();
}
```

## ZipLookups Api

### ZipLookup
```bash
curl https://api.lob.com/v1/us_zip_lookups \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "zip_code=94107"
```

```java
try {
    ZipEditable zipEditable = new ZipEditable();
    zipEditable.setZipCode("94107");

    apiInstance.lookup(zipEditable);
} catch (ApiException e) {
    e.printStackTrace();
}
```

## IntlAutocompletion Api

### IntlAutocompletion
```bash
curl https://api.lob.com/v1/intl_autocompletions \
  -u <YOUR_LIVE_API_KEY>: \
  -d "address_prefix=340 Wat" \
  -d "city=Summerside" \
  -d "state=Prince Edward Island" \
  -d "zip_code=C1N 1C4" \
  -d "country=CA"
```

```java
        try {
            IntlAutocompletionsWritable autoCompletionWritable = new IntlAutocompletionsWritable();
            autoCompletionWritable.setAddressPrefix("185 B");
            autoCompletionWritable.setCity("San Francisco");
            autoCompletionWritable.setState("CA");
            autoCompletionWritable.setZipCode("94107");

            apiInstance.autocomplete(autoCompletionWritable, null);
        } catch (ApiException e) {
            e.printStackTrace();
        }
```
