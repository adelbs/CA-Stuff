<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<script src="../../js/baseList.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		showTitle("Cadastros", "Relação com todas as pessoas cadastradas até agora.");
		
		var config = new TableConfig();
		config.td(0, "30%");
		config.td(1, "30%");
		config.td(2, "20%");

		addTableConfig("#resultTable", config);
		
		retrieve();
	});
	
	function limparFiltros() {
		$("input, select").val("");
		retrieve();
	}
</script>

<form:form action="../Pessoa" modelAttribute="pessoaTO" id="pessoaForm" name="pessoaForm">
	<form:hidden path="entity.idPessCdPessoa" id="idPessCdPessoa" class="txtID" />

	<div class="divFiltros">
		<div class="cssTableLabel">Nome:</div>
		<div class="cssTableField"><form:input path="pessDsNome" maxlength="255"/></div>
		
		<div class="cssTableLabel" style="clear: left;">Email:</div>
		<div class="cssTableField"><form:input path="pessDsEmail" maxlength="255"/></div>

		<div class="cssTableLabel">Empresa:</div>
		<div class="cssTableField"><form:input path="pessDsEmpresa" maxlength="255"/></div>

		<div style="float: right;">
			<button type="button" onclick="limparFiltros();">Limpar</button>
			<button class="btnRetrieve" type="button" onclick="retrieve();">Filtrar</button>
		</div>
	</div>

	<div id="resultTable" style="width: 100%; margin-bottom: 70px; float: left;"></div>
	<div style="text-align: right;">
		<button id="btnNovo" type="button" onclick="newAction();">Novo Cadastro</button>
	</div>
</form:form>