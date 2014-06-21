package parser.contents;

public class Binding extends Statement{
	
	/**
	 * @uml.property  name="name"
	 */
	private String name;
		
	public Binding (Expression expr, String name){
		super(true,expr);
		this.setName(name);
		
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
	

}
