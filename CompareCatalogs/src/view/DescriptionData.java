package view;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;

import parser.elements.Variable;

public class DescriptionData{

	private LinkedHashMap<String, DataStructure> catalogStructure;
	private String path;
	private final String init = "#---Details of Columns:";
	private Vector<StarRow> stars;
	private boolean empty;
	private int contador = 0;
	private String header;

	public DescriptionData(){

		this.setDt(new LinkedHashMap<String, DataStructure>());
		this.stars = new Vector<StarRow>();
		header = "";
	}

	public DescriptionData(String path){
		this.path = path;
		this.setDt(new LinkedHashMap<String, DataStructure>());
		this.stars = new Vector<StarRow>();
		empty = true;
		header = "";
	}

	public Vector<StarRow> getStars() {
		return stars;
	}

	public void setStars(Vector<StarRow> stars) {
		this.stars = stars;
	}

	public LinkedHashMap<String, DataStructure> getDt() {
		return catalogStructure;
	}

	public void setDt(LinkedHashMap<String, DataStructure> dt) {
		this.catalogStructure = dt;
	}


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public LinkedHashMap<String, DataStructure> parser(){

		File archive = null;
	    FileReader fr = null;
	    BufferedReader br = null;
		try {
	         // Open file and create BufferedReader
	         // for reading (using readLine()).
	         archive = new File (path);
	         fr = new FileReader (archive);
	         br = new BufferedReader(fr);
	         String line;
	         //RAJ2000 (deg) (F10.6) (ra) Right ascension (J2000) [ucd=pos.eq.ra;meta.main]
	         try{
		         while(!(line=br.readLine()).equals(init));

		         while(!(line=br.readLine()).substring(0, 1).equals("-")){
		        	 String key;
		     		 DataStructure value = new DataStructure();
		        	 int i=4;
		        	 while(line.charAt(i)!= ' '){//R
		        		 i++;
		        	 }
		        	 key = line.substring(4, i);//RAJ2000		        	 

		        	 while(line.charAt(i)== ' '){
		        		 i++;
		        	 }
		        	 if(!Character.isDigit(line.charAt(i+2))){
		        		 int j=i;
		        		 while(line.charAt(j)!= ' '){
			        		 j++;
			        	 }
		        		 value.setMag(line.substring(i, j));//(deg)		        		
		        		 i=j;
		        		 while(line.charAt(i)== ' '){
			        		 i++;
			        	 }
		        	 }
		        	 char type = line.charAt(i+1);
		        	 value.setType(type);

		        	 if (type == 'F'){
		        		 if(line.charAt(i+3) == '.'){
		        			 int lenght = Integer.parseInt(Character.toString(line.charAt(i+2)));
		        			 value.setLenght(lenght);
		        			 int dec = Integer.parseInt(Character.toString(line.charAt(i+4)));
		        			 value.setDecimals(dec);
		        			 i= i+5;
		        		 }else{
		        			 int lenght = Integer.parseInt(line.substring(i+2, i+4));
		        			 value.setLenght(lenght);
		        			 int dec = Integer.parseInt(Character.toString(line.charAt(i+5)));
		        			 value.setDecimals(dec);
		        			 i= i+6;
		        		 }
		        	 }else if(line.charAt(i+3) == ')'){
				        		 int lenght = Integer.parseInt(Character.toString(line.charAt(i+2)));
			        			 value.setLenght(lenght);
			        			 i= i+3;
		        	 		}else{
				        		 int lenght = Integer.parseInt(line.substring(i+2, i+4));
			        			 value.setLenght(lenght);
			        			 i= i+4;
		        	 		}
		        	 String description = line.substring(i+1, line.length());
		        	 value.setDescription(description);

        			

        			 //Add new element into LinkedHashMap
        			 catalogStructure.put(key, value);
		         }
		         //End of description

		         //Header
		         header += line + "\n";
		         while(!(line=br.readLine()).substring(0, 1).equals("-")){
		        	 header += line + "\n";
		         }
		         header += line + "\n";
		         

		         //Stars
		         while((line=br.readLine()).length()!=0){
		        	int i=0;


		        	String value = "";
				    StarRow starRow = new StarRow(line);

		        	for (Map.Entry<String,DataStructure> entry : catalogStructure.entrySet()) {
					    String key = entry.getKey();
					    DataStructure dst = entry.getValue();
					    int lenght= dst.getLenght();
					    try{
					    	value= line.substring(i, i+lenght);
						    i += lenght+1;
						    DataStructure.Type type = dst.getType();

					    	if(type != DataStructure.Type.A){//To supress white spaces in numbers
						    	value.replaceAll("\\s+","");
					    	}
						    String_Type st = new  String_Type(value,type);
						    starRow.getStar().put(key, st);

					    }
					    catch(java.lang.StringIndexOutOfBoundsException ex){
					    	//i += lenght+1;
					    	DataStructure.Type type = dst.getType();
						    String_Type st = new  String_Type("",type);
						    starRow.getStar().put(key, st);
					    }


					}
		           stars.add(starRow);

		         }
		         empty = false;
		         contador=setContador(stars.size());

	         }catch (java.lang.StringIndexOutOfBoundsException ex){
	   			 fr.close();
	   			 br.close();
	   			 ex.printStackTrace();
	   			 /*Exception e;
	   			 throw e= new Exception();*/
	   			 JOptionPane.showMessageDialog(null,ex.getMessage());
	         }catch (java.lang.NullPointerException ex){
	        	 //There's no stars for this
	        	 empty = true;
	         }
		 }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	    	  // Here we close file, to make sure that
	    	  // it closes even if everything's ok
	    	  // or there is an exception
	         try{
	            if( null != fr ){
	               fr.close();
	            }
	         }catch (Exception e2){
	            e2.printStackTrace();
	         }
	      }

		return catalogStructure;

	}

	private int setContador(int size) {
		return this.contador= size;
	}

	public int getContador(){
		return contador;
	}
	public Vector<Variable> variablesForParser(String catalog){
		Vector <Variable> variables = new Vector <Variable>();
		for (Map.Entry<String,DataStructure> entry : catalogStructure.entrySet()) {
			 String key = entry.getKey();
			 DataStructure dst = entry.getValue();
			 String type = dst.getParserType(dst.getType());
			 System.out.println(key+type);
			 Variable var= new Variable(catalog + "." + key,type,"");
			 variables.add(var);
		}

		return variables;
	}


}

