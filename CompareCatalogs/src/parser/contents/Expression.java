package parser.contents;
import java.util.HashMap;

import parser.elements.*;



public abstract class Expression  {
	/*
	 * TYPES:
	 * Numerics:
	 *  - integer
	 *  - real
	 *  - exponential
	 * 
	 * - boolean
	 * - string
	 * 
	 * - error
	 */
	/**
	 * @uml.property  name="type"
	 */
	protected String type;
	protected boolean error;

	public abstract Value getValue(HashMap <Variable,Value> localVar);


	public Expression(){
		type = "";	
		error=false;
	}
	
	public Expression(String type) {
		this.type = type;
	}
	
	public Expression (Expression e) {
		this.type = e.getType();
	}
	

	public boolean isError() {
		return error;
	}


	public void setError(boolean error) {
		this.error = error;
	}

	
	public Expression deepCopy() {
        if (this instanceof Abs) {
            return new Abs((Abs)this);
        } else if (this instanceof Arccosd) {
            return new Arccosd((Arccosd)this);
        } else if (this instanceof Arccoss) {
            return new Arccoss((Arccoss)this);
        }else if (this instanceof Arcsind) {
            return new Arcsind((Arcsind)this);
        }else if (this instanceof Arcsins) {
            return new Arcsins((Arcsins)this);
        }else if (this instanceof Arctand) {
            return new Arctand((Arctand)this);
        }else if (this instanceof Arctans) {
            return new Arctans((Arctans)this);
        }else if (this instanceof Cosd) {
            return new Cosd((Cosd)this);
        }else if (this instanceof Coss) {
            return new Coss((Coss)this);
        }else if (this instanceof DecToSexaDecl) {
            return new DecToSexaDecl((DecToSexaDecl)this);
        }else if (this instanceof DecToSexaRa) {
            return new DecToSexaRa((DecToSexaRa)this);
        } else if (this instanceof Distance) {
            return new Distance((Distance)this);
        }else if (this instanceof ExpAdit) {
            return new ExpAdit((ExpAdit)this);
        }else if (this instanceof ExpEq) {
            return new ExpEq((ExpEq)this);
        }else if (this instanceof ExpExponential) {
            return new ExpExponential((ExpExponential)this);
        }else if (this instanceof ExpLog) {
            return new ExpLog((ExpLog)this);
        }else if (this instanceof ExpMult) {
            return new ExpMult((ExpMult)this);
        }else if (this instanceof Exponential) {
            return new Exponential((Exponential)this);
        }else if (this instanceof ExpRel) {
            return new ExpRel((ExpRel)this);
        }else if (this instanceof False) {
            return new False((False)this);
        }else if (this instanceof Id) {
            return new Id((Id)this);
        }else if (this instanceof IfExpr) {
            return new IfExpr((IfExpr)this);
        }else if (this instanceof Int) {
            return new Int((Int)this);
        }else if (this instanceof Less) {
            return new Less((Less)this);
        }else if (this instanceof Negation) {
            return new Negation((Negation)this);
        }else if (this instanceof Real) {
            return new Real((Real)this);
        }else if (this instanceof SexaToDec) {
            return new SexaToDec((SexaToDec)this);
        }else if (this instanceof Sind) {
            return new Sind((Sind)this);
        }else if (this instanceof Sins) {
            return new Sins((Sins)this);
        }else if (this instanceof Str) {
            return new Str((Str)this);
        }else if (this instanceof Tand) {
            return new Tand((Tand)this);
        }else if (this instanceof Tans) {
            return new Tans((Tans)this);
        }else if (this instanceof True) {
            return new True((True)this);
        }

        throw new Error("Unknown type of expression");
    }
	
	/**
	 * @return
	 * @uml.property  name="type"
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 * @uml.property  name="type"
	 */
	public void setType(String type) {
		this.type = type;
	}

	public boolean isTypeNumeric() {
			
		/*return	(type.equals("integer") || (type.equals("real"))||
				(type.equals("exponential")));*/
				
		/* orig*/
		return this.type.equals("integer") ||
				this.type.equals("real")   ||
				this.type.equals("exponential") || 
				this.type.equals("string")|| 
				this.type.equals("boolean");
		
			
	}
	public String finalType(String t1,String t2){

		String result = null;

		if((t1.equals("integer")) && (t2.equals("integer")))
			result="integer";
		else if ((t1.equals("real")) || (t2.equals("real")))
			result="real";
		else if ((t1.equals("exponential")) && (t2.equals("exponential")))
			result="exponential";
		else if ((t1.equals("integer")) && (t2.equals("exponential")))
			result="exponential";
		else if ((t1.equals("exponential")) && (t2.equals("integer")))
			result="exponential";		
		else result="error";
		return result;
	}



}
