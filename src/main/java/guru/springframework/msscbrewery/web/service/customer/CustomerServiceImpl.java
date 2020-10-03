package guru.springframework.msscbrewery.web.service.customer;


import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Mike")
                .build();
    }

    @Override
    public CustomerDto save(CustomerDto customerToSave) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(customerToSave.getName())
                .build();
    }

    @Override
    public CustomerDto update(UUID customerId, CustomerDto customerNewValues) {
        return CustomerDto.builder()
                .id(customerId)
                .name(customerNewValues.getName())
                .build();
    }

    @Override
    public boolean delete(UUID customerId) {
        return customerId.getLeastSignificantBits() > 5L;
    }
}
