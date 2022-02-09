package com.musinsa.graphql.repository.student;

import com.musinsa.graphql.entity.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
