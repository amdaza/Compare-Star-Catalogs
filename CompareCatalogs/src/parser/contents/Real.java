package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Real extends Expression {
	/**
	 * @uml.property  name="value"
	 */
	private String value;

	public Real(String value){
		type = "real";
		this.setValue(value);
	}

	/*public Real (Expression e){
		super();
	}*/

	public Real(Real exp){
		this.type=exp.type;
		this.value=exp.value;
	}

	/**
	 * @return
	 * @uml.property  name="value"
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value
	 * @uml.property  name="value"
	 */
	public void setValue(String value) {
		this.value = value;
	}
	public Value getValue(HashMap<Variable,Value> localVar){

		Value result = null;

		if ( type.equals("real"))
			result =  new Value(value,getType());
		else{
			error = true;
			result = new Value("126","error");
		}


		return result;
	}


}
