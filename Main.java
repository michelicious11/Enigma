import java.awt.EventQueue;

public class Main extends Interface {

	//Create first rotor arrays (aller and retour)
	static final Integer[] allerRotor1 = {10, 21, 5, -17, 21, -4, 12, 16, 6, -3, 7, -7, 4, 2,
			5, -7, -11, -17, -9, -6, -9, -19, 2, -3, -21, -4};
	static final Integer[] retourRotor1 = {17, 4, 19, 21, 7, 11, 3, -5, 7, 9, -10, 9, 17, 6,
			-6, -2, -4, -7, -12, -5, 3, 4, -21, -16, -2, -21};

	//Create second rotor arrays (aller and retour)
	static final Integer[] allerRotor2 = {3, 17, 22, 18, 16, 7, 5, 1, -7, 16, -3, 8, 2, 9, 2,
			-5, -1, -13, -12, -17, -11, -4, 1, -10, -19, -25};
	static final Integer[] retourRotor2 = {25, 7, 17, -3, 13, 19, 12, 3, -1, 11, 5, -5, -7, 10,
			-2, 1, -2, 4, -17, -8, -16, -18, -9, -1, -22, -16};

	//Create third rotor arrays (aller and retour)
	static final Integer[] allerRotor3 = {1, 16, 5, 17, 20, 8, -2, 2, 14, 6, 2, -5, -12, -10, 9,
			10, 5, -9, 1, -14, -2, -10, -6, 13, -10, -23};
	static final Integer[] retourRotor3 = {12, -1, 23, 10, 2, 14, 5, -5, 9, -2, -13, 10, -2, 
			-8, 10, -6, 6, -16, 2, -1, -17, -5, -14, -9, -20, -10};

	//Create the reflector
	static final Integer[] reflector = {25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1, -1, -3, 
			-5, -7, -9, -11, -13, -15, -17, -19, -21, -23, -25};

	//Create the three rotors to be used
	private static Rotor rotor1 = new Rotor(allerRotor1, retourRotor1);
	private static Rotor rotor2 = new Rotor(allerRotor2, retourRotor2);
	private static Rotor rotor3 = new Rotor(allerRotor3, retourRotor3);


	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Interface window = new Interface();
						window.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
	/****************GETTER/SETTER*********************/
	public static Integer[] getAllerrotor1() {
		return allerRotor1;
	}

	public static Integer[] getRetourrotor1() {
		return retourRotor1;
	}

	public static Integer[] getAllerrotor2() {
		return allerRotor2;
	}

	public static Integer[] getRetourrotor2() {
		return retourRotor2;
	}

	public static Integer[] getAllerrotor3() {
		return allerRotor3;
	}

	public static Integer[] getRetourrotor3() {
		return retourRotor3;
	}

	public static Integer[] getReflector() {
		return reflector;
	}

	public static Rotor getRotor1() {
		return rotor1;
	}


	public static void setRotor1(Rotor rotor1) {
		Main.rotor1 = rotor1;
	}


	public static Rotor getRotor2() {
		return rotor2;
	}


	public static void setRotor2(Rotor rotor2) {
		Main.rotor2 = rotor2;
	}


	public static Rotor getRotor3() {
		return rotor3;
	}


	public static void setRotor3(Rotor rotor3) {
		Main.rotor3 = rotor3;
	}
	/****************END GETTER/SETTER*********************/
} 

