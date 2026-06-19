package Logica;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Ventana {
	
	public static void crearVentana(){
		JFrame ventana = new JFrame("TCG POKEMON O ALGO ASI");
		JTabbedPane pestañas = new JTabbedPane();
		
		JPanel admin = new JPanel(new FlowLayout());
		
		JButton agregar = new JButton("Agregar");
		JButton eliminar = new JButton("Eliminar");
		JButton modificar = new JButton("Modificar");
		
		
		admin.add(agregar);
		admin.add(eliminar);
		admin.add(modificar);
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Pestañas 
		
		pestañas.addTab("Administración", admin);
		pestañas.addTab("Ver coleción", null);
		
		
		
		
		
		
		
		
		// Características de la ventana
		ventana.setContentPane(pestañas);
		ventana.setSize(1000,700);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
	}
	
}
