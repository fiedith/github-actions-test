package kr.co.pawong.cicdtest.animal.service;

import kr.co.pawong.cicdtest.animal.dto.AnimalCreateRequest;
import kr.co.pawong.cicdtest.animal.dto.AnimalCreateResponse;

public interface AnimalCommandService {
    AnimalCreateResponse create(AnimalCreateRequest request);
}
