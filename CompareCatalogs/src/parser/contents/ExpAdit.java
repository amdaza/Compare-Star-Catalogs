package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class ExpAdit extends Expression {

	/**
	 * @uml.property  name="op"
	 */
	private String op;
	/**
	 * @uml.property  name="e1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e1;
	/**
	 * @uml.property  name="e2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e2;

	public ExpAdit (Expression e1, Expression e2, String op){
		super();
		this.op=op;
		this.e1=e1.deepCopy();
		this.e2=e2.deepCopy();
		this.type = finalType(e1.getType(),e2.getType());///??????
	}

	public ExpAdit (ExpAdit exp){
		this.type = exp.type;
		this.e1 = exp.e1.deepCopy();
		this.e2 = exp.e2.deepCopy();
		this.op = exp.op;
	}

	public Value getValue(HashMap<Variable,Value> localvar )  { 
		Value result=null;
		Value v1 = e1.getValue(localvar);
		Value v2 = e2.getValue(localvar);
		
		switch(op) {
		case "+": 
			result = add(v1,v2);
			break;
		case "-":
			result = sub(v1,v2);
			break;
		}		
		return result;
	}

	private Value sub(Value v1, Value v2) {

		Value result= null;			
		if (isTypeNumeric()) {
			type = finalType( e1.getType(),e2.getType());
			
				switch (type){

				case "integer":
					int exp1 = v1.getInt();
					int exp2 = v2.getInt();
					int resul1 = exp1 - exp2;					
					result = new Value(String.valueOf(resul1), type);
					break;
				case "real":
					double exp3 = v1.getDouble();
					double exp4 = v2.getDouble();
					double resul2 = exp3 - exp4;
					result = new Value(String.valueOf(resul2), type);
					break;
				case "exponential":
					double exp5 = v1.getDouble();
					double exp6 = v2.getDouble();
					double resul3 = exp5 - exp6;
					result = new Value(String.valueOf(resul3), type);
					break;
				}
			
		}
		else {
			result = new Value("121", "error");
		}
		return result;
	}



	private Value add(Value v1, Value v2) {
		Value result= null;		
		
		if (isTypeNumeric()) {
			type = finalType( e1.getType(),e2.getType());	
			switch (type){
			case "integer":
				int exp1 = v1.getInt();
				int exp2 = v2.getInt();
				int resul1 = exp1 + exp2;					
				result = new Value(String.valueOf(resul1), type);
				break;
			case "real":
				double exp3 = v1.getDouble();
				double exp4 = v2.getDouble();
				double resul2 = exp3 + exp4;
				result = new Value(String.valueOf(resul2), type);
				break;
			case "exponential":
				double exp5 = v1.getDouble();
				double exp6 = v2.getDouble();
				double resul3 = exp5 + exp6;
				result = new Value(String.valueOf(resul3), type);
				break;
			
			}
		}
		else {
			result = new Value("121", "error");
		}
		return result;
	}

	
	
}


