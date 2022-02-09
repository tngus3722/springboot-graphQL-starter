package com.musinsa.graphql.dto.response.student;

import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class StudentResponseDTO {

    @GraphQLQuery(name = "id")
    @NotNull
    private Long studentId;
    @GraphQLQuery(name = "studentName")
    private String studentName;
    @GraphQLQuery(name = "studentCode")
    private String studentCode;
    @GraphQLQuery(name = "majors")
    private List<MajorResponseDTO> majorResponseDTOs;
}
