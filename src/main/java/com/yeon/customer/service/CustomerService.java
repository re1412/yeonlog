package com.yeon.customer.service;

import com.yeon.customer.model.CustomerResponse;

public interface CustomerService {
    CustomerResponse findCustomer(Long CustomerId);
}
