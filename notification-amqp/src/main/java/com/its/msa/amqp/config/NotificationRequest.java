package com.its.msa.amqp.config;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
