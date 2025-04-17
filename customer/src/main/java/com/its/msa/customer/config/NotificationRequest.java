package com.its.msa.customer.config;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
