package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Cosd  extends Expression {


	private Expression e;

	public Cosd(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}

	public Cosd(Cosd exp){
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
					int cosd1 = (int) Math.cos(v.getInt());
					result = new Value(String.valueOf(cosd1), "real");
				break;
				case "real":
					double cosd2 = Math.cos(v.getDouble());
					result = new Value(String.valueOf(cosd2), "real");
				break;
				case "exponential":
					double cosd3 = Math.cos(v.getDouble());
					result = new Value(String.valueOf(cosd3), "real");
				break;
			}
		}
		else {
			error=true;
			result = new Value("105","error");
		}
		return result;
	}

}
