<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<style>

	#evenDsTitulo, #evenDhEvento, #evenDsLocal {
		width: 350px;
	}
	
	#evenDsDescricao {
		width: 346px;
	}
	
	.cssTitleTableLabel {
		float: left;
		clear: left;
		width: 100%;
		margin-top: 2px;
		margin-bottom: 10px;
		font-family: Verdana;
		font-size: 13px;
		font-weight: bold;
		border-bottom: #000000 1px solid;
	}

</style>

<script src="../../js/baseList.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		var idReg = $("#idPessCdPessoa")[0].value;
		showTitle("Consultar Cadastro", "Informe seu nome e e-mail para consultar seu cadastro");
		
		centerScreen(320, 570);
	});
		
	function filterData() {
		openUrl("../Pessoa/viewData?pessDsEmail="+ $("#pessDsEmail").val());
	}
</script>

<form:form action="../Pessoa" modelAttribute="pessoaTO" id="pessoaForm" name="pessoaForm">
	<form:hidden path="entity.idPessCdPessoa" id="idPessCdPessoa" class="txtID" />

	<div style="float: left; border: 0px solid; padding: 10px;">

		<div class="cssTableLabel"><form:label path="entity.pessDsNome" for="pessDsNome">Nome:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.pessDsNome" cssClass="required" id="pessDsNome" maxlength="50" />
		</div>
		
		<div class="cssTableLabel"><form:label path="entity.pessDsEmail" for="pessDsEmail">Email:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.pessDsEmail" cssClass="required" id="pessDsEmail" maxlength="50" />
		</div>

		<div style="float: left; margin-top: 25px; font-size: 13px;">
			<i><b>Importante:</b> funcionários CA e representantes do Governo, abrangidos por pessoal da Administração direta e indireta, não são elegíveis ao sorteio por força legal.
			Caso o sorteante constate que o sorteado é de empresa pública, ele vai desprezar o formulário e realizar um novo sorteio.</i>
		</div>

	</div>
	
	<div style="float: right; border: 0px solid; padding: 10px; text-align: right; margin: 15px;">
		<button type="button" class="btnRetrieve" onclick="filterData();">Consultar</button>
	</div>

</form:form>