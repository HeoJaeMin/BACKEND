package task.jmheo.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROD_SELL")
public class ProdSell {

	@Id
	@Column(name = "PROD_CD")
	// 상품 코드
	private String prodCd;

	@Column(name = "SELL_CNT")
	// 판매량
	private Long sellCnt;

	@JsonIgnore//Jackson 순환참조 방지
	@OneToOne(mappedBy = "prodSell")
	private Prod prod;

	public String getProdCd() {
		return prodCd;
	}

	public void setProdCd(String prodCd) {
		this.prodCd = prodCd;
	}

	public Long getSellCnt() {
		return sellCnt;
	}

	public void setSellCnt(Long sellCnt) {
		this.sellCnt = sellCnt;
	}

	public Prod getProd() {
		return prod;
	}

	public void setProd(Prod prod) {
		this.prod = prod;
	}

	public ProdSell(String prodCd, Long sellCnt, Prod prod) {
		super();
		this.prodCd = prodCd;
		this.sellCnt = sellCnt;
		this.prod = prod;
	}

	public ProdSell() {
		super();
	}

	@Override
	public String toString() {
		return "ProdSell [prodCd=" + prodCd + ", sellCnt=" + sellCnt + ", prod=" + prod + "]";
	}

}
