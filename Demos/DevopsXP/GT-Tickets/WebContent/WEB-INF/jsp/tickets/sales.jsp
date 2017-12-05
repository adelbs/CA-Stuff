<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<style type="text/css">

	.main {
		display: table;
		margin: 0 auto;
		border: #CDCDCD 0px solid;
		width: 850px; 
		height: 150px; 
		padding-top: 50px;
	}

	.titleLine {
		float: left;
		width: 100%;
		border-top: #999999 1px solid;
		border-bottom: #999999 1px solid;
	}

	.titleField {
		float: left;
		font-family: Arial;
		font-size: 16px;
		padding: 10px;
		font-weight: bold;
		font-style: italic;
		color: #1F4E79;
	}

	.contentLine {
		float: left;
		width: 100%;
		border-bottom: #999999 1px solid;
	}

	.contentField {
		float: left;
		font-family: Arial;
		font-size: 14px;
		padding: 10px;
		color: #1F4E79;
	}
	
</style>

<script type="text/javascript">

	$(function() {
		if ($("#idCliente").val() == "") {
			showDialog(TYPE_CONFIRM, "Ticket", "Sua sessão expirou! Favor logar novamente!", function() {
				openUrl('../LoginWeb/logout');
			});
		}
		else {
			var test = ($("#idCliente").val() == "-1" ? "?test=true" : "");
			callAjax("../Ticket/retrieveSales" + test, "", function(data){
				if (data.result != undefined) {
					for (i = 0; i < data.result.length; i++) {
						var newLine = $("<div class='contentLine'></div>");
						var col = new Array();
						
						col[0] = $("<div class='contentField' style='width: 300px;'>"+ data.result[i].compDsEvento +"</div>");
						col[1] = $("<div class='contentField' style='width:  90px;'>"+ data.result[i].compDhEvento +"</div>");
						col[2] = $("<div class='contentField' style='width: 110px;'>"+ data.result[i].compDhCompra +"</div>");
						col[3] = $("<div class='contentField' style='width: 120px;'>"+ data.result[i].compNrValor +"</div>");
						col[4] = $("<div class='contentField' style='width: 120px;'>Autorizado</div>");
						
						newLine.append(col[0]);
						newLine.append(col[1]);
						newLine.append(col[2]);
						newLine.append(col[3]);
						newLine.append(col[4]);
						
						$(".main").append(newLine);
						
						$(".empty").remove();
					}
				}
			});
		}
	});
	
</script>

<div class="main">
	<div class="titleLine">
		<div class="titleField" style="width: 300px;">Evento</div>
		<div class="titleField" style="width: 90px;">Data</div>
		<div class="titleField" style="width: 110px;">Data Compra</div>
		<div class="titleField" style="width: 120px;">Valor</div>
		<div class="titleField" style="width: 120px;">Status</div>
	</div>
	<div class="contentLine">
		<div class="contentField empty" style="width: 100%;">Nenhuma Compra Efetuada</div>
	</div>
</div>