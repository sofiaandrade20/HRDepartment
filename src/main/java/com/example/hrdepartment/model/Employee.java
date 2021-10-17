package com.example.hrdepartment.model;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="Employee")
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
    /*@OneToMany(mappedBy = "jobHistory")
    private List<JobHistory> jobHistoryList;
    //One to many -> One employee can have many job categories (eg.: when promoted)
    @OneToMany(mappedBy = "job")
    private List<Job> jobList;*/

}