<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<style>

	label.error {
		width: 150px;
		margin-bottom: 5px;
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

<script type="text/javascript">
	$(function() {
		var idReg = $("#idUsuaCdUsuario")[0].value; 
		showTitle(idReg == "" ?  "":"Senhas");
		
		 $("#divNome").html($("#usuaDsNome").val());
		 $("#divLogin").html($("#usuaDsLogin").val());
		
		centerScreen(350, 320);
	});
	
</script>

<form:form action="../Usuario/savepwd" modelAttribute="usuarioTO" id="usuarioForm" name="usuarioForm">
	<form:hidden path="entity.idUsuaCdUsuario" id="idUsuaCdUsuario"/>
	<form:hidden path="entity.usuaDsNome" id="usuaDsNome" />
	<form:hidden path="entity.usuaDsLogin" id="usuaDsLogin" />

	<div style="float: left; border: 0px solid; padding: 10px;">
		<div class="cssTableLabel"><form:label path="entity.usuaDsNome" for="usuaDsNome">Nome:</form:label></div>
		<div class="cssTableField" id="divNome"></div>
		
		<div class="cssTableLabel"><form:label path="entity.usuaDsLogin" for="usuaDsLogin">Login:</form:label></div>
		<div class="cssTableField" id="divLogin"></div>
		<div class="cssTableLabel">&nbsp;</div>
		
		<div class="cssTableLabel"><form:label path="entity.usuaDsPwd" for="usuaDsPwd">Senha:</form:label></div>
		<div class="cssTableField">
			<form:password path="entity.usuaDsPwd" id="usuaDsPwd" cssClass="required" class="txtPWD" maxlength="10" />
		</div>
		<div class="cssTableLabel"><form:label path="entity.usuaDsPwd" for="usuaDsPwd">Confirmar:</form:label></div>
		<div class="cssTableField">
			<input type="password" name="newPwd" id="newPwd" class="checkpwd" maxlength="10" />
		</div>
	</div>
	
	<div style="float: right; border: 0px solid; padding: 10px; text-align: right; margin: 15px;">
	  <button type="submit" class="btnSave">Salvar</button>
	</div>

</form:form>