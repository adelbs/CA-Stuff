<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<style>

	#cmbEvento, #tickDsDescricao, #tickNrValor, #tickNrDisponivel {
		width: 200px;
	}

	.cssTableLabel {
		width: 120px;
	}

</style>

<script src="../../js/baseList.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		var idReg = $("#idTickCdTicket")[0].value;
		showTitle("Ticket", (idReg == "" ? "Novo ticket" : "Editar ticket"));
		
		centerScreen(350, 420);
	});
		
	function beforeSave(){
		
	}
	
	function afterSave(data) {
		openUrl("../Tickets/list");
	}
</script>

<form:form action="../Tickets" modelAttribute="ticketTO" id="ticketForm" name="ticketForm">
	<form:hidden path="entity.idTickCdTicket" id="idTickCdTicket" class="txtID" />

	<div style="float: left; border: 0px solid; padding: 10px;">

		<div class="cssTableLabel"><form:label path="entity.fiCdEventoEVEN.idEvenCdEvento">Evento:</form:label> </div>
		<div class="cssTableField">
			<form:select path="entity.fiCdEventoEVEN.idEvenCdEvento"  cssClass="required" id="cmbEvento" >
				<form:option value="">--- Escolha uma opção ---</form:option>
				<form:options items="${ticketTO.listEventos}" itemLabel="evenDsTitulo" itemValue="idEvenCdEvento" />
			</form:select>
		</div>

		<div class="cssTableLabel"><form:label path="entity.tickDsDescricao" for="tickDsDescricao">Descrição:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.tickDsDescricao" cssClass="required" id="tickDsDescricao" maxlength="50" />
		</div>
		
		<div class="cssTableLabel"><form:label path="entity.tickNrValor" for="tickNrValor">Valor:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.tickNrValor" cssClass="required" id="tickNrValor" maxlength="10" />
		</div>
		
		<div class="cssTableLabel"><form:label path="entity.tickNrDisponivel" for="tickNrDisponivel">Qdt. Disponível:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.tickNrDisponivel" cssClass="required" id="tickNrDisponivel" maxlength="5" />
		</div>
	</div>
	
	<div style="float: right; border: 0px solid; padding: 10px; text-align: right; margin: 15px;">
		<button type="button" onclick="cancelAction();" class="btnCancel">Cancelar</button>
		<button type="button" onclick="removeAction();" class="btnExcluir">Excluir</button>
		<button type="submit" class="btnSave">Salvar</button>
	</div>

</form:form>