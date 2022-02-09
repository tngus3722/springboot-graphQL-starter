package com.musinsa.graphql.entity.student;

import com.musinsa.graphql.entity.BaseEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@NoArgsConstructor
@Setter
@Getter
@SQLDelete(sql = "UPDATE major SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
@Table(name = "major")
public class MajorEntity extends BaseEntity {

    /**
     * 전공명
     */
    @Basic
    @Column(name = "major_name")
    private String majorName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;
}
