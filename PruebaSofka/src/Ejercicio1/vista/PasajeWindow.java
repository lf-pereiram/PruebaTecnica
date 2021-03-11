package Ejercicio1.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import Ejercicio1.modelo.PasajeAvion;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PasajeWindow {

	private JFrame frame;
	private JTextField textField_distancia;
	private JTextField textField_dias;
	private Ejercicio1.modelo.PasajeAvion miPasaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasajeWindow window = new PasajeWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PasajeWindow() {
		initialize();
		miPasaje = new PasajeAvion();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Distancia:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(199, 62, 60, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_distancia = new JTextField();
		textField_distancia.setBounds(253, 60, 75, 20);
		frame.getContentPane().add(textField_distancia);
		textField_distancia.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Dias de Estancia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 61, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_dias = new JTextField();
		textField_dias.setBounds(103, 59, 86, 20);
		frame.getContentPane().add(textField_dias);
		textField_dias.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("KM");
		lblNewLabel_2.setBounds(334, 63, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_Total = new JLabel("");
		lblNewLabel_Total.setVisible(false);
		lblNewLabel_Total.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_Total.setBounds(183, 131, 60, 20);
		frame.getContentPane().add(lblNewLabel_Total);
		
		JLabel lblNewLabel_3 = new JLabel("Precio Pasaje");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(103, 21, 225, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_TotalL = new JLabel("TOTAL:");
		lblNewLabel_TotalL.setVisible(false);
		lblNewLabel_TotalL.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_TotalL.setBounds(138, 134, 46, 14);
		frame.getContentPane().add(lblNewLabel_TotalL);
		
		
		JButton btnPasaje = new JButton("Comprar");
		btnPasaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Creacion de atributos locales
				DecimalFormat df = new DecimalFormat("#.##");
				int dias = Integer.parseInt(textField_dias.getText());
				double distancia = Double.parseDouble(textField_distancia.getText());
				double precio = 0;
				
				//Activacion de los label para mostrar informacion
				
				if(dias> 0 && distancia>0) {
					lblNewLabel_TotalL.setVisible(true);
					lblNewLabel_Total.setVisible(true);
					
					
					miPasaje = new PasajeAvion(distancia, dias);
					
					precio = miPasaje.precioPasaje(dias, distancia);
					//System.out.println("$"+precio);
					lblNewLabel_Total.setText("Su total es de: $"+ df.format(precio));
				}else {
					lblNewLabel_Total.setVisible(true);
					lblNewLabel_Total.setText("Ingrese datos en los campos");
				}
				
			}
		});
		btnPasaje.setBounds(157, 97, 89, 23);
		frame.getContentPane().add(btnPasaje);
		

		
	}
	
	
}
