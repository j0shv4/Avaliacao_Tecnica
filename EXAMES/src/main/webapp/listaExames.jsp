<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Exames</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div align="center">
		<h2>Lista Exames</h2>
		<a href=novoExame.jsp>
			<button class="actionBtn">Marcar Novo Exame</button>
		</a>
	</div>
	</br>
	<table width="750" class="examesTable" align="center">
		<thead>
			<tr>
				<th>Nome Paciente</th>
				<th>Exame</th>
				<th>Data</th>
				<th>Observaçao/Resultado</th>
				<th colspan="2">Ações</th>
			</tr>
		</thead>
		<s:iterator value="exames" var="exame">
			<tr >
				<td><s:property value="#exame.examePac" /></td>
				<td><s:property value="#exame.exameNome" /></td>
				<td><s:property value="#exame.exameData" /></td>
				<td><s:property value="#exame.exameObsRes" /></td>
				<td>
					<a href ="recuperarDados?exameId=<s:property value ="#exame.exameId"/>">
						<button class="actionBtn">Atualizar</button>
					</a>
				</td>
				<td>
				<a href ="excluirExame?examePac=<s:property value ="#exame.examePac"/>">
					<button class="actionBtn">Excluir</button>
				</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>