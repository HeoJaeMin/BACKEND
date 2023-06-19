package task.jmheo.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
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
	public List<Prod> prods(String target) {
		Brand brand = repo.findById(target).orElse(null);

		/**
		 * brand_cd에 traget값이 존재하지 않거나, 해당 브랜드를 시스템에서 사용하지 않을 경우
		 */
		if (brand == null || brand.getUseYn().equals("N")) {
			throw new EntityNotFoundException();
		}
		
		List<Prod> prods = brand.getProd();
		
		//판매량 높은순으로 정렬
		prods.sort((o1, o2) -> {
			return o2.getSellCnt().compareTo(o1.getSellCnt());
		});

		return prods;
	}

	/**
	 * 가장 많이 판매된 상위 3개 브랜드명과 판매수량
	 */
	public List<BrandTop> top(String limit) {

		Long conv = Long.parseLong(limit);

		JPAQueryFactory jq = new JPAQueryFactory(em);

		List<BrandTop> res = BrandTop.getQuery(jq, conv).fetch();

		return res;
	}

	public List<Brand> list() {
		return repo.findAll();
	}

}
