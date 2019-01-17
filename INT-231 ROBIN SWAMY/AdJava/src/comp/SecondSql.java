package comp;
import java.io.File;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.sql.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SecondSql{
	
	//Assert a=new Assert();
	public static String second = "S.xml";	
	public void start() {
		 
		 
		//Table data to XML 
				Document doc = null;
				try {
					
					SecondSql sql = null;
					doc = sql.generateXML();
				} catch (TransformerException | ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
				public static Document generateXML() throws TransformerException,
				ParserConfigurationException {
					
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			DOMSource domSource1 = null;
	 
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element results = doc.createElement("Table");
			doc.appendChild(results);
	 
			try {
	 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(
							"jdbc:mysql://sql12.freemysqlhosting.net/sql12273536","sql12273536","accolite");
				} catch (Exception e) {
					System.out.println(e);
					System.exit(0);
				}
	 
				pstmt = con
						.prepareStatement("select * from emp");
	 
				rs = pstmt.executeQuery();
	 
				System.out.println("Col count pre ");
				ResultSetMetaData rsmd = rs.getMetaData();//to retrieve table name, column name, column type and column precision, etc..
				int colCount = rsmd.getColumnCount();
	 
				Element tableName = doc.createElement("TableName");
				tableName.appendChild(doc.createTextNode(rsmd.getTableName(1)));
				results.appendChild(tableName);
	 
				Element structure = doc.createElement("TableStructure");
				results.appendChild(structure);
	 
				Element col = null;
				for (int i = 1; i <= colCount; i++) {
	 
					col = doc.createElement("Column" + i);
					results.appendChild(col);
					Element columnNode = doc.createElement("ColumnName");
					columnNode
							.appendChild(doc.createTextNode(rsmd.getColumnName(i)));
					col.appendChild(columnNode);
	 
					Element typeNode = doc.createElement("ColumnType");
					typeNode.appendChild(doc.createTextNode(String.valueOf((rsmd
							.getColumnTypeName(i)))));
					col.appendChild(typeNode);
	 
					Element lengthNode = doc.createElement("Length");
					lengthNode.appendChild(doc.createTextNode(String.valueOf((rsmd
							.getPrecision(i)))));
					col.appendChild(lengthNode);
	 
					structure.appendChild(col);
				}
	 
				System.out.println("Col count = " + colCount);
	 
				Element productList = doc.createElement("TableData");
				results.appendChild(productList);
	 
				int l = 0;
				while (rs.next()) {
					Element row = doc.createElement("Product" + (++l));
					results.appendChild(row);
					for (int i = 1; i <= colCount; i++) {
						String columnName = rsmd.getColumnName(i);
						Object value = rs.getObject(i);
						Element node = doc.createElement(columnName);
						node.appendChild(doc.createTextNode((value != null) ? value
								.toString() : ""));
						row.appendChild(node);
					}
					productList.appendChild(row);
				}
	 
				
				
				domSource1 = new DOMSource(doc);
				 TransformerFactory transformerFactory = TransformerFactory.newInstance();
					
		            Transformer transformer = transformerFactory.newTransformer();
		
		           //String second = "C:\\Users\\robin\\eclipse-workspace\\AdJava\\bin\\SecondExample.xml";	
		        
					StreamResult streamResult1 = new StreamResult(new File(second));
		
		 
		            transformer.transform(domSource1, streamResult1);
		
		            System.out.println("Done creating XML File");				           
	 
			} catch (SQLException sqlExp) {
	 
				System.out.println("SQLExcp:" + sqlExp.toString());
	 
			} finally {
				try {
	 
					if (rs != null) {
						rs.close();
						rs = null;
					}
					if (con != null) {
						con.close();
						con = null;
					}
				} catch (SQLException expSQL) {
					System.out
							.println("CourtroomDAO::loadCourtList:SQLExcp:CLOSING:"
									+ expSQL.toString());
				}
			}
	 
			// return sw.toString();
	 
			return doc;
	
				}
	
}
