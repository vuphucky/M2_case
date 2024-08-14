package model.service.customerService;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> displayCustomer();

    void add(List<Customer> customerList);

    void remove();

    void update();
}
