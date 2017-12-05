<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<script src="../../js/baseList.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		showTitle("Usuários", "Relação com os Usuários cadastrados.");
		
		var config = new TableConfig();
		config.td(0, "20%");
		config.td(1, "30%");
		config.td(2, "30%");
		config.td(3, "20%", function(value){
			return (value == "s" ? "Inativo" : "Ativo");
		});

		addTableConfig("#resultTable", config);
		
		retrieve();
	});
	
	function limparFiltros() {
		$("input, select").val("");
		retrieve();
	}
</script>

<form:form action="../Usuario" modelAttribute="usuarioTO" id="usuarioForm" name="usuarioForm">
	<form:hidden path="entity.idUsuaCdUsuario" id="idUsuaCdUsuario" class="txtID" />

	<div class="divFiltros">	
		<div class="cssTableLabel">Nome:</div>
		<div class="cssTableField"><form:input path="nomeUsua" maxlength="255"/></div>

		<div class="cssTableLabel">Login:</div>
		<div class="cssTableField"><form:input path="login" maxlength="255"/></div>

		<div style="float: right;">
			<button type="button" onclick="limparFiltros();">Limpar</button>
			<button class="btnRetrieve" type="button" onclick="retrieve();">Filtrar</button>
		</div>
	</div>

	<div id="resultTable" style="width: 100%; margin-bottom: 70px; float: left;"></div>
	<div style="text-align: right;">
		<button id="btnNovo" type="button" onclick="newAction();">Novo Usuário</button>
	</div>
</form:form>