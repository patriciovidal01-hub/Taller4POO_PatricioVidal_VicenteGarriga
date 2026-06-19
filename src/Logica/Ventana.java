package Logica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Ventana {

	public static void crearVentana() {
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

		JTextArea texto = new JTextArea(5, 20);
		texto.setEditable(false);

		ordenar.add(texto, BorderLayout.CENTER);

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
