package task.jmheo.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROD_SELL")
public class ProdSell {

	@Id
	@Column(name = "PROD_CD")
	// 상품 코드
	private String prodCd;

	@Column(name = "PROD_SELL")
	// 판매량
	private Long prodSell;

	public String getProdCd() {
		return prodCd;
	}

	public void setProdCd(String prodCd) {
		this.prodCd = prodCd;
	}

	public Long getProdSell() {
		return prodSell;
	}

	public void setProdSell(Long prodSell) {
		this.prodSell = prodSell;
	}

	public ProdSell(String prodCd, Long prodSell) {
		super();
		this.prodCd = prodCd;
		this.prodSell = prodSell;
	}

	public ProdSell() {
		super();
	}

	@Override
	public String toString() {
		return "ProdSell [prodCd=" + prodCd + ", prodSell=" + prodSell + "]";
	}

}
