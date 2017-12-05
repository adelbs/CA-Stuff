
<style type="text/css">

	#divMenuMobile {
		position: absolute;
		top: 5px;
		left: 5px;
		cursor: pointer;
		display: none;
		background-color: #FFFFFF;
	}

	#main-menu {
		position:relative;
		width:auto;
	}

	.sm-mint {
		border: #CDCDCD 1px solid;
	}
	
	.sm-mint a {
		-moz-border-radius: 4px 4px 4px 4px;
		-webkit-border-radius: 4px 4px 4px 4px;
		border-radius: 4px 4px 4px 4px;
	}
	
</style>

<script type="text/javascript">
	
	var showingMenu = false;
	$(function() {
		
		$('#main-menu').smartmenus({
			subMenusSubOffsetX: 1,
			subMenusSubOffsetY: -8,
			showOnClick: true
		});

		$("#divMenuMobile").click(function(event){
			event.stopPropagation();
			showMobileMenu(true);
		});
		
		if (window.location.href.indexOf("localhost") <= 0) {
			$("#menuAdm").hide();
		}
		
	});
	
	function inIframe() {
	    try {
	        return window.self !== window.top;
	    } catch (e) {
	        return true;
	    }
	}
	
	function showMobileMenu(value) {
		if (window.innerWidth <= 640 && !value) {
			showingMenu = false;
			$("#main-menu").hide();
		}
		else if (value) {
			if(showingMenu){
				showingMenu = false;
				$("#main-menu").hide();
			}
			else{
				showingMenu = true;
				$("#main-menu").show();
			}
		}
	}
</script>

<div id="divMenuMobile"><img class="notificationSignal" style="vertical-align: middle;" src="../../img/menu.png" /></div>

<ul id="main-menu" class="sm sm-mint" style="display: none;">
	<li id="menuMensagensMobile" style="display: none;"></li>
	<li onclick="openUrl('../Pessoa/newPessoa');"><a href="#">Home</a></li>
	<li onclick="openUrl('../Pessoa/filter');"><a href="#">Meus Dados</a></li>
	<li id="menuAdm"><a href="#">Administração</a>
		<ul>
			<li onclick="openUrl('../Pessoa/list');"><a href="#">Pessoas Cadastradas</a></li>
			<li onclick="openUrl('../Sorteio/load');"><a href="#">Realizar Sorteio</a></li>
		</ul>
	</li>
</ul>
