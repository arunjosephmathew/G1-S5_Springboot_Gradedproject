package com.greatlearning.employee.service;

import java.util.List;
import org.springframework.data.domain.Sort.Direction;
import com.greatlearning.employee.entity.Employee;

public interface EmployeeService {

	String addSingleEmployee(Employee employee);

	String addAllEmployees(List<Employee> employees);

	String deleteEmployeeById(Long id);

	String deleteAllInBatch(List<Employee> employees);

	List<Employee> getAllEmployee();

	Employee getAnEmployeeById(Long id);

	Employee updateEmployee(Long id, Employee updatedEmployee);

	List<Employee> getEmployeesWithFirstName(String firstName);

	List<Employee> getEmployeesWithLatestAddedOrder();

	List<Employee> getEmployeesCustomSortedById(Direction direction);

	List<Employee> getEmployeesCustomSortedByFirstName(Direction direction);

	String pruneEmployees();

}
