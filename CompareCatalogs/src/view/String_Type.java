package view;

public class String_Type {

	private String s;
	private DataStructure.Type t;



	public String_Type(String s, DataStructure.Type t) {
		this.s = s;
		this.t = t;
	}

	public String getValue() {
		return s;
	}

	public void setValue(String s) {
		this.s = s;
	}

	public DataStructure.Type getT() {
		return t;
	}

	public void setT(DataStructure.Type t) {
		this.t = t;
	}


}
