package fp.tipos;

import java.time.LocalDate;
import java.util.List;

public class CursoConPracticas extends CursoOnLine {

	private List<String> empresas;
	private Integer numHoras;
	
	public CursoConPracticas(String id, String titulo, String organizacion, LocalDate fechaInicio, LocalDate fechaFin,
			Integer duracion, TipoCertificacion tipoCert, Double valoracion, NivelDificultad nivelDificultad,
			Integer numeroEstudiantes, Boolean gratuito,
			List<String> empresas, Integer numHoras) {
		super(id, titulo, organizacion, fechaInicio, fechaFin, duracion, tipoCert, valoracion, nivelDificultad,
				numeroEstudiantes, gratuito);
		//¡OJO! Esto lo vamos a modificar
		this.empresas=empresas;
		this.numHoras= numHoras;
	}

	public List<String> getEmpresas() {
		//OJO! Esto lo vamos a modificar
		return empresas;
	}

	public Integer getNumHoras() {
		return numHoras;
	}
	

	public Integer getNumEmpresas() {
		return empresas.size();
	}
	public String toString() {
		return super.toString() +","+ getEmpresas() + "," + getNumHoras();
	}
	
	public void agregarEmpresa(String empresa) {
		if (! empresas.contains(empresa)) {
			empresas.add(empresa);
		}
	}
	
	public void eliminarEmpresa(String empresa) {
		empresas.remove(empresa);
	}

}





