package kr.co.pawong.cicdtest.animal.service;

import kr.co.pawong.cicdtest.animal.dto.AnimalCreateRequest;
import kr.co.pawong.cicdtest.animal.dto.AnimalCreateResponse;
import kr.co.pawong.cicdtest.animal.repository.AnimalCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalCommandServiceImpl implements AnimalCommandService {
    private final AnimalCommandRepository animalCommandRepository;

    @Override
    public AnimalCreateResponse create(AnimalCreateRequest request) {
        Long id = animalCommandRepository.create(request);
        return new AnimalCreateResponse(id);
    }
}
