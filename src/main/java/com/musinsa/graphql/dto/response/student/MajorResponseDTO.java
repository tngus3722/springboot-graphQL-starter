package com.musinsa.graphql.dto.response.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MajorResponseDTO {

    private Long majorId;
    private String majorName;
}
