package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Arctand extends Expression {

	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e;

	public Arctand(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}
	public Arctand(Arctand exp){
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
				int arctand1 = (int) Math.atan(v.getInt());
				result = new Value(String.valueOf(arctand1), "real");
				break;
			case "real":
				double arctand2 = Math.atan(v.getDouble());
				result = new Value(String.valueOf(arctand2), "real");
				break;
			case "exponential":
				double arctand3 = Math.atan(v.getDouble());
				result = new Value(String.valueOf(arctand3), "real");
				break;
			}
		}
		else {
			error=true;
			result = new Value("115","error");
		}
		return result;
	}

}
