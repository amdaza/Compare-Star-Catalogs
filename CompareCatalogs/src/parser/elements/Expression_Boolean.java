package parser.elements;

import parser.contents.Expression;

public class Expression_Boolean {
	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e;
	/**
	 * @uml.property  name="b"
	 */
	private boolean b;
	
	public Expression_Boolean(Expression e, boolean b){
		this.e = e;
		this.b = b;
	}
	
	public Expression getExpression() {
		return e;
	}
	public void setExpression(Expression e) {
		this.e = e;
	}
	public boolean isCorrect() {
		return b;
	}
	public void setCorrect(boolean b) {
		this.b = b;
	}
	
	
}
