package parser.contents;
import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;


public class Statement {

	private boolean binding;
	private Expression expr;
	
	
	public Statement (boolean binding, Expression expr){
		this.expr=expr;
		this.binding=true;
	}
	
	public boolean isBinding(){
		return binding;
	}
	public Value getValue(HashMap<Variable,Value> localVar){
		return expr.getValue(localVar);
	}
	
	public void setBinding(boolean binding) {
		this.binding = binding;
	}
	


	
}
