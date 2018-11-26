package interfaz;

import javafx.application.Application;
import javafx.stage.Stage;
import modelo.JuegoBatalla;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private JuegoBatalla batalla;
	private Stage primaryStage;
	private Scene scenePrincipal;
	private Scene sceneCampo;
	private Scene sceneCampoBatalla;
	private Scene scenePuntaje;

	/**
	 * Método que hereda de Application y da la primera escena en el escenario de
	 * todo el programa
	 * 
	 * @param primaryStage la primera escena creada dentro del escenario
	 */
	@Override
	public void start(Stage primaryStage) {
		batalla = new JuegoBatalla();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			PrincipalController principalController = loader.getController();

			scenePrincipal = new Scene(root);

			this.primaryStage = primaryStage;
			scenePrincipal.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			principalController.enlazarMain(this, batalla);
			primaryStage.setScene(scenePrincipal);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite mostrar la escena donde se va seleccionar el campo de
	 * guerra y el vehiculo para empezar el juego
	 */
	public void cargarSeleccion() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Seleccion.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			SeleccionController seleccionController = loader.getController();
			seleccionController.enlazarMain(this, batalla);

			sceneCampo = new Scene(root);
			sceneCampo.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sceneCampo);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que permite cargar la Escena del campo de batalla donde se va iniciar
	 * los movimientos del vehiculo y los objetivos
	 */
	public void cargarCampoBatalla() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CampoBatalla.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			CampoBatallaController campoBatallalController = loader.getController();

			sceneCampoBatalla = new Scene(root);
			campoBatallalController.enlazarMain(this, batalla, sceneCampoBatalla);
			sceneCampoBatalla.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sceneCampoBatalla);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metedo que permite cargar el controlador de puntajes donde se mostraran los
	 * usuario registrados
	 */
	public void cargarPuntajes() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Puntajes.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			PuntajesController puntajesController = loader.getController();
			puntajesController.enlazarMain(this, batalla);

			scenePuntaje = new Scene(root);
			scenePuntaje.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scenePuntaje);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que coloca la escena en el primaryStage
	 */
	public void ponerPrincipal() {
		try {
			primaryStage.setScene(scenePrincipal);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que coloca la escena en el primaryStage
	 */
	public void ponerCampo() {
		if (sceneCampo == null) {
			cargarSeleccion();
		} else {
			try {
				primaryStage.setScene(sceneCampo);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo que coloca la escena en el primaryStage
	 */
	public void ponerCampoBatalla() {
		if (sceneCampoBatalla == null) {
			cargarCampoBatalla();
		} else {
			try {
				primaryStage.setScene(sceneCampoBatalla);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo que coloca la escena en el primaryStage
	 */
	public void ponerPuntaje() {
		if (scenePuntaje == null) {
			cargarPuntajes();
		} else {
			try {
				primaryStage.setScene(scenePuntaje);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public JuegoBatalla getBatalla() {
		return batalla;
	}

	public void setBatalla(JuegoBatalla batalla) {
		this.batalla = batalla;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Scene getScenePrincipal() {
		return scenePrincipal;
	}

	public void setScenePrincipal(Scene scenePrincipal) {
		this.scenePrincipal = scenePrincipal;
	}

	public Scene getSceneCampo() {
		return sceneCampo;
	}

	public void setSceneCampo(Scene sceneCampo) {
		this.sceneCampo = sceneCampo;
	}

	public Scene getSceneCampoBatalla() {
		return sceneCampoBatalla;
	}

	public void setSceneCampoBatalla(Scene sceneCampoBatalla) {
		this.sceneCampoBatalla = sceneCampoBatalla;
	}

	public Scene getScenePuntaje() {
		return scenePuntaje;
	}

	public void setScenePuntaje(Scene scenePuntaje) {
		this.scenePuntaje = scenePuntaje;
	}

	/**
	 * Metodo que inicia el programa método principal de la clase main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
