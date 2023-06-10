package task.jmheo.backend.entity;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "PROD")
/**
 * 상품 정보
 * 
 * @author Heo
 *
 */
public class Prod {

	@Id
	@Column(name = "PROD_CD")
	// 상품 코드
	private String prodCd;

	@Column(name = "PROD_NM")
	// 상품명
	private String prodNm;

	@Column(name = "PROD_DVS_CD")
	// 상품구분코드
	private String prodDvsCd;

	@Column(name = "FAS_DVS_CD")
	private String fasDvsCd;

	@Column(name = "BRAND_CD")
	// 브랜드 코드
	private String brandCd;

	@Transient
	private String brandNm;

	@Transient
	private String fasDvsNm;

	@Transient
	private Long sellCnt;

	@Column(name = "USE_YN")
	// 사용여부
	private String useYn;

	@JsonIgnore // Jackson 순환참조 방지
	@ManyToOne
	@JoinColumn(name = "BRAND_CD", insertable = false, updatable = false)
	private Brand brand;

	@JsonIgnore // Jackson 순환참조 방지
	@OneToOne
	@JoinColumn(name = "PROD_CD")
	private ProdSell prodSell;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "FAS_DVS_CD", insertable = false, updatable = false)
	@Where(clause = "FAS_DVS_CD IS NOT NULL")
	private FasDvs fasDvs;

	@PostLoad
	private void onLoad() {
		if (prodSell != null) {
			this.sellCnt = prodSell.getSellCnt();
		}

		if (brand != null) {
			this.brandNm = brand.getBrandNm();
		}

		if (fasDvs != null) {
			this.fasDvsNm = fasDvs.getFasDvsNm();
		}
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public ProdSell getProdSell() {
		return prodSell;
	}

	public void setProdSell(ProdSell prodSell) {
		this.prodSell = prodSell;
	}

	public String getFasDvsCd() {
		return fasDvsCd;
	}

	public void setFasDvsCd(String fasDvsCd) {
		this.fasDvsCd = fasDvsCd;
	}

	public FasDvs getFasDvs() {
		return fasDvs;
	}

	public void setFasDvs(FasDvs fasDvs) {
		this.fasDvs = fasDvs;
	}

	public String getBrandNm() {
		return brandNm;
	}

	public void setBrandNm(String brandNm) {
		this.brandNm = brandNm;
	}

	public Long getSellCnt() {
		return sellCnt;
	}

	public void setSellCnt(Long sellCnt) {
		this.sellCnt = sellCnt;
	}

	public String getFasDvsNm() {
		return fasDvsNm;
	}

	public void setFasDvsNm(String fasDvsNm) {
		this.fasDvsNm = fasDvsNm;
	}

	public Prod(String prodCd, String prodNm, String prodDvsCd, String fasDvsCd, String brandCd, String brandNm,
			String fasDvsNm, Long sellCnt, String useYn, Brand brand, ProdSell prodSell, FasDvs fasDvs) {
		super();
		this.prodCd = prodCd;
		this.prodNm = prodNm;
		this.prodDvsCd = prodDvsCd;
		this.fasDvsCd = fasDvsCd;
		this.brandCd = brandCd;
		this.brandNm = brandNm;
		this.fasDvsNm = fasDvsNm;
		this.sellCnt = sellCnt;
		this.useYn = useYn;
		this.brand = brand;
		this.prodSell = prodSell;
		this.fasDvs = fasDvs;
	}

	public Prod() {
		super();
	}

	@Override
	public String toString() {
		return "Prod [prodCd=" + prodCd + ", prodNm=" + prodNm + ", prodDvsCd=" + prodDvsCd + ", fasDvsCd=" + fasDvsCd
				+ ", brandCd=" + brandCd + ", brandNm=" + brandNm + ", fasDvsNm=" + fasDvsNm + ", sellCnt=" + sellCnt
				+ ", useYn=" + useYn + ", brand=" + brand + ", prodSell=" + prodSell + ", fasDvs=" + fasDvs + "]";
	}

}
