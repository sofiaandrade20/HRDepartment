package com.example.hrdepartment.repository;

import com.example.hrdepartment.model.Job;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
