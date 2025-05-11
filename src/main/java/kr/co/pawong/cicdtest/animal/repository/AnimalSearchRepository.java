package kr.co.pawong.cicdtest.animal.repository;

import kr.co.pawong.cicdtest.animal.dto.AnimalSearchCondition;
import kr.co.pawong.cicdtest.animal.dto.AnimalSearchResponse;

public interface AnimalSearchRepository {

    AnimalSearchResponse searchSimilarAnimals(AnimalSearchCondition condition);
}
