package parser.elements;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

	private HashMap<String, TSContent> ts;

	private SymbolTable superior;

	public SymbolTable(SymbolTable ts) {

		superior = ts;
		this.ts = new HashMap<String, TSContent>();
	}

	public SymbolTable(SymbolTable ts, HashMap<String, TSContent> mapa) {
		superior = ts;
		this.ts = mapa;
	}

	@SuppressWarnings("unchecked")
	public SymbolTable Copia() {
		SymbolTable nueva = new SymbolTable(superior,
				(HashMap<String, TSContent>) ts.clone());
		return nueva;
	}

	public SymbolTable() {

		ts = new HashMap<String, TSContent>();
		superior = null;
	}

	public Map<String, TSContent> anadeId(String id, TSContent reg) {
		if (existeId(id)) {
			return null;
		} else {
			ts.put(id, reg);
			return ts;
		}
	}

	public void anadeId1(String id, TSContent reg) {
		if (!existeId(id)) {
			ts.put(id, reg);
		}
	}

	public Map<String, TSContent> getTs() {
		return ts;
	}

	public void setTs(HashMap<String, TSContent> ts) {
		this.ts = ts;
	}

	public boolean existeId(String id) {
		if (ts.containsKey(id))
			return true;
		else
			return false;

	}

	public SymbolTable getSuperior() {
		return superior;

	}

	public TSContent getContenido(String id) {
		SymbolTable tsAux = this;
		while (tsAux.superior != null) { // || !tsAux.ts.containsKey(id)
			if (tsAux.ts.containsKey(id))
				return tsAux.ts.get(id);
			else
				tsAux = tsAux.superior;
		}
		if (tsAux.ts.containsKey(id))
			return tsAux.ts.get(id);
		else
			return null;
	}

	public void setSuperior(SymbolTable t) {
		superior = t;
	}
}
