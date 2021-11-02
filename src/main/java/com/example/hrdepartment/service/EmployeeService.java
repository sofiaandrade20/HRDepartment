package com.example.hrdepartment.service;

import com.example.hrdepartment.controller.request.CreateEmployeeRQ;
import com.example.hrdepartment.exception.EmployeeNotFound;
import com.example.hrdepartment.model.Employee;
import com.example.hrdepartment.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Returns a list of all employees in the company
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //Returns an employee attributes by id
        public Employee findById(Long id) {
            return employeeRepository.findById(id)
                    .orElseThrow(() -> new EmployeeNotFound("Employee doesn't exists."));
        }

    //Creates a new Employee
    public List<Employee> save(List<CreateEmployeeRQ> createEmployeeRQList) {
        List<Employee> newEmployeeList = new ArrayList<>();
        Employee newEmployee;
        for (CreateEmployeeRQ createEmployeeRQ : createEmployeeRQList) {
            newEmployee = Employee.builder()
                    .department(createEmployeeRQ.getDepartment())
                    .name(createEmployeeRQ.getName())
                    .age(createEmployeeRQ.getAge())
                    .currentSalary(createEmployeeRQ.getCurrentSalary())
                    .email(createEmployeeRQ.getEmail())
                    .build();
            employeeRepository.save(newEmployee);
            newEmployeeList.add(newEmployee);
        }
        return newEmployeeList;
    }

    //Checks if an employee exists in the database
    public boolean checkIfEmployeeIsOnDatabase(Employee employee) {
        if (employee.getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Employee not found in the database.");
        }
        return this.employeeRepository.existsById(employee.getId());
    }

    //Updates current salary
    public Employee updateSalary(Long id, Long currentSalary) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFound("Employee doesn't exists."));
        employee.setCurrentSalary(currentSalary);
        return employeeRepository.save(employee);
    }

    //Deletes an employee by Id
    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
