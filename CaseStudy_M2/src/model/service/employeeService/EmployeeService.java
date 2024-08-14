package model.service.employeeService;

import model.Employee;
import model.repo.EmployeeRepo;
import model.repo.IEmployeeRepo;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepo iEmployeeRepo = new EmployeeRepo();

    @Override
    public List<Employee> displayEmployee() {
        return iEmployeeRepo.displayEmployee();
    }

    @Override
    public void add(List<Employee> employeeList) {

        iEmployeeRepo.add(employeeList);
    }

    @Override
    public void removeEmployee() {
        iEmployeeRepo.removeEmployee();
    }

    @Override
    public void update() {
        iEmployeeRepo.update();
    }
}
