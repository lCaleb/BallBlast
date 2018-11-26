package modelo;

import java.io.Serializable;

public class Jugador implements Serializable, Comparable {

	/**
	 * Sub arbol izquierdo
	 */
	private Jugador izq;
	/**
	 * Sub arbol derecho
	 */
	private Jugador der;
	/**
	 * Atributo que representa el nivel donde está el jugador
	 */
	private int nivel;
	/**
	 * Nombre del jugador
	 */
	private String nickName;
	/**
	 * puntaje que lleva el jugador
	 */
	private int puntaje;

	/**
	 * Nivel que lleva el jugador
	 */
	private Nivel nivelDelJugador;

	/**
	 * Crea un jugador con toda la información básica
	 * 
	 * @param nickName
	 *            - nombre !=null
	 * @param puntaje-
	 *            puntaje del programador
	 */
	public Jugador(String nickName, int puntaje) {
		this.nickName = nickName;
		this.puntaje = puntaje;

		izq = null;
		der = null;
	}

	/**
	 * Compara este jugador con otro
	 * 
	 * @param o
	 *            es el otro juagador con el que se compara
	 * @return -1 si este jugador es menor al otro, 0 si son iguales y 1 si este
	 *         jugador es mayor al otro
	 */
	@Override
	public int compareTo(Object jugador) {
		// TODO Auto-generated method stub
		Jugador player = (Jugador) jugador;

		return nickName.compareToIgnoreCase(player.getNickName());
	}

	/**
	 * Da el subArbol izquierdo
	 * 
	 * @return izq
	 */
	public Jugador getIzq() {
		return izq;
	}

	/**
	 * modifica el subArbol Izquierdo
	 * 
	 * @param izq
	 */
	public void setIzq(Jugador izq) {
		this.izq = izq;
	}

	/**
	 * Da el subArbol derecho
	 * 
	 * @return der
	 */
	public Jugador getDer() {
		return der;
	}

	/**
	 * modifica el subArbol derecho
	 * 
	 * @param der
	 */
	public void setDer(Jugador der) {
		this.der = der;
	}

	/**
	 * Retorna el nickName del jugador
	 * 
	 * @return nickName del jugador
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * modifica el nickName del jugador
	 * 
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * da el puntaje del jugador
	 * 
	 * @return puntaje entero que represanta al puntaje de esta jugador
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * modifica el puntahe del jugador
	 * 
	 * @param puntaje
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	/**
	 * da el nivel del jugador
	 * 
	 * @return nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * modifica el nivel del jugador
	 * 
	 * @param nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * da el nivel del jugador
	 * 
	 * @return
	 */
	public Nivel getNivelDelJugador() {
		return nivelDelJugador;
	}

	/**
	 * modifica el nivel del jugador
	 * 
	 * @param nivelDelJugador
	 */
	public void setNivelDelJugador(Nivel nivelDelJugador) {
		this.nivelDelJugador = nivelDelJugador;
	}

}
