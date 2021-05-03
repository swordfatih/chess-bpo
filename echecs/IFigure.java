package echecs;

public interface IFigure {
	boolean potentiel(int colonne, int ligne, Echiquier echiquier);
	boolean occupe(int colonne, int ligne);
	void d�placer(int x, int y);
	void dessiner(char[][] t);
	boolean peutEtreMat();
	boolean estBlanc();
	int getColonne();
	int getLigne();
}
