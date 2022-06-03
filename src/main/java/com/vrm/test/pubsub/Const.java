package com.vrm.test.pubsub;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author taaviv @ 03.06.22
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Const {

    public static final String PROJECT = "test-pubsub-352112";
    public static final String TOPIC = "stonks";
    public static final String SUBSCRIPTION = TOPIC + "-sub";

}
