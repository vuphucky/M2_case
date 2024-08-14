package model.repo;

import model.Customer;
import model.Employee;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> displayCustomer();

    void add(List<Customer> customerList);

    void remove();

    void update();
}