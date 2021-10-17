package com.example.hrdepartment.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String description;
    private String manager;
    /*@ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employee;*/
}