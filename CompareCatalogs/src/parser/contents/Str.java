package parser.contents;
import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;


public class Str extends Expression {

	private String value;

	public Str(String value){
		type = "string";
		this.setValue(value);
	}

	/*	public Str (Expression e){
		super();
	}*/

	public Str(Str exp){
		this.type = exp.type;
		this.value = exp.value;
	}


	public String getValue() {
		return value;
	}

	
	public void setValue(String value) {
		this.value = value;
	}
	public Value getValue(HashMap<Variable,Value> localVar){
		Value result = null;
		if(type.equals("string"))
			result =  new Value(value,getType());
		else {
			error = true;
			result = new Value("127","error");
		}

		return result;
	}


}
