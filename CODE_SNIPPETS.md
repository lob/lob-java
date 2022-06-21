# Code Snippets

## Address Api

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




## Postcards Api

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

## SelfMailers Api

### Retrieve
```bash
curl https://api.lob.com/v1/self_mailers/sfm_8ffbe811dea49dcf \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<SelfMailer> response = SelfMailer.retrieve("sfm_8ffbe811dea49dcf");
SelfMailer selfMailer = response.getResponseBody();
```



### List
```bash
curl -X GET "https://api.lob.com/v1/self_mailers?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
Map<String, Object> params = new HashMap<>();
params.put("limit", 2);

LobResponse<SelfMailerCollection> response = SelfMailer.list(params);
SelfMailerCollection selfMailers = response.getResponseBody();
```

## Letters Api

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

## Checks Api

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

## BankAccounts Api

### Retrieve
```bash
curl https://api.lob.com/v1/bank_accounts/bank_8cad8df5354d33f \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LobResponse<BankAccount> response = BankAccount.retrieve("bank_8cad8df5354d33f");
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

## Templates Api

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

## TemplateVersions Api

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

## UsVerifications Api

### Bulk Verify
```bash
curl https://api.lob.com/v1/bulk/us_verifications \
  -u <YOUR LIVE API KEY>: \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'addresses[0][primary_line]=210 King Street' \
  --data-urlencode 'addresses[0][city]=San Francisco' \
  --data-urlencode 'addresses[0][state]=CA' \
  --data-urlencode 'addresses[0][zip_code]=94017' \
  --data-urlencode 'addresses[1][primary_line]=185 BERRY ST STE 6600' \
  --data-urlencode 'addresses[1][city]=SAN FRANCISCO' \
  --data-urlencode 'addresses[1][state]=CA' \
  --data-urlencode 'addresses[1][zip_code]=94017' \
```

```java
MultipleComponentsList bulkVerify = new MultipleComponentsList(); 
MultipleComponents bulkAddress0 = new MultipleComponents(); 
bulkAddress0.setPrimaryLine("210 King Street");
bulkAddress0.setCity("San Francisco");
bulkAddress0.setState("CA");
bulkAddress0.setZipCode("94017");
bulkVerify.addAddressesItem(bulkAddress0);

MultipleComponents bulkAddress1 = new MultipleComponents(); 
bulkAddress1.setPrimaryLine("185 BERRY ST STE 6600");
bulkAddress1.setCity("SAN FRANCISCO");
bulkAddress1.setState("CA");
bulkAddress1.setZipCode("94017");
bulkVerify.addAddressesItem(bulkAddress1);

UsVerificationsApi apiInstance = new UsVerificationsApi(lobClient);
try {
  UsVerifications bulkVerifyResponse = apiInstance.verifyBulk(bulkVerify, null);
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
  -d "zip_code=94017" \
```

```java
UsVerificationsWritable singleVerify = new UsVerificationsWritable(); 
singleVerify.setPrimaryLine("210 King Street");
singleVerify.setCity("San Francisco");
singleVerify.setState("CA");
singleVerify.setZipCode("94017");

UsVerificationsApi apiInstance = new UsVerificationsApi(lobClient);
try {
  apiInstance.verifySingle(singleVerify, null);
} catch (ApiException e) {
  e.printStackTrace();
}
```
