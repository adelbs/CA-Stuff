package obi1.socket.felipeprotocol;

import java.util.List;

import com.itko.lisa.vse.stateful.protocol.tcp.delimiters.TCPDelimiter;

public class FPDelimiter implements TCPDelimiter {

	/*
	 * 00 - operacao (0 - inclusao - 1 consulta - 2 exclusao)
	 * 0000 - chave
	 * 00 - tamanho do nome
	 * 00 - tamanho do valor
	 * xxxxxxx - nome (20 caracteres)
	 * xxxxxxx - valor (20 caracteres)
	 */
	
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
		
		String msg = new String(ba);
		
		int tamNome;
		int tamValor;
		
		if (msg.indexOf("\n") > -1) {
			endOfRequest = msg.replaceAll("\n", "").replaceAll("\r", "").length();
			startOfNextRequest = endOfRequest;
			return true;
		}
		
		if (msg.length() >= 10){
			tamNome = Integer.parseInt(msg.substring(6, 8));
			tamValor = Integer.parseInt(msg.substring(8, 10));
			
			if (msg.length() == (tamNome + tamValor + 10)) {
				
				endOfRequest = tamNome + tamValor + 10;
				startOfNextRequest = endOfRequest;
				
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String validate() {
		return null;
	}
}
