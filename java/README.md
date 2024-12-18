# Official PTI Java SDK
For detailed API documentation please refer to the [PTI API Reference](TBD).

Building the API client library requires:

1. Java 11+
2. Gradle

## Installation

To install the API client library to your local Gradle/Maven repository, simply execute:

```shell
./gradlew publishToMavenLocal 
```

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.pti.sdk</groupId>
  <artifactId>pti-java-sdk</artifactId>
  <version>latest</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.pti.sdk:pti-java-sdk:latest"
```

## Getting Started
### initialize PTI Client
You can initialize the PTI SDK by providing the parameters directly:

```java
PTIClient client = new PTIClient(ClientOptions.builder()
    .environment(Environment.STAGING)
    .ptiClientId("<client id provided by PTI>")
    .privateKeyPath("<path to your private key>")
    .build());
```
