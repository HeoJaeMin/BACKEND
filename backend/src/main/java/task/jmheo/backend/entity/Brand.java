package task.jmheo.backend.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BRAND")
/**
 * 브랜드 정보
 * 
 * @author Heo
 *
 */
public class Brand {

	@Id
	@Column(name = "BRAND_CD")
	// 브랜드 코드
	private String brandCd;

	@Column(name = "BRAND_NM")
	// 브랜드 명
	private String brandNm;

	@Column(name = "USE_YN")
	// 사용여부
	private String useYn;

	@OneToMany(mappedBy = "brand")
	private List<Prod> prod = new ArrayList<>();

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

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public Brand(String brandCd, String brandNm, String useYn) {
		super();
		this.brandCd = brandCd;
		this.brandNm = brandNm;
		this.useYn = useYn;
	}

	public Brand() {
		super();
	}

	@Override
	public String toString() {
		return "Brand [brandCd=" + brandCd + ", brandNm=" + brandNm + ", useYn=" + useYn + "]";
	}

}
