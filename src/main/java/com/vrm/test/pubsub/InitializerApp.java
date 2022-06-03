package com.vrm.test.pubsub;

import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.cloud.pubsub.v1.SchemaServiceClient;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.Encoding;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.SchemaName;
import com.google.pubsub.v1.SchemaSettings;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author taaviv @ 03.06.22
 */
@Slf4j
public class InitializerApp {

    private void createSchema(String projectName, String schemaName, String schemaFile) throws Exception {
        log.info("Create schema: {}", schemaName);
        String fullSchemaName = SchemaName.of(projectName, schemaName).toString();
        URL resource = getClass().getResource(schemaFile);
        if (resource == null) {
            throw new IllegalArgumentException(String.format("Schema file [%s] not found", schemaFile));
        }

        Path schemaFilePath = Paths.get(resource.toURI());

        Schema schema = Schema.newBuilder()
                .setName(fullSchemaName)
                .setType(Schema.Type.AVRO)
                .setDefinition(new String(Files.readAllBytes(schemaFilePath)))
                .build();

        try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
            Schema created = schemaServiceClient.createSchema(ProjectName.of(projectName), schema, schemaName);
            log.info("Schema created: {}", created);
        }
        catch (AlreadyExistsException e) {
            log.info(e.getMessage());
        }
    }

    private void createTopic(String projectName, String topicName, String subscriptionName, String schemaName) throws Exception {
        log.info("Create topic and subscription");
        SchemaSettings settings = SchemaSettings.newBuilder()
                .setSchema(SchemaName.of(projectName, schemaName).toString())
                .setEncoding(Encoding.BINARY)
                .build();

        TopicName topicNameInstance = TopicName.of(projectName, topicName);
        Topic topic = Topic.newBuilder()
                .setName(topicNameInstance.toString())
                .setSchemaSettings(settings)
                .build();

        try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
            Topic created = topicAdminClient.createTopic(topic);
            log.info("Topic created: {}", created);
        }
        catch (AlreadyExistsException e) {
            log.info(e.getMessage());
        }

        int ackDelaySeconds = 60;
        try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
            Subscription subscription = subscriptionAdminClient.createSubscription(
                    SubscriptionName.of(projectName, subscriptionName),
                    topicNameInstance,
                    PushConfig.getDefaultInstance(),
                    ackDelaySeconds
            );
            log.info("Subscription created: {}", subscription);
        }
    }

    public static void main(String[] args) throws Exception {
        InitializerApp app = new InitializerApp();
        app.createSchema(Const.PROJECT_NAME, Const.SCHEMA_NAME, Const.SCHEMA_FILE);
        app.createTopic(Const.PROJECT_NAME, Const.TOPIC_NAME, Const.SUBSCRIPTION_NAME, Const.SCHEMA_NAME);
    }

}
