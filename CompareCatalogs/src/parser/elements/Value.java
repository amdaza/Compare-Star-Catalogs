package parser.elements;

public class Value {

	/**
	 * @uml.property  name="val"
	 */
	private String val;
	/**
	 * @uml.property  name="type"
	 */
	private String type;

	public Value(String val, String type) {
		this.val=val;
		this.type=type;

	}

	/**
	 * @return
	 * @uml.property  name="val"
	 */
	public String getVal() {
		return val;
	}

	public void setval(String val) {
		this.val = val;
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
		return 	(this.type.equals("integer") || this.type.equals("exponential")
				|| this.type.equals("real")) || this.type.equals("boolean");
	}


}
