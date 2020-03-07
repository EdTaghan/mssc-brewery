package gurus.springframework.msscbrewery.services;

import java.util.UUID;

import gurus.springframework.msscbrewery.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID customerId);

	CustomerDto saveNewCustomer(CustomerDto customerDto);

	void updateService(UUID customerId, CustomerDto customerDto);

	void deleteById(UUID customerId);

}
