package kataDos;

public class KataExecuteAround {
		
    public static void main(String[] args){   	 
    	
    	System.out.println("--- Kata 2 ---");
    	
    	Estudiante estudiantePregrado = new Pregrado("David");    	
		Estudiante.use(new TemplateAround() {			
			@Override
			public void accept(Estudiante estudiante) {
				estudiante.realizarPresentacion();				
			}
		}, estudiantePregrado);    
		
		Estudiante estudiantePosgrado = new Posgrado("Alberto");    	
		Estudiante.use(new TemplateAround() {			
			@Override
			public void accept(Estudiante estudiante) {
				estudiante.realizarPresentacion();				
			}
		}, estudiantePosgrado); 
		
    }
}
