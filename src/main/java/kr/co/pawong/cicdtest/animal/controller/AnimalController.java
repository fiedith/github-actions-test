package kr.co.pawong.cicdtest.animal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.pawong.cicdtest.animal.dto.AnimalQueryResponse;
import kr.co.pawong.cicdtest.animal.dto.AnimalSearchCondition;
import kr.co.pawong.cicdtest.animal.dto.AnimalSearchResponse;
import kr.co.pawong.cicdtest.animal.service.AnimalQueryService;
import kr.co.pawong.cicdtest.animal.service.AnimalSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Animals", description = "동물 검색 및 조회 API")
@RestController
@RequestMapping(path = "/api/v1/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalSearchService animalSearchService;
    private final AnimalQueryService animalQueryService;

    @Operation(
            summary = "Elasticsearch 기반 동물 검색",
            description = "특징(searchTerm)으로 색인된 specialMark 필드에 대해 형태소 분석기(korean)를 사용한 AND 매칭 검색을 수행합니다."
    )
    @GetMapping("/search")
    public AnimalSearchResponse searchByTerm(
            @Parameter(
                    description = "검색어 (동물의 특징)",
                    required = true,
                    schema = @Schema(example = "fluffy small")
            )
            @RequestParam("term") String term
    ) {
        AnimalSearchCondition condition = AnimalSearchCondition.builder()
                .searchTerm(term)
                .build();
        return animalSearchService.search(condition);
    }

    @Operation(
            summary = "RDB에서 모든 동물 조회",
            description = "JPA를 이용해 데이터베이스에 저장된 모든 Animal 엔티티를 조회하여 반환합니다."
    )
    @GetMapping("/all")
    public AnimalQueryResponse findAll() {
        return animalQueryService.findAll();
    }
}