package kataDos;

abstract class Estudiante {
	
	protected String nombreEstudiante;
	
	public Estudiante(String nombreEstudiante) {
		super();
		this.nombreEstudiante = nombreEstudiante;
	}
	
	protected void realizarPresentacion() {		
		presentacionNombre();
		presentacionEstudio();
	}
	
	protected void presentacionNombre() {
		System.out.print("Mi nombre es: " + this.getNombreEstudiante());
	}
	
	protected abstract void presentacionEstudio();
	
	private void close() {
		// TODO Auto-generated method stub
		System.out.println("Se ejecuta proceso de cierre");
	}
	
	public static void use(TemplateAround templateAround, Estudiante estudiante) {
		try {
			templateAround.accept(estudiante);
		}finally {
			estudiante.close();
		}
	}	

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}
	
}
