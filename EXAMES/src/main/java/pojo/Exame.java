package pojo;

import java.sql.Date;

public class Exame {

	Integer exameId;
	String examePac;
	String exameNome;
	Date exameData;
	String exameObsRes;

	public Exame() {
		// TODO Auto-generated constructor stub
	}

	public Exame(Integer exameId,String examePac, String exameNome, Date exameData, String exameObsRes) {
		this.exameId = exameId;
		this.examePac = examePac;
		this.exameNome = exameNome;
		this.exameData = exameData;
		this.exameObsRes = exameObsRes;
	}

	public Integer getExameId() {
		return exameId;
	}

	public void setExameId(Integer exameId) {
		this.exameId = exameId;
	}

	public String getExamePac() {
		return examePac;
	}

	public void setExamePac(String examePac) {
		this.examePac = examePac;
	}

	public String getExameNome() {
		return exameNome;
	}

	public void setExameNome(String exameNome) {
		this.exameNome = exameNome;
	}

	public Date getExameData() {
		return exameData;
	}

	public void setExameData(Date exameData) {
		this.exameData = exameData;
	}

	public String getExameObsRes() {
		return exameObsRes;
	}

	public void setExameObsRes(String exameObsRes) {
		this.exameObsRes = exameObsRes;
	}
	public String toString() {
		return "Exame [examePac=" + examePac + ",exameNome=" + exameNome + ",exameData" + exameData
				+ ",exameObsRes=" + exameObsRes + "]";
	}
}
