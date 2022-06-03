package com.vrm.test.pubsub;

/**
 * @author taaviv @ 03.06.22
 */
public class InitializerApp {

    private void createSchema(String projectName, String schemaName, String schemaFile) {

    }

    private void createTopic(String projectName, String topicName, String subscriptionName) {

    }

    public static void main(String[] args) {
        InitializerApp app = new InitializerApp();
        app.createSchema(Const.PROJECT_NAME, Const.SCHEMA_NAME, Const.SCHEMA_FILE);
        app.createTopic(Const.PROJECT_NAME, Const.TOPIC_NAME, Const.SUBSCRIPTION_NAME);
    }

}
