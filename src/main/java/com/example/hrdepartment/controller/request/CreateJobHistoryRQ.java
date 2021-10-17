package com.example.hrdepartment.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateJobHistoryRQ {
    private String description;
    private String manager;
}
