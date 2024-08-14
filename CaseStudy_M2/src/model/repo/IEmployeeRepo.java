package model.repo;

import model.Employee;

import java.util.List;

public interface IEmployeeRepo {
    List<Employee> displayEmployee();

    void add(List<Employee> employeeList);

    void removeEmployee();

    void update();
}
