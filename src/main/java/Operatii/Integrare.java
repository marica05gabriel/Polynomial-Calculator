package Operatii;

import Model.Monom;
import Model.Polinom;

import java.util.Iterator;
import java.util.Set;

public class Integrare implements Operatie {
    private static Integrare ourInstance = new Integrare();
    private Polinom rezultat=null;


    public static Integrare getInstance() {
        return ourInstance;
    }

    private Integrare() {
    }

    public Polinom calculeaza(Polinom... P) {
        rezultat = new Polinom();
        if(P[0] == null ) {
            System.out.println("Introduceti polinomul!");
            return null;
        } else {
            Set<Integer> keys = P[0].getPolinom().keySet();
            Iterator<Integer> itr = keys.iterator();

            while(itr.hasNext()) {
                Integer iterator = itr.next();
                float coef = P[0].getPolinom().get(iterator).getCoeficient();
                int exp = P[0].getPolinom().get(iterator).getExponent();

                System.out.println("ASD "+coef+" EFG "+exp);

                exp = exp + 1;
                coef = coef * (1.0f/exp);

                System.out.println("rezultat "+coef+"  "+exp);
                Monom monom = Monom.creareMonom(coef,exp);
                rezultat.addMonom(monom);
            }
        }
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
