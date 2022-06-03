package com.vrm.test.pubsub;

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import com.vrm.test.pubsub.model.Stock;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author taaviv @ 02.06.22
 */
@Slf4j
public class PublisherApp implements AutoCloseable {

    private static final Random RANDOM = new Random();

    private final Publisher publisher;

    public PublisherApp(String projectName, String topicName) throws Exception {
        TopicName topic = TopicName.of(projectName, topicName);
        publisher = Publisher.newBuilder(topic).build();
    }

    private void publish() throws Exception {
        log.info("Publishing");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(new Stock("STC", price()));

        InputStream stream = new ByteArrayInputStream(baos.toByteArray());
        ByteString data = ByteString.readFrom(stream);
        PubsubMessage message = PubsubMessage.newBuilder().setData(data).build();
        ApiFuture<String> future = publisher.publish(message);
        String id = future.get(10, TimeUnit.SECONDS);
        log.info("Published: {}", id);
    }

    private static double price() {
        return RANDOM.nextDouble() * 20.0;
    }

    @Override
    public void close() throws Exception {
        if (publisher != null) {
            publisher.shutdown();
            publisher.awaitTermination(1, TimeUnit.MINUTES);
        }
    }

    public static void main(String[] args) throws Exception {
        try (PublisherApp publisher = new PublisherApp(Const.PROJECT, Const.TOPIC)) {
            publisher.publish();
        }
    }

}
