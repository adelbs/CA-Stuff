<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<style>

	#usuaDsNome, #usuaDsEmail {
		width: 200px;
	}
	
	#usuaDsTelefone, #usuaDsLogin, #usuaDsPwd {
		width: 100px;
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
		var idReg = $("#idUsuaCdUsuario")[0].value;
		showTitle("Usuários", (idReg == "" ? "Novo usuário" : "Editar Usuário"));
		
		centerScreen(400, 570);
	});
		
	function beforeSave(){
		
	}
	
	function afterSave(data) {
		openUrl("../Usuario/list");
	}
</script>

<form:form action="../Usuario" modelAttribute="usuarioTO" id="usuarioForm" name="usuarioForm">
	<form:hidden path="entity.idUsuaCdUsuario" id="idUsuaCdUsuario" class="txtID" />

	<div style="float: left; border: 0px solid; padding: 10px;">

		<div class="cssTableLabel"><form:label path="entity.usuaDsNome" for="usuaDsNome">Nome:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.usuaDsNome" cssClass="required" id="usuaDsNome" maxlength="50" />
		</div>
		
		<div class="cssTableLabel"><form:label path="entity.usuaDsLogin" for="usuaDsLogin">Login:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.usuaDsLogin" cssClass="required" id="usuaDsLogin" maxlength="10" />
		</div>
		
		<div class="cssTableLabel"><form:label path="entity.usuaDsPwd" for="usuaDsPwd">Senha:</form:label></div>
		<div class="cssTableField">
			<form:password path="entity.usuaDsPwd" cssClass="required" id="usuaDsPwd" maxlength="20" />
		</div>
	</div>
	
	<div style="float: right; border: 0px solid; padding: 10px; text-align: right; margin: 15px;">
		<button type="button" onclick="cancelAction();" class="btnCancel">Cancelar</button>
		<button type="button" onclick="removeAction();" class="btnExcluir">Excluir</button>
		<button type="submit" class="btnSave">Salvar</button>
	</div>

</form:form>