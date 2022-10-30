package guru.springframework.msscbrewery.services;


import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CutomerServiceImpl  implements  CustomerService {

    @Override
    public CustomerDto getCustomer(UUID customerId) {
        return  CustomerDto.builder().id(UUID.randomUUID())
                .name("Isaac").build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {

        return    CustomerDto.builder().id(customerDto.getId()).name(customerDto.getName()).build();

    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.info("Updating a customer");
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.info("deleting customer");
    }
}
