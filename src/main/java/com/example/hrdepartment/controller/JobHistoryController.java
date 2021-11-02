package com.example.hrdepartment.controller;

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
    //Get all job history
    @GetMapping(value = "/job-History")
    public List<JobHistory> getJobHistoryList() {
        return jobHistoryService.findAll();
    }

    //Create a new history
    @PostMapping(value = "/job-History", consumes = "application/json")
    public List<JobHistory> addJobHistory(@RequestBody @Valid List<CreateJobHistoryRQ> createJobHistoryRQ) {
        return jobHistoryService.save(createJobHistoryRQ);
    }

    //Delete a job history
    @DeleteMapping(path = "/job-History/{id}")
    public void deleteJobHistory(@PathVariable(value = "id") Long jobHistoryId) {
        jobHistoryService.deleteById(jobHistoryId);
    }
}
