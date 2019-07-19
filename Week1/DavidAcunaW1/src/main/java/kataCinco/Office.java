package kataCinco;

import java.util.ArrayList;
import java.util.List;

public class Office {

	private String nombre;
	private List<Table> tablas = new ArrayList<Table>();
	
	public Office(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void addTable(Table t) {
		tablas.add(t);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Table> getTablas() {
		return tablas;
	}
	public void setTablas(List<Table> tablas) {
		this.tablas = tablas;
	}
}
