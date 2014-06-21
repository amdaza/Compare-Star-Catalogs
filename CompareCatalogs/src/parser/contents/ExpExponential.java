package parser.contents;

import java.util.HashMap;

import parser.elements.*;

public class ExpExponential extends Expression {

	/**
	 * @uml.property  name="e1"
	 * @uml.associationEnd  
	 */
	private Expression e1;
	/**
	 * @uml.property  name="e2"
	 * @uml.associationEnd  
	 */
	private Expression e2;

	public ExpExponential (Expression e1, Expression e2){
		super();
		this.e1=e1.deepCopy();
		this.e2=e2.deepCopy();
		this.type = "real";
	}

	public ExpExponential (Expression e){
		super();
	}
	public ExpExponential(ExpExponential exp){
		this.type = exp.type;
	}

	public Value getValue(HashMap<Variable,Value> localvar )  { 
		Value result=null;
		Value v1 = e1.getValue(localvar);
		Value v2 = e2.getValue(localvar);
		if (isTypeNumeric()){
			result = exponential(v1,v2);
		}else {
			result = new Value("124", "error");
		}
			
		return result;
	}

	private Value exponential(Value v1, Value v2) {
		double exp1 = v1.getDouble();
		double exp2 = v2.getDouble();
		double resul1 = Math.pow(exp1,exp2);					
		return new Value(String.valueOf(resul1), "real");

	}

}