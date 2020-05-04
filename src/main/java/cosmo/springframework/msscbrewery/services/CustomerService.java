package cosmo.springframework.msscbrewery.services;

import cosmo.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

   CustomerDto  getCustomerById(UUID customerId);


   CustomerDto saveCustomer(CustomerDto customerDto);

   void updateCustomer(UUID customerId, CustomerDto customerDto);

   void deleteById(UUID customerId);
}
