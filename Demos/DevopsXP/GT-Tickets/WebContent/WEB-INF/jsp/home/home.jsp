<%@ include file="/WEB-INF/jsp/common/include.jsp" %>

<style type="text/css">

	.background {
		float: left; 
		width: 100%; 
		background-image: url(../../img/backGroundShow2.jpg); 
		height: 600px;
	}

	.searchArea {
		float: left;
		margin-top: 200px;
		margin-left: 35%;
		border-radius: 8px;
		padding: 8px;
		background-color: #DDDDDD;
		width: 600px;
	}

	.searchField {
		float: left;
		background-color: #FFFFFF;
		height: 50px;
		width: 450px;
		border-radius: 8px;
		padding: 5px;

	}
	
	.searchField input, .searchField input:FOCUS {
		border: 0px;
		outline: 0;
		height: 90%;
		width: 400px;
		font-size: 22px;
	}

	.btnPesquisar {
		margin-left: 5px;
		float: left;
		background-color: #CC3300;
		border-radius: 8px;
		line-height: 58px;		
		height: 58px;
		width: 130px;
		font-family: Arial;
		color: #FFFFFF;
		text-align: center;
		vertical-align: middle;
		cursor: pointer;
	}

	.btnPesquisar:HOVER {
		background-color: #AA0000;
	}
	
</style>

<script type="text/javascript">

	$(function() {
		$(".btnPesquisar").click(function() {
			openUrl("../Ticket/load?evenDsTitulo="+ $("#txtPesquisa").val());
		});
		
		$("#txtPesquisa").keydown(function (e){
			if(e.keyCode == 13 || e.which == 13){
				$(".btnPesquisar").click();
			}
		});
		
		$("#divContent").css("height", "");
	});

</script>

<div class="background">
	<div class="searchArea">
		<div class="searchField"><img src="../../img/lupa.png" style="vertical-align: middle;" />&nbsp;
			<input type="text" id="txtPesquisa" />
		</div>
		<div class="btnPesquisar">Pesquisar</div>
	</div>
</div>
