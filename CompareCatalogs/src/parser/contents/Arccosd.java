package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Arccosd extends Expression {

	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e;

	public Arccosd(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}
	public Arccosd (Arccosd exp){
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
					int arccosd1 = (int) Math.acos(v.getInt());
					result = new Value(String.valueOf(arccosd1), "real");
				break;
				case "real":
					double arccosd2 = Math.acos(v.getDouble());
					result = new Value(String.valueOf(arccosd2), "real");
				break;
				case "exponential":
					double arccosd3 = Math.acos(v.getDouble());
					result = new Value(String.valueOf(arccosd3), "real");
				break;
			}
		}
		else {
			error=true;
			result = new Value("113","error");
		}
		return result;
	}
}
