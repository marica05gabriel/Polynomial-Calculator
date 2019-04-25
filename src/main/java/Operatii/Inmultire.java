package Operatii;

import Model.Monom;
import Model.Polinom;

import java.util.Iterator;
import java.util.Set;

public class Inmultire implements Operatie{
    private static Inmultire ourInstance = new Inmultire();
    private Polinom rezultat=null;

    public static Inmultire getInstance() {
        return ourInstance;
    }

    private Inmultire() {
    }

    public Polinom calculeaza(Polinom... P) {
        if(P[0] == null || P[1]== null) {
            System.out.println("Introduceti polinoamele!");
            return null;
        } else {
            System.out.println("Se calculeaza produsul polinoamelor:");
            P[0].afiseazaPolinom();
            P[1].afiseazaPolinom();

            Set<Integer> keys0 = P[0].getPolinom().keySet();
            Iterator<Integer> itr0 = keys0.iterator();

            Set<Integer> keys1 = P[1].getPolinom().keySet();
            Iterator<Integer> itr1 ;

            Polinom rezultat = new Polinom();
            while(itr0.hasNext()) {
                Integer iterator0 = itr0.next();
                itr1 = keys1.iterator();

                float coef0 = P[0].getPolinom().get(iterator0).getCoeficient();
                int exp0 = P[0].getPolinom().get(iterator0).getExponent();

                System.out.println("ITR0:"+coef0+" "+exp0);
                while(itr1.hasNext()) {
                    Integer iterator1 = itr1.next();
                    float coef1 = P[1].getPolinom().get(iterator1).getCoeficient();
                    int exp1 = P[1].getPolinom().get(iterator1).getExponent();
                    System.out.println("ITR1:"+ coef1 + " "+exp1);

                    Monom monom = Monom.creareMonom(coef0*coef1, exp0+exp1);
                    rezultat.addMonom(monom);
                }

            }
            rezultat.afiseazaPolinom();
            return rezultat;
        }
    }

    public Polinom getRezultat() {
        return rezultat;
    }

    public void setRezultat(Polinom rezultat) {
        this.rezultat = rezultat;
    }
}
