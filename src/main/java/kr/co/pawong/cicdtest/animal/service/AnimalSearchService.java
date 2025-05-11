package kr.co.pawong.cicdtest.animal.service;

import kr.co.pawong.cicdtest.animal.dto.AnimalSearchCondition;
import kr.co.pawong.cicdtest.animal.dto.AnimalSearchResponse;

public interface AnimalSearchService {

    AnimalSearchResponse search(AnimalSearchCondition condition);
}
