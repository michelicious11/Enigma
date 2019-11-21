import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;

public class Interface {

	private JFrame frame;
	private JTable rotor3;
	private JTable alphabet;
	private JTable rotor1;
	private JTable rotor2;
	private JTable reflector;
	private JTextField amountInput;
	private boolean direction; 
	private Integer[] allerRotor; 
	private Integer[] retourRotor;
	private JTable jTableSelected; 
	private int numInput;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

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

		/**************JText Areas********************/
		JTextArea textAreaDecrypt = new JTextArea();
		textAreaDecrypt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textAreaDecrypt.setBounds(120, 520, 369, 62);
		getFrame().getContentPane().add(textAreaDecrypt);

		JTextArea textAreaEncrypt = new JTextArea();
		textAreaEncrypt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textAreaEncrypt.setBounds(120, 413, 369, 62);
		getFrame().getContentPane().add(textAreaEncrypt);


		/**************BOUTONS RADIOS********************/
		JRadioButton btnDroite = new JRadioButton("Droite", true);
		btnDroite.setBackground(Color.LIGHT_GRAY);
		btnDroite.setBounds(230, 346, 66, 23);
		frame.getContentPane().add(btnDroite);

		JRadioButton btnGauche = new JRadioButton("Gauche", false);
		btnGauche.setBackground(Color.LIGHT_GRAY);
		btnGauche.setBounds(230, 372, 73, 23);
		frame.getContentPane().add(btnGauche);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(btnDroite);
		btnGroup.add(btnGauche);

		/*****************JTextField (input)********************/
		amountInput = new JTextField();
		amountInput.setBounds(309, 358, 40, 23);
		frame.getContentPane().add(amountInput);
		amountInput.setColumns(10);

		/***********DROPDOWN MENU POUR CHOISIR ROTOR*****************/
		String[] rotors = {"   Rotor 1", "   Rotor 2", "   Rotor 3"};
		JComboBox comboBox = new JComboBox(rotors);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBorder(new LineBorder(new Color(171, 173, 179)));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(115, 358, 109, 23);
		frame.getContentPane().add(comboBox);

		/*******************TABLES**********************/
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
		alphabet.setBounds(47, 307, 622, 32);
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
		rotor1.setBounds(47, 228, 622, 50);
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
		rotor2.setBounds(47, 167, 622, 50);
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
		rotor3.setBounds(47, 106, 622, 50);
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
		
		/***************BOUTONS***********************/
		JButton btnConfig = new JButton("Configurer rotor"); //configurer la cle
		btnConfig.setBounds(359, 358, 137, 23);
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				Rotor rotor = new Rotor(); //pour pour avoir acces aux methodes de Rotor
				//recuperer valeur gauche-droite
				if(btnDroite.isSelected()) {
					direction = true; 
				} else if(btnGauche.isSelected()) {
					direction = false; 
				}
				//recuperer valeur input jtextfield
				int montant = checkInt(amountInput.getText()); 
				//recuperer valeur dropdown menu
				int boxChoice = comboBox.getSelectedIndex();
				if(boxChoice == 0) {
					allerRotor = Main.allerRotor1; 
					retourRotor = Main.retourRotor1;
					jTableSelected = rotor1; 
				} else if(boxChoice == 1) {
					allerRotor = Main.allerRotor2; 
					retourRotor = Main.retourRotor2;
					jTableSelected = rotor2; 
				} else if(boxChoice == 2) {
					allerRotor = Main.allerRotor3; 
					retourRotor = Main.retourRotor3;
					jTableSelected = rotor3; 
				}
				//fonction pour decaler rotor
				rotor.returnVector(allerRotor, retourRotor, direction, montant);
				//set new rotor decale
				setNewData(jTableSelected, allerRotor, retourRotor);
			} 
		});
		getFrame().getContentPane().add(btnConfig);


		JButton btnDecrypt = new JButton("Decrypter"); //decrypter
		btnDecrypt.setBounds(498, 542, 125, 23);
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Event to take text from first text area and encrypt it into second text area
				Rotor rotor = new Rotor(); //pour pour avoir acces aux methodes de Rotor
				String mot = textAreaDecrypt.getText().toUpperCase(); //recupere le texte dans le JtextArea + le met en majuscules
				StringBuilder str = new StringBuilder(mot); //pour pour avoir acces aux methodes de StringBuilder
				String text = rotor.parcourirMot(str, Main.getRotor1(), Main.getRotor2(), Main.getRotor3(), Main.getReflector()); 
				textAreaEncrypt.setText(text); //Mets le String (une lettre) dans le JtextArea
			}
		});
		getFrame().getContentPane().add(btnDecrypt);

		JButton btnEncrypt = new JButton("Encrypter"); //encrypter
		btnEncrypt.setBounds(498, 432, 125, 23);
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Event to take text from first text area and encrypt it into second text area
				Rotor rotor = new Rotor(); //pour pour avoir acces aux methodes de Rotor
				String mot = textAreaEncrypt.getText().toUpperCase(); //recupere le texte dans le JtextArea + le met en majuscules
				StringBuilder str = new StringBuilder(mot); //pour pour avoir acces aux methodes de StringBuilder
				String text = rotor.parcourirMot(str, Main.getRotor1(), Main.getRotor2(), Main.getRotor3(), Main.getReflector()); 
				textAreaDecrypt.setText(text); //Mets le String (une lettre) dans le JtextArea
			}
		});
		getFrame().getContentPane().add(btnEncrypt);

		JButton btnEffacer = new JButton("Effacer champs"); //Enlever le texte dans les text area
		btnEffacer.setBounds(158, 486, 125, 23);
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaDecrypt.setText(null);
				textAreaEncrypt.setText(null);
			}
		});
		getFrame().getContentPane().add(btnEffacer);

		JButton btnNext = new JButton("Etape suivante"); //etape suivante de l'encryption
		btnNext.setBounds(314, 486, 125, 23);
		frame.getContentPane().add(btnNext);

		JButton btnCheckKey = new JButton("Visualiser cle"); //remettre les rotors comme au debut
		btnCheckKey.setBounds(499, 358, 125, 23);
		frame.getContentPane().add(btnCheckKey);		
		
		JButton btnReset = new JButton("Reinitialisation"); //voir la cle apres l'avoir configure
		btnReset.setBounds(545, 11, 125, 23);
		btnReset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
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
			rotor1.setBounds(47, 228, 622, 50);
			getFrame().getContentPane().add(rotor1);
			
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
			rotor2.setBounds(47, 167, 622, 50);
			getFrame().getContentPane().add(rotor2);

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
			rotor3.setBounds(47, 106, 622, 50);
			getFrame().getContentPane().add(rotor3);
		} 
	});
		frame.getContentPane().add(btnReset);

		/*****************LABELS**********************/

		JLabel lblReflector = new JLabel("REFLECTEUR");
		lblReflector.setBounds(673, 49, 90, 32);
		getFrame().getContentPane().add(lblReflector);

		JLabel lblRotor = new JLabel("ROTOR 3");
		lblRotor.setLabelFor(rotor3);
		lblRotor.setBounds(673, 124, 73, 32);
		getFrame().getContentPane().add(lblRotor);

		JLabel lblRotor_1 = new JLabel("ROTOR 2");
		lblRotor_1.setLabelFor(rotor2);
		lblRotor_1.setBounds(673, 182, 73, 32);
		getFrame().getContentPane().add(lblRotor_1);

		JLabel lblRotor_2 = new JLabel("ROTOR 1");
		lblRotor_2.setLabelFor(rotor1);
		lblRotor_2.setBounds(673, 239, 73, 32);
		getFrame().getContentPane().add(lblRotor_2);

		JLabel lblCle = new JLabel("CLE");
		lblCle.setBounds(76, 358, 29, 23);
		getFrame().getContentPane().add(lblCle);
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

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
	}
}

