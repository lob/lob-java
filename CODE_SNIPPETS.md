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
AddressesApi apiInstance = new AddressesApi(lobClient);

try {
  AddressList response = apiInstance.list(
    2, // limit
    null, // before
    null, // after
    null, // include
    null, // dateCreated
    null // metadata
  );
} catch (ApiException e) {
  e.printStackTrace();
}
```

## Postcards Api

### List
```bash
curl -X GET "https://api.lob.com/v1/postcards?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
PostcardsApi apiInstance = new PostcardsApi(lobClient);

try {
  PostcardList response = apiInstance.list(
    2, // limit
    null, // before
    null, // after
    null, // include
    null, // dateCreated
    null, // metadata
    null, // size
    null, // scheduled
    null, // sendDate
    null, // mailType
    null // sortBy
  );
} catch (ApiException e) {
  e.printStackTrace();
}
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
SelfMailersApi apiInstance = new SelfMailersApi(lobClient);

try {
  SelfMailerList response = apiInstance.list(
    2, // limit
    null, // before
    null, // after
    null, // include
    null, // dateCreated
    null, // metadata
    null, // size
    null, // scheduled
    null, // sendDate
    null, // mailType
    null // sortBy
  );
} catch (ApiException e) {
  e.printStackTrace();
}
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
LettersApi apiInstance = new LettersApi(lobClient);

try {
  LetterList response = apiInstance.list(
    2, // limit
    null, // before
    null, // after
    null, // include
    null, // dateCreated
    null, // metadata
    null, // color
    null, // scheduled
    null, // sendDate
    null, // mailType
    null // sortBy
  );
} catch (ApiException e) {
  e.printStackTrace();
}
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
ChecksApi apiInstance = new ChecksApi(lobClient);

try {
  CheckList response = apiInstance.list(
    2, // limit
    null, // before
    null, // after
    null, // include
    null, // dateCreated
    null, // metadata
    null, // scheduled
    null, // sendDate
    null, // mailType
    null // sortBy
  );
} catch (ApiException e) {
  e.printStackTrace();
}
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
BankAccountsApi apiInstance = new BankAccountsApi(lobClient);

try {
  BankAccountList response = apiInstance.list(
    2, // limit
    null, // before
    null, // after
    null, // include
    null, // dateCreated
    null // metadata
  );
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
curl -X GET "https://api.lob.com/v1/templates/tmpl_dadaaf7b76c9f25/versions?limit=2" \
  -u test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:
```

```java
This feature is not currently supported by this library.
```
