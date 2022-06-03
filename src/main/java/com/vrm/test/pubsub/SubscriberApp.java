package com.vrm.test.pubsub;

import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import lombok.extern.slf4j.Slf4j;

/**
 * @author taaviv @ 03.06.22
 */
@Slf4j
public class SubscriberApp {


    private void subscribe() {
        log.debug("Subscribing...");
        ProjectSubscriptionName subscriptionName =
                ProjectSubscriptionName.of(Const.PROJECT, Const.SUBSCRIPTION);

        MessageReceiver receiver = (message, consumer) -> {
            log.info("Received message [{}]: {}", message.getMessageId(),
                    message.getData().toStringUtf8());
            consumer.ack();
        };

        Subscriber subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
        subscriber.startAsync().awaitRunning();
        subscriber.awaitTerminated();
    }

    public static void main(String[] args) {
        new SubscriberApp().subscribe();
    }


}
