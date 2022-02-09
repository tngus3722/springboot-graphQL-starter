package com.musinsa.graphql.dto.page;

import com.musinsa.graphql.annotation.ValidationGroup;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OffsetCriteria extends BaseCriteria {

    @NotNull
    @Max(value = 100000, groups = ValidationGroup.Read.class, message = "page는 너무 클 수 없습니다.")
    private Integer page = 0;
}
