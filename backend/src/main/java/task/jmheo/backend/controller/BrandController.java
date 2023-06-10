package task.jmheo.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/prods")
	public ResponseEntity<List<Prod>> prods(@RequestParam(name="target")String target){
		return service.prods(target);
	}
}
