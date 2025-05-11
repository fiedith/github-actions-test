package kr.co.pawong.cicdtest.animal.repository.document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "animal")
public class AnimalDocument {

    @Id
    @Field(type = FieldType.Keyword, name = "animalId")
    private Long animalId;

    @Field(type = FieldType.Text, name = "specialMark", analyzer = "korean")
    private String specialMark;

    @Field(type = FieldType.Keyword, name = "kind")
    private String kind;
}
