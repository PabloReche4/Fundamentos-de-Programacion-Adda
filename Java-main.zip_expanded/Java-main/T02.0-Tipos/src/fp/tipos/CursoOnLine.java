package fp.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import utiles.Checkers;
import utiles.Validators;

public class CursoOnLine {
	//Constante
	private static final Integer DURACION_MINIMA=1;
	private static final Double VALORACION_MINIMA = 0.0;
	private static final Double VALORACION_MAXIMA = 5.0;
	
	//Atributos
	private String id;
	private String titulo;
	private String organizacion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Integer duracion;
	private TipoCertificacion tipoCertificacion;
	private Double valoracion;
	private NivelDificultad nivelDificultad;
	private Integer numeroEstudiantes;
	private Boolean gratuito;
	//¡OJO! Para las propiedades derivadas NO se necesitan
	//atributos
	
	//Constructores
	public CursoOnLine(String id,String titulo,
			String organizacion, LocalDate fechaInicio,
			LocalDate fechaFin, Integer duracion,
			TipoCertificacion tipoCert, 
			Double valoracion,
			NivelDificultad nivelDificultad, 
			Integer numeroEstudiantes,
			Boolean gratuito) {
		checkId(id);
		this.id = id;
		this.titulo=titulo;
		this.organizacion= organizacion;
		checkFechas(fechaInicio, fechaFin);
		this.fechaInicio=fechaInicio;
		//En este caso con setFechaInicio se produce un NullPointerException
		//		setFechaInicio(fechaInicio);
		this.fechaFin=fechaFin;
		//R3
//		checkDuracion(duracion);
//		this.duracion=duracion;
		setDuracion(duracion);
		
		this.tipoCertificacion= tipoCert;
		checkValoracion(valoracion);
		this.valoracion=valoracion;
		this.nivelDificultad = nivelDificultad;
		checkNumeroEstudiantes(numeroEstudiantes);
		this.numeroEstudiantes= numeroEstudiantes;
		this.gratuito = gratuito;
	}
	private void checkId(String id) {
		if (!(id.length()==7 && Validators.sonLetras(id.substring(0,3))
				&& Validators.sonDigitos(id.substring(3)))) {
			throw new IllegalArgumentException("CursoOnLine::Id no tiene un formato válido");
		}
	} 

	
	
	private void checkFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		if (! (fechaFin.isAfter(fechaInicio))) {
			throw new IllegalArgumentException("CursoOnLine:La fecha de fin no es posterior a la de inicio");
		}
		
	}
	private void checkValoracion(Double valoracion) {
		if (! (valoracion>=VALORACION_MINIMA && valoracion<=VALORACION_MAXIMA)) {
			throw new IllegalArgumentException("CursonOnLine::La valoración debe estar entre 0 y 5");
		}
	}
	
	private void checkNumeroEstudiantes(Integer numeroEstudiantes) {
		if (!(numeroEstudiantes>=0)) {
			throw new IllegalArgumentException("CursoOnLine::Numero estudiantes incorrecto");
		}
		
	}
	//Consultores y modificadores
	//R3
	private void checkDuracion(Integer duracion) {
		if (!(duracion >=DURACION_MINIMA)) {
			throw new IllegalArgumentException("CursoOnLine::La duración debe ser superior a "+ DURACION_MINIMA);
		}
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		checkFechas(fechaInicio, getFechaFin());
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		checkFechas(getFechaInicio(), fechaFin);
		this.fechaFin = fechaFin;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		checkDuracion(duracion);
		this.duracion = duracion;
	}

	public Boolean getGratuito() {
		return gratuito;
	}

	public void setGratuito(Boolean gratuito) {
		this.gratuito = gratuito;
	}

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public TipoCertificacion getTipoCertificacion() {
		return tipoCertificacion;
	}

	public Double getValoracion() {
		return valoracion;
	}

	public NivelDificultad getNivelDificultad() {
		return nivelDificultad;
	}

	public Integer getNumeroEstudiantes() {
		return numeroEstudiantes;
	}
	
	//Propiedades derivadas
	public Double getMediaHorasSemanales() {
		Long numSemanas = ChronoUnit.WEEKS.between(
				          getFechaFin(), getFechaInicio());
		return getDuracion()*1.0/numSemanas;
	}
	
	public EstadoCurso getEstadoCurso() {
		EstadoCurso res = null;
		LocalDate hoy = LocalDate.now();
		if (getFechaFin().isBefore(hoy)) { //El curso ha acabado
			res = EstadoCurso.FINALIZADO;
		}else if(getFechaInicio().isAfter(hoy)) {//El curso no ha empezado
			res= EstadoCurso.PROXIMO;
		}else {
			res = EstadoCurso.EN_CURSO;
		}
		return res;
	}
	public CursoOnLine(String s) {
		Checkers.checkNoNull(s);
		String [] trozos = s.split(",");
		Checkers.check("formato invlido", trozos.length == 11);
		checkId(id);
		this.id = String.valueOf(trozos[0].trim());
		this.titulo = String.valueOf(trozos[1].trim());
		this.organizacion = String.valueOf(trozos[2].trim());
		checkFechas(fechaInicio, fechaFin);
		this.fechaInicio = LocalDate.parse(trozos[3].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.fechaFin = LocalDate.parse(trozos[4].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		checkDuracion(duracion);
		this.duracion = Integer.valueOf(trozos[5].trim());
		this.tipoCertificacion = TipoCertificacion.valueOf(trozos[6].trim());
		checkValoracion(valoracion);
		this.valoracion = Double.valueOf(trozos[7].trim());
		this.nivelDificultad = NivelDificultad.valueOf(trozos[8].trim());
		checkNumeroEstudiantes(numeroEstudiantes);
		this.numeroEstudiantes = Integer.valueOf(trozos[9].trim());
		this.gratuito = Boolean.valueOf(trozos[10].trim());
	}

	@Override
	public String toString() {
		return "CursoOnLine [getFechaInicio()=" + getFechaInicio() + ", getFechaFin()=" + getFechaFin()
				+ ", getDuracion()=" + getDuracion() + ", getGratuito()=" + getGratuito() + ", getId()=" + getId()
				+ ", getTitulo()=" + getTitulo() + ", getOrganizacion()=" + getOrganizacion()
				+ ", getTipoCertificacion()=" + getTipoCertificacion() + ", getValoracion()=" + getValoracion()
				+ ", getNivelDificultad()=" + getNivelDificultad() + ", getNumeroEstudiantes()="
				+ getNumeroEstudiantes() + ", getMediaHorasSemanales()=" + getMediaHorasSemanales()
				+ ", getEstadoCurso()=" + getEstadoCurso() + "]";
	}
	
	//Criterio de igualdad
	public boolean equals(Object obj) {
		boolean res = false;
			if (obj instanceof CursoOnLine) {
				CursoOnLine c = (CursoOnLine) obj;
				res = this.getId().equals(c.getId());
			}
		
		return res;
	}
	
	public int hashCode() {
		return this.getId().hashCode();
	}
}
