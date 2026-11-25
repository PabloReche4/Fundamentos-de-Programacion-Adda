package hamburguesas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Visita implements Comparable<Visita>{
	private String email;
	private String ciudad;
	private String codigoPostal;
	private LocalDateTime entrada;
	private LocalDateTime salida;
	private Double temperatura;
	private List<Evaluacion>evaluaciones;
	
	public Visita(String email, String ciudad, String codigoPostal, LocalDateTime entrada, LocalDateTime salida,
			Double temperatura, List<Evaluacion> evaluaciones) {
		Checkers.check(" El momento de salida debe ser posterior al momento de entrada.", salida.isAfter(entrada));
		Checkers.check(" El email debe contener el carácter ‘@’.", email.contains("@"));
		Checkers.check("La lista de evaluaciones debe contener al menos un elemento.", evaluaciones.isEmpty());
		this.email = email;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.entrada = entrada;
		setSalida(salida);
		setTemperatura(temperatura);
		this.evaluaciones =new ArrayList<> (evaluaciones);
	}
	public void setSalida(LocalDateTime salida) {
		Checkers.check(" El día de entrada tiene que ser el mismo que el de salida.", salida.toLocalDate().equals(entrada.toLocalDate()));
		Checkers.check(" El momento de salida debe ser posterior al momento de entrada.", getSalida().isAfter(entrada));
		this.salida=salida;	
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura=temperatura;
	}
	public String getEmail() {
		return email;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public LocalDateTime getEntrada() {
		return entrada;
	}
	public LocalDateTime getSalida() {
		return salida;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public List<Evaluacion> getEvaluaciones() {
		return new ArrayList<>(this.evaluaciones);
	}
	public Integer getNumEvaluaciones() {
		return getEvaluaciones().size();
		
	}
	public Paladar paladar() {
		Paladar res=Paladar.MEDIO;
		if(mediaPuntuaciones()>=9) {
			res=Paladar.BAJO;
		}else if(mediaPuntuaciones()<6) {
			res=Paladar.ALTO;
		}
		return res;
	}
	private Double mediaPuntuaciones() {
		Double sum=0.0;
		for(Evaluacion ev:evaluaciones) {
			sum+=ev.puntuacionFinal();
		}
		return sum/getEvaluaciones().size();
	}
	public Duration getTiempoTranscurrido() {
		return Duration.between(getEntrada(), getSalida());
	}
	@Override
	public String toString() {
		return "Visita [email=" + email + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + ", entrada="
				+ entrada + ", salida=" + salida + ", temperatura=" + temperatura + ", evaluaciones=" + evaluaciones
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, entrada, salida);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Visita))
			return false;
		Visita other = (Visita) obj;
		return Objects.equals(email, other.email) && Objects.equals(entrada, other.entrada)
				&& Objects.equals(salida, other.salida);
	}
	public int compareTo(Visita o) {
		int res=getEntrada().compareTo(o.getEntrada());
		if(res==0) {
			res=getSalida().compareTo(o.getSalida());
			if(res==0) {
			res=getEmail().compareTo(o.getEmail());
		}
		}
		return res;
	}
}