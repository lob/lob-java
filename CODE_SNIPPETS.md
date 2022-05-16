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

### Retrieve
```bash
curl https://api.lob.com/v1/addresses/adr_fa85158b26c3eb7c \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<Address> response = Address.retrieve("adr_fa85158b26c3eb7c");
Address address = response.getResponseBody();
```

### List
```bash
curl -X GET "https://api.lob.com/v1/addresses?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
Map<String, Object> params = new HashMap<>();
params.put("limit", 2);

LobResponse<AddressCollection> response = Address.list(params);
AddressCollection addresses = response.getResponseBody();
```

### Delete
```bash
curl -X DELETE https://api.lob.com/v1/addresses/adr_43769b47aed248c2 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<Address> response = Address.delete("adr_43769b47aed248c2");
Address address = response.getResponseBody();
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
Map<String, String> mergeVariables = new HashMap<>();
mergeVariables.put('name', 'Harry');

LobResponse<Postcard> response = new Postcard.RequestBuilder()
        .setDescription('Demo Postcard job')
        .setTo(
                new Address.RequestBuilder()
                        .setName('Harry Zhang')
                        .setLine1('210 King St')
                        .setLine2('# 6100')
                        .setCity('San Francisco')
                        .setState('CA')
                        .setZip('94107')
        )
        .setFrom('adr_210a8d4b0b76d77b')
        .setFront('<html style="padding: 1in; font-size: 50;">Front HTML for {{name}}</html>')
        .setBack('<html style="padding: 1in; font-size: 20;">Back HTML for {{name}}</html>')
        .setMergeVariables(mergeVariables)
        .create();

Postcard postcard = response.getResponseBody();
```

### Retrieve
```bash
curl https://api.lob.com/v1/postcards/psc_5c002b86ce47537a \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<Postcard> response = Postcard.retrieve("psc_5c002b86ce47537a");
Postcard postcard = response.getResponseBody();
```

### List
```bash
curl -X GET "https://api.lob.com/v1/postcards?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
Map<String, Object> params = new HashMap<>();
params.put("limit", 2);

LobResponse<PostcardCollection> response = Postcard.list(params);
PostcardCollection postcards = response.getResponseBody();
```

### Cancel
```bash
curl -X DELETE https://api.lob.com/v1/postcards/psc_5c002b86ce47537a \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<Postcard> deleteResponse = Postcard.delete("psc_5c002b86ce47537a");
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
Map<String, String> mergeVariables = new HashMap<>();
mergeVariables.put("name", "Harry");

LobResponse<SelfMailer> response = new SelfMailer.RequestBuilder()
        .setDescription("Demo Self Mailer job")
        .setTo(
                new Address.RequestBuilder()
                        .setName("Harry Zhang")
                        .setLine1("210 King St")
                        .setCity("San Francisco")
                        .setState("CA")
                        .setZip("94107")
        )
        .setFrom("adr_210a8d4b0b76d77b")
        .setInside("<html style='padding: 1in; font-size: 50;'>Inside HTML for {{name}}</html>")
        .setOutside("<html style='padding: 1in; font-size: 20;'>Outside HTML for {{name}}</html>")
        .setMergeVariables(mergeVariables)
        .create();

SelfMailer selfMailer = response.getResponseBody();
```

### Retrieve
```bash
curl -X GET "https://api.lob.com/v1/self_mailers/sfm_8ffbe811dea49dcf" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<SelfMailer> response = SelfMailer.retrieve("sfm_8ffbe811dea49dcf");
SelfMailer selfMailer = response.getResponseBody();
```

### List
```bash
try {
  const selfMailers = await new selfMailersApi(config).list(2);
} catch (err: any) {
  console.error(err);
}
```

```java
Map<String, Object> params = new HashMap<>();
params.put('limit', 2);

LobResponse<SelfMailerCollection> response = SelfMailer.list(params);
SelfMailerCollection selfMailers = response.getResponseBody();
```

### Delete
```bash
curl -X DELETE https://api.lob.com/v1/self_mailers/sfm_8ffbe811dea49dcf \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<SelfMailer> deleteResponse = SelfMailer.delete("sfm_8ffbe811dea49dcf");
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
Map<String, String> mergeVariables = new HashMap<>();
mergeVariables.put('name', 'Harry');

LobResponse<Letter> response = new Letter.RequestBuilder()
        .setDescription('Demo Letter')
        .setFile('<html style="padding-top: 3in; margin: .5in;">HTML Letter for {{name}}</html>')
        .setColor(true)
        .setMergeVariables(mergeVariables)
        .setTo(
                new Address.RequestBuilder()
                        .setName('Harry Zhang')
                        .setLine1('210 King St Ste 6100')
                        .setCity('San Francisco')
                        .setState('CA')
                        .setZip('94107')
        )
        .setFrom('adr_210a8d4b0b76d77b')
        .setCards('card_c51ae96f5cebf3e')
        .create();

Letter letter = response.getResponseBody();
```

### Retrieve
```bash
curl https://api.lob.com/v1/letters/ltr_4868c3b754655f90 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<Letter> response = Letter.retrieve("ltr_4868c3b754655f90");
Letter letter = response.getResponseBody();
```

### List
```bash
curl -X GET "https://api.lob.com/v1/letters?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
Map<String, Object> params = new HashMap<>();
params.put("limit", 2);

LobResponse<LetterCollection> response = Letter.list(params);
LetterCollection letters = response.getResponseBody();
```

### Cancel
```bash
curl -X DELETE https://api.lob.com/v1/letters/ltr_4868c3b754655f90 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<Letter> response = Letter.delete("ltr_4868c3b754655f90");
Letter letter= = response.getResponseBody();
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
Map<String, String> mergeVariables = new HashMap<>();
mergeVariables.put('name', 'Harry');

LobResponse<Check> response = new Check.RequestBuilder()
        .setDescription('Demo Check')
        .setCheckBottom('<h1 style="padding-top:4in;">Demo Check for {{name}}</h1>')
        .setMergeVariables(mergeVariables)
        .setAmount(22.50f)
        .memo('rent')
        .setLogo('https://s3-us-west-2.amazonaws.com/public.lob.com/assets/check_logo.png')
        .setTo(
                new Address.RequestBuilder()
                        .setName('Harry Zhang')
                        .setLine1('210 King St Ste 6100')
                        .setCity('San Francisco')
                        .setState('CA')
                        .setZip('94107')
        )
        .setFrom('adr_210a8d4b0b76d77b')
        .setBankAccount('bank_8cad8df5354d33f')
        .create();

Check check = response.getResponseBody();
```

### Retrieve
```bash
curl https://api.lob.com/v1/checks/chk_534f10783683daa0 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<Check> response = Check.retrieve("chk_534f10783683daa0");
Check check = response.getResponseBody();
```

### List
```bash
curl -X GET "https://api.lob.com/v1/checks?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
Map<String, Object> params = new HashMap<>();
params.put("limit", 2);

LobResponse<CheckCollection> response = Check.list(params);
CheckCollection checks = response.getResponseBody();
```

### Cancel
```bash
curl -X DELETE https://api.lob.com/v1/checks/chk_534f10783683daa0 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<Check> response = Check.delete("chk_534f10783683daa0");
Check check = response.getResponseBody();
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
LobResponse<BankAccount> response = new BankAccount.RequestBuilder()
        .setDescription("Test Bank Account")
        .setRoutingNumber("322271627")
        .setAccountNumber("123456789")
        .setSignatory("John Doe")
        .setAccountType("company")
        .create();

BankAccount bankAccount = response.getResponseBody();
```

### Retrieve
```bash
curl https://api.lob.com/v1/bank_accounts/bank_8cad8df5354d33f \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<BankAccount> response = BankAccount.retrieve("bank_8cad8df5354d33f");
BankAccount bankAccount = response.getResponseBody();
```

### Verify
```bash
curl https://api.lob.com/v1/bank_accounts/bank_dfceb4a2a05b57e/verify \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "amounts[]=25" \
  -d "amounts[]=63"
```

```java
LobResponse<BankAccount> response = BankAccount.verify(newBankAccount.getId(), Arrays.asList(25, 63));
BankAccount bankAccount = response.getResponseBody();
```

### List
```bash
curl -X GET "https://api.lob.com/v1/bank_accounts?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
Map<String, Object> params = new HashMap<>();
params.put("limit", 2);

LobResponse<BankAccountCollection> response = BankAccount.list(params);
BankAccountCollection bankAccounts = response.getResponseBody();
```

### Delete
```bash
curl -X DELETE https://api.lob.com/v1/bank_accounts/bank_3e64d9904356b20 \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<BankAccount> response = BankAccount.delete("bank_3e64d9904356b20");
BankAccount bankAccount = response.getResponseBody();
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
List<USVerification.RequestBuilder> addresses = new ArrayList<USVerification.RequestBuilder>();
addresses.add(new USVerification.RequestBuilder()
        .setRecipient("Donald")
        .setPrimaryLine("deliverable")
        .setSecondaryLine("Ste 6100")
        .setUrbanization("")
        .setCity("San Francisco")
        .setState("CA")
        .setZipCode("94107"));
LobResponse<BulkUSVerification> response = new BulkUSVerification.RequestBuilder()
        .setAddresses(addresses)
        .verify();
BulkUSVerification bulkUSVerification = response.getResponseBody();
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
LobResponse<USVerification> response = new USVerification.RequestBuilder()
        .setRecipient("Donald")
        .setPrimaryLine("210 King St")
        .setSecondaryLine("Ste 6100")
        .setCity("San Francisco")
        .setState("CA")
        .setZipCode("94107")
        .verify();

USVerification usVerification = response.getResponseBody();
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
LobResponse<USAutocompletion> response = new USAutocompletion.RequestBuilder()
    .setAddressPrefix("185 B")
    .setCity("San Francisco")
    .setState("CA")
    .setZipCode("94107")
    .autocomplete();

USAutocompletion usAutocompletion = response.getResponseBody();
```

## Reverse Geocode Lookups Api

### Reverse Geocode Lookup
```bash
curl https://api.lob.com/v1/us_reverse_geocode_lookups \
  -u <YOUR_LIVE_API_KEY>: \
  -d "latitude=37.7749" \
  -d "longitude=122.4194" \
```

```typescript
const ReverseGeocodeLookup = new ReverseGeocodeLookupsApi(av_config);
const coordinates: Location = {
  Latitude: 37.777456,
  longitude: -122.393039
};
try {
  const geocode = await ReverseGeocodeLookup.lookup(coordinates);
} catch (err: any) {
  console.error(err);
}
```

```java
LobResponse<ReverseGeocodeLookup> response = new ReverseGeocodeLookup.RequestBuilder()
        .setLatitude(37.7749)
        .setLongitude(122.4194)
        .lookup();

ReverseGeocodeLookup reverseGeocodeLookup = response.getResponseBody();
```

## ZipLookups Api

### ZipLookup
```bash
curl https://api.lob.com/v1/us_zip_lookups \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "zip_code=94107"
```

```java
LobResponse<USZipLookup> response = new USZipLookup.RequestBuilder()
        .setZipCode("94107")
        .lookup();

USZipLookup usZipLookup = response.getResponseBody();
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
LobResponse<IntlVerification> response = new IntlVerification.RequestBuilder()
        .setAddressPrefix("340 Wat")
        .setCity("Summerside")
        .setState("Prince Edward Island")
        .setPostalCode("C1N 1C4")
        .setCountry("CA")
        .verify();
IntlVerification intlVerification = response.getResponseBody();
```
