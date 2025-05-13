package kr.co.pawong.cicdtest.animal.repository;

import kr.co.pawong.cicdtest.animal.repository.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalJpaRepository extends JpaRepository<AnimalEntity, Long> {

}