package zadaca1;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML {

	public void kreirajFajl(String fileName, Vraboten objekt) {
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			Element root = doc.createElement("Vraboten");
			doc.appendChild(root);
			
			Element ime = doc.createElement("Ime");
			root.appendChild(ime);
			
			Element prezime = doc.createElement("Prezime");
			root.appendChild(prezime);
			
			Element plata = doc.createElement("Plata");
			root.appendChild(plata);
			
			ime.appendChild(doc.createTextNode(objekt.getIme()));
			prezime.appendChild(doc.createTextNode(objekt.getPrezime()));
			plata.appendChild(doc.createTextNode(objekt.getPlata()));
	
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			DOMSource src = new DOMSource (doc);
			
			StreamResult result = new StreamResult (new File(fileName));
			
			t.transform(src,result);
			
			System.out.println("Kreiran e fajl so ime: " + fileName );
			System.out.println("Zacuvano");
		}
		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}	
}
