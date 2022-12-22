package zadaca2;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML {

	public void kreirajFajl(String fileName, List<Vraboten> objekt){
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			Element root = doc.createElement("Vraboten");
			doc.appendChild(root);
			
			for(Vraboten v: objekt ) {
				
				Element objektElement = doc.createElement("Vraboten");
				root.appendChild(objektElement);
				
				Element ime = doc.createElement("Ime");
				objektElement.appendChild(ime);
				
				Element prezime = doc.createElement("Prezime");
				objektElement.appendChild(prezime);
				
				Element plata = doc.createElement("Plata");
				objektElement.appendChild(plata);
				
				ime.appendChild(doc.createTextNode(v.getIme()));
				prezime.appendChild(doc.createTextNode(v.getPrezime()));
				plata.appendChild(doc.createTextNode(v.getPlata()));
			}
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			DOMSource src = new DOMSource (doc);
			
			StreamResult result = new StreamResult (new File(fileName));
			
			t.transform(src,result);
			
			System.out.println("Kreiran e fajl so ime " + fileName );
			System.out.println("Zacuvano");
		}
	
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
}
