package kr.co.pawong.cicdtest.animal.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.pawong.cicdtest.animal.domain.Animal;
import kr.co.pawong.cicdtest.animal.dto.AnimalCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "animal")
@Builder
@AllArgsConstructor    // @Builder 와 함께 사용
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;

    private String kind;
    private String specialMark;

    public Animal toModel() {
        return Animal.builder()
                .animalId(animalId)
                .kind(kind)
                .specialMark(specialMark)
                .build();
    }
}

