package task.jmheo.backend.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import task.jmheo.backend.entity.QProd;
import task.jmheo.backend.entity.QProdDvs;
import task.jmheo.backend.entity.QProdSell;

public class ProdCatCnt {

	private String dvsCd;
	private String dvsNm;
	private String pareDvsCd;
	private String pareDvsNm;
	private String fasNm;
	private Long catCnt;
	private Long sellCnt;
	
	/**
	 * 상품 구분에 딸느 상품 수, 판매 수량 조회 쿼리
	 * @param jq
	 * @param target
	 * @return
	 */
	public static JPAQuery<ProdCatCnt> getQuery(JPAQueryFactory jq, String target){
		QProdDvs dvs = QProdDvs.prodDvs;
		QProdDvs dvsNm = new QProdDvs("dvsNm");
		QProd prod = QProd.prod;
		QProdSell sell = QProdSell.prodSell;
		
		BooleanBuilder builder = new BooleanBuilder();
		
		if(!target.equals("-1")) {
			builder.and(dvs.prodDvsCd.startsWith(target));
		}
		
		JPAQuery<ProdCatCnt> query = jq.select(new QProdCatCnt(
				dvs.prodDvsCd,
				dvs.prodDvsNm,
				dvs.pareProdDvsCd,
				dvsNm.prodDvsNm,
				prod.count().coalesce(0L),
				sell.sellCnt.sum().coalesce(0L)
			))
			.from(dvs)
			.leftJoin(dvsNm).on(dvs.pareProdDvsCd.eq(dvsNm.prodDvsCd))
			.leftJoin(prod).on(prod.prodDvsCd.startsWith(dvs.prodDvsCd))
			.leftJoin(sell).on(sell.prodCd.eq(prod.prodCd))
			.where(
					dvs.useYn.eq("Y")
					.and(
						dvsNm.useYn.eq("Y")
						.or(dvsNm.prodDvsCd.isNull())
							)
				)
			.groupBy(
					dvs.prodDvsCd,
					dvs.prodDvsNm,
					dvs.pareProdDvsCd,
					dvsNm.prodDvsNm
				)
			;
		
		return query;
	}

	public String getDvsCd() {
		return dvsCd;
	}

	public void setDvsCd(String dvsCd) {
		this.dvsCd = dvsCd;
	}

	public String getDvsNm() {
		return dvsNm;
	}

	public void setDvsNm(String dvsNm) {
		this.dvsNm = dvsNm;
	}

	public String getPareDvsCd() {
		return pareDvsCd;
	}

	public void setPareDvsCd(String pareDvsCd) {
		this.pareDvsCd = pareDvsCd;
	}

	public String getPareDvsNm() {
		return pareDvsNm;
	}

	public String getFasNm() {
		return fasNm;
	}

	public void setFasNm(String fasNm) {
		this.fasNm = fasNm;
	}

	public void setPareDvsNm(String pareDvsNm) {
		this.pareDvsNm = pareDvsNm;
	}

	public Long getCatCnt() {
		return catCnt;
	}

	public void setCatCnt(Long catCnt) {
		this.catCnt = catCnt;
	}

	public Long getSellCnt() {
		return sellCnt;
	}

	public void setSellCnt(Long sellCnt) {
		this.sellCnt = sellCnt;
	}

	@QueryProjection

	public ProdCatCnt(String dvsCd, String dvsNm, String pareDvsCd, String pareDvsNm,Long catCnt,
			Long sellCnt) {
		super();
		this.dvsCd = dvsCd;
		this.dvsNm = dvsNm;
		this.pareDvsCd = pareDvsCd;
		this.pareDvsNm = pareDvsNm;
		this.catCnt = catCnt;
		this.sellCnt = sellCnt;
	}

	

	public ProdCatCnt() {
		super();
	}


	@Override
	public String toString() {
		return "ProdCatCnt [dvsCd=" + dvsCd + ", dvsNm=" + dvsNm + ", catCnt=" + catCnt + "]";
	}

}
