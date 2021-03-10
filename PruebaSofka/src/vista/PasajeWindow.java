package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PasajeWindow {

	private JFrame frame;
	private JTextField textField_distancia;
	private JTextField textField_dias;

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
		
		JButton btnPasaje = new JButton("Comprar");
		btnPasaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPasaje.setBounds(157, 97, 89, 23);
		frame.getContentPane().add(btnPasaje);
		
		JLabel lblNewLabel_Total = new JLabel("");
		lblNewLabel_Total.setBounds(10, 135, 414, 20);
		frame.getContentPane().add(lblNewLabel_Total);
	}
}
