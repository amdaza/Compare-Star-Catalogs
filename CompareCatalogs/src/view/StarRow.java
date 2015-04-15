package view;

import java.util.LinkedHashMap;
import java.util.Map;

import parser.elements.Value;
import parser.elements.Variable;

public class StarRow {
	/**
	 * @uml.property  name="star"
	 * @uml.associationEnd  qualifier="key:java.lang.String view.String_Type"
	 */
	private LinkedHashMap<String, String_Type> star;
	private String line;
	
	StarRow(String line){
		star = new LinkedHashMap<String, String_Type>();
		this.line = line; 
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
	
	public LinkedHashMap<String, String_Type> getStar() {
		return star;
	}

	public void setStar(LinkedHashMap<String, String_Type> star) {
		this.star = star;
	}
	
	public LinkedHashMap<Variable, Value> starRowToVariable(String catalog){//Catalog is P or S

		DataStructure dt = new DataStructure();
		LinkedHashMap<Variable, Value> result = new LinkedHashMap<Variable, Value>();
		for (Map.Entry<String,String_Type> entry : star.entrySet()) {
			String_Type st = entry.getValue();
			String name = catalog+"."+entry.getKey();
			String type = dt.getParserType(st.getT());
			String value = st.getValue();

			Variable var = new Variable(name,type,value);
			Value val = new Value(value,type);
			result.put(var, val);

		}		
		return result;
		
	}
	
	
}
