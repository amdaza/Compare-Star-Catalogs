package parser.contents;

public class Binding extends Statement{
	
	private String name;
		
	public Binding (Expression expr, String name){
		super(true,expr);
		this.setName(name);
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}
