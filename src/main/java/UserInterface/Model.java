package UserInterface;


import Operatii.*;
import Model.Polinom;
import Parsare.Expresie;

public class Model {
    String rezultat;

    public Model() {
        reset();
    }

    public void reset(){
        rezultat="";
    }

    public String getRezultat() {
        return rezultat;
    }

    public void sum(String polinom1,String polinom2) {
        Expresie expresie = Expresie.getInstance();
        Polinom p1=expresie.getPolinom(polinom1);
        Polinom p2=expresie.getPolinom(polinom2);

        Adunare adunare=Adunare.getInstance();

        Polinom p3 = adunare.calculeaza(p1,p2);
        if (p3!=null) {
            if (p3.afiseazaPolinom() == "") {
                rezultat = "0";
            } else {
                rezultat = p3.afiseazaPolinom();
            }
        } else {
            rezultat = "Nu s-a putut face adunarea.";
        }


    }

    public void sub(String polinom1,String polinom2) {
        Expresie expresie = Expresie.getInstance();
        Polinom p1=expresie.getPolinom(polinom1);
        Polinom p2=expresie.getPolinom(polinom2);

        Scadere scadere=Scadere.getInstance();

        Polinom p3 = scadere.calculeaza(p1,p2);
        if (p3!=null) {
            if (p3.afiseazaPolinom() == "") {
                rezultat = "0";
            } else {
                rezultat = p3.afiseazaPolinom();
            }
        } else {
            rezultat = "Nu s-a putut face scaderea.";
        }
    }

    public void mul(String polinom1,String polinom2) {
        Expresie expresie = Expresie.getInstance();
        Polinom p1=expresie.getPolinom(polinom1);
        Polinom p2=expresie.getPolinom(polinom2);

        Inmultire inmultire=Inmultire.getInstance();

        Polinom p3 = inmultire.calculeaza(p1,p2);
        if (p3!=null) {
            if (p3.afiseazaPolinom() == "") {
                rezultat = "0";
            } else {
                rezultat = p3.afiseazaPolinom();
            }
        } else {
            rezultat = "Nu s-a putut face inmultirea.";
        }

    }

    public void div(String polinom1,String polinom2) {
        Expresie expresie = Expresie.getInstance();
        Polinom p1=expresie.getPolinom(polinom1);
        Polinom p2=expresie.getPolinom(polinom2);

        Impartire impartire=Impartire.getInstance();

        impartire.calculeaza(p1,p2);
        /*if (p3!=null) {
            if (p3.afiseazaPolinom() == "") {
                rezultat = "0";
            } else {
                rezultat = p3.afiseazaPolinom();
            }
        } else {
            rezultat = impartire.getRezultat();
        }*/
        rezultat = impartire.getRezultat();
    }

    public void derivare(String polinom1) {
        Expresie expresie = Expresie.getInstance();
        Polinom p1=expresie.getPolinom(polinom1);


        Derivare derivare=Derivare.getInstance();
        Polinom p2 = derivare.calculeaza(p1);

        if (p2!=null) {
            if (p2.afiseazaPolinom() == "") {
                rezultat = "0";
            } else {
                rezultat = p2.afiseazaPolinom();
            }
        } else {
            rezultat = "Nu s-a putut face derivarea.";
        }
    }

    public void integrare(String polinom1) {
        Expresie expresie = Expresie.getInstance();
        Polinom p1=expresie.getPolinom(polinom1);


        Integrare integrare=Integrare.getInstance();

        Polinom p2 = integrare.calculeaza(p1);
        if (p2!=null) {
            if (p2.afiseazaPolinom() == "") {
                rezultat = "0";
            } else {
                rezultat = p2.afiseazaPolinom();
            }
        } else {
            rezultat = "Nu s-a putut face integrarea.";
        }
    }

}
