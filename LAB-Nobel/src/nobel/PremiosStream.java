package nobel;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PremiosStream implements Premios {
	private Set<Premio> premios ;
	
	public PremiosStream() {
		this.premios=new HashSet<Premio>();
	}
	
	public PremiosStream(Stream<Premio>p) {
		this.premios=p.collect(Collectors.toSet());
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(premios);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremiosStream other = (PremiosStream) obj;
		return Objects.equals(premios, other.premios);
	}



	@Override
	public void añadirPremio(Premio premio) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Premio> obtenerPremiosDeGenero(Genero genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer calcularNumeroPremiadosMasJovenesDe(Integer edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Genero, Integer> calcularNumeroPremiosPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, List<Premio>> calcularPremiosPorEdad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> calcularMediaEdadPorCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

}
