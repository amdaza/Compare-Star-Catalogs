package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Id extends Expression {
	/**
	 * @uml.property  name="value"
	 */
	private String value;
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  
	 */
	private Expression e;

	public Id(String name, String type, String value){
		
		this.setName(name);
		this.type=type;
		this.value=value;
		
	}
	
	public Id (Expression e){
		super();
		this.e=e.deepCopy();
		this.type = e.getType();
	}
	
	public Id(Id exp){
		this.type=exp.type;
		this.value=exp.value;
		this.name=exp.name;
		//this.e = exp.e.deepCopy();
	}
	
	public Value getValue(HashMap<Variable,Value> localVar){
		Value result = null;
		if (isTypeNumeric()){
			Variable v = new Variable(name,type,"");
			result = localVar.get(v);//parece que lo pierde aqui el type devuelve null error en el hasCode
		}
		else{
			error=true;
			result = new Value("129","error");
		}
		return  result;
	}
	
	/**
	 * @return
	 * @uml.property  name="value"
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @param value
	 * @uml.property  name="value"
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return
	 * @uml.property  name="e"
	 */
	public Expression getE() {
		return e;
	}
	
	/**
	 * @param e
	 * @uml.property  name="e"
	 */
	public void setE(Expression e) {
		this.e = e;
	}


}
