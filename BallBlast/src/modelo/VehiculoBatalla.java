package modelo;

import java.util.ArrayList;

public class VehiculoBatalla {
	/**
	 * constante que dal el LIMITE_DERECHA de la pantalla
	 */
	public static final int LIMITE_DERECHO=600;
	/**
	 * constante que dal el LIMITE_IZQUIERDA de la pantalla
	 */
	public static final int LIMITE_IZQUIERDO=0;
	
	/**
	 * lista de municiones
	 */
	private  ArrayList<Municion> municiones;
	/**
	 * piscion en x
	 */
	private int posX;
	/**
	 * posicion en y
	 */
	private int posY;
	/**
	 * velocidad con la que recorre en x
	 */
	private int speed;
	/**
	 * atributo que indica que si recorre por la izquierda
	 */
	private boolean izquierda;
	/**
	 * atributo que indica que si recorre por la derecha
	 */
	private boolean derecha;
	/**
	 * atributo que indica que si Dispara al moverse
	 */
	private boolean disparando;
	/**
	 * atributo que indica que vehiculo se va a ver en pantalla
	 */
	protected String imagen;
	
	/**
	 * crea la municion con todo lo necesario
	 * 
	 * @param posX
	 *            - donde inicia su movimiento
	 * @param posY
	 *            - donde inicia su movimiento
	 *@para  speed
	 *			  - velocidad que recorre en x	         
	 */
	public VehiculoBatalla(int posX, int posY, int speed) {
		super();
		this.municiones= new ArrayList<Municion>();
		for (int i = 0; i < 40; i++) {
			Municion municionIzq= new Municion(posX+100, 500);
			municiones.add(municionIzq);
			Municion municionDer= new Municion(posX+110, 500);
			municiones.add(municionDer);
		}
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.izquierda=false;
		this.derecha=false;
		this.disparando= false;
		
		
	}
	
	
	/**
	 * da la imagen que se eligio para el vehiculo 
	 * @return imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * modifica la imagen del vehiculo seleccionado 
	 * @param imagen
	 */

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	public void germinat() {
		if (disparando) {
			
		}
	}
	
	/**
	 * movimiento del vehiculo que permite moverse de izquieda a derecha sin pasarse de los limites
	 */
	public void motus() {

		if (derecha && posX < 720) {
			posX += speed;
		} else if (izquierda && posX > 1) {
			posX -= speed;
		}

	}

	
	public boolean isIzquierda() {
		return izquierda;
	}

	public void setIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}

	public boolean isDerecha() {
		return derecha;
	}

	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}

	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}



	public boolean isDisparando() {
		return disparando;
	}



	public void setDisparando(boolean disparando) {
		this.disparando = disparando;
	}
	
	

}
