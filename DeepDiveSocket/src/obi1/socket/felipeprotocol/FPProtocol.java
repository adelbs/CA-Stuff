package obi1.socket.felipeprotocol;

import com.itko.lisa.test.TestExec;
import com.itko.lisa.vse.stateful.model.Request;
import com.itko.lisa.vse.stateful.model.Response;
import com.itko.lisa.vse.stateful.model.TransientResponse;
import com.itko.lisa.vse.stateful.protocol.ParameterListDataProtocol;
import com.itko.util.Parameter;
import com.itko.util.ParameterList;

public class FPProtocol extends ParameterListDataProtocol {
	
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
		String payload;
		
		if (isBinary) {
			payload = new String(request.getBodyAsByteArray());
		}
		else {
			payload = request.getBodyAsString();
		}
		
		try {
			ParameterList attributes = new ParameterList();

			String operacao = payload.substring(0, 2);
			String chave = payload.substring(2, 6);
			int tamNome = Integer.parseInt(payload.substring(6, 8));
			
			String nome = payload.substring(10, (10 + tamNome));
			String valor = payload.substring(10 + tamNome, payload.length());
				
			if (operacao.equals("00")) {
				request.setOperation("INCLUSAO");
				attributes.addParameter(new Parameter("CHAVE", chave));
				attributes.addParameter(new Parameter("NOME", nome));
				attributes.addParameter(new Parameter("VALOR", valor));
			}
			else if (operacao.equals("01")) {
				request.setOperation("CONSULTA");
				attributes.addParameter(new Parameter("CHAVE", chave));
			}
			else if (operacao.equals("02")) {
				request.setOperation("EXCLUSAO");
				attributes.addParameter(new Parameter("CHAVE", chave));
			}
			else {
				request.setOperation("UNKNOWN-OPERATION");
			}
				
			request.setArguments(attributes);
		} 
		catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public void updateResponse(Response response) {

		boolean isBinary = response.isBinary();
		String payload;

		try {
			if (isBinary) {
				payload = new String(response.getBodyAsByteArray());
			}
			else {
				payload = response.getBodyAsString();
			}

			String newBody = "";
			String operacao = payload.substring(0, 2);
			String chave = payload.substring(2, 6);
			int tamNome = Integer.parseInt(payload.substring(6, 8));
			
			String nome = payload.substring(10, (10 + tamNome));
			String valor = payload.substring(10 + tamNome, payload.length());
				
			if (operacao.equals("00")) {
				//INCLUSAO;
				newBody = newBody.concat(getTag("CHAVE", chave));
				newBody = newBody.concat(getTag("NOME", nome));
				newBody = newBody.concat(getTag("VALOR", valor));
			}
			else if (operacao.equals("01")) {
				//CONSULTA
				newBody = newBody.concat(getTag("CHAVE", chave));
			}
			else if (operacao.equals("02")) {
				//EXCLUSAO
				newBody = newBody.concat(getTag("CHAVE", chave));
			}
			
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
			String newBody = response.getBodyAsString();
			
			newBody = removeTags(testExec.parseInState(newBody)) +"\n\r";
			
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
	
}