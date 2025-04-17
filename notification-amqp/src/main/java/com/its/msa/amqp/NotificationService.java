package com.its.msa.amqp;

import com.its.msa.amqp.config.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

//    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
//        notificationRepository.save(
//                Notification.builder()
//                        .toCustomerId(notificationRequest.toCustomerId())
//                        .toCustomerEmail(notificationRequest.toCustomerName())
//                        .sender("its-admin")
//                        .message(notificationRequest.message())
//                        .sentAt(LocalDateTime.now())
//                        .build()
//        );
    }
}
