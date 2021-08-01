

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


class Order {
	private int Id;
	private String Name;
	private int Age;
	private String City;
	
	public Order(int id, String name, int age, String city) {
		this.Id = id;
		this.Name = name;
		this.Age = age;
		this.City = city;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}
	
}

class Orders {
	private Order order[] = {		// this data could be coming from database
		new Order(11, "Ali", 20, "Lahore"),
		new Order(12, "Humza", 32, "Islamabad"),
	};

	public Order[] get() {
		return order;
	}

	public void set(Order[] _order) {
		this.order = _order;
	}
}


public class CreateXML {

	public static void main(String[] args) {
		System.out.println("hello!");
		
		
        try {
        	//create new XML document
    		Document doc = new Document();
    		Element OrderElement = doc.setRootElement(new Element("Order")).getRootElement();
    		//get Orders
    		//could be coming from database
    		Order orders[] = new Orders().get();
    		
    		//create XML element for each order
    		for(int i = 0; i < orders.length; i++ ) {
    			System.out.println(orders[i].getName());
    			OrderElement.addContent(createCustomerXMLElement(orders[i]));
    		}
    		
    		
            

    		OrderElement.addContent(createUserXMLElement("1", "Ramesh", "Fadatare", "28", "Male"));
    		OrderElement.addContent(createUserXMLElement("2", "Tom", "Cruise", "45", "Male"));
    		OrderElement.addContent(createUserXMLElement("3", "Tony", "Stark", "40", "Male"));
    		OrderElement.addContent(createUserXMLElement("3", "Amir", "Khan", "50", "Male"));

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

	private static Element createCustomerXMLElement(Order order) {
		String CustomerId = String.valueOf(order.getId());
		String CustomerName = order.getName();
		String CustomerAge = String.valueOf(order.getAge());
		String CustomerCity = order.getCity();
		
	    Element Customer = new Element("Customer");
	    Customer.setAttribute(new Attribute("order_id", CustomerId));
	    Customer.addContent(new Element("name").setText(CustomerName));
	    Customer.addContent(new Element("age").setText(CustomerAge));
	    Customer.addContent(new Element("city").setText(CustomerCity));
	    return Customer;
	}

}
