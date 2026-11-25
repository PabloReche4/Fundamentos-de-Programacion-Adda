package fp.trayecto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Trayecto implements Comparable <Trayecto> {
private LocalDateTime fechaHora;
private String nombre;
private Empresa empresa;
private Integer usuarios;
private String paradaInicial;
private List<Etapa>recorrido;
public Trayecto(LocalDateTime fechaHora, String nombre, Empresa empresa, Integer usuarios, String paradaInicial,
		List<Etapa> recorrido) {
	Checkers.check("al menos una etapa",recorrido.size()>=1);
	Checkers.checkNoNull(paradaInicial);
	
	this.fechaHora = fechaHora;
	this.nombre = nombre;
	this.empresa = empresa;
	this.usuarios = usuarios;
	this.paradaInicial = paradaInicial;
	this.recorrido = new ArrayList<>(recorrido);
	
	
}
@Override
public String toString() {
	return "Trayecto [fechaHora=" + fechaHora + ", nombre=" + nombre + ", empresa=" + empresa + ", usuarios=" + usuarios
			+ ", paradaInicial=" + paradaInicial + ", recorrido=" + recorrido + "]";
}
public LocalDateTime getFechaHora() {
	return fechaHora;
}
public String getNombre() {
	return nombre;
}
public Empresa getEmpresa() {
	return empresa;
}
public Integer getUsuarios() {
	return usuarios;
}
public String getParadaInicial() {
	return paradaInicial;
}
public List<Etapa> getRecorrido() {
	return new ArrayList<>(recorrido);
}
public Integer getNumeroParadas() {
	return 	recorrido.size()+1;
}
public LocalTime horaLlegada() {
	return getHoraLlegadaParada(recorrido.size()-1);
	
}
public List<String>getParadas(){
	List<String>res=new ArrayList<>();
	res.add(paradaInicial);
	for(Etapa e:recorrido) {
		res.add(e.parada());
	}
	return res;
}
public Integer getTiempoRecorrido() {
	return recorrido.stream()
			.mapToInt(Etapa::minutos)
			.sum();
}
public LocalTime getHoraLlegadaParada(int ind) {
	Checkers.check("indice fuera de rango", ind>=0 && ind<recorrido.size());
	LocalDateTime res=getFechaHora();
	for(int i=0; i<=ind; i++) {
		Etapa e=recorrido.get(i);
		res=res.plusMinutes(e.minutos());
		
	}
	return res.toLocalTime();
}
@Override
public int hashCode() {
	return Objects.hash(fechaHora, nombre);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!(obj instanceof Trayecto))
		return false;
	Trayecto other = (Trayecto) obj;
	return Objects.equals(fechaHora, other.fechaHora) && Objects.equals(nombre, other.nombre);
}
public int compareTo(Trayecto t) {
	int res=getFechaHora().compareTo(t.getFechaHora());
		if (res==0) {
			res=getNombre().compareTo(t.getNombre());
		}
	return res;
}
}
