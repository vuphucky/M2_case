package model.repo;

import model.Customer;
import storage.IOCustomer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    private final static List<Customer> listCustomer;

    static {
        listCustomer = new ArrayList<>();
    }

    @Override
    public List<Customer> displayCustomer() {
        return IOCustomer.readFromFile();
    }

    @Override
    public void add(List<Customer> list) {
        IOCustomer.writeToFile(list);
    }

    @Override
    public void remove() {
        displayCustomer();
    }

    @Override
    public void update() {
        displayCustomer();
    }
}
