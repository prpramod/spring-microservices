package cosmo.springframework.msscbrewery.controller;

import cosmo.springframework.msscbrewery.services.CustomerService;
import cosmo.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
   // @GetMapping({"/{beerId}"})
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){

   return  new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

}
