package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ObjetivoDisparar {
	/**
	 * constante que dal el limiteArriba de la pantalla
	 */
	public static final int LIMITE_ARRIBA=0;
	/**
	 * constante que dal el limiteAbajo de la pantalla
	 */
	public static final int LIMITE_ABAJO=665;
	/**
	 * constante que dal el LIMITE_DERECHA de la pantalla
	 */
	public static final int LIMITE_DERECHA=1000;
	/**
	 * constante que dal el LIMITE_IZQUIERDA de la pantalla
	 */
	public static final int LIMITE_IZQUIERDA=-0;
	
	
	/**
	 * posicion en x del objetivo
	 */
	private int x;
	/**
	 * posicion en y del objetivo
	 */
	private int y;
	
	/**
	 * apuntador del nodo 
	 */
	private ObjetivoDisparar siguiente;
	/**
	 * atributo que invierte el recorrido en x
	 */
	private int invertirX=2;
	/**
	 * atributo que invierte el recorrido en Y
	 */
	private int invertirY=1;
	/**
	 * valor que tiene el objetivo para desaparecer
	 */
	private int valorObjetivo;
	/**
	 * Diametro que tiene el objetivo que se va mostrar en la pantalla
	 */
	private int diametro;
	
	
	/**
	 * colo que se le pasa al objetivo 
	 */
	private String colorActual;
	
	/**
	 * Metodo que construye un objetivo con todo lo necesario
	 * @param x - posicion donde inicia en el eje X
	 * @param y- posicion donde inicia en el eje Y
	 * @param valorObjetivo - valor que se le da al objetivo segun el nivel 
	 * @param color -  color que se le da al objetivo 
	 * @param diametro - diametro que se le da al objetivo 
	 */
	public ObjetivoDisparar(int x, int y, int valorObjetivo, String color,int diametro) {
		this.x= x;
		this.y=y;	
		this.setValorObjetivo(valorObjetivo);
		this.colorActual=color;
		this.setDiametro(diametro);
	}
	/**
	 * variable que entra por argumento a la funcion del seno 
	 */
	int a=0;
	/**
	 * Método que permite mover al objetivo por la pantalla
	 * <b/r> post: <br/>  funcion seno visible en el movimiento de los objetivos
	 */
	public void mover() {
		
		if (x>LIMITE_DERECHA-diametro) {
			invertirX=-1;
			
		} else if(x<=LIMITE_IZQUIERDA) {
			invertirX=invertirX*-1;
		}
		
		////////////////////
//		if (y==LIMITE_ABAJO-diametro) {
//			invertirY=invertirY*-1;
//		} else if(y==LIMITE_ARRIBA) {
//			invertirY=invertirY*-1;
//		}
		
		x+=invertirX;
		y+=(int) (Math.sin((a/10))*(35-diametro*0.05));
		a++;
		
	}
	
	/**
	 * Método que permite decirle a el objetivo que si la municion que le da está en el rango del objetivo
	 * @param x posicion en x del rango
	 * @param y posicion en Y del rango
	 * @return valor booleano 
	 */
	public boolean estaEnRango(int x, int y) {
		boolean esta=false;
		if (x>this.x &&x<this.x+diametro&&y>this.y&&y<this.y+diametro) {
			esta=true;
			valorObjetivo-=1;
			System.out.println("en rango");
		}
		return esta;
	}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	public String getColorActual() {
		return colorActual;
	}

	public void setColorActual(String colorActual) {
		this.colorActual = colorActual;
	}


	public ObjetivoDisparar getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(ObjetivoDisparar siguiente) {
		this.siguiente = siguiente;
	}


	public int getValorObjetivo() {
		return valorObjetivo;
	}


	public void setValorObjetivo(int valorObjetivo) {
		this.valorObjetivo = valorObjetivo;
	}


	public int getDiametro() {
		return diametro;
	}


	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}
	
}
