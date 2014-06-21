package parser.elements;

public class Token {
	/**
	 * @uml.property  name="tipo"
	 */
	private String tipo;
	/**
	 * @uml.property  name="atributo"
	 */
	private String atributo;
	/**
	 * @uml.property  name="fila"
	 */
	int fila;
	/**
	 * @uml.property  name="columna"
	 */
	int columna;

	/**
	 * 
	 * @param fila
	 * @param col
	 * @param tipo
	 * @param atributo
	 */
	public Token(int fila, int col, String tipo, String atributo) {
		this.fila = fila;
		this.columna = col;
		this.tipo = tipo;
		this.atributo = atributo;

	}

	/**
	 * 
	 * @param fila
	 * @param col
	 * @param tipo
	 */
	public Token(int fila, int col, String tipo) {
		this(fila, col, tipo, null);
	}

	/**
	 * 
	 * @param t
	 */
	public Token(Token t) {
		this.fila = t.fila;
		this.columna = t.columna;
		this.tipo = t.tipo;
		this.atributo = t.atributo;
	}

	/**
	 * 
	 * @return
	 */
	public String leeTipo() {
		return tipo;
	}

	/**
	 * 
	 * @return
	 */
	public int leeFila() {
		return fila;
	}

	/**
	 * 
	 * @return
	 */
	public int leeColumna() {
		return columna;
	}

	/**
	 * 
	 * @return
	 */
	public String readAtribute() {
		return atributo;
	}

	/**
	 * 
	 */
	public String toString() {
		if (atributo == null)
			return "<tipo: " + tipo.toString() + ",atributo: null >";
		else
			return "<tipo: " + tipo.toString() + ",atributo: "
					+ atributo.toString() + ">";
	}

	
	
}
