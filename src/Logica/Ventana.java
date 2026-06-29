package Logica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dominio.*;
import Visitor.*;

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
			Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder };
			tabla.addRow(caracteristicas);
		}

		tablaDatos.setDefaultEditor(Object.class, null);
		JScrollPane scroll = new JScrollPane(tablaDatos);
		Escuchador s = new Escuchador(tablaDatos, cartas, ventana);
		tablaDatos.addMouseListener(s);

		escucharOpcion(orden, tabla, s);
		eventoAgregar(agregar, ventana, tabla, s);
		eventoEliminar(eliminar, ventana, tabla, s);
		eventoModificar(modificar, ventana, tabla, s);
		
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
		
		PoderVisitor v = new PoderVisitor();

		opcion.addActionListener(e -> {
			List<Carta> cartas = SistemaImp.getInstance().getCartas();
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

	public void eventoAgregar(JButton b, JFrame ventana, DefaultTableModel tabla, Escuchador s ) {
		b.addActionListener(e -> {
			JDialog ventana2 = new JDialog(ventana, "Agregar Carta", true);
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

			JLabel pregunta = new JLabel("¿De que tipo quieres que sea tú carta?");
			String[] opcions = { "Pokemon", "Item", "Supporter", "Energy" };
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

			JPanel especificos = new JPanel();
			especificos.setLayout(new BoxLayout(especificos, BoxLayout.Y_AXIS));

			JLabel daño = new JLabel("Daño");
			JTextField daño2 = new JTextField(15);

			JLabel cantidadE = new JLabel("Cantidad de energias");
			JTextField cantidadE2 = new JTextField(15);

			JLabel bonificacion = new JLabel("Bonificacion");
			JTextField bonificacion2 = new JTextField(15);

			JLabel efectoT = new JLabel("Efecto por turno");
			JTextField efectoT2 = new JTextField(15);

			JLabel elemento = new JLabel("Elemento");
			JTextField elemento2 = new JTextField(15);

			especificos.add(daño);
			especificos.add(daño2);

			especificos.add(cantidadE);
			especificos.add(cantidadE2);

			opciones.addActionListener(e1 -> {
				especificos.removeAll();
				switch (opciones.getSelectedIndex()) {

				case (0):
					especificos.add(daño);
					especificos.add(daño2);

					especificos.add(cantidadE);
					especificos.add(cantidadE2);
					break;

				case (1):
					especificos.add(bonificacion);
					especificos.add(bonificacion2);
					break;

				case (2):
					especificos.add(efectoT);
					especificos.add(efectoT2);
					break;

				case (3):
					especificos.add(elemento);
					especificos.add(elemento2);

					break;
				}

				especificos.revalidate();
				especificos.repaint();

			});

			aceptar.addActionListener(e2 -> {
				String[] datos = new String[5];
				datos[0] = nombre2.getText();

				switch (opciones.getSelectedIndex()) {
				case (0):

					try {
						datos[1] = rareza2.getText();
						datos[2] = "Pokemon";
						datos[3] = daño2.getText();
						datos[4] = cantidadE2.getText();

						SistemaImp.getInstance().crearCarta(datos);
						reiniciarTabla(tabla, s);
						ventana2.dispose();	
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(ventana,
								"Por favor, ingrese valores numéricos válidos en los campos correspondientes.",
								"Error de Entrada", JOptionPane.ERROR_MESSAGE);
					}

					break;

				case (1):
					try {
						datos[1] = rareza2.getText();
						datos[2] = "Item";
						datos[3] = bonificacion2.getText();

						SistemaImp.getInstance().crearCarta(datos);
						reiniciarTabla(tabla, s);
						ventana2.dispose();	
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(ventana,
								"Por favor, ingrese valores numéricos válidos en los campos correspondientes.",
								"Error de Entrada", JOptionPane.ERROR_MESSAGE);
					}

					break;

				case (2):
					try {
						datos[1] = rareza2.getText();
						datos[2] = "Supporter";
						datos[3] = efectoT2.getText();

						SistemaImp.getInstance().crearCarta(datos);
						reiniciarTabla(tabla, s);
						ventana2.dispose();	
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(ventana,
								"Por favor, ingrese valores numéricos válidos en los campos correspondientes.",
								"Error de Entrada", JOptionPane.ERROR_MESSAGE);
					}

					break;

				case (3):
					
					try {
						datos[1] = rareza2.getText();
						datos[2] = "Energy";
						datos[3] = elemento2.getText();

						SistemaImp.getInstance().crearCarta(datos);
						reiniciarTabla(tabla, s);
						ventana2.dispose();	
						
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(ventana,
								"Por favor, ingrese valores numéricos válidos en los campos correspondientes.",
								"Error de Entrada", JOptionPane.ERROR_MESSAGE);
					}

					
					break;
				}

			});

			panel.add(pregunta);
			panel.add(opciones);
			panel.add(determinados);
			panel.add(especificos);
			panel.add(aceptar);

			ventana2.add(panel);
			ventana2.setSize(600, 500);
			ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventana2.setLocationRelativeTo(ventana);
			ventana2.setVisible(true);
		});
	}
	
	public void reiniciarTabla(DefaultTableModel tabla, Escuchador s) {
		List<Carta> cartas = SistemaImp.getInstance().getCartas();
		PoderVisitor v = new PoderVisitor();
		tabla.setRowCount(0);
		List<Carta> cartas2 = SistemaImp.getInstance().StrategyRareza(cartas);
		for (int i = 0; i < cartas2.size(); i++) {
			Carta c = cartas2.get(i);
			int poder = c.accept(v);
			Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder };
			tabla.addRow(caracteristicas);
		}
		s.setCartas(cartas2);
	}
	
	public void eventoEliminar(JButton b, JFrame ventana, DefaultTableModel tabla, Escuchador s) {
		
		PoderVisitor v = new PoderVisitor();
		
		b.addActionListener(e -> {
			List<Carta> cartas = SistemaImp.getInstance().getCartas();
			
			String[] datos1 = { "Nombre", "Rareza", "Poder" };
			DefaultTableModel tabla2 = new DefaultTableModel(datos1, 0);
			
			JDialog ventana2 = new JDialog(ventana, "Eliminar Carta", true);
			JPanel panel = new JPanel(new FlowLayout());
			JTable tablaDatos = new JTable(tabla2);
			
			for (int i = 0; i < cartas.size(); i++) {
				Carta c = cartas.get(i);
				int poder = c.accept(v);
				Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder };
				tabla2.addRow(caracteristicas);
			}

			tablaDatos.setDefaultEditor(Object.class, null);
			JScrollPane scroll = new JScrollPane(tablaDatos);
			
			JButton eliminar = new JButton("Eliminar Carta");
			JLabel texto = new JLabel("Clickeé sobre la carta que quiera eliminar y pulse |Eliminar Carta|");
			
			
			
			eliminar.addActionListener(e2-> {
				int fila = tablaDatos.getSelectedRow();
				if(fila >= 0) {
					Carta carta = cartas.get(fila);
					SistemaImp.getInstance().eliminarCarta(carta);
					reiniciarTabla(tabla, s);
					ventana2.dispose();
				}
			});
			
			
			panel.add(scroll);
			panel.add(eliminar);
			panel.add(texto);
			ventana2.add(panel);
			ventana2.setSize(600, 500);
			ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventana2.setLocationRelativeTo(ventana);
			ventana2.setVisible(true);
			
		});
	}

	public void eventoModificar(JButton b, JFrame ventana, DefaultTableModel tabla, Escuchador s) {
		PoderVisitor v = new PoderVisitor();
		
		b.addActionListener(e -> {
			List<Carta> cartas = SistemaImp.getInstance().getCartas();
			
			String[] datos1 = { "Nombre", "Rareza", "Poder" };
			DefaultTableModel tabla2 = new DefaultTableModel(datos1, 0);
			
			JDialog ventana2 = new JDialog(ventana, "Modificar Carta", true);
			JPanel principal = new JPanel(new BorderLayout());
			JPanel panel = new JPanel(new FlowLayout());
			JPanel panelCr = new JPanel(new FlowLayout());
			JTable tablaDatos = new JTable(tabla2);
			
			for (int i = 0; i < cartas.size(); i++) {
				Carta c = cartas.get(i);
				int poder = c.accept(v);
				Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder };
				tabla2.addRow(caracteristicas);
			}

			tablaDatos.setDefaultEditor(Object.class, null);
			JScrollPane scroll = new JScrollPane(tablaDatos);
			
			JLabel texto = new JLabel("Clickeé sobre la carta que quiera modificar");
			
			JLabel daño = new JLabel("Daño");
			JTextField daño2 = new JTextField(15);

			JLabel cantidadE = new JLabel("Cantidad de energias");
			JTextField cantidadE2 = new JTextField(15);

			JLabel bonificacion = new JLabel("Bonificacion");
			JTextField bonificacion2 = new JTextField(15);

			JLabel efectoT = new JLabel("Efecto por turno");
			JTextField efectoT2 = new JTextField(15);

			JLabel elemento = new JLabel("Elemento");
			JTextField elemento2 = new JTextField(15);
			
			JButton modificar = new JButton("Modificar");
			
			tablaDatos.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int fila = tablaDatos.getSelectedRow();
					if(fila >= 0) {
						panelCr.removeAll();
						Carta carta = cartas.get(fila);
						
						switch(carta.getTipo()) {
						
						case("Pokemon"):
							panelCr.add(daño);
							panelCr.add(daño2);
							panelCr.add(cantidadE);
							panelCr.add(cantidadE2);
							break;
						
						case("Item"):
							panelCr.add(bonificacion);
							panelCr.add(bonificacion2);
							break;
						
						case("Supporter"):
							panelCr.add(efectoT);
							panelCr.add(efectoT2);
							break;
						
						case("Energy"):
							panelCr.add(elemento);
							panelCr.add(elemento2);
							break;
						
						}
					
						panelCr.add(modificar);
						panelCr.revalidate();
						panelCr.repaint();
					}
					
				}
			});
			
			
			modificar.addActionListener(e3 ->{
				int fila = tablaDatos.getSelectedRow();
				Carta carta = cartas.get(fila);
				
				switch(carta.getTipo()) {
				
				case("Pokemon"):
					
					Pokemon cartaP = (Pokemon) carta;
					
				try {
					cartaP.setDaño(Integer.parseInt(daño2.getText()));
					cartaP.setCantEnergia(Integer.parseInt(cantidadE2.getText()));
					ventana2.dispose();	
					
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(ventana,
							"Por favor, ingrese valores numéricos válidos en los campos correspondientes.",
							"Error de Entrada", JOptionPane.ERROR_MESSAGE);
				}
				
					break;
				
				case("Item"):
					Item cartaI = (Item) carta;
				
				try {
					cartaI.setBonificacion(Integer.parseInt(bonificacion2.getText()));
					ventana2.dispose();	
					
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(ventana,
							"Por favor, ingrese valores numéricos válidos en los campos correspondientes.",
							"Error de Entrada", JOptionPane.ERROR_MESSAGE);
				}
					break;
				
				case("Supporter"):
					Supporter cartaS = (Supporter) carta;
				
				try {
					cartaS.setEfectoTurno(Integer.parseInt(efectoT2.getText()));
					ventana2.dispose();	
					
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(ventana,
							"Por favor, ingrese valores numéricos válidos en los campos correspondientes.",
							"Error de Entrada", JOptionPane.ERROR_MESSAGE);
				}
					break;
				
				case("Energy"):
					Energy cartaE = (Energy) carta;
					cartaE.setElemento(elemento2.getText());
					break;
				
				}
			});
			
			
			panel.add(scroll);
			panel.add(texto);
			principal.add(panel, BorderLayout.CENTER);
			principal.add(panelCr, BorderLayout.SOUTH);
			ventana2.add(principal);
			ventana2.setSize(600, 500);
			ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventana2.setLocationRelativeTo(ventana);
			ventana2.setVisible(true);
			
		});
	}

}
