package test;

import echecs.Case;
import echecs.Echiquier;
import fabriques.Fabrique;
import figures.Tour;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Antoine <antoine@jiveoff.fr> on 25/05/2021
 * @project BPO-Chess
 */
public class TourTest {

    @Test
    public void creationTour() {
        Tour t1 = new Tour(true, 1, 1);
        assertTrue(t1.estBlanc());
        assertFalse(t1.peutEtrePromu());
        assertFalse(t1.peutEtreMat());
        assertTrue(t1.occupe(new Case(1,1)));
        assertTrue(t1.getCase().equals(new Case(1, 1)));
        assertFalse(t1.getCase().equals(new Case(2, 2)));
        assertFalse(t1.estInsuffisant());
        assertEquals(t1.getSymbole(), 't');

        Tour t2 = new Tour(false, 4, 3);
        assertFalse(t2.estBlanc());
    }

    @Test
    public void roque() {

        Fabrique f = new Fabrique();
        Tour t = new Tour(true, 1,1);
        f.ajouter(t);
        Echiquier e = new Echiquier(f);

        assertFalse(t.aBoug�());
        assertTrue(t.peutEtreRoque());

        try {
            e.jouer(new Case(1,1), new Case(1,0));
            assertTrue(true);
            assertTrue(t.aBoug�());
            assertFalse(t.peutEtreRoque());
        } catch (Exception exception) {
            fail();
        }
    }
    @Test
    public void mouvementTour() {
        Fabrique f = new Fabrique();

        Tour t = new Tour(true, 7,4);
        f.ajouter(t);

        Echiquier e = new Echiquier(f);

        try {
            e.jouer(new Case(7,4), new Case(3,1));
            fail();
        } catch(Exception exception) {
            assertTrue(true);
        }

        assertTrue(t.getCase().equals(new Case(7, 4)));

        try {
            e.jouer(new Case(7,4), new Case(7,0));
            assertTrue(true);
            assertTrue(t.aBoug�());
            assertTrue(t.occupe(new Case(7,0)));
        } catch (Exception exception) {
            fail();
        }

        try {
            e.jouer(new Case(7,0), new Case(2,0));
            assertTrue(true);
            assertTrue(t.occupe(new Case(2,0)));
        } catch (Exception exception) {
            fail();
        }
    }

}
