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

import Dominio.*;
/**
 * Clase encargada de escuchar el mouse del Usuario y ejecutar ciertas acciones.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class Escuchador extends MouseAdapter {
	
	/**
	 * Tabla.
	 */
	private JTable tabla;
	
	/**
	 * Lista de cartas.
	 */
	private List<Carta> cartas;
	
	/**
	 * Ventana principal que se utiliza.
	 */
	private JFrame ventana;
	
	
	/**
	 * Inicializa el Escuchador con sus atributos respectivos.
	 * @param tabla Tabla donde se escucha el mouse.
	 * @param cartas Lista de cartas relacionada a la tabla.
	 * @param ventana Ventana principal que se ocupa.
	 */
	public Escuchador(JTable tabla, List<Carta> cartas, JFrame ventana) {
		this.tabla = tabla;
		this.cartas = cartas;
		this.ventana = ventana;
	}
	
	
	/**
	 * Crea una ventana adicional que muestra información relacionada y un png de la carta clickeada en la tabla .	
	 * @param e Un evento de la tabla.
	 */
	public void mouseClicked(MouseEvent e) {
		JDialog dialog = new JDialog(this.ventana, "Carta", true);
		dialog.setLayout(new BorderLayout());
		JPanel panelImagen = new JPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		int fila = tabla.getSelectedRow();
		JLabel marco = new JLabel();
			
		if (fila >= 0) {
			File arch = new File("imagenes/" + cartas.get(fila).getNombre() + ".png");
			if(arch.exists()) {
			ImageIcon imagen = new ImageIcon("imagenes/" + cartas.get(fila).getNombre() + ".png");
			marco.setIcon(imagen);
			
			} else {
			ImageIcon predeterminado = new ImageIcon("imagenes/predeterminado.png");
			marco.setIcon(predeterminado);
			}
			
			panelImagen.add(marco);
		} else {
			return ;
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

		dialog.add(panelImagen, BorderLayout.WEST);
		dialog.add(panel, BorderLayout.CENTER);
		dialog.setSize(1200, 1040);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(this.ventana);
		dialog.setVisible(true);

	}
	
	/**
	 * Modifica la lista de cartas actual de la carta por una nueva lista de cartas.
	 * 
	 * @param cartas Nueva lista de cartas.
	 */
	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

}
