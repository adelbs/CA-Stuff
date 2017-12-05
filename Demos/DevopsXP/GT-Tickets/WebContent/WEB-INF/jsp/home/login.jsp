<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<style>

	a {
		cursor: pointer;
	}

	.cssTableLabel {
		width: 120px;
	}

	.cssTableField input[type="text"] {
		width: 200px;
	}
	
	.cssTableField input[type="password"] {
		width: 155px;
	}

	.loginLabel {
		font-size: 20px;
		font-weight: bold;
		color: #1F4E79;
		margin-bottom: 20px;
	}
	
	.cadastroLabel {
		float: left;
		width: 100%;
		margin-top: 30px;
		font-size: 15px;
		text-align: center;
	}

	.mainLogin {
		display: table;
		margin: 0 auto;
		border: #CDCDCD 2px solid; 
		width: 350px; 
		height: 150px; 
		padding: 10px;
	}

</style>

<script type="text/javascript">
	$(function() {
		
		$("#clieDsPwd").keydown(function (e){
			if(e.keyCode == 13 || e.which == 13){
				$("#clienteForm").submit();
			}
		});
		
		$("#clieDsLogin").focus();
	});
	
	function beforeSave(){
		setWaitMessage("Conectando...");
	}
	
	function afterSave(data) {
		if ($("#clieDsLogin").val() == "test!")
			openUrl("../Home/load?test=true");
		else
			openUrl("../Home/load");
	}
	
</script>

<form:form action="../LoginWeb/login" modelAttribute="clienteTO" id="clienteForm" name="clienteForm">

	<div style="margin-top: 70px;">&nbsp;</div>
	<div class="mainLogin">
		<div class="loginLabel">Login</div>
		<div class="cssTableLabel">Login: </div>
		<div class="cssTableField"><form:input path="entity.clieDsLogin" id="clieDsLogin" maxlength="10" cssClass="required" title="Informe o Login" /></div>
		<div class="cssTableLabel">Password: </div>
		<div class="cssTableField"><form:password path="entity.clieDsPwd" id="clieDsPwd" maxlength="10" cssClass="required" title="Informe a Senha" />
			<button type="submit" class="btnLogin">Login</button></div>
		<div class="cadastroLabel">Ainda não tem cadastro? <br/><u><a onclick="openUrl('../LoginWeb/cadastro');">Inscreva-se agora!</a></u></div>
	</div>

</form:form>