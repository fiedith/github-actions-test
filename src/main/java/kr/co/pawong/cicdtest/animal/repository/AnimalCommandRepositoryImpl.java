package kr.co.pawong.cicdtest.animal.repository;

import kr.co.pawong.cicdtest.animal.dto.AnimalCreateRequest;
import kr.co.pawong.cicdtest.animal.repository.entity.AnimalEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnimalCommandRepositoryImpl implements AnimalCommandRepository {

    private final AnimalJpaRepository animalJpaRepository;

    @Override
    public Long create(AnimalCreateRequest request) {
        AnimalEntity entity = AnimalEntity.builder()
                .kind(request.getKind())
                .specialMark(request.getSpecialMark())
                .build();

        AnimalEntity saved = animalJpaRepository.save(entity);

        return saved.getAnimalId();
    }
}