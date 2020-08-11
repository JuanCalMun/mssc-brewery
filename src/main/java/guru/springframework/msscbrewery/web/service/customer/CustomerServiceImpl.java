package guru.springframework.msscbrewery.web.service.customer;


import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .name("Mike")
                .build();
    }
}
