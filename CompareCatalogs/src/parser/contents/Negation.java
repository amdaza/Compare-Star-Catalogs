package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Negation extends Expression {

	private Expression e;

	public Negation(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}
	
	public Negation(Negation exp){
		this.type = exp.type;	
		this.e = exp.e.deepCopy();
	}

	public Value getValue(HashMap<Variable,Value> localvar )  { 
		Value result = null;
		type = "boolean";	
		type = e.getType();
		Value v = e.getValue(localvar);
		if (type.equals("boolean")) {
			switch (v.getString()){
				case "true":					
					result = new Value("false", type);
				break;
				case "false":
					result = new Value("true", type);
				break;
				
			}
		}
		else {
			result = new Value("101", "error");
		}
		return result;
	}

}