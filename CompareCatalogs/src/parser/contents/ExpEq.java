package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class ExpEq extends Expression {

	/**
	 * @uml.property  name="op"
	 */
	private String op;
	/**
	 * @uml.property  name="e1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e1;
	/**
	 * @uml.property  name="e2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e2;

	public ExpEq (Expression e1, Expression e2, String op){
		super();
		this.e1=e1.deepCopy();
		this.e2=e2.deepCopy();
		this.type = "boolean";
		this.op = op;
	}

	public ExpEq(ExpEq exp){
		this.type = exp.type;
		this.e1 = exp.e1.deepCopy();
		this.e2 = exp.e2.deepCopy();
		this.op = exp.op;
	}

	public Value getValue(HashMap<Variable, Value> localVar) {
		Value result=null;
		Value v1 = e1.getValue(localVar);
		Value v2 = e2.getValue(localVar);
		if (v1.getType().equals(v2.getType()) || (v1.isTypeNumeric() && v2.isTypeNumeric())) {
			switch(op) {
			case "=":
				result = equal(v1,v2);
				break;
			case "<>":
				result = distinct(v1,v2);
				break;
			}

		}
		else {
			error=true;
			result = new Value("121", "error");
		}
		return result;
	}



	private Value equal(Value v1, Value v2) {
		Value result = null;
		if(v1.isTypeNumeric()  && v2.isTypeNumeric()){
			switch(v1.getType()) {
			case "integer":
				if(v2.getType().equals("integer")){
					int i1 = v1.getInt();
					int i2 = v2.getInt();
					if(i1 == i2)	result = new Value("true","boolean");
					else 	result = new Value("false","boolean");
				}
				else {
					double d1 = v1.getDouble();
					double d2 = v2.getDouble();
					if(d1 == d2)	result = new Value("true","boolean");
					else 	result = new Value("false","boolean");
				}

				break;
			case "real":
				double d3 = v1.getDouble();
				double d4 = v2.getDouble();
				if(d3 == d4)	result = new Value("true","boolean");
				else 	result = new Value("false","boolean");

				break;
			case "exponential":
				double d5 = v1.getDouble();
				double d6 = v2.getDouble();
				if(d5 == d6)	result = new Value("true","boolean");
				else 	result = new Value("false","boolean");
				break;

			}
		}
		else  if(v1.getVal().equals(v2.getVal())){
			result = new Value("true","boolean");

		}
		else result = new Value("false","boolean");
		return result;
	}

	private Value distinct(Value v1, Value v2) {
		Value result = null;
		if(v1.isTypeNumeric()  && v2.isTypeNumeric()){
			switch(v1.getType()) {
			case "integer":
				if(v2.getType().equals("integer")){
					int i1 = v1.getInt();
					int i2 = v2.getInt();
					if(i1 != i2)	result = new Value("true","boolean");
					else 	result = new Value("false","boolean");
				}
				else {
					double d1 = v1.getDouble();
					double d2 = v2.getDouble();
					if(d1 !=  d2)	result = new Value("true","boolean");
					else 	result = new Value("false","boolean");
				}

				break;
			case "real":
				double d3 = v1.getDouble();
				double d4 = v2.getDouble();
				if(d3  !=  d4)	result = new Value("true","boolean");
				else 	result = new Value("false","boolean");

				break;
			case "exponential":
				double d5 = v1.getDouble();
				double d6 = v2.getDouble();
				if(d5  !=  d6)	result = new Value("true","boolean");
				else 	result = new Value("false","boolean");
				break;

			}
		}
		else  if(!v1.getVal().equals(v2.getVal())){
			result = new Value("true","boolean");

		}
		else result = new Value("false","boolean");
		return result;
	}

}
