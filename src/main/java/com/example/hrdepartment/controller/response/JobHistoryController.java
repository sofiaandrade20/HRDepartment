package com.example.hrdepartment.controller.response;

import com.example.hrdepartment.controller.request.CreateJobHistoryRQ;
import com.example.hrdepartment.model.JobHistory;
import com.example.hrdepartment.service.JobHistoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class JobHistoryController {
    private final JobHistoryService jobHistoryService;

    public JobHistoryController(JobHistoryService jobHistoryService) {
        this.jobHistoryService = jobHistoryService;
    }

    @GetMapping(value = "/jobHistory")
    public List<JobHistory> getJobHistoryList() {
        return jobHistoryService.findAll();
    }

    @PostMapping(value = "/jobHistory", consumes = "application/json")
    public List<JobHistory> addJobHistory(@RequestBody @Valid List<CreateJobHistoryRQ> createJobHistoryRQ) {
        return jobHistoryService.save(createJobHistoryRQ);
    }

    @DeleteMapping(path = "/jobHistory/{id}")
    public void deleteJobHistory(@PathVariable(value = "id") Long jobHistoryId) {
        jobHistoryService.deleteById(jobHistoryId);
    }
}
