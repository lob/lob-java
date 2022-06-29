# Code Snippets

## Address Api

### Retrieve
```bash
curl https://api.lob.com/v1/addresses/adr_fa85158b26c3eb7c \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
AddressesApi apiInstance = new AddressesApi(lobClient);

try {
  Address response = apiInstance.get("adr_fa85158b26c3eb7c");
} catch (ApiException e) {
  e.printStackTrace();
}
```







### Delete
```bash
curl -X DELETE "https://api.lob.com/v1/addresses/adr_43769b47aed248c2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
AddressesApi apiInstance = new AddressesApi(lobClient);

try {
    AddressDeletion address = apiInstance.delete("adr_43769b47aed248c2");
} catch (ApiException e) {
    e.printStackTrace();
}
```


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
  -d "address_country=US" \
```

```java
AddressesApi apiInstance = new AddressesApi(lobClient);

try {
  AddressEditable addressEditable = new AddressEditable(); 
  addressEditable.setDescription("Harry - Office");
  addressEditable.setName("Harry Zhang");
  addressEditable.setCompany("Lob");
  addressEditable.setEmail("harry@lob.com");
  addressEditable.setPhone("5555555555");
  addressEditable.setAddressLine1("210 King St");
  addressEditable.setAddressLine2("# 6100");
  addressEditable.setAddressCity("San Francisco");
  addressEditable.setAddressState("CA");
  addressEditable.setAddressZip("94107");
  addressEditable.setAddressCountry(CountryExtended.US);

  Address result = apiInstance.create(addressEditable);
  System.out.println(result);
} catch (ApiException e) {
  e.printStackTrace();
}
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

### Retrieve
```bash
curl https://api.lob.com/v1/postcards/psc_5c002b86ce47537a \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
PostcardsApi apiInstance = new PostcardsApi(lobClient);

try {
  Postcard response = apiInstance.get("psc_5c002b86ce47537a");
} catch (ApiException e) {
  e.printStackTrace();
}
```







### Delete
```bash
curl -X DELETE "https://api.lob.com/v1/postcards/psc_5c002b86ce47537a" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
PostcardsApi apiInstance = new PostcardsApi(lobClient);

try {
    PostcardDeletion address = apiInstance.cancel("psc_5c002b86ce47537a");
} catch (ApiException e) {
    e.printStackTrace();
}
```


### Create
```bash
curl https://api.lob.com/v1/postcards \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Demo Postcard job" \
  -d "from=adr_210a8d4b0b76d77b" \
  --data-urlencode "front=<html style='padding: 1in; font-size: 50;'>Front HTML for {{name}}</html>" \
  --data-urlencode "back=<html style='padding: 1in; font-size: 20;'>Back HTML for {{name}}</html>" \
  -d "to[name]=Harry Zhang" \
  -d "to[address_line1]=210 King St" \
  -d "to[address_line2]=# 6100" \
  -d "to[address_city]=San Francisco" \
  -d "to[address_state]=CA" \
  -d "to[address_zip]=94107" \
  -d "merge_variables[name]=Harry" \
```

```java
Map<String, String> merge_variables = new HashMap<>();
merge_variables.put("name", "Harry");

PostcardsApi apiInstance = new PostcardsApi(lobClient);

AddressEditable to = new AddressEditable();
to.setName("Harry Zhang");
to.setAddressLine1("210 King St");
to.setAddressLine2("# 6100");
to.setAddressCity("San Francisco");
to.setAddressState("CA");
to.setAddressZip("94107");

try {
  PostcardEditable postcardEditable = new PostcardEditable(); 
  postcardEditable.setDescription("Demo Postcard job");
  postcardEditable.setFrom("adr_210a8d4b0b76d77b");
  postcardEditable.setFront("<html style='padding: 1in; font-size: 50;'>Front HTML for {{name}}</html>");
  postcardEditable.setBack("<html style='padding: 1in; font-size: 20;'>Back HTML for {{name}}</html>");
  postcardEditable.setTo(to);
  postcardEditable.setMergeVariables(merge_variables);

  Postcard result = apiInstance.create(postcardEditable, null);
  System.out.println(result);
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
SelfMailersApi apiInstance = new SelfMailersApi(lobClient);

try {
  SelfMailer response = apiInstance.get("sfm_8ffbe811dea49dcf");
} catch (ApiException e) {
  e.printStackTrace();
}
```







### Delete
```bash
curl -X DELETE "https://api.lob.com/v1/self_mailers/sfm_8ffbe811dea49dcf" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
SelfMailersApi apiInstance = new SelfMailersApi(lobClient);

try {
    SelfMailerDeletion address = apiInstance.delete("sfm_8ffbe811dea49dcf");
} catch (ApiException e) {
    e.printStackTrace();
}
```


### Create
```bash
curl https://api.lob.com/v1/self_mailers \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Demo Self Mailer job" \
  -d "from=adr_210a8d4b0b76d77b" \
  --data-urlencode "inside=<html style='padding: 1in; font-size: 50;'>Inside HTML for {{name}}</html>" \
  --data-urlencode "outside=<html style='padding: 1in; font-size: 20;'>Outside HTML for {{name}}</html>" \
  -d "to[name]=Harry Zhang" \
  -d "to[address_line1]=210 King St" \
  -d "to[address_line2]=# 6100" \
  -d "to[address_city]=San Francisco" \
  -d "to[address_state]=CA" \
  -d "to[address_zip]=94107" \
  -d "merge_variables[name]=Harry" \
```

```java
Map<String, String> merge_variables = new HashMap<>();
merge_variables.put("name", "Harry");

SelfMailersApi apiInstance = new SelfMailersApi(lobClient);

AddressEditable to = new AddressEditable();
to.setName("Harry Zhang");
to.setAddressLine1("210 King St");
to.setAddressLine2("# 6100");
to.setAddressCity("San Francisco");
to.setAddressState("CA");
to.setAddressZip("94107");

try {
  SelfMailerEditable selfMailerEditable = new SelfMailerEditable(); 
  selfMailerEditable.setDescription("Demo Self Mailer job");
  selfMailerEditable.setFrom("adr_210a8d4b0b76d77b");
  selfMailerEditable.setInside("<html style='padding: 1in; font-size: 50;'>Inside HTML for {{name}}</html>");
  selfMailerEditable.setOutside("<html style='padding: 1in; font-size: 20;'>Outside HTML for {{name}}</html>");
  selfMailerEditable.setTo(to);
  selfMailerEditable.setMergeVariables(merge_variables);

  SelfMailer result = apiInstance.create(selfMailerEditable, null);
  System.out.println(result);
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
LettersApi apiInstance = new LettersApi(lobClient);

try {
  Letter response = apiInstance.get("ltr_4868c3b754655f90");
} catch (ApiException e) {
  e.printStackTrace();
}
```







### Delete
```bash
curl -X DELETE "https://api.lob.com/v1/letters/ltr_4868c3b754655f90" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
LettersApi apiInstance = new LettersApi(lobClient);

try {
    LetterDeletion address = apiInstance.cancel("ltr_4868c3b754655f90");
} catch (ApiException e) {
    e.printStackTrace();
}
```


### Create
```bash
curl https://api.lob.com/v1/letters \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Demo Letter" \
  -d "from=adr_210a8d4b0b76d77b" \
  --data-urlencode "file=<html style='padding-top: 3in; margin: .5in;'>HTML Letter for {{name}}</html>" \
  -d "color=true" \
  -d "to[name]=Harry Zhang" \
  -d "to[address_line1]=210 King St" \
  -d "to[address_line2]=# 6100" \
  -d "to[address_city]=San Francisco" \
  -d "to[address_state]=CA" \
  -d "to[address_zip]=94107" \
  -d "merge_variables[name]=Harry" \
  -d "cards[]=card_c51ae96f5cebf3e"
```

```java
Map<String, String> merge_variables = new HashMap<>();
merge_variables.put("name", "Harry");

LettersApi apiInstance = new LettersApi(lobClient);

AddressEditable to = new AddressEditable();
to.setName("Harry Zhang");
to.setAddressLine1("210 King St");
to.setAddressLine2("# 6100");
to.setAddressCity("San Francisco");
to.setAddressState("CA");
to.setAddressZip("94107");

List<String> cards = new ArrayList<String>();
cards.add("card_c51ae96f5cebf3e");

try {
  LetterEditable letterEditable = new LetterEditable(); 
  letterEditable.setDescription("Demo Letter");
  letterEditable.setFrom("adr_210a8d4b0b76d77b");
  letterEditable.setFile("<html style='padding-top: 3in; margin: .5in;'>HTML Letter for {{name}}</html>");
  letterEditable.setColor(true);
  letterEditable.setTo(to);
  letterEditable.setMergeVariables(merge_variables);
  letterEditable.setCards(cards);

  Letter result = apiInstance.create(letterEditable, null);
  System.out.println(result);
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
ChecksApi apiInstance = new ChecksApi(lobClient);

try {
  Check response = apiInstance.get("chk_534f10783683daa0");
} catch (ApiException e) {
  e.printStackTrace();
}
```







### Delete
```bash
curl -X DELETE "https://api.lob.com/v1/checks/chk_534f10783683daa0" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
ChecksApi apiInstance = new ChecksApi(lobClient);

try {
    CheckDeletion address = apiInstance.cancel("chk_534f10783683daa0");
} catch (ApiException e) {
    e.printStackTrace();
}
```


### Create
```bash
curl https://api.lob.com/v1/checks \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Demo Check" \
  -d "bank_account=bank_8cad8df5354d33f" \
  -d "amount=22.5" \
  -d "memo=rent" \
  --data-urlencode "logo=https://s3-us-west-2.amazonaws.com/public.lob.com/assets/check_logo.png" \
  --data-urlencode "check_bottom=<h1 style='padding-top:4in;'>Demo Check for {{name}}</h1>" \
  -d "from=adr_210a8d4b0b76d77b" \
  -d "to[name]=Harry Zhang" \
  -d "to[address_line1]=210 King St" \
  -d "to[address_line2]=# 6100" \
  -d "to[address_city]=San Francisco" \
  -d "to[address_state]=CA" \
  -d "to[address_zip]=94107" \
  -d "merge_variables[name]=Harry" \
```

```java
Map<String, String> merge_variables = new HashMap<>();
merge_variables.put("name", "Harry");

ChecksApi apiInstance = new ChecksApi(lobClient);

AddressEditable to = new AddressEditable();
to.setName("Harry Zhang");
to.setAddressLine1("210 King St");
to.setAddressLine2("# 6100");
to.setAddressCity("San Francisco");
to.setAddressState("CA");
to.setAddressZip("94107");

try {
  CheckEditable checkEditable = new CheckEditable(); 
  checkEditable.setDescription("Demo Check");
  checkEditable.setBankAccount("bank_8cad8df5354d33f");
  checkEditable.setAmount(22.5f);
  checkEditable.setMemo("rent");
  checkEditable.setLogo("https://s3-us-west-2.amazonaws.com/public.lob.com/assets/check_logo.png");
  checkEditable.setCheckBottom("<h1 style='padding-top:4in;'>Demo Check for {{name}}</h1>");
  checkEditable.setFrom("adr_210a8d4b0b76d77b");
  checkEditable.setTo(to);
  checkEditable.setMergeVariables(merge_variables);

  Check result = apiInstance.create(checkEditable, null);
  System.out.println(result);
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
BankAccountsApi apiInstance = new BankAccountsApi(lobClient);

try {
  BankAccount response = apiInstance.get("bank_8cad8df5354d33f");
} catch (ApiException e) {
  e.printStackTrace();
}
```







### Delete
```bash
curl -X DELETE "https://api.lob.com/v1/bank_accounts/bank_3e64d9904356b20" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
BankAccountsApi apiInstance = new BankAccountsApi(lobClient);

try {
    BankAccountDeletion address = apiInstance.delete("bank_3e64d9904356b20");
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
Map<String, Object> params = new HashMap<>();
params.put("limit", 2);

LobResponse<BankAccountCollection> response = BankAccount.list(params);
BankAccountCollection bankAccounts = response.getResponseBody();
```



### Verify
```bash
curl https://api.lob.com/v1/bank_accounts/bank_dfceb4a2a05b57e/verify \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \ 
  -d "amounts[]=25" \ 
  -d "amounts[]=63" \ 
```

```java
BankAccountVerify verification = new BankAccountVerify(); 
verification.addAmountsItem(25); 
verification.addAmountsItem(63); 

BankAccountsApi apiInstance = new BankAccountsApi(lobClient);

try {
  apiInstance.verify("bank_dfceb4a2a05b57e", verification);
} catch (ApiException e) {
  e.printStackTrace();
}
```





### Create
```bash
curl https://api.lob.com/v1/bank_accounts \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Test Bank Account" \
  -d "routing_number=322271627" \
  -d "account_number=123456789" \
  -d "signatory=John Doe" \
  -d "account_type=company" \
```

```java
BankAccountsApi apiInstance = new BankAccountsApi(lobClient);

try {
  BankAccountWritable bankAccountWritable = new BankAccountWritable(); 
  bankAccountWritable.setDescription("Test Bank Account");
  bankAccountWritable.setRoutingNumber("322271627");
  bankAccountWritable.setAccountNumber("123456789");
  bankAccountWritable.setSignatory("John Doe");
  bankAccountWritable.setAccountType(BankTypeEnum.COMPANY);

  BankAccount result = apiInstance.create(bankAccountWritable);
  System.out.println(result);
} catch (ApiException e) {
  e.printStackTrace();
}
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







### Delete
```bash
curl -X DELETE "https://api.lob.com/v1/templates/tmpl_df934eeda694203" \
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



### Create
```bash
curl https://api.lob.com/v1/templates \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Test Template" \
  --data-urlencode "html=<html>HTML for {{name}}</html>" \
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







### Delete
```bash
curl -X DELETE "https://api.lob.com/v1/templates/tmpl_4aa14648113e45b/versions/vrsn_534e339882d2282" \
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



### Create
```bash
curl https://api.lob.com/v1/templates/tmpl_4aa14648113e45b/versions \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc: \
  -d "description=Second Version" \
  --data-urlencode "html=<html>Second HTML for {{name}}</html>" \
```

```java
This feature is not currently supported by this library.
```



## USAutoCompletions Api

### Autocomplete
```bash
curl https://api.lob.com/v1/us_autocompletions \
  -u <YOUR_LIVE_API_KEY>: \
  -d "address_prefix=185 B" \
  -d "city=San Francisco" \
  -d "state=CA" \
  -d "zip_code=94017" \
```

```java
UsAutocompletionsApi apiInstance = new UsAutocompletionsApi(lobClient);
UsAutocompletionsWritable autoCompletionWritable = new UsAutocompletionsWritable(); 
autoCompletionWritable.setAddressPrefix("185 B");
autoCompletionWritable.setCity("San Francisco");
autoCompletionWritable.setState("CA");
autoCompletionWritable.setZipCode("94017");

try {
  UsAutocompletions usAutocompletion = apiInstance.autocomplete(autoCompletionWritable);
} catch (ApiException e) {
  e.printStackTrace();
}
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

