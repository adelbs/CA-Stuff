<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<script src="../../js/baseList.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		showTitle("Tickets", "Relação com os Tickets cadastrados.");
		
		var config = new TableConfig();
		config.td(0, "20%");
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

<form:form action="../Tickets" modelAttribute="ticketTO" id="ticketForm" name="ticketForm">
	<form:hidden path="entity.idTickCdTicket" id="idTickCdTicket" class="txtID" />

	<div class="divFiltros">	
		<div class="cssTableLabel">Evento:</div>
		<div class="cssTableField">
			<form:select path="idEvento"  cssClass="required" id="cmbEvento" >
				<form:option value="">--- Escolha uma opção ---</form:option>
				<form:options items="${ticketTO.listEventos}" itemLabel="evenDsTitulo" itemValue="idEvenCdEvento" />
			</form:select>

		</div>

		<div class="cssTableLabel">Descrição:</div>
		<div class="cssTableField"><form:input path="descricao" maxlength="255"/></div>

		<div style="float: right;">
			<button type="button" onclick="limparFiltros();">Limpar</button>
			<button class="btnRetrieve" type="button" onclick="retrieve();">Filtrar</button>
		</div>
	</div>

	<div id="resultTable" style="width: 100%; margin-bottom: 70px; float: left;"></div>
	<div style="text-align: right;">
		<button id="btnNovo" type="button" onclick="newAction();">Novo Ticket</button>
	</div>
</form:form>