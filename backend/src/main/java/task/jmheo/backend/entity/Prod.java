package task.jmheo.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROD")
/**
 * 상품 정보
 * @author Heo
 *
 */
public class Prod {

	@Id
	@Column(name = "PROD_CD")
	//상품 코드
	private String prodCd;

	@Column(name = "PROD_NM")
	//상품명
	private String prodNm;

	@Column(name = "PROD_DVS_CD")
	//상품구분코드
	private String prodDvsCd;

	@Column(name = "BRAND_CD")
	//브랜드 코드
	private String brandCd;

	@Column(name = "USE_YN")
	//사용여부
	private String useYn;

	@Override
	public String toString() {
		return "Prod [prodCd=" + prodCd + ", prodNm=" + prodNm + ", prodDvsCd=" + prodDvsCd + ", brandCd=" + brandCd
				+ ", useYn=" + useYn + "]";
	}

	public String getProdCd() {
		return prodCd;
	}

	public void setProdCd(String prodCd) {
		this.prodCd = prodCd;
	}

	public String getProdNm() {
		return prodNm;
	}

	public void setProdNm(String prodNm) {
		this.prodNm = prodNm;
	}

	public String getProdDvsCd() {
		return prodDvsCd;
	}

	public void setProdDvsCd(String prodDvsCd) {
		this.prodDvsCd = prodDvsCd;
	}

	public String getBrandCd() {
		return brandCd;
	}

	public void setBrandCd(String brandCd) {
		this.brandCd = brandCd;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public Prod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prod(String prodCd, String prodNm, String prodDvsCd, String brandCd, String useYn) {
		super();
		this.prodCd = prodCd;
		this.prodNm = prodNm;
		this.prodDvsCd = prodDvsCd;
		this.brandCd = brandCd;
		this.useYn = useYn;
	}

}
