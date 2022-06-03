# Pubsub Test

### Generating sources from Avro schema

`mvn generate-sources`

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