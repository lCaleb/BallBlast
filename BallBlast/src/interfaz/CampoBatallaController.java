package interfaz;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import modelo.JuegoBatalla;
import modelo.ObjetivoDisparar;

public class CampoBatallaController {

	/**
	 * relacion con el modelo la clase priciapl
	 */
	private JuegoBatalla batalla;
	/**
	 * relacion con la clase Main
	 */
	private Main main;
	/**
	 * escenerio del campo batalla
	 */
	private Scene campoBatalla;
	/**
	 * etiqueta de puntajes
	 */
	@FXML
	private Label score;
	/**
	 * etiqueta de nivel actual
	 */
	@FXML
	private Label nivelActual;
	/**
	 * etiqueta de nivel siguiente
	 */
	@FXML
	private Label nivelSiguiente;
	/**
	 * Escenario que se cambia al ser seleccionado
	 */
	@FXML
	private ImageView escenarioCambiar;
	/**
	 * personaje que se cambia al ser seleccionado
	 */
	@FXML
	private ImageView personajeCambiar;
	/**
	 * Permite agregar y quitar al ahcor pane un objeto
	 */

	@FXML
	private AnchorPane anchor;
	/**
	 * Lista de hilos
	 */
	private ArrayList<Timeline> hilos;
	/**
	 * lista de hilos Objetivos
	 */
	private ArrayList<Timeline> hilosObjetivos;
	/**
	 * constructor
	 */
	public CampoBatallaController() {

	}
	/**
	 * Método que se inicializa primero 
	 */
	public void initialize() {
	}
	/**
	 * Método que pasa el main y principal controlador del modelo 
	 * @param main - Clase main
	 * @param batalla clase principal del modelo 
	 * @param campoBatalla clase controladora principal
	 */
	public void enlazarMain(Main main, JuegoBatalla batalla, Scene campoBatalla) {
		this.batalla = batalla;
		this.campoBatalla = campoBatalla;
		this.main = main;
		personajeCambiar.setImage(new Image(batalla.getVehiculumLectus().getImagen()));
		escenarioCambiar.setImage(new Image(batalla.getEscenario()));
		hilos = new ArrayList<Timeline>();
		hilosObjetivos = new ArrayList<Timeline>();
		darFunciones();
		perpetuumMotus();
		perpetummGerminat();
		objetivoMovimiento();

	}
	/**
	 * Método que permite poner el hilo en movimiento en la pantalla
	 */
	public void objetivoMovimiento() {
		ObjetivoDisparar obj = batalla.getNivelActual().getObjetivoCabeza();
		for (int i = 0; i < 2; i++) {
			Objetivo objetivo = new Objetivo(obj.getValorObjetivo(), obj.getColorActual(), obj.getDiametro());
			anchor.getChildren().add(objetivo);
			layoutMotusLectus(objetivo, obj);
			obj = obj.getSiguiente();
		}
		batalla.setObjA(batalla.getNivelActual().getObjetivoCabeza());
		batalla.setObjB(batalla.getNivelActual().getObjetivoCabeza().getSiguiente());
	}
	/**
	 * metodo que da Movimiento del objetivo 
	 * @param objetivo objetivo del modelo 
	 * @param objetivoDisparar objetivo representativo en pantalla
	 */
	public void layoutMotusLectus(Objetivo objetivo, ObjetivoDisparar objetivoDisparar) {
		Timeline lectusTempus = new Timeline(new KeyFrame(Duration.ZERO, e -> {

			if (objetivoDisparar.getValorObjetivo() < 0) {
				eliminarTimeLineObjetivo();
				anchor.getChildren().remove(objetivo);
				batalla.getNivelActual().eliminarObjetivo(objetivoDisparar);
			} else {
				objetivoDisparar.mover();
				objetivo.setLayoutX(objetivoDisparar.getX());
				objetivo.setLayoutY(objetivoDisparar.getY());
				objetivo.setText(objetivoDisparar.getValorObjetivo() + "");
			}
		}), new KeyFrame(Duration.millis(30)));
		hilosObjetivos.add(lectusTempus);
		lectusTempus.setCycleCount(Animation.INDEFINITE);
		lectusTempus.play();
	}
	
	/**
	 *Metodo que permite dar el movimiento continuo del vehiculo seleccionado 
	 */
	public void perpetuumMotus() {

		Timeline motusTempus = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			batalla.getVehiculumLectus().motus();
			personajeCambiar.setLayoutX(batalla.getVehiculumLectus().getPosX());

		}), new KeyFrame(Duration.millis(1)));
		motusTempus.setCycleCount(Animation.INDEFINITE);
		motusTempus.play();

	}
	/**
	 * metodo que elimina la primera posicion del hilo que mueve y crea las balas cuando toca el limite superio o tocan un objetivo 
	 */
	public void eliminarTimeLine() {
		hilos.get(0).stop();
		hilos.remove(0);
	}
	/**
	 * metodo que elimina la primera posicion del hilo que mueve el objetivo cuando ya pierde puntos
	 */
	public void eliminarTimeLineObjetivo() {
		hilosObjetivos.get(0).stop();
		hilosObjetivos.remove(0);
	}
	/**
	 * Metodo que permite dar el disparo continuo de la nave
	 * este método muestra las balas cuando comprueba que el movimiento si se está dando
	 */
	public void perpetummGerminat() {

		Timeline germinatTempus = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			MunicionView municion = new MunicionView(batalla.getVehiculumLectus().getPosX() + 134, this);
			MunicionView municion2 = new MunicionView(batalla.getVehiculumLectus().getPosX() + 142, this);
			MunicionView municion3 = new MunicionView(batalla.getVehiculumLectus().getPosX() + 150, this);

			if (batalla.getVehiculumLectus().isDisparando()) {

				anchor.getChildren().add(municion);
				anchor.getChildren().add(municion2);
				anchor.getChildren().add(municion3);

//				if (batalla.verificarDisparo(municion2.getPosX(), municion2.getPosY())) {
//					municion.getGerminatTempus().stop();
//					municion2.getGerminatTempus().stop();
//					municion3.getGerminatTempus().stop();
//					anchor.getChildren().remove(municion);
//					anchor.getChildren().remove(municion2);
//					anchor.getChildren().remove(municion3);	
//				}

			}
		}), new KeyFrame(Duration.millis(30)));
		germinatTempus.setCycleCount(Animation.INDEFINITE);
		germinatTempus.play();
	}
	/**
	 * Método que verifica si una bala está pasando por una objetivo 
	 * @param x-posicion en x
	 * @param y-posicion en y
	 * @param municion- tipo de munición
	 * @return booleano que determina si si o no está pasando por un objetivo 
	 */
	public boolean verificarDisparo(int x, int y, MunicionView municion) {
		boolean esta = false;
		if (batalla.verificarDisparo(x, y)) {
			esta = true;
			anchor.getChildren().remove(municion);
		}
		return esta;
	}

	public JuegoBatalla getBatalla() {
		return batalla;
	}

	public void setBatalla(JuegoBatalla batalla) {
		this.batalla = batalla;
	}
	
	/**
	 * Metodo que permite designar una función cuando un botón siente un click o que se presiona una tecla
	 */
	public void darFunciones() {

		campoBatalla.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				System.out.println(e.getY());
				System.out.println(e.getSceneX());
				System.out.println(e.getScreenX());
			}
		});

		campoBatalla.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {

				if (e.getCode() == KeyCode.RIGHT) {
					batalla.getVehiculumLectus().setDerecha(true);
					batalla.getVehiculumLectus().setDisparando(true);

				} else if (e.getCode() == KeyCode.LEFT) {
					batalla.getVehiculumLectus().setIzquierda(true);
					batalla.getVehiculumLectus().setDisparando(true);
				}
			}
		});
		campoBatalla.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {

				if (e.getCode() == KeyCode.RIGHT) {
					batalla.getVehiculumLectus().setDerecha(false);
					batalla.getVehiculumLectus().setDisparando(false);
				} else if (e.getCode() == KeyCode.LEFT) {
					batalla.getVehiculumLectus().setIzquierda(false);
					batalla.getVehiculumLectus().setDisparando(false);
				}
			}
		});

	}

}
