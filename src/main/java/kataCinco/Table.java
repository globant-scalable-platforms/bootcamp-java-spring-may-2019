package kataCinco;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private String codigo;
	private List<Element> elementos = new ArrayList<Element>();
	
	public Table(String codigo) {
		super();
		this.codigo = codigo;
	}
	
	public void addElement(Element e) {
		elementos.add(e);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Element> getElementos() {
		return elementos;
	}

	public void setElementos(List<Element> elementos) {
		this.elementos = elementos;
	}
	
	
}
