package Operatii;

import Model.Monom;
import Model.Polinom;

public class Adunare implements Operatie{
    private static Adunare ourInstance = new Adunare();
    private Polinom rezultat=null;

    public static Adunare getInstance() {
        return ourInstance;
    }


    private Adunare() { }

    public Polinom calculeaza(Polinom... P) {
        if(P[0] == null && P[1]== null) {
            System.out.println("Introduceti polinoamele!");
            return null;
        } else {
            System.out.println("\nSe calculeaza suma polinoamelor:");
            rezultat = new Polinom();

            if(P[0]==null || P[1] ==null) {
                if(P[0] != null) {
                    P[0].afiseazaPolinom();
                    rezultat = P[0];
                }
                if(P[1] != null) {
                    P[1].afiseazaPolinom();
                    rezultat = P[1];
                }
            } else {
                 P[0].afiseazaPolinom();
                 P[1].afiseazaPolinom();

                int rankMax = (P[0].getMaxRank()>P[1].getMaxRank())?P[0].getMaxRank():P[1].getMaxRank();
                float coeficientP0 = 0, coeficientP1 = 0, coef=0;

                for(int i= rankMax; i>=0; i--) {
                    coeficientP0 = 0;
                    coeficientP1 = 0;

                    if(P[0].getPolinom().get(i) != null) {
                        coeficientP0 = P[0].getPolinom().get(i).getCoeficient();
                    }

                    if(P[1].getPolinom().get(i) != null) {
                        coeficientP1 = P[1].getPolinom().get(i).getCoeficient();
                    }

                    coef = coeficientP0 + coeficientP1;

                    Monom monom = Monom.creareMonom(coef, i);
                    rezultat.addMonom(monom);
                }
            }

            System.out.println("Rezultat:");
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
