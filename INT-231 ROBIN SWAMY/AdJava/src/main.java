import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import comp.SecondSql;
public class main {

	public static void main(String[] args) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		sql s=new sql();
		map m= new map();
		sql1 s1=new sql1();
		SecondSql sql=new SecondSql();
		compare c=new compare();
		s.start();
		m.start();
		//s1.start();
		sql.start();
		c.start();
	}

}
