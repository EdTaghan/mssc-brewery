package gurus.springframework.msscbrewery.services;

import gurus.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder().id(UUID.randomUUID())
				.firstname("Charlie")
				.lastname("Brown")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}
	
	@Override
	public void updateService(UUID customerId, CustomerDto customerDto) {
		log.debug("Updating customer "+customerId.toString()+"...");
	}
	
	@Override
	public void deleteById(UUID customerId) {
		log.debug("Deleting a customer...");
	}
}
