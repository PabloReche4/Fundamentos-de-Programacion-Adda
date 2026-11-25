package vuelos;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Vuelo implements Comparable<Vuelo> {
	private Trayecto trayecto;
	private Double precio;
	private Integer numPasajeros;
	private Integer numPlazas;
	private String codigo;
	private LocalDate fecha;
	private Duration duracion;
	private List<String> tripulacion;
	
	public String origen() {
		return trayecto.origen();
	}
	
	public String destino() {
		return trayecto.destino();
	}
	
	public Integer duracionMin() {
		return this.duracion.toMinutesPart();
	}
	
	public Boolean estaCompleto() {
		boolean res = false;
		if(numPlazas != 0) {
			res = true;
		}
		return res;
	}
	
	public Double porcentajeOcupacion() {
		return this.numPasajeros/this.numPlazas *100.0;
	}
	
	public Integer getNumPasajeros() {
		return numPasajeros;
	}

	public void setNumPasajeros(Integer numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Trayecto getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(Trayecto trayecto) {
		this.trayecto = trayecto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(Integer numPlazas) {
		this.numPlazas = numPlazas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}

	public List<String> getTripulacion() {
		return tripulacion;
	}
	
	public void incrementaPrecioPorcentaje(Double porcentaje) {
		this.precio = precio+ precio*(porcentaje/100);
	}

	public Vuelo(Trayecto trayecto, Double precio, Integer numPasajeros, Integer numPlazas, 
						String codigo, LocalDate fecha,Duration duracion, List<String> tripulacion ) {
		Checkers.check("numero de plazas mayor o igual q cero", numPlazas>=0);
		Checkers.check("El número de pasajeros debe ser mayor que cero", numPasajeros>0);
		Checkers.check("El precio debe ser mayor o igual que cero", precio>0);
		Checkers.check("El número de pasajeros debe inferior o igual que el número de plazas",
				numPasajeros<=numPlazas);
		Checkers.check("El número de tripulantes del avión debe ser superior o igual a 3 (un piloto, un copiloto y"
				+ " al menos un asistente).", tripulacion.size()>=3);
				checkR6();
				checkR7();
	}
	
	public Boolean checkR6() {
		
        for (String codigoTripulante : tripulacion) {
            if (!codigoTripulante.matches("[A-Z]{2}\\d{4}")) {
                return false;
            }
        }
        return true;
	}
	
	public Boolean checkR7() {
		
        int numPilotos = 0;
        int numCopilotos = 0;
        int numAsistentes = 0;
        
        for (String codigoTripulante : tripulacion) {
            if (codigoTripulante.startsWith("PP")) {
                numPilotos++;
            } else if (codigoTripulante.startsWith("CP")) {
                numCopilotos++;
            } else if (codigoTripulante.startsWith("AV")) {
                numAsistentes++;
            }
        }
        return numPilotos >= 1 && numCopilotos >= 1 && numAsistentes >= 1;
	}

	public String toString() {
		return "Vuelo [trayecto=" + trayecto + ", codigo=" + codigo + ", fecha=" + fecha + "]";
	}

	public int hashCode() {
		return Objects.hash(codigo, fecha);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(fecha, other.fecha);
	}

	public int compareTo(Vuelo v) {
		int res = this.getFecha().compareTo(v.getFecha());
		if (res == 0) {
			res = this.getCodigo().compareTo(v.getCodigo());
		}
		return res;
	}
		
}
