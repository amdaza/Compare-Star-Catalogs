package parser.contents;

import java.util.HashMap;
import parser.elements.*;

public class Less extends Expression {

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
	
	public Expression getE() {
		return e;
	}
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
			result = new Value("102", "error");
		}
		return result;
	}

}
