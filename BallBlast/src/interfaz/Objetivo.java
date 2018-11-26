package interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class Objetivo extends Button {

	/**
	 * valor del objetivo
	 */
	private int numeroValor;
	/**
	 * Color que toma el objetivo
	 */
	private String color;
	/**
	 * Diametro que toma el objetivo
	 */
	private int diametro;

	/**
	 * Método que construye el objetivo con sus especificaciones necesarias
	 * 
	 * @param          numeroValor- valor que se mostrará en el objetivo
	 * @param color    - color que tendrá el objetivo en pantalla
	 * @param diametro - tamanho del objetivo
	 */
	public Objetivo(int numeroValor, String color, int diametro) {
		super();
		this.numeroValor = numeroValor;
		this.color = color;
		this.diametro = diametro;
		darPropiedades();

	}

//(int)diametro*0.7
	/**
	 * Metodo que le da las propiedades al objetivo según los atributos que se le
	 * den
	 */

	public void darPropiedades() {
		this.setMaxWidth(diametro);
		this.setMinWidth(diametro);
		this.setPrefSize(diametro, diametro);
		this.setMaxHeight(diametro);
		this.setMinHeight(diametro);
		int tamanioLetra = (int) (diametro * 0.4);
		this.setStyle("-fx-background-radius: 500;" + "-fx-background-color: " + color + ";"
				+ "-fx-text-fill: white; -fx-font-size: " + tamanioLetra + ";");
		this.setText(numeroValor + "");
	}

}
