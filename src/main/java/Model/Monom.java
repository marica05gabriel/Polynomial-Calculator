package Model;

public class Monom implements Cloneable {
    private int exponent;
    private float coeficient;

    private Monom(float coeficient, int exponent) {
        setExponent(exponent);
        setCoeficient(coeficient);
    }

    public static Monom creareMonom(float coeficient, int exponent) {
        if(coeficient != 0) {
            return new Monom(coeficient, exponent);
        }
        else {
            //System.out.println("Coeficientul monomului este 0!");
            return null;
        }
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public float getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }

    private boolean coef0() {
        if( coeficient == 0) {
            //System.out.println("Monomul este null. Coeficient 0!");
            return true;
        }
        return false;
    }

    private String coef1exp0(){
        String rez = "";
        if(exponent == 0) {
            if (coeficient == 1) {
                System.out.print(" +1");
                rez += " +1";
            } else {
                if( coeficient == -1) {
                    System.out.print(" -1");
                    rez += " -1";
                } else {
                    if (coeficient==(int)coeficient) {
                        if(coeficient>0) {
                            System.out.print(" +"+(int)coeficient);
                            rez+=" +"+(int)coeficient;
                        } else {
                            System.out.print(" "+(int)coeficient);
                            rez+=" "+(int)coeficient;
                        }
                    } else {
                        if(coeficient>0) {
                            System.out.print(" +"+coeficient);
                            rez+=" +"+coeficient;
                        } else {
                            System.out.print(" "+coeficient);
                            rez+=" "+coeficient;
                        }
                    }
                }
            }
        }
        return  rez;
    }

    private String coef1exp1() {
        String rez = "";
        if(exponent == 1) {
            if (coeficient == 1) {
                System.out.print(" +x");
                rez += " +x";
            } else {
                if( coeficient == -1) {
                    System.out.print(" -x");
                    rez += " -x";
                }
            }
        }
        return rez;
    }

    private String coef2exp1() {
        String rez="";
        if(exponent == 1) {
            if (coeficient != 1 && coeficient != -1) {
                if (coeficient > 0) {
                    if (coeficient == (int) coeficient) {
                        System.out.print(" +" + (int) coeficient+"x");
                        rez += " +" + (int) coeficient+"x";
                    } else {
                        System.out.print(" +" + coeficient+"x");
                        rez += " +" +  coeficient+"x";
                    }
                } else {
                    if (coeficient == (int) coeficient) {
                        System.out.print(" "+(int) coeficient+"x");
                        rez+=" "+(int) coeficient+"x";
                    } else {
                        System.out.print(" "+coeficient+"x");
                        rez+=" "+coeficient+"x";
                    }
                }
            }
        }
        return rez;
    }

    private String coef1exp2() {
        String rez = "";
        if(exponent != 1 && exponent!=0) {
            if(coeficient == (int)coeficient) {
                if(coeficient == 1) {
                    System.out.print(" +x^" + exponent);
                    rez +=" +x^" + exponent;
                } else {
                    if(coeficient == -1) {
                        System.out.print(" -x^"+exponent);
                        rez+=" -x^"+exponent;
                    } else {
                        if(coeficient > 0) {
                            System.out.print(" +"+(int)coeficient + "x^"+exponent);
                            rez+=" +"+(int)coeficient + "x^"+exponent;
                        } else {
                            System.out.print(" "+(int)coeficient + "x^"+exponent);
                            rez+=" "+(int)coeficient + "x^"+exponent;
                        }
                    }
                }
            } else {
                if(coeficient > 0) {
                    System.out.print(" +"+coeficient + "x^"+exponent);
                    rez+=" +"+coeficient + "x^"+exponent;
                } else {
                    System.out.print(" "+coeficient + "x^"+exponent);
                    rez+=" "+coeficient + "x^"+exponent;
                }
            }
        }
        return rez;
    }

    public String afiseazaMonom(){
        //System.out.println("Coeficient:"+coeficient +" Exponent:"+exponent);
        String rez="";

        coef0();
        rez+=coef1exp0();
        rez+=coef1exp1();
        rez+=coef1exp2();
        rez+=coef2exp1();
        return rez;
    }

    /*public Monom adunare(Monom monom) {
        float coef = 0;
        Monom rezultat=null;
        if(monom!=null) {
            coef = coeficient + monom.getCoeficient();
            rezultat = Monom.creareMonom(coef, exponent);
        } else {
            try {
                rezultat = this.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println("Nu suporta clonarea!");
            }
        }
        return rezultat;
    }

    public Monom scadere(Monom monom) {
        float coef = 0;
        coef = coeficient - monom.getCoeficient();
        Monom rezultat = Monom.creareMonom(coef, exponent);
        return rezultat;
    }

    public Monom inmultire(Monom monom) {
        float coef = 0;
        coef = coeficient * monom.getCoeficient();
        Monom rezultat = Monom.creareMonom(coef, exponent+ monom.getExponent());
        return rezultat;
    }


    public Monom integrare() {
        float coef = 0;
        coef = coeficient * (1 / (1+exponent) );
        Monom rezultat = Monom.creareMonom(coef, exponent+1);
        return rezultat;
    }

    public Monom derivare() {
        float coef = 0;
        coef = coeficient * exponent;
        Monom rezultat = Monom.creareMonom(coef, exponent-1);
        return rezultat;
    }*/

    public Monom clone() throws CloneNotSupportedException
    {
        Monom student = (Monom) super.clone();

        return student;
    }

    public boolean equals(Monom monom) {
        if(coeficient==monom.getCoeficient() && exponent==monom.getExponent())
            return true;
        else
            return false;
    }
}
