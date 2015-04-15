package parser.contents;

import java.util.HashMap;
import parser.elements.*;

public class Less extends Expression {

	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e;

	public Less(Expression e){//
		super();
		this.e=e.deepCopy();
		this.type = e.type;
	}

	public Less(Less exp){//
		this.type = exp.type;
		this.e = exp.e.deepCopy();
	}

	/**
	 * @return
	 * @uml.property  name="e"
	 */
	public Expression getE() {
		return e;
	}
	/**
	 * @param e
	 * @uml.property  name="e"
	 */
	public void setE(Expression e) {//
		this.e = e;
		this.type = e.type;
	}

	public Value getValue(HashMap<Variable,Value> localvar )  {
		Value result=null;
		type = e.getType();
		Value v = e.getValue(localvar);
		if (v.isTypeNumeric()) {
			if(type.equals("integer")){
				int k = 0 - v.getInt();
				result = new Value(String.valueOf(k), type);
			}
			else{
				double k = 0 - v.getDouble();
				result = new Value(String.valueOf(k), type);
			}
		}
		else {
			error = true;
			result = new Value("102", "error");
		}
		return result;
	}

}
