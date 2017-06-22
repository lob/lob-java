# Java Examples
Here we have put together a hand full of java examples to help get you started. As always feel free to [contact us](https://lob.com/support) directly if you have any questions on implementation.


## Getting started
Before running these examples make sure you are in the `lob-java-examples/` directory.

```bash
lob$ cd lob-java-examples/
lob-java-examples$ mvn clean package
```

## Examples

### Create letters from CSV

An example showing how to dynamically create letters from a CSV using HTML, a custom font, merge variables, and Lob's [Letter API](https://lob.com/services/letters). The example code to create letters from a CSV can be found [here](https://github.com/lob/lob-java/blob/master/lob-java-examples/src/main/java/com/lob/examples/CsvLetterExample.java).
```bash
lob-java-examples$ mvn exec:java -Dexec.mainClass="com.lob.examples.CsvLetterExample"
```

### Create postcards from CSV

An example showing how to dynamically create postcards from a CSV using HTML, a custom font, merge variables, and Lob's [Postcard API](https://lob.com/services/postcards). The example code to create postcards from a CSV can be found [here](https://github.com/lob/lob-java/blob/master/lob-java-examples/src/main/java/com/lob/examples/CsvPostcardExample.java).
```bash
lob-java-examples$ mvn exec:java -Dexec.mainClass="com.lob.examples.CsvPostcardExample"
```

### Verify US addresses from CSV

An example showing how to validate and cleanse a CSV spreadsheet full of shipping addresses using Lob's [US Verification API](https://lob.com/verification/address). The code to verify addresses from a CSV can be found [here](https://github.com/lob/lob-java/blob/master/lob-java-examples/src/main/java/com/lob/examples/CsvUSVerificationExample.java).

```bash
lob-java-examples$ mvn exec:java -Dexec.mainClass="com.lob.examples.CsvUSVerificationExample"
```

### Create a check
The example code to create a single check can be found [here](https://github.com/lob/lob-java/blob/master/lob-java-examples/src/main/java/com/lob/examples/CheckExample.java).
```bash
lob-java-examples$ mvn exec:java -Dexec.mainClass="com.lob.examples.CheckExample"
```

### Create a postcard
The example code to create a single postcard can be found [here](https://github.com/lob/lob-java/blob/master/lob-java-examples/src/main/java/com/lob/examples/PostcardExample.java).
```bash
lob-java-examples$ mvn exec:java -Dexec.mainClass="com.lob.examples.PostcardExample"
```

