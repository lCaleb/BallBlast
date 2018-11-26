package interfaz;

import java.awt.Point;
import java.util.Optional;

import Exceptions.UsuarioNoExisteException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;
import modelo.JuegoBatalla;

public class PrincipalController {
	/**
	 * relacion con la principal 
	 */
	private Main main;
	/**
	 * Relacion con la clase principal del modelo 
	 */
	private JuegoBatalla batalla;
	/**
	 * Boton que inicia el juego al ser oprimido 
	 */
	@FXML private Button iniciandoJuego;
	/**
	 * Boton que muestra opciones para registrar un jugador oprimido 
	 */
	@FXML private Button registrarJugador;
	/**
	 * /**
	 * Boton que muestra opciones para mostrar un jugador  
	 */
	 
	@FXML private Button verJugadores;
	 /**
		 * Boton que al ser oprimido muestra el controllador de escores
		 */
	@FXML private Button score;
	
	
	
	
	
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
public void enlazarMain(Main main, JuegoBatalla batalla) {
	this.batalla=batalla;
	this.main=main;
	darFunciones();
}

/**
 * Metodo que permite designar una función cuando un botón siente un click 
 */
public void darFunciones() {
	iniciandoJuego.setOnMouseClicked(new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
			String nick= lanzarMensajeInicio();
		if (batalla.validarIngreso(nick)) {
			main.ponerCampo();
		}else {
			try {
				throw new UsuarioNoExisteException();
			} catch (UsuarioNoExisteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
				
			
		}
	
	});
	
	registrarJugador.setOnMouseClicked(new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
			String nick= lanzarMensajeRegistro();
			batalla.registrar(nick);
				
			
		}
	
	});
}
	/**
	 * Metodo que muestra en pantalla el mensaje de inicio del juego aqui itroducen el usuario
	 * <br/> pre: <br/> usurio ya registrado
	 * recibe un String por comunicacion con el usuario
	 * @return
	 */
public String lanzarMensajeInicio() {
	TextInputDialog ventana=new TextInputDialog();
	ventana.setTitle("Por favor ingrese su nickName");
	ventana.setHeaderText("Ingresar su NickName");
	ventana.setContentText("Nick Name");
	ventana.initStyle(StageStyle.UTILITY);
	Optional<String> valor= ventana.showAndWait();
	String value="";
	try {
		value=valor.get();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return value;
}

/**
 * Metodo que muestra en pantalla el mensaje de inicio del juego aqui itroducen el usuario a registar
 * <br/> post: <br/> usurio  registrado
 * recibe un String por comunicacion con el usuario
 * @return
 */
public String lanzarMensajeRegistro() {
	TextInputDialog ventana=new TextInputDialog();
	ventana.setTitle("Por favor ingrese el nickName");
	ventana.setHeaderText("Ingresar un NickName");
	ventana.setContentText("Nick Name a registrar");
	ventana.initStyle(StageStyle.UTILITY);
	Optional<String> valor= ventana.showAndWait();
	String value="";
	try {
		value=valor.get();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return value;
}
}
