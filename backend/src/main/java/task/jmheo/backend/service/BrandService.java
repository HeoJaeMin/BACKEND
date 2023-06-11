package task.jmheo.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import task.jmheo.backend.dto.BrandTop;
import task.jmheo.backend.entity.Brand;
import task.jmheo.backend.entity.Prod;
import task.jmheo.backend.repository.BrandRepository;

@Service
public class BrandService {

	BrandRepository repo;

	EntityManager em;

	public BrandService(BrandRepository repo, EntityManager em) {
		super();
		this.repo = repo;
		this.em = em;
	}

	/*
	 * brand에 대한 전체 상품 목록
	 */
	public ResponseEntity<List<Prod>> prods(String target) {
		Brand brand = repo.findById(target).orElse(null);

		/**
		 * brand_cd에 traget값이 존재하지 않거나, 해당 브랜드를 시스템에서 사용하지 않을 경우
		 */
		if (brand == null || brand.getUseYn().equals("N")) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(brand.getProd(), HttpStatus.OK);
	}

	/**
	 * 가장 많이 판매된 상위 3개 브랜드명과 판매수량
	 */
	public ResponseEntity<List<BrandTop>> top(String limit) {

		Long conv = 0L;
		/**
		 * 
		 */
		try {
			conv = Long.parseLong(limit);
		} catch (NumberFormatException e) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}

		JPAQueryFactory jq = new JPAQueryFactory(em);

		List<BrandTop> res = BrandTop.getQuery(jq, conv).fetch();

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
