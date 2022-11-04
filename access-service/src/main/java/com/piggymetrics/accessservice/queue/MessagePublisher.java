package com.piggymetrics.accessservice.queue;

public interface MessagePublisher {
    void publish(final String message);
}
