package com.its.msa.notification;

import com.its.msa.notification.config.NotificationRequest;
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
