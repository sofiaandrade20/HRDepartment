package com.example.hrdepartment.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateJobRQ {
    private String description;
    private Long maxSalary;
    private Long minSalary;
}
