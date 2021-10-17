package com.example.hrdepartment.service;

import com.example.hrdepartment.controller.request.CreateEmployeeRQ;
import com.example.hrdepartment.controller.request.CreateJobHistoryRQ;
import com.example.hrdepartment.model.Employee;
import com.example.hrdepartment.model.JobHistory;
import com.example.hrdepartment.repository.JobHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobHistoryService {
    private final JobHistoryRepository jobHistoryRepository;

    public JobHistoryService(JobHistoryRepository jobHistoryRepository) {
        this.jobHistoryRepository = jobHistoryRepository;
    }

    //Returns a list of all history jobs in the company
    public List<JobHistory> findAll() {
        return jobHistoryRepository.findAll();
    }

    //Creates a new JobHistory
    public List<JobHistory> save(List<CreateJobHistoryRQ> createJobHistoryRQList) {
        List<JobHistory> newJobHistoryList = new ArrayList<>();
        JobHistory newJobHistory;
        for (CreateJobHistoryRQ createJobHistoryRQ : createJobHistoryRQList) {
            newJobHistory = JobHistory.builder().description(createJobHistoryRQ.getDescription()).manager(createJobHistoryRQ.getManager()).build();
            jobHistoryRepository.save(newJobHistory);
            newJobHistoryList.add(newJobHistory);
        }
        return newJobHistoryList;
    }

    //Deletes an employee by Id
    public void deleteById(Long jobHistoryId) {
        jobHistoryRepository.deleteById(jobHistoryId);
    }
}
