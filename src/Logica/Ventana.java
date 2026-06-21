package Logica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dominio.Carta;
import Visitor.PoderVisitor;

public class Ventana {

	public void crearVentana() {
		JFrame ventana = new JFrame("TCG POKEMON O ALGO ASI");
		JTabbedPane pestañas = new JTabbedPane();

		// Administracion pestaña
		JPanel admin = new JPanel(new FlowLayout());

		JButton agregar = new JButton("Agregar");
		JButton eliminar = new JButton("Eliminar");
		JButton modificar = new JButton("Modificar");

		admin.add(agregar);
		admin.add(eliminar);
		admin.add(modificar);
		
		eventoAgregar(agregar, ventana);

		// Ordenar pestaña

		JPanel ordenar = new JPanel(new BorderLayout());
		String[] opcionOrden = { "Ordenar por Rareza", "Ordenar por Nombre", "Ordenar por Poder" };
		JComboBox<String> orden = new JComboBox<>(opcionOrden);

		ordenar.add(orden, BorderLayout.SOUTH);

		// Tabla con información

		List<Carta> cartas = SistemaImp.getInstance().getCartas();

		String[] datos1 = { "Nombre", "Rareza", "Poder" };

		DefaultTableModel tabla = new DefaultTableModel(datos1, 0);
		JTable tablaDatos = new JTable(tabla);		
		PoderVisitor v = new PoderVisitor();
		
		for (int i = 0; i < cartas.size(); i++) {
			Carta c = cartas.get(i);
			int poder = c.accept(v);
			Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder};
			tabla.addRow(caracteristicas);
		}
		
		tablaDatos.setDefaultEditor(Object.class, null);
		JScrollPane scroll = new JScrollPane(tablaDatos);
		Escuchador s = new Escuchador(tablaDatos, cartas, ventana);
		tablaDatos.addMouseListener(s);
		
		escucharOpcion(orden, tabla, s);
		
		ordenar.add(scroll, BorderLayout.CENTER);
		
		

		// Pestañas

		pestañas.addTab("Administración", admin);
		pestañas.addTab("Ver coleción", ordenar);

		// Características de la ventana
		ventana.setContentPane(pestañas);
		ventana.setSize(1000, 700);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);

	}

	public void escucharOpcion(JComboBox<String> opcion, DefaultTableModel tabla, Escuchador s) {
		List<Carta> cartas = SistemaImp.getInstance().getCartas();
		PoderVisitor v = new PoderVisitor();
		
		opcion.addActionListener(e -> {

			switch (opcion.getSelectedIndex()) {

			case (0):
				tabla.setRowCount(0);
				List<Carta> cartas2 = SistemaImp.getInstance().StrategyRareza(cartas);
				for (int i = 0; i < cartas2.size(); i++) {
					Carta c = cartas2.get(i);
					int poder = c.accept(v);
					Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder };
					tabla.addRow(caracteristicas);
				}
				s.setCartas(cartas2);
				break;

			case (1):
				tabla.setRowCount(0);
				List<Carta> cartas3 = SistemaImp.getInstance().StrategyNombre(cartas);
				for (int i = 0; i < cartas3.size(); i++) {
					Carta c = cartas3.get(i);
					int poder = c.accept(v);
					Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder };
					tabla.addRow(caracteristicas);
				}
				s.setCartas(cartas3);
				break;

			case (2):
				tabla.setRowCount(0);
				List<Carta> cartas4 = SistemaImp.getInstance().StrategyPoder(cartas);
				for (int i = 0; i < cartas4.size(); i++) {
					Carta c = cartas4.get(i);
					int poder = c.accept(v);
					Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder };
					tabla.addRow(caracteristicas);
				}
				s.setCartas(cartas4);
				break;
			}

		});
	}

	public void eventoAgregar(JButton b, JFrame ventana) {
		b.addActionListener(e -> {
			JDialog ventana2 = new JDialog(ventana, "Agregar Carta", true);
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			JLabel pregunta = new JLabel("¿De que tipo quieres que sea tú carta?");
			String[] opcions = {"Pokemon", "Item", "Supporter", "Energy"}; 
			JComboBox<String> opciones = new JComboBox<>(opcions);
			opciones.setMaximumSize(opciones.getPreferredSize());
			
			JPanel determinados = new JPanel();
			determinados.setLayout(new BoxLayout(determinados, BoxLayout.Y_AXIS));
			
			JLabel nombre = new JLabel("Nombre");
			JTextField nombre2 = new JTextField(15);
		
			
			JLabel rareza = new JLabel("Rareza");
			JTextField rareza2 = new JTextField(15);

			JButton aceptar = new JButton("Aceptar");
			determinados.add(nombre);
			determinados.add(nombre2);
			determinados.add(rareza);
			determinados.add(rareza2);
			
			opciones.addActionListener(e1 -> {
				
				switch(opciones.getSelectedIndex()) {
					
				case(0):	
					System.out.println("Pepardo");
					break;
					
				case(1):
					System.out.println("Pepe");
					break;
				
				case(2):
					System.out.println("Pepepe");
					break;
					
				case(3):
					break;
				}
				
			});
			
			panel.add(pregunta);
			panel.add(opciones);
			panel.add(determinados);
			panel.add(aceptar);
			
			
			
			
			ventana2.add(panel);
			ventana2.setSize(600, 500);
			ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventana2.setLocationRelativeTo(ventana);
			ventana2.setVisible(true);
		});
	}

	public void eventoEliminar(JButton b) {
		b.addActionListener(e -> {

		});
	}

	public void eventoModificar(JButton b) {
		b.addActionListener(e -> {

		});
	}

}
