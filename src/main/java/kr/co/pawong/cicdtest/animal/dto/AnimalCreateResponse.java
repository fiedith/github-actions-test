package kr.co.pawong.cicdtest.animal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AnimalCreateResponse {

    private Long animalId;
}
