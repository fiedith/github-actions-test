package kr.co.pawong.cicdtest.animal.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AnimalSearchCondition {

    private String searchTerm;  // specialMark(특징) 검색어
}
