package com.vzb.prj.util;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/** * XML utils, including formatting. */
public class XmlUtils {
	private static XmlFormatter formatter = new XmlFormatter(2, 80);

	public static String formatXml(String s) {
		return formatter.format(s, 0);
	}

	public static String formatXml(String s, int initialIndent) {
		return formatter.format(s, initialIndent);
	}

	private static class XmlFormatter {
		private int indentNumChars;
		private int lineLength;
		private boolean singleLine;

		public XmlFormatter(int indentNumChars, int lineLength) {
			this.indentNumChars = indentNumChars;
			this.lineLength = lineLength;
		}

		public synchronized String format(String s, int initialIndent) {
			int indent = initialIndent;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				char currentChar = s.charAt(i);
				if (currentChar == '<') {
					char nextChar = s.charAt(i + 1);
					if (nextChar == '/') {
						indent -= indentNumChars;
					}
					// see if its a closing tag
					
					if (!singleLine) // Don't indent before closing element if
										// we're creating opening and closing
										// elements on a single line.
						sb.append(buildWhitespace(indent));
					if (nextChar != '?' && nextChar != '!' && nextChar != '/') {
						indent += indentNumChars;
					}
					singleLine = false; // Reset flag.
				}
				boolean ignore = false;
				
				if (currentChar == ' ' || currentChar == '\n') {
					// if its between two opening or two closing tags, ignore
					int nextStartIndex = s.indexOf('<', i);
					int nextEndIndex = s.indexOf('>', i);
					
					if (nextStartIndex < nextEndIndex) { 
						if (s.charAt(nextEndIndex-1) == '/') {
							// next tag is an open/close tag. That means this char is definitely between two diff tags and should be ignored
							ignore = true;
						} else if (s.charAt(nextStartIndex+1) != '/') { // next tag is opening tag
							ignore = true;
						} else {
							String prevString = s.substring(0, i);
							int lastCloseIndex = prevString.lastIndexOf('>');
							int lastStartIndex = prevString.lastIndexOf('<');
							if (lastStartIndex < lastCloseIndex) {
								if (s.charAt(lastCloseIndex-1) == '/') {
									// last tag is an open/close tag. That means this char is definitely between two diff tags and should be ignored
									ignore = true;
								} else if (s.charAt(lastStartIndex+1) == '/') { //next and last tags are closing tags
										ignore = true;
								}
							}
						}
					}
				}
				
				if (!ignore) {
					sb.append(currentChar);
				}
				
				if (currentChar == '>') {
					if (s.charAt(i - 1) == '/') {
						indent -= indentNumChars;
						sb.append("\n");
					} else {
						int nextStartElementPos = s.indexOf('<', i);
						if (nextStartElementPos > i + 1 && s.charAt(nextStartElementPos+1) == '/') {//only closing tag handling should be done this way
							String textBetweenElements = s.substring(i + 1,
									nextStartElementPos); // If the space
															// between elements
															// is solely
															// newlines or spaces, let
															// them through to
															// preserve
															// additional
															// newlines in
															// source document.
							if ( textBetweenElements.replaceAll("\n", "").replaceAll(" ", "")
									.length() == 0) {
								sb.append("\n");
							} // Put tags and text on a single line if the text
								// is short.
							else if (textBetweenElements.length() <= lineLength * 0.5) {
								sb.append(textBetweenElements);
								singleLine = true;
							} // For larger amounts of text, wrap lines to a
								// maximum line length.
							else {
								sb.append("\n"
										+ lineWrap(textBetweenElements,
												lineLength, indent, null)
										+ "\n");
							}
							i = nextStartElementPos - 1;
						} else {
							sb.append("\n");
						}
					}
				}
			}
			return sb.toString();
		}
	}

	private static String buildWhitespace(int numChars) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numChars; i++)
			sb.append(" ");
		return sb.toString();
	}

	/**
	 * Wraps the supplied text to the specified line length.
	 * 
	 * @lineLength the maximum length of each line in the returned string (not
	 *             including indent if specified).
	 * @indent optional number of whitespace characters to prepend to each line
	 *         before the text.
	 * @linePrefix optional string to append to the indent (before the text).
	 * @returns the supplied text wrapped so that no line exceeds the specified
	 *          line length + indent, optionally with indent and prefix applied
	 *          to each line.
	 */
	private static String lineWrap(String s, int lineLength, Integer indent,
			String linePrefix) {
		if (s == null)
			return null;
		StringBuilder sb = new StringBuilder();
		int lineStartPos = 0;
		int lineEndPos;
		boolean firstLine = true;
		while (lineStartPos < s.length()) {
			if (!firstLine)
				sb.append("\n");
			else
				firstLine = false;
			if (lineStartPos + lineLength > s.length())
				lineEndPos = s.length() - 1;
			else {
				lineEndPos = lineStartPos + lineLength - 1;
				while (lineEndPos > lineStartPos
						&& (s.charAt(lineEndPos) != ' ' && s.charAt(lineEndPos) != '\t'))
					lineEndPos--;
			}
			sb.append(buildWhitespace(indent));
			if (linePrefix != null)
				sb.append(linePrefix);
			sb.append(s.substring(lineStartPos, lineEndPos + 1));
			lineStartPos = lineEndPos + 1;
		}
		return sb.toString();
	} 
	
	public static String transform(String xmlFilePath, String xsltFilePath) throws Exception{		
		StreamResult result = new StreamResult(new StringWriter());
		StreamSource s = new StreamSource(new File(xsltFilePath));
		StreamSource xml = new StreamSource(new File(xmlFilePath));
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer(s);
		transformer.transform(xml, result);
		
		String response = result.getWriter().toString();
		
		return response;
	}
	
	public static String transformString(String xmlString, String xsltFilePath) throws Exception{		
		StreamResult result = new StreamResult(new StringWriter());
		StreamSource s = new StreamSource(new File(xsltFilePath));
		StreamSource xml = new StreamSource(new StringReader(xmlString));
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer(s);
		transformer.transform(xml, result);
		
		String response = result.getWriter().toString();
		
		return response;
	}
	
	public static Object parseRequestObjectFromSoap(String soapXml) throws Exception{
		Object result = null;
		
		if(soapXml != null && soapXml.trim().length()>0) {
			DocumentBuilderFactory xmlFact =
			                DocumentBuilderFactory.newInstance();
			xmlFact.setNamespaceAware(true);

			DocumentBuilder builder = xmlFact.newDocumentBuilder();
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			
			// map namespace
//			xpath.setNamespaceContext(new NamespaceContext() {
//				public String getNamespaceURI(String prefix) {
//				    return "soap".equals(prefix) ?  "http://schemas.xmlsoap.org/soap/envelope/" : null;
//				}
//
//				public String getPrefix(String namespaceURI) {
//				    return null; // we are not using this.
//				}
//
//				public Iterator getPrefixes(String namespaceURI) {
//				    return null; // we are not using this.
//				}
//			    });

			
			StringReader xsr = new StringReader(soapXml);
			InputSource is = new InputSource(xsr);
			Document doc = builder.parse(is);
			
			//Node requestNode = (Node) xpath.evaluate("/soap:Envelope/soap:Body/*", doc, XPathConstants.NODE);
			Node requestNode = (Node) xpath.evaluate("/*[local-name()='Envelope']/*[local-name()='Body']/*", doc, XPathConstants.NODE);
			
			JAXBContext ctx = JAXBContext.newInstance("xo.xoi.orderentry.ebonding");
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			result = unmarshaller.unmarshal(requestNode);
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		String input = "<USER>  <USERTYPE>Business Services</USERTYPE>  <USERFIRSTNAME>Red</USERFIRSTNAME>  <USERLASTNAME>Ventures</USERLASTNAME>  <USEREMAILADDRESS>red@ventures.com</USEREMAILADDRESS>  <USERSWORKPHONE>1112223333</USERWORKPHONE>  <USERCOMPANY>    <USERCOMPANYID>redventures</USERCOMPANYID>    <USERCOMPANYNAME>Red Ventures</USERCOMPANYNAME>\n      </USERCOMPANY>   <USERPARTNERID>X-1111</USERPARNTERID>  <USERPRICELISTACCESS>      <LISTACCESS>         <USERLINEOFBUSINESSID>SMB</USERLINEOFBUSINESSID>         <USERNETWORKACCESSTYPE>PORT</USERNETWORKACCESSTYPE>         <USERNETWORKACCESSVALUE>PORT</USERNETWORKACCESSVALUE>         <USERICBCODE>12345</USERICBCODE>      </LISTACCESS>      <LISTACCESS>         <USERLINEOFBUSINESSID>SMB</USERLINEOFBUSINESSID>         <USERNETWORKACCESSTYPE>LOOP</USERNETWORKACCESSTYPE>         <USERNETWORKACCESSVALUE>LOOP</USERNETWORKACCESSVALUE>         <USERICBCODE></USERICBCODE>      </LISTACCESS>   </USERPRICELISTACCESS></USER>";
		String output = formatXml(input);
		System.out.println(output);
		
		input = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Header><ns2:psSoapHeader xmlns:ns2=\"http://namespaces.xo.com/ICP/Headers\" xmlns:ns3=\"http://xo/xoi/orderentry/Ebonding/InternalElements\" xmlns:ns4=\"http://xo/xoi/orderentry/Ebonding/\"><ns2:UserId>SMB</ns2:UserId><ns2:Password>SMB</ns2:Password><ns2:TransactionId>23df3162-3177-438a-b37b-4358ac4a0ccf</ns2:TransactionId><ns2:ApplicationName>SMB</ns2:ApplicationName></ns2:psSoapHeader></soap:Header><soap:Body><ns4:SalesOrderPacketStatusRequest xmlns:ns4=\"http://xo/xoi/orderentry/Ebonding/\" xmlns:ns2=\"http://namespaces.xo.com/ICP/Headers\" xmlns:ns3=\"http://xo/xoi/orderentry/Ebonding/InternalElements\"><salesOrderPacketToken>ID:658b1957-9921-11e0-a946-00163e5206bf</salesOrderPacketToken></ns4:SalesOrderPacketStatusRequest></soap:Body></soap:Envelope>";
		Object result = parseRequestObjectFromSoap(input);
		System.out.println(result);
	}
}