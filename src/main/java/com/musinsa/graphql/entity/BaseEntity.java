package com.musinsa.graphql.entity;

import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
    @Basic
    @Column(name = "is_deleted")
    protected Boolean isDeleted = false;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    protected LocalDateTime createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    protected LocalDateTime updatedAt;
}