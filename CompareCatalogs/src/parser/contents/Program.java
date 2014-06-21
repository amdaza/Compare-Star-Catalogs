package parser.contents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import parser.elements.*;


public class Program {

	/**
	 * @uml.property  name="statement"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="parser.contents.Statement"
	 */
	private ArrayList<Statement> statement;

	public Program(ArrayList<Statement> statement){
		this.statement=statement;
	}
	public boolean eval(LinkedHashMap<Variable,Value> row){
		boolean result = true;
		LinkedHashMap<Variable,Value> localvar = new LinkedHashMap<Variable,Value> ( row);
		Iterator<Statement> i = statement.iterator();
		while (i.hasNext() && result) {
			Statement s = i.next();
			if (s.isBinding ())  {
			
				Value v = s.getValue(localvar); 
				String vname = ((Binding) s).getName(); 
				Variable x = new Variable(vname, v.getType(), v.getVal());
				localvar.put(x, null);  
			} else {  
				Value v = s.getValue(localvar); 
				if (v.getType() != "bool") {
					
					result =  false; 
				} else  if (v.getVal()=="false")  result =  false;// es un bool

			} 
		}
		return result;
	}

}