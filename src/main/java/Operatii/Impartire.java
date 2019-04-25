package Operatii;

import Model.Monom;
import Model.Polinom;

import java.util.ArrayList;
import java.util.Hashtable;

public class Impartire implements Operatie{
    private static Impartire ourInstance = new Impartire();
    private String cat = null;
    private String rest = null;
    private String rezultat = "";

    public static Impartire getInstance() {
        return ourInstance;
    }

    private Impartire() {
    }

    public Polinom calculeaza(Polinom... P) {
        if(P[0]==null || P[1]==null) {
            System.out.println("Introduceti polinoamele!");
            rezultat="Introduceti polinoamele!";
            return null;
        } else {
            if(P[0].getPolinom().get( P[0].getMaxRank() ).getExponent() == 0 ){
                rezultat = "Cat: 0      Rest: "+P[0].afiseazaPolinom();
            } else {
                System.out.println("Se calculeaza impartirea polinoamelor:");
                P[0].afiseazaPolinom();
                P[1].afiseazaPolinom();

                ArrayList<Monom> deimpartit = transformaInLista(P[0]);
                ArrayList<Monom> impartitor = transformaInLista(P[1]);
                ArrayList<Monom> q = new ArrayList<Monom>();
                ArrayList<Monom> r = new ArrayList<Monom>();

                rCloneDeimpartit(P[0] ,  r );

                int gradR = r.get(0).getExponent();
                int gradImpartitor = impartitor.get(0).getExponent();

                impartire_aux(gradR, gradImpartitor, r, impartitor, q);
            }
        }
        return  null;
    }

    private ArrayList<Monom> transformaInLista(Polinom polinom) {
        ArrayList<Monom> rezultat = new ArrayList<Monom>();
        for(int i=polinom.getMaxRank(); i>=0; i--) {
            if(polinom.getPolinom().get(i)!=null) {
                try {
                    Monom monom = polinom.getPolinom().get(i).clone();
                    rezultat.add(monom);

                } catch (CloneNotSupportedException e) {
                    System.out.println("Nu se accepta conversia");
                }
            }
        }
        return rezultat;
    }

    private Polinom arrayListtoPolinom(ArrayList<Monom> arr) {
        int size = arr.size();
        Polinom polinom = new Polinom();
        for(int i=0; i < size; i++) {
            Monom monom = Monom.creareMonom(arr.get(i).getCoeficient(), arr.get(i).getExponent());
            polinom.addMonom(monom);
        }
        return polinom;
    }

    private void rCloneDeimpartit(Polinom P , ArrayList<Monom> r ) {
        for(int i=P.getMaxRank(); i>=0; i--) {
            float coef = 0;
            int exponent = 0;
            if(P.getPolinom().get(i) != null) {
                coef = P.getPolinom().get(i).getCoeficient();
                exponent = P.getPolinom().get(i).getExponent();

                Monom monom = Monom.creareMonom(coef,exponent);
                if(monom != null) {
                    r.add(monom);
                }
            }
        }
    }

    private void impartire_aux(int gradR, int gradImpartitor,ArrayList<Monom> r, ArrayList<Monom> impartitor, ArrayList<Monom> q ){
        while( gradR >= gradImpartitor && gradR !=0) {
            float coefMonom = r.get(0).getCoeficient() / impartitor.get(0).getCoeficient();
            int expMonom = r.get(0).getExponent() - impartitor.get(0).getExponent();
            Monom monom = Monom.creareMonom(coefMonom, expMonom);

            Inmultire inmultire = Inmultire.getInstance();

            Polinom aux1 = new Polinom();
            Polinom aux2 = new Polinom();
            Polinom aux3 = new Polinom();
            aux1.addMonom(monom);
            aux2.addMonom(impartitor.get(0));
            aux3.addMonom(r.get(0));

            Polinom aux = new Polinom();
            aux = inmultire.calculeaza(aux1,arrayListtoPolinom(impartitor));

            q.add(monom);
            Scadere scadere = Scadere.getInstance();
            r = transformaInLista(scadere.calculeaza(arrayListtoPolinom(r) ,aux));

            if(r.size()>0) {
                while (r.get(0).getCoeficient() == 0) {
                    r.remove(0);
                }
                gradR = r.get(0).getExponent();
            } else {
                gradR = 0;
            }
        }
        cat = arrayListtoPolinom(q).afiseazaPolinom();
        rest = arrayListtoPolinom(r).afiseazaPolinom();
        if(rest == "") {
            rest = "0";
        }
        if(cat=="") {
            cat = "0";
        }
        rezultat = "CAT: "+cat+"      REST: "+rest;
        System.out.println("Rezultat:");
        System.out.println(rezultat);
    }


    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }
}
