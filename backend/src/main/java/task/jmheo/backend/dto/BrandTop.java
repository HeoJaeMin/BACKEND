package task.jmheo.backend.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import task.jmheo.backend.entity.QBrand;
import task.jmheo.backend.entity.QProd;
import task.jmheo.backend.entity.QProdSell;

public class BrandTop {

	public static JPAQuery<BrandTop> getQuery(JPAQueryFactory jq, Long limit) {

		QBrand brand = QBrand.brand;
		QProd prod = QProd.prod;
		QProdSell sell = QProdSell.prodSell;

		NumberExpression<Long> sellExp = sell.sellCnt.sum();

		return jq.select(new QBrandTop(brand.brandCd, brand.brandNm, sellExp))
				.from(brand)
				.innerJoin(prod).on(brand.brandCd.eq(prod.brandCd))
				.innerJoin(sell).on(prod.prodCd.eq(sell.prodCd))
				.where(
						brand.useYn.eq("Y").and(prod.useYn.eq("Y"))
				)
				.groupBy(brand.brandCd, brand.brandNm)
				.limit(limit)
				.orderBy(sellExp.desc())
				;
	}

	private String brandCd;
	private String brandNm;
	private Long totSell;

	public String getBrandCd() {
		return brandCd;
	}

	public void setBrandCd(String brandCd) {
		this.brandCd = brandCd;
	}

	public String getBrandNm() {
		return brandNm;
	}

	public void setBrandNm(String brandNm) {
		this.brandNm = brandNm;
	}

	public Long getTotSell() {
		return totSell;
	}

	public void setTotSell(Long totSell) {
		this.totSell = totSell;
	}

	@QueryProjection
	public BrandTop(String brandCd, String brandNm, Long totSell) {
		super();
		this.brandCd = brandCd;
		this.brandNm = brandNm;
		this.totSell = totSell;
	}

	public BrandTop() {
		super();
	}

	@Override
	public String toString() {
		return "BrandTop [brandCd=" + brandCd + ", brandNm=" + brandNm + ", totSell=" + totSell + "]";
	}

}
