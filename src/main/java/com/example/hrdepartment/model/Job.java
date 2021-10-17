package com.example.hrdepartment.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Job")
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String description;
    private Long maxSalary;
    private Long minSalary;
    @ManyToOne
    @JoinColumn(name="employeeID")
    private Employee employee;
}