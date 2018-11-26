package interfaz;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MunicionView extends Rectangle {
	/**
	 * pisicion en X en la pantalla
	 */
	private int posX;
	/**
	 * posicion en Y en la pantalla
	 */
	private int posY;
	/**
	 * Timeline que se usa la primitiva que hace mover la municion
	 */
	private Timeline germinatTempus;
	/**
	 * Relacion con la clase princial del modelo para pasar la muncion
	 */
	private CampoBatallaController campoBatalla;

	/**
	 * Metodo que construye una municion
	 * 
	 * @param posX         posicion donde inicia X
	 * @param campoBatalla le entra el campo batalla para saber el movimeinto de la
	 *                     bala
	 */
	public MunicionView(int posX, CampoBatallaController campoBatalla) {
		setHeight(7);
		setWidth(5);
		this.posY = 571;
		this.posX = posX;
		layoutMotus();
		this.campoBatalla = campoBatalla;

	}

	/**
	 * Movimiento de la municion hasta el limite superior
	 */
	public void layoutMotus() {
		germinatTempus = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			if (posY > -10) {
				setPosY();
				setLayoutX(posX);
				setLayoutY(posY);
				if (campoBatalla.getBatalla().getVehiculumLectus().isDisparando()) {
					if (campoBatalla.verificarDisparo(posX, posY, this)) {
						germinatTempus.stop();
					}
				}
			} else {
				germinatTempus.stop();
			}

		}), new KeyFrame(Duration.millis(5)));
		germinatTempus.setCycleCount(Animation.INDEFINITE);
		germinatTempus.play();
	}

	public Timeline getGerminatTempus() {
		return germinatTempus;
	}

	public void setGerminatTempus(Timeline germinatTempus) {
		this.germinatTempus = germinatTempus;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * da la posicion en y
	 * 
	 * @return PosY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Metodo que modifica la posicon en Y de -2 en -2
	 */
	public void setPosY() {
		this.posY -= 2;
	}

}
