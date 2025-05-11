package kr.co.pawong.cicdtest.animal.repository;

import kr.co.pawong.cicdtest.animal.dto.AnimalQueryResponse;

public interface AnimalQueryRepository {

    AnimalQueryResponse findAll();
}
