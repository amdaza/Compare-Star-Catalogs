package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Tans  extends Expression {

	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e;

	public Tans(Expression e){
		super();
		this.type = e.type;
		this.e=e.deepCopy();
	}
	public Tans(Tans exp){
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
				double tans = Math.tan(d);
				result = new Value(String.valueOf(tans), "real");
			}else{
				double d = std.sexaToDecRa(sexa);
				double tans = Math.tan(d);
				result = new Value(String.valueOf(tans), "real");
			}
		}
		else {
			error = true;
			result = new Value("108", "error");
		}
		return result;
	}

}
