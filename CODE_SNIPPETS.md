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
LobResponse<SelfMailer> response = SelfMailer.retrieve("sfm_8ffbe811dea49dcf");
SelfMailer selfMailer = response.getResponseBody();
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
LobResponse<Letter> response = Letter.retrieve("ltr_4868c3b754655f90");
Letter letter = response.getResponseBody();
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
  -d "cards[]=card_thingy"
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
cards.add("card_thingy");

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
LobResponse<Check> response = Check.retrieve("chk_534f10783683daa0");
Check check = response.getResponseBody();
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





### List
```bash
curl -X GET "https://api.lob.com/v1/templates?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
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





### List
```bash
curl -X GET "https://api.lob.com/v1/templates/tmpl_ea6e6a1abf01703/versions?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
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

