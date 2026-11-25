package fp.buses;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Trayecto implements Comparable<Trayecto> {
	
   private LocalDateTime fechaHora;
   private String nombre;
   private Empresa empresa;
   private Integer usuarios;
   private String paradaInicial;
   private List<Etapa> recorrido;

public Trayecto(LocalDateTime fechaHora, String nombre, Empresa empresa, Integer usuarios, String paradaInicial,
		   List <Etapa>recorrido) {
	   this.fechaHora=fechaHora;
	   this.nombre=nombre;
	   this.empresa=empresa;
	   this.usuarios=usuarios;
	   this.paradaInicial=paradaInicial;
//	    Antes de hacer el this.lista hay que implementar un checkers
	   Checkers.check("Recorridos incorrectos", recorrido.size()>=1);
	   this.recorrido=new ArrayList<>(recorrido);
	   
   }

	
	public LocalDateTime getFechaHora() {
	return fechaHora;
}


public void setFechaHora(LocalDateTime fechaHora) {
	this.fechaHora = fechaHora;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public Empresa getEmpresa() {
	return empresa;
}


public void setEmpresa(Empresa empresa) {
	this.empresa = empresa;
}


public Integer getUsuarios() {
	return usuarios;
}


public void setUsuarios(Integer usuarios) {
	this.usuarios = usuarios;
}


public String getParadaInicial() {
	return paradaInicial;
}


public void setParadaInicial(String paradaInicial) {
	this.paradaInicial = paradaInicial;
}


public List<Etapa> getRecorrido() {
	return recorrido;
}


public void setRecorrido(List<Etapa> recorrido) {
	this.recorrido = recorrido;
}


	@Override
	public int hashCode() {
		return Objects.hash(empresa, fechaHora, nombre, paradaInicial, recorrido, usuarios);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trayecto other = (Trayecto) obj;
		return empresa == other.empresa && Objects.equals(fechaHora, other.fechaHora)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(paradaInicial, other.paradaInicial)
				&& Objects.equals(recorrido, other.recorrido) && Objects.equals(usuarios, other.usuarios);
	}
	
	@Override
	public String toString() {
		return "Trayecto [fechaHora=" + fechaHora + ", nombre=" + nombre + ", empresa=" + empresa + ", usuarios="
				+ usuarios + ", paradaInicial=" + paradaInicial + ", recorrido=" + recorrido + "]";
	}
	public List<String> getParadas() {
		List<String> res = new ArrayList<String>();
		res.add(paradaInicial);
		for (Etapa etapa: recorrido) {
		res.add(etapa.parada());
		}
		return res;
		}
	public LocalTime gethoraLlegada() {
		return gethoraLlegadaParada(recorrido.size()-1);
		
	}
	private LocalTime gethoraLlegadaParada(int ind) {
		Checkers.check("Indice de recorrido incorrecto", ind>=0 && ind< recorrido.size());
		LocalDateTime res=getFechaHora();
		for (int i=0; i<=ind; i++) {
			Etapa etapa=recorrido.get(i);
			res=res.plusMinutes(etapa.minutos());
		}
			
		return res.toLocalTime() ;
	}
	public int compareTo(Trayecto t) {
		int res=getFechaHora().compareTo(t.getFechaHora());
		if (res==0) {
			res=getNombre().compareTo(t.getNombre());
		}
		return res;
	}
	
}
