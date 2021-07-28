package Acao;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamesDAO;
import pojo.Exame;

public class CarregarExames extends ActionSupport {

	List<Exame> exames;

	public void InicializarExames() {
		exames = ExamesDAO.getAllExame();
	}

	public String execute() {
		InicializarExames();
		return "success";
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

}
