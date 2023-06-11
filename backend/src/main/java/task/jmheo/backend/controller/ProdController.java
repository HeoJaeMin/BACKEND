package task.jmheo.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import task.jmheo.backend.dto.ProdCatCnt;
import task.jmheo.backend.entity.Prod;
import task.jmheo.backend.service.ProdService;

@Controller
@RequestMapping("/prod")
public class ProdController {

	ProdService prodService;

	public ProdController(ProdService prodService) {
		super();
		this.prodService = prodService;
	}

	/**
	 * 상품 구분에 따른 상품수 조회
	 * @param target
	 * @return
	 */
	@GetMapping("/search/cat")
	public ResponseEntity<List<ProdCatCnt>> searchCat(@RequestParam(name="target")String target){
		return new ResponseEntity<List<ProdCatCnt>>(prodService.searchCat(target), HttpStatus.OK);
	}
	/**
	 * 상품 구분에 따른 상품 목록 조회
	 * @param target
	 * @return
	 */
	@GetMapping("/search/cat/details")
	public ResponseEntity<List<Prod>> detailList(@RequestParam(name="target")String target){
		return new ResponseEntity<List<Prod>>(prodService.detailList(target), HttpStatus.OK);
	}
}
