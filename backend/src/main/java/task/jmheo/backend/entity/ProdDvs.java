package task.jmheo.backend.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	// 상품 구분 명 ex) 01-패션, 0101-가방, 0102-신발, 0103-옷
	private String prodDvsNm;

	@Column(name = "PARE_PROD_DVS_CD")
	// 부모 상품 구분 코드 명 ex) 0101의 부모 상품 구분 코드 = 01
	private String pareProdDvsCd;

	@Column(name = "USE_YN")
	// 사용여부
	private String useYn;
	
	@JsonIgnore
	@OneToMany(mappedBy="prodDvs")
	private List<Prod> prod = new ArrayList<>();

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
