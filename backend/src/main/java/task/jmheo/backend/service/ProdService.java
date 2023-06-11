package task.jmheo.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import task.jmheo.backend.dto.ProdCatCnt;
import task.jmheo.backend.entity.Prod;
import task.jmheo.backend.repository.ProdRepository;

@Service
public class ProdService {
	
	ProdRepository prodRepo;
	
	EntityManager em;
	
	JPAQueryFactory jq;
	
	public ProdService(ProdRepository prodRepo, EntityManager em) {
		super();
		this.prodRepo = prodRepo;
		this.em = em;
		this.jq = new JPAQueryFactory(em);
	}

	/**
	 * 상품 구분에 따른 상품 목록 조회
	 * @param target
	 * @return
	 */
	public List<Prod> detailList(String target) {
		List<Prod> list = prodRepo.findByProdDvsCdStartsWithAndUseYn(target,"Y").orElseThrow();
		return list;
	}
	
	/**
	 * 상품 구분에 따른 상품 수, 판매 수량 조회
	 * @param target
	 * @return
	 */
	public List<ProdCatCnt> searchCat(String target){
		List<ProdCatCnt> list = ProdCatCnt.getQuery(jq, target).fetch();
		
		return list;
	}

}
