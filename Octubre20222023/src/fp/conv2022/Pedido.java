package fp.conv2022;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public record Pedido(LocalDate fecha, String usuario, String pais, String ciudad, Envio envio,
		Set <String>categorias, String producto, Double precioSinIVA, Integer unidadesCompradas) {
	public  Double precioConIVA() {
		return precioSinIVA() * unidadesCompradas()*1.21;
	}
	public Pedido{
		Checkers.check("R1: la fecha del pedido no puede ser futura, es decir,"
				+ " no pueden ser posteriores al día actual"
				, fecha.isBefore(LocalDate.now()));
		Checkers.check("R2: el precio unitario y las unidades "
				+ "compradas tienen que ser igual o mayor a 0",
				precioSinIVA>=0&&unidadesCompradas>=0);
		Checkers.checkNoNull("R3: el nombre del producto, el precio unitario y"
				+ " las unidades compradas no pueden ser nulos.",
				producto, precioSinIVA, unidadesCompradas);
		
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(fecha, producto, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pedido))
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(producto, other.producto)
				&& Objects.equals(usuario, other.usuario);
	}
	public int compareTo(Pedido p) {
		int res=fecha.compareTo(p.fecha);
		if(res==0) {
			res=usuario.compareTo(p.usuario);
			if(res==0) {
				res=producto.compareTo(p.producto);
			}
		
		}
		return res;
	}
	@Override
	public String toString() {
		return "Pedido [fecha=" + fecha + ", usuario=" + usuario + ", pais=" + pais + ", ciudad=" + ciudad + ", envio="
				+ envio + ", categorias=" + categorias + ", producto=" + producto + ", precioSinIVA=" + precioSinIVA
				+ ", unidadesCompradas=" + unidadesCompradas + "]";
	}
	
}
