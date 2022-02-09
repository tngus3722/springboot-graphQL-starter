package com.musinsa.graphql.graphQLResolver.student;

import com.musinsa.graphql.annotation.ValidationGroup;
import com.musinsa.graphql.dto.page.OffsetCriteria;
import com.musinsa.graphql.dto.request.student.StudentPutRequestDTO;
import com.musinsa.graphql.dto.response.student.StudentResponseDTO;
import com.musinsa.graphql.service.student.StudentService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@RequiredArgsConstructor
@Component
@GraphQLApi
public class StudentResolver {

    private final StudentService studentService;

    @GraphQLQuery(name = "students")
    public List<StudentResponseDTO> getStudents(@Validated(ValidationGroup.Read.class) OffsetCriteria offsetCriteria) {
        return studentService.getStudents(offsetCriteria);
    }

    @GraphQLQuery(name = "student")
    public StudentResponseDTO getStudentById(@GraphQLArgument(name = "id") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @GraphQLMutation(name = "putStudent")
    public StudentResponseDTO putStudentByID(@GraphQLArgument(name = "id") Long studentId,
            @GraphQLArgument(name = "studentPutRequestDTO") StudentPutRequestDTO studentPutRequestDTO) {
        return studentService.putStudentById(studentId, studentPutRequestDTO);
    }

    @GraphQLMutation(name = "deleteStudent")
    public void deleteStudentByID(@GraphQLArgument(name = "id") Long studentId) {
        studentService.deleteStudentById(studentId);
    }
}
