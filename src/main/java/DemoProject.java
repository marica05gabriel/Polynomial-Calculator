import Model.Monom;
import Model.Polinom;
import Operatii.Adunare;
import Operatii.Inmultire;
import Operatii.Scadere;
import Parsare.Expresie;
import UserInterface.Controller;
import UserInterface.Model;
import UserInterface.View;


public class DemoProject {
    public static void main(String[] args) {
        Expresie expresie = Expresie.getInstance();
        Polinom polinomTestParsare = expresie.getPolinom("2.0x-1x5-2*^+1+2.0X^2-2.1X+X^3-3x +2*x^1 +5.3x^3");
        polinomTestParsare.afiseazaPolinom();

        Polinom polinomTestParsare2 = expresie.getPolinom(" +1");
        System.out.println("DELIMITARE 1");
        Polinom polinomTestAdd = expresie.getPolinom("1+x+x3+x2+0");
        System.out.println("DELIMITARE 2");
        Polinom polinomTestAdd2= expresie.getPolinom("-2x-x3-1");

        polinomTestAdd.afiseazaPolinom();
        polinomTestAdd2.afiseazaPolinom();

        Adunare adunare = Adunare.getInstance();
        adunare.calculeaza(polinomTestAdd,polinomTestAdd2).afiseazaPolinom();

        Scadere scadere = Scadere.getInstance();
        scadere.calculeaza(polinomTestAdd, polinomTestAdd2);

        try {
            Monom testClone = Monom.creareMonom(5,5);
            Polinom testClone1 = new Polinom();
            Polinom testClone2 = new Polinom();
            Monom testClone3 = testClone.clone();
            testClone1.addMonom(testClone);
            testClone2 = testClone1.clone();

            System.out.println(testClone1.equals(testClone2));

            testClone2.getPolinom().get(5).setCoeficient(4);
            System.out.println(testClone1.equals(testClone2));
;

            testClone1.afiseazaPolinom();
            testClone2.afiseazaPolinom();


            Inmultire inmultire = Inmultire.getInstance();
            inmultire.calculeaza(polinomTestAdd,polinomTestAdd2);

        } catch (CloneNotSupportedException e) {
            System.out.println("Nu se poate clona");
        }
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model,view);

    }
}



