package com.example.hrdepartment.controller;
import com.example.hrdepartment.controller.request.UpdateSalaryRQ;
import com.example.hrdepartment.model.Employee;
import com.example.hrdepartment.controller.request.CreateEmployeeRQ;
import com.example.hrdepartment.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@Validated
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/employee")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/employee/{id}")
    public Employee getEmployee(@PathVariable(value = "id") Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping(value="/employees",consumes ="application/json")
    public List<Employee> addEmployee(@RequestBody @Valid List<CreateEmployeeRQ> createEmployeeRQ){return employeeService.save(createEmployeeRQ);}

    @PutMapping("/employee/{id}/currentSalary")
    public ResponseEntity updateCurrentSalary(@PathVariable Long id, @RequestBody UpdateSalaryRQ request){
        final Employee updatedEmployee = employeeService.updateSalary(id,request.getCurrentSalary());
        return ResponseEntity.created(URI.create("/employee/" + id + "/currentSalary")).body("Updated Salary");
    }

    @DeleteMapping(path ="/employee/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        employeeService.deleteById(employeeId);
    }
}