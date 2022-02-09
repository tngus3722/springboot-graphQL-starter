package com.musinsa.graphql.repository.student;

import com.musinsa.graphql.entity.student.MajorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<MajorEntity, Long> {

}
