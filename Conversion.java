import java.util.HashMap;

public class Conversion {

	 // Add keys and values (letters, numbers)
    // Create a HashMap object called alphanumerique
    HashMap<Integer, String> alphaNumerique; 
    
	public Conversion() {
    alphaNumerique = new HashMap<Integer, String>();
	alphaNumerique.put(0, "A");
    alphaNumerique.put(1, "B");
    alphaNumerique.put(2, "C");
    alphaNumerique.put(3, "D");
    alphaNumerique.put(4, "E");
    alphaNumerique.put(5, "F");
    alphaNumerique.put(6, "G");
    alphaNumerique.put(7, "H");
    alphaNumerique.put(8, "I");
    alphaNumerique.put(9, "J");
    alphaNumerique.put(10, "K");
    alphaNumerique.put(11, "L");
    alphaNumerique.put(12, "M");
    alphaNumerique.put(13, "N");
    alphaNumerique.put(14, "O");
    alphaNumerique.put(15, "P");
    alphaNumerique.put(16, "Q");
    alphaNumerique.put(17, "R");
    alphaNumerique.put(18, "S");
    alphaNumerique.put(19, "T");
    alphaNumerique.put(20, "U");
    alphaNumerique.put(21, "V");
    alphaNumerique.put(22, "W");
    alphaNumerique.put(23, "X");
    alphaNumerique.put(24, "Y");
    alphaNumerique.put(25, "Z");
    alphaNumerique.put(26, " ");
	}
	
    HashMap<String, Integer> numeriqueAlpha; 
    
	public Conversion(String lettre) {
    numeriqueAlpha = new HashMap<String, Integer>();
    numeriqueAlpha.put("A", 0);
	numeriqueAlpha.put("B", 1);
	numeriqueAlpha.put("C", 2);
	numeriqueAlpha.put("D", 3);
	numeriqueAlpha.put("E", 4);
	numeriqueAlpha.put("F", 5);
	numeriqueAlpha.put("G", 6);
	numeriqueAlpha.put("H", 7);
	numeriqueAlpha.put("I", 8);
	numeriqueAlpha.put("J", 9);
	numeriqueAlpha.put("K", 10);
	numeriqueAlpha.put("L", 11);
	numeriqueAlpha.put("M", 12);
	numeriqueAlpha.put("N", 13);
	numeriqueAlpha.put("O", 14);
	numeriqueAlpha.put("P", 15);
	numeriqueAlpha.put("Q", 16);
	numeriqueAlpha.put("R", 17);
	numeriqueAlpha.put("S", 18);
	numeriqueAlpha.put("T", 19);
	numeriqueAlpha.put("U", 20);
	numeriqueAlpha.put("V", 21);
	numeriqueAlpha.put("W", 22);
	numeriqueAlpha.put("X", 23);
	numeriqueAlpha.put("Y", 24);
	numeriqueAlpha.put("Z", 25);
	numeriqueAlpha.put(" ", 26);
	}
	
	public HashMap<Integer, String> getMap() {	
		return alphaNumerique; 
	}
	
	public String getValueOfNbr(int nbr) {
		String y = alphaNumerique.get(nbr);
		return y;
	}
	
	public int getValueOfLettre(String lettre) {
		int y = numeriqueAlpha.get(lettre);
		return y;
	}
	
}
