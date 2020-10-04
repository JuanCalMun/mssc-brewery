package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import guru.springframework.msscbrewery.web.service.customer.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerRestController {

    CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDto customerToSave) {
        CustomerDto savedCustomer = customerService.save(customerToSave);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/v1/customer/" + savedCustomer.getId().toString()));
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable UUID customerId,
                               @RequestBody CustomerDto customerNewValues) {
        customerService.update(customerId, customerNewValues);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID customerId) {
        customerService.delete(customerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity validationHandler(ConstraintViolationException exception) {
        List<String> errorList = exception.getConstraintViolations()
                .stream()
                .map(e -> e.getPropertyPath() + ":" + e.getMessage())
                .collect(Collectors.toList());
        return new ResponseEntity(errorList, HttpStatus.BAD_REQUEST);
    }
}
