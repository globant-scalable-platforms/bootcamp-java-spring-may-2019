package kataDos;

class Posgrado extends Estudiante {
	
	public Posgrado(String nombreEstudiante) {
		super(nombreEstudiante);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void presentacionEstudio() {
		// TODO Auto-generated method stub
		System.out.println(" y estudio posgrado");
	}
}
