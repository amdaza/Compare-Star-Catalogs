package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class ExpLog extends Expression {


	private String op;
	private Expression e1;
	private Expression e2;

	public ExpLog (Expression e1, Expression e2, String op){
		super();
		this.e1=e1.deepCopy();
		this.e2=e2.deepCopy();
		this.type = "boolean";
		this.op = op;
	}

/*	public ExpLog (Expression e){
		super();
	}*/

	public ExpLog(ExpLog exp){
		this.type = exp.type;
		this.e1 = exp.e1.deepCopy();
		this.e2 = exp.e2.deepCopy();
		this.op = exp.op;
	}

	public Value getValue(HashMap<Variable,Value> localvar )  {
		Value result=null;
		Value v1 = e1.getValue(localvar);
		Value v2 = e2.getValue(localvar);
		if (v1.getType().equals("boolean") && v2.getType().equals("boolean")) {
			switch(op) {
			case "and":
				result = and(v1,v2);
				break;
			case "or":
				result = or(v1,v2);
				break;
			}

		}
		else {
			error = true;
			result = new Value("120", "error");

		}
		return result;
	}

	private Value and(Value v1, Value v2) {
		Value result= null;
		type = "boolean";
		if((v1.getType().equals("true")) && (v2.getType().equals("true")))
			result = new Value("true","boolean");

		else
			 result = new Value("false","boolean");

		return result;
	}

	private Value or(Value v1, Value v2) {

		Value result=null;
		if((v1.getType().equals("true")) || (v2.getType().equals("true")))

			result = new Value("true","boolean");

		else result = new Value("false","boolean");

		return result;
	}

}
