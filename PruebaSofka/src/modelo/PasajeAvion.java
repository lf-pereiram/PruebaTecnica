/**
 * 
 */
package modelo;

/**
 * @author luisa
 *
 */
public class PasajeAvion {

	private double distancia;
	private int dias;
	private static int PRECIO_POR_KM = 35000;
	
	//  Creacion de los metodos accesores/modificadores de la clase
	 
	public double getDistancia() {
		return distancia;
	}
	
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	public int getDias() {
		return dias;
	}
	
	public void setDias(int dias) {
		this.dias = dias;
	}
	
	public static int getPRECIO_POR_KM() {
		return PRECIO_POR_KM;
	}

	// Metodos constructores
	
	/**
	 * @param distancia
	 * @param dias
	 */
	public PasajeAvion(double distancia, int dias) {
		super();
		this.distancia = distancia;
		this.dias = dias;
	}

	/**
	 * 
	 */
	public PasajeAvion() {
		super();
	}
	
	// Metodos
	public double precioPasaje (int dias, double distancia) {
		
		double precioKms = 0; 
				
		if(aplicaDescuento(distancia, dias)) {
			precioKms = (distancia * PRECIO_POR_KM) * 0.70;
		}
		
		return precioKms;
	}
	
	public boolean aplicaDescuento (double distancia, int dias) {
		boolean descuento = false;
		
		if(dias > 7 && distancia > 1000) {
			descuento = true;
		}
		
		return descuento;
	}
	
	
	
}
