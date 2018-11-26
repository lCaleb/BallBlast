package modelo;

import java.util.ArrayList;

public class Nivel {
	/**
	 * nivel actual
	 */
	private int nivelActual;
	/**
	 * nivel siguiente para pasar
	 */
	private int nivelSiguiente;
	/**
	 * progreso donde cominza el estado del nivel
	 */
	private double progreso;
	/**
	 * puntos para pasar al suguiente nivel
	 */
	public int puntosPasar;
	/**
	 * tamaño de la lista de objetivos
	 */
	public int objetivosSize;
	/**
	 * apuntador siguiente para la lista doble
	 */
	private Nivel siguiente;
	/**
	 * apuntador anterior para la lista doble
	 */
	private Nivel anterior;
	/**
	 * cabeza de la lista simple de objetivos
	 */
	private ObjetivoDisparar objetivoCabeza;
	/**
	 * Lista de colores para los objetivos
	 */
	private ArrayList<String> colores;

	/**
	 * Metodo que construye un nivel con todo lo necesario
	 * 
	 * @param                nivelActual- nivel en que se encuentra actualmente
	 *                       !=null
	 * @param nivelSiguiente nivel para pasar al siguietne nivel
	 * @param progreso       - progreso que lleva este nivel
	 * @param colores        - color que lleva un objetivo en este nivel
	 */
	public Nivel(int nivelActual, int nivelSiguiente, double progreso, ArrayList<String> colores) {

		this.nivelActual = nivelActual;
		this.nivelSiguiente = nivelSiguiente;
		this.progreso = progreso;
		this.puntosPasar = 0;
		this.colores = colores;
		cargarNivel();

	}

	/**
	 * Método que carga un nivel con todo y bolas
	 */
	public void cargarNivel() {
		int numeroBolas = (nivelActual * 2) + 6;
		for (int i = 0; i < numeroBolas; i++) {
			int y = 4;
			int x = (int) (Math.random() * 900) + 1;
			int valueX = (int) (Math.random() * 30) + 1;
			int value = valueX + (nivelActual * 10);
			int color = (int) (Math.random() * 4) + 1;
			int tamanio = (int) (Math.random() * 120) + 80;
			ObjetivoDisparar obj = new ObjetivoDisparar(x, y, value, colores.get(color), tamanio);
			agregarObjetivoALista(obj);
			puntosPasar += value;
		}
	}

	/**
	 * Método que elimina un objetivo de la lista de los objetivos
	 * 
	 * @param objetivoEliminar objetivo que se quiere eliminar
	 * @param objetivoActual   objetivo que recorre recursivamente <br>
	 *                         pre: <br>
	 *                         objetivoEliminar!=null <br>
	 *                         post: <br>
	 *                         se elimino un elemento de la lista
	 */
	public void eliminarObjetivo(ObjetivoDisparar objetivoEliminar, ObjetivoDisparar objetivoActual) {

		if (objetivoCabeza == objetivoEliminar) {
			objetivoCabeza = objetivoCabeza.getSiguiente();
			objetivosSize--;
		} else if (objetivoEliminar == objetivoActual.getSiguiente()) {
			objetivoActual.setSiguiente(objetivoActual.getSiguiente().getSiguiente());
			objetivosSize--;

		} else {
			eliminarObjetivo(objetivoEliminar, objetivoActual.getSiguiente());
		}
	}

	/**
	 * Método auxiliar
	 * 
	 * @param objetivo - a eliminar
	 */
	public void eliminarObjetivo(ObjetivoDisparar objetivo) {
		if (objetivo != null) {
			eliminarObjetivo(objetivo, objetivoCabeza);
		}
	}

	/**
	 * da el tamaño de la lista de objetivos
	 * 
	 * @return objetivosSize
	 */
	public int getObjetivosSize() {
		return objetivosSize;
	}

	/**
	 * metodo que modifica el tampaño de la lista de objetivos
	 * 
	 * @param objetivosSize
	 */
	public void setObjetivosSize(int objetivosSize) {
		this.objetivosSize = objetivosSize;
	}

	/**
	 * Método que busca un objetivo
	 * 
	 * @param pos
	 * @return obj
	 */
	public ObjetivoDisparar buscarObjetivo(int pos) {
		ObjetivoDisparar obj = objetivoCabeza;

		for (int i = 0; i <= pos; i++) {
			obj = obj.getSiguiente();
		}

		return obj;

	}

	/**
	 * Metodo que agrega un objetivo a la lista de objetivos
	 * 
	 * @param objetivo <br/>
	 *                 post : <br/>
	 *                 se agregó a la lista de objetivos
	 */
	public void agregarObjetivoALista(ObjetivoDisparar objetivo) {
		if (objetivoCabeza == null) {
			objetivoCabeza = objetivo;
			objetivosSize++;
		} else {
			boolean stop = false;
			ObjetivoDisparar next = objetivoCabeza;
			while (!stop) {
				if (next.getSiguiente() == null) {
					next.setSiguiente(objetivo);
					stop = true;
					objetivosSize++;
				}
				next = next.getSiguiente();

			}
		}

	}

	/**
	 * apuntador del nivel a nivelsiguiente
	 * 
	 * @return siguiente
	 */
	public Nivel getSiguiente() {
		return siguiente;
	}

	/**
	 * modifica el apuntador de nivel siguiente
	 * 
	 * @param siguiente
	 */
	public void setSiguiente(Nivel siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * apuntador del nivel a nivel anterior
	 * 
	 * @return anterior
	 */
	public Nivel getAnterior() {
		return anterior;
	}

	/**
	 * modifica el apuntador de nivel anterio
	 * 
	 * @param anterior
	 */
	public void setAnterior(Nivel anterior) {
		this.anterior = anterior;
	}

	/**
	 * da el nivel Actual
	 * 
	 * @return nivelActual
	 */
	public int getNivelActual() {
		return nivelActual;
	}

	/**
	 * modifica el nivel actual
	 * 
	 * @param nivelActual
	 */
	public void setNivelActual(int nivelActual) {
		this.nivelActual = nivelActual;
	}

	/**
	 * retorna un entero que expresa el nivel siguiente del nivel
	 * 
	 * @return
	 */
	public int getNivelSiguiente() {
		return nivelSiguiente;
	}

	/**
	 * modifica el nivel siguiente del nivel
	 * 
	 * @param nivelSiguiente
	 */
	public void setNivelSiguiente(int nivelSiguiente) {
		this.nivelSiguiente = nivelSiguiente;
	}

	/**
	 * da el progreso que hasta ahora lleva el nivel
	 * 
	 * @return
	 */
	public double getProgreso() {
		return progreso;
	}

	/**
	 * modifica el progreso que lleva el nivel
	 * 
	 * @param progreso
	 */
	public void setProgreso(double progreso) {
		this.progreso = progreso;
	}

	/**
	 * da los puntos para pasar el nivel
	 * 
	 * @return puntosPasar
	 */
	public int getPuntosPasar() {
		return puntosPasar;
	}

	/**
	 * modifica los puntos que permiten al nivel pasar al siguiente nivel
	 * 
	 * @param puntosPasar
	 */
	public void setPuntosPasar(int puntosPasar) {
		this.puntosPasar = puntosPasar;
	}

	/**
	 * retorna la cabeza de este nodo
	 * 
	 * @return objetivoCabeza
	 */
	public ObjetivoDisparar getObjetivoCabeza() {
		return objetivoCabeza;
	}

	/**
	 * modifica la caebeza de este nodo
	 * 
	 * @param objetivoCabeza
	 */

	public void setObjetivoCabeza(ObjetivoDisparar objetivoCabeza) {
		this.objetivoCabeza = objetivoCabeza;
	}

}
