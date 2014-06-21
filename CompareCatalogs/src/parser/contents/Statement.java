package parser.contents;
import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;


public class Statement {

	/**
	 * @uml.property  name="binding"
	 */
	protected boolean binding;
	/**
	 * @uml.property  name="expr"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	protected Expression expr;
	
	
	public Statement (boolean binding, Expression expr){
		this.expr=expr;
		this.binding=binding;
	}
	
	/**
	 * @return
	 * @uml.property  name="binding"
	 */
	public boolean isBinding(){
		return binding;
	}
	public Value getValue(HashMap<Variable,Value> localVar){
		return expr.getValue(localVar);
	}
	
	/**
	 * @param binding
	 * @uml.property  name="binding"
	 */
	public void setBinding(boolean binding) {
		this.binding = binding;
	}
	


	
}
