package kr.co.pawong.cicdtest.animal.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AnimalCreateRequest {
    private String kind;
    private String specialMark;
}
