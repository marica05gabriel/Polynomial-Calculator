package Operatii;

import Model.Monom;
import Model.Polinom;

import java.util.Iterator;
import java.util.Set;

public class Derivare implements  Operatie{
    private static Derivare ourInstance = new Derivare();
    private Polinom rezultat=null;

    public static Derivare getInstance() {
        return ourInstance;
    }

    private Derivare() { }


    public Polinom calculeaza(Polinom... P) {
        rezultat = new Polinom();
        if(P[0] == null ) {
            System.out.println("Introduceti polinomul!");
            return null;
        } else {
            System.out.println("Operatia de derivarea polinomului:");
            P[0].afiseazaPolinom();

            Set<Integer> keys = P[0].getPolinom().keySet();
            Iterator<Integer> itr = keys.iterator();

            while(itr.hasNext()) {
                Integer iterator = itr.next();
                float coef = P[0].getPolinom().get(iterator).getCoeficient();
                int exp = P[0].getPolinom().get(iterator).getExponent();

                if(exp != 0) {
                    coef = coef * exp;
                    exp = exp - 1;
                } else {
                    coef = 0;
                    exp = 0;
                }

                Monom monom = Monom.creareMonom(coef,exp);

                if(monom!=null)
                rezultat.addMonom(monom);
            }
        }
        System.out.println("Rezultat: ");
        rezultat.afiseazaPolinom();
        return rezultat;
    }

    public Polinom getRezultat() {
        return rezultat;
    }

    public void setRezultat(Polinom rezultat) {
        this.rezultat = rezultat;
    }
}

