package Strategy;

import java.util.List;
import Dominio.*;

public interface Strategy {

	List<Carta> ordenar(List<Carta> cartas);
}
