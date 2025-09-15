package com.its.msa.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;

    public String getFraudServiceUrl() {
        return discoveryClient.getInstances("FRAUD").stream()
                .findFirst()
                .map(si -> si.getUri().toString())
                .orElseThrow(() -> new IllegalStateException("Fraud service not found!"));
    }

    public void register(Customer customer) {
        log.info("customer: {}", customer);
        //TODO validate email is not null
        //TODO validate name is not null
        //TODO store to DB
        customerRepository.saveAndFlush(customer);
        log.info("customer saved: {}", customer);
        //TODO isFraudster
        FraudCheckResponse fraudCheckResponse = restTemplate
                .getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("It's a fraudster with customerId " + customer.getId());
        }
        //TODO send notifications
    }
}
