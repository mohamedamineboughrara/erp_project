package com.oga.interview.queries.repositories;

import com.oga.interview.enums.InterviewStatus;
import com.oga.interview.queries.entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview,String> {
    List<Interview> findInterviewByStatus(InterviewStatus status);
}
