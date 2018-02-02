package com.ca.wcf2soap;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Wcf2Soap extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private String xml;
	private String soapXml;
	
	public static void main(String[] args) throws Exception {
		new Wcf2Soap();
	}
	
	public Wcf2Soap() throws Exception {
		addWindowListener(new WindowListener() {
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowOpened(WindowEvent e) {}
		});

		//Tamanho e posição
		setTitle("Wcf2Soap v.0.1");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 418, 248);
		setResizable(false);
		int w = getSize().width;
		int h = getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		setLocation(x, y);
		getContentPane().setLayout(null);
		
		JLabel lblInterfaces = new JLabel("Interfaces");
		lblInterfaces.setBounds(12, 82, 77, 16);
		getContentPane().add(lblInterfaces);
		
		JLabel lblRequest = new JLabel("Request");
		lblRequest.setBounds(12, 111, 77, 16);
		getContentPane().add(lblRequest);
		
		JLabel DTO = new JLabel("New label");
		DTO.setBounds(12, 140, 77, 16);
		getContentPane().add(DTO);
		
		txtInterfaces = new JTextField();
		txtInterfaces.setBounds(101, 79, 246, 22);
		getContentPane().add(txtInterfaces);
		txtInterfaces.setColumns(10);
		
		txtRequest = new JTextField();
		txtRequest.setBounds(101, 108, 246, 22);
		getContentPane().add(txtRequest);
		txtRequest.setColumns(10);
		
		txtDTO = new JTextField();
		txtDTO.setBounds(101, 137, 246, 22);
		getContentPane().add(txtDTO);
		txtDTO.setColumns(10);
		
		txtFile = new JTextField();
		txtFile.setBounds(101, 13, 246, 22);
		getContentPane().add(txtFile);
		txtFile.setColumns(10);
		
		JButton button = new JButton("...");
		button.setBounds(355, 12, 38, 25);
		getContentPane().add(button);
		
		JLabel lblArquivo = new JLabel("Arquivo");
		lblArquivo.setBounds(12, 16, 77, 16);
		getContentPane().add(lblArquivo);
		
		JLabel lblNameSpaces = new JLabel("Name Spaces:");
		lblNameSpaces.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNameSpaces.setBounds(12, 53, 113, 16);
		getContentPane().add(lblNameSpaces);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.setBounds(296, 175, 97, 25);
		getContentPane().add(btnConverter);

		//Exibindo a tela
		setVisible(true);

		btnConverter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					xml = readFile("C:\\Users\\jacfe02\\Documents\\Work\\OneDrive - CA Technologies\\Clientes\\Edenred\\POC\\AppTest-WS\\XMLWcfStorm2.xml");
					soapXml = convert(xml);
				}
				catch (Exception x) {
					x.printStackTrace();
				}
			}
		});

		
		xml = readFile("C:\\Users\\jacfe02\\Documents\\Work\\OneDrive - CA Technologies\\Clientes\\Edenred\\POC\\AppTest-WS\\XMLWcfStorm2.xml");
		soapXml = convert(xml);

		
		System.out.println(soapXml);
		
		System.exit(0);;
	}
	
	public String readFile(String file) throws Exception {
		
		String result = "";
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }

		    result = sb.toString();
		} 
		catch (Exception x) {
			result = null;
			x.printStackTrace();
			throw x;
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (Exception x) {
					x.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	private String xmlnsInterfaces = "http://Ticket/Watts/CorporateLevelManagement/Core/Interfaces/";
	private String xmlnsRequest = "http://schemas.datacontract.org/2004/07/Ticket.Watts.Framework.Core.Communications.Request";
	private String xmlnsDTO = "http://schemas.datacontract.org/2004/07/Ticket.Watts.CorporateLevelManagement.Core.DTO";
	private JTextField txtInterfaces;
	private JTextField txtRequest;
	private JTextField txtDTO;
	private JTextField txtFile;
	
	public String convert(String wcfXML) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(wcfXML));
		
		Document document = builder.parse(is);
		Node node;

		StringBuilder newXML = new StringBuilder();
		newXML.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
			.append("<soapenv:Envelope xmlns:soapenv=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n")
			.append("  <soapenv:Body>\n")
			.append("    <").append(document.getDocumentElement().getNodeName()).append(" xmlns=\"").append(xmlnsInterfaces).append("\">\n");
		
		for (int i = 0; i < document.getDocumentElement().getChildNodes().getLength(); i++) {
			node = document.getDocumentElement().getChildNodes().item(i);
			
			if (node.getNodeName().equals("MethodParameters"))
				newXML.append(convertContent(3, node.getChildNodes()));
		}
		
		newXML.append("    </").append(document.getDocumentElement().getNodeName()).append(">\n")
			.append("  </soapenv:Body>\n")
			.append("</soapenv:Envelope>\n");
		
		return newXML.toString();
	}
	
	public String convertContent(int identValue, NodeList nodeList) {
		
		StringBuilder newXML = new StringBuilder();
		Node node;
		
		String xmlns = "";
		
		for (int i = 0; i < nodeList.getLength(); i++) {
		
			node = nodeList.item(i);
			
			if (!node.getNodeName().equals("#text")) {
				if (",Control,List,Paging,Security,User,".indexOf("," + node.getNodeName() + ",") > 0)
					xmlns = xmlnsRequest;
				else if (node.getNodeName().endsWith("DTOArray0"))
					xmlns = xmlnsDTO;
				else
					xmlns = null;
	
				newXML.append(getTagContent(identValue, node, xmlns));
			}
		}
		
		return newXML.toString();
	}
	
	public String getTagContent(int identValue, Node node, String xmlns) {
		
		StringBuilder newXML = new StringBuilder();
		String tagName = node.getNodeName().endsWith("Array0") ? node.getNodeName().substring(0, node.getNodeName().indexOf("Array0")) : node.getNodeName();
		String properties = xmlns == null ? "" : " xmlns=\"" + xmlns + "\"";
		
		newXML.append(getTabs(identValue)).append("<").append(tagName).append(properties);
		
		if (node.getChildNodes().getLength() <= 1 && node.getTextContent().trim().equals("")) {
			newXML.append(" xsi:nil=\"true\"/>\n");
		}
		else {
			newXML.append(">");
			if (node.getChildNodes().getLength() > 1) {
				newXML.append("\n");
				newXML.append(convertContent(identValue + 1, node.getChildNodes()));
				newXML.append(getTabs(identValue)).append("</").append(tagName).append(">\n");
			}
			else {
				newXML.append(node.getTextContent());
				newXML.append("</").append(tagName).append(">\n");
			}
		}
		
		return newXML.toString();
	}
	
	public String getTabs(int identValue) {
		String result = "";
		for (int i = 0; i < identValue; i++) result += "  ";
		return result;
	}
}
