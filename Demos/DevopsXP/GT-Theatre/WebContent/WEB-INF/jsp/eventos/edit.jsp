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
		var idReg = $("#idEvenCdEvento")[0].value;
		showTitle("Evento", (idReg == "" ? "Novo evento" : "Editar evento"));
		
		centerScreen(400, 570);
	});
		
	function beforeSave(){
		
	}
	
	function afterSave(data) {
		openUrl("../Eventos/list");
	}
</script>

<form:form action="../Eventos" modelAttribute="eventoTO" id="eventoForm" name="eventoForm">
	<form:hidden path="entity.idEvenCdEvento" id="idEvenCdEvento" class="txtID" />

	<div style="float: left; border: 0px solid; padding: 10px;">

		<div class="cssTableLabel"><form:label path="entity.evenCdTipo">Tipo:</form:label> </div>
		<div class="cssTableField">
			<form:select path="entity.evenCdTipo"  cssClass="required" id="cmbTpEvento" >
				<form:option value="">--- Escolha uma opção ---</form:option>
				<form:option value="1">Futebol</form:option>
				<form:option value="2">Show</form:option>
				<form:option value="3">Teatro</form:option>
				<form:option value="4">Cinema</form:option>
				<form:option value="5">Luta</form:option>
			</form:select>
		</div>

		<div class="cssTableLabel"><form:label path="entity.evenDsTitulo" for="evenDsTitulo">Titulo:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.evenDsTitulo" cssClass="required" id="evenDsTitulo" maxlength="50" />
		</div>
		
		<div class="cssTableLabel"><form:label path="entity.evenDsDescricao" for="evenDsDescricao">Descrição:</form:label></div>
		<div class="cssTableField">
			<form:textarea path="entity.evenDsDescricao" id="evenDsDescricao" rows="5" />
		</div>
		
		<div class="cssTableLabel"><form:label path="entity.evenDhEvento" for="evenDhEvento">Data:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.evenDhEvento" cssClass="required" id="evenDhEvento" maxlength="10" />
		</div>

		<div class="cssTableLabel"><form:label path="entity.evenDsLocal" for="evenDsLocal">Local:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.evenDsLocal" cssClass="required" id="evenDsLocal" maxlength="50" />
		</div>
		
	</div>
	
	<div style="float: right; border: 0px solid; padding: 10px; text-align: right; margin: 15px;">
		<button type="button" onclick="cancelAction();" class="btnCancel">Cancelar</button>
		<button type="button" onclick="removeAction();" class="btnExcluir">Excluir</button>
		<button type="submit" class="btnSave">Salvar</button>
	</div>

</form:form>