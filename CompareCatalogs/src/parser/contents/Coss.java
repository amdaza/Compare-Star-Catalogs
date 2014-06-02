package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Coss extends Expression {

	private Expression e;

	public Coss(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}
	
	public Coss(Coss exp){
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
				double cos = Math.cos(d);
				result = new Value(String.valueOf(cos), "real");
			}else{
				double d = std.sexaToDecRa(sexa);
				double cos = Math.cos(d);
				result = new Value(String.valueOf(cos), "real");
			}
		}
		else {
			result = new Value("107", "error");
		}
		return result;
	}
}
