package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Exponential extends Expression {

	private String value;

	public Exponential(String value){
		type = "exponential";
		this.setValue(value);
	}

	public Exponential (Expression e){
		super();
		this.type = e.type;

	}

	public Exponential(Exponential exp){
		this.type = exp.type;
		this.value = exp.value;
	}

	public Value getValue(HashMap<Variable,Value> localVar){
		Value result = null;
		if(type.equals("exponential"))

			result =  new Value(value,getType());
		else{
			error=true;
			result =  new Value("103","error");

		}
			//result = new Value("123","error");

		return result;
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
