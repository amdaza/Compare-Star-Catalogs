package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Int  extends Expression {


	private String value;


	public Int (Int exp){
		this.type = exp.type;
		this.value = exp.value;
	}

	public Int(String value){
		type = "integer";
		this.setValue(value);
	}

	public Value getValue(HashMap<Variable,Value> localVar){
		Value result = null;

		if ( type.equals("integer"))
			result =  new Value(value,getType());
		else{
			error = true;
			result = new Value("125","error");
		}


		return result;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


}
