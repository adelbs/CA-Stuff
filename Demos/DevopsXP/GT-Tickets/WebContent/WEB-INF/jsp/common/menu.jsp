
<style type="text/css">
	
	a {
		cursor: pointer;
	}
	
	.mainMenu {
		display: table;
		margin: 0 auto;
	}

	#divLogo {
		margin-top: 20px;
	}

	#divMenu {
		margin-left: 20px;
	}

	.menuItem {
		float: left;
		text-align: center;
		vertical-align: middle;
		line-height: 100px;
		border-top: #FFFFFF 3px solid;
		border-right: #CDCDCD 1px solid;
		padding-left: 20px;
		padding-right: 20px;
		height: 100px;
		font-size: 22px;
		font-family: Arial;
		cursor: pointer;
	}
	
	.menuItem:HOVER {
		border-top: #AA0000 3px solid;
		background-color: #EDEDED;
	}

	.userData {
		float: left;
		margin-left: 20px;
		margin-top: 30px;
	}
	
	#idd {
		font-size: 16px;
		font-family: Arial;
		font-weight: bold;
	}
	
	#iddOpcoes {
		margin-top: 5px;
		font-size: 14px;
		font-family: Arial;
		font-weight: normal;
	}
	
</style>

<script type="text/javascript">
	
	var showingMenu = false;
	$(function() {
		if ($("#idCliente").val() != "")
			$("#menuConta").show();
		else
			$("#menuLogin").show();
		
		$("#idd").html("Bem vindo, "+ $("#clieDsNome").val() +"!");
	});
	
	function openMenu(url) {
		openUrl(url);
	}
	
</script>

<div class="mainMenu">

	<div id="divMenuMobile" style="display: none; position: absolute; top: 0; left: 0;"><img src="../../img/menu-alt.png" width="70px" /></div>

	<div id="divLogo" style="float: left;"><img src="../../img/logoTickets.png" /></div>
	
	<div id="divMenu" style="float: left; display: block;">
		<div class="menuItem" onclick="openMenu('../Home/load');" style="border-left: #CDCDCD 1px solid;">Home</div>
		<div class="menuItem" onclick="openMenu('../Ticket/load?evenCdTipo=1');">Futebol</div>
		<div class="menuItem" onclick="openMenu('../Ticket/load?evenCdTipo=2');">Shows</div>
		<div class="menuItem" onclick="openMenu('../Ticket/load?evenCdTipo=3');">Teatro</div>
		<div class="menuItem" onclick="openMenu('../Ticket/load?evenCdTipo=4');">Cinema</div>
		<div class="menuItem" onclick="openMenu('../Ticket/load?evenCdTipo=5');">Lutas</div>
		
		<div id="menuLogin" class="menuItem" style="display: none;" onclick="openMenu('../LoginWeb/logout');">Entrar...</div>
		<div id="menuConta" class="userData" style="display: none;">
			<div id="idd"></div>
			<div id="iddOpcoes">
				<a onclick="openMenu('../LoginWeb/dadosCliente');">[Meus Dados]</a>
				<a onclick="openMenu('../Ticket/sales');">[Meus Tickets]</a>
				<a onclick="openMenu('../LoginWeb/logout');">[Sair]</a>
			</div>
		</div>
	</div>
</div>