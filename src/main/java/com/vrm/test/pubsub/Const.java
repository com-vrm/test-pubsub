package com.vrm.test.pubsub;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author taaviv @ 03.06.22
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Const {

    public static final String PROJECT_NAME = "test-pubsub-352112";
    public static final String TOPIC_NAME = "stonks";
    public static final String SUBSCRIPTION_NAME = TOPIC_NAME + "-sub";
    public static final String SCHEMA_NAME = "stonks-schema";
    public static final String SCHEMA_FILE = "/schema/stock.avsc";

}
