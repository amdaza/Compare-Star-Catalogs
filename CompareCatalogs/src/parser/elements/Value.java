package parser.elements;

public class Value {
	
	private String val;
	private String type;

	public Value(String val, String type) {
		this.val=val;
		this.type=type;
		
	}

	public String getVal() {
		return val;
	}

	public void setval(String val) {
		this.val = val;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int getInt() {
		
		return Integer.parseInt(val) ;
	}

	public double getDouble() {
		
		return Double.parseDouble(val);
	}

	public String getString() {
		
		return val;
	}

	public boolean isTypeNumeric(){
		return //(this.type.equals("string") || this.type.equals("string")) ||
				(this.type.equals("integer") || this.type.equals("exponential") 
				|| this.type.equals("real"));
	}
	
	
}
