<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>  

<!DOCTYPE html>
<html>
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- meta http-equiv="Content-Type" content="text/html; charset=utf-8" / -->
		
		<meta http-equiv="Content-Style-Type" content="text/css">
	
		<title>TICKETS-GALAXY</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />

		<!-- JQuery -->
		<script src="../../js/jquery-2.0.3.min.js" type="text/javascript"></script >
		<link href="../../js/jquery-ui-1.10.3/themes/base/jquery-ui.css" rel="stylesheet" />
		<script src="../../js/jquery-ui-1.10.3/ui/jquery-ui.js"></script>

		<!-- DateTimePicker -->
		<link href="../../js/dateTimePicker/jquery.datetimepicker.css" rel="stylesheet" type="text/css" />
		<script src="../../js/dateTimePicker/jquery.datetimepicker.js"></script>
		
		<!-- Menu -->
		<link href='../../js/smartmenus-0.9.6/css/sm-core-css.css' rel='stylesheet' type='text/css' />
		<link href='../../js/smartmenus-0.9.6/css/sm-mint/sm-mint.css' rel='stylesheet' type='text/css' />
		<script src="../../js/smartmenus-0.9.6/jquery.smartmenus.js" type="text/javascript"></script>
		
		<!-- Paginação -->
		<link href='../../js/pagination/simplePagination.css' rel='stylesheet' type='text/css' />
		<script src="../../js/pagination/jquery.simplePagination.js" type="text/javascript"></script>
		
		<!-- Validation -->
		<script src="../../js/jquery-validation-1.11.1/jquery.validate.js" type="text/javascript"></script>
		
		<!-- Loading -->
		<script src="../../js/jquery.blockUI.js"></script>
		
		<!-- Base -->
		<link href="../../css/base.css" rel="stylesheet" />
		<script src="../../js/base.js" type="text/javascript"></script>

		<style>
			.divStatusTitle, .divStatusValue {
				float: left; 
				margin-top: 2px; 
				margin-left: 5px; 
				font-family: verdana; 
				font-size: 9px;
			}
		
			.divStatusTitle {
				clear: left;
				font-weight: bold;
				width: 50px;
				text-align: right;
			}
			
			#divBottom {
				float: left;
				padding-top: 5px;
				height: 100px;
				width: 100%;
				border-top: 3px solid #AA0000;
				font-family: Arial;
				font-size: 14px;
				text-align: center;
			}
			
		</style>

		<script type="text/javascript">
			var messages = new Array();
			messages["system.dialog.cancelar.title"] = "Cancelar";
			messages["system.dialog.cancelar.message"] = "Tem certeza que deseja cancelar?";
		
			$(function() {
				if($("#msgError")[0].value != ""){
					showDialog(TYPE_ERROR, "Erro!", $("#msgError")[0].value);
				}

				if($("#msgSuccess")[0].value != ""){
					showDialog(TYPE_INFORMATION, "Mensagem", $("#msgSuccess")[0].value);
				}

			//	showDialog(TYPE_INFORMATION, "Titulo 123", "Tem certeza que deseja continuar?", function(){alert("");});
			
				resizeTemplate();
				$(window).resize(function () {resizeTemplate();});
			});
			
			//Movimentando o mennu e área de notificação para funcionar em qualquer dispositivo
			function resizeTemplate(){
				//Area de notificação
				if(window.innerWidth > 1038 && window.innerWidth <= 1177){
					$("#divUserVersion").hide();
					$("#divStatusMsg").show();
					$("#divNotificationSignal").css("margin-left", "40px");
				}
				else if(window.innerWidth > 752 && window.innerWidth <= 1038){
					$("#divUserVersion").hide();
					$("#divStatusMsg").hide();
					$("#divNotificationSignal").css("margin-left", "0px");
				}
				else if(window.innerWidth > 720 && window.innerWidth <= 752){
				}
				else if(window.innerWidth > 685 && window.innerWidth <= 720){
					$("#divUserVersion").hide();
					$("#divStatusMsg").hide();
					$("#divNotificationSignal").css("margin-left", "0px");
				}
				else if(window.innerWidth <= 685){
				}
				else{
					$("#divUserVersion").show();
					$("#divStatusMsg").show();
					$("#divNotificationSignal").css("margin-left", "40px");
				}
				
				//Menu
				$("#main-menu").show();
				//$("#divMenuMobile").hide();
				//$("#menuMensagensMobile").hide();
			}
			
		</script>
	</head>

	<body style="padding: 0px; margin: 0px;">
		<input type="hidden" value="${msgSuccess}" id="msgSuccess"/>
		<input type="hidden" value="${msgError}" id="msgError"/>

		<input type="hidden" value="${demoStep}" id="demoStep" />

		<input type="hidden" value="${FiCdClienteCLIE.id}" id="idCliente"/>
		<input type="hidden" value="${FiCdClienteCLIE.clieDsNome}" id="clieDsNome"/>
		<input type="hidden" value="${FiCdClienteCLIE.clieTpCartao}" id="clieTpCartao"/>

		<div id="divWait" style="display: none;">
			<div style="float: left; padding-top: 15px; margin-left: 20px;">
				<img src="../../img/execucao/running.GIF" width="18px"/>
			</div>
			<div style="float: left; height: 100%; margin-left: 25px;">
				<div style="float: left; margin-top: 7px;">
					Aguarde, por favor...
				</div>
				<div style="float: left; clear: left; font-size: 12px; font-style: italic;">
					[MESSAGE]
				</div>
			</div>
		</div>
	
		<div id="dialogTemplate" title="" style="display: none;">
			<div><img src=""/></div>
			<div>Dialogo parão 1232</div>
			<div style="text-align: right;">
				<button type="button" onclick="" class="btnYes">Sim</button>
				<button type="button" onclick="closeDialog();" class="btnNo">Não</button>
				<button type="button" onclick="closeDialog();" class="btnOk">OK</button>
				<button type="button" onclick="showStackTrace();" class="btnDet">Detalhes &gt;&gt;</button>
			</div>
			<div id="divStackTrace" style="margin-top: 20px; display: none;"><textarea style="width: 100%; font-size: 10px;" rows="10" readonly="readonly" id="txtStackTrace"></textarea></div>
		</div>
		
		<tiles:insertAttribute name="menu" />
		
		<div style="float: left; width: 100%; height: 3px; background-color: #AA0000;"></div>
		
		<div id="divContent" style="float: left; width: 100%; overflow: auto; font-family: verdana; font-size: 20px; height: 700px;">
			<tiles:insertAttribute name="body" />
		</div>

		<div id="divBottom">
			Esta é uma aplicacao ficticia para fins de demonstracao. Versao do build: ${buildNumber}
		</div>
	
	</body>

</html>