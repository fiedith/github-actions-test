package kr.co.pawong.cicdtest.animal.service;

import kr.co.pawong.cicdtest.animal.dto.AnimalQueryResponse;
import kr.co.pawong.cicdtest.animal.repository.AnimalQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalQueryServiceImpl implements AnimalQueryService {

    private final AnimalQueryRepository animalQueryRepository;

    @Override
    public AnimalQueryResponse findAll() {
        return animalQueryRepository.findAll();
    }
}
