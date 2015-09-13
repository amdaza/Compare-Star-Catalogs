package parser.elements;

public class Token {
	
	private String tipo;	 
	private String atributo;
	private int fila;
	private int columna;


	public Token(int fila, int col, String tipo, String atributo) {
		this.fila = fila;
		this.columna = col;
		this.tipo = tipo;
		this.atributo = atributo;

	}

	public Token(int fila, int col, String tipo) {
		this(fila, col, tipo, null);
	}

	public Token(Token t) {
		this.fila = t.fila;
		this.columna = t.columna;
		this.tipo = t.tipo;
		this.atributo = t.atributo;
	}


	public String leeTipo() {
		return tipo;
	}

	public int leeFila() {
		return fila;
	}

	public int leeColumna() {
		return columna;
	}

	public String readAtribute() {
		return atributo;
	}

	public String toString() {
		if (atributo == null)
			return "<tipo: " + tipo.toString() + ",atributo: null >";
		else
			return "<tipo: " + tipo.toString() + ",atributo: "
					+ atributo.toString() + ">";
	}



}
