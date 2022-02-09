package com.musinsa.graphql.entity.student;

import com.musinsa.graphql.dto.request.student.StudentPutRequestDTO;
import com.musinsa.graphql.entity.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
@SQLDelete(sql = "UPDATE student SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
@Table(name = "student")
public class StudentEntity extends BaseEntity {

    /***
     * 학생 이름
     */
    @Basic
    @Column(name = "student_name")
    private String studentName;
    /**
     * 학번
     */
    @Basic
    @Column(name = "student_code")
    private String studentCode;
    /**
     * 전공리스트
     */
    @OneToMany(mappedBy = "studentEntity", fetch = FetchType.LAZY)
    private List<MajorEntity> majorEntities = new ArrayList<>();

    public void update(StudentPutRequestDTO studentPutRequestDTO){
        this.studentName = studentPutRequestDTO.getStudentName();
    }
}
