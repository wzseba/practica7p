import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GestionEmpleados {

	List<Empleado> listaEmpleado;

	public GestionEmpleados() {
		this.listaEmpleado = new ArrayList<>();
	}

	public void leerArchivo() {

		try (BufferedReader br = new BufferedReader(new FileReader("empleados.csv"))) {

			String linea;

			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");

				String nombre = datos[0];
				String sector = datos[1];
				Double salario = Double.parseDouble(datos[2]);

				Empleado empleado = new Empleado(nombre, sector, salario);
				listaEmpleado.add(empleado);

			}

		} catch (IOException e) {
			System.err.println("Error de lectura " + e.getMessage());
		}
	}

	public Map<String, List<Empleado>> cargarMapEmpleado() {

		Map<String, List<Empleado>> mapEmpleado = new TreeMap<>();

		for (Empleado empleado : listaEmpleado) {
			List<Empleado> liEmple = mapEmpleado.getOrDefault(empleado.getSector(), new ArrayList<Empleado>());
			liEmple.add(empleado);
			mapEmpleado.put(empleado.getSector(), liEmple);
		}

		return mapEmpleado;
	}

	public static void main(String[] args) {
		GestionEmpleados ge = new GestionEmpleados();
		ge.leerArchivo();

		Map<String, List<Empleado>> lista = ge.cargarMapEmpleado();

		for (Map.Entry<String, List<Empleado>> entry : lista.entrySet()) {
			String sector = entry.getKey();
			List<Empleado> listEmpleados = entry.getValue();

			System.out.println(sector);
			for (Empleado e : listEmpleados) {
				System.out.println(e.toString());
			}

		}
	}

}
