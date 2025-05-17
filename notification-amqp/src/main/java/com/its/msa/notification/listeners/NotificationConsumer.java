package com.its.msa.notification.listeners;

import com.its.msa.notification.config.NotificationRequest;
import com.its.msa.notification.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;
    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        System.out.println("Message received from queue : " + notificationRequest);
        notificationService.send(notificationRequest);
    }
}
