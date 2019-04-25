package Operatii;

import Model.Monom;
import Model.Polinom;

public class Scadere implements  Operatie{
    private static Scadere ourInstance = new Scadere();
    private Polinom rezultat=null;

    public static Scadere getInstance() {
        return ourInstance;
    }

    private Scadere() {
    }

    public Polinom calculeaza(Polinom... P) {
        if(P[0] == null && P[1]== null) {
            System.out.println("Introduceti polinoamele!");
            return null;
        } else {
            System.out.println("\nSe calculeaza diferenta polinoamelor:");
            rezultat = new Polinom();

            if(P[0]==null || P[1] ==null) {
                if(P[0] != null) {
                    P[0].afiseazaPolinom();
                    rezultat = P[0];
                }
                if(P[1] != null) {
                    P[1].afiseazaPolinom();
                    try {
                        rezultat = P[1].clone();
                    }catch( CloneNotSupportedException e) {
                        System.out.println("Nu s-a putut clona.");
                    }
                    rezultat.inverseaza();
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

                    coef = coeficientP0 - coeficientP1;

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
