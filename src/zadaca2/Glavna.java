package zadaca2;

import java.util.ArrayList;
import java.util.List;

public class Glavna {

	public static void main(String[] args) {

		List<Vraboten> objekt = new ArrayList<Vraboten>();
		
		objekt.add(new Vraboten ("Elena", "Risteska", "80000"));
		objekt.add(new Vraboten ("Mihail", "Kitanov", "75000"));
		objekt.add(new Vraboten ("Dimitar", "Miladinov", "23000"));
	
		XML xml = new XML();
		xml.kreirajFajl("file2.xml", objekt);
	}
}
