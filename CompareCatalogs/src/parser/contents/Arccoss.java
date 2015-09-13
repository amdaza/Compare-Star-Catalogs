package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Arccoss extends Expression {


	private Expression e;

	public Arccoss(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}

	public Arccoss(Arccoss exp){
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
				double arccoss = Math.acos(d);
				result = new Value(String.valueOf(arccoss), "real");
			}else{
				double d = std.sexaToDecRa(sexa);
				double arccoss = Math.acos(d);
				result = new Value(String.valueOf(arccoss), "real");
			}
		}
		else {
			error=true;
			result = new Value("112","error");
		}
		return result;
	}

}


