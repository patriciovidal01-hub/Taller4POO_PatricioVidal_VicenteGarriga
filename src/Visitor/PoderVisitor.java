package Visitor;

import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

public class PoderVisitor implements Visitor {


	public int visit(Pokemon x) {
		int poder = (x.getDaño()/x.getCantEnergia())*100;
		return poder;
		
	}

	
	public int visit(Item x) {
		int poder = x.getBonificacion()*20;
		return poder;
		
	}


	public int visit(Supporter x) {
		
		int poder = x.getEfectoTurno()*50;
		return poder;
		
	}

	
	public int visit(Energy x) {
		int poder = 1;
		return poder;
	}

}
