package Acao;

import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamesDAO;
import pojo.Exame;

public class AtualizarExame extends ActionSupport {

	Integer exameId;
	String examePac;
	String exameNome;
	Date exameData;
	String exameObsRes;

	public String execute() {

		String statusCode = "";
		Exame exame = new Exame(exameId, examePac, exameNome, exameData, exameObsRes);
		if (examePac == "") {
			addFieldError("examePac", "Nome do Paciente não pode ser duplicado ou Vazio");
			return "error";
		} else {
			if (exameNome == "") {
				addFieldError("exameNome", "Nome do Exame não pode ser Vazio");
				return "error";
			}
			if (exameData == null) {
				addFieldError("exameData", "Data não pode ser Vazio");
				return "error";
			}
			if (ExamesDAO.testaExameNomeDuplicadoEdicao(exame)) {
				return "error";
			}
			if (exame.getExameData() == null || !exame.getExameData().after(new Date(System.currentTimeMillis()))) {
				addFieldError("exameData", "Nao se pode marcar exame para o dia atual ou antes");
				return "error";
			}
		}
		int recordUpdated = ExamesDAO.atualizarExame(exame);
		if (recordUpdated == 1) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}
		return statusCode;
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