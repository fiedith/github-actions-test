package kr.co.pawong.cicdtest.animal.dto;

import java.util.List;
import kr.co.pawong.cicdtest.animal.domain.Animal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AnimalSearchResponse {

    private List<Animal> animals;
}
