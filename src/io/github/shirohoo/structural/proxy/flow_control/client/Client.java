package io.github.shirohoo.structural.proxy.flow_control.client;

import io.github.shirohoo.structural.proxy.flow_control.operator.Operator;

public class Client {
    private final Operator operator;

    public Client(Operator operator) {
        this.operator = operator;
    }

    public void callOperation() {
        operator.operate();
    }
}

