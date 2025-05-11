package kr.co.pawong.cicdtest.animal.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Animal {

    private Long animalId;
    private String kind;    // 축종
    private String specialMark;     // 특징
}
