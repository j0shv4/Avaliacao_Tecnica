package Acao;


import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamesDAO;
import pojo.Exame;


public class RecuperarDados extends ActionSupport {
	
	Integer exameId;
	String examePac;
	String exameNome;
	Date exameData;
	String exameObsRes;
	
	public String execute() {
		Exame exame = ExamesDAO.getExameById(exameId);
		exameId = exame.getExameId();
		examePac = exame.getExamePac();
		exameNome = exame.getExameNome();
		exameData = exame.getExameData();
		exameObsRes = exame.getExameObsRes();	
		return "success";			
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
	
}
