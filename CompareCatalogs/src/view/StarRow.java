package view;

import java.util.LinkedHashMap;
import java.util.Map;

import parser.elements.Value;
import parser.elements.Variable;

public class StarRow {

	private LinkedHashMap<String, String_Type> star;
	private String line;
	private boolean validStar = true;

	StarRow(String line){
		star = new LinkedHashMap<String, String_Type>();
		this.line = line;
	}

	public boolean isValidStar() {
		return validStar;
	}

	public void setValidStar(boolean validStar) {
		this.validStar = validStar;
	}
	
	public void notValidStar(){
		this.validStar = false;
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
	private int sexaToDegreeOrHour(String sexa){
		return Integer.parseInt(sexa.split(" ")[0]);
	}

	private int sexaToMin(String sexa){
		return Integer.parseInt(sexa.split(" ")[1]);
	}

	private double sexaToSec(String sexa){
		return Double.parseDouble(sexa.split(" ")[2]);
	}
	
	private double sexaToDecDecl(String sexa){
		double res = 0;
		double deg = sexaToDegreeOrHour(sexa);
		double min = sexaToMin(sexa);
		double sec = sexaToSec(sexa);
		if(deg > 0){
			res= deg+min/60+sec/3600;
		}else{
			res= deg-min/60-sec/3600;
		}
		return res;
	}

	private double sexaToDecRa(String sexa){
		double res = 0;
		double hours = sexaToDegreeOrHour(sexa);
		double min = sexaToMin(sexa);
		double sec = sexaToSec(sexa);
			res= 15*(hours+min/60+sec/3600);
		return res;
	}
	
	private double distance(double ra1, double dec1, double ra2, double dec2) {
		double a = Math.pow(Math.sin(Math.toRadians((dec2-dec1)/2)),2) +
				Math.cos(Math.toRadians(dec1))*Math.cos(Math.toRadians(dec2))*Math.pow(Math.sin(Math.toRadians((ra2-ra1)/2)), 2);
		double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
		//double ap1 = Math.toDegrees(Math.asin(Math.cos(Math.toRadians(s2.dec)))*Math.sin(Math.toRadians(s2.ra-this.ra))/Math.sin(c));
		double d = Math.toDegrees(c)*3600;
		return d;

	}

	
	public double distance(StarRow star2){
		String stringRa1 = this.getStar().get("RAJ2000").getValue();
		double ra1, dec1, ra2, dec2;
		if(stringRa1.indexOf(" ") == -1){
			ra1 = Double.parseDouble(stringRa1);
		} else {
			ra1 = sexaToDecRa(stringRa1);
		}
		
		String stringDec1 = this.getStar().get("DEJ2000").getValue();
		if(stringDec1.indexOf(" ") == -1){
			dec1 = Double.parseDouble(stringDec1);
		} else {
			//dec1 = sexaToDecRa(stringDec1);
			dec1 = sexaToDecDecl(stringDec1);
		}
		
		String stringRa2 = star2.getStar().get("RAJ2000").getValue();
		if(stringRa2.indexOf(" ") == -1){
			ra2 = Double.parseDouble(stringRa2);
		} else {
			ra2 = sexaToDecRa(stringRa2);
		}
		
		String stringDec2 = star2.getStar().get("DEJ2000").getValue();
		if(stringDec2.indexOf(" ") == -1){
			dec2 = Double.parseDouble(stringDec2);
		} else {
			//dec2 = sexaToDecRa(stringDec2);
			dec2 = sexaToDecDecl(stringDec2);
		}
		
		return distance(ra1, dec1, ra2, dec2);
	}


}
