package parser.errors;

import java.awt.Color;

import javax.swing.JTextArea;

import parser.elements.*;



public class Errors {

	/**
	 * attributes:
	 * 
	 * s	-
	 * t	-
	 */
	private String s;
	private Token t;

	/**
	 * constructor of the class
	 * 
	 * @param id
	 * @param t
	 * @param throwError
	 * @param console
	 */
	public Errors(int id, Token t, boolean throwError, JTextArea console) {
		this.t = new Token(t);
		String tError="";
		if((id>0)&&(id<100))
			tError ="Syntax error:\n";
		else if (id>=100)
			tError ="Type error:\n";
		else if (id>=200)
			tError = "Lexical error:\n";
		if (id==1)
			this.s="filter or assignment expected ";
		else if (id==2)
			this.s="expression expected ";
		else if (id==3)
			this.s="':=' expected";
		else if (id==4)
			this.s="';' expected";
		else if (id==5)
			this.s="'ELSE' expected";
		else if (id==6)
			this.s="'THEN' expected";
		else if (id==7)
			this.s="')' expected ";
		else if (id==8)
			this.s="',' expected ";
		else if (id==9)
			this.s="Exp4 expected in dis(Exp1,Exp2,Exp3,Exp4)";
		else if (id==10)
			this.s="Exp3 expected in dis(Exp1,Exp2,Exp3,Exp4)";
		else if (id==11)
			this.s="Exp2 expected in dis(Exp1,Exp2,Exp3,Exp4)";
		else if (id==12)
			this.s="Exp1 expected in dis(Exp1,Exp2,Exp3,Exp4)";
		else if (id==13)
			this.s="Exp expected in abs(Exp)";
		else if (id==14)
			this.s=" '(' expected after abs";
		else if (id==15)
			this.s="Exp expected in sind(Exp)";
		else if (id==16)
			this.s="'(' expected after sind";
		else if (id==17)
			this.s="Exp expected in cosd(Exp)";
		else if (id==18)
			this.s="'(' expected after cosd";
		else if (id==19)
			this.s="Exp expected in sins(Exp)";
		else if (id==20)
			this.s="'(' expected after sins ";
		else if (id==21)
			this.s="Exp expected in coss(Exp)";
		else if (id==22)
			this.s="'(' expected after coss";
		else if (id==23)
			this.s="Exp expected in tans(Exp)";
		else if (id==24)
			this.s="'(' expected after tans";
		else if (id==25)
			this.s="Exp expected in tand(Exp)";
		else if (id==26)
			this.s="'(' expected after tand";
		else if (id==27)
			this.s="Exp expected in arcsins(Exp)";
		else if (id==28)
			this.s="'(' expected after arcsins";
		else if (id==29)
			this.s="Exp expected in arcsind(Exp)";
		else if (id==30)
			this.s="'(' expected after arcsind";
		else if (id==31)
			this.s="Exp expected in arccoss(Exp)";
		else if (id==32)
			this.s="'(' expected after arccoss";
		else if (id==33)
			this.s="Exp expected in arccosd(Exp)";
		else if (id==34)
			this.s="'(' expected after arccosd";
		else if (id==35)
			this.s="Exp expected in arctans(Exp)";
		else if (id==36)
			this.s="'(' expected after arctans";
		else if (id==37)
			this.s="Exp expected in arctand(Exp)";
		else if (id==38)
			this.s="'(' expected after arctand";
		else if (id==39)
			this.s="Exp expected in s2d(Exp)";
		else if (id==40)
			this.s="'(' expected after s2d";
		else if (id==41)
			this.s="Exp expected in d2sdec(Exp)";
		else if (id==42)
			this.s="'(' expected after d2sdec";
		else if (id==43)
			this.s="Exp expected in d2sra(Exp)";
		else if (id==44)
			this.s="'(' expected after d2sra";
		else if (id==45)
			this.s="exp2 expected in exp1 (+ | -) exp2";
		else if (id==46)
			this.s="exp2 expected in exp1 (* | / | 'div' | 'mod') exp2";
		else if (id==47)
			this.s="exp2 expected in exp1 ^ exp2";
		else if (id==48)
			this.s="identificator not declared before";
		else if (id==100)
			this.s="Type error";
		else if (id==101)
			this.s="Negation needs an boolean expression";
		else if (id==102)
			this.s="Less needs an numeric expression";
		else if (id==103)
			this.s="abs needs an numeric expression";
		else if (id==104)
			this.s="sind needs an numeric expression";
		else if (id==105)
			this.s="cosd needs an numeric expression";
		else if (id==106)
			this.s="sins needs an string expression. Example '17 25 86.5'";
		else if (id==107)
			this.s="coss needs an numeric expression";
		else if (id==108)
			this.s="tans needs an sttring expression. Example '17 25 86.5'";
		else if (id==109)
			this.s="tand needs an numeric expression";
		else if (id==110)
			this.s="arcsins needs an string expression. Example '17 25 86.5'";
		else if (id==111)
			this.s="arcsind needs an numeric expression";
		else if (id==112)
			this.s="arccoss needs an string expression. Example '17 25 86.5'";
		else if (id==113)
			this.s="arccosd needs an numeric expression";
		else if (id==114)
			this.s="arctans needs an string expression. Example '17 25 86.5'";
		else if (id==115)
			this.s="arctand needs an numeric expression";
		else if (id==116)
			this.s="s2d needs an string expression. Example '17 25 86.5'";
		else if (id==117)
			this.s="DecToSexaDecl needs an numeric expression";
		else if (id==118)
			this.s="DecToSexaRa needs an numeric expression";
		else if (id==119)
			this.s="Distance needs an numeric expression";
		else if (id==120)
			this.s="Logic operation needs an boolean expression";
		else if (id==121)
			this.s="Operation 'mod' requies integers";
		else if (id==122)
			this.s="Operation 'div' requies integers";
		/*else if (id==123)
			this.s="";
		else if (id==124)
			this.s="";*/
		else if (id==125)
			this.s="expected an integer";
		else if (id==126)
			this.s="expected an real";
		else if (id==127)
			this.s="expecting a string";
		else if (id==128)
			this.s="expecting a boolean";
		else if (id==129)
			this.s="expected an integer";
		/*else if (id==130)
			this.s="";*/
		else if (id==201)
			this.s="Unknown character";
		if(throwError){
			console.setForeground(Color.red);
			System.out.println(tError + s + " , in the row: " + t.leeFila()
					+ " , in the column: " + t.leeColumna());
			console.append(tError + s + " , in the row: " + t.leeFila()
					+ " , in the column: " + t.leeColumna()+"\n");
			
		}
		throwError = true;
	}

	/**
	 * 
	 * @return
	 */
	public String getS() {
		return s;
	}

	/**
	 * 
	 * @param s
	 */
	public void setS(String s) {
		this.s = s;
	}

	/**
	 * 
	 * @return Token
	 */
	public Token getT() {
		return t;
	}

	/**
	 * 
	 * @param t
	 */
	public void setT(Token t) {
		this.t = t;
	}
}
