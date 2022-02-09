package com.musinsa.graphql.service.student;

import com.musinsa.graphql.dto.page.OffsetCriteria;
import com.musinsa.graphql.dto.request.student.StudentPutRequestDTO;
import com.musinsa.graphql.dto.response.student.StudentResponseDTO;
import java.util.List;

public interface StudentService {

    List<StudentResponseDTO> getStudents(OffsetCriteria offsetCriteria);

    StudentResponseDTO getStudentById(Long studentId);

    StudentResponseDTO putStudentById(Long studentId, StudentPutRequestDTO studentPutRequestDTO);

    void deleteStudentById(Long studentId);
}
