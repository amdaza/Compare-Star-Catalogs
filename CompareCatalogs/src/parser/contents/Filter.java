package parser.contents;

public class Filter extends Statement {

	public Filter(Expression expr){
		super(false, expr);
	}

}
