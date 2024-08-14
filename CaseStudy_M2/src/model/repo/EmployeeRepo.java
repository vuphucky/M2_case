package model.repo;

import model.Employee;
import storage.IOEmployee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo {
    private final static List<Employee> listEmployee;
    static {
        listEmployee = new ArrayList<>();
    }

    @Override
    public List<Employee> displayEmployee() {
        return IOEmployee.readFromFile();
    }

    @Override
    public void add(List<Employee> employeeList) {
        IOEmployee.writeToFile(employeeList);
    }

    @Override
    public void removeEmployee() {
        displayEmployee();
    }

    @Override
    public void update() {
        displayEmployee();
    }
}
