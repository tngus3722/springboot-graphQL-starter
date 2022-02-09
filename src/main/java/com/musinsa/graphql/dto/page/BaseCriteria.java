package com.musinsa.graphql.dto.page;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BaseCriteria {

    protected Integer limit = 10;
    protected String sortBy = "id";
    protected String order = "desc";
}
