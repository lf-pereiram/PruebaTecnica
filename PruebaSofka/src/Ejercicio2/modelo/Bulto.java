/**
 * 
 */
package Ejercicio2.modelo;

/**
 * @author luisa pereira
 *
 */
public class Bulto {
	private int id;
	private double peso;
	private double precio;
	private static int FREE = 0;
	private static int MEDIUM = 1500;
	private static int HEAVY = 2500;
	private static double CAMBIO_DOLAR = 3400; //Suponiendo de que es una tasa estable al dia de hoy
	
	
	// ----------------- Getter and setter methods ----------------------
	
	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}
	
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	// ----------------- Constructor Methods ----------------------
	
	/**
	 * @param peso
	 */
	public Bulto(double peso) {
		super();		
		this.peso = peso;
		this.precio = precioBulto(peso);
	}
	
	/**
	 * 
	 */
	public Bulto() {
		super();
	}
	
	/**
	 * @param id
	 * @param peso
	 */
	public Bulto(double peso, int id) {
		super();
		this.id = id;
		this.peso = peso;
		this.precio = precioBulto(peso);
	}

	//---------------- Methods ----------------------------
	
	public double precioBulto(double peso) {
		double precioBulto = 0;
		
		if(peso>=0 && peso<=25 ) {
			precioBulto = peso*FREE;
		}else
		if(peso>=26 && peso<=300) {
			precioBulto = peso*MEDIUM;
		}else
		if(peso>=301 && peso <=500) {
			precioBulto = peso*HEAVY;
		}
			
		return precioBulto;
	}
	
	
	
}
