package figures;

import echecs.Case;
import echecs.Echiquier;

public class Tour extends Figure {
	public Tour(Couleur couleur, Case position) 
	{
		super(couleur, position);
	}
	
	@Override
	public boolean potentiel(Case dest, Echiquier echiquier) 
	{	
		Case relatif = getCase().relatif(dest);
		Case delta = Case.abs(relatif);
		
		if (relatif.getColonne() != 0 && relatif.getLigne() != 0)
			return false;
		
		int dx = delta.getColonne() != 0 ? (relatif.getColonne() > 0 ? -1 : 1) : 0;
		int dy = delta.getLigne() != 0 ? (relatif.getLigne() > 0 ? -1 : 1) : 0;
		
		for (int i = 1; i < delta.getColonne() + delta.getLigne(); ++i)
			if (echiquier.occupant(new Case(getCase().getColonne() + i * dx, getCase().getLigne() + i * dy)) != null)
				return false;
			
		return true;
	}
	
	@Override
	public boolean peutEtreRoque()
	{
		return !aBoug�();
	}
	
	@Override
	public char getSymbole()
	{
		return 't';
	}
}
