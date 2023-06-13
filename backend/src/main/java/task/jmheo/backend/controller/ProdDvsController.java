package task.jmheo.backend.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import task.jmheo.backend.entity.ProdDvs;
import task.jmheo.backend.service.ProdDvsService;

@RestController
@RequestMapping("/prodDvs")
public class ProdDvsController {
	
	ProdDvsService serv;
	
	

	public ProdDvsController(ProdDvsService serv) {
		super();
		this.serv = serv;
	}



	@GetMapping("/search")
	public ResponseEntity<ProdDvs> search(@RequestParam(name="target")String target){
		try {
			return new ResponseEntity<ProdDvs>(serv.search(target), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
