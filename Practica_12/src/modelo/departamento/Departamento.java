package modelo.departamento;

public class Departamento {
	private String nombredepa;
	private String codigo;
	private Empleado empleados;

	public String getNombredepa() {
		return nombredepa;
	}

	public void setNombredepa(String nombredepa) {
		this.nombredepa = nombredepa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Empleado getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleado empleados) {
		this.empleados = empleados;
	}

}
