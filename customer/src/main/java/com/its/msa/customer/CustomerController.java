package com.its.msa.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("Registering customer with customer {}", customerRegistrationRequest);
        Customer customer = Customer.builder()
                .name(customerRegistrationRequest.firstName())
                .surName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();
        customerService.register(customer);
    }

}
