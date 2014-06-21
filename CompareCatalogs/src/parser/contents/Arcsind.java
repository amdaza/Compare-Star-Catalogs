package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Arcsind extends Expression {

	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e;

	public Arcsind(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}
	
	public Arcsind(Arcsind exp){
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
					int arcsind1 = (int) Math.asin(v.getInt());
					result = new Value(String.valueOf(arcsind1), "real");
				break;
				case "real":
					double arcsind2 = Math.asin(v.getDouble());
					result = new Value(String.valueOf(arcsind2), "real");
				break;
				case "exponential":
					double arcsind3 = Math.asin(v.getDouble());
					result = new Value(String.valueOf(arcsind3), "real");
				break;
			}
		}
		else {
			result = new Value("111", "error");
		}
		return result;
	}

}
