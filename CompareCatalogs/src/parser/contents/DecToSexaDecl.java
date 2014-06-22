package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class DecToSexaDecl extends Expression {

	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e;

	public DecToSexaDecl(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}
	
	public DecToSexaDecl(DecToSexaDecl exp){
		this.type = exp.type;	
		this.e = exp.e.deepCopy();
	}

	public Value getValue(HashMap<Variable,Value> localvar )  { 
		Value result=null;
		type = e.getType();
		Value v = e.getValue(localvar);
		if (isTypeNumeric()) {
			switch (type){
			case "integer":
				int gr;
				int min;
				int sec;
				if(v.getInt()<0){
					gr = v.getInt() +1; 
				}else{
					gr = v.getInt(); 
				}
				min = (int) (Math.abs(v.getInt()-gr)*60);
				if(v.getInt()*3600>gr*3600-(min*60)){
					sec = v.getInt()*3600 - gr*3600-(min*60);
				}else{
					sec = v.getInt()*3600 + gr*3600-(min*60);
				}
				String grString;
				if(gr>0){
					grString= "+" + String.valueOf(gr);
				}else{
					grString= String.valueOf(gr);
				}
				String r = grString + " " + String.valueOf(min) + " " + String.valueOf(sec); 
				result = new Value(String.valueOf(r), "string");
				break;
			case "real":
				int gr1;
				int min1;
				double sec1;
				if(v.getDouble()<0){
					gr1 = (int) v.getDouble() +1; 
				}else{
					gr1 = (int) v.getDouble(); 
				}
				min1 = (int) (Math.abs(v.getDouble()-gr1)*60);
				if(v.getDouble()*3600>gr1*3600-(min1*60)){
					sec1 = v.getDouble()*3600 - gr1*3600-(min1*60);
				}else{
					sec1 = v.getDouble()*3600 + gr1*3600-(min1*60);
				}
				String gr1String;
				if(gr1>0){
					gr1String= "+" + String.valueOf(gr1);
				}else{
					gr1String= String.valueOf(gr1);
				}
				String r1 = gr1String + " " + String.valueOf(min1) + " " + String.valueOf(sec1); 
				result = new Value(String.valueOf(r1), "string");
				break;
			case "exponential":
				int gr2;
				int min2;
				double sec2;
				if(v.getDouble()<0){
					gr2 = (int) v.getDouble() +1; 
				}else{
					gr2 = (int) v.getDouble(); 
				}
				min2 = (int) (Math.abs(v.getDouble()-gr2)*60);
				if(v.getDouble()*3600>gr2*3600-(min2*60)){
					sec2 = v.getDouble()*3600 - gr2*3600-(min2*60);
				}else{
					sec2 = v.getDouble()*3600 + gr2*3600-(min2*60);
				}
				String gr2String;
				if(gr2>0){
					gr2String= "+" + String.valueOf(gr2);
				}else{
					gr2String= String.valueOf(gr2);
				}
				String r2 = gr2String + " " + String.valueOf(min2) + " " + String.valueOf(sec2); 
				result = new Value(String.valueOf(r2), "string");
				break;
			}
		}
		else {
			error=true;
			result = new Value("117","error");
		}
		return result;
	}
}
