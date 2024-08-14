package model.service.employeeService;

import model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> displayEmployee();

    void add(List<Employee> employeeList);

    void removeEmployee();

    void update();
}
