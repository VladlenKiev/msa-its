package com.its.msa.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.its.msa.amqp",
        "com.its.msa.notification"
})
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfig notificationConfig
//    ) {
//        return args -> {
//            producer.publish(
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey(),
//                    new Person("Ali", 18)
//            );
//        };
//    }
} record Person(String name, int age) {}
