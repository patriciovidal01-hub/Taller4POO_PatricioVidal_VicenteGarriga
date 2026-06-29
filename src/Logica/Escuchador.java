package Logica;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import Dominio.Carta;
import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

public class Escuchador extends MouseAdapter {

	JTable tabla;
	List<Carta> cartas;
	JFrame ventana;

	public Escuchador(JTable tabla, List<Carta> cartas, JFrame ventana) {
		this.tabla = tabla;
		this.cartas = cartas;
		this.ventana = ventana;
	}

	public void mouseClicked(MouseEvent e) {
		JDialog ventana = new JDialog(this.ventana, "Carta", true);
		ventana.setLayout(new BorderLayout());
		JPanel panelImagen = new JPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		int fila = tabla.getSelectedRow();
		JLabel marco = new JLabel();
//		marco.setBounds(0, 0, 500, 698);
		
		File arch = new File("imagenes/" + cartas.get(fila).getNombre() + ".png");
		
		if (fila >= 0) {
			if(arch.exists()) {
			ImageIcon imagen = new ImageIcon("imagenes/" + cartas.get(fila).getNombre() + ".png");
			marco.setIcon(imagen);
			
			} else {
			ImageIcon predeterminado = new ImageIcon("imagenes/predeterminado.png");
			marco.setIcon(predeterminado);
			}
			
			panelImagen.add(marco);
		}
		panel.add(new JLabel("Nombre"));
		panel.add(new JLabel(cartas.get(fila).getNombre()));
		panel.add(new JLabel("Rareza"));
		panel.add(new JLabel(String.valueOf(cartas.get(fila).getRareza())));

		if (cartas.get(fila) instanceof Pokemon) {
			Pokemon p = (Pokemon) cartas.get(fila);
			panel.add(new JLabel("Daño"));
			panel.add(new JLabel(String.valueOf(p.getDaño())));
			panel.add(new JLabel("Cantidad Energias"));
			panel.add(new JLabel(String.valueOf(p.getCantEnergia())));
		} else if (cartas.get(fila) instanceof Item) {
			Item i = (Item) cartas.get(fila);
			panel.add(new JLabel("Bonificación"));
			panel.add(new JLabel(String.valueOf(i.getBonificacion())));
		} else if(cartas.get(fila) instanceof Supporter) {
			Supporter s = (Supporter) cartas.get(fila);
			panel.add(new JLabel("Efecto por turno"));
			panel.add(new JLabel(String.valueOf(s.getEfectoTurno())));
		} else if(cartas.get(fila) instanceof Energy) {
			Energy en = (Energy) cartas.get(fila);
			panel.add(new JLabel("Elemento"));
			panel.add(new JLabel(en.getElemento()));
		}

		ventana.add(panelImagen, BorderLayout.WEST);
		ventana.add(panel, BorderLayout.CENTER);
		ventana.setSize(1200, 1040);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(this.ventana);
		ventana.setVisible(true);

	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

}
