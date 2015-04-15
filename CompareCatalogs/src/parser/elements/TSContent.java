package parser.elements;

import java.util.LinkedList;

public class TSContent {
	private String type;
	private String baseType;
	private int posIni;
	private int posFin;
	private int argsNum;
	private LinkedList<String> argsType; // linkedlist in case of
											// method or function call
	private int argsPass;
	private LinkedList<String> returnList; // linkedlist in case of function which
										// returns more than one argument
	private int size;
	private SymbolTable childTable;
	private LinkedList<TSContent> pointer; // linkedlist in case it's a pointer

	public TSContent(String tipo, String tipoBase, int posIni, int posFin,
			int NumArgs, LinkedList<String> TipoArgs, int pasoArgs,
			LinkedList<String> retorno, int tamanio, SymbolTable th,
			LinkedList<TSContent> puntero) {
		this.setType(tipo);
		this.setBaseType(tipoBase);
		this.setPosIni(posIni);
		this.setPosFin(posFin);
		this.setArgsPass(pasoArgs);
		this.setReturnList(retorno);
		this.setSize(tamanio);
		this.setChildTable(th);
		this.setArgsType(TipoArgs);
		this.setArgsNum(NumArgs);
		this.setPointer(puntero);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public int getPosIni() {
		return posIni;
	}

	public void setPosIni(int posIni) {
		this.posIni = posIni;
	}

	public int getPosFin() {
		return posFin;
	}

	public void setPosFin(int posFin) {
		this.posFin = posFin;
	}

	public int getArgsNum() {
		return argsNum;
	}

	public void setArgsNum(int argsNum) {
		this.argsNum = argsNum;
	}

	public LinkedList<String> getArgsType() {
		return argsType;
	}

	public void setArgsType(LinkedList<String> typeArgs) {
		this.argsType = typeArgs;
	}

	public int getArgsPass() {
		return argsPass;
	}

	public void setArgsPass(int argsPass) {
		this.argsPass = argsPass;
	}

	public LinkedList<String> getReturnList() {
		return returnList;
	}

	public void setReturnList(LinkedList<String> returnList) {
		this.returnList = returnList;
	}

	public SymbolTable getChildTable() {
		return childTable;
	}

	public void setChildTable(SymbolTable childTable) {
		this.childTable = childTable;
	}

	public void setPointer(LinkedList<TSContent> pointer) {
		this.pointer = pointer;
	}

	public LinkedList<TSContent> getPointer() {
		return pointer;
	}
}
