<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<script src="../../js/baseList.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		showTitle("Eventos", "Relação com os Eventos cadastrados.");
		
		var config = new TableConfig();
		config.td(0, "20%", function(value) {
			var ret = "";
			if (value == 1)
				ret = "Futebol";
			else if (value == 2)
				ret = "Show";
			else if (value == 3)
				ret = "Teatro";
			else if (value == 4)
				ret = "Cinema";
			else if (value == 5)
				ret = "Luta";
			
			return ret;
		});
		config.td(1, "30%");
		config.td(2, "30%");
		config.td(3, "20%");

		addTableConfig("#resultTable", config);
		
		retrieve();
	});
	
	function limparFiltros() {
		$("input, select").val("");
		retrieve();
	}
</script>

<form:form action="../Eventos" modelAttribute="eventoTO" id="eventoForm" name="eventoForm">
	<form:hidden path="entity.idEvenCdEvento" id="idEvenCdEvento" class="txtID" />

	<div class="divFiltros">	
		<div class="cssTableLabel">Tipo:</div>
		<div class="cssTableField">
			<form:select path="tpEvento"  cssClass="required" id="cmbTpEvento" >
				<form:option value="">--- Escolha uma opção ---</form:option>
				<form:option value="1">Futebol</form:option>
				<form:option value="2">Show</form:option>
				<form:option value="3">Teatro</form:option>
				<form:option value="4">Cinema</form:option>
				<form:option value="5">Luta</form:option>
			</form:select>
		</div>

		<div class="cssTableLabel" style="clear: left;">Titulo:</div>
		<div class="cssTableField"><form:input path="titulo" maxlength="255"/></div>

		<div class="cssTableLabel">Local:</div>
		<div class="cssTableField"><form:input path="local" maxlength="255"/></div>

		<div style="float: right;">
			<button type="button" onclick="limparFiltros();">Limpar</button>
			<button class="btnRetrieve" type="button" onclick="retrieve();">Filtrar</button>
		</div>
	</div>

	<div id="resultTable" style="width: 100%; margin-bottom: 70px; float: left;"></div>
	<div style="text-align: right;">
		<button id="btnNovo" type="button" onclick="newAction();">Novo Evento</button>
	</div>
</form:form>