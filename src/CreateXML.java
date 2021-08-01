

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


class Order {
	private String Name;
	private int Age;
	private String City;
	
	public Order(String _name, int _age, String _city) {
		this.Name = _name;
		this.Age = _age;
		this.City = _city;
	}
	
	
}

interface Orders {
	String Customers[][] = {
			{},
			{}
	};
}


public class CreateXML {

	public static void main(String[] args) {
		System.out.println("hello!");
		
        try {
            Document doc = new Document();
            doc.setRootElement(new Element("Users"));

            doc.getRootElement().addContent(createUserXMLElement("1", "Ramesh", "Fadatare", "28", "Male"));
            doc.getRootElement().addContent(createUserXMLElement("2", "Tom", "Cruise", "45", "Male"));
            doc.getRootElement().addContent(createUserXMLElement("3", "Tony", "Stark", "40", "Male"));
            doc.getRootElement().addContent(createUserXMLElement("3", "Amir", "Khan", "50", "Male"));

            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();
            // xmlOutput.output(doc, System.out);
            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("orderdetail.xml"));

            System.out.println("File Saved!");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

	}

	private static Element createUserXMLElement(String id, String firstName, String lastName, String age,
	    String gender) {
	    Element user = new Element("User");
	    user.setAttribute(new Attribute("id", id));
	    user.addContent(new Element("firstName").setText(firstName));
	    user.addContent(new Element("lastName").setText(lastName));
	    user.addContent(new Element("age").setText(age));
	    user.addContent(new Element("gender").setText(gender));
	    return user;
	}

}
