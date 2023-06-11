package task.jmheo.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import task.jmheo.backend.dto.BrandTop;
import task.jmheo.backend.entity.Prod;
import task.jmheo.backend.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	BrandService service;

	public BrandController(BrandService service) {
		super();
		this.service = service;
	}

	/*
	 * brand에 대한 전체 상품 목록
	 */
	@GetMapping("/prods")
	public ResponseEntity<List<Prod>> prods(@RequestParam(name = "target") String target) {
		return service.prods(target);
	}

	/**
	 * 가장 많이 판매된 상위 3개 브랜드명과 판매수량
	 */
	@GetMapping("/top")
	public ResponseEntity<List<BrandTop>> top(@RequestParam(name = "limit") String limit) {
		return service.top(limit);
	}
}
