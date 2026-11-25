package nobel;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Premios {
  void añadirPremio(Premio premio);
  Collection<Premio>  obtenerPremiosDeGenero(Genero genero);
  Integer calcularNumeroPremiadosMasJovenesDe(Integer edad);
  Map<Genero, Integer> calcularNumeroPremiosPorGenero();
  Map<Integer, List<Premio>>calcularPremiosPorEdad();
  Map<String, Double>calcularMediaEdadPorCategoria();
}
