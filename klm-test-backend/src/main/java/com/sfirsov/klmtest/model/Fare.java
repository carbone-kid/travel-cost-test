package com.sfirsov.klmtest.model;

import lombok.Value;

@Value
public class Fare {
    private double amount;
    private Currency currency;
    private String origin, destination;
}
