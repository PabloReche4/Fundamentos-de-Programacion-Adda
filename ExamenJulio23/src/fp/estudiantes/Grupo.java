package fp.estudiantes;
import fp.estudiantes.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grupo {
private List<Estudiante>estudiantes;
	public Grupo(Stream<Estudiante> sv) {
		
	}
	@Override
	public String toString() {
		return "Grupo [estudiantes=" + estudiantes + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Grupo))
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(estudiantes, other.estudiantes);
	}
	public SortedSet<Estudiante> estudiantesQueCursanNAsignaturasAlMenos
	(Integer curso, Integer n){
		return estudiantes.stream().filter(x->x.getAsignaturas().size()>=n&&
				tieneAsignaturasCurso(x, curso))
				.collect(Collectors.toCollection(TreeSet::new));
	}
	private boolean tieneAsignaturasCurso(Estudiante x, Integer curso) {
		return x.getAsignaturas().stream().anyMatch(m->m.curso().equals(curso));
	}
	public  Double edadMediaEstudiantesRepetidores(Set<String> idsAsignaturas) {
		
	}


}
