package parser.elements;




public class Variable {

	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="type"
	 */
	private String type;
	/**
	 * @uml.property  name="value"
	 */
	private String value;

	public Variable(String name, String type, String value){
		this.name = name;
		this.type=type;
		this.value=value;

	}

	public Variable(String name, Value value){
		this.name = name;
		this.type= value.getType();
		this.value=value.getVal();

	}

	public Variable(String name, String type, Value value) {
		this.name = name;
		this.type= value.getType();
		this.value=value.getVal();

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

	public boolean equals(Object v1){
		if (v1 == null)
            return false;
        if (this == v1)
            return true;
        if (!(v1 instanceof Variable)) return false;

        Variable var = (Variable) v1;

        if(var.getName() == null ){

        	if (var.getName() != null) return false;
        }
      else return this.getName().equalsIgnoreCase(var.getName());

        return true;

	}

	public int hashCode() {
		int hash = 1;
		if ( name == null )
			hash = hash * 32;
		else{
			hash= hash*this.name.length();
		}
		return hash;
	}


}
