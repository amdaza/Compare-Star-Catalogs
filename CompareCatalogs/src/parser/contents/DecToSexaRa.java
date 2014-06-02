package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class DecToSexaRa  extends Expression {

	private Expression e;

	public DecToSexaRa(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}
	public DecToSexaRa(DecToSexaRa exp){
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
					int h = (int) v.getInt()*24/360;
					int min = (int) (v.getInt()-15*h)*4;
					double s = (v.getInt()-(h*60+min)/4)*240;
					String r = String.valueOf(h) + " " + String.valueOf(min) + " " + String.valueOf(s); 
					result = new Value(String.valueOf(r), "string");
				break;
				case "real":
					double h1 = (int) v.getDouble()*24/360;
					double min1 = (int) (v.getDouble()-15*h1)*4;
					double s1 = (v.getDouble()-(h1*60+min1)/4)*240;
					String r1 = String.valueOf(h1) + " " + String.valueOf(min1) + " " + String.valueOf(s1); 
					result = new Value(String.valueOf(r1), "string");
				break;
				case "exponential":
					double h2 = (int) v.getDouble()*24/360;
					double min2 = (int) (v.getDouble()-15*h2)*4;
					double s2 = (v.getDouble()-(h2*60+min2)/4)*240;
					String r2 = String.valueOf(h2) + " " + String.valueOf(min2) + " " + String.valueOf(s2); 
					result = new Value(String.valueOf(r2), "string");
				break;
			}
		}
		else {
			result = new Value("118", "error");
		}
		return result;
	}

}