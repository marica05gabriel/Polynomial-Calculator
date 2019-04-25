package Testare;
import Model.Monom;
import Model.Polinom;
import Operatii.*;
import Parsare.Expresie;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class Teste {

    @Test
    public void test_parsare_afirmativ_1() {
        String string_test = "-3x^2+5x-25+24";
        Expresie expresie = Expresie.getInstance();
        Polinom polinomDeTestat = expresie.getPolinom(string_test);

        Monom monom1 = Monom.creareMonom(-3,2);
        Monom monom2 = Monom.creareMonom(5,1);
        Monom monom3 = Monom.creareMonom(-1,0);

        Polinom polinom = new Polinom();
        polinom.addMonom(monom1);
        polinom.addMonom(monom2);
        polinom.addMonom(monom3);

        boolean test1 = polinomDeTestat.equals(polinom);

        assertTrue(test1);
    }

    @Test
    public void test_parsare_afirmativ_2() {
        String string_test = "-3x2+5*x-5x";
        Expresie expresie = Expresie.getInstance();
        Polinom polinomDeTestat = expresie.getPolinom(string_test);

        Monom monom1 = Monom.creareMonom(-3,2);
        Polinom polinom = new Polinom();
        polinom.addMonom(monom1);

        boolean test1 = polinomDeTestat.equals(polinom);

        assertTrue(test1);
    }

    @Test
    public void test_parsare_negativ_1() {
        String string_test = "-x2";
        Expresie expresie = Expresie.getInstance();
        Polinom polinomDeTestat = expresie.getPolinom(string_test);

        Monom monom1 = Monom.creareMonom(1,2);
        Polinom polinom = new Polinom();
        polinom.addMonom(monom1);

        boolean test1 = polinomDeTestat.equals(polinom);

        assertFalse(test1);
    }

    @Test
    public void test_parsare_negativ_2() {
        String string_test = "2";
        Expresie expresie = Expresie.getInstance();
        Polinom polinomDeTestat = expresie.getPolinom(string_test);

        Monom monom1 = Monom.creareMonom(1,0);
        Polinom polinom = new Polinom();
        polinom.addMonom(monom1);

        boolean test1 = polinomDeTestat.equals(polinom);

        assertFalse(test1);
    }

    @Test
    public void test_adunare_afirmativ() {
        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("3x^2 - 5x^3 + 2");
        Polinom polinom2 = expresie.getPolinom("2x^2  - 2 + x");

        Polinom rezultat = expresie.getPolinom("-5x^3 +5x^2 +x");

        Adunare adunare = Adunare.getInstance();
        Polinom polinomDeTestat = adunare.calculeaza(polinom1,polinom2);

        assertTrue( polinomDeTestat.equals( rezultat) );
    }

    @Test
    public void test_adunare_negativ() {
        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("3x^2 - 5x^3 + 2");
        Polinom polinom2 = expresie.getPolinom("2x^2  - 2 + x");

        Polinom rezultat = expresie.getPolinom("0");

        Adunare adunare = Adunare.getInstance();
        Polinom polinomDeTestat = adunare.calculeaza(polinom1,polinom2);

        assertFalse( polinomDeTestat.equals( rezultat) );
    }

    @Test
    public void test_scadere_afirmativ() {
        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("3x^2 - 5x^3 + 2");
        Polinom polinom2 = expresie.getPolinom("2x^2  - 2 + x");

        Polinom rezultat = expresie.getPolinom("-5x3 +x^2 -x + 4");

        Scadere scadere = Scadere.getInstance();
        Polinom polinomDeTestat = scadere.calculeaza(polinom1,polinom2);

        assertTrue( polinomDeTestat.equals( rezultat) );
    }

    @Test
    public void test_scadere_negativ() {

        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("3x^2 - 5x^3 + 2");
        Polinom polinom2 = expresie.getPolinom("2x^2  - 2 + x");

        Polinom rezultat = expresie.getPolinom("5x3 +x^2 -x ");

        Scadere scadere = Scadere.getInstance();
        Polinom polinomDeTestat = scadere.calculeaza(polinom1,polinom2);

        assertFalse( polinomDeTestat.equals( rezultat) );
    }

    @Test
    public void test_inmultire_afirmativ() {
        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("X^2-1");
        Polinom polinom2 = expresie.getPolinom("x^2+1");

        Polinom rezultat = expresie.getPolinom("X^4-1");

        Inmultire inmultire = Inmultire.getInstance();
        Polinom polinomDeTestat = inmultire.calculeaza(polinom1,polinom2);

        assertTrue( polinomDeTestat.equals( rezultat) );
    }

    @Test
    public void test_inmultire_negativ() {
        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("X^2-1");
        Polinom polinom2 = expresie.getPolinom("x^2+1");

        Polinom rezultat = expresie.getPolinom("X^2-1");

        Inmultire inmultire = Inmultire.getInstance();
        Polinom polinomDeTestat = inmultire.calculeaza(polinom1,polinom2);

        assertFalse( polinomDeTestat.equals( rezultat) );
    }

    @Test
    public void test_impartire_afirmativ() {
        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("x^3 +5x^2 -3^x +1");
        Polinom polinom2 = expresie.getPolinom("x-2");

        Polinom cat = expresie.getPolinom("X^2 +7x +11");
        Polinom rest = expresie.getPolinom("23");

        Impartire impartire = Impartire.getInstance();
        impartire.calculeaza(polinom1,polinom2);

        Polinom catDeTestat = expresie.getPolinom(impartire.getCat());
        Polinom restDeTestat = expresie.getPolinom(impartire.getRest());

        assertTrue( catDeTestat.equals( cat) );
        assertTrue( restDeTestat.equals( rest) );
    }

    @Test
    public void test_impartire_negativ() {
        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("x^3 +5x^2 -3^x +1");
        Polinom polinom2 = expresie.getPolinom("x-2");

        Polinom cat = expresie.getPolinom("+7x +11");
        Polinom rest = expresie.getPolinom("21");

        Impartire impartire = Impartire.getInstance();
        impartire.calculeaza(polinom1,polinom2);

        Polinom catDeTestat = expresie.getPolinom(impartire.getCat());
        Polinom restDeTestat = expresie.getPolinom(impartire.getRest());

        assertFalse( catDeTestat.equals( cat) );
        assertFalse( restDeTestat.equals( rest) );
    }

    @Test
    public void test_integrare_afirmativ() {
        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("3X^2-1");

        Polinom rezultat = expresie.getPolinom("X^3 -x");

        Integrare integrare= Integrare.getInstance();
        Polinom polinomDeTestat = integrare.calculeaza(polinom1);

        assertTrue( polinomDeTestat.equals( rezultat) );
    }

    @Test
    public void test_integrare_negativ() {
        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("3X^2-1");

        Polinom rezultat = expresie.getPolinom("X -1");

        Integrare integrare= Integrare.getInstance();
        Polinom polinomDeTestat = integrare.calculeaza(polinom1);

        assertFalse( polinomDeTestat.equals( rezultat) );
    }

    @Test
    public void test_derivare_afirmativ() {
        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("3X^2-1");

        Polinom rezultat = expresie.getPolinom("6X^1 ");

        Derivare derivare= Derivare.getInstance();
        Polinom polinomDeTestat = derivare.calculeaza(polinom1);

        assertTrue( polinomDeTestat.equals( rezultat) );
    }

    @Test
    public void test_derivare_negativ() {

        Expresie expresie = Expresie.getInstance();
        Polinom polinom1 = expresie.getPolinom("3X^2-1");

        Polinom rezultat = expresie.getPolinom("X^1 ");

        Derivare derivare= Derivare.getInstance();
        Polinom polinomDeTestat = derivare.calculeaza(polinom1);

        assertFalse( polinomDeTestat.equals( rezultat) );
    }
}
