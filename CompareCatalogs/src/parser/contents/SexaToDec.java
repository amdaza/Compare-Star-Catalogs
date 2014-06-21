package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class SexaToDec extends Expression {

	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  
	 */
	private Expression e;

	public SexaToDec(Expression e){
		super();
		this.e=e.deepCopy();
		this.type = e.type;
	}
	
	public SexaToDec(SexaToDec exp){
		this.type = exp.type;	
		this.e = exp.e.deepCopy();
	}
	
	public SexaToDec(){
		super();
	}

	public Value getValue(HashMap<Variable,Value> localvar )  { 
		Value result=null;
		type = e.getType();
		Value v = e.getValue(localvar);
		if (type.equals("string")) {
			String s = v.getString();
			char c = s.charAt(0);
			if(c == '+' || c == '-'){//DUDA
				result = new Value(String.valueOf(sexaToDecDecl(s)), "real");
			}else{
				result = new Value(String.valueOf(sexaToDecRa(s)), "real");
			}
			
		}
		else {
			result = new Value("116", "error");
		}
		return result;
	}

	private int sexaToDegreeOrHour(String sexa){
		return Integer.parseInt(sexa.split(" ")[0]);
	}
	
	private int sexaToMin(String sexa){
		return Integer.parseInt(sexa.split(" ")[1]);
	}
	
	private double sexaToSec(String sexa){
		return Double.parseDouble(sexa.split(" ")[2]);
	}
	
	public double sexaToDecDecl(String sexa){
		double res = 0;
		int deg = sexaToDegreeOrHour(sexa);
		int min = sexaToMin(sexa);
		double sec = sexaToSec(sexa);
		if(deg > 0){
			res= deg+min/60+sec/3600;
		}else{
			res= deg-min/60-sec/3600;
		}
		return res;
	}
	
	public double sexaToDecRa(String sexa){
		double res = 0;
		int hours = sexaToDegreeOrHour(sexa);
		int min = sexaToMin(sexa);
		double sec = sexaToSec(sexa);
			res= 15*(hours+min/60+sec/3600);
		return res;
	}

}