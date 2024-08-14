package model.service.customerService;

import model.Customer;
import model.repo.CustomerRepo;
import model.repo.ICustomerRepo;

import java.util.List;

public class CustomerService implements ICustomerService{
    private ICustomerRepo iCustomerRepo = new CustomerRepo();

    @Override
    public List<Customer> displayCustomer() {
        return iCustomerRepo.displayCustomer();
    }

    @Override
    public void add(List<Customer> customerList) {
         iCustomerRepo.add(customerList);
    }

    @Override
    public void remove() {
        iCustomerRepo.remove();
    }

    @Override
    public void update() {
        iCustomerRepo.update();
    }
}
