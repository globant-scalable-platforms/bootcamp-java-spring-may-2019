package kataCinco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KataCinco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Office oficina_1 = new Office("Globant");
		
		Table tabla1 = new Table("1_Uno");
		Table tabla2 = new Table("1_Dos");
		Table tabla3 = new Table("1_Tres");
		
		Element elemento1 = new Element("AAA");
		Element elemento2 = new Element("CCC");
		Element elemento3 = new Element("YYY");
		Element elemento4 = new Element("UUU");
		Element elemento5 = new Element("HHH");
		Element elemento6 = new Element("PPP");
		
		tabla1.addElement(elemento1);
		tabla1.addElement(elemento2);
		
		tabla2.addElement(elemento3);
		tabla2.addElement(elemento4);
		
		tabla3.addElement(elemento5);
		tabla3.addElement(elemento6);
	
		oficina_1.addTable(tabla1);
		oficina_1.addTable(tabla2);
		oficina_1.addTable(tabla3);
		
		Office oficina_2 = new Office("Oracle");
		
		Table tabla4 = new Table("2_Uno");
		Table tabla5 = new Table("2_Dos");
		Table tabla6 = new Table("2_Tres");
		
		Element elemento7 = new Element("DDD");
		Element elemento8 = new Element("LLL");
		Element elemento9 = new Element("FFF");
		Element elemento10 = new Element("KKK");
		Element elemento11 = new Element("XXX");
		Element elemento12 = new Element("ZZZ");
		
		tabla4.addElement(elemento7);
		tabla4.addElement(elemento8);
		
		tabla5.addElement(elemento9);
		tabla5.addElement(elemento10);
		
		tabla6.addElement(elemento11);
		tabla6.addElement(elemento12);
	
		oficina_2.addTable(tabla4);
		oficina_2.addTable(tabla5);
		oficina_2.addTable(tabla6);
		
		 List<Office> oficinas = new ArrayList<>();	
		 oficinas.add(oficina_1);
		 oficinas.add(oficina_2);
		 
//		 System.out.println("--- Oficinas ---");
//		 
//		 oficinas.stream().map(ofi -> ofi.getNombre()).forEach(element ->
//		 	System.out.println(element)
//		 );
		 
//		 System.out.println("--- Tablas ---");
		 
		 List<Table> tablasOficinas = oficinas.stream()
				 .map(o -> o.getTablas())
				 .flatMap(t -> t.stream())
				 .distinct()
				 .collect(Collectors.toList());
		 
//		tablasOficinas.forEach(element -> System.out.println(element.getCodigo()));
		
		System.out.println("--- Elementos ---");
		 
		 List<Element> todosElementos = oficinas.stream()
				 .map(Office::getTablas)
				 .flatMap(Collection::stream)
				 .collect(Collectors.toList())
				 .stream()
				 .map(Table::getElementos)
				 .flatMap(Collection::stream)
				 .sorted(Comparator.comparing(Element::getCodigo))
				 .limit(7)				 
				 .collect(Collectors.toList());		
				 
		 
		 todosElementos.forEach(element -> System.out.println(element.getCodigo()));
		
	 }

}
