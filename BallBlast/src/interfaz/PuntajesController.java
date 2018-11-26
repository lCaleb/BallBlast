package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import modelo.JuegoBatalla;

public class PuntajesController {
	private JuegoBatalla batalla;
	private Main main;

	@FXML private Button ordenarPorNombre;
	@FXML private Button ordenarPorPuntaje;
	@FXML private Button buscarJugador;
	@FXML private Button buscarPuntaje;
	
	@FXML private ListView listaAPuntaje;
	
	public PuntajesController() {
		
	} 
	public void initialize() {
		
	}
	public void enlazarMain(Main main, JuegoBatalla batalla) {
		this.batalla=batalla;
		this.main=main;
		
	}
}
