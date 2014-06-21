package view;

public class String_Type {
	/**
	 * @uml.property  name="s"
	 */
	private String s;
	/**
	 * @uml.property  name="t"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private DataStructure.Type t;
	
	
	
	public String_Type(String s, DataStructure.Type t) {
		this.s = s;
		this.t = t;
	}
	/**
	 * @return
	 * @uml.property  name="s"
	 */
	public String getValue() {
		return s;
	}
	/**
	 * @param s
	 * @uml.property  name="s"
	 */
	public void setValue(String s) {
		this.s = s;
	}
	/**
	 * @return
	 * @uml.property  name="t"
	 */
	public DataStructure.Type getT() {
		return t;
	}
	/**
	 * @param t
	 * @uml.property  name="t"
	 */
	public void setT(DataStructure.Type t) {
		this.t = t;
	}

	
}
