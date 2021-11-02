package com.example.hrdepartment.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    private Department department;
    private String name;
    private Long age;
    private String email;
    private Long currentSalary;

    //One to many -> One employee can have many job categories (eg.: when promoted)
    @OneToMany(mappedBy="employee",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Job> job = new ArrayList<>();

    //One to many -> One employee can have many job categories (eg.: when promoted)
    @OneToMany(mappedBy="employee",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Job> jobHistory = new ArrayList<>();

}