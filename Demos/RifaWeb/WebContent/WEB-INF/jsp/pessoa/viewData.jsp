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
		showTitle("Cadastro", $("#message").val());
		
		if ($("#idPessCdPessoa").val() == "") {
			$("#divDados").hide();
		}
		else {
			$("#divBtnBack").hide();
		}
		
		$("#pessDsEmail").val("("+ $("#qty").val() +"x) "+ $("#pessDsEmail").val());
		centerScreen(200, 570);
	});
</script>

<form:form action="../Pessoa" modelAttribute="pessoaTO" id="pessoaForm" name="pessoaForm">
	<form:hidden path="entity.idPessCdPessoa" id="idPessCdPessoa" class="txtID" />
	<form:hidden path="message" id="message" />
	<form:hidden path="qty" id="qty" />

	<div id="divDados" style="float: left; border: 0px solid; padding: 10px;">

		<div class="cssTableLabel"><form:label path="entity.pessDsNome" for="pessDsNome">Nome:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.pessDsNome" cssClass="required" id="pessDsNome" readonly="true" />
		</div>
		
		<div class="cssTableLabel"><form:label path="entity.pessDsTelefone" for="pessDsTelefone">Telefone:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.pessDsTelefone" cssClass="required" id="pessDsTelefone" readonly="true" />
		</div>

		<div class="cssTableLabel"><form:label path="entity.pessDsEmail" for="pessDsEmail">Email: </form:label></div>
		<div class="cssTableField">
			<form:input path="entity.pessDsEmail" cssClass="required" id="pessDsEmail" readonly="true" />
		</div>
		
		<div class="cssTableLabel"><form:label path="entity.pessDsEmpresa" for="pessDsEmpresa">Empresa:</form:label></div>
		<div class="cssTableField">
			<form:input path="entity.pessDsEmpresa" cssClass="required" id="pessDsEmpresa" readonly="true" />
		</div>

	</div>
	
	<div id="divBtnBack" style="float: right; border: 0px solid; padding: 10px; text-align: right; margin: 15px;">
		<button type="button" onclick="openUrl('../Pessoa/filter');" class="btnCancel">Ok</button>
	</div>
	
</form:form>