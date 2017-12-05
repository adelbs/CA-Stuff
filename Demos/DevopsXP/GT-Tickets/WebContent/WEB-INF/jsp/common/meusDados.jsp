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
</script>

<form:form action="../Home/load" modelAttribute="clienteTO" id="clienteForm" name="clienteForm">

	<div style="margin-top: 70px;">&nbsp;</div>
	<div class="mainLogin">
		<div class="loginLabel">Meus Dados</div>
		<div class="cssTableLabel">Nome: </div>
		<div class="cssTableField"><form:input path="entity.clieDsNome" readonly="true" /></div>
		<div class="cssTableLabel">Telefone: </div>
		<div class="cssTableField"><form:input path="entity.clieDsTelefone" readonly="true"/></div>
		<div class="cssTableLabel">E-Mail: </div>
		<div class="cssTableField"><form:input path="entity.clieDsEmail" readonly="true"/></div>
		<div class="cssTableLabel">Cartão de Crédito: </div>
		<div class="cssTableField"><form:input path="entity.clieDsNumcartao" readonly="true"/></div>
		<div class="cssTableLabel">Bandeira Cartão: </div>
		<div class="cssTableField">
			<form:select path="entity.clieTpCartao" id="clieTpCartao" disabled="true">
				<form:option value="1">VISA</form:option>
				<form:option value="2">MASTER</form:option>
				<form:option value="3">AMEX</form:option>
				<form:option value="4">ELO</form:option>
			</form:select>
		</div>
		<div class="cssTableLabel">Tipo Cliente: </div>
		<div class="cssTableField">
			<form:select path="entity.clieTpCliente" id="clieTpCliente" disabled="true">
				<form:option value="1">COMUM</form:option>
				<form:option value="2">VIP</form:option>
			</form:select>
		</div>

		<div class="cssTableLabel">Login: </div>
		<div class="cssTableField"><form:input path="entity.clieDsLogin" disabled="true" /></div>
	</div>

</form:form>