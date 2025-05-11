package kr.co.pawong.cicdtest.animal.repository;

import co.elastic.clients.elasticsearch._types.query_dsl.Operator;
import kr.co.pawong.cicdtest.animal.domain.Animal;
import kr.co.pawong.cicdtest.animal.dto.AnimalSearchCondition;
import kr.co.pawong.cicdtest.animal.dto.AnimalSearchResponse;
import kr.co.pawong.cicdtest.animal.repository.document.AnimalDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnimalSearchRepositoryImpl implements AnimalSearchRepository {

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public AnimalSearchResponse searchSimilarAnimals(AnimalSearchCondition condition) {
        String term = condition.getSearchTerm();

        // NativeQuery 안에서 match 쿼리를 직접 정의
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q
                        .match(m -> m
                                .field("specialMark")
                                .query(term)
                                .analyzer("korean")          // 형태소 분석기
                                .operator(Operator.And)      // 토큰 간 AND 연산
                        )
                )
                .withMaxResults(50)               // 최대 50개 결과
                .build();

        // 실행 & 도메인 매핑
        SearchHits<AnimalDocument> hits =
                elasticsearchOperations.search(query, AnimalDocument.class);

        return AnimalSearchResponse.builder()
                .animals(hits.stream()
                        .map(hit -> hit.getContent())
                        .map(doc -> Animal.builder()  // Animal에 @Builder가 붙어 있다고 가정
                                .animalId(doc.getAnimalId())
                                .specialMark(doc.getSpecialMark())
                                .kind(doc.getKind())
                                .build()
                        )
                        .toList())
                .build();
    }
}