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
	
	#fakebar {
		border: #BBBBBB 1px solid; color: #000099; 
		width: 580px; height: 45px; text-align: center; padding-top: 15px;
		cursor: pointer;
	}

</style>

<script src="../../js/baseList.js" type="text/javascript"></script>
<script type="text/javascript">
	var progressbar;

	$(function() {
		var idReg = $("#idPessCdPessoa")[0].value;
		showTitle("Sorteio", "");
		
		progressbar = $( "#progressbar" ).progressbar({
		      value: 0
		    });
	
		progressbar.hide();
		centerScreen(300, 600);
	});
	
	function sorteioClick() {
		if (!sorteado) {
			progress();
		}
		else {
			if (!finalizado) {
				
				var pessoa1;
				var pessoa2;
				
				callAjax("../Sorteio/retrieve", formSerialize($("#pessoaForm")), function(data){
					pessoa1 = data.pessoa01;
					pessoa2 = data.pessoa02;
					
					var htmlWinner = "Parabéns!<br/>"+
									"<li><font style='color: #006633;'><b>"+ pessoa1.pessDsNome +"</b></font> ("+ pessoa1.pessDsEmpresa +" - "+ pessoa1.pessDsEmail +")</li> "+
									"<li><font style='color: #006633;'><b>"+ pessoa2.pessDsNome +"</b></font> ("+ pessoa2.pessDsEmpresa +" - "+ pessoa2.pessDsEmail +")</li> <br/>"+
									"<font style='color: #006633;'>Vocês são os vencedores!!!</font>";
					
					$("#fakebar").css("text-align", "left");
					$("#fakebar").html(htmlWinner);
					$("#fakebar").css("border", "0px");
					
				}, true);
				
				finalizado = true;
			}
		}
	}
	
	var sorteado = false;
	var finalizado = false;
	function progress() {
		$("#fakebar").hide();
		$("#divLabel").html("Aguarde, embaralhando os dados...");
		progressbar.show();
		var val = progressbar.progressbar( "value" ) || 0;
		
		progressbar.progressbar( "value", val + Math.floor( Math.random() * 2 ) );
		
		if ( val >= 20 && val < 40 ) {
			$("#divLabel").html("Embaralhando mais um pouco...");
		}
		else if ( val >= 40 && val < 60 ) {
			$("#divLabel").html("Re-fazendo os cálculos...");
		}
		else if ( val >= 60 && val < 80 ) {
			$("#divLabel").html("Tirando a prova real...");
		}
		else if ( val >= 80 ) {
			$("#divLabel").html("Só mais um pouco... ");
		}
		
		if ( val <= 99 ) {
		  progressTimer = setTimeout( progress, 50 );
		}
		else {
			$("#fakebar").show();
			$("#fakebar").html("REVELAR GANHADOR");
			$("#divLabel").html("Sorteio realizado!");
			progressbar.hide();
			sorteado = true;
		}
    }
	
</script>

<form:form action="../Sorteio" modelAttribute="pessoaTO" id="pessoaForm" name="pessoaForm">
	<form:hidden path="entity.idPessCdPessoa" id="idPessCdPessoa" class="txtID" />

	<div id="divLabel" style="width: 100%; text-align: center; margin-bottom: 20px;">
		<font style="color: #990000;">2147</font> PESSOAS CADASTRADAS! <br/>
		Inscrições Encerradas!
	</div>

	<div id="fakebar" onclick="sorteioClick();">SORTEAR!</div>
	<div id="progressbar" style="width: 580px; height: 60px; text-align: center;"></div>
	
</form:form>