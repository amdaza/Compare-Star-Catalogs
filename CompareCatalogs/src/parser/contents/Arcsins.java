package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Arcsins extends Expression {

	private Expression e;

	public Arcsins(Expression e){
		super();
		this.e=e;
		this.type = e.type;
	}
	public Arcsins(Arcsins exp){
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
				double arcsins = Math.asin(d);
				result = new Value(String.valueOf(arcsins), "real");
			}else{
				double d = std.sexaToDecRa(sexa);
				double arcsins = Math.asin(d);
				result = new Value(String.valueOf(arcsins), "real");
			}
		}
		else {
			result = new Value("110", "error");
		}
		return result;
	}

}
