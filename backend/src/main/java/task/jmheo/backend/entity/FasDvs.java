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
@Table(name = "FAS_DVS")
//패션 구분 정보
public class FasDvs {

	@Id
	@Column(name = "FAS_DVS_CD")
	//패션 구분 코드 ex) 01: 남성, 02: 여성, 03: 공용, 04: 키드
	private String fasDvsCd;

	@Column(name = "FAS_DVS_NM")
	//패션 구분 명
	private String fasDvsNm;

	@Column(name = "USE_YN")
	private String useYn;

	@JsonIgnore
	@OneToMany(mappedBy = "fasDvs")
	private List<Prod> prod = new ArrayList<>();

	public String getFasDvsCd() {
		return fasDvsCd;
	}

	public void setFasDvsCd(String fasDvsCd) {
		this.fasDvsCd = fasDvsCd;
	}

	public String getFasDvsNm() {
		return fasDvsNm;
	}

	public void setFasDvsNm(String fasDvsNm) {
		this.fasDvsNm = fasDvsNm;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public List<Prod> getProd() {
		return prod;
	}

	public void setProd(List<Prod> prod) {
		this.prod = prod;
	}

	public FasDvs(String fasDvsCd, String fasDvsNm, String useYn, List<Prod> prod) {
		super();
		this.fasDvsCd = fasDvsCd;
		this.fasDvsNm = fasDvsNm;
		this.useYn = useYn;
		this.prod = prod;
	}

	public FasDvs() {
		super();
	}

	@Override
	public String toString() {
		return "FasDvs [fasDvsCd=" + fasDvsCd + ", fasDvsNm=" + fasDvsNm + ", useYn=" + useYn + ", prod=" + prod + "]";
	}

}
