package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class IfExpr extends Expression {
	
	private Expression e1;
	private Expression e2;
	private Expression e3;	

	public IfExpr(Expression e1, Expression e2, Expression e3) {
		super();
		this.e1=e1.deepCopy();
		this.e2=e2.deepCopy();
		this.e3=e3.deepCopy();
	}
	
/*	public IfExpr (Expression e){
		super();
	}*/
	
	public IfExpr(IfExpr exp){
		this.type = exp.type;
		this.e1 = exp.e1.deepCopy();
		this.e2 = exp.e2.deepCopy();
		this.e3 = exp.e3.deepCopy();
	}
	
	public Expression getE1() {
		return e1;
	}

	public void setE1(Expression e1) {
		this.e1 = e1;
	}

	public Expression getE2() {
		return e2;
	}

	public void setE2(Expression e2) {
		this.e2 = e2;
	}

	public Expression getE3() {
		return e3;
	}

	public void setE3(Expression e3) {
		this.e3 = e3;
	}
	
	@Override
	public Value getValue(HashMap<Variable, Value> localVar) {
		
		Value result=null;
		Value v1 = e1.getValue(localVar);
		Value v2 = e2.getValue(localVar);
		Value v3 = e3.getValue(localVar);
		
		if (v1.getType().equals("boolean") && v1.getVal().equals("true")) {
			result= v2;

		}
		else {
			result = v3;
			
		}
		return result;
	}


}
