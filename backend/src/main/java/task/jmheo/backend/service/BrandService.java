package task.jmheo.backend.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import task.jmheo.backend.entity.Brand;
import task.jmheo.backend.entity.Prod;
import task.jmheo.backend.repository.BrandRepository;

@Service
public class BrandService {

	BrandRepository repo;

	public BrandService(BrandRepository repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<List<Prod>> prods(String target) {
		Brand brand = repo.findById(target).orElse(null);
		
		/**
		 * brand_cd에 traget값이 존재하지 않거나, 해당 브랜드를 시스템에서 사용하지 않을 경우
		 */
		if(brand==null || brand.getUseYn().equals("N")) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(brand.getProd(), HttpStatus.OK);
	}

}
