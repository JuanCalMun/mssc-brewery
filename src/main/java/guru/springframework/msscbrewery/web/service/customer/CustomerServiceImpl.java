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
//        TODO not implemented yet
        return null;
    }

    @Override
    public CustomerDto update(UUID customerId, CustomerDto customerNewValues) {
//        TODO not implemented yet
        return null;
    }

    @Override
    public boolean delete(UUID customerId) {
//        TODO not implemented yet
        return false;
    }
}
