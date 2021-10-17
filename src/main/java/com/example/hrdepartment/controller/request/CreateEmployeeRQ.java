package com.example.hrdepartment.controller.request;

import com.example.hrdepartment.model.Department;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployeeRQ {
    private Department department;
    @NotBlank(message = "Name is a mandatory field.")
    private String name;
    private Long age;
    private String email;
    private Long currentSalary;
}
