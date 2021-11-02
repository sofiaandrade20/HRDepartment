package com.example.hrdepartment.service;

import com.example.hrdepartment.controller.request.CreateEmployeeRQ;
import com.example.hrdepartment.controller.request.CreateJobRQ;
import com.example.hrdepartment.model.Employee;
import com.example.hrdepartment.model.Job;
import com.example.hrdepartment.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //Returns a list of all jobs in the company
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    //Creates a new Job
    public List<Job> save(List<CreateJobRQ> createJobRQList) {
        List<Job> newJobList = new ArrayList<>();
        Job newJob;
        for (CreateJobRQ createJobRQ : createJobRQList) {
            newJob = Job.builder()
                    .description(createJobRQ.getDescription())
                    .maxSalary(createJobRQ.getMaxSalary())
                    .minSalary(createJobRQ.getMinSalary())
                    .build();
            jobRepository.save(newJob);
            newJobList.add(newJob);
        }
        return newJobList;
    }

    //Deletes an employee by Id
    public void deleteById(Long jobId) {
        jobRepository.deleteById(jobId);
    }
}
