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
        
        if(var.getName() == null /*|| getType() == null || getValue()==null*/){
        	//if((name == null) ? (var.name != null) : !name.equals(var.name))return false;
        	if (var.getName() != null) return false;
        	//if (var.getType() != null) return false;
        	//if (var.getValue() != null) return false;
        }
      else return var.getName().equals(var.getName());
        		    //&& getType().equals(var.getType())
        		   // && getValue().equals(var.getValue());
        /*else return 
        	Objects.equals(this.name, var.name)
        	&& Objects.equals(this.type,var.type)
        	&& Objects.equals(this.value,var.value);*/
		//return this.name.equals(var.getName());
	
        return true;
        	
	}
	
	public int hashCode() {
		/*int hash = 7;
		hash = 97 * hash + this.name.hashCode();
		return hash;*/
		int hash = 1;
		if ( name == null /*|| type ==null || value == null*/ )
			hash = hash * 31;
		else{ 
			hash = hash * 31 + getName().hashCode();
			//hash = hash +31 + (name != null ? name.hashCode() : 0);
			//hash = hash * 31 + getType().hashCode();
			//hash = hash * 31 + getValue().hashCode();
		
		}
        return hash;
	}
	

}
