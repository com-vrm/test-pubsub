# Pubsub Test

---

`avro-maven-plugin` doesn't generate `public void customEncode(Encoder out)` at least not by default

### Configuring service account key

Set the environment variable GOOGLE_APPLICATION_CREDENTIALS to the path of the JSON 
file that contains service account key.

### Quickstart

https://cloud.google.com/pubsub/docs/publish-receive-messages-client-library

### Java Library

```
  <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>com.google.cloud</groupId>
                <artifactId>libraries-bom</artifactId>
                <version>25.3.0</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>           
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>com.google.cloud</groupId>
            <artifactId>google-cloud-pubsub</artifactId>
        </dependency>
    </dependencies>
```