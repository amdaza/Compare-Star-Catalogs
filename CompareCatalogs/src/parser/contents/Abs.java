package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Abs extends Expression {

	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e;

	public Abs(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}
	public Abs (Abs exp){
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
	public void setE(Expression e) {
		this.e = e;
		this.type = e.type;
	}

	public Value getValue(HashMap<Variable,Value> localvar )  {
		Value result=null;
		type = e.getType();
		Value v = e.getValue(localvar);
		if (isTypeNumeric()) {
			switch (type){
				case "integer":
					int abs1 = Math.abs(v.getInt());
					result = new Value(String.valueOf(abs1), type);
				break;
				case "real":
					double abs2 = Math.abs(v.getDouble());
					result = new Value(String.valueOf(abs2), type);
				break;
				case "exponential":
					double abs3 = Math.abs(v.getDouble());
					result = new Value(String.valueOf(abs3), type);
				break;

			}
		}
		else {
			error=true;
			result = new Value("103","error");
		}
		return result;
	}

}
