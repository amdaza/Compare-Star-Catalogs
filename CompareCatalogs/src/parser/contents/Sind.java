package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Sind  extends Expression {

	private Expression e;

	public Sind(Expression e){
		super();
		this.e=e.deepCopy();
		this.type = e.type;
	}
	
	public Sind(Sind exp){
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
					int sind1 = (int) Math.sin(v.getInt());
					result = new Value(String.valueOf(sind1), "real");
				break;
				case "real":
					double sind2 = Math.sin(v.getDouble());
					result = new Value(String.valueOf(sind2), "real");
				break;
				case "exponential":
					double sind3 = Math.sin(v.getDouble());
					result = new Value(String.valueOf(sind3), "real");
				break;
			}
		}
		else {
			result = new Value("104", "error");
		}
		return result;
	}
	
}