package Acao;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamesDAO;


public class DeletarExame extends ActionSupport{


	String examePac;

	public String execute() {
		String statusCode = "";
		int recordDeleted = ExamesDAO.deleteExame(examePac);
		if (recordDeleted == 1) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}
		return statusCode;
	}

	public String getExamePac() {
		return examePac;
	}

	public void setExamePac(String examePac) {
		this.examePac = examePac;
	}
	
}
