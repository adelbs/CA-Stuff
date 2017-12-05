package com.ca.sv.ext.vse.stateless.protocol.gci;

import java.util.List;

import com.ca.sv.ext.vse.stateless.protocol.gci.helper.GCIHelper;
import com.itko.lisa.vse.stateful.protocol.tcp.delimiters.TCPDelimiter;

public class GCIDelimiter implements TCPDelimiter {

	public static final String SEPARADOR = "%@$&!#";
	
	/*
	 * Cabecalho do registro (tratada pelas APIs do GCI)
	 * =================================================
	 * 
	 * 	char IdentInic[6] -- %@$&!#
	 * 	char TipoConx[1]  -- 1 Permanente, 2 Temporaria 
	 *  char CodMsg[1]    -- 2 Clock                 
	 *                    -- 3 Incl Serv             
	 *                    -- 4 Excl Serv             
	 *                    -- 5 Sevr Nao Disponivel   
	 *                    -- 6 Resposta do Servico   
	 *                    -- 7 Requisicao do cliente 
	 *  char TamReg[5]    -- Tamanho do registro     
	 *  char NSUMsg[6]    -- Numero sequencial da mensagem da aplicacao 
	 *  char SockOrig[10] -- 4 bytes socket de origem, 
	 *                    -- 6 bytes numero sequencial do GCI 
	 *  char VersOrig[4]  -- Versao da api de origem do GCI 
	 *  char ChrFinal[1]  -- 0 ou branco - caracter suprimido do final da mensagem 
	 *  char Platafo[1]   -- Plataforma da API de origem (ainda nao implementado 
	 *  char Filler[1]    -- sem uso 
	 *  */
	public static final int CR_TPO_CNX = 1;
	public static final int CR_COD_MSG = 1; 
	public static final int CR_TAM_REG = 5;
	public static final int CR_NSU_MSG = 6;
	public static final int CR_SOC_ORI = 10;
	public static final int CR_VER_ORI = 4;
	public static final int CR_CHR_FIM = 3;
	public static final int TAMANHO_CR = CR_TPO_CNX + CR_COD_MSG + CR_TAM_REG + CR_NSU_MSG + CR_SOC_ORI + CR_VER_ORI + CR_CHR_FIM;

	
	/*
	 * Cabecalho da mensagem (Tratada pelas aplicacoes)
	 * ================================================
	 * 
	 *  char Sistema[3]   -- Sistema aplicacao      
	 *  char Servico[8]   -- Servico GCI            
	 *  char Programa[8]  -- Programa aplicacao     
	 *  char Versao[4]    -- Versao aplicacao       
	 *  char TimeOut[3]   -- Timeout da transacao   
	 *  char TamMsg[5]    -- Tamanho da mensagem    
	 *  char CodErro[4]   -- 0000 ou codigo do erro 
	 *  char EndIP[15]    -- Endereco IP da origem, a API do GCI coloca 
	 *  char Cliente[8]   -- Codigo do cliente         (#)
	 *  char Matric[14]   -- Matricula do operador     (#)
	 *  char Senha[8]     -- Senha do operador, em geral criptografada        (#)
	 *  char Cont[1]      -- 1 se a transacao tem continuacao, 0 se nao tem   (#)
	 *  unsigned char Msg /* de 1 a 10.200 bytes)       
	 *  Observacoes:
	 *  1) (#) - campo nao obrigatorio
	 *  2) Se forem suprimidos brancos ou zeros no final da mensagem, o caracter esta em ChrFinal no cabecalho do registro e a quantidade eh (TamMsg + 117 - TamReg)
	 *  */
	public static final int CM_SISTEMA = 3;
	public static final int CM_SERVICO = 8;
	public static final int CM_PROGRAM = 8;
	public static final int CM_VERSAO = 4;
	public static final int CM_TIMEOUT = 3;
	public static final int CM_TAMMSG = 5;
	public static final int CM_CODERRO = 4;
	public static final int CM_ENDIP = 15;
	public static final int CM_CLIENT = 8;
	public static final int CM_MATRIC = 14;
	public static final int CM_SENHA = 8;
	public static final int CM_CONT = 1;
	public static final int TAMANHO_CM = CM_SISTEMA + CM_SERVICO + CM_PROGRAM + CM_VERSAO + CM_TIMEOUT + 
			CM_TAMMSG + CM_CODERRO + CM_ENDIP + CM_CLIENT + CM_MATRIC + CM_SENHA + CM_CONT;

	
	
	private int startOfNextRequest = 0;
	private int endOfRequest = -1;
	
	
	
	@Override
	public void configure(String arg0) {
	
	}

	@Override
	public int getEndOfRequest() {
		return endOfRequest;
	}

	@Override
	public int getStartOfNextRequest() {
		return startOfNextRequest;
	}

	@Override
	public boolean locateRequest(List<Byte> arg0) {
				
		byte[] ba = new byte[arg0.size()];
		for (int i = 0; i < arg0.size(); i++) {
			ba[i] = arg0.get(i);
		}
		
		String baHexString = GCIHelper.bytesToHexString(ba);
		String str = GCIHelper.hexToAscii(baHexString);
		String tamanhoReg = "";
		
		endOfRequest = -1;
		startOfNextRequest = -1;
		
		if (str.length() < (TAMANHO_CR + TAMANHO_CM)) {
			return false;
		}
		else {
			
			//Se tiver lixo entre as mensagens, descarta
			if (str.indexOf(SEPARADOR) > 0) {
				endOfRequest = str.indexOf(SEPARADOR);
				startOfNextRequest = endOfRequest + SEPARADOR.length();
				
				return true;
			}
			else {
				tamanhoReg = str.substring(SEPARADOR.length() + CR_TPO_CNX + CR_COD_MSG, 
						SEPARADOR.length() + CR_TPO_CNX + CR_COD_MSG + CR_TAM_REG);
				
				if (str.length() >= Integer.parseInt(tamanhoReg)) {
					endOfRequest = Integer.parseInt(tamanhoReg);
					startOfNextRequest = endOfRequest + SEPARADOR.length();
					
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public String validate() {
		return null;
	}
}
