package zadaca1;

public class Glavna {

	public static void main(String[] args) {

		Vraboten objekt = new Vraboten();
		
		objekt.setIme("Mihail");
		objekt.setPrezime("Naumovski");
		objekt.setPlata("70000");
		
		XML xml = new XML();
		xml.kreirajFajl("file.xml", objekt);
	}
}
