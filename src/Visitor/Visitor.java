package Visitor;
import Dominio.*;

public interface Visitor {
	
	int visit(Pokemon x);
	int visit(Item x);
	int visit(Supporter x);
	int visit(Energy x);
}
