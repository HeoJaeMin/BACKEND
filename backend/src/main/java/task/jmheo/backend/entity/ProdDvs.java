package task.jmheo.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROD_DVS")
//상품 구분 정보
public class ProdDvs {

	@Id
	@Column(name = "PROD_DVS_CD")
	// 상품 구분 코드 ex) 01, 02, 0101, 0102
	private String prodDvsCd;

	@Column(name = "PROD_DVS_NM")
	// 상품 구분 명 ex) 01-패션, 0101-남성용, 0102-여성용, 0103-공용
	private String prodDvsNm;

	@Id
	@Column(name = "PARE_PROD_DVS_CD")
	// 부모 상품 구분 코드 명 ex) 0101의 부모 상품 구분 코드 = 01
	private String pareProdDvsCd;

	@Column(name = "USE_YN")
	// 사용여부
	private String useYn;

	public String getProdDvsCd() {
		return prodDvsCd;
	}

	public void setProdDvsCd(String prodDvsCd) {
		this.prodDvsCd = prodDvsCd;
	}

	public String getProdDvsNm() {
		return prodDvsNm;
	}

	public void setProdDvsNm(String prodDvsNm) {
		this.prodDvsNm = prodDvsNm;
	}

	public String getPareProdDvsCd() {
		return pareProdDvsCd;
	}

	public void setPareProdDvsCd(String pareProdDvsCd) {
		this.pareProdDvsCd = pareProdDvsCd;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public ProdDvs(String prodDvsCd, String prodDvsNm, String pareProdDvsCd, String useYn) {
		super();
		this.prodDvsCd = prodDvsCd;
		this.prodDvsNm = prodDvsNm;
		this.pareProdDvsCd = pareProdDvsCd;
		this.useYn = useYn;
	}

	public ProdDvs() {
		super();
	}

	@Override
	public String toString() {
		return "ProdDvs [prodDvsCd=" + prodDvsCd + ", prodDvsNm=" + prodDvsNm + ", pareProdDvsCd=" + pareProdDvsCd
				+ ", useYn=" + useYn + "]";
	}

}
