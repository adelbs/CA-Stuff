<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<style>

	.cssTableField input[type="text"] {
		width: 200px;
	}
	
	.cssTableField input[type="password"] {
		width: 155px;
	}

	.cssTableLabel {
		width: 140px;
	}

	.loginLabel {
		font-size: 20px;
		font-weight: bold;
		color: #1F4E79;
		margin-bottom: 20px;
	}

	.mainLogin {
		display: table;
		margin: 0 auto;
		border: #CDCDCD 2px solid; 
		width: 400px; 
		height: 200px; 
		padding: 10px;
	}

</style>

<script type="text/javascript">
	$(function() {
		
	});
	
	function beforeSave(){
		setWaitMessage("Salvando...");
	}
	
	function afterSave(data) {
		openUrl("../Home/load");
	}
	
</script>

<form:form action="../LoginWeb/saveNew" modelAttribute="clienteTO" id="clienteForm" name="clienteForm">

	<div style="margin-top: 70px;">&nbsp;</div>
	<div class="mainLogin">
		<div class="loginLabel">Cadastro</div>
		<div class="cssTableLabel">Nome: </div>
		<div class="cssTableField"><form:input path="entity.clieDsNome" id="clieDsNome" cssClass="required" title="Informe o Nome" /></div>
		<div class="cssTableLabel">Telefone: </div>
		<div class="cssTableField"><form:input path="entity.clieDsTelefone" id="clieDsTelefone"/></div>
		<div class="cssTableLabel">E-Mail: </div>
		<div class="cssTableField"><form:input path="entity.clieDsEmail" id="clieDsEmail"/></div>
		<div class="cssTableLabel">Cartão de Crédito: </div>
		<div class="cssTableField"><form:input path="entity.clieDsNumcartao" id="clieDsNumcartao"/></div>
		<div class="cssTableLabel">Bandeira Cartão: </div>
		<div class="cssTableField">
			<form:select path="entity.clieTpCartao" id="clieTpCartao">
				<form:option value="1">VISA</form:option>
				<form:option value="2">MASTER</form:option>
				<form:option value="3">AMEX</form:option>
				<form:option value="4">ELO</form:option>
			</form:select>
		</div>

		<div class="cssTableLabel">Login: </div>
		<div class="cssTableField"><form:input path="entity.clieDsLogin" id="clieDsLogin" maxlength="10" cssClass="required" title="Informe o Login" /></div>
		<div class="cssTableLabel">Password: </div>
		<div class="cssTableField"><form:password path="entity.clieDsPwd" id="clieDsPwd" maxlength="10" cssClass="required" title="Informe a Senha" />
		<button type="submit" class="btnLogin">OK</button></div>
	</div>

</form:form>