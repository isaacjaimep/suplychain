package guru.springframework.msscbrewery.web.controller;


import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {


    private  final CustomerService customerService;

    public CustomerController(CustomerService customerService){ this.customerService=customerService;}


    @GetMapping("/{customer}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customer") UUID customer)
    {
   return new ResponseEntity<>(customerService.getCustomer(customer), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){

            CustomerDto created= customerService.saveCustomer(customerDto);
        HttpHeaders h = new HttpHeaders();
        h.add("location","/api/v1/beer" + created.getId().toString());

    return new ResponseEntity<>(created,h,HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate( @PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomer(customerId);

    }


}// fin de clase
