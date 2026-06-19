package Logica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
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

		escucharOpcion(orden, tabla);
		
		PoderVisitor v = new PoderVisitor();
		
		for (int i = 0; i < cartas.size(); i++) {
			Carta c = cartas.get(i);
			int poder = c.accept(v);
			Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder};
			tabla.addRow(caracteristicas);
		}

		tablaDatos.setDefaultEditor(Object.class, null);
		JScrollPane scroll = new JScrollPane(tablaDatos);
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

	public void escucharOpcion(JComboBox<String> opcion, DefaultTableModel tabla) {
		List<Carta> cartas = SistemaImp.getInstance().getCartas();
		PoderVisitor v = new PoderVisitor();
		
		opcion.addActionListener(e -> {

			switch (opcion.getSelectedIndex()) {

			case (0):
				tabla.setRowCount(0);
				List<Carta> cartas2 = SistemaImp.getInstance().Strategy1(cartas);
				for (int i = 0; i < cartas2.size(); i++) {
					Carta c = cartas2.get(i);
					int poder = c.accept(v);
					Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder };
					tabla.addRow(caracteristicas);
				}
				break;

			case (1):
				tabla.setRowCount(0);
				List<Carta> cartas3 = SistemaImp.getInstance().Strategy2(cartas);
				for (int i = 0; i < cartas3.size(); i++) {
					Carta c = cartas3.get(i);
					int poder = c.accept(v);
					Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder };
					tabla.addRow(caracteristicas);
				}
				break;

			case (2):
				tabla.setRowCount(0);
				List<Carta> cartas4 = SistemaImp.getInstance().Strategy3(cartas);
				for (int i = 0; i < cartas4.size(); i++) {
					Carta c = cartas4.get(i);
					int poder = c.accept(v);
					Object[] caracteristicas = { c.getNombre(), c.getRareza(), poder };
					tabla.addRow(caracteristicas);
				}
				break;
			}

		});
	}

	public void eventoAgregar(JButton b) {
		b.addActionListener(e -> {

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
