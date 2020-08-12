package guru.springframework.msscbrewery.web.service.customer;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto save(CustomerDto customerToSave);

    CustomerDto update(UUID customerId, CustomerDto customerNewValues);

    boolean delete(UUID customerId);
}
