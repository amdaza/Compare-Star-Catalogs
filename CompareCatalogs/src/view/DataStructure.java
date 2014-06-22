package view;

// This class will save second and third column of catalog data
public class DataStructure {
	/**
	 * @author    Delegacion01
	 */
	enum Type{/**
	 * @uml.property  name="a"
	 * @uml.associationEnd  
	 */
		A, /**
		 * @uml.property  name="i"
		 * @uml.associationEnd  
		 */
		I, /**
		 * @uml.property  name="f"
		 * @uml.associationEnd  
		 */
		F, /**
		 * @uml.property  name="e"
		 * @uml.associationEnd  
		 */
		E};

		/**
		 * @uml.property  name="mag"
		 */
		private String mag;
		/**
		 * @uml.property  name="type"
		 * @uml.associationEnd  
		 */
		private Type type;
		/**
		 * @uml.property  name="description"
		 */
		private String description;
		/**
		 * @uml.property  name="lenght"
		 */
		private int lenght;
		/**
		 * @uml.property  name="decimals"
		 */
		private int decimals;


		public DataStructure(){
			description="";
		}

		/**
		 * @return
		 * @uml.property  name="type"
		 */
		public Type getType() {
			return type;
		}

		public void setType(char type) {
			switch (type) {
			case 'a':
			case 'A':
				this.type = Type.A;
				break;
			case 'F':
				this.type = Type.F;
				break;
			case 'I':
				this.type = Type.I;
				break;
			case 'E':
				this.type = Type.E;
				break;
			}
		}
		public String getParserType(DataStructure.Type type){
			String result = null;
			switch (type) {			
			case A:		
				result = "string";
				break;
			case F:
				result = "real";
				break;
			case I:
				result = "integer";
				break;
			case E:
				result = "exponential";
				break;
			}
			return result;
		}

		/**
		 * @return
		 * @uml.property  name="description"
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description
		 * @uml.property  name="description"
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return
		 * @uml.property  name="mag"
		 */
		public String getMag() {
			return mag;
		}

		/**
		 * @param mag
		 * @uml.property  name="mag"
		 */
		public void setMag(String mag) {
			this.mag = mag;
		}

		public String toString() {
			return type + description ;
		}

		/**
		 * @return
		 * @uml.property  name="lenght"
		 */
		public int getLenght() {
			return lenght;
		}

		/**
		 * @param lenght
		 * @uml.property  name="lenght"
		 */
		public void setLenght(int lenght) {
			this.lenght = lenght;
		}

		/**
		 * @return
		 * @uml.property  name="decimals"
		 */
		public int getDecimals() {
			return decimals;
		}

		/**
		 * @param decimals
		 * @uml.property  name="decimals"
		 */
		public void setDecimals(int decimals) {
			this.decimals = decimals;
		}

		/**
		 * @param type
		 * @uml.property  name="type"
		 */
		public void setType(Type type) {
			this.type = type;
		}


}
