package parser.lexical;

import javax.swing.JTextArea;

import parser.elements.*;
import parser.errors.Errors;



public class Lexical {

	/**
	 * attributes:
	 * state 	   - contains the current state in which we find ourselves.
	 * code 	   - code has to be analyzed.
	 * lexeme 	   - accumulate the characters read.
	 * row 	       - keeps the row in which the character is read.
	 * column 	   - keeps the column in which the character is read.
	 * character   - containing the current character.
	 * index	   - contains the order of the current character.
	 * startRow    - row where the token begins.
	 * startColumn - column where the token begins.
	 */


	enum lexicalStatus {
		/**
		 * @uml.property  name="iNITIAL"
		 * @uml.associationEnd
		 */
		INITIAL, /**
		 * @uml.property  name="iS_START_ASSIGNMENT"
		 * @uml.associationEnd
		 */
		IS_START_ASSIGNMENT, /**
		 * @uml.property  name="iS_NUMBER"
		 * @uml.associationEnd
		 */
		IS_NUMBER, /**
		 * @uml.property  name="iS_IDENTIFIER"
		 * @uml.associationEnd
		 */
		IS_IDENTIFIER,
		/**
		 * @uml.property  name="iS_PLUS"
		 * @uml.associationEnd
		 */
		IS_PLUS, /**
		 * @uml.property  name="iS_MINUS"
		 * @uml.associationEnd
		 */
		IS_MINUS, /**
		 * @uml.property  name="iS_BY"
		 * @uml.associationEnd
		 */
		IS_BY, /**
		 * @uml.property  name="iS_DIVIDED"
		 * @uml.associationEnd
		 */
		IS_DIVIDED, /**
		 * @uml.property  name="iS_EXPONENTIAL"
		 * @uml.associationEnd
		 */
		IS_EXPONENTIAL, /**
		 * @uml.property  name="iS_LESS"
		 * @uml.associationEnd
		 */
		IS_LESS, /**
		 * @uml.property  name="iS_MAJOR"
		 * @uml.associationEnd
		 */
		IS_MAJOR,
		/**
		 * @uml.property  name="iS_LESS_EQUAL"
		 * @uml.associationEnd
		 */
		IS_LESS_EQUAL, /**
		 * @uml.property  name="iS_MAJOR_EQUAL"
		 * @uml.associationEnd
		 */
		IS_MAJOR_EQUAL, /**
		 * @uml.property  name="iS_DIFFERENT"
		 * @uml.associationEnd
		 */
		IS_DIFFERENT, /**
		 * @uml.property  name="iS_EQUAL"
		 * @uml.associationEnd
		 */
		IS_EQUAL, /**
		 * @uml.property  name="iS_NEGATION"
		 * @uml.associationEnd
		 */
		IS_NEGATION, /**
		 * @uml.property  name="eS_CONJUNCION"
		 * @uml.associationEnd
		 */
		ES_CONJUNCION,
		/**
		 * @uml.property  name="iS_INITIAL_PARENTHESIS"
		 * @uml.associationEnd
		 */
		IS_INITIAL_PARENTHESIS, /**
		 * @uml.property  name="iS_FINAL_PARENTHESIS"
		 * @uml.associationEnd
		 */
		IS_FINAL_PARENTHESIS, /**
		 * @uml.property  name="pART_EXPONENTIAL"
		 * @uml.associationEnd
		 */
		PART_EXPONENTIAL, /**
		 * @uml.property  name="pART_EXPONENTIAL_2"
		 * @uml.associationEnd
		 */
		PART_EXPONENTIAL_2, /**
		 * @uml.property  name="pART_EXPONENTIAL_3"
		 * @uml.associationEnd
		 */
		PART_EXPONENTIAL_3,
		/**
		 * @uml.property  name="iS_COMMA"
		 * @uml.associationEnd
		 */
		IS_COMMA, /**
		 * @uml.property  name="iS_POINT"
		 * @uml.associationEnd
		 */
		IS_POINT, /**
		 * @uml.property  name="iS_EOF"
		 * @uml.associationEnd
		 */
		IS_EOF, /**
		 * @uml.property  name="iS_DOUBLE_QUOTES"
		 * @uml.associationEnd
		 */
		IS_DOUBLE_QUOTES,
		/**
		 * @uml.property  name="iS_INTERROGATION"
		 * @uml.associationEnd
		 */
		IS_INTERROGATION, /**
		 * @uml.property  name="iS_ASSIGNMENT"
		 * @uml.associationEnd
		 */
		IS_ASSIGNMENT, /**
		 * @uml.property  name="iS_SHARP"
		 * @uml.associationEnd
		 */
		IS_SHARP, /**
		 * @uml.property  name="iS_STRING"
		 * @uml.associationEnd
		 */
		IS_STRING, /**
		 * @uml.property  name="iS_STRING_END"
		 * @uml.associationEnd
		 */
		IS_STRING_END,
	    /**
		 * @uml.property  name="dECIMAL_PART"
		 * @uml.associationEnd
		 */
	    DECIMAL_PART, /**
		 * @uml.property  name="dECIMAL_PART_2"
		 * @uml.associationEnd
		 */
	    DECIMAL_PART_2, /**
		 * @uml.property  name="iS_CATALOG_ID"
		 * @uml.associationEnd
		 */
	    IS_CATALOG_ID, /**
		 * @uml.property  name="iS_CATALOG_ID_2"
		 * @uml.associationEnd
		 */
	    IS_CATALOG_ID_2, /**
		 * @uml.property  name="iS_SEMICOLON"
		 * @uml.associationEnd
		 */
	    IS_SEMICOLON

	};

	/**
	 * @uml.property  name="state"
	 * @uml.associationEnd
	 */
	private lexicalStatus state;
	/**
	 * @uml.property  name="console"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextArea console= new JTextArea();
	/**
	 * @uml.property  name="code"
	 */
	private String code;
	/**
	 * @uml.property  name="lexeme"
	 */
	private String lexeme;
	/**
	 * @uml.property  name="row"
	 */
	private int row;
	/**
	 * @uml.property  name="column"
	 */
	private int column;
	/**
	 * @uml.property  name="character"
	 */
	private int character;
	/**
	 * @uml.property  name="index"
	 */
	private int index;
	/**
	 * @uml.property  name="startRow"
	 */
	private int startRow;
	/**
	 * @uml.property  name="startColumn"
	 */
	private int startColumn;

	/**
	 * Constructura the lexical analyzer class, get the code to compile.
	 *
	 * @param input - program source code.
	 *
	 */
	public Lexical(String input) {
		this.code = input.toLowerCase() + ' ';
		row = 0;
		column = -1;
		index = 0;
		character = sigCar();

	}

	/**
	 * Method to the next token, which will collect characters until a valid token.
	 *
	 * @param
	 *
	 * @return Token
	 *
	 */
	@SuppressWarnings("incomplete-switch")
	public Token sigToken() {
		state = lexicalStatus.INITIAL;
		startRow = row;
		startColumn =column;
		lexeme = "";
		while (true) {
			switch (state) {
			case INITIAL:
				if (index == code.length()) {
					transita(lexicalStatus.IS_EOF);
				} else if (isLetter(character) && ((character == 's') || (character== 'p'))){
					transita(lexicalStatus.IS_CATALOG_ID);
				} else if (isLetter(character)) {
					transita(lexicalStatus.IS_IDENTIFIER);
				} else if (esDigito(character)) {
					transita(lexicalStatus.IS_NUMBER);
				} else if (character == ':') {
					transita(lexicalStatus.IS_START_ASSIGNMENT);
				} else if (character == '+') {
					transita(lexicalStatus.IS_PLUS);
				} else if (character == '-') {
					transita(lexicalStatus.IS_MINUS);
				} else if (character == '*') {
					transita(lexicalStatus.IS_BY);
				} else if (character == '/') {
					transita(lexicalStatus.IS_DIVIDED);
				} else if (character == '^') {
					transita(lexicalStatus.IS_EXPONENTIAL);
				} else if (character == '<') {
					transita(lexicalStatus.IS_LESS);
				} else if (character == '>') {
					transita(lexicalStatus.IS_MAJOR);
				} else if (character == '=') {
					transita(lexicalStatus.IS_EQUAL);
				} else if (character == '(') {
					transita(lexicalStatus.IS_INITIAL_PARENTHESIS);
				} else if (character == ')') {
					transita(lexicalStatus.IS_FINAL_PARENTHESIS);
				}else if (character == ',') {
					transita(lexicalStatus.IS_COMMA);
				} else if (character == '.') {
					transita(lexicalStatus.IS_POINT);}
				else if (character == ';') {
						transita(lexicalStatus.IS_SEMICOLON);
				} else if (character == '#') {
					transita(lexicalStatus.IS_SHARP);
				} else if (character == '"') {
					transita(lexicalStatus.IS_DOUBLE_QUOTES);
				} else if (isSep(character)) {
					transitaIgnorando(lexicalStatus.INITIAL);
				} else {
					return errorLexico();
				}
				break;

			case IS_CATALOG_ID:
				if (character == '.') {
					transita(lexicalStatus.IS_CATALOG_ID_2);
				} else {
					transita(lexicalStatus.IS_IDENTIFIER);
				}
				break;

			case IS_CATALOG_ID_2:
				if (isLetter(character) || esDigito(character) || character == '_'||character == '.') {
					transita(lexicalStatus.IS_CATALOG_ID_2);
				} else if (character == '?'){
					//return new Token(startRow, startColumn, "wds_id", lexeme);
					return new Token(startRow, startColumn, "wds_id", lexeme);
				} else {
					//return new Token(startRow, startColumn, "catalog_id", lexeme);
					return new Token(startRow, startColumn, "identificator", lexeme);
				}
				break;

			case IS_IDENTIFIER:
				if (isLetter(character) || esDigito(character) || character == '_'){

					transita(lexicalStatus.IS_IDENTIFIER);

				} else {
					return tokenPalabraReservada();
				}
				break;


			case IS_NUMBER:
				if (esDigito(character)) {
					transita(lexicalStatus.IS_NUMBER);
				} else if (character == '.') {
					transita(lexicalStatus.DECIMAL_PART);
				} else if (character == 'e') {
					transita(lexicalStatus.PART_EXPONENTIAL);
				} else {
					return new Token(startRow, startColumn, "integer", lexeme);
				}
				break;

			case DECIMAL_PART:
				if (esDigito(character)) {
					transita(lexicalStatus.DECIMAL_PART_2);
				} else {
					errorDecimal();
				}
				break;

			case DECIMAL_PART_2:
				if (esDigito(character)) {
					transita(lexicalStatus.DECIMAL_PART_2);
				} else if (character == 'e') {
					if(isSep(character)){
						transita(lexicalStatus.PART_EXPONENTIAL);
				    }
					transita(lexicalStatus.PART_EXPONENTIAL);
				} else {
					return new Token(startRow, startColumn, "real",lexeme);
				}
				break;

			case PART_EXPONENTIAL:
				if ((character == '-') || (character == '+')){
					transita(lexicalStatus.PART_EXPONENTIAL_2);
				}else if(esDigito(character)){
					transita(lexicalStatus.PART_EXPONENTIAL_2);
				}else {
					return errorExp1();
				}
				break;

			case PART_EXPONENTIAL_2:
				if (esDigito(character)) {
					transita(lexicalStatus.PART_EXPONENTIAL_3);
				} else {
					return errorExp2();
				}
				break;

			case PART_EXPONENTIAL_3:
				if (esDigito(character)) {
					transita(lexicalStatus.PART_EXPONENTIAL_3);
				} else {
					return new Token(startRow, startColumn, "exponential",lexeme);
				}
				break;


			case IS_START_ASSIGNMENT:
				if (character == '=') {
					transita(lexicalStatus.IS_ASSIGNMENT);
				} else {

					return errorAsig();
				}
				break;

			case IS_ASSIGNMENT:
				return new Token(startRow, startColumn, ":=", null);

			case IS_PLUS:
				return new Token(startRow, startColumn, "OP_ADIT", "+");

			case IS_MINUS:
				return new Token(startRow, startColumn, "OP_ADIT", "-");

			case IS_BY:
				return new Token(startRow, startColumn, "OP_MULT", "*");

			case IS_DIVIDED:
				return new Token(startRow, startColumn, "OP_MULT", "/");

			case IS_EXPONENTIAL:
				return new Token(startRow, startColumn, "OP_EXP", "^");

			case IS_LESS:

				if (character == '=') {
					transita(lexicalStatus.IS_LESS_EQUAL);
				} else if (character == '>') {
					transita(lexicalStatus.IS_DIFFERENT);
				} else {
					return new Token(startRow, startColumn, "OP_COMP", "<");
				}
				break;

			case IS_MAJOR:

				if (character == '=') {
					transita(lexicalStatus.IS_MAJOR_EQUAL);
				} else {
					return new Token(startRow, startColumn, "OP_COMP", ">");
				}
				break;

			case IS_LESS_EQUAL:
				return new Token(startRow, startColumn, "OP_COMP", "<=");

			case IS_MAJOR_EQUAL:
				return new Token(startRow, startColumn, "OP_COMP", ">=");

			case IS_DIFFERENT:
				return new Token(startRow, startColumn, "OP_IGU", "<>");

			case IS_EQUAL:
				return new Token(startRow, startColumn, "OP_IGU", "=");

			case IS_INITIAL_PARENTHESIS:
				return new Token(startRow, startColumn, "SEPAR", "(");

			case IS_FINAL_PARENTHESIS:
				return new Token(startRow, startColumn, "SEPAR", ")");

			case IS_COMMA:
				return new Token(startRow, startColumn, "SEPAR", ",");

			case IS_POINT:
					return new Token(startRow, startColumn, "SEPAR", ".");

			case IS_SHARP:
				return new Token(startRow, startColumn, "SEPAR", "#");

			case IS_SEMICOLON:
				return new Token(startRow, startColumn, "SEPAR",";");

			case IS_DOUBLE_QUOTES:
				if (character != '"') {
					lexeme = "" + character;
					transita(lexicalStatus.IS_STRING);
				}else {
					return new Token(startRow, startColumn, "string", "");
				}
				break;

			case IS_STRING:
				if (character == '"') {
					transita(lexicalStatus.IS_STRING_END);
				}else {
					transita(lexicalStatus.IS_STRING);
				}
				break;

			case IS_STRING_END:
				lexeme = lexeme.substring(2, lexeme.length()-1);/////
				System.out.println(lexeme);
				return new Token(startRow, startColumn, "string", lexeme);

			case IS_EOF:
				return new Token(startRow, startColumn, "EOF", null);
			}
		}
	}

	/**
	 * Method that tells us if the used token is a reserved word or just a valid ID.
	 *
	 * @param
	 *
	 * @return returns the token formed.
	 *
	 */

	private Token tokenPalabraReservada() {
		if (lexeme.equalsIgnoreCase("abs")) {
			return new Token(startRow, startColumn, "PAL_RES","abs");
		}else if (lexeme.equalsIgnoreCase("and")) {
			return new Token(startRow, startColumn, "OP_LOG", "and");
		}else if (lexeme.equalsIgnoreCase("arccosd")) {
			return new Token(startRow, startColumn, "PAL_RES","arccosd");
		}else if (lexeme.equalsIgnoreCase("arccoss")) {
			return new Token(startRow, startColumn, "PAL_RES","arccoss");
		}else if (lexeme.equalsIgnoreCase("arcsind")) {
			return new Token(startRow, startColumn, "PAL_RES","arcsind");
		}else if (lexeme.equalsIgnoreCase("arcsins")) {
			return new Token(startRow, startColumn, "PAL_RES","arcsins");
		}else if (lexeme.equalsIgnoreCase("arctand")) {
			return new Token(startRow, startColumn, "PAL_RES","arctand");
		}else if (lexeme.equalsIgnoreCase("arctans")) {
			return new Token(startRow, startColumn, "PAL_RES","arctans");
		}else if (lexeme.equalsIgnoreCase("cosd")) {
			return new Token(startRow, startColumn, "PAL_RES","cosd");
		}else if (lexeme.equalsIgnoreCase("coss")) {
			return new Token(startRow, startColumn, "PAL_RES","coss");
		}else if (lexeme.equalsIgnoreCase("d2sdec")) {
			return new Token(startRow, startColumn, "PAL_RES","d2sdec");
		}else if (lexeme.equalsIgnoreCase("d2sra")) {
			return new Token(startRow, startColumn, "PAL_RES","d2sra");
		}else if (lexeme.equalsIgnoreCase("dist")) {
			return new Token(startRow, startColumn, "PAL_RES","dist");
		}else if (lexeme.equalsIgnoreCase("div")) {
			return new Token(startRow, startColumn, "PAL_RES","div");
		}else if (lexeme.equalsIgnoreCase("else")) {
			return new Token(startRow, startColumn, "PAL_RES","else");
		}else if (lexeme.equalsIgnoreCase("false")) {
			return new Token(startRow, startColumn, "PAL_RES","false");
		}else if (lexeme.equalsIgnoreCase("if")) {
			return new Token(startRow, startColumn, "PAL_RES","if");
		}else if (lexeme.equalsIgnoreCase("mod")) {
			return new Token(startRow, startColumn, "PAL_RES","mod");
		}else if (lexeme.equalsIgnoreCase("not")) {
			return new Token(startRow, startColumn, "OP_LOG", "not");
		}else if (lexeme.equalsIgnoreCase("or")) {
			return new Token(startRow, startColumn, "OP_LOG", "or");
		}else if (lexeme.equalsIgnoreCase("s2d")) {
			return new Token(startRow, startColumn, "PAL_RES","s2d");
		}else if (lexeme.equalsIgnoreCase("sec")) {
			return new Token(startRow, startColumn, "PAL_RES","sec");
		}else if (lexeme.equalsIgnoreCase("sind")) {
			return new Token(startRow, startColumn, "PAL_RES","sind");
		}else if (lexeme.equalsIgnoreCase("sins")) {
			return new Token(startRow, startColumn, "PAL_RES","sins");
		}else if (lexeme.equalsIgnoreCase("tand")) {
			return new Token(startRow, startColumn, "PAL_RES","tand");
		}else if (lexeme.equalsIgnoreCase("tans")) {
			return new Token(startRow, startColumn, "PAL_RES","tans");
		}else if (lexeme.equalsIgnoreCase("then")) {
			return new Token(startRow, startColumn, "PAL_RES","then");
		}else if (lexeme.equalsIgnoreCase("true")) {
			return new Token(startRow, startColumn, "PAL_RES","true");
		}else {
			Token t= new Token(startRow, startColumn, "identificator", lexeme);
			return t;
		}
	}

	/**
	 * Method makes transition from one state to another,
	 * adding character to the current lexeme.
	 *
	 * @param  toState state to which it will travel.
	 *
	 * @return
	 */
	private void transita(lexicalStatus toState) {
		lexeme += (char) character;
		transitaIgnorando(toState);
	}

	/**
	 * Method that makes moving from one state to another,
	 * going on to the next character.
	 *
	 * @param toState state to which it will travel.
	 *
	 * @return
	 *
	 */
	private void transitaIgnorando(lexicalStatus toState) {
		state = toState;
		startRow = row;
		startColumn = column;
		if (state != lexicalStatus.IS_EOF)
			character = sigCar();
	}

	/**
	 * Method that checks whether the character is a letter received.
	 *
	 * @param car input character to analyze.
	 *
	 * @return returns true if it is a letter or false otherwise.
	 */
	private boolean isLetter(int car) {
		return (car >= 'a' && car <= 'z') || (car >= 'A' && car <= 'Z');
	}

	/**
	 * Method that checks whether the character is a digital received.
	 *
	 * @param car
	 *
	 * @return returns true if it is a digital or false otherwise.
	 */
	private boolean esDigito(int car) {
		return (car >= '0' && car <= '9');
	}

	/**
	 * Method that checks if the receiving character is a separator.
	 *
	 * @param car input character to analyze.
	 *
	 * @return returns true if a separator or false otherwise.
	 */
	private boolean isSep(int car) {
		return car == ' ' || car == '\t' || car == '\r' || car == '\b' || car == '\n';
	}

	/**
	 * Method that generates the lexical token mistake.
	 *
	 * @param
	 *
	 * @return returns the error token.
	 */
	private Token errorLexico() {
		String error = "LEXIC ERROR:" + "\n" + "Unknown character: '"
				+ (char) character + "' in line " + row + ", column "
				+ column + ".";
		transita(lexicalStatus.INITIAL);
		Token tok = new Token(startRow, startColumn, "Error",   ""+ (char)character);
		new Errors(201,tok,true,console);
		return new Token(startRow, startColumn, "Error", error);
	}

	/**
	 * Method that generates the lexical token mistake.
	 *
	 * @return returns the error token.
	 */
	private Token errorAsig() {
		String error = "LEXIC ERROR:" + "\n" + "Missing '=' after '"
				+ (char) character + "' in linr " + row + ", column "
				+ column + ".";
		transita(lexicalStatus.INITIAL);

		return new Token(startRow, startColumn, "Error", error);

	}

	/**
	 * Method that generates the lexical token mistake.
	 *
	 * @return  returns the error token.
	 */
	private Token errorDecimal() {
		String error = "LEXIC ERROR:" + "\n" + "Expecting decimal part after '"
				+ (char) character + "' in linr " + row + ", column "
				+ column + ".";
		transita(lexicalStatus.INITIAL);
		return new Token(startRow, startColumn, "Error", error);

	}

	/**
	 * Method that generates the lexical token mistake.
	 *
	 * @return returns the error token.
	 */
	private Token errorExp1() {
		String error = "LEXIC ERROR:" + "\n" + "Missing '-' after '"
				+ (char) character + "' to form an exponential number in linr " + row + ", column "
				+ column + ".";
		transita(lexicalStatus.INITIAL);
		return new Token(startRow, startColumn, "Error", error);
	}

	/**
	 * Method that generates the lexical token mistake.
	 *
	 * @return returns the error token.
	 */
	private Token errorExp2() {
		String error = "LEXIC ERROR:" + "\n" + "Missing number after '"
				+ (char) character + "' to form an exponential number in linr " + row + ", column "
				+ column + ".";
		transita(lexicalStatus.INITIAL);
		return new Token(startRow, startColumn, "Error", error);
	}

	/**
	 * Method advances to the next character.
	 *
	 * @return returns the next character.
	 */
	private int sigCar() {
		try {
			character = code.charAt(index);
			index++;
			if (character == '\n') {
				column = -1;
				row++;
			} else {
				column++;
			}
			return character;
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Error lexical: lack '}'");
			return '}';
		}
	}

	/**
	 * Metodo us back to the next character.
	 *
	 * @return returns the previous character.
	 */
	@SuppressWarnings("unused")
	private int antCar() {
		index--;
		character = (int) code.charAt(index - 1);
		if (character == '\n') {
			column = -1;
			row--;
		} else {
			column--;
		}
		return character;
	}

}