<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Exame</title>
<link rel="stylesheet" href="style.css">
<script src="jquery-3.2.0.min.js"></script>
<script src="jquery.mask.min.js"></script>
</head>
<body>
	<div align="center">
		<h2>Novo Exame</h2>
		<s:form action= "novoExame" class="formTable">
			<s:textfield name="examePac" label="Nome Paciente" class="formTextField"/>
			<s:textfield name="exameNome" label="Nome Exame" class="formTextField"/>
			<s:textfield name="exameData" label="Data do Exame" class="formTextField"/>
			<s:textarea name="exameObsRes" label="Observação" class="formTextField"/>
			<s:submit name="Cadastrar Novo Exame" class="actionBtn"/>
		</s:form>
	</div>
	<script>
	$(document).ready(function(){
		  $('input[name=exameData]').mask('00/00/0000');
	});
	</script>
</body>
</html>