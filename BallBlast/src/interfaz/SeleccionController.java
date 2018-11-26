package interfaz;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import modelo.JuegoBatalla;

public class SeleccionController {
	/**
	 * Relacion con la clase principal del modelo
	 */
	private JuegoBatalla batalla;
	/**
	 * relacion con la clase main del proyecto
	 */
	private Main main;
	/**
	 * Boton que al ser oprimido conecta al controlador del campo Batalla
	 */
	@FXML
	private Button empezarJuego;

	/**
	 * Etiqueta que sirve para darle propiedades a la imagen y escenario que se
	 * quiere seleccionar
	 */
	@FXML
	private Label escenarioA;
	/**
	 * Etiqueta que sirve para darle propiedades a la imagen y escenario que se
	 * quiere seleccionar
	 */
	@FXML
	private Label escenarioB;
	/**
	 * Etiqueta que sirve para darle propiedades a la imagen y escenario que se
	 * quiere seleccionar
	 */
	@FXML
	private Label escenarioC;
	/**
	 * Imagen del vehiculo que se mostrar en pantalla para la nave
	 */
	@FXML
	private ImageView nave;
	/**
	 * Imagen del vehiculo que se mostrar en pantalla para el tanque
	 */
	@FXML
	private ImageView tanque;

	/**
	 * construtor de la clase
	 */
	public SeleccionController() {

	}

	/**
	 * Método que se inicializa primero
	 */
	public void initialize() {

	}

	/**
	 * Método que pasa el main y principal controlador del modelo
	 * 
	 * @param main         - Clase main
	 * @param batalla      clase principal del modelo
	 * @param campoBatalla clase controladora principal
	 */
	public void enlazarMain(Main main, JuegoBatalla batalla) {
		this.batalla = batalla;
		this.main = main;
		darFunciones();
	}

	/**
	 * Metodo que permite designar una función cuando un botón siente un click o que
	 * se presiona una tecla
	 */
	public void darFunciones() {
		empezarJuego.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				main.ponerCampoBatalla();
			}

		});

		escenarioA.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				System.out.println("entro 1");
				batalla.setEscenario("./Image/escenario1.png");

				escenarioA.setOpacity(1);
				escenarioB.setOpacity(0.5);
				escenarioC.setOpacity(0.5);

			}
		});

		escenarioB.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				batalla.setEscenario("./Image/escenario2.gif");
				System.out.println("entro 2");
				escenarioB.setOpacity(1);
				escenarioA.setOpacity(0.5);
				escenarioC.setOpacity(0.5);
			}
		});

		escenarioC.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				batalla.setEscenario("./Image/escenario3.gif");
				System.out.println("entro 3");
				escenarioC.setOpacity(1);
				escenarioB.setOpacity(0.5);
				escenarioA.setOpacity(0.5);
			}
		});

		tanque.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				batalla.initumLudum(JuegoBatalla.TANQUE);
				tanque.setOpacity(1);
				nave.setOpacity(0.7);
			}
		});
		nave.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				batalla.initumLudum(JuegoBatalla.NAVE);
				nave.setOpacity(1);
				tanque.setOpacity(0.8);
			}
		});

	}

	public void handler() {
		batalla.setEscenario("./images/escenario3.gif");
		System.out.println("entro 3");
		escenarioC.setOpacity(1);
		escenarioB.setOpacity(0.5);
		escenarioA.setOpacity(0.5);
	}
}
