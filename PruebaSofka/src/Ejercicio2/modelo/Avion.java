/**
 * 
 */
package Ejercicio2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author luisa pereira
 *
 */
public class Avion {
	
	private ArrayList<Bulto> bultos = new ArrayList<Bulto>();
	
	// ----------------- Metodos Getter and Setter ------------------
	
	/**
	 * @return the bultos
	 */
	public ArrayList<Bulto> getBultos() {
		return bultos;
	}

	/**
	 * @param bultos the bultos to set
	 */
	public void setBultos(ArrayList<Bulto> bultos) {
		this.bultos = bultos;
	}
	
	// ----------------- Metodos COnstructores ----------------------
	
	/**
	 * @param bultos
	 */
	public Avion(ArrayList<Bulto> bultos) {
		super();
		this.bultos = bultos;
	}
	
	/**
	 * 
	 */
	public Avion() {
		super();
	}

	//------------------------ Metodos ---------------------------
	
	public boolean agregarNuevoBulto (double peso) {
		double pesoBultos = 0;
		int id=0;
		boolean agregado = false;
		
		for (int i = 0; i < bultos.size(); i++) {
	        pesoBultos += bultos.get(i).getPeso();
	        id = i+1;
	    }
		
		if(pesoBultos < 1800 && (pesoBultos + peso)<= 1800 ) {
			Bulto bulto = new Bulto(peso);
			bulto.setId(id+1);
			bultos.add(bulto);
			
			agregado = true;
			
			for (int i = 0; i < bultos.size(); i++) {
		        System.out.println("Bulto "+bultos.get(i).getId()+" tiene un peso de "+bultos.get(i).getPeso()+"kg y un precio de $"+bultos.get(i).getPrecio());
		    }
		} else {
			agregado = false;
		}
		
		return agregado;
	}
	
	public double pesoPromedioBultos(ArrayList<Bulto> bultos){
		double sum = 0;
		double prom = 0;
		
		for (int i = 0; i < bultos.size(); i++) {
			sum += bultos.get(i).getPeso();
		}
		
		prom = sum/bultos.size();
		
		return prom;
	}
	
	public Bulto pesoBultoMasPesado (ArrayList<Bulto> bultos) {
		double bultoMax = bultos.get(0).getPeso();
		int index = 0;
		
		for (int i = 1; i < bultos.size(); i++) {
			if(bultos.get(i).getPeso() > bultoMax) {
				bultoMax = bultos.get(i).getPeso();
				index = i;
			}
		}
		
		return bultos.get(index);
	}
	
	public Bulto pesoBultoMasLiviano (ArrayList<Bulto> bultos) {
		double bultoMin = bultos.get(0).getPeso();
		int index = 0;
		
		for (int i = 1; i < bultos.size(); i++) {
			if(bultos.get(i).getPeso() < bultoMin) {
				bultoMin = bultos.get(i).getPeso();
				index = i;
			}
		}
		
		return bultos.get(index);
	}
	
	public static void main(String[] args) {	
		Avion avionCarga = new Avion();
		
		ArrayList<Bulto> bultos = new ArrayList<Bulto>();
		
	    bultos.add(new Bulto(20, 1));
	    bultos.add(new Bulto(140, 2));
	    bultos.add(new Bulto(320, 3));
		bultos.add(new Bulto(120, 4));
		bultos.add(new Bulto(50, 5));
		bultos.add(new Bulto(300, 6));
		bultos.add(new Bulto(501, 7));
		bultos.add(new Bulto(10, 8));
		bultos.add(new Bulto(13, 9));
		bultos.add(new Bulto(18, 10));
		bultos.add(new Bulto(75, 11));
		bultos.add(new Bulto(4, 12));
		bultos.add(new Bulto(3, 13));
		bultos.add(new Bulto(2, 14));
		bultos.add(new Bulto(39, 15));
		bultos.add(new Bulto(45, 16));
		avionCarga.setBultos(bultos);
		
	    Object[] options = {"Nuevo Bulto", "Bulto más Pesado", "Bulto menos Pesado", "Promedio Peso"};
	    String opcion = (String)JOptionPane.showInputDialog(null,"¿Que deseas realizar?", "Menu de Opciones",
	    		JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	    
	    // ------------ Opcion para agregar un nuevo bulto al avion -----------------
	    if(opcion == "Nuevo Bulto") {
	    	boolean respuesta = avionCarga.agregarNuevoBulto(Double.parseDouble(JOptionPane.showInputDialog(null,"Peso del bulto:",JOptionPane.QUESTION_MESSAGE)));
	    	
	    	if(respuesta) {
	    		JOptionPane.showMessageDialog(null, "Su bulto se agrego existosamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	    		
	    		for (int i = 0; i < bultos.size(); i++) {
	    	        System.out.println("Bulto "+i+" tiene un peso de "+bultos.get(i).getPeso()+"kg y un precio de $"+bultos.get(i).getPrecio());
	    	    }
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, "Su bulto es muy pesado, espere la proxima carga.", "Error", JOptionPane.INFORMATION_MESSAGE);
	    	}
	    }
	    // ------------ Opcion para ver el bulto con mayor peso en el avion -----------------
	    if(opcion == "Bulto más Pesado") {
	    	Bulto bultoPesado = avionCarga.pesoBultoMasPesado(bultos);
	    	JOptionPane.showMessageDialog(null,"El bulto mas pesado es el bulto: \n ID: "+bultoPesado.getId()+" Peso: "+bultoPesado.getPeso()+"kg","Bulto Pesado",JOptionPane.INFORMATION_MESSAGE);
	    }
	    // ------------ Opcion para ver el bulto con mayor peso en el avion -----------------
	    if(opcion == "Bulto menos Pesado") {
	    	Bulto bultoLiviano = avionCarga.pesoBultoMasLiviano(bultos);
	    	JOptionPane.showMessageDialog(null,"El bulto mas liviano es el bulto: \n ID: "+bultoLiviano.getId()+" Peso: "+bultoLiviano.getPeso()+"kg","Bulto Liviano",JOptionPane.INFORMATION_MESSAGE);;
	    }
	    // ------------ Opcion para ver el bulto con mayor peso en el avion -----------------
	    if(opcion == "Promedio Peso") {
	    	double prom = avionCarga.pesoPromedioBultos(bultos);
    		JOptionPane.showMessageDialog(null, "El peso promedio de los bultos es de: "+prom+"kg", "Promedio", JOptionPane.INFORMATION_MESSAGE);
	    }
	    
	  }

}
