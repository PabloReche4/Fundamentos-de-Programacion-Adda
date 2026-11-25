package fp.conv2022;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstudioPedidos {
private Set<Pedido>pedidos;

public EstudioPedidos(Stream<Pedido> pedidos) {

	this.pedidos = pedidos.collect(Collectors.toSet());
}

public Set<Pedido> getPedidos() {
	return new HashSet<>(pedidos);
}

@Override
public String toString() {
	return "EstudioPedidos [pedidos=" + pedidos + "]";
}

@Override
public int hashCode() {
	return Objects.hash(pedidos);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!(obj instanceof EstudioPedidos))
		return false;
	EstudioPedidos other = (EstudioPedidos) obj;
	return Objects.equals(pedidos, other.pedidos);
}
public Map<Envio, Integer> getTotalPedidosPorEnvio(Set<Envio> envios, Integer mes){
	Map<Envio, Integer>res=new HashMap<>();
	for (Pedido p: pedidos) {
		if(envios.contains(p.envio())&&p.fecha().getMonthValue()==mes) {
			if(res.containsKey(p.envio())) {
				res.put(p.envio(), res.get(p.envio())+1);
			}else {
				res.put(p.envio(), 1);
			}
			
		}
		
	}
	return res;
}
public Double getMediaPrecioPorPedidoUsuarioAlemania(String usuario, String categoria) {
	return pedidos.stream()
			.filter(x->x.usuario().equals(usuario)&&x.categorias().contains(categoria))
			.mapToDouble(p->p.precioSinIVA()*p.unidadesCompradas()*1.19)
			.average()
			.getAsDouble();
}
public Map<String, List<Double>> getResumenPedidosUsuario(){
	return pedidosPorUsuario().entrySet().stream()
			.collect(Collectors.toMap(e->e.getKey(), e->getResumen(e.getValue())));
}
private Map<String,List<Pedido>>pedidosPorUsuario(){
	return pedidos.stream().collect(Collectors.groupingBy(Pedido::usuario));
}
private List<Double>getResumen(List<Pedido>pedidos){
	Double min=pedidos.stream().mapToDouble(Pedido::precioSinIVA).min().getAsDouble();
	Double max=pedidos.stream().mapToDouble(Pedido::precioSinIVA).max().getAsDouble();
	Double media=pedidos.stream().mapToDouble(Pedido::precioSinIVA).average().getAsDouble();
	return List.of(min,max,media);
}
public String getUsuarioMasDerrochadorPosicion(LocalDate fecha, Integer n) {
Map<String, Double>gastosPorUsuario=totalGastdadoPorUsuario(fecha);

			return gastosPorUsuario.entrySet().stream()
					.sorted(Map.Entry.comparingByValue())
					.skip(n)
					.findFirst()
					.get()
					.getKey()
			;
//			return pedidos.stream()
//			.filter(p->p.fecha().isAfter(fecha))
//			.sorted(Comparator.comparing(p->p.precioSinIVA()*p.unidadesCompradas()))
//			.map(Pedido::usuario)
//			.limit(n)
//			.findFirst()
//			.get()
	
}

private Map<String, Double> totalGastdadoPorUsuario(LocalDate fecha) {
	
	return this.pedidos.stream()
			.filter(p->p.fecha().isAfter(fecha))
			.collect(Collectors.groupingBy(Pedido::usuario,Collectors.summingDouble(Pedido::precioConIVA)));
}
public Map<String, String>getProductoMayorPrecioPorPais(LocalDate fecha){
	Map<String, List<Pedido>>po= pedidos.stream()
			.filter(p->p.fecha().equals(fecha))
			.collect(Collectors.groupingBy(Pedido::pais));
	return po.entrySet().stream()
			.collect(Collectors.toMap(Map.Entry::getKey,
					e->productoMasCaro(e.getValue())));
}
private String productoMasCaro(Collection<Pedido>p) {
	return pedidos.stream()
			.max(Comparator.comparing(Pedido::precioConIVA))
			.get()
			.producto();
}
}
	

