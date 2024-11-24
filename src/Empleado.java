
public class Empleado {

	private String sector;
	private String nombre;
	private double salario;

	public Empleado(String nombre, String sector, double salario) {
		this.nombre = nombre;
		this.sector = sector;
		this.salario = salario;
	}

	public String getSector() {
		return sector;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + " " + "salario: " + salario;
	}

}
