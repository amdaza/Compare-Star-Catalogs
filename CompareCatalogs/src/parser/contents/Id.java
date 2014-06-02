package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Id extends Expression {
	private String value;
	private String name;
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
			Variable v = new Variable(name,"","");
			result = localVar.get(v);
		}
		else result = new Value("129","error");
		return  result;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Expression getE() {
		return e;
	}
	
	public void setE(Expression e) {
		this.e = e;
	}


}
