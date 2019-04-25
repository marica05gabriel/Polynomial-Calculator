package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import Model.Polinom;
import Parsare.*;
import Operatii.Adunare;

public class Controller {
    private View view;
    private Model model;

    public Controller(Model _model, View _view) {
        view = _view;
        model = _model;

        view.addSumListeren(new SumListener());
        view.addSubListeren(new SubListener());
        view.addMulListeren(new MulListener());
        view.addDivListeren(new DivListener());
        view.addIntegrareListeren(new IntegrareListener());
        view.addDerivareListeren(new DerivareListener());
    }

    class SumListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String poli0 = view.getPolinom0TextField();
            String poli1 = view.getPolinom1TextField();
            System.out.println(poli0);
            System.out.println(poli1);

            model.sum(poli0,poli1);
            String rez = model.getRezultat();

            System.out.println(rez);
            view.setRezultatTextField(rez);
        }
    }

    class SubListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String poli0 = view.getPolinom0TextField();
            String poli1 = view.getPolinom1TextField();
            System.out.println(poli0);
            System.out.println(poli1);

            model.sub(poli0,poli1);
            String rez = model.getRezultat();

            System.out.println(rez);
            view.setRezultatTextField(rez);
        }
    }

    class DivListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String poli0 = view.getPolinom0TextField();
            String poli1 = view.getPolinom1TextField();
            System.out.println(poli0);
            System.out.println(poli1);

            model.div(poli0,poli1);
            String rez = model.getRezultat();

            System.out.println(rez);
            view.setRezultatTextField(rez);
        }
    }

    class MulListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String poli0 = view.getPolinom0TextField();
            String poli1 = view.getPolinom1TextField();
            System.out.println(poli0);
            System.out.println(poli1);

            model.mul(poli0,poli1);
            String rez = model.getRezultat();

            System.out.println(rez);
            view.setRezultatTextField(rez);
        }
    }

    class DerivareListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String poli0 = view.getPolinom0TextField();

            System.out.println(poli0);


            model.derivare(poli0);
            String rez = model.getRezultat();

            System.out.println(rez);
            view.setRezultatTextField(rez);
        }
    }

    class IntegrareListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String poli0 = view.getPolinom0TextField();

            System.out.println(poli0);


            model.integrare(poli0);
            String rez = model.getRezultat();

            System.out.println(rez);
            if(rez == "") {
                rez="0";
            }

            view.setRezultatTextField(rez);
        }
    }


}


