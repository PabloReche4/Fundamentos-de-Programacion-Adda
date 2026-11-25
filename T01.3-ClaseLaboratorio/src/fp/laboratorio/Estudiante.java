package fp.laboratorio;

/**
 * El tipo Estudiante representa un estudiante de una clase de laboratorio
 * @author To�i Reina
 * @version 1.0.0
 */
public interface Estudiante {

	/**
	 * @return Devuelve el nombre del estudiante.
	 */ 
	String getNombre();
	/**
	 * @param nuevoNombre Nuevo nombre del estudiante.
	 * Cambia el nombre del estudiante por uno nuevo.
	 */
	void setNombre(String nuevoNombre);
	/**
	 * @return Devuelve los apellidos del estudiante.
	 */
	String getApellidos();
	/**
	 * @param nuevosApellidos Nuevos apellidos del estudiante
	 * Cambia los apellidos del estudiante.
	 */
	void setApellidos(String nuevosApellidos);
	/**
	 * @return Devuelve el UVUS del estudiante.
	 */
 	String getUVUS();
	/**
	 * @return Devuelve el total de puntos que tiene el estudiante.
	 */
	Double getPuntos();
	/**
	 * @return Devuelve las iniciales del estudiante.
	 * Las iniciales est�n formadas por la primera letra del nombre y la primera letra del primer apellido,
	 * separadas por un punto.
	 */
	String getIniciales();
	/**
	 * @param puntosAdicionales Puntos que se a�aden
	 * A�ade los puntos dados por el par�metro puntosAdicionales a los puntos que ya tiene el estudiante.
	 */
	void sumarPuntos(Double puntosAdicionales);
	void setUVUS(String string);
	
}
