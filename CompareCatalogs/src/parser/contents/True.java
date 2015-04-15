package parser.contents;
import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;


public  class True extends Expression {

	public True(String type){
		this.type="boolean";
	}
	public True (Expression e){
		super();
		type="boolean";
	}
	public True(True exp){
		this.type = exp.type;
	}
	public Value getValue(HashMap<Variable,Value> localVar){
		Value result = null;
		if (type.equals("boolean"))
			result =  new Value("true",getType());
		else{
			error = true;
			result = new Value("128","error");
		}


		return result;
	}


}
