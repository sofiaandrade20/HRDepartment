package com.example.hrdepartment.controller.response;

import com.example.hrdepartment.controller.request.CreateJobRQ;
import com.example.hrdepartment.model.Job;
import com.example.hrdepartment.service.JobService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(value = "/job")
    public List<Job> getJobList() {
        return jobService.findAll();
    }

    @PostMapping(value = "/job", consumes = "application/json")
    public List<Job> addJob(@RequestBody @Valid List<CreateJobRQ> createJobRQ) {
        return jobService.save(createJobRQ);
    }

    @DeleteMapping(path = "/job/{id}")
    public void deleteJob(@PathVariable(value = "id") Long jobId) {
        jobService.deleteById(jobId);
    }

}
