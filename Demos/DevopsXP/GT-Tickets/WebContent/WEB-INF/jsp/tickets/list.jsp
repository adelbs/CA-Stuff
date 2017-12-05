<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<style type="text/css">

	#divContent {
		background-color: #F6F6F6;
	}

	.cssTableField input[type="text"] {
		width: 200px;
	}
	
	.cssTableLabel {
		width: 140px;
	}

	div {
		font-family: Arial;
		font-size: 16px;
	}

	select {
		width: 160px;
	}

	.ticket {
		float: left;
		margin: 10px;
		padding: 10px;
		width: 170px;
		height: 280px;
		
		background: url(../../img/ticket_bg.png) center top no-repeat;
	}

	.tkTitulo {
		text-align: center;
		font-size: 20px;
		font-weight: bold;
		color: #1F4E79;
	}
	
	.tkDatalocal {
		text-align: center;
	}
	
	.tkDescricao {
		margin-top: 10px;
		height: 100px;
	}
	
	.tkOpcoes {
		margin-top: 32px;
		text-align: center;
	}
	
</style>

<script type="text/javascript">
	$(function() {
		
		if ($("#idCliente").val() == "")
			$(".btnComprar, .btnCompra1Click").hide();
		
		if ($("#demoStep").val() == "0")
			$(".btnCompra1Click").hide();
		
		$("#dialogEndereco, #dialogPagamento").dialog({
			autoOpen: false,
			draggable: false,
			resizable: false,
			title: "Compra de Ingresso",
			width: 390,
			height: 210,
			modal: true
		});
		
		var test = ($("#idCliente").val() == "-1" ? "?test=true" : "");
		callAjax("../Ticket/retrieve"+ test, formSerialize($("form")), function(data){
			if (data.result != undefined) {
				for (i = 0; i < data.result.length; i++) {
					var divTK = $("<div class='ticket'></div>");
					var newHtml = $(".ticketEx").html();
					
					newHtml = newHtml.replace("[TITULO]", data.result[i].evenDsTitulo);
					newHtml = newHtml.replace("[LOCAL]", data.result[i].evenDsLocal);
					newHtml = newHtml.replace("[DATA]", data.result[i].evenDhEvento);
					newHtml = newHtml.replace("[DESCRICAO]", data.result[i].evenDsDescricao);
					newHtml = newHtml.replace("##", data.result[i].idEvenCdEvento);
					newHtml = newHtml.replace("#!#", data.result[i].idEvenCdEvento);
					newHtml = newHtml.replace("#!#", data.result[i].idEvenCdEvento);
					
					divTK.html(newHtml);
					
					if (data.result[i].evenDsTitulo.length > 16) {
						divTK.find(".tkOpcoes").css("margin-top", "10px");
					}
					
					$("form").append(divTK);
					
					var newOption;
					var txtOption;
					for (j = 0; j < data.result[i].tickets.length; j++) {
						txtOption = data.result[i].tickets[j].tickDsDescricao;
						if (data.result[i].tickets[j].tickNrDisponivel > 0)
							txtOption = txtOption +" (R$ "+ data.result[i].tickets[j].tickNrValor +")";
						else
							txtOption = txtOption +" (ESGOTADO)";
						
						newOption = $("<option value='"+ data.result[i].tickets[j].idTickCdTicket +"' "+
								"valor='"+ data.result[i].tickets[j].tickNrValor +"' "+
								"qtd='"+ data.result[i].tickets[j].tickNrDisponivel +"' "+
								"dsEvento='"+ data.result[i].evenDsTitulo +"' "+
								"dtEvento='"+ data.result[i].evenDhEvento +"' >"+ txtOption +"</option>");
						$("#cmbOpcao"+ data.result[i].idEvenCdEvento).append(newOption);
					}
				}
			}
		});
		
		retrieve();
	});
	
	function comprar(id, oneClick) {
		
		$("#idTicketCompra").val(id);
		
		if ($("#cmbOpcao"+ id)[0].options[$("#cmbOpcao"+ id)[0].selectedIndex].getAttribute("qtd") == "0") {
			showDialog(TYPE_INFORMATION, "Ticket", "Este ingresso está esgotado, tente outra opção.");
		}
		else {
			if (oneClick) {
				compraFase1($("#clieTpCartao").val());
			}
			else {
				showDialog(TYPE_QUESTION, "Ticket", "Confirma a compra desse ingresso?", function () {
					$("#dialogPagamento").dialog("open");
				});
			}
		}
	}
	
	function compraFase1(tpCartao) {
		waitMessage("Aguardando autorização do cartão de crédito");
		
		//Se for a primeira etapa da demo, tem que dar erro no cartao ELO
		if ($("#demoStep").val() == "1" && Number(tpCartao) > 3) {
			setTimeout(function() {cartaoInvalido();}, 2000);
		}
		else {
			setTimeout(function() {compraFase2();}, 2000);
		}
	}

	function cartaoInvalido() {
		showDialog(TYPE_ERROR, "Ticket", "ERRO: SISTEMA DE COMPRAS INDISPONIVEL! TENTE MAIS TARDE!");
	}
	
	function compraFase2() {
		waitMessage("Estabelecendo conexão com a casa de shows");
		setTimeout(function() {compraFase3();}, 2000);
	}
	
	function compraFase3() {
		var id = $("#idTicketCompra").val();
		callAjax("../Ticket/buy", "idTickCdTicket="+ $("#cmbOpcao"+ id).val() +
				"&tickNrValor="+ $("#cmbOpcao"+ id)[0].options[$("#cmbOpcao"+ id)[0].selectedIndex].getAttribute("valor") +
				"&tickDsDescricao="+ $("#cmbOpcao"+ id)[0].options[$("#cmbOpcao"+ id)[0].selectedIndex].getAttribute("dsEvento"), 
				function(data){
			
			if (data.result == "OK") {
				showDialog(TYPE_CONFIRM, "Ticket", "Parabéns, sua compra foi autorizada!", function() {
					openUrl("../Ticket/sales");
				});
			}
			else if (data.result == "MAX_TICKETS") {
				showDialog(TYPE_ERROR, "Ticket", "Você atingiu a quantidade máxima permitida para compras on-line. Entrar em contato por telefone.");
			}
			
		});
	}
	
</script>

<form:form action="../Ticket" modelAttribute="eventoTO" id="eventoForm" name="eventoForm">
	<form:hidden path="evenCdTipo" />
	<form:hidden path="evenDsTitulo" />
	
	<input type="hidden" id="idTicketCompra" />

	<div id="dialogPagamento" style="display: none;">
		<div>Informe a forma de pagamento: <br/><br/> </div>
		
		<div class="cssTableLabel">Cartão de Crédito: </div>
		<div class="cssTableField"><input type="text" /></div>
		<div class="cssTableLabel">Bandeira Cartão: </div>
		<div class="cssTableField">
			<select>
				<option value="1">VISA</option>
				<option value="2">MASTER</option>
				<option value="3">AMEX</option>
				<option value="4">ELO</option>
			</select>
		</div>
		
		<div style="float: left; width: 100%; margin-top: 15px; text-align: right;">
			<button type="button" onclick="$('#dialogPagamento').dialog('close');" class="btnCancelar">Cancelar</button>
			<button type="button" onclick="$('#dialogPagamento').dialog('close');$('#dialogEndereco').dialog('open');" class="btnConfirmar">Proximo</button>
		</div>
	</div>
	
	<div id="dialogEndereco" style="display: none;">
		<div>Informe o endereco de entrega: <br/><br/> </div>
		
		<div class="cssTableLabel">Endereco: </div>
		<div class="cssTableField"><input type="text" /></div>
		<div class="cssTableLabel">CEP: </div>
		<div class="cssTableField"><input type="text" /></div>
		<div class="cssTableLabel">Complemento: </div>
		<div class="cssTableField"><input type="text" /></div>
		
		<div style="float: left; width: 100%; margin-top: 15px; text-align: right;">
			<button type="button" onclick="$('#dialogEndereco').dialog('close');" class="btnCancelar">Cancelar</button>
			<button type="button" onclick="compraFase1(-1);" class="btnConfirmar">Proximo</button>
		</div>
	</div>

	
	<div class="ticketEx" style="display: none;">
		<div class="tkTitulo">[TITULO]</div>
		<div class="tkDatalocal">[LOCAL]<br/>([DATA])</div>
		<div class="tkDescricao">[DESCRICAO]</div>
		<div class="tkOpcoes">
			<select id="cmbOpcao##"></select>
			<button type="button" onclick="comprar('#!#', false);" style="margin-top: 5px;" class="btnComprar">Comprar</button>
			<button type="button" onclick="comprar('#!#', true);" style="margin-top: 5px;" class="btnCompra1Click">Compra-1-click</button>
		</div>
	</div>

</form:form>