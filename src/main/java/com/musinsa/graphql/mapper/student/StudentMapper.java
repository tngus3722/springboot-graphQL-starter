package com.musinsa.graphql.mapper.student;

import com.musinsa.graphql.dto.response.student.MajorResponseDTO;
import com.musinsa.graphql.dto.response.student.StudentResponseDTO;
import com.musinsa.graphql.entity.student.MajorEntity;
import com.musinsa.graphql.entity.student.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "majorEntities", target = "majorResponseDTOs")
    @Mapping(source = "id", target = "studentId")
    StudentResponseDTO toStudentResponseDTO(StudentEntity studentEntity);

    @Mapping(source = "id", target = "majorId")
    MajorResponseDTO toMajorResponseDTO(MajorEntity majorEntity);
}
