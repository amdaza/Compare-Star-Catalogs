package parser.contents;

import java.util.HashMap;

import parser.elements.*;


public class ExpRel extends Expression {


	private String op;

	private Expression e1;

	private Expression e2;

	public ExpRel (Expression e1, Expression e2, String op){
		super();
		this.e1 = e1.deepCopy();
		this.e2 = e2.deepCopy();
		this.type = "boolean";
		this.op = op;
	}

	public ExpRel(Expression e){
		super();

	}

	public ExpRel (ExpRel exp){
		this.e1 = exp.e1.deepCopy();
		this.e2 = exp.e2.deepCopy();
		this.type = "boolean";
		this.op = exp.op;
	}

	public Value getValue(HashMap<Variable,Value> localvar )  {
		Value result=null;
		Value v1 = e1.getValue(localvar);
		Value v2 = e2.getValue(localvar);
		if (v1.isTypeNumeric() && v2.isTypeNumeric()) {
			switch(op) {
			case "<":
				result = lessThan(v1,v2);
				break;
			case ">":
				result = moreThan(v1,v2);
				break;
			case "<=":
				result = lessOrEqual(v1,v2);
				break;
			case ">=":
				result = moreOrEqual(v1,v2);
				break;
			}
		}
		else {
			error=true;
			result =  new Value("123","error");

		}
		return result;
	}

	private Value moreOrEqual(Value v1, Value v2) {
		Value result = null;
		String t1 = (String) v1.getType();
		String t2 = (String) v2.getType();

		if(t1.equals("integer") && t2.equals("integer")){
			if(v1.getInt() >= v2.getInt())
				result = new Value("true","boolean");
			else
				result = new Value("false","boolean");
		}else{
			if(v1.getDouble() >= v2.getDouble())
				result = new Value("true","boolean");
			else
				result = new Value("false","boolean");
		}
		return result;
	}

	private Value lessOrEqual(Value v1, Value v2) {
		Value result = null;
		String t1 = (String) v1.getType();
		String t2 = (String) v2.getType();

		if(t1.equals("integer") && t2.equals("integer")){
			if(v1.getInt() <= v2.getInt())
				result = new Value("true","boolean");
			else
				result = new Value("false","boolean");
		}else{
			if(v1.getDouble() <= v2.getDouble())
				result = new Value("true","boolean");
			else
				result = new Value("false","boolean");
		}
		return result;
	}

	private Value moreThan(Value v1, Value v2) {
		Value result = null;
		String t1 = (String) v1.getType();
		String t2 = (String) v2.getType();

		if(t1.equals("integer") && t2.equals("integer")){
			if(v1.getInt() > v2.getInt())
				result = new Value("true","boolean");
			else
				result = new Value("false","boolean");
		}else{
			if(v1.getDouble() > v2.getDouble())
				result = new Value("true","boolean");
			else
				result = new Value("false","boolean");
		}
		return result;
	}


	private Value lessThan(Value v1, Value v2) {
		Value result = null;
		String t1 = (String) v1.getType();
		String t2 = (String) v2.getType();

		if(t1.equals("integer") && t2.equals("integer")){
			if(v1.getInt() < v2.getInt())
				result = new Value("true","boolean");
			else
				result = new Value("false","boolean");
		}else{
			if(v1.getDouble() < v2.getDouble())
				result = new Value("true","boolean");
			else
				result = new Value("false","boolean");
		}
		return result;
	}

}
