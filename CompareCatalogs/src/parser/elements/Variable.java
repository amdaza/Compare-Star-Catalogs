package parser.elements;

public class Variable {


	private String name;
	private String type;	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

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
