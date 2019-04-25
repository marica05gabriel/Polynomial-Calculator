package Parsare;
import Model.Monom;
import Model.Polinom;


public class Expresie {
    private static Expresie ourInstance= new Expresie();

    public static Expresie getInstance() {

        if (ourInstance == null) {
            ourInstance = new Expresie();
        }

        return ourInstance;
    }

    private Expresie() { }


    public Polinom getPolinom(String expresie) {
        Polinom polinom = null;
        expresie = expresie.replaceAll("[*^ ]","");
        expresie = expresie.replaceAll("[xX]", "x");

        if(expresie.startsWith("+")) {
            expresie = expresie.substring(1);
        }

        try {
            nullExpression(expresie);
        } catch (ExpresieInvalidaException e) {
            System.out.println("Expresia e invalida => polinomul este null");
            return null;
        }

        polinom = new Polinom();

        String[]  expresieParsata = expresie.split("\\+|(?=-)");
        int size=expresieParsata.length;

        parsareExpresieMonom(expresieParsata, polinom);
        return polinom;
    }

    private void parsareExpresieMonom(String[] expresieParsata, Polinom polinom) {
        int size = expresieParsata.length;
        for(int i=0; i<size; i++) {
            String[] expresieMonom = expresieParsata[i].split("(?=x)");

            float coeficient = 0;
            coeficient = getCoeficient(expresieMonom);

            int exponent = 0;
            exponent = getExponent(expresieMonom);

            //System.out.println("COEF:"+coeficient+" EXP:"+exponent);
            System.out.println("COEFICIENT:"+coeficient+" EXPONENT:"+exponent);
            Monom monom = Monom.creareMonom(coeficient, exponent);
            polinom.addMonom(monom);
        }
    }

    private boolean nullExpression(String expresie) throws ExpresieInvalidaException{
        if ( expresie == null||expresie.equals("") ) {
            throw new ExpresieInvalidaException();
        }
        return false;
    }

    private float getCoeficient(String[] expresieMonom) {
        if(expresieMonom!=null) {
            float coeficient = 0;

            if( expresieMonom[0].contains("x") ) {
                coeficient=1;
            } else {
                if( expresieMonom[0].equals("") || expresieMonom[0].equals(" ") ) {
                    coeficient = 1;
                }
                else {
                    expresieMonom[0] = expresieMonom[0].replace(" ","");
                    if(expresieMonom[0].equals("-")) {
                        coeficient = -1;
                    } else {
                        coeficient = Float.parseFloat(expresieMonom[0]);
                    }
                }
            }
            return coeficient;

        }
        return 0;
    }

    private int getExponent(String[]  expresieMonom) {
        int exponent = 0;

        if(expresieMonom != null) {
            if( expresieMonom.length == 2) {
                expresieMonom[1] = expresieMonom[1].replace("x", "");
                if( expresieMonom[1].equals(" ") || expresieMonom[1].equals("") ) {
                    exponent = 1;
                }
                else {
                    expresieMonom[1] = expresieMonom[1].replace(" ","");
                    exponent = Integer.parseInt(expresieMonom[1]);
                }
            }
            else {
                if(expresieMonom[0].contains("x")) {
                    expresieMonom[0] = expresieMonom[0].replace("x","");
                    System.out.println(expresieMonom[0]);
                    //aiCI
                    if(expresieMonom[0].equals("")) {
                        exponent = 1;
                    } else {
                        exponent = Integer.parseInt(expresieMonom[0]);
                    }
                } else {
                    exponent = 0;
                }
            }
            return exponent;
        }

        return 0;

    }

}
