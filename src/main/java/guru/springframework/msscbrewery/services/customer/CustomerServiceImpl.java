package guru.springframework.msscbrewery.services.customer;


import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        log.info("Searching customer with id: " + customerId.toString());
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Mike")
                .build();
    }

    @Override
    public CustomerDto save(CustomerDto customerToSave) {
        log.info("Creating customer with id: " + customerToSave);
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(customerToSave.getName())
                .build();
    }

    @Override
    public CustomerDto update(UUID customerId, CustomerDto customerNewValues) {
        log.info("Updating customer with id: " + customerId.toString());
        return CustomerDto.builder()
                .id(customerId)
                .name(customerNewValues.getName())
                .build();
    }

    @Override
    public boolean delete(UUID customerId) {
        log.info("Deleting customer with id: " + customerId.toString());
        return customerId.getLeastSignificantBits() > 5L;
    }
}
