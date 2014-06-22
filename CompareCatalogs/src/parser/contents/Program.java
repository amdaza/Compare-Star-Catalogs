package parser.contents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.JTextArea;

import parser.elements.*;
import parser.errors.Errors;


public class Program {

	/**
	 * @uml.property  name="statement"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="parser.contents.Statement"
	 */
	private ArrayList<Statement> statement;

	public Program(ArrayList<Statement> statement){
		this.statement=statement;
	}
	@SuppressWarnings("unused")
	public boolean eval(LinkedHashMap<Variable,Value> row, JTextArea console){
		boolean result = true;
		LinkedHashMap<Variable,Value> localvar = new LinkedHashMap<Variable,Value> ( row);
		Iterator<Statement> i = statement.iterator();
		while (i.hasNext() && result) {
					
			Statement s = i.next();
			Value v = s.getValue(localvar);
			if(v.getType().equals("error")){

				int numError = Integer.parseInt(v.getVal());
				Errors e = new Errors(numError, console);
			}

			else if (s.isBinding ())  {		

				String vname = ((Binding) s).getName(); 
				Variable var = new Variable(vname, v.getType(), v.getVal());
				Value val = new Value(v.getVal(),v.getType() );
				localvar.put(var, val);  
			} else {  				
				if (v.getType() != "boolean") {
					result =  false; 
				} 
				else  if (v.getVal()=="false")  result =  false;// es un bool

			} 
		}
		return result;
	}

}