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
	 
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.NodeList;

	public class map{
		
		
		public void start() {
			
			Statement stmt = null;
			ResultSet rs;
			Connection con = null;
			try {
				 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net/sql12273536", "sql12273536", "accolite");
				} catch (Exception e) {
					System.out.println(e);
					System.exit(0);
				}
				String query="INSERT INTO emp " + "VALUES(432,'raj','SD',405,'2018-02-03',9200,447,20)";
				stmt = con.prepareStatement(query);
	 
				stmt.executeUpdate(query);
					
			}
			catch(SQLException se)
			{
		     se.printStackTrace();
		    } 
			catch(Exception e)
			{
		        e.printStackTrace();
		    } 
			finally {
		        try {
		            if(stmt != null)
		                con.close();
		        } 
		        catch(SQLException se)
		        {
		        }
		        try {
		            if(con != null)
		                con.close();
		        } catch(SQLException se) {
		            se.printStackTrace();
		        }
	
				}
			
		}
		
		
	}
