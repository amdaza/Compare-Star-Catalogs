package parser.contents;

import java.util.HashMap;

import parser.elements.*;

public class False extends Expression {
	
	public False(String type){
		this.type="boolean";
	}
	public False (Expression e){
		super();
		type="boolean";
	}
	
	public False(False exp){
		this.type = exp.type;
		
	}

	public Value getValue(HashMap<Variable, Value> localVar) {
		Value result = null;
		if (type.equals("boolean")) 
			result =  new Value("false",getType());
		else{
			error = true;
			result = new Value("128","error");
		}
			
		
		return result;
	}
	
	

}
