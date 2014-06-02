package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Tand extends Expression {

	private Expression e;

	public Tand(Expression e){
		super();
		this.e=e.deepCopy();
		this.type = e.type;
	}
	
	public Tand(Tand exp){
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
					int tan1 = (int) Math.tan(v.getInt());
					result = new Value(String.valueOf(tan1), "real");
				break;
				case "real":
					double tan2 = Math.tan(v.getDouble());
					result = new Value(String.valueOf(tan2), "real");
				break;
				case "exponential":
					double tan3 = Math.tan(v.getDouble());
					result = new Value(String.valueOf(tan3), "real");
				break;
			}
		}
		else {
			result = new Value("109", "error");
		}
		return result;
	}

}
