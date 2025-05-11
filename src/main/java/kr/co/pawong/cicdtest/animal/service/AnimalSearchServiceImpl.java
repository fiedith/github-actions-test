package kr.co.pawong.cicdtest.animal.service;

import kr.co.pawong.cicdtest.animal.dto.AnimalSearchCondition;
import kr.co.pawong.cicdtest.animal.dto.AnimalSearchResponse;
import kr.co.pawong.cicdtest.animal.repository.AnimalSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalSearchServiceImpl implements AnimalSearchService {

    private final AnimalSearchRepository animalSearchRepository;

    @Override
    public AnimalSearchResponse search(AnimalSearchCondition condition) {
        return animalSearchRepository.searchSimilarAnimals(condition);
    }

}
