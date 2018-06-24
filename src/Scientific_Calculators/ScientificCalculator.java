package Scientific_Calculators;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ScientificCalculator {

	private JFrame frmStandardCalculator;
	private JTextField txtDisplay;
	private JTextField jtxtConverts;
	private JTextField jlblConverts;
	double firstnum;
	double secondnum;
	double result;
	String operations;
	String answer;
	
	double foot=3.28084;
	double inch=39.3701;
	double yard=1.09361;
	double mile=0.000621371;
	double[] i = new double[5];
	private JTextField txtConvert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScientificCalculator window = new ScientificCalculator();
					window.frmStandardCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScientificCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStandardCalculator = new JFrame();
		frmStandardCalculator.getContentPane().setBackground(Color.GREEN);
		frmStandardCalculator.setTitle("Standard Calculator");
		frmStandardCalculator.setBounds(100, 100, 363, 468);
		frmStandardCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmStandardCalculator.setJMenuBar(menuBar);		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		
		JMenuItem mntmStandard = new JMenuItem("Standard");
		mntmStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmStandardCalculator.setTitle("Standard Calculator");
				frmStandardCalculator.setBounds(100, 100, 363, 468);
				txtDisplay.setBounds(10, 11, 323, 60);
				txtDisplay.setBackground(Color.cyan);
			}
		});
		mnFile.add(mntmStandard);
		
		JMenuItem mntmScientific = new JMenuItem("Scientific");
		mntmScientific.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmStandardCalculator.setTitle("Scientific Calculator");
				frmStandardCalculator.setBounds(100, 100, 632, 468);
				txtDisplay.setBounds(10, 11, 590, 60);
			}
		});
		mnFile.add(mntmScientific);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		
		JMenuItem mntmUnitConversion = new JMenuItem("Unit Conversion");
		mntmUnitConversion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmStandardCalculator.setTitle("Unit Conversion");
				frmStandardCalculator.setBounds(100, 100, 946, 468);
				txtDisplay.setBounds(10, 11, 590, 60);
			}
		});
		mnFile.add(mntmUnitConversion);
		mnFile.add(mntmExit);
		frmStandardCalculator.getContentPane().setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setBounds(10, 11, 323, 60);
		frmStandardCalculator.getContentPane().add(txtDisplay);
		txtDisplay.setColumns(10);
		
		JButton btnDel = new JButton("\u2190");
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDel.setBorder(new LineBorder(new Color(0,0,0), 1, true));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace = null;
				
				if(txtDisplay.getText().length()>0){
					StringBuilder strB = new StringBuilder((txtDisplay.getText()));
					strB.deleteCharAt(txtDisplay.getText().length()-1);
					backspace=strB.toString();
					txtDisplay.setText(backspace);
				}
			}
		});
		btnDel.setBounds(20, 84, 53, 41);
		frmStandardCalculator.getContentPane().add(btnDel);
		
		JButton btnCE = new JButton("\u0152");
		btnCE.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCE.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDisplay.setText("");
			}
		});
		btnCE.setBounds(85, 84, 118, 41);
		frmStandardCalculator.getContentPane().add(btnCE);
		
		JButton btnPlusMinus = new JButton("\u00B1");
		btnPlusMinus.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPlusMinus.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=ops*(-1);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnPlusMinus.setBounds(215, 84, 53, 41);
		frmStandardCalculator.getContentPane().add(btnPlusMinus);
		
		JButton btnRoot = new JButton("\u221A");
		btnRoot.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRoot.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.sqrt(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnRoot.setBounds(280, 84, 53, 41);
		frmStandardCalculator.getContentPane().add(btnRoot);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iNum=txtDisplay.getText()+btn7.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn7.setBounds(20, 143, 53, 41);
		frmStandardCalculator.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8\r\n");
		btn8.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iNum=txtDisplay.getText()+btn8.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn8.setBounds(85, 143, 53, 41);
		frmStandardCalculator.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn9.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iNum=txtDisplay.getText()+btn9.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn9.setBounds(150, 143, 53, 41);
		frmStandardCalculator.getContentPane().add(btn9);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDiv.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations="/";
			}
		});
		btnDiv.setBounds(215, 143, 53, 41);
		frmStandardCalculator.getContentPane().add(btnDiv);
		
		JButton btnMod = new JButton("%");
		btnMod.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMod.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations="%";
			}
		});
		btnMod.setBounds(280, 143, 53, 41);
		frmStandardCalculator.getContentPane().add(btnMod);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iNum=txtDisplay.getText()+btn4.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn4.setBounds(20, 197, 53, 41);
		frmStandardCalculator.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iNum=txtDisplay.getText()+btn5.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn5.setBounds(85, 197, 53, 41);
		frmStandardCalculator.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iNum=txtDisplay.getText()+btn6.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn6.setBounds(150, 197, 53, 41);
		frmStandardCalculator.getContentPane().add(btn6);
		
		JButton btnMult = new JButton("*");
		btnMult.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMult.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations="*";
			}
		});
		btnMult.setBounds(215, 197, 53, 41);
		frmStandardCalculator.getContentPane().add(btnMult);
		
		JButton btn1x = new JButton("1/x");
		btn1x.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn1x.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn1x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=1/ops;
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btn1x.setBounds(280, 197, 53, 41);
		frmStandardCalculator.getContentPane().add(btn1x);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iNum=txtDisplay.getText()+btn1.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn1.setBounds(20, 251, 53, 41);
		frmStandardCalculator.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iNum=txtDisplay.getText()+btn2.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn2.setBounds(85, 251, 53, 41);
		frmStandardCalculator.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iNum=txtDisplay.getText()+btn3.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn3.setBounds(150, 251, 53, 41);
		frmStandardCalculator.getContentPane().add(btn3);
		
		JButton btnSubt = new JButton("-");
		btnSubt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSubt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations="-";
			}
		});
		btnSubt.setBounds(215, 251, 53, 41);
		frmStandardCalculator.getContentPane().add(btnSubt);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEqual.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String answer;
				secondnum=Double.parseDouble(txtDisplay.getText());
				if (operations=="+")
				{
					result=firstnum+secondnum;
					answer=String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				
				else if (operations=="-")
				{
					result=firstnum-secondnum;
					answer=String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				
				else if (operations=="*")
				{
					result=firstnum*secondnum;
					answer=String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				
				else if (operations=="/")
				{
					result=firstnum/secondnum;
					answer=String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				
				else if (operations=="%")
				{
					result=firstnum%secondnum;
					answer=String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				
				else if (operations=="^")
				{
					result=Math.pow(firstnum, secondnum);
					answer=String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				
			}
		});
		btnEqual.setBounds(280, 251, 53, 95);
		frmStandardCalculator.getContentPane().add(btnEqual);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn0.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum=txtDisplay.getText()+btn0.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn0.setBounds(20, 305, 118, 41);
		frmStandardCalculator.getContentPane().add(btn0);
		
		JButton btnDecimal = new JButton(".");
		btnDecimal.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDecimal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum=txtDisplay.getText()+btnDecimal.getText();
				txtDisplay.setText(iNum);
			}
		});
		btnDecimal.setBounds(150, 305, 53, 41);
		frmStandardCalculator.getContentPane().add(btnDecimal);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPlus.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations="+";
			}
		});
		btnPlus.setBounds(215, 305, 53, 41);
		frmStandardCalculator.getContentPane().add(btnPlus);
		
		JButton btnLog = new JButton("Log");
		btnLog.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLog.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.log(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnLog.setBounds(349, 84, 61, 41);
		frmStandardCalculator.getContentPane().add(btnLog);
		
		JButton btnSin = new JButton("Sin");
		btnSin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSin.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.sin(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnSin.setBounds(414, 84, 61, 41);
		frmStandardCalculator.getContentPane().add(btnSin);
		
		JButton btnSinh = new JButton("Sinh");
		btnSinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSinh.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.sinh(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnSinh.setBounds(479, 84, 61, 41);
		frmStandardCalculator.getContentPane().add(btnSinh);
		
		JButton btnAbs = new JButton("|  |");
		btnAbs.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAbs.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnAbs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.abs(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnAbs.setBounds(548, 84, 57, 41);
		frmStandardCalculator.getContentPane().add(btnAbs);
		
		JButton btnPi = new JButton("\u03C0");
		btnPi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPi.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnPi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops;
				ops=3.14159;
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnPi.setBounds(349, 143, 61, 41);
		frmStandardCalculator.getContentPane().add(btnPi);
		
		JButton btnCos = new JButton("Cos");
		btnCos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCos.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.cos(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnCos.setBounds(414, 143, 61, 41);
		frmStandardCalculator.getContentPane().add(btnCos);
		
		JButton btnCosh = new JButton("Cosh");
		btnCosh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCosh.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.cosh(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnCosh.setBounds(479, 143, 67, 41);
		frmStandardCalculator.getContentPane().add(btnCosh);
		
		JButton btnLnx = new JButton("lnx");
		btnLnx.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLnx.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnLnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.log10(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnLnx.setBounds(548, 143, 57, 41);
		frmStandardCalculator.getContentPane().add(btnLnx);
		
		JButton btnxy = new JButton("x^y");
		btnxy.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnxy.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnxy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum=Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations="^";
			}
		});
		btnxy.setBounds(349, 197, 61, 41);
		frmStandardCalculator.getContentPane().add(btnxy);
		
		JButton btnTan = new JButton("Tan");
		btnTan.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTan.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.tan(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnTan.setBounds(414, 197, 61, 41);
		frmStandardCalculator.getContentPane().add(btnTan);
		
		JButton btnTanh = new JButton("Tanh");
		btnTanh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTanh.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnTanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.tanh(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnTanh.setBounds(479, 197, 67, 41);
		frmStandardCalculator.getContentPane().add(btnTanh);
		
		JButton btnx2 = new JButton("x^2\r\n");
		btnx2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnx2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.pow(ops, 2);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnx2.setBounds(350, 251, 125, 41);
		frmStandardCalculator.getContentPane().add(btnx2);
		
		JButton btnx3 = new JButton("x^3");
		btnx3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnx3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnx3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.pow(ops, 3);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnx3.setBounds(479, 251, 126, 41);
		frmStandardCalculator.getContentPane().add(btnx3);
		
		JButton btnCubeRoot = new JButton("Cbr\r\n");
		btnCubeRoot.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCubeRoot.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCubeRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops=Math.cbrt(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnCubeRoot.setBounds(548, 197, 57, 41);
		frmStandardCalculator.getContentPane().add(btnCubeRoot);
		
		JLabel lblUnitConvertor = new JLabel("Unit Convertor");
		lblUnitConvertor.setFont(new Font("Arial", Font.BOLD, 25));
		lblUnitConvertor.setBounds(676, 30, 239, 41);
		frmStandardCalculator.getContentPane().add(lblUnitConvertor);
		
		JComboBox cbconvert = new JComboBox();
		cbconvert.setFont(new Font("Arial", Font.PLAIN, 20));
		cbconvert.setModel(new DefaultComboBoxModel(new String[] {"Choose one...", "Inch", "Foot", "Yard", "Mile"}));
		cbconvert.setBounds(628, 96, 287, 41);
		frmStandardCalculator.getContentPane().add(cbconvert);
		
		txtConvert = new JTextField();
		txtConvert.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtConvert.setText(null);
			}
		});
		txtConvert.setHorizontalAlignment(SwingConstants.CENTER);
		txtConvert.setText("Enter in metres");
		txtConvert.setFont(new Font("Calibri Light", Font.ITALIC, 17));
		txtConvert.setBounds(628, 169, 287, 48);
		frmStandardCalculator.getContentPane().add(txtConvert);
		txtConvert.setColumns(10);
		
		JLabel lblConvert = new JLabel("");
		lblConvert.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblConvert.setHorizontalAlignment(SwingConstants.CENTER);
		lblConvert.setBounds(628, 251, 287, 41);
		frmStandardCalculator.getContentPane().add(lblConvert);
		
		JButton btnConvert = new JButton("CONVERT");
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double metre=Double.parseDouble(txtConvert.getText());
				if(cbconvert.getSelectedItem().equals("Foot"))
				{
					String cConvert1=String.format("%.3f feet", metre*foot);
					lblConvert.setText(cConvert1);
				}
				else if(cbconvert.getSelectedItem().equals("Inch"))
				{
					String cConvert1=String.format("%.3f Inch", metre*inch);
					lblConvert.setText(cConvert1);
				}
				else if(cbconvert.getSelectedItem().equals("Yard"))
				{
					String cConvert1=String.format("%.3f yard", metre*yard);
					lblConvert.setText(cConvert1);
				}
				else if(cbconvert.getSelectedItem().equals("Mile"))
				{
					String cConvert1=String.format("%.3f miles", metre*mile);
					lblConvert.setText(cConvert1);
				}
			}
		});
		btnConvert.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnConvert.setBounds(648, 320, 118, 41);
		frmStandardCalculator.getContentPane().add(btnConvert);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtConvert.setText(null);
				lblConvert.setText(null);
				cbconvert.setSelectedItem("Choose one...");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnClear.setBounds(778, 320, 108, 41);
		frmStandardCalculator.getContentPane().add(btnClear);
	}
}
