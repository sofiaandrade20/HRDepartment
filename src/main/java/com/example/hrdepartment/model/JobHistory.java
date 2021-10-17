package com.example.hrdepartment.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "JobHistory")
@Entity
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String description;
    private String manager;
    private String employeeID;
    @ManyToOne
    @JoinColumn(name="jobID")
    private Employee employee;
}