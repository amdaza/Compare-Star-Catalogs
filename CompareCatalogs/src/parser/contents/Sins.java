package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Sins  extends Expression {

	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e;

	public Sins(Expression e){
		super();
		this.e=e.deepCopy();
		this.type = e.type;
	}

	public Sins (Sins exp){
		this.type = exp.type;
		this.e = exp.e.deepCopy();
	}

	public Value getValue(HashMap<Variable,Value> localvar )  {
		Value result=null;
		type = e.getType();
		Value v = e.getValue(localvar);
		SexaToDec std = new SexaToDec();
		if (type.equals("string")) {
			String sexa = v.getString();
			char c = sexa.charAt(0);
			if(c == '+' || c == '-'){
				double d = std.sexaToDecDecl(sexa);
				double sins = Math.sin(d);
				result = new Value(String.valueOf(sins), "real");
			}else{
				double d = std.sexaToDecRa(sexa);
				double sins = Math.sin(d);
				result = new Value(String.valueOf(sins), "real");
			}
		}
		else {
			error = true;
			result = new Value("106", "error");
		}
		return result;
	}

}
