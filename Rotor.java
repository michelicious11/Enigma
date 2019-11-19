import java.util.Arrays;

public class Rotor {


	//direction: true = right - false = left
	private boolean direction; 
	//the rotors
	private Integer[] allerRotor; 
	private Integer[] retourRotor;
	//pour convertir chiffre a lettre
	Conversion conversion = new Conversion(); 
	Conversion conversion2 = new Conversion("test");
	//StringBuilder str = new StringBuilder(); 

	//Constructor for a rotor
	public Rotor(Integer[] allerRotor, Integer[] retourRotor, boolean direction) {
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
	public int moveDirection(Rotor x, Integer y, boolean z) {
		int move;
		boolean direction = x.checkDirection(); 
		if(direction) {
			move = y%26; 
		} else {
			move = -1 * (y%26); 
		}
		return move; 
	}

	//FONCTIONS POUR ENCRYPTER/DECRYPTER//

	//Makes array circular, s'assure que valeur int reste en 0 et 25
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

	//fonction pour arriver a valeur entier en montant dans les rotors
	public Integer aller(int w, Rotor x, Rotor y, Rotor z) {
		int moveToIndex = w; //w is the index of first rotor
		//System.out.println(moveToIndex);
		if(moveToIndex == 26) {
			return null;
		}
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

	//fonction pour arriver a valeur entier en descendant les rotors
	public Integer retour(int w, Integer[] reflector, Rotor x, Rotor y, Rotor z) {
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

	//fonction pour encrypter en combinant aller et retour
	public String encryption(int w, Rotor x, Rotor y, Rotor z, Integer[] reflector) {
		int moveToIndex = w; 
		Integer valeurAller = aller(moveToIndex, x, y, z);
		if(valeurAller == null) {
			return " "; 
		}
		Integer valeurRetour = retour(valeurAller, reflector, z, y, x);
		String lettre = conversion.getValueOfNbr(valeurRetour);
		System.out.print(lettre);
		return lettre; 
	}

	//fonction pour recueillir les lettres d'un mot
	public String[] readLetters(StringBuilder str) {
		int mot = str.length(); 
		String[] lettres = new String[mot];

		for (int i = 0; i < mot; i++)
		{
			char myChar = str.charAt(i);
			lettres[i] = Character.toString(myChar);
		}
		return lettres; 
	}

	//fonction pour changer les lettres recueillies en chiffres
	public Integer[] convertLetters(String[] lettres) {
		Integer nbrLettres = lettres.length;
		Integer[] numeros = new Integer[nbrLettres]; 
		for(int i = 0; i < nbrLettres; i++) {
			String lettre = lettres[i].toUpperCase();
			Integer numero = conversion2.getValueOfLettre(lettre);
			numeros[i] = numero; 
		}			
		return numeros;
	}

	//recueillir int[] de convertLettre et appliquer encryption dessus
	public String readWord(Integer[] chiffresMot, Rotor x, Rotor y, Rotor z, Integer[] reflector) {
		int longueurMot = chiffresMot.length;
		String[] mot = new String[longueurMot];
		for(int i = 0; i < longueurMot; i++) {
			Integer lettre = chiffresMot[i];
			mot[i] = encryption(lettre, x, y, z, reflector);
		}
		StringBuilder newMot = new StringBuilder();
		for(int j = 0; j < mot.length; j++) {
			newMot.append(mot[j]);
		}
		return newMot.toString();
	}

	//appliquer readLetters, convertLetters et readWord
	public String parcourirMot(StringBuilder str, Rotor x, Rotor y, Rotor z, Integer[] reflector) {
		String[] lettres = readLetters(str);
		Integer[] chiffres = convertLetters(lettres);
		String strArr = readWord(chiffres, x, y, z, reflector);
		return strArr;
	}

	//FONCTIONS POUR LE DECALAGE//

	public void afficherVector(int[] arr, int[] arr2) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(" ");
		for(int j = 0; j < arr2.length; j++) {
			System.out.print(arr2[j] + ", ");
		}

	}

	public void returnVector(int[] arr, int[] arr2, boolean direction, int d) {
		if(direction) {
			rightRotate(arr, d); 
			rightRotate(arr2, d);
		} else {
			leftRotate(arr, d);
			leftRotate(arr2, d);
		}
		afficherVector(arr, arr2); 
	}


	public void leftRotate(int[] arr, int d) { 
		int n = arr.length; 
		for (int i = 0; i < d; i++) 
			leftRotatebyOne(arr); 
	} 

	/*Function to right rotate arr[] of size n by d*/
	public void rightRotate(int arr[], int d) { 
		int n = arr.length;
		for (int i = 0; i < d; i++) 
			rightRotateByOne(arr); 
	} 

	//function needed for leftRotate
	public void leftRotatebyOne(int arr[]) { 
		int n = arr.length; 
		int i, temp; 
		temp = arr[0]; 
		for (i = 0; i < n - 1; i++) 
			arr[i] = arr[i + 1]; 
		arr[i] = temp; 
	} 

	//function needed for rightRotate
	public void rightRotateByOne(int arr[]) {
		int n = arr.length;
		int last = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = last;
	}

	/**************************GETTER/SETTER********************************/

	public boolean getDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public Integer[] getAllerRotor() {
		return allerRotor;
	}

	public void setAllerRotor(Integer[] allerRotor) {
		this.allerRotor = allerRotor;
	}

	public Integer[] getRetourRotor() {
		return retourRotor;
	}

	public void setRetourRotor(Integer[] retourRotor) {
		this.retourRotor = retourRotor;
	}

	/***********************END GETTER/SETTER*******************************/

}
