package com.its.msa.notification.config;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
