package obi1.socket.felipeprotocol;

import com.itko.lisa.vse.stateful.model.TransactionProcessor;
import com.itko.lisa.vse.stateful.protocol.tcp.TCPProtocolHandler;
import com.itko.lisa.vse.stateful.protocol.tcp.delimiters.TCPDelimiter;
import com.itko.lisa.vse.stateful.protocol.tcp.recordingproxy.ProxyConfig;

public class FPTransportProtocol extends TCPProtocolHandler implements TransactionProcessor, ProxyConfig {

	public FPTransportProtocol() {
		super();
		addDataProtocol(new FPProtocol(), true);
		addDataProtocol(new FPProtocol(), false);
		super.setRequestDelimiter(new FPDelimiter());
		super.setResponseDelimiter(new FPDelimiter());
	}
	
	public void setRequestDelimiter(TCPDelimiter newDelimiter) {
		if (newDelimiter instanceof FPDelimiter) {
			super.setRequestDelimiter(newDelimiter);
		}
	}
	
	public void setResponseDelimiter(TCPDelimiter newDelimiter) {
		if (newDelimiter instanceof FPDelimiter) {
			super.setRequestDelimiter(newDelimiter);
		}
	}
	
}
