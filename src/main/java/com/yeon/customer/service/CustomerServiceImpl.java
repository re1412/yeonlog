package com.yeon.customer.service;

import com.yeon.customer.domain.Customer;
import com.yeon.customer.model.CustomerResponse;
import com.yeon.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public CustomerResponse findCustomer(Long CustomerId) {
        Customer customer = customerRepository.findById(CustomerId).orElseThrow();

        CustomerResponse response = CustomerResponse.builder().customer(customer).build();

        return response;
    }
}
