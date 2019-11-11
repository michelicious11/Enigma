

public class Rotor {


	//direction: true = right - false = left
	private boolean direction; 
	//the rotors
	private int[] allerRotor; 
	private int[] retourRotor;
	//pour convertir chiffre a lettre
	Conversion conversion = new Conversion(); 
	Conversion conversion2 = new Conversion("test");

	//Constructor for a rotor
	public Rotor(int[] allerRotor, int[] retourRotor, boolean direction) {
		this.allerRotor = allerRotor; 
		this.retourRotor = retourRotor;
		this.direction = direction; 
	}

	//Default
	public Rotor() {}


	/****************FONCTIONS********************/

	public boolean checkDirection() { 
		return direction;
	}

	//Determine how many columns to move to, left or right
	public int moveDirection(Rotor x, int y, boolean z) {
		int move;
		boolean direction = x.checkDirection(); 
		if(direction) {
			move = y%26; 
		} else {
			move = -1 * (y%26); 
		}
		return move; 
	}

	//Makes array circular
	public int circularArray(int index, int move) {
		int front = 0; 
		int end = 25; 

		if(move < front) {
			int moveValeur = move%26;
			//System.out.println("movevaleur < " + move + " " + moveValeur );
			move = end + moveValeur; 
			//System.out.println("movevaleur < " + move + " " + moveValeur );
		} else if(move > end) {
			int moveValeur = move%26;
			//System.out.println(moveValeur);
			move = front + moveValeur;
		}	
		return move; 
	}


	public int aller(int w, Rotor x, Rotor y, Rotor z) {

		int moveToIndex = w; //w is the index of first rotor
		//System.out.println(moveToIndex);
		int rotor1 = x.allerRotor[moveToIndex];	//prochain index = value of rotor1
		//at moveToindex + moveToIndex
		moveToIndex = circularArray(moveToIndex, rotor1 + moveToIndex); //convert rotor1 if value outside of array
		//System.out.println(moveToIndex);
		int rotor2 = y.allerRotor[moveToIndex]; //prochain index = value of rotor1 at 
		//updated moveToIndex + updated moveToIndex
		moveToIndex = circularArray(moveToIndex, moveToIndex + rotor2); //convert rotor2 if value outside
		//System.out.println(moveToIndex);
		int rotor3 = z.allerRotor[moveToIndex]; //prochain index = value of rotor2 at 
		//updated2 moveToIndex + updated2 moveToIndex
		moveToIndex = circularArray(moveToIndex, moveToIndex + rotor3);
		//moveToIndex now = index of reflector
		//System.out.println(moveToIndex);
		return moveToIndex;
	}

	public int retour(int w, int[] reflector, Rotor x, Rotor y, Rotor z) {

		int moveToIndex = w; //w is the reflector index 
		//System.out.println(moveToIndex);
		//get index + value to move to rotor3, makes sure value stays into array
		moveToIndex = circularArray(moveToIndex, moveToIndex + reflector[moveToIndex]); 
		//System.out.println(moveToIndex);
		int rotor3 = x.retourRotor[moveToIndex];//next index = index + value of rotor3
		//get index + value to move to rotor2, makes sure value stays into array
		moveToIndex = circularArray(moveToIndex, rotor3 + moveToIndex);
		//System.out.println(moveToIndex);
		int rotor2 = y.retourRotor[moveToIndex]; //next index = index + value of rotor2 
		//get index + value to move to rotor1, makes sure value stays into array
		moveToIndex = circularArray(moveToIndex, moveToIndex + rotor2);
		//System.out.println(moveToIndex);
		int rotor1 = z.retourRotor[moveToIndex];
		moveToIndex = circularArray(moveToIndex, moveToIndex + rotor1);
		return moveToIndex; //returns index of rotor1
	}	

	//fonction pour encrypter combinant aller et retour
	public String encryption(int w, Rotor x, Rotor y, Rotor z, int[] reflector) {
		int moveToIndex = w; 
		int valeurAller = aller(moveToIndex, x, y, z);
		int valeurRetour = retour(valeurAller, reflector, z, y, x);
		String lettre = conversion.getValueOfNbr(valeurRetour);
		System.out.print(lettre);
		return lettre; 
	}
	
	//encrypter avec un String au lieu du int
	public String encryption(String w, Rotor x, Rotor y, Rotor z, int[] reflector) {
		int moveToIndex = conversion2.getValueOfLettre(w); 
		int valeurAller = aller(moveToIndex, x, y, z);
		int valeurRetour = retour(valeurAller, reflector, z, y, x);
		String lettre = conversion.getValueOfNbr(valeurRetour);
		System.out.print(lettre);
		return lettre; 
	}
	
	
	
	//fonction pour recueillir les lettres d'un mot
	public String[] readLetters(String input) {
		int mot = input.length(); 
		String[] lettres = new String[mot];

		for (int i = 0; i < mot; i++)
		{
			char myChar = input.charAt(i);
			lettres[i] = Character.toString(myChar);
		}
		return lettres; 
	}

	//fonction pour changer les lettres recueillies en chiffres
	public int[] convertLetters(String[] lettres) {
		int nbrLettres = lettres.length;
		int[] numeros = new int[nbrLettres]; 
		for(int i = 0; i < nbrLettres; i++) {
			String lettre = lettres[i].toUpperCase();
			int numero = conversion2.getValueOfLettre(lettre);
			numeros[i] = numero; 
		}			
		return numeros;
	}
	
	//
	public void readWord(int[] chiffresMot, Rotor x, Rotor y, Rotor z, int[] reflector) {
		int longueurMot = chiffresMot.length; 
		for(int i = 0; i < longueurMot; i++) {
			int lettre = chiffresMot[i];
			encryption(lettre, x, y, z, reflector); 
		}
	}
	
	public void parcourirMot(String input, Rotor x, Rotor y, Rotor z, int[] reflector) {
		String[] lettres = readLetters(input);
		int[] chiffres = convertLetters(lettres);
		readWord(chiffres, x, y, z, reflector);
	}



	/**************************GETTER/SETTER********************************/

	public boolean getDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public int[] getAllerRotor() {
		return allerRotor;
	}

	public void setAllerRotor(int[] allerRotor) {
		this.allerRotor = allerRotor;
	}

	public int[] getRetourRotor() {
		return retourRotor;
	}

	public void setRetourRotor(int[] retourRotor) {
		this.retourRotor = retourRotor;
	}

	/***********************END GETTER/SETTER*******************************/

}
