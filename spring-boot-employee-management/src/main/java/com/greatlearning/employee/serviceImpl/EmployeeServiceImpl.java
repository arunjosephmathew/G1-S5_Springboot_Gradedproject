package com.greatlearning.employee.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.repository.EmployeeRepository;
import com.greatlearning.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String addSingleEmployee(Employee employee) {
		employeeRepository.save(employee);
		employeeRepository.flush();
		return "Employee saved";
	}

	@Override
	public String addAllEmployees(List<Employee> employees) {
		employeeRepository.saveAll(employees);
		employeeRepository.flush();
		return "All Employees are Saved";
	}

	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Employee employee = this.getAnEmployeeById(id);
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		return this.employeeRepository.save(employee);
	}

	@Override
	public String deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		return "Deleted Employee id: " + id;

	}

	@Override
	public String deleteAllInBatch(List<Employee> employees) {
		employeeRepository.deleteAllInBatch(employees);
		return "Deleted all the Employees in the list in batch mode";

	}

	@Override
	public String pruneEmployees() {
		employeeRepository.deleteAll();
		return "prune complete";
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee getAnEmployeeById(Long id) {
		return this.employeeRepository.findById(id).orElseThrow();
	}

	@Override
	public List<Employee> getEmployeesWithFirstName(String firstName) {
		Employee empFirstName = new Employee();
		empFirstName.setFirstName(firstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastname", "email");
		Example<Employee> example = Example.of(empFirstName, exampleMatcher);
		return employeeRepository.findAll(example, Sort.by("firstName"));
	}

	@Override
	public List<Employee> getEmployeesWithLatestAddedOrder() {
		return employeeRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public List<Employee> getEmployeesCustomSortedById(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "id"));
	}

	@Override
	public List<Employee> getEmployeesCustomSortedByFirstName(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

}
