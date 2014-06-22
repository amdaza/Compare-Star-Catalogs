package view;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;








import parser.contents.Program;
import parser.elements.Value;
import parser.elements.Variable;
import parser.errors.TypeException;
import parser.lexical.Lexical;
import parser.syntactic.SyntacticAnalizer;
import view.Catalog;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.FileHandler;

import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;



@SuppressWarnings("unused")
public class Interface extends JFrame{



	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel contentPane;
	/**
	 * @uml.property  name="console"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel console;
	/**
	 * @uml.property  name="panel_2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel panel_2;
	/**
	 * @uml.property  name="panel_4"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel panel_4 ;
	
	/**
	 * @uml.property  name="textFieldP"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField textFieldP;
	/**
	 * @uml.property  name="textCoorP"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField textCoorP;
	/**
	 * @uml.property  name="textRadiusP"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField textRadiusP;
	/**
	 * @uml.property  name="textFieldS"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField textFieldS;
	/**
	 * @uml.property  name="textRadiusS"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField textRadiusS;
	
	/**
	 * @uml.property  name="table"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTable table;

	/**
	 * @uml.property  name="tableModel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private DefaultTableModel tableModel;
	
	/**
	 * @uml.property  name="textAreaFilterP"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextArea textAreaFilterP;
	/**
	 * @uml.property  name="textAreaFilterS"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextArea textAreaFilterS;
	/**
	 * @uml.property  name="textAreaCriteriumS"
	 * @uml.associationEnd  readOnly="true"
	 */
	private JTextArea textAreaCriteriumS;
	/**
	 * @uml.property  name="textAreaCriteriumErrors"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextArea textAreaCriteriumErrors;
	/**
	 * @uml.property  name="textAreaConsole"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextArea textAreaConsole;
	
	/**
	 * @uml.property  name="btnButtonLoad"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnButtonLoad;
	/**
	 * @uml.property  name="btnStart"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnStart;
	/**
	 * @uml.property  name="btnButtonFilter"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton btnButtonFilter ;
	
	/**
	 * @uml.property  name="mntmAbout"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JMenuItem mntmAbout;
	
	/**
	 * @uml.property  name="open"
	 */
	private boolean open=false;
	/**
	 * @uml.property  name="open2"
	 */
	private boolean open2=false;
	/**
	 * @uml.property  name="load"
	 */
	private boolean load;
	
	/**
	 * @uml.property  name="filFichero"
	 */
	private String filFichero;
	/**
	 * @uml.property  name="path"
	 */
	private String path;
	/**
	 * @uml.property  name="timeStamp"
	 */
	private String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	/**
	 * @uml.property  name="botones" multiplicity="(0 -1)" dimension="1"
	 */
	private String [] botones = { " Catalog P", " Catalog S"};
	/**
	 * @uml.property  name="botones2" multiplicity="(0 -1)" dimension="1"
	 */
	private String [] botones2 = {"Example", "Aceptar"};
	private String [] botones1 = { "Aceptar"};
	private static Catalog Info;	
	
	/**
	 * @uml.property  name="primaryData"
	 * @uml.associationEnd  
	 */
	private DescriptionData primaryData;
	/**
	 * @uml.property  name="arraySecondaryData"
	 */
	private Vector<DescriptionData> arraySecondaryData;

	/**
	 * @uml.property  name="folderSession"
	 */
	private File folderSession;
	/**
	 * @uml.property  name="fileLog"
	 */
	private File fileLog;
	
	private static FileHandler fh;
	//private static Logger log =null;// Logger.getLogger(Interface.class.getName());
	
	private static int linesNumber=0;
	private static int linesNumber2=0;
	private static int tabCounter = 0;
	/**
	 * @uml.property  name="bw"
	 */
	private   BufferedWriter bw = null;
	/**
	 * @uml.property  name="icono"
	 * @uml.associationEnd  readOnly="true"
	 */
	private ImageIcon icono;
	
	private Program parserCatalogP;
	private Program parserCatalogS;
	private Program parserCriteriumErrors;
	private JCheckBox chckbxOneToOne;
	private JCheckBox chckbxShowClosestCandidate;
	
	
	
	/**
	 * Create the frame.
	 */
	public Interface() {
		
		setFont(new Font("Calibri", Font.BOLD, 28));
		setTitle("Compare Catalog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1190, 670);
		setEnabled(true);
		load=false;
		validate();
		setLocationRelativeTo(null);
		Info = new Catalog();	
		//log=  Logger.getLogger("");
		/*try {
			//URL url = Loader.getResource("log4j.properties");
			//PropertyConfigurator.configure(url);
			//"[%p] [%c] %d{dd.MM.yyyy/HH:mm:ss} ===> %m%n"
			//String ruta="C:/Users/Delegacion01/Desktop/Rosa";	
			PatternLayout defaultLayout = new PatternLayout("%n%d{yyyy-MM-dd HH:mm:ss} [%-5p]  ===> %m%n");					
			RollingFileAppender rollingFileAppender = new RollingFileAppender();
			try {
				rollingFileAppender.setFile("fileLog.log",true, false, 0);
				
			} catch (IOException e1) {
				//log.log(Level.ERROR,e1.toString());
				e1.printStackTrace();
			}
			rollingFileAppender.setLayout(defaultLayout);
			//log.addAppender(rollingFileAppender);
			//log.info("Log created");
		   
		} catch (SecurityException e2) {			
			e2.printStackTrace();
		} */
			 
		contentPane = new JPanel();
		contentPane.setForeground(new Color(146, 208,80));
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Export");
		mnFile.setMnemonic(KeyEvent.VK_E);
		mnFile.setFont(new Font("Calibri", Font.BOLD, 15));
		
		menuBar.add(mnFile);
		
		JMenuItem mntmOpenSession = new JMenuItem("Open Session");
		mntmOpenSession.addActionListener(new ActionListener() {			

			public void actionPerformed(ActionEvent arg0) {
				folderSession = new File (path);
				folderSession.mkdir();	
				
				JFileChooser seleccion = new JFileChooser(folderSession);
				int i = seleccion.showOpenDialog(Interface.this);
				int k=0;
				if (i == 0){
					textFieldP.setText(null);
					textCoorP.setText(null);
					textRadiusP.setText(null);
					textFieldS.setText(null);
					textRadiusS.setText(null);
					textAreaFilterP.setText(null);
					textAreaFilterS.setText(null);
					textAreaCriteriumErrors.setText(null);					
					
					clearTable();					
					String fichero =seleccion.getSelectedFile().getAbsolutePath();
					Scanner sc = null;
					try{
						

						sc = new Scanner(new File(fichero));
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();			
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();			
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();
							String[] array = filFichero.split(":");
							String s = array[1].substring(1);
							textFieldP.setText(s);	
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();
							String[] array = filFichero.split(":");
							String s = array[1].substring(1);
							textCoorP.setText(s);
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();
							String[] array = filFichero.split(":");
							String s = array[1].substring(1);
							textRadiusP.setText(s);	
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();
							String[] array = filFichero.split(":");
							String s = array[1].substring(1);
							textFieldS.setText(s);
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();
							String[] array = filFichero.split(":");
							String s = array[1].substring(1);
							textRadiusS.setText(s);
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();			
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();			
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();			
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();	
						}	
						while(sc.hasNextLine() && !((filFichero=sc.nextLine()).equals("Catalog S:"))){
							textAreaFilterP.append(filFichero+"\n");							
						}
						while(sc.hasNextLine() && !((filFichero=sc.nextLine()).equals("************  Criterium for detecting errors  ************"))){
							textAreaFilterS.append(filFichero+"\n");
						}
						if(sc.hasNextLine()){
							filFichero=sc.nextLine();		
						}						
						while(sc.hasNextLine()){
							filFichero=sc.nextLine();	
							textAreaCriteriumErrors.append(filFichero+"\n");
						}
							
					}					
					catch (FileNotFoundException ex){
						//log.log(Level.ERROR, "File not found");
						System.out.println("File not found");
					}
					 
					sc.close();
					createTable();
				}
				
			}
			
			
		});
		
		mntmOpenSession.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFile.add(mntmOpenSession);
		
		JMenuItem mntmSaveSession = new JMenuItem("Save Session");
		mntmSaveSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				folderSession = new File(path.concat("/Session"));
				folderSession.mkdir();
				FileOutputStream f = null;
				try {
					f = new FileOutputStream(folderSession+ "\\"+timeStamp +".txt");
					//log.info("Session Created");
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				PrintWriter fileExit =null;	
				fileExit = new PrintWriter(f);
				fileExit.println("************  Catalog Selection  ************\n");
				fileExit.println("Catalog P: "+textFieldP.getText());
				fileExit.println("Coordinates of Catalog P: "+textCoorP.getText());
				fileExit.println("Radius (\"): "+textRadiusP.getText());
				fileExit.println("Catalog S: "+textFieldS.getText());
				fileExit.println("Radius around each P star (\"): "+textRadiusS.getText());
				
				fileExit.println("\n************  Filters  ************\n");
				fileExit.println("Catalog P:");
				fileExit.println(textAreaFilterP.getText());
				fileExit.println("\nCatalog S:");
				fileExit.println(textAreaFilterS.getText());			
				
				fileExit.println("\n************  Criterium for detecting errors  ************\n");
				fileExit.println(textAreaCriteriumErrors.getText());
				fileExit.close();
				
			}

		});
		mntmSaveSession.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFile.add(mntmSaveSession);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int response = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    if (response == JOptionPane.NO_OPTION) {
				    } else if (response == JOptionPane.YES_OPTION) {
				      System.exit(0);
				    } else if (response == JOptionPane.CLOSED_OPTION) {
				    }
			}
		});
		mntmExit.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFile.add(mntmExit);
		
		JMenu mnFu = new JMenu("Functions for filter");
		mnFu.setMnemonic(KeyEvent.VK_F);
		mnFu.setFont(new Font("Calibri", Font.BOLD, 14));
		menuBar.add(mnFu);
		
		JMenuItem mntmAbsolute = new JMenuItem("abs");
		mntmAbsolute.setToolTipText("Calculates the absolute value of a number");
		mntmAbsolute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("abs", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)
					textAreaFilterS.insert("abs", textAreaFilterS.getCaretPosition());
				if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmAbsolute.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmAbsolute);
		
		JMenuItem mntmArccosd = new JMenuItem("arccosd");
		mntmArccosd.setToolTipText("Calculates the arccosine of a decimal number");
		mntmArccosd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("arccosd", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)					
					textAreaFilterS.insert("arccosd", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmArccosd.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmArccosd);
		
		JMenuItem mntmArccoss = new JMenuItem("arccoss");
		mntmArccoss.setToolTipText("Calculates the arccosine of a sexagesimal number");
		mntmArccoss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("arccoss", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)					
					textAreaFilterS.insert("arccoss", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmArccoss.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmArccoss);
		
		JMenuItem mntmArcsind = new JMenuItem("arcsind");
		mntmArcsind.setToolTipText("Calculates the arcsine of a decimal number");
		mntmArcsind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("arcsind", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)					
					textAreaFilterS.insert("arcsind", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmArcsind.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmArcsind);
		
		JMenuItem mntmArcsins = new JMenuItem("arcsins");
		mntmArcsins.setToolTipText("Calculates the arcsine of a sexagesimal number");
		mntmArcsins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("arcsins", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)					
					textAreaFilterS.insert("arcsins", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmArcsins.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmArcsins);
		
		JMenuItem mntmArctand = new JMenuItem("arctand");
		mntmArctand.setToolTipText("Calculates the arctangent of a decimal number");
		mntmArctand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("arctand", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)					
					textAreaFilterS.insert("arctand", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmArctand.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmArctand);
		
		JMenuItem mntmArctans = new JMenuItem("arctans");
		mntmArctans.setToolTipText("Calculates the arctangent of a sexagesimal number");
		mntmArctans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("arctans", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)							
					textAreaFilterS.insert("arctans", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmArctans.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmArctans);
		
		JMenuItem mntmCosd = new JMenuItem("cosd");
		mntmCosd.setToolTipText("Calculates the cosine of a decimal number");
		mntmCosd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("cosd", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)						
					textAreaFilterS.insert("cosd", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmCosd.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmCosd);
		
		JMenuItem mntmCoss = new JMenuItem("coss");
		mntmCoss.setToolTipText("Calculates the cosine of a sexagesimal number");
		mntmCoss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("coss", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)						
					textAreaFilterS.insert("coss", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmCoss.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmCoss);
		
		JMenuItem mntmDist = new JMenuItem("dist");
		mntmDist.setToolTipText("Calculate distance between two stars");
		mntmDist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("dist", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)						
					textAreaFilterS.insert("dist", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmDist.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmDist);
		
		JMenuItem mntmDecToSexaDecl = new JMenuItem("DecToSexaDecl");
		mntmDecToSexaDecl.setToolTipText("Pass a decimal number to sexagesimal (declination)");
		mntmDecToSexaDecl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("d2sdec", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)						
					textAreaFilterS.insert("d2sdec", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
				
			}
		});
		mntmDecToSexaDecl.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmDecToSexaDecl);
		
		JMenuItem mntmDectosexara = new JMenuItem("DecToSexaRa");
		mntmDectosexara.setToolTipText("Pass a decimal number to sexagesimal (right ascension)");
		mntmDectosexara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("d2sra", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)						
					textAreaFilterS.insert("d2sra", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmDectosexara.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmDectosexara);		
		
		
		JMenuItem mntmSexaToDec = new JMenuItem("SexaToDec");
		mntmSexaToDec.setToolTipText("Pass a sexagesimal number to decimal");
		mntmSexaToDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("s2d", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)						
					textAreaFilterS.insert("s2d", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmSexaToDec.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmSexaToDec);
		
		JMenuItem mntmSind = new JMenuItem("sind");
		mntmSind.setToolTipText("Calculates the sine of a decimal number");
		mntmSind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("sind", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)						
					textAreaFilterS.insert("sind", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmSind.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmSind);
		
		JMenuItem mntmSins = new JMenuItem("sins");
		mntmSins.setToolTipText("Calculates the sine of a sexagesimal number");
		mntmSins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("sins", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)						
					textAreaFilterS.insert("sins", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmSins.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmSins);
		
		JMenuItem mntmTand = new JMenuItem("tand");
		mntmTand.setToolTipText("Calculates the tangent of a decimal number");
		mntmTand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("tand", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)						
					textAreaFilterS.insert("tand", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmTand.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmTand);
		
		JMenuItem mntmTans = new JMenuItem("tans");
		mntmTans.setToolTipText("Calculates the tangent of a sexagesimal number");
		mntmTans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog (null, 
						"Choose to insert a TextArea", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, botones, botones[0]);
				if (response == JOptionPane.YES_OPTION)
					textAreaFilterP.insert("tans", textAreaFilterP.getCaretPosition());
				else if (response == JOptionPane.NO_OPTION)						
					textAreaFilterS.insert("tans", textAreaFilterS.getCaretPosition());
				else if (response == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmTans.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnFu.add(mntmTans);
		
		JMenu mnNewMenu = new JMenu("Parser");					
		mnNewMenu.setFont(new Font("Calibri", Font.BOLD, 14));
		mnNewMenu.setMnemonic(KeyEvent.VK_P);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmGrammar = new JMenuItem("Grammar");		
		mntmGrammar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				f.setForeground(new Color(154,200,153));
				JTextArea text = new JTextArea();
				text.setEditable(false);
				text.setBounds(50, 50, 500, 500);
				text.setForeground(new Color(0,102,102));
				text.setText("Rule 1:	program → (statement ';' )* \n"+
						"Rule 2:	statement → filter | binding\n"+
						"Rule 3:	binding→ id ':=' Exp0\n"+
						"Rule 4:	filter → '#' Exp0 | binding\n"+
						"Rule 5:	Exp0 → Exp1\n"+
						"Rule 6:	Exp0 → Exp1 op_log Exp1\n"+
						"Rule 7:	Exp1 → Exp2 | Exp2 op_eq Exp1 \n"+
						"Rule 8:	Exp2 → Exp3 | Exp3 op_rel Exp2\n"+
						"Rule 9:	Exp3 → Exp4 | dist ‘(’ Exp4 ‘,’ Exp4 ‘,’ Exp4 ‘,’ Exp4 ‘)’ | abs ‘(’ Exp4 ‘)’\n"+
						"            	| sind ‘(’ Exp4 ‘)’ | cosd ‘(’ Exp4 ‘)’ | sins ‘(’ Exp4 ‘)’|coss ‘(’ Exp4 ‘)’\n"+
						"           	| tans ‘(’ Exp4 ‘)’ | tand ‘(’ Exp4 ‘)’ | arcsins ‘(’ Exp4 ‘)’ |\n"+
						"            	| arcsind‘(’ Exp4 ‘)’ | arccoss ‘(’ Exp4 ‘)’ | arccosd ‘(’ Exp4 ‘)’ | arctans ‘(’ Exp4 ‘)’ | arctand ‘(’ Exp4 ‘)’\n"+
						"            	| s2d ‘(’ Exp4 ‘)’ | d2sra‘(’ Exp4 ‘)’ | d2sdec'(' Exp4 ')' \n"+																 
						"Rule 10:	Exp4 → Exp5 | Exp5 op_adit Exp4\n"+
						"Rule 11:	Exp5 → Exp6 | Exp6 op_mult Exp5 \n"+
						"Rule 12:	Exp6 → Exp7 | Exp7 ^ Exp6\n"+
						"Rule 13:	Exp7 → neg Exp5 | men Exp5 | numbers | booleans | strings | ( Exp0 ) | QFieldName | id | binding | IfExpr \n"+						
						"Rule 14:	IFExpr→ 'if' Exp0 'then'  Exp0 'else' Exp0\n"+
						"Rule 15:	op_adit → + | -\n"+
						"Rule 16:	op_mult → * | / | div | mod\n"+
						"Rule 17:	op_rel →   '>' | '<' | '>=' | '<='\n"+
						"Rule 18:	op_eq → = | <>\n"+
						"Rule 19:	op_log → and | or \n"+
						"Rule 20:	neg → not\n"+
						"Rule 21:	men → -\n" +
						"Rule 22:	QFieldName → [ ‘p’ | ‘s’ ] ‘.’ id [‘?’]\n"+
						"Rule 23:	id  → l ( l | d | _ )\n"+
						"Rule 24:	numbers→ integers | reals | exponentials\n"+
						"Rule 25:	integers→ [ + | - ] d d*\n" +
						"Rule 26:	reals → [ + | - ] d d* [.d d*]\n"+
						"Rule 27:	exponentials → [ + | - ] d d* [.d d*] ‘e’ ( ‘-’ | ‘+’ ) d d*\n"+
						"Rule 28:	strings → ‘“‘ [ s | l | d ]* ‘“’\n"+
						"Rule 29:	booleans → true | false\n");				
				
				f.setBounds(100, 100, 700, 570);
				f.setVisible(true);
				f.setTitle("Detailed Grammar ");
				f.getContentPane().add(text);

				
			}
		});
		mntmGrammar.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnNewMenu.add(mntmGrammar);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Lexical");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame f = new JFrame();	
				f.setForeground(new Color(154,200,153));
				JTextArea text = new JTextArea();
				text.setEditable(false);
				text.setBounds(100, 100, 700, 700);
				text.setForeground(new Color(0,102,102));
				text.setText(" "+"\n	s → ‘ ‘ | ‘(‘ | ‘)’ | ‘_’ | ‘+’ | ‘-’ | ‘;‘ | ‘*’ | ‘/’ | ‘<’ | ‘>’| ‘=’ | ‘,’ | ‘:’  | ‘#’  | ‘“’  | ‘?’\n"+
						"	d  → 0 | … | 9\n"+
						"	l  → a | … | z | A | ... |  Z \n"+
						"	delim → ‘ ‘ | ‘(‘ | ‘)’ | EOL | EOF | TAB | ‘+’ | ‘-’ | ‘;’ | ‘:’ | ‘*’ | ‘/’ | ‘div’ | ‘mod’ | ‘<’ | ‘>’ | ‘=’ | ‘,’ | ‘#’ | ‘“’ | ‘?’");
				
				
				f.setBounds(100, 100, 670, 160);
				f.setVisible(true);
				f.setTitle("Detailed Lexical ");
				f.getContentPane().add(text);
				
				
			}
		});
		mntmNewMenuItem_14.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_14);
		
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic(KeyEvent.VK_H);
		mnHelp.setFont(new Font("Calibri", Font.BOLD, 15));
		menuBar.add(mnHelp);
		
		JMenuItem mntmCatalogSelection = new JMenuItem("Catalog Selection");
		mntmCatalogSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reponse = JOptionPane.showOptionDialog(null,"The two catalogs to be compared. Usually WDS and another VizieR catalog \n\n"+
							"a) Catalog P:  The VizieR identifier of the primary catalog with which to compare. By default WDS. \n"+
							"b) Catalog S:  The VizieR identifier of secondary catalog.\n"+
							"c) Catalog P:  Coordinates and Radius(''):\n"+
								"           Consider only P stars within these coordinates and radius (interpreted in seconds)\n"+
								"           If the user writes ALL in the coordinates field, then the whole catalog is considered.\n"+
							"d) Catalog S:  Radius(''): \n"
								+"          For each P star, consider only S stars within the given radius (interpreted in seconds).\n"+
								"           In the case of WDS we consider that each WDS row contains in fact two stars: the primary and the secondary.\n"+
								"           Therefore, the system will look for S stars around the primary, and also for S stars around the secondary. \n"+
							"e) The button load consults VizieR loading internally the data","Information Catalog Selection",
						    JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botones2,botones[0]);
				if (reponse == JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null,"","Example Catalog Selection",JOptionPane.PLAIN_MESSAGE,new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Selection.jpg"))));
					if(reponse==JOptionPane.YES_OPTION){						
					}	
				}
				if (reponse == JOptionPane.CLOSED_OPTION) {  }
			}
		});
		mntmCatalogSelection.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnHelp.add(mntmCatalogSelection);
		
		JMenuItem mntmCatalogDescription = new JMenuItem("Catalog Description");
		mntmCatalogDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				int response = JOptionPane.showOptionDialog (null,"a) Catalog P: Label of each column in catalog. P \n"+
						"     If the primary catalog is WDS, this column additionally includes the coordinates for B star.\n"+
					"b) Catalog S: Label of each column in catalog S.\n"+
						"     This information is obtained automatically from VizieR by the application"
					  + "     (except the coordinates of the secondary star in the case of WDS,\n"
					  + "     which are computed from the primary coordinates, the last separation and the last PA in the catalog).\n"+
					    "     The names of the fields are used in the rest of the application.\n","Information Catalog Description",
					    JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botones2,botones[0]);
				if (response == JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null,"","Example Catalog Description",JOptionPane.PLAIN_MESSAGE,new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Description.jpg"))));
					if(response==JOptionPane.YES_OPTION){						
					}	
				}
				if (response == JOptionPane.CLOSED_OPTION) {  }
				
				
			}
		});
		mntmCatalogDescription.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnHelp.add(mntmCatalogDescription);
		
		JMenuItem mntmFilters = new JMenuItem("Filters");
		mntmFilters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int response= JOptionPane.showOptionDialog(null,
						"a) Catalog P: \n"
					+  "          In this field, you can apply filters for selecting P rows (before comparing).\n"
					+   "b) Catalog S: \n"
					+   "         In this one, you can apply filters for selecting S rows (before comparing too). \n","Information Filters",
					 JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botones2,botones[0]);
						if (response == JOptionPane.YES_OPTION){
							JOptionPane.showMessageDialog(null,"","Example Filters",JOptionPane.PLAIN_MESSAGE,new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Filter.jpg"))));
							if(response==JOptionPane.YES_OPTION){						
							}	
						}
						if (response == JOptionPane.CLOSED_OPTION) {  }	
			
			}
			
		});
		mntmFilters.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnHelp.add(mntmFilters);
		
		JMenuItem mntmCriterionForDetecting = new JMenuItem("Criterium for detecting errors");
		mntmCriterionForDetecting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog(null,
						" Here, you can define in which case you want the program to detect some error. \n"					
				    +   " The One to One check-box indicates that the WDS star must be selected only if after the previous criterium\n"
					+   " (the selection of S rows) only one row remains for the star.\n"
				    +   " The second check-box 'Show Closest Candidate' is used when the previous check-box is not selected,\n"
					+   " that is several S candidates are allowed, but we only want to select the closest one (in terms of distance).\n","Information Criterium for detecting errors",
					 JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botones2,botones[0]);
				if (response == JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null,"","Example Criterium for detecting errors",JOptionPane.PLAIN_MESSAGE,new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/CriteriumErrors.jpg"))));
					if(response==JOptionPane.YES_OPTION){}	
				}
				if (response == JOptionPane.CLOSED_OPTION) {}	

			}
		});
		mntmCriterionForDetecting.setFont(new Font("Calibri", Font.PLAIN, 14));
		mnHelp.add(mntmCriterionForDetecting);
		
		JSeparator separator_1 = new JSeparator();
		mnHelp.add(separator_1);
		
		
		mnHelp.add(getMenuAbout());
		
		path =  System.getProperty("user.dir");
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 144, 967, 167);
		panel.setForeground(new Color(146, 208,80));
		panel.setBackground(new Color(0, 102, 102));
		panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51),3), "Filters", 
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 20), new java.awt.Color(255, 153, 51)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_5 = new JLabel("Catalog P");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_5.setBounds(41, 24, 58, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Catalog S");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_6.setBounds(437, 24, 111, 14);
		panel.add(label_6);	
		
		
		ButtonListener o = new ButtonListener();
		
		btnButtonFilter = new JButton("Filter");
		btnButtonFilter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnButtonFilter.setFont(new Font("Calibri", Font.BOLD, 14));
		btnButtonFilter.addActionListener(o);
		btnButtonFilter.setBounds(857, 65, 89, 23);
		panel.add(btnButtonFilter);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(41, 47, 360, 100);
		panel.add(scrollPane_4);
		
		textAreaFilterP = new JTextArea();		
		textAreaFilterP.setBounds(41, 47, 360, 100);
		textAreaFilterP.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaFilterP.setLineWrap(true);
		scrollPane_4.setViewportView(textAreaFilterP);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(437, 47, 360, 100);
		panel.add(scrollPane_5);
		
		textAreaFilterS = new JTextArea();
		textAreaFilterS.setBounds(437, 47, 360, 100);
		textAreaFilterS.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaFilterS.setLineWrap(true);
		scrollPane_5.setViewportView(textAreaFilterS);
		
		
	
		
		panel_2 = new JPanel();
		panel_2.setBounds(5, 11, 967, 133);		
		panel_2.setForeground(new Color(146, 208,80));
		panel_2.setBackground(new Color(0, 102, 102));
		panel_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51),3), "Catalog Selection", 
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 20), new java.awt.Color(255, 153, 51)));
		panel_2.setLayout(null);
		contentPane.add(panel_2);
		
		JLabel label = new JLabel("Catalog P");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Calibri", Font.PLAIN, 15));
		label.setBounds(20, 50, 69, 14);
		panel_2.add(label);
		
		textFieldP = new JTextField();
		textFieldP.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textFieldP.setColumns(10);
		textFieldP.setBounds(20, 75, 86, 20);
		panel_2.add(textFieldP);	
		
		
		textCoorP = new JTextField();
		textCoorP.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textCoorP.setColumns(10);
		textCoorP.setBounds(134, 75, 221, 20);
		panel_2.add(textCoorP);
		
		textRadiusP = new JTextField();
		textRadiusP.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textRadiusP.setColumns(10);
		textRadiusP.setBounds(353, 75, 86, 20);
		panel_2.add(textRadiusP);
		
		JLabel label_11 = new JLabel("Coordinates of Catalog P");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_11.setBounds(134, 50, 162, 14);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel("Radius (\")");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_12.setBounds(356, 50, 65, 14);
		panel_2.add(label_12);
		
		JLabel label_13 = new JLabel("Catalog S");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_13.setBounds(481, 50, 58, 14);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Radius around each P star (\") ");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_14.setBounds(610, 50, 195, 14);
		panel_2.add(label_14);
		
		
		
		btnButtonLoad = new JButton("Load");
		btnButtonLoad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));				
		btnButtonLoad.setFont(new Font("Calibri", Font.BOLD, 15));
		btnButtonLoad.addActionListener(o);
		btnButtonLoad.setBorderPainted(true);
		btnButtonLoad.setBounds(852, 74, 89, 23);
		panel_2.add(btnButtonLoad);		
		
		
		textFieldS = new JTextField();
		textFieldS.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textFieldS.setColumns(10);
		textFieldS.setBounds(481, 75, 86, 20);
		panel_2.add(textFieldS);
		
		textRadiusS = new JTextField();
		textRadiusS.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textRadiusS.setColumns(10);
		textRadiusS.setBounds(610, 75, 207, 20);
		panel_2.add(textRadiusS);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 312, 967, 150);
		panel_3.setForeground(new Color(146, 208,80));
		panel_3.setBackground(new Color(0, 102, 102));
		panel_3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51),3), "Criterium for detecting errors", 
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 20), new java.awt.Color(255, 153, 51)));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		chckbxOneToOne = new JCheckBox("One to One");
		chckbxOneToOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//log.info("Pin to One to One");
				chckbxShowClosestCandidate.setSelected(false);
				
			}
		});
		chckbxOneToOne.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxOneToOne.setForeground(Color.WHITE);
		chckbxOneToOne.setBackground(new Color(0, 102, 102));	
		chckbxOneToOne.setBounds(779, 31, 146, 23);
		panel_3.add(chckbxOneToOne);
		
		chckbxShowClosestCandidate = new JCheckBox("Show Closest Candidate");
		chckbxShowClosestCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//log.info("Pin to Show Closest Candidate");
				chckbxOneToOne.setSelected(false);
				
			}
		});
		chckbxShowClosestCandidate.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxShowClosestCandidate.setBounds(779, 57, 177, 26);
		chckbxShowClosestCandidate.setForeground(Color.WHITE);
		chckbxShowClosestCandidate.setBackground(new Color(0, 102, 102));
		panel_3.add(chckbxShowClosestCandidate);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(23, 31, 700, 100);
		panel_3.add(scrollPane_3);
		
		textAreaCriteriumErrors = new JTextArea();
		textAreaCriteriumErrors.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaCriteriumErrors.setBounds(23, 31, 733, 216);		
		textAreaCriteriumErrors.setLineWrap(true);
		scrollPane_3.setViewportView(textAreaCriteriumErrors);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(779, 103, 89, 23);
		panel_3.add(btnStart);
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStart.setFont(new Font("Calibri", Font.BOLD, 15));
		btnStart.addActionListener(o);
		btnStart.setBorderPainted(true);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(980, 0, 193, 600);
		panel_4.setForeground(new Color(153, 200,153));
		panel_4.setBackground(new Color(153, 200, 153));	
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_2 = new JLabel("Catalog P");
		label_2.setForeground(new Color(0, 102, 102));
		label_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_2.setBounds(10, 60, 69, 14);
		label_2.setBackground(new Color(0, 102, 102));
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("Catalog S");
		label_3.setForeground(new Color(0, 102, 102));
		label_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_3.setBounds(125, 60, 58, 14);
		label_3.setBackground(new Color(0, 102, 102));
		panel_4.add(label_3);
		
		JLabel lblNewLabel = new JLabel("Catalog Description");
		lblNewLabel.setForeground(new Color(0, 102, 102));
		lblNewLabel.setBackground(new Color(0, 102, 102));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 173, 24);
		panel_4.add(lblNewLabel);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableModel = new DefaultTableModel(
				new Object[][] {
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
					},
					new String [] {
						"New column", "New column"
					});	
		table.setModel(tableModel);
		table.setBounds(10, 85, 173, 480);
		table.setBackground(new Color(154, 200, 153));
		panel_4.add(table);		
		
		console = new JPanel();
		console.setBounds(5, 461, 967, 139);
		console.setForeground(new Color(146, 208,80));
		console.setBackground(new Color(0, 102, 102));
		console.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51),3), "Console", 
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 20), new java.awt.Color(255, 153, 51)));
		contentPane.add(console);		
		console.setLayout(null);
		
		JScrollPane scrollPaneConsole = new JScrollPane();
		scrollPaneConsole.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneConsole.setBounds(23, 31, 850, 90);
		console.add(scrollPaneConsole);
		
		textAreaConsole = new JTextArea();
		textAreaConsole.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaConsole.setBounds(23, 31, 850, 90);		
		textAreaConsole.setLineWrap(true);
		textAreaConsole.setEditable(true);
		
		scrollPaneConsole.setViewportView(textAreaConsole);
	
	}
	/**
	 * @return
	 * @uml.property  name="table"
	 */
	public JTable getTable() {
		return table;
	}
	/**
	 * @param table
	 * @uml.property  name="table"
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * @return
	 * @uml.property  name="tableModel"
	 */
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	/**
	 * @param tableModel
	 * @uml.property  name="tableModel"
	 */
	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	

	public  void clearTable() {
		 try{
			
		
			  tableModel=(DefaultTableModel) table.getModel();
			 int fila=table.getRowCount();
			 for (int i = 0;fila>i; i++) {
			 tableModel.removeRow(0);}	 
		 
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
	}



	private JMenuItem getMenuAbout() {
		mntmAbout = new JMenuItem("About");
		mntmAbout.setFont(new Font("Calibri", Font.PLAIN, 14));
		mntmAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showOptionDialog(null,"Application developed by: \n\n "+
												" Alicia Mireya Daza Castillo \n"+
												" Jorge González López \n" +
												" Rosa Rodríguez Navarro\n"+
												" Rafael Caballero Roldán\n"+
												" date: 05/30/2014 \n"+
												" version 2.2.1","About",
												JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botones1,botones[0]);
			}
			
			});	
		return mntmAbout;
	}


	public void createTable() {
		table = new JTable();
		table.setShowGrid(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableModel = new DefaultTableModel(
				new Object[][] {
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
						{"", ""},
					},
					new String [] {
						"New column", "New column"
					});	
		table.setModel(tableModel);
		table.setBounds(10, 85, 173, 480);
		table.setBackground(new Color(154, 200, 153));
		panel_4.add(table);	
			 
		
	}

	/**
	 * 
	 * class ButtonGroupListener
	 *
	 */
	public class ButtonGroupListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Do whatever with e.getActionCommand() 
		}
	}	
	
	/**
	 * 
	 * class ButtonListener LOAD/STAR
	 *
	 */
	public class ButtonListener implements ActionListener{
		String path2;
		
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == btnButtonLoad){
			
				if(textFieldP.getText().equals("") || textCoorP.getText().equals("") ||
						textRadiusP.getText().equals("") || textFieldS.getText().equals("") ||
						textRadiusS.getText().equals("")){
					
					JOptionPane.showMessageDialog(null,"Some fields are empty","",JOptionPane.ERROR_MESSAGE);
				}
				else{
				contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				
				Map<String,DescriptionData> mp=new LinkedHashMap<String,DescriptionData>();
				String sourceP = textFieldP.getText();
				String coordP = textCoorP.getText();
				String radP = textRadiusP.getText();
				String sourceS = textFieldS.getText();
				String radiusS = textRadiusS.getText();
				
				/*log.info("Pin down load");				
				log.info("Catalog P: "+sourceP);
				log.info("Coord P: "+coordP);
				log.info("rad P: "+radP);
				log.info("Catalog S:" +sourceS);
				log.info("Radius around each P star :"+ radiusS);				
			*/
				
				path2= "\\"+sourceP+"_"+coordP;
				File folder = new File(path.concat(path2));				
				File folderSecond = new File(path.concat(path2+"/Secondary"));				
				
				if(folder.exists()){
					boolean value=false;
					int result = JOptionPane.showConfirmDialog(Interface.this, 
						       new String("The file \n"+folder+"\n exists, overwrite?"),
	                     "Existing file", JOptionPane.YES_NO_CANCEL_OPTION);
					if (result == JOptionPane.YES_OPTION) value = true;
					else if(result == JOptionPane.CANCEL_OPTION){
						value = false;
						//JOptionPane.showMessageDialog(null, "","EstaSeguro?",JOptionPane.INFORMATION_MESSAGE);
					}
					else if (result == JOptionPane.NO_OPTION) value = false;    
					File folder1 = new File(path.concat(path2));
					folder1.mkdir();
					//log.info("Created directory "+folder1);
					
				}
				else{ 
					folder.mkdir();				
					//log.info(folder);
					
					if(folderSecond.exists()){
						boolean value2=false;
						int result2 = JOptionPane.showConfirmDialog(Interface.this, 
							       new String("The file \n"+folderSecond+"\n exists, overwrite?"),
		                     "Existing file", JOptionPane.YES_NO_CANCEL_OPTION);
						if (result2 == JOptionPane.YES_OPTION) value2 = true;
						else if(result2 == JOptionPane.CANCEL_OPTION){
							value2 = false;
							
						}
						else if (result2 == JOptionPane.NO_OPTION) value2 = false;     
						folderSecond = new File(path.concat("/Secondary"+"_"+coordP));											
						folderSecond.mkdir();
						//log.info("Created directory "+folderSecond);
						
							
					}
					else{
						folderSecond.mkdir();
						//log.info("Created directory "+folderSecond);
					  
					}	
						
				}
				
				JFileChooser selecFile=new JFileChooser(folder);
				int i=selecFile.showSaveDialog(Interface.this);
				
				try{
					if(i==JFileChooser.CANCEL_OPTION){}
					else{
					///FALLA AL DARLE A CANCELAR
					String fileName=selecFile.getSelectedFile().getAbsolutePath();	
					
					String pathName=path.concat(path2);
					if (alreadyexists(fileName)/* && alreadyexists(fileNotes)*/){
					    Info.saveCatalogFile(fileName,sourceP,coordP,radP);
					    Info.setCatalogPath(fileName);					    
					    open=true;					   
					    primaryData = new DescriptionData(fileName);
					    primaryData.parser();
					    linesNumber=primaryData.getContador();
					    exploreDirectory(path.concat(path2),linesNumber);
					   // log.info("Created File "+fileName);
					   // log.info("Catalog Description Primary: ");					 
					    insertNames(primaryData.getDt(),0);
					    saveSData(selecFile, primaryData.getDt(),folderSecond,pathName);					    
					    					   
					}	
					    
					}
				}catch(Exception e2){ 
					
					//log.log(Level.WARN,e2.toString());
					e2.printStackTrace();
					
				};
				
				contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}
				
			}
			else if (o == btnButtonFilter){	
				
				textAreaConsole.setText(null);				
				String filterP= textAreaFilterP.getText();
				String filterS= textAreaFilterS.getText();
				//log.info("Filter P: "+filterP);				
				//log.info("Filter S: "+filterS);	
				Vector<StarRow> primaryStars;
				
				Lexical lp= new Lexical(filterP);
				//Lexical ls = new Lexical(filterS);
				SyntacticAnalizer asP = new SyntacticAnalizer(lp,textAreaConsole);
				
				//SyntacticAnalizer asS = new SyntacticAnalizer(ls);
				asP.setRow(primaryData.variablesForParser("p"));
				asP.parser();				
				parserCatalogP = asP.getProgram();
				primaryStars = primaryData.getStars();
				
				//Filter Catalog P
				String pathFilteredP = path + path2 + "/Filtered_CatalogP";
				//create directory for filtered P
				File folderFilteredP= new File(pathFilteredP);	
				folderFilteredP.mkdir();
				
				//Crete directory for secondary stars around filtered P
				File folderSecondaryFilteredP= new File(pathFilteredP + "/Secondary");	
				folderSecondaryFilteredP.mkdir();
				
				

				try {
					File file = new File(pathFilteredP + "/Filtered_Primary.txt");
					BufferedWriter output = new BufferedWriter(new FileWriter(file));
					output.write("This is a list of star rows which passed catalog P filter\n\n");
					output.flush();
					//loop stars
					try{
						for(int i = 0; i < primaryStars.size(); i++){
							LinkedHashMap<Variable, Value> listForParser = primaryStars.get(i).starRowToVariable("p"); //modify data for parser
							boolean saveStar = parserCatalogP.eval(listForParser, textAreaConsole); //check if this star pass the filter
							if (saveStar){
								output.write(primaryStars.get(i).getLine() + "\n");
								output.flush();
							}
						}
					}catch (TypeException te){
						//
					}
					output.flush();
					output.close();

					//asS.program(false);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}

				
				
				
			}else if (o == btnStart){
				
				String criteriumS= textAreaCriteriumS.getText();
				String criteriumError= textAreaCriteriumErrors.getText();
				//log.info("Criterium for selecting S rows: "+criteriumS);				
				//log.info("Criterium for detecting errors : "+criteriumError);	
			}
				
			
	
		}
	
	

		private void saveSData(JFileChooser selectedFile, LinkedHashMap<String, DataStructure> dt,File folder,String pathName) {
			arraySecondaryData = new Vector<DescriptionData>();
		    //Catalog S
			String sourceS = textFieldS.getText();
			String radS = textRadiusS.getText();
			String coordS = "";
			Vector<StarRow> starsP = primaryData.getStars();
			String coordSAnt = "x";
			String coordSAnt2 = "y";
			String coordSAnt3 = "z";
			String coordSAnt4 = "x";
			String coordSAnt5 = "y";
			String coordSAnt6 = "z";
			String coordSAnt7 = "x";
			String coordSAnt8 = "y";
			String coordSAnt9 = "z";
			String pepe=pathName+"\\read.txt";
			try {
				//if (alreadyexists(pepe)){
	        	bw = new BufferedWriter(new FileWriter(pathName+"\\read.txt",true));
				bw.write("In the directory " +folder.getName()+" have generated the following files \n\n" );
				bw.close();
			//} 
			}catch (IOException e) {			
				e.printStackTrace();
			}
			for (StarRow row : starsP){
			    coordS = row.getStar().get("RAJ2000").getValue();
			    coordS += " ";
			    coordS += row.getStar().get("DEJ2000").getValue();
			  
			    try{
					
					String aux = "";
					if(coordS.equals(coordSAnt)){
						if (coordSAnt.equals(coordSAnt2)){
							if (coordSAnt2.equals(coordSAnt3)){
								if (coordSAnt3.equals(coordSAnt4)){
									if (coordSAnt4.equals(coordSAnt5)){
										if (coordSAnt5.equals(coordSAnt6)){
											if (coordSAnt6.equals(coordSAnt7)){
												if (coordSAnt7.equals(coordSAnt8)){
													if (coordSAnt8.equals(coordSAnt9)){
														aux = "IX";
													}
													else aux = "_VIII";
												}
												else aux = "_VII";
											}
											else aux = "_VI";
										}
										else aux = "_V";
									}
									else aux = "_IV";
								}
								else aux = "_III";
							}
							else aux = "_II";
						}
						else aux = "_I";
					}
					String fileName = folder+ "\\Stars_of_S_around_"+ coordS + aux +".txt";
					
					if (alreadyexists(fileName)){
					    Info.saveCatalogFile(fileName,sourceS,coordS,radS);
					    Info.setCatalogPath(fileName);					    
					    open2=true;					   
					    DescriptionData secondaryData = new DescriptionData(fileName);
					    secondaryData.parser();
					    linesNumber2=secondaryData.getContador();					   
					    arraySecondaryData.add(secondaryData);						    
												
					}
				
					//String pepe=pathName+"\\read.txt";
					try {
			        	  
						//if (alreadyexists(pepe)){
						bw = new BufferedWriter(new FileWriter(pepe,true));	
						
						bw.write(" - File Created ->  "+" "+ "Stars_of_S_around_"+ coordS + aux +".txt"+
								" ===> "+"Number of stars : "+linesNumber2+" \n\n");
						bw.flush();
						bw.close();
	        	  		//log.info("Created File "+"Stars_of_S_around_"+ coordS + aux +".txt");	//}			
					} //}
					catch (IOException e) {						
						e.printStackTrace();
					}
					//recorrerDirectorios(path.concat(path2+"/Secondary"),linesNumber2);
						
			    }catch(Exception e2){e2.printStackTrace();};
				coordSAnt9 = coordSAnt8;
				coordSAnt8 = coordSAnt7;
				coordSAnt7 = coordSAnt6;
				coordSAnt6 = coordSAnt5;
				coordSAnt5= coordSAnt4;
				coordSAnt4 = coordSAnt3;
				coordSAnt3 = coordSAnt2;
				coordSAnt2 = coordSAnt;
				coordSAnt = coordS;

			    /*********************/
			}
			//recorrerDirectorios(path.concat(path2+"/Secondary"),linesNumber2);
			
			//Get column names from some secondary data not empty
			boolean found = false;
			Iterator<DescriptionData> it = arraySecondaryData.iterator();
			DescriptionData ref=null;
			while (!found && it.hasNext()){
				DescriptionData dd = it.next();
				if (!dd.isEmpty()){
					ref = dd;
					found = true;
				}
			}
		    if (found){
		    	//log.info("Catalog Description Secondary: ");		    	
		    	insertNames(ref.getDt(),1); 
		    }else{
		    	//No data for catalog S 
		    	//Message??
		    }
		  
		  
			
		}

		private void insertNames(LinkedHashMap<String, DataStructure> dt, int column) {
			int row = 0;			
			for (Map.Entry<String,DataStructure> entry : dt.entrySet()) {
			    String key = entry.getKey();			 
			    tableModel.setValueAt(key, row, column);			  
			   // log.info(key);
			    row++;			   
			}	
			
		}


	}
	

		
	private  boolean alreadyexists(String file ) {
		boolean value = true;
		File f = new File(file);		
		if (f.exists()) {
			 int result = JOptionPane.showConfirmDialog(Interface.this, 
					       new String("The file \n"+file+"\n exists, overwrite?"),
                     "Existing file", JOptionPane.YES_NO_CANCEL_OPTION);
             if (result == JOptionPane.YES_OPTION)  value = true;
             else if(result == JOptionPane.CANCEL_OPTION) value = false;
             else if (result == JOptionPane.NO_OPTION) value = false;    
             
		}
		return value;
	}

	/**
	 * @return
	 * @uml.property  name="textFieldP"
	 */
	public JTextField getTextFieldP() {
		return textFieldP;
	}

	/**
	 * @param textFieldP
	 * @uml.property  name="textFieldP"
	 */
	public void setTextFieldP(JTextField textFieldP) {
		this.textFieldP = textFieldP;
	}
	
	 public  void exploreDirectory(String path, int linesNumber) {
		 
	        //one file object is created with the directory path
	       File directory =new File(path);
	      
	       BufferedWriter bw = null;
	        //Check if the path exists
	        if (!directory.exists()) {
	            System.out.println("The path " + directory.getAbsolutePath() + " does not exist.");
	            return;
	        }
	        //It checks if a directory
	        if (!directory.isDirectory()) {
	            System.out.println("The path " + directory.getAbsolutePath() + " is not a directory");
	            return;
	        }
	       
	        
	        //get the content of the directory
	        File[] lista = directory.listFiles();
	       
        		String pepe=path+"\\read.txt";
	        try {
	        
	        	//if (alreadyexists(pepe)){
	        	bw = new BufferedWriter(new FileWriter(pepe,true));       	
	        	
	        	//log.info("Created File "+"read.txt");
				bw.write("In the directory " +directory.getName()+" have generated the following files \n\n" );
				bw.flush();
				bw.close();//}
			} catch (IOException e) {			
				e.printStackTrace();
			}
	        //walking the directory and files are listed first
	       
	        	  
	       for (File s : lista){
	        	 if(s.isFile()){
	          
					try {
						//if (alreadyexists(pepe)){
						bw = new BufferedWriter(new FileWriter(path+"\\read.txt",true));						
						bw.write(" - File Created ->  "+" "+ s.getName()+
								" ===> "+"Number of stars : "+linesNumber+" \n\n");
						bw.flush();
						bw.close();
						//log.info("Created File "+s.getName());		//}			
					} 
					catch (IOException e) {						
						e.printStackTrace();
					}
					
	           }
	         
	       }    
	       //is walking again the directory and subdirectories are obtained
	     /* for (File s : lista) {        
	            //Si es un directorio se vuelve a llamar al m�todo
	            if (s.isDirectory()) {
	            						
	                recorrerDirectorios(ruta,linesNumber);
	            }
	        }*/
	 }
	
}
