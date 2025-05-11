package kr.co.pawong.cicdtest.animal.repository;

import java.util.ArrayList;
import java.util.List;
import kr.co.pawong.cicdtest.animal.domain.Animal;
import kr.co.pawong.cicdtest.animal.dto.AnimalQueryResponse;
import kr.co.pawong.cicdtest.animal.repository.entity.AnimalEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnimalQueryRepositoryImpl implements AnimalQueryRepository {

    private final AnimalJpaRepository animalJpaRepository;

    @Override
    public AnimalQueryResponse findAll() {
        List<AnimalEntity> animalEntities = animalJpaRepository.findAll();
        List<Animal> animals = new ArrayList<>();
        for (AnimalEntity animalEntity : animalEntities) {
            animals.add(animalEntity.toModel());
        }

        return AnimalQueryResponse.builder()
                .animals(animals)
                .build();
    }
}
