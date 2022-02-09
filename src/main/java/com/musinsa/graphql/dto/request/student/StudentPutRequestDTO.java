package com.musinsa.graphql.dto.request.student;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class StudentPutRequestDTO {

    @NotNull
    private String studentName;
}
