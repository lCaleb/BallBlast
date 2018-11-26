package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JuegoBatalla {
	/**
	 * Constante ue da el tipo del vehiculo
	 */
	public static final String TANQUE = "tanque";
	/**
	 * Constante ue da el tipo del vehiculo
	 */
	public static final String NAVE = "nave";
	/**
	 * Constante que indica el número de niveles
	 */
	public static final int NUMERO_NIVELES = 10;

	/**
	 * Nodo Principal del árbol de los jugadores
	 */
	private Jugador jugadorRaiz;
	/**
	 * Nodo Principal del árbol de los puntajes
	 */
	private Jugador puntajeRaiz;
	/**
	 * Nodo pricipal de la lista doblementaEnlazada de niveles
	 */
	private Nivel cabezaNivel;
	/**
	 * Nodo pricipal de la lista enlazada de municion
	 */
	private Municion cabezaMunicion;
	/**
	 * atributo que tiene esta clase para darse cuenta de su estado
	 */
	private VehiculoBatalla vehiculumLectus;
	/**
	 * Escenario del juego
	 */
	private String escenario;
	/**
	 * Lista de colores que emplean los objtivos
	 */
	private ArrayList<String> color;
	/**
	 * atributo que representa el nivel actual en esta clase
	 */
	private Nivel nivelActual;
	/**
	 * Estado del jugador actual en la clase
	 */
	private Jugador jugadorActual;

	/**
	 * objetivos en el campo de batalla el cual deberan ser destruidos
	 */
	private ObjetivoDisparar objA;
	/**
	 * objetivos en el campo de batalla el cual deberan ser destruidos
	 */
	private ObjetivoDisparar objB;

	/**
	 * crea un juegoBatalla con los requerimientos para que se vea en pantalla
	 */
	public JuegoBatalla() {
		color = new ArrayList<String>();
		leerColoresYPasarAArray();
		cargarNiveles();
		this.nivelActual = cabezaNivel;
	}

	/**
	 * Método que actuliaza el atributo nivelActual
	 * 
	 * @param nivel
	 *            - que entra
	 */
	public void actualizarNivel(Nivel nivel) {
		nivelActual = nivel;
	}

	/**
	 * Método que la esta clase es capaz de identificar un disparo en una coordenada
	 * 
	 * @param x
	 *            putno en x de la Escena
	 * @param y
	 *            punto en y de la Escena
	 * @return un valor booleano para saber si es correcto el disparo
	 */
	public boolean verificarDisparo(int x, int y) {

		boolean a = objA.estaEnRango(x, y);
		boolean b = objB.estaEnRango(x, y);
		return a || b;
	}

	/**
	 * Método que permite pasarle un nivel al juego de batalla
	 */
	public void cargarNiveles() {
		for (int i = 0; i < NUMERO_NIVELES; i++) {
			Nivel nivel = new Nivel(i + 1, i + 2, 0, color);
			agregarOrdenado(nivel);
		}
	}

	/**
	 * Método que lee y pasa los colores a la lista de colores <b>pre: </b> lista de
	 * colores ya está inicializada <b>post: </b> se logró pasar los datos a la
	 * lista de colores
	 */
	public void leerColoresYPasarAArray() {

		File file = new File("data/colors.txt");
		try {
			FileReader aLeer = new FileReader(file);
			BufferedReader lector = new BufferedReader(aLeer);
			String linea = "";

			while (linea != null) {
				linea = lector.readLine();
				if (linea != null) {
					color.add(linea);
				}
			}
			lector.close();
		} catch (IOException e) {
			// TODO: handle exception}
			e.printStackTrace();
		}
	}

	/**
	 * Método que le dice a la clase principal del modelo ue vehiculo fue
	 * seleccionado
	 * 
	 * @param vehiculumGenus-
	 *            vehículo seleccionado
	 */
	public void initumLudum(String vehiculumGenus) {
		switch (vehiculumGenus) {
		case TANQUE:
			vehiculumLectus = new Tanque(330, 0, 1);
			break;
		case NAVE:
			vehiculumLectus = new Nave(330, 0, 1);
			break;

		default:
			break;
		}
	}

	// Métodos arboles binarios

	/**
	 * Método axuiliar
	 * 
	 * @param jugador
	 *            jugador que se quiere agragar al árbol
	 */
	public void agregarJugador(Jugador jugador) {
		agregarJugador(jugador, jugadorRaiz);
	}

	/**
	 * Método que da el vehiculo que se seleccionó
	 * 
	 * @return vehiculumLectus
	 */
	public VehiculoBatalla getVehiculumLectus() {
		return vehiculumLectus;
	}

	/**
	 * Método que modifica el vehiculo que se seleccionó
	 * 
	 * @return vehiculumLectus
	 */
	public void setVehiculumLectus(VehiculoBatalla vehiculumLectus) {
		this.vehiculumLectus = vehiculumLectus;
	}

	/**
	 * Inserta un nuevo programador al árbol que comienza en este nodo.
	 * 
	 * @param jugador
	 *            - el nuevo jugador que se va a insertar - jugador != null
	 * @param pivote
	 *            - raiz en la cual va ir iterando
	 * @throws JugadorRepetidoException
	 *             se lanza esta excepción si el Jugador que se quiere agregar ya
	 *             está en el árbol
	 */
	public void agregarJugador(Jugador jugador, Jugador pivote) {

		if (jugadorRaiz == null) {
			jugadorRaiz = jugador;
		} else {
			if (jugador.compareTo(pivote) > 0) {
				if (pivote.getDer() == null) {
					pivote.setDer(jugador);
				} else {
					agregarJugador(jugador, pivote.getDer());
				}
			} else {

				if (pivote.getIzq() == null) {
					pivote.setIzq(jugador);
				} else {
					agregarJugador(jugador, pivote.getIzq());
				}
			}
		}
	}

	/**
	 * Método que permite validar el ingreso de un jugador ya registrado o no
	 * 
	 * @param nickName
	 *            Nombre al cual se va validar nickName !=null
	 * @return valido - valor booleano
	 */
	public boolean validarIngreso(String nickName) {
		boolean validado = false;
		Jugador player = buscarJugador(nickName);
		if (buscarJugador(nickName) != null) {
			validado = true;
			jugadorActual = player;
		}
		return validado;
	}

	/**
	 * Método que registra un jugador en el juego y lo añade al árbol <b>pre: </b>
	 * nickName !=null <b>post: </b>se registró correctamente
	 * 
	 * @param nickName
	 *            nombre del jugador a registrar
	 */
	public void registrar(String nickName) {
		Jugador player = new Jugador(nickName, 0);
		agregarJugador(player);
	}

	/**
	 * método axuliar
	 * 
	 * @param nick
	 *            - nombre a buscar !=null
	 * @return el nombre del jugador encontrado
	 */
	public Jugador buscarJugador(String nick) {
		return buscarJugador(jugadorRaiz, nick);
	}

	/**
	 * Método que permite encontrar un jugador dentro del arbol de jugadores
	 * 
	 * @param reco
	 *            - Paramétro recursivo que permite la iteración en caso de no hayar
	 *            en esa iteracion al jugador cabeza!=null
	 * @param nick
	 *            - nombre del jugador a encontrar
	 * @return retornar el jugador encontrado
	 */
	public Jugador buscarJugador(Jugador reco, String nick) {
		if (reco == null) {
			return null;
		}
		if (reco.getNickName().compareToIgnoreCase(nick) > 0) {
			return buscarJugador(reco.getIzq(), nick);
		} else if (reco.getNickName().compareToIgnoreCase(nick) < 0) {
			return buscarJugador(reco.getDer(), nick);
		} else {
			return reco;
		}

	}

	/**
	 * Metodo que permite mostrar en la consola la lista de los jugadores de manera
	 * preorden
	 * 
	 * @param reco
	 *            parametro que recorre el arbol recursivamente
	 */
	public void pintarRecorridoPre(Jugador reco) {
		if (reco != null) {
			System.out.println(reco.getNickName());

			pintarRecorridoPre(reco.getIzq());
			pintarRecorridoPre(reco.getDer());

		}
	}

	/**
	 * Metodo que permite mostrar en la consola la lista de los jugadores de manera
	 * inorden
	 * 
	 * @param reco
	 *            parametro que recorre el arbol recursivamente
	 */
	public void pintarRecorridoIn(Jugador reco) {
		if (reco != null) {

			pintarRecorridoIn(reco.getIzq());
			System.out.println(reco.getNickName());
			pintarRecorridoIn(reco.getDer());
		}
	}

	/**
	 * Metodo que permite mostrar en la consola la lista de los jugadores de manera
	 * posorden
	 * 
	 * @param reco
	 *            parametro que recorre el arbol recursivamente
	 */
	public void pintarRecorridoPos(Jugador reco) {
		if (reco != null) {
			pintarRecorridoPos(reco.getIzq());
			pintarRecorridoPos(reco.getDer());
			System.out.println(reco.getNickName());
		}
	}

	//////////// Método lista doble/////////////
	/**
	 * método axuliar
	 * 
	 * @param nivelNuevo
	 *            - nivel que se quiere agregar a la lista doble de niviles
	 */
	public void agregarOrdenado(Nivel nivelNuevo) {
		agregarOrdenado(nivelNuevo, cabezaNivel);
	}

	/**
	 * Método que permite agregar ordenadamente un nivel al juego de batalla
	 * 
	 * @param nivelNuevo
	 *            - nivel a agregar
	 * @param reco
	 *            - parametro que recorre la lista recursivamente
	 * @throws NivelRepetidoException
	 *             se lanza esta excepción si el nivel que se quiere agregar ya está
	 *             en la lista
	 */
	public void agregarOrdenado(Nivel nivelNuevo, Nivel reco) {
		if (cabezaNivel == null) {
			cabezaNivel = nivelNuevo;
		} else if (cabezaNivel.getNivelActual() > nivelNuevo.getNivelActual()) {
			cabezaNivel.setAnterior(nivelNuevo);
			nivelNuevo.setSiguiente(cabezaNivel);
			cabezaNivel = nivelNuevo;
		} else if (reco.getSiguiente() == null) {
			reco.setSiguiente(nivelNuevo);
			nivelNuevo.setAnterior(reco);
		} else if (reco.getSiguiente().getNivelActual() > nivelNuevo.getNivelActual()) {
			nivelNuevo.setSiguiente(reco.getSiguiente());
			reco.getSiguiente().setAnterior(nivelNuevo);
			reco.setSiguiente(nivelNuevo);
			nivelNuevo.setAnterior(reco);
		} else {
			agregarOrdenado(nivelNuevo, reco.getSiguiente());
		}
	}

	////////// Setters and getters
	/**
	 * Método que da la raiz del arbol de jugadores
	 * 
	 * @return jugadorRaiz
	 */
	public Jugador getJugadorRaiz() {
		return jugadorRaiz;
	}

	/**
	 * Método que modifica la raiz del arbol de jugadores
	 * 
	 * @param jugadorRaiz
	 *            parametro a modificar
	 */
	public void setJugadorRaiz(Jugador jugadorRaiz) {
		this.jugadorRaiz = jugadorRaiz;
	}

	/**
	 * Método que da la raiz del arbol de puntajes
	 * 
	 * @return puntajeRaiz
	 */
	public Jugador getPuntajeRaiz() {
		return puntajeRaiz;
	}

	/**
	 * Método que modifica la raiz del arbol de puntajes
	 * 
	 * @param puntajeRaiz
	 *            parametro a modificar
	 */
	public void setPuntajeRaiz(Jugador puntajeRaiz) {
		this.puntajeRaiz = puntajeRaiz;
	}

	/**
	 * Método que da la cabeza de la listaDoble de niveles
	 * 
	 * @return cabezaNivel
	 */
	public Nivel getCabezaNivel() {
		return cabezaNivel;
	}

	/**
	 * Método que modifica la cabeza de la lisdaDoble de niveles
	 * 
	 * @param cabezaNivel
	 *            parametro a modificar
	 */
	public void setCabezaNivel(Nivel cabezaNivel) {
		this.cabezaNivel = cabezaNivel;
	}

	/**
	 * Método que da la cabeza de la lista de municiones
	 * 
	 * @return cabezaMunicion
	 */
	public Municion getCabezaMunicion() {
		return cabezaMunicion;
	}

	/**
	 * Método que modifica la cabeza de la lisda de municiones
	 * 
	 * @param cabezaMunicion
	 *            parametro a modificar
	 */
	public void setCabezaMunicion(Municion cabezaMunicion) {
		this.cabezaMunicion = cabezaMunicion;
	}

	public static void main(String[] args) {
		JuegoBatalla jb = new JuegoBatalla();
		Jugador j1 = new Jugador("Caleb", 1112);
		Jugador j2 = new Jugador("Maycol", 1113);
		Jugador j3 = new Jugador("carlos", 123);
		Jugador j4 = new Jugador("Pablo", 5657);
		Jugador j5 = new Jugador("pedro", 224);
		Jugador j6 = new Jugador("Pabla", 689);
		Jugador j7 = new Jugador("jasinto", 786);
		Jugador j8 = new Jugador("Ganzito", 448);
		Jugador j9 = new Jugador("jorge", 208);
		Jugador j10 = new Jugador("Arica", 984);

		jb.agregarJugador(j1);
		jb.agregarJugador(j2);
		jb.agregarJugador(j3);
		jb.agregarJugador(j4);
		jb.agregarJugador(j5);
		jb.agregarJugador(j6);
		jb.agregarJugador(j7);
		jb.agregarJugador(j8);
		jb.agregarJugador(j9);
		jb.agregarJugador(j10);

		// jb.pintarRecorridoPos(jb.getJugadorRaiz());
		System.out.println(jb.buscarJugador("jorge").getNickName());

	}

	/**
	 * Método que da el escenario
	 * 
	 * @return escenario
	 */
	public String getEscenario() {
		return escenario;
	}

	/**
	 * Método que modifica el escenario
	 * 
	 * @param escenario
	 */
	public void setEscenario(String escenario) {
		this.escenario = escenario;
	}

	/**
	 * Método que da el nivelActual
	 * 
	 * @return nivelActual
	 */
	public Nivel getNivelActual() {
		return nivelActual;
	}

	/**
	 * Método que modifica el nivelActual
	 * 
	 * @param nivelActual
	 */
	public void setNivelActual(Nivel nivelActual) {
		this.nivelActual = nivelActual;
	}

	/**
	 * Método que da el ObjetivoDisparar A
	 * 
	 * @return ObjetivoDisparar
	 */
	public ObjetivoDisparar getObjA() {
		return objA;
	}

	/**
	 * Método que modifica el ObjetivoDisparar A
	 * 
	 * @param objA
	 */
	public void setObjA(ObjetivoDisparar objA) {
		this.objA = objA;
	}

	/**
	 * Método que da el ObjetivoDisparar B
	 * 
	 * @return objB
	 */
	public ObjetivoDisparar getObjB() {
		return objB;
	}

	/**
	 * Método que modifica el ObjetivoDisparar Ab
	 * 
	 * @param objB
	 */
	public void setObjB(ObjetivoDisparar objB) {
		this.objB = objB;
	}

}
