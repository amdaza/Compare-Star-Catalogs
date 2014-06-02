package parser.contents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import parser.elements.*;


public class Program {

	private ArrayList<Statement> statement;

	public Program(ArrayList<Statement> statement){
		this.statement=statement;
	}
	public boolean eval(HashMap<Variable,Value> row){
		boolean result = true;
		HashMap<Variable,Value> localvar = new HashMap<Variable,Value> ( row);
		Iterator<Statement> i = statement.iterator();
		while (i.hasNext() && result) {
			Statement s = i.next();
			if (s.isBinding ())  {
			
				Value v = s.getValue(localvar); 
				String vname = ((Binding) s).getName(); 
				Variable x = new Variable(vname, v.getType(), v.getVal());
				localvar.put(x, null);  // ojo redefinir equal en variable->solo varname
			} else {  
				Value v = s.getValue(localvar); 
				if (v.getType() != "bool") {
					//FATAL ERROR
					result =  false; 
				} else  if (v.getVal()=="false")  result =  false;// es un bool

			} 
		}
		return result;
	}

}