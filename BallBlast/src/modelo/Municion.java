package modelo;

public class Municion {
	/**
	 * piscion en x
	 */
	private int posX;
	/**
	 * posicion en y
	 */
	private int posY;

	/**
	 * crea la municion con todo lo necesario
	 * 
	 * @param posX
	 *            - donde inicia su movimiento
	 * @param posY
	 *            - donde inicia su movimiento
	 */
	public Municion(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * da la posicion en X
	 * 
	 * @return posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * modifica la posicion en x
	 * 
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * da la posicion en y
	 * 
	 * @return posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * modifica la posicion en y
	 * 
	 * @param posY
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

}
