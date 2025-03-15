package com.its.msa.customer;


public record CustomerRegistrationRequest(String firstName,
                                          String lastName,
                                          String email) {

}
