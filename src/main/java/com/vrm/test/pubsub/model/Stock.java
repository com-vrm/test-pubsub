package com.vrm.test.pubsub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author taaviv @ 02.06.22
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Stock implements Serializable {

    private String symbol;
    private double price;

}
