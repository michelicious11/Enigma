import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JInternalFrame;
import javax.swing.JProgressBar;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;

public class Interface {

	private Integer[] rotor1Aller = Main.allerRotor1.clone(); 
	private Integer[] rotor1Retour = Main.retourRotor1.clone();
	private Integer[] rotor2Aller = Main.allerRotor2.clone(); 
	private Integer[] rotor2Retour = Main.retourRotor2.clone();
	private Integer[] rotor3Aller = Main.allerRotor3.clone(); 
	private Integer[] rotor3Retour = Main.retourRotor3.clone();
	private Rotor rotorFirst = new Rotor(rotor1Aller, rotor1Retour); 
	private Rotor rotorSecond = new Rotor(rotor2Aller, rotor2Retour); 
	private Rotor rotorThird = new Rotor(rotor3Aller, rotor3Retour); 
	private JFrame frame;
	private JTable alphabet;
	private JTable rotor1;
	private JTable rotor2;
	private JTable rotor3;
	private JTable reflector;
	private JTextArea encryptArea;
	private JTextArea decryptArea;
	private JTextField amountInput1;
	private JTextField amountInput2;
	private JTextField amountInput3;
	private JRadioButton btnDroite1;
	private JRadioButton btnDroite2;
	private JRadioButton btnDroite3;
	private JRadioButton btnGauche1; 
	private JRadioButton btnGauche2; 
	private JRadioButton btnGauche3; 
	private JComboBox comboBox1; 
	private JComboBox comboBox2; 
	private JComboBox comboBox3; 
	private boolean direction; 
	private Integer[] allerRotor; 
	private Integer[] retourRotor;
	private JTable jTableSelected; 
	private int numInput;
	private int counter = 0; 
	private JComboBox cle1;
	private JComboBox cle2; 
	private JComboBox cle3;
	private JRadioButton gaucheCle1; 
	private JRadioButton gaucheCle2;
	private JRadioButton gaucheCle3;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(Color.LIGHT_GRAY);
		getFrame().setBounds(100, 100, 789, 668);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		decryptArea = new JTextArea();
		decryptArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		decryptArea.setBounds(120, 541, 369, 62);
		getFrame().getContentPane().add(decryptArea);

		encryptArea = new JTextArea();
		encryptArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		encryptArea.setBounds(120, 431, 369, 62);
		getFrame().getContentPane().add(encryptArea);


		/**************BOUTONS RADIOS********************/
		btnDroite1 = new JRadioButton("Droite", true);
		btnDroite1.setBackground(Color.LIGHT_GRAY);
		btnDroite1.setBounds(347, 328, 66, 23);
		frame.getContentPane().add(btnDroite1);

		btnGauche1 = new JRadioButton("Gauche", false);
		btnGauche1.setBackground(Color.LIGHT_GRAY);
		btnGauche1.setBounds(415, 328, 84, 23);
		frame.getContentPane().add(btnGauche1);

		ButtonGroup btnGroup1 = new ButtonGroup();
		btnGroup1.add(btnDroite1);
		btnGroup1.add(btnGauche1);

		btnGauche2 = new JRadioButton("Gauche", false);
		btnGauche2.setBackground(Color.LIGHT_GRAY);
		btnGauche2.setBounds(415, 358, 84, 23);
		frame.getContentPane().add(btnGauche2);

		btnDroite2 = new JRadioButton("Droite", true);
		btnDroite2.setBackground(Color.LIGHT_GRAY);
		btnDroite2.setBounds(347, 358, 66, 23);
		frame.getContentPane().add(btnDroite2);

		ButtonGroup btnGroup2 = new ButtonGroup();
		btnGroup2.add(btnDroite2);
		btnGroup2.add(btnGauche2);

		btnGauche3 = new JRadioButton("Gauche", false);
		btnGauche3.setBackground(Color.LIGHT_GRAY);
		btnGauche3.setBounds(415, 392, 84, 23);
		frame.getContentPane().add(btnGauche3);

		btnDroite3 = new JRadioButton("Droite", true);
		btnDroite3.setBackground(Color.LIGHT_GRAY);
		btnDroite3.setBounds(347, 392, 66, 23);
		frame.getContentPane().add(btnDroite3);

		ButtonGroup btnGroup3 = new ButtonGroup();
		btnGroup3.add(btnDroite3);
		btnGroup3.add(btnGauche3);

		/*****************JTextField (input)********************/
		amountInput1 = new JTextField();
		amountInput1.setColumns(10);
		amountInput1.setBounds(162, 329, 47, 23);
		frame.getContentPane().add(amountInput1);

		amountInput2 = new JTextField();
		amountInput2.setBounds(162, 358, 47, 23);
		frame.getContentPane().add(amountInput2);
		amountInput2.setColumns(10);

		amountInput3 = new JTextField();
		amountInput3.setColumns(10);
		amountInput3.setBounds(162, 392, 47, 23);
		frame.getContentPane().add(amountInput3);

		/***********DROPDOWN MENU POUR CHOISIR ROTOR*****************/
		String[] rotors = {"   Rotor 1", "   Rotor 2", "   Rotor 3"};

		comboBox1 = new JComboBox(rotors);
		comboBox1.setSelectedIndex(0);
		comboBox1.setBorder(new LineBorder(new Color(171, 173, 179)));
		comboBox1.setBackground(Color.WHITE);
		comboBox1.setBounds(219, 328, 109, 23);
		frame.getContentPane().add(comboBox1);

		comboBox2 = new JComboBox(rotors);
		comboBox2.setBackground(Color.WHITE);
		comboBox2.setBorder(new LineBorder(new Color(171, 173, 179)));
		comboBox2.setSelectedIndex(0);
		comboBox2.setBounds(219, 358, 109, 23);
		frame.getContentPane().add(comboBox2);

		comboBox3 = new JComboBox(rotors);
		comboBox3.setSelectedIndex(0);
		comboBox3.setBorder(new LineBorder(new Color(171, 173, 179)));
		comboBox3.setBackground(Color.WHITE);
		comboBox3.setBounds(219, 392, 109, 23);
		frame.getContentPane().add(comboBox3);

		/***************BOUTONS***********************/
		JButton btnConfig1 = new JButton("Configurer");
		btnConfig1.setBounds(518, 328, 103, 23);
		btnConfig1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				decalage(checkInt(amountInput1.getText()), btnDroite1, comboBox1);
			} 
		});
		getFrame().getContentPane().add(btnConfig1);

		JButton btnConfig2 = new JButton("Configurer");
		btnConfig2.setBounds(518, 358, 103, 23);
		btnConfig2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				decalage(checkInt(amountInput2.getText()), btnDroite2, comboBox2);
			} 
		});
		frame.getContentPane().add(btnConfig2);

		JButton btnConfig3 = new JButton("Configurer");
		btnConfig3.setBounds(518, 392, 103, 23);
		btnConfig3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				decalage(checkInt(amountInput3.getText()), btnDroite3, comboBox3);
			} 
		});
		frame.getContentPane().add(btnConfig3);


		JButton btnDecrypt = new JButton("Decrypter");
		btnDecrypt.setBounds(498, 542, 125, 23);
		btnDecrypt.addActionListener(new ActionListener() { //Event to take text from first text area and encrypt it into second text area
			public void actionPerformed(ActionEvent e) {
				decrypter(); 
			}
		});
		getFrame().getContentPane().add(btnDecrypt);

		JButton btnEncrypt = new JButton("Encrypter");
		btnEncrypt.setBounds(498, 432, 125, 23);
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Event to take text from first text area and encrypt it into second text area
				Rotor rotor = new Rotor(); //pour pour avoir acces aux methodes de Rotor
				String lettres = new String(encryptArea.getText().toUpperCase()); 
				String[] str = rotor.readLetters(lettres);
				for(int i = 0; i < str.length; i++) {
					Conversion conversion = new Conversion("numeriquealpha");
					int tempInt = conversion.getValueOfLettre(str[i]);
					String tempStr = rotor.encryption(tempInt, rotorFirst, rotorSecond, rotorThird, Main.getReflector());

					if(i == str.length - 1) {
						decryptArea.append(tempStr);
						encrypter(); 					
					}
				}
			}
		});
		getFrame().getContentPane().add(btnEncrypt);

		JButton btnEffacer = new JButton("Effacer champs");
		btnEffacer.setBounds(162, 507, 125, 23);
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decryptArea.setText(null);
				encryptArea.setText(null);
			}
		});
		getFrame().getContentPane().add(btnEffacer);

		JButton btnReset = new JButton("Reinitialiser"); //voir la cle apres l'avoir configure
		btnReset.setBounds(545, 11, 125, 23);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(amountInput1);
			}
		});
		frame.getContentPane().add(btnReset);

		/*******************TABLE**********************/

		alphabet = new JTable();
		alphabet.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		alphabet.setRowHeight(40);
		alphabet.setModel(new DefaultTableModel(
				new Object[][] {
					{"  A", "  B", "  C", "  D", "  E", "  F", "  G", "  H", "  I", "  J", "  K", "  L", "  M", "  N", "  O", "  P", "  Q", "  R", "  S", "  T", "  U", "  V", "  W", "  X", "  Y", "  Z"},
				},
				new String[] {
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
				}
				));
		alphabet.setBounds(48, 272, 622, 32);
		getFrame().getContentPane().add(alphabet);

		rotor1 = new JTable();
		rotor1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		rotor1.setRowHeight(25);
		rotor1.setModel(new DefaultTableModel(
				new Object[][] {
					{17, 4, 19, 21, 7, 11, 3, -5, 7, 9, -10, 9, 17, 6, -6, -2, -4, -7, -12, -5, 3, 4, -21, -16, -2, -21},
					{10, 21, 5, -17, 21, -4, 12, 16, 6, -3, 7, -7, 4, 2, 5, -7, -11, -17, -9, -6, -9, -19, 2, -3, -21, -4},
				},
				new String[] {
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
				}
				));
		rotor1.setBounds(47, 211, 622, 50);
		getFrame().getContentPane().add(rotor1);

		rotor2 = new JTable();
		rotor2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		rotor2.setRowHeight(25);
		rotor2.setModel(new DefaultTableModel(
				new Object[][] {
					{25, 7, 17, -3, 13, 19, 12, 3, -1, 11, 5, -5, -7, 10, -2, 1, -2, 4, -17, -8, -16, -18, -9, -1, -22, -16},
					{3, 17, 22, 18, 16, 7, 5, 1, -7, 16, -3, 8, 2, 9, 2, -5, -1, -13, -12, -17, -11, -4, 1, -10, -19, -25},
				},
				new String[] {
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
				}
				));
		rotor2.setBounds(47, 150, 622, 50);
		getFrame().getContentPane().add(rotor2);

		rotor3 = new JTable();
		rotor3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		rotor3.setRowHeight(25);
		rotor3.setModel(new DefaultTableModel(
				new Object[][] {
					{12, -1, 23, 10, 2, 14, 5, -5, 9, -2, -13, 10, -2, -8, 10, -6, 6, -16, 2, -1, -17, -5, -14, -9, -20, -10},
					{1, 16, 5, 17, 20, 8, -2, 2, 14, 6, 2, -5, -12, -10, 9, 10, 5, -9, 1, -14, -2, -10, -6, 13, -10, -23},
				},
				new String[] {
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
				}
				));
		rotor3.setBounds(47, 89, 622, 50);
		getFrame().getContentPane().add(rotor3);

		reflector = new JTable();
		reflector.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		reflector.setRowHeight(40);
		reflector.setModel(new DefaultTableModel(
				new Object[][] {
					{"  " + 25, "  " + 23, "  " + 21, "  " + 19, "  " + 17, "  " + 15, "  " + 13, "  " + 11, "  " + 9, "  " + 7, "  " + 5, "  " + 3, "  " + 1,
						"  " + -1, "  " + -3, "  " + -5, "  " + -7, " " + -9, " " + -11, " " + -13, " " + -15, " " + -17, -19, -21, -23, -25},
				},
				new String[] {
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
				}
				));
		reflector.setBounds(47, 46, 622, 32);
		getFrame().getContentPane().add(reflector);


		/*****************LABELS**********************/

		JLabel lblReflector = new JLabel("REFLECTEUR");
		lblReflector.setBounds(673, 49, 90, 32);
		getFrame().getContentPane().add(lblReflector);

		JLabel lblRotor = new JLabel("ROTOR 3");
		lblRotor.setLabelFor(rotor3);
		lblRotor.setBounds(673, 102, 73, 32);
		getFrame().getContentPane().add(lblRotor);

		JLabel lblRotor_1 = new JLabel("ROTOR 2");
		lblRotor_1.setLabelFor(rotor2);
		lblRotor_1.setBounds(673, 160, 73, 32);
		getFrame().getContentPane().add(lblRotor_1);

		JLabel lblRotor_2 = new JLabel("ROTOR 1");
		lblRotor_2.setLabelFor(rotor1);
		lblRotor_2.setBounds(673, 218, 73, 32);
		getFrame().getContentPane().add(lblRotor_2);

		JLabel lblCle = new JLabel("CLE 2");
		lblCle.setBounds(120, 358, 38, 23);
		getFrame().getContentPane().add(lblCle);

		JLabel label_1 = new JLabel("CLE 3");
		label_1.setBounds(120, 392, 38, 23);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("CLE 1");
		label_2.setBounds(120, 328, 38, 23);
		frame.getContentPane().add(label_2);


	}

	public JTable getTable() {
		return rotor3;
	}

	public JFrame getFrame() {
		return frame;
	}


	/*****************FONCTIONS*********************/

	public JTable setNewData(JTable jTable, Integer[] allerRotor, Integer[] retourRotor) {
		jTable.setModel(new DefaultTableModel(
				new Object[][] {
					this.retourRotor = retourRotor,
							this.allerRotor = allerRotor					
				},
				new String[] {
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
				}
				));
		return jTable;
	}

	public int checkInt(String textField) {
		int montant = 0;
		try {
			montant = Integer.parseInt(textField); 

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(frame, "Veuillez entrer un entier valide", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return montant;
	}

	public void reset(JTextField amountInput) {
		amountInput1.setText(null);
		amountInput2.setText(null);
		amountInput3.setText(null);
		btnDroite1.setSelected(true); 
		btnDroite2.setSelected(true);
		btnDroite3.setSelected(true);
		comboBox1.setSelectedIndex(0);
		comboBox2.setSelectedIndex(0);
		comboBox3.setSelectedIndex(0);
		allerRotor = null;
		retourRotor = null; 
		counter = 0; 
		rotor1Aller = Main.allerRotor1.clone(); 
		rotor1Retour = Main.retourRotor1.clone();
		rotor2Aller = Main.allerRotor2.clone(); 
		rotor2Retour = Main.retourRotor2.clone();
		rotor3Aller = Main.allerRotor3.clone(); 
		rotor3Retour = Main.retourRotor3.clone();

		rotorFirst = new Rotor(rotor1Aller, rotor1Retour); 
		rotorSecond = new Rotor(rotor2Aller, rotor2Retour); 
		rotorThird = new Rotor(rotor3Aller, rotor3Retour); 

		setNewData(rotor1, rotor1Aller, rotor1Retour);
		setNewData(rotor2, rotor2Aller, rotor2Retour);
		setNewData(rotor3, rotor3Aller, rotor3Retour);
	}

	public void encrypter() {
		if(counter < 26) {
			decalage(1, btnDroite1, comboBox1);
			counter++;
		} else if(counter >= 26 && counter < 52) {
			decalage(1, btnDroite2, comboBox2);
			counter++;
		} else if(counter >= 52 && counter < 78) {
			decalage(1, btnDroite3, comboBox3);
			counter++;
		} else {
			decalage(1, btnDroite1, comboBox1);
			counter = 1; 
		}
	}

	public void decrypter() {
		Rotor rotor = new Rotor(); //pour pour avoir acces aux methodes de Rotor
		Conversion conversion = new Conversion("numeriquealpha"); //pour pour avoir acces aux methodes de Conversion

		String lettres = new String(decryptArea.getText().toUpperCase());//prendre le texte a decrypter et le mettre en maj
		String[] str = rotor.readLetters(lettres);//mettre le texte dans un array de string
		int strLength = str.length; 
		String[] decryption = new String[strLength]; //array ou mettre message decrypter de meme taille que msg 


		for(int i = 0; i < strLength; i++) {
			encrypter(); 
		}

		determinerCles(comboBox1, comboBox2, comboBox3); //pour savoir avec quelle cle commencer la decryption
		counter = strLength; //dependamment le nombre de lettre, il y a eu meme nombre de tours 
		for(int i = 0; i < strLength; i++) {
			if(counter < 26 || counter >= 78) {
				decalage(1, gaucheCle3, cle3); 
				int tempInt = conversion.getValueOfLettre(str[i]);
				decryption[i] = rotor.encryption(tempInt, rotorFirst, rotorSecond, rotorThird, Main.getReflector());
				counter--;
			} else if(counter < 78 && counter >= 52) {
				decalage(1, gaucheCle2, cle2); 
				int tempInt = conversion.getValueOfLettre(str[i]);
				decryption[i] = rotor.encryption(tempInt, rotorFirst, rotorSecond, rotorThird, Main.getReflector());	
				counter--;
			} else if(counter < 52 && counter >= 26) {
				decalage(1, gaucheCle1, cle1); 
				int tempInt = conversion.getValueOfLettre(str[i]);
				decryption[i] = rotor.encryption(tempInt, rotorFirst, rotorSecond, rotorThird, Main.getReflector());
				counter--;
			}
			System.out.println(counter);
		}
		encryptArea.setText(rotor.convertirArrayEnString(decryption));
	}

	public void decalage(int montant, JRadioButton btnDroite, JComboBox comboBox) {
		Rotor rotor = new Rotor(); //pour pour avoir acces aux methodes de Rotor
		//recuperer valeur gauche-droite
		if(btnDroite.isSelected()) {
			direction = true; 
		} else {
			direction = false; 
		}
		//recuperer valeur input jtextfield
		//recuperer valeur dropdown menu
		int boxChoice = comboBox.getSelectedIndex();
		if(boxChoice == 0) {
			allerRotor = rotor1Aller; 
			retourRotor = rotor1Retour;
			jTableSelected = rotor1; 
		} else if(boxChoice == 1) {
			allerRotor = rotor2Aller; 
			retourRotor = rotor2Retour;
			jTableSelected = rotor2; 
		} else if(boxChoice == 2) {
			allerRotor = rotor3Aller; 
			retourRotor = rotor3Retour;
			jTableSelected = rotor3; 
		}
		//fonction pour decaler rotor
		rotor.returnVector(allerRotor, retourRotor, direction, montant);
		//set new rotor decale
		setNewData(jTableSelected, allerRotor, retourRotor);
	}

	public void determinerCles(JComboBox combo1, JComboBox combo2, JComboBox combo3) {
		switch(combo1.getSelectedIndex()) {
		case 0: 
			cle1 = comboBox1;
			gaucheCle1 = btnGauche1;
			break; 
		case 1: 
			cle2 = comboBox1;
			gaucheCle2 = btnGauche1;
			break;
		case 2: 
			cle3 = comboBox1;
			gaucheCle3 = btnGauche1;
			break;
		}

		switch(combo2.getSelectedIndex()) {
		case 0: 
			cle1 = comboBox2;
			gaucheCle1 = btnGauche2;
			break; 
		case 1: 
			cle2 = comboBox2;
			gaucheCle2 = btnGauche2;
			break;
		case 2: 
			cle3 = comboBox2;
			gaucheCle3 = btnGauche2;
			break;
		}

		switch(combo3.getSelectedIndex()) {
		case 0: 
			cle1 = comboBox3;
			gaucheCle1 = btnGauche3; 
			break; 
		case 1: 
			cle2 = comboBox3;
			gaucheCle2 = btnGauche3;
			break;
		case 2: 
			cle3 = comboBox3;
			gaucheCle3 = btnGauche3;
			break;
		}
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
	}
}

