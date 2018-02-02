package com.ca.sv.ext.vse.stateless.protocol.gci;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.ca.sv.ext.vse.stateless.protocol.gci.helper.GCIHelper;
import com.ca.sv.ext.vse.stateless.protocol.gci.helper.LinkedProperties;
import com.ca.sv.ext.vse.stateless.protocol.gci.to.CBParameter;
import com.ca.sv.ext.vse.stateless.protocol.gci.to.CopyBook;
import com.itko.lisa.test.TestExec;
import com.itko.lisa.vse.stateful.model.Request;
import com.itko.lisa.vse.stateful.model.Response;
import com.itko.lisa.vse.stateful.model.TransientResponse;
import com.itko.lisa.vse.stateful.protocol.ParameterListDataProtocol;
import com.itko.util.Parameter;
import com.itko.util.ParameterList;

public class GCI extends ParameterListDataProtocol {
	
	private String COPYBOOK_DIR = "/opt/CA/DevTest/gci/copybooks";
	private String CONFIG_DIR = "/opt/CA/DevTest/gci/config";

	//private String COPYBOOK_DIR = "C:\\CA\\DevTest8\\Projects\\ProcergsGCI\\Data\\copybooks";
	//private String CONFIG_DIR = "C:\\CA\\DevTest8\\Projects\\ProcergsGCI\\Data\\config";
	
	@Override
	protected ParameterList createDefaultParameters() {
		ParameterList params = new ParameterList();
		return params;
	}

	@Override
	public void updateRequest(TestExec testExec, Request request) {
		updateRequest(request);
	}

	@Override
	public void updateRequest(Request request) {
		
		boolean isBinary = request.isBinary();
		byte[] payloadBody;
		String payload;
		
		if (isBinary) {
			payloadBody = request.getBodyAsByteArray();
			payload = GCIHelper.bytesToString(payloadBody);
		}
		else {
			payload = request.getBodyAsString();
		}
		
		try {
			ParameterList attributes = new ParameterList();
			CopyBook copyBook;
			String cmSistema = "";
			String cmServico = "";
			String cmProgram = "";
			
			int cursor = GCIDelimiter.SEPARADOR.length();
			
			//Cabecalho do registro
			if (payload.length() >= GCIDelimiter.TAMANHO_CR) {

				attributes.addParameter(new Parameter("CR_TPO_CNX", payload.substring(cursor, (cursor += GCIDelimiter.CR_TPO_CNX))));
				attributes.addParameter(new Parameter("CR_COD_MSG", payload.substring(cursor, (cursor += GCIDelimiter.CR_COD_MSG))));
				attributes.addParameter(new Parameter("CR_TAM_REG", payload.substring(cursor, (cursor += GCIDelimiter.CR_TAM_REG))));
				attributes.addParameter(new Parameter("CR_NSU_MSG", payload.substring(cursor, (cursor += GCIDelimiter.CR_NSU_MSG))));
				attributes.addParameter(new Parameter("CR_SOC_ORI", payload.substring(cursor, (cursor += GCIDelimiter.CR_SOC_ORI))));
				attributes.addParameter(new Parameter("CR_VER_ORI", payload.substring(cursor, (cursor += GCIDelimiter.CR_VER_ORI))));
				attributes.addParameter(new Parameter("CR_CHR_FIM", payload.substring(cursor, (cursor += GCIDelimiter.CR_CHR_FIM))));
				
			}
			
			//Cabecalho da mensagem
			if (payload.length() >= (GCIDelimiter.TAMANHO_CR + GCIDelimiter.TAMANHO_CM)) {
				
				cmSistema = payload.substring(cursor, (cursor += GCIDelimiter.CM_SISTEMA));
				cmServico = payload.substring(cursor, (cursor += GCIDelimiter.CM_SERVICO));
				cmProgram = payload.substring(cursor, (cursor += GCIDelimiter.CM_PROGRAM));
				
				attributes.addParameter(new Parameter("CM_SISTEMA", cmSistema));
				attributes.addParameter(new Parameter("CM_SERVICO", cmServico));
				attributes.addParameter(new Parameter("CM_PROGRAM", cmProgram));
				attributes.addParameter(new Parameter("CM_VERSAO", payload.substring(cursor, (cursor += GCIDelimiter.CM_VERSAO))));
				attributes.addParameter(new Parameter("CM_TIMEOUT", payload.substring(cursor, (cursor += GCIDelimiter.CM_TIMEOUT))));
				attributes.addParameter(new Parameter("CM_TAMMSG", payload.substring(cursor, (cursor += GCIDelimiter.CM_TAMMSG))));
				attributes.addParameter(new Parameter("CM_CODERRO", payload.substring(cursor, (cursor += GCIDelimiter.CM_CODERRO))));
				attributes.addParameter(new Parameter("CM_ENDIP", payload.substring(cursor, (cursor += GCIDelimiter.CM_ENDIP))));
				attributes.addParameter(new Parameter("CM_CLIENT", payload.substring(cursor, (cursor += GCIDelimiter.CM_CLIENT))));
				attributes.addParameter(new Parameter("CM_MATRIC", payload.substring(cursor, (cursor += GCIDelimiter.CM_MATRIC))));
				attributes.addParameter(new Parameter("CM_SENHA", payload.substring(cursor, (cursor += GCIDelimiter.CM_SENHA))));
				attributes.addParameter(new Parameter("CM_CONT", payload.substring(cursor, (cursor += GCIDelimiter.CM_CONT))));
				
			}
			
			//Obtendo o copybook da transacao
			copyBook = getCopybook(cmSistema + cmServico + cmProgram);
			if (copyBook != null) {
				for (CBParameter param : copyBook.getParameters()) {
					if ((cursor + param.getSize()) < payload.length()) {
						attributes.addParameter(new Parameter(param.getName(), payload.substring(cursor, (cursor += param.getSize()))));
					}
				}
			}
			
			//Bytes do final da mensagem
			if (cursor < payload.length())
				attributes.addParameter(new Parameter("LASTBYTES", payload.substring(cursor)));
			
			if (copyBook != null)
				request.setOperation(copyBook.getName());
			else
				request.setOperation("UNKNOWN-OPERATION");
			
			request.setArguments(attributes);
		} 
		catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public void updateResponse(Response response) {
		boolean isBinary = response.isBinary();
		byte[] payloadBody;
		String payload;
		try {
			if (isBinary) {
				payloadBody = response.getBodyAsByteArray();
				payload = GCIHelper.bytesToString(payloadBody);
			} 
			else {
				payload = response.getBodyAsString();
			}

			String newBody = "";
			CopyBook copyBook;
			String cmSistema = "";
			String cmServico = "";
			String cmProgram = "";

			int cursor = GCIDelimiter.SEPARADOR.length();
			
			//Cabecalho do registro
			if (payload.length() >= GCIDelimiter.TAMANHO_CR) {
				
				newBody = newBody.concat(getTag("CR_TPO_CNX", payload.substring(cursor, (cursor += GCIDelimiter.CR_TPO_CNX))));
				newBody = newBody.concat(getTag("CR_COD_MSG", payload.substring(cursor, (cursor += GCIDelimiter.CR_COD_MSG))));
				newBody = newBody.concat(getTag("CR_TAM_REG", payload.substring(cursor, (cursor += GCIDelimiter.CR_TAM_REG))));
				newBody = newBody.concat(getTag("CR_NSU_MSG", payload.substring(cursor, (cursor += GCIDelimiter.CR_NSU_MSG))));
				newBody = newBody.concat(getTag("CR_SOC_ORI", payload.substring(cursor, (cursor += GCIDelimiter.CR_SOC_ORI))));
				newBody = newBody.concat(getTag("CR_VER_ORI", payload.substring(cursor, (cursor += GCIDelimiter.CR_VER_ORI))));
				newBody = newBody.concat(getTag("CR_CHR_FIM", payload.substring(cursor, (cursor += GCIDelimiter.CR_CHR_FIM))));
				
			}
			
			//Cabecalho da mensagem
			if (payload.length() >= (GCIDelimiter.TAMANHO_CR + GCIDelimiter.TAMANHO_CM)) {
				
				cmSistema = payload.substring(cursor, (cursor += GCIDelimiter.CM_SISTEMA));
				cmServico = payload.substring(cursor, (cursor += GCIDelimiter.CM_SERVICO));
				cmProgram = payload.substring(cursor, (cursor += GCIDelimiter.CM_PROGRAM));
				
				newBody = newBody.concat(getTag("CM_SISTEMA", cmSistema));
				newBody = newBody.concat(getTag("CM_SERVICO", cmServico));
				newBody = newBody.concat(getTag("CM_PROGRAM", cmProgram));
				newBody = newBody.concat(getTag("CM_VERSAO", payload.substring(cursor, (cursor += GCIDelimiter.CM_VERSAO))));
				newBody = newBody.concat(getTag("CM_TIMEOUT", payload.substring(cursor, (cursor += GCIDelimiter.CM_TIMEOUT))));
				newBody = newBody.concat(getTag("CM_TAMMSG", payload.substring(cursor, (cursor += GCIDelimiter.CM_TAMMSG))));
				newBody = newBody.concat(getTag("CM_CODERRO", payload.substring(cursor, (cursor += GCIDelimiter.CM_CODERRO))));
				newBody = newBody.concat(getTag("CM_ENDIP", payload.substring(cursor, (cursor += GCIDelimiter.CM_ENDIP))));
				newBody = newBody.concat(getTag("CM_CLIENT", payload.substring(cursor, (cursor += GCIDelimiter.CM_CLIENT))));
				newBody = newBody.concat(getTag("CM_MATRIC", payload.substring(cursor, (cursor += GCIDelimiter.CM_MATRIC))));
				newBody = newBody.concat(getTag("CM_SENHA", payload.substring(cursor, (cursor += GCIDelimiter.CM_SENHA))));
				newBody = newBody.concat(getTag("CM_CONT", payload.substring(cursor, (cursor += GCIDelimiter.CM_CONT))));
				
			}
			
			copyBook = getCopybook(cmSistema + cmServico + cmProgram);
			if (copyBook != null) {
				for (CBParameter param : copyBook.getParameters()) {
					if ((cursor + param.getSize()) < payload.length()) {
						newBody = newBody.concat(getTag(param.getName(), payload.substring(cursor, (cursor += param.getSize()))));
					}
				}
			}
			
			//Bytes do final da mensagem
			if (cursor < payload.length())
				newBody = newBody.concat(getTag("LASTBYTES", payload.substring(cursor)));
			
			response.setBody(newBody);
		}
		catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	@Override
	public void updateResponse(TestExec testExec, TransientResponse response) {
		
		if (response == null) return;
		
		try {
			String newBody = parseCustomCmds(response.getBodyAsString());
			newBody = GCIDelimiter.SEPARADOR + removeTags(testExec.parseInState(newBody));
			
			response.setBody(newBody);
			response.setBinary(false);
		}
		catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public void updateResponse(TransientResponse response) {
		updateResponse(null, response);
	}
	
	private CopyBook getCopybook(String key) {
		CopyBook copyBook = null;
		LinkedProperties prop = null;
		InputStream is;
		
		File dir = new File(COPYBOOK_DIR);
		
		for (File file : dir.listFiles()) {
			try {
				prop = new LinkedProperties();
				is = new FileInputStream(file);
				
				prop.load(is);
				if (prop.getProperty("KEY").equals(key)) break;
				prop = null;
			}
			catch (Exception x) {
				
			}
		}
		
		if (prop != null) 
			copyBook = CopyBook.getInstance(prop);
		
		return copyBook;
	}
	
	private String getTag(String tagName, String value) {
		return "<".concat(tagName).concat(">").concat(value).concat("</").concat(tagName).concat(">\n");
	}
	
	private String removeTags(String text) {
		String newText = text.replaceAll("\n", "").replaceAll("\r", "");
		
		while (newText.indexOf("<") > -1)
			newText = newText.substring(0, newText.indexOf("<")).
					concat(newText.substring(newText.indexOf(">") + 1));
		
		return newText;
	}
	
	private String parseCustomCmds(String text) {
		
		String result = text;
		
		try {
			if (result.indexOf("{{autoSequence") > -1) {
				String key = result.substring(result.indexOf("{{autoSequence") + 15, result.indexOf(")", result.indexOf("{{autoSequence")));
				String nextNumber;
				String minChar;
				
				Properties prop = new Properties();
				OutputStream output = null;
				InputStream input = new FileInputStream(CONFIG_DIR + File.separator + "autoSequence.properties");
				
				prop.load(input);
				nextNumber = prop.getProperty(key);
				minChar = prop.getProperty(key +".minChar");
				
				if (nextNumber == null)
					nextNumber = "1";
				
				if (minChar == null)
					minChar = "1";
				
				//USAR O NUMERO
				nextNumber = GCIHelper.completaZeros(nextNumber, Integer.parseInt(minChar));
				result = result.substring(0, result.indexOf("{{autoSequence")) + 
						nextNumber + result.substring(result.indexOf(")", result.indexOf("{{autoSequence")) + 3);
				
				output = new FileOutputStream(CONFIG_DIR + File.separator + "autoSequence.properties");
				nextNumber = String.valueOf(Long.parseLong(nextNumber) + 1);
				prop.setProperty(key, nextNumber);
				prop.setProperty(key +".minChar", minChar);
				prop.store(output, null);
			}
		}
		catch(Exception x) {
			x.printStackTrace();
		}
		
		return result;
	}
}