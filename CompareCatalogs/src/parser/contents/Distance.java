package parser.contents;

import java.util.HashMap;

import parser.elements.Value;
import parser.elements.Variable;

public class Distance extends Expression {

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
	/**
	 * @uml.property  name="e3"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e3;
	/**
	 * @uml.property  name="e4"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Expression e4;

	public Distance (Expression e1, Expression e2, Expression e3, Expression e4){
		super();
		this.e1=e1.deepCopy();
		this.e2=e2.deepCopy();
		this.e3=e3.deepCopy();
		this.e4=e4.deepCopy();
		this.type = "real";//////?????
	}
	
	public Distance(Distance exp){
		this.type = exp.type;
		this.e1 = exp.e1.deepCopy();
		this.e2 = exp.e2.deepCopy();
		this.e3 = exp.e3.deepCopy();
		this.e4 = exp.e4.deepCopy();
	}

	public Value getValue(HashMap<Variable,Value> localvar )  { 
		Value result = null;
		Value v1 = e1.getValue(localvar);
		Value v2 = e2.getValue(localvar);
		Value v3 = e3.getValue(localvar);
		Value v4 = e4.getValue(localvar);
		Double d1 = v1.getDouble();
		Double d2 = v2.getDouble();
		Double d3 = v3.getDouble();
		Double d4 = v4.getDouble();
		if (checkTypes(v1,v2,v3,v4)) {
			//Calculate distance
			double dist = distance(d1,d2,d3,d4);
			result = new Value(String.valueOf(dist), "real");
		}
		else {
			error=true;
			result = new Value("119","error");
		}
		return result;
	}

    private double distance(double ra1, double dec1, double ra2, double dec2) {
    	double a = Math.pow(Math.sin(Math.toRadians((dec2-dec1)/2)),2) + 
                   Math.cos(Math.toRadians(dec1))*Math.cos(Math.toRadians(dec2))*Math.pow(Math.sin(Math.toRadians((ra2-ra1)/2)), 2);
        double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        //double ap1 = Math.toDegrees(Math.asin(Math.cos(Math.toRadians(s2.dec)))*Math.sin(Math.toRadians(s2.ra-this.ra))/Math.sin(c));
        double d = Math.toDegrees(c)*3600;        
        return d;

    }
    
    private boolean checkTypes(Value v1, Value v2, Value v3, Value v4){
    	boolean valid = false;
    	if((v1.getType() == v2.getType()) && (v1.getType() == v3.getType()) 
    		&& (v1.getType() == v4.getType())){
    		if(v1.getType() == "integer" || v1.getType() == "real" || v1.getType() == "exponential"){
    			valid = true;
    		}
    	}
    	return valid;
    }

}
