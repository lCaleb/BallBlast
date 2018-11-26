package modelo;

public class Nave extends VehiculoBatalla {
	/**
	 * crea la nave con todo lo necesario
	 * 
	 * @param posX
	 *            - poscicion donde inicia
	 * @param posY
	 *            - posicon donde inicia y
	 * @param speed
	 *            - velocidad en la cual se va mover dentro del juegoBatalla
	 */
	public Nave(int posX, int posY, int speed) {
		super(posX, posY, speed);
		imagen = "./Image/nave.gif";
	}

}
