package Model;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Polinom implements Cloneable  {
    private Hashtable<Integer, Monom> polinom;
    private int maxRank;

    public Polinom() {
        polinom = new Hashtable<Integer, Monom>();
        setMaxRank(0);
    }

    public int getMaxRank() {
        return maxRank;
    }

    public void setMaxRank(int maxRank) {
        this.maxRank = maxRank;
    }

    public void addMonom(Monom monom) {
        if (monom == null) {
           // System.out.println("monom null"); //nu il adaug, il ignor
        } else {
            int exponent = monom.getExponent();
            if(polinom.get(exponent)!=null) {
                if( polinom.get(exponent).getCoeficient() + monom.getCoeficient() == 0) {
                    polinom.remove(exponent);
                } else {

                    if (exponent > getMaxRank() ) {
                        setMaxRank(exponent);
                    }

                    float coeficientPolinom = polinom.get(exponent).getCoeficient();
                    polinom.get(exponent).setCoeficient(coeficientPolinom + monom.getCoeficient());
                }
            } else {
                polinom.put( exponent , monom );
                if(exponent>maxRank) {
                    setMaxRank(exponent);
                }
            }
        }
    }

    public void removeMonom(int key) {
        polinom.remove(key);
        maxRank = cautaRankMax();
    }

    public String afiseazaPolinom() {
        String rez = "";
        if (polinom!=null) {
            try {
                for(int i=maxRank; i>=0; i-=1) {
                    if(polinom.get(i) != null) {
                        rez+=polinom.get(i).afiseazaMonom();
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("Polinomul este null!");
                rez="Polinomul este null!";
            }
        }
        System.out.println();
        return rez;
    }

    private int cautaRankMax(){
        for( int i=maxRank; i>=0; i++) {
            if( polinom.get(i) != null)
                maxRank = i;
                return i;
        }
        return 0;
    }

    // Inmultesc un polinom cu -1;
    public void inverseaza() {
        if (this != null) {
            for(int  i =maxRank; i>=0;i--) {
                if(polinom.get(i) != null) {
                    polinom.get(i).setCoeficient( -polinom.get(i).getCoeficient());
                }
            }
        }
    }

    public Polinom clone() throws CloneNotSupportedException {
        Polinom student = new Polinom();

        Set<Integer> keys = polinom.keySet();
        Iterator<Integer> itr = keys.iterator();

        while (itr.hasNext()) {
            student.addMonom(polinom.get(itr.next()).clone());
        }
        return student;
    }

    public Hashtable<Integer, Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(Hashtable<Integer, Monom> polinom) {
        this.polinom = polinom;
    }

    public boolean equals(Polinom polinom) {
        int max = (maxRank>polinom.getMaxRank())?maxRank:polinom.getMaxRank();
        for(int i=max; i>=0;i--) {
            if(polinom.getPolinom().get(i)!=null) {
                if(this.getPolinom().get(i) != null) {
                    if (polinom.getPolinom().get(i).equals(this.getPolinom().get(i))==false)
                    {
                        return  false;
                    }
                } else {
                    return false;
                }
            } else {
                if(getPolinom().get(i) != null) {
                    return false;
                }
            }
        }
        return  true;
    }
}
