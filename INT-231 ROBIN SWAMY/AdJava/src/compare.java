import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader; 
import java.util.List; 
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
import org.xml.sax.SAXException;
import java.lang.*;


public class compare{
	public void start() throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
	
		
		
		File file1 = new File("FirstExample.xml");
		File file2=new File("S.xml");
		BufferedReader FXML = new BufferedReader(new FileReader(file1));
		BufferedReader SXML = new BufferedReader(new FileReader(file2));
		String line = FXML.readLine();
		String line1 = SXML.readLine();
	    System.out.println("Unsimilar  Data Present after Insert command");
		while(line!=null&&line1!=null)
		{
			if(line.equals(line1))
			{
				line=FXML.readLine();
				line1=SXML.readLine();
			}
			else
			{
				System.out.println(line1);
				line1=SXML.readLine();
			}
		}
		
		
 }
 }
