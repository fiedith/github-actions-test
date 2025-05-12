package kr.co.pawong.cicdtest.animal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.pawong.cicdtest.animal.dto.AnimalQueryResponse;
import kr.co.pawong.cicdtest.animal.service.AnimalQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Animals", description = "동물 검색 및 조회 API")
@RestController
@RequestMapping(path = "/api/v1/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalQueryService animalQueryService;

    @Operation(
            summary = "RDB에서 모든 동물 조회",
            description = "JPA를 이용해 데이터베이스에 저장된 모든 Animal 엔티티를 조회하여 반환합니다."
    )
    @GetMapping("/all")
    public AnimalQueryResponse findAll() {
        return animalQueryService.findAll();
    }
}