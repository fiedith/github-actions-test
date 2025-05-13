package kr.co.pawong.cicdtest.animal.repository;

import kr.co.pawong.cicdtest.animal.dto.AnimalCreateRequest;

public interface AnimalCommandRepository {

    Long create(AnimalCreateRequest request);

}
