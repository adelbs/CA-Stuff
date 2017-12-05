
//Mensagem que aparece no popup "loading"
var strWaitMessage = "Salvando as informações...";

//Fun��es ao carregar a tela
$(function() {
	
	$("#dialogTemplate").dialog({
		autoOpen: false,
		draggable: false,
		resizable: false,
		width: 500,
		modal: true
	});
	
	//Todo formul�rio, por quest�o de seguran�a, deve ser ajax
	$("form").each(function(){
		if($(this).attr("target") == "" || $(this).attr("target") == undefined) {
			$(this).validate({
				submitHandler: function(form) {
					try{beforeSave();}catch(x){}
					waitMessage(strWaitMessage);
					
					//alert($(form).serialize());
					//alert(formSerialize($(form)));
					//return false
					
					callAjax(getFormAction($(form)), formSerialize($(form)), function(data){
						try{afterSave(data);}catch(x){}
					}, true);
				
					return false;
				}
			});
		}
		else {
			$(this).validate();
			$(this).attr("onsubmit", "beforeSave();");
		}
	});

	//Fun��o para verifica��o de senhas
	jQuery.validator.addMethod("checkpwd", function(value, element) {
		var pwds = $("input[type='password']");
	    return pwds[0].value == pwds[1].value;
	}, "*");
	
	initBtnsConfig();
});

function getFormAction(objForm) {
	var result = objForm.attr("action");
	if (result.indexOf("/", result.indexOf("/") + 1) < 0) result += "/save";
	return result;
}

/**
 * Exibe o DIV com a mensagem de loading.
 */
function setWaitMessage(message){
	strWaitMessage = message;
}

/**
 * Serializa o form para ser enviado via ajax.
 * Poderiamos usar o .serialize() do jquery, mas tivemos problemas com acentuacao.
 */
function formSerialize(objForm) {
	var fields = objForm.serializeArray();
	var result = "";
	jQuery.each( fields, function( i, field ) {
		result += "§" + field.name + "§§" + field.value;
	});
	
	result = replaceAll(result, "%", "@25");
	result = replaceAll(result, "@25", "%25");
	
	result = replaceAll(result, "$", "%24");
	result = replaceAll(result, "&", "%26");
	result = replaceAll(result, "?", "%3F");
	result = replaceAll(result, "+", "%2B");
	result = replaceAll(result, "=", "%3D");
	result = replaceAll(result, "#", "%23");
	result = replaceAll(result, "@", "%40");
	result = replaceAll(result, "[", "%5B");
	result = replaceAll(result, "]", "%5D");
	result = replaceAll(result, "{", "%7B");
	result = replaceAll(result, "}", "%7D");
	result = replaceAll(result, "<", "%3C");
	result = replaceAll(result, ">", "%3E");
	result = replaceAll(result, "\"", "%22");
	result = replaceAll(result, ",", "%2C");
	result = replaceAll(result, ";", "%3B");
	result = replaceAll(result, ":", "%3A");
	result = replaceAll(result, "/", "%2F");
	result = replaceAll(result, "\\", "%5C");
	result = replaceAll(result, "|", "%7C");
	result = replaceAll(result, "¨", "%C2%A8");
	
	result = replaceAll(result, " ", "+");
	result = replaceAll(result, "§§", "=");
	result = replaceAll(result, "§", "&");
	
	return result.substring(1);
}

/**
 * Padroniza os estilos dos bot�es
 */
function initBtnsConfig() {
	$("button").button();
	$(".btnSave").button({
		icons : {primary : "ui-icon-disk"}
	});
	$(".btnCancel").button({
		icons : {primary : "ui-icon-close"}
	});

	$(".btnExcluir").button({
		 icons: {primary: "ui-icon-trash"}
	});
	$(".btnConfig").button({
		 icons: {primary: "ui-icon-gear"}, text: false
	});
	$(".btnRemove").button({
		 icons: {primary: "ui-icon-trash"}, text: false
	});
	$(".btnAdd").button({
		 icons: {primary: "ui-icon-plus"}, text: false
	});
	$(".btnRetrieve").button({
		icons: {primary: "ui-icon-search"}
	});
}

/**
 * Exibe o titulo das telas.
 * @param title com o titulo principal
 * @param subTitle com a descri��o que aparece logo abaixo do titulo
 */
function showTitle(title, subTitle){
	$("#divTitle").show();
	$("#divTitle").text(title);
	$("#divSubTitle").show();
	$("#divSubTitle").text(subTitle);
}

/**
 * Fun��o para substituir tudo
 * @param str String contendo o texto original
 * @param strFind String que dever� ser localizada
 * @param strReplace String que dever� ser substituida
 * @returns String ap�s a substitui��o
 */
function replaceAll(str, strFind, strReplace){
	var result = str;
	while(result.indexOf(strFind) > -1)
		result = result.replace(strFind, strReplace);
	return result;
}

/**
 * Fun��o para chamar um m�todo AJAX do controller
 * @param sSource URL que dever� ser chamada
 * @param aoData Parametros
 * @param fnCallback Fun��o que ser� chamada com o retorno do m�todo AJAX
 * @param sync Boolean informando se a chamada � ASSINCRONA
 */
function callAjax(sSource, aoData, fnCallback, sync) {
	if(sync == null || sync == 'undefined'){
		sync = true;
	}
	$.ajax({
		"dataType": 'json',
		"type": "GET",
		"url": sSource,
		"data": aoData,
		"success": function(data) {
			if(data != null && data.messageError) {
				if(data.stackTrace)
					$("#txtStackTrace").val(replaceAll(data.stackTrace, "@@", "\n"));
				showDialog(TYPE_ERROR, "Erro", data.messageError);
			}
			else if(data != null && data.messageSuccess) {
				showDialog(TYPE_CONFIRM, "Pruvo", data.messageSuccess, function(){
					fnCallback(data);
				});
			}
			else {
				fnCallback(data);
			}
		},
		"error": function(jqXHR, errorThrown) {
			waitMessage(null);
			if(errorThrown == "parsererror"){
				openUrl("../Login/logoutSess");
			}
			else if(errorThrown != "error") {
				showDialog(TYPE_ERROR, "Erro", errorThrown);
			}
		},
		"async": sync 
	});
}

/**
 * Constantes para o dialogo principal. Ver fun��o showDialog
 */
var TYPE_CONFIRM = "../../img/execucao/sucess.gif";
var TYPE_INFORMATION = "../../img/iconInformation.png";
var TYPE_QUESTION = "../../img/iconQuestion.png";
var TYPE_ERROR = "../../img/iconError.png";

/**
 * Exibe o dialogo padr�o da aplica��o. Este dialogo pode ser uma quest�o com YES ou NO, ou apenas informativo.
 * @param type
 * 		TYPE_INFORMATION: Icone de informa��o
 * 		TYPE_QUESTION: Icone de quest�o
 * 		TYPE_ERROR: Icone de erro
 * @param title Titulo da janela
 * @param message Conte�do da mensagem
 * @param okAction Fun��o caso clicar no bot�o YES. Se n�o for passado este parametro, ent�o a janela ter� um �nico bot�o (OK)
 */
function showDialog(type, title, message, okAction){
	waitMessage(null);
	
	$(".btnDet").hide();
	if(okAction == null || okAction == 'undefined' || type == TYPE_CONFIRM){
		$("#dialogTemplate").find(".btnYes").hide();
		$("#dialogTemplate").find(".btnNo").hide();
		$("#dialogTemplate").find(".btnOk").show();
		
		if(type == TYPE_ERROR && $("#txtStackTrace").val() != "")
			$(".btnDet").show();
	}
	else{
		$("#dialogTemplate").find(".btnYes").show();
		$("#dialogTemplate").find(".btnNo").show();
		$("#dialogTemplate").find(".btnOk").hide();
	}
	
	$("#divStackTrace").hide();
	$("#dialogTemplate").dialog("open")
			.dialog("option", "height", 130)
			.dialog("option", "width", 500)
			.dialog("option", "title", title);
	
	$("#dialogTemplate").unbind("dialogclose");
	$("#dialogTemplate").bind("dialogclose", function(event) {
		$("#txtStackTrace").val("");
		if(type == TYPE_CONFIRM) {
			$("#dialogTemplate").find(".btnYes").click();
		}
	 });
	
	$("#dialogTemplate").find("img")[0].src = type;
	$("#dialogTemplate").find("div:nth-child(2)").text(message);
	$("#dialogTemplate").find(".btnYes").unbind("click");
	$("#dialogTemplate").find(".btnYes").click(function(){
		closeDialog();
		try{okAction();}
		catch(x){}
	});
}

/**
 * Exibe o stacktrace do dialogo de erro.
 */
function showStackTrace(){
	$("#dialogTemplate").dialog("option", "height", 330);
	$("#dialogTemplate").dialog("option", "width", "75%");
	$("#divStackTrace").show();
}

/**
 * Fecha o dialogo padr�o da aplica��o, aberto pela fun��o showDialog
 */
function closeDialog(){
	$("#dialogTemplate").dialog("close");
}

/**
 * Centraliza o conte�do principal da janela.
 * @param height Altura do div contendo o conteudo
 * @param width Largura do div contendo o conteudo
 */
function centerScreen(height, width){
	$("#divIcon").show();
	$("#divSubContent")[0].style.marginTop = "20px";
	$("#divSubContent")[0].style.marginBottom = "20px";
	$("#divSubContent")[0].style.width = width +"px";
	$("#divSubContent")[0].style.height = height +"px";
	$("#divSubContent")[0].style.border = "#CDCDCD 1px solid";
	$("#divSubContent")[0].style.marginLeft = ((window.innerWidth /2) - (width / 2)) +"px";
}

function maximizeContent(){
	$("#divContent")[0].style.height = ((window.innerHeight - 60) +"px");
}

/**
 * Estiva o div do conte�do principal aproveitando o m�ximo de espa�o dispon�vel na janela
 * @param widthSubtract Quando deve subtrair de largura (caso tenha algum objeto ao lado, por exemplo)
 */
function maximizeDivPrincipal(widthSubtract){
	$("#divContentPrincipal")[0].style.marginBottom = "20px";
	$("#divContentPrincipal")[0].style.width = (window.innerWidth - widthSubtract - 60) +"px";
}

function verificarAppType(){
	alert("REMOV!!!");
}

function verificarPermissao(){
	alert("REMOV!!!");
}

function numericMask(fieldFinder){
	$(fieldFinder).keydown(function(event) {
		// Allow only backspace and delete
		if ( event.keyCode == 46 || event.keyCode == 8 ) {
			// let it happen, don't do anything
		}
		else {
			// Ensure that it is a number and stop the keypress
			if (event.keyCode < 48 || event.keyCode > 57 ) {
				event.preventDefault();	
			}	
		}
	});
}

function formatAjaxDate(date){
	var result = date.split("-");
	var dd;
	var mm;
	var yyyy;
	
	yyyy = result[0];
	mm = result[1];
	
	result = result[2].split(" ");
	dd = result[0];
	
	return dd +"/"+ mm +"/"+ yyyy;
}

function formatAjaxDateTime(date){
	var result = date.split("-");
	var dd;
	var mm;
	var yyyy;
	var hh;
	var mi;
	var ss;
	
	yyyy = result[0];
	mm = result[1];
	
	result = result[2].split(" ");
	dd = result[0];
	
	result = result[1].split(":");
	hh = result[0];
	mi = result[1];
	ss = result[2];
	ss = ss.split(".")[0];
	
	return dd +"/"+ mm +"/"+ yyyy +" "+ hh +":"+ mi +":"+ ss;
}

/**
 * Bloqueia a tela, exibe a mensagem de aguarde...
 * @param message
 */
function waitMessage(message){
	if(message != null){
		$.blockUI({ 
			message: "<div class=\"waitBlock\">"+ $("#divWait").html().replace("[MESSAGE]", message) +"</div>"
		});
	}
	else{
		$.unblockUI();
	}
}

/**
 * Exibe a mensagem de aguarde e carrega uma URL.
 * @param url
 */
function openUrl(url){
	//waitMessage("Carregando...");
	document.location = url;
}