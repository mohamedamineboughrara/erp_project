package com.oga.interview.mappers;

import com.oga.interview.queries.dtos.InterviewResponseDTO;
import com.oga.interview.queries.entities.Interview;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface InterviewMapper {
    InterviewResponseDTO interviewToInterviewDTO(Interview interview);
}
