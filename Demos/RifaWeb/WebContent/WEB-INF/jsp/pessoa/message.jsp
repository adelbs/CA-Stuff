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

showAllPopups = false;

	$(function() {
		showTitle("Cadastro", $("#message").val());
		centerScreen(200, 570);
	});
</script>

<form:form action="../Pessoa" modelAttribute="pessoaTO" id="pessoaForm" name="pessoaForm">
	<form:hidden path="message" id="message" />
	
	<div style="float: right; border: 0px solid; padding: 10px; text-align: right; margin: 15px;">
		<button type="button" onclick="openUrl('../Pessoa/newPessoa');" class="btnCancel">Ok</button>
	</div>
</form:form>