package com.its.msa.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void register(Customer customer) {
        log.info("customer: {}", customer);
        //TODO validate email is not null
        //TODO validate name is not null
        //TODO store to DB
        customerRepository.saveAndFlush(customer);
        //TODO isFraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:8082/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("It's a fraudster with customerId " + customer.getId());
        }
        //TODO send notifications
    }
}
