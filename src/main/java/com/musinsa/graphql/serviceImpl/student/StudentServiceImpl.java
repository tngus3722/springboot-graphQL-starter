package com.musinsa.graphql.serviceImpl.student;

import com.musinsa.graphql.dto.page.OffsetCriteria;
import com.musinsa.graphql.dto.request.student.StudentPutRequestDTO;
import com.musinsa.graphql.dto.response.student.StudentResponseDTO;
import com.musinsa.graphql.entity.student.StudentEntity;
import com.musinsa.graphql.enums.ErrorMessage;
import com.musinsa.graphql.exception.staticException.RequestInputException;
import com.musinsa.graphql.mapper.student.StudentMapper;
import com.musinsa.graphql.repository.student.StudentRepository;
import com.musinsa.graphql.service.student.StudentService;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Transactional(readOnly = true)
    @Override
    public List<StudentResponseDTO> getStudents(OffsetCriteria offsetCriteria) {
        return studentRepository.findAll(PageRequest.of(offsetCriteria.getPage(), offsetCriteria.getLimit()))
                .stream()
                .map(StudentMapper.INSTANCE::toStudentResponseDTO)
                .sorted(Comparator.comparing(StudentResponseDTO::getStudentId))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public StudentResponseDTO getStudentById(Long studentId) {
        return studentMapper.toStudentResponseDTO(this.getStudentEntity(studentId));
    }

    @Transactional
    @Override
    public StudentResponseDTO putStudentById(Long studentId, StudentPutRequestDTO studentPutRequestDTO) {
        StudentEntity studentEntity = this.getStudentEntity(studentId);
        studentEntity.update(studentPutRequestDTO);
        return this.getStudentById(studentId);
    }

    @Transactional
    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.delete(this.getStudentEntity(studentId));
    }

    private StudentEntity getStudentEntity(Long studentId) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(studentId);
        if (optionalStudentEntity.isEmpty()) {
            throw new RequestInputException(ErrorMessage.STUDENT_NOT_EXIST_EXCEPTION, false);
        }
        return optionalStudentEntity.get();
    }
}
