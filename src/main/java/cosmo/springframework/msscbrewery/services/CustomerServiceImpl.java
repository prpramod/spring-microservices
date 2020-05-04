package cosmo.springframework.msscbrewery.services;


import cosmo.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Pramod")
                .build();


    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();

    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        //  // todo impl - Update a Customer
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("deleting Customer....");

    }
}
