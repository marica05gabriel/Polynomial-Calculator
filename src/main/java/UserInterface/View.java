package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends  JFrame{

    JLabel polinom0Label = new JLabel("Polinomul 1:");
    JTextField polinom0TextField = new JTextField(30);
    JLabel polinom1Label = new JLabel("Polinomul 2:");
    JTextField polinom1TextField = new JTextField(30);
    JLabel rezultatLabel = new JLabel("Rezultat :");
    JTextField rezultatTextField = new JTextField(30);

    JButton sumButton = new JButton("+");
    JButton subButton = new JButton("-");
    JButton mulButton = new JButton("*");
    JButton divButton = new JButton("/");
    JButton integrareButton = new JButton("Integrare");
    JButton derivareButton = new JButton("Derivare");

    public  View() {
        JFrame mainFrame = new JFrame("Marica Gabriel");
        mainFrame.setSize(400,300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel topPanel = new JPanel();
        JPanel polinomPanel = new JPanel();
        polinomPanel.setLayout(new BoxLayout(polinomPanel, BoxLayout.Y_AXIS));
        JPanel operatiiPanel = new JPanel();
        operatiiPanel.setLayout(new BoxLayout(operatiiPanel, BoxLayout.X_AXIS));
        operatiiPanel.add(sumButton);
        operatiiPanel.add(subButton);
        operatiiPanel.add(mulButton);
        operatiiPanel.add(divButton);
        operatiiPanel.add(integrareButton);
        operatiiPanel.add(derivareButton);


        mainPanel.add(topPanel,BorderLayout.NORTH);
        mainPanel.add(polinomPanel,BorderLayout.WEST);
        mainPanel.add(operatiiPanel, BorderLayout.EAST);

        JLabel topLabel = new JLabel("Salut");
        topPanel.add(topLabel);

        JPanel polinom0Panel = new JPanel();

        polinom0Panel.add(polinom0Label);
        polinom0Panel.add(polinom0TextField);

        JPanel polinom1Panel = new JPanel();

        polinom1Panel.add(polinom1Label);
        polinom1Panel.add(polinom1TextField);

        JPanel rezultatPanel = new JPanel();

        rezultatPanel.add(rezultatLabel);
        rezultatPanel.add(rezultatTextField);

        polinomPanel.add(polinom0Panel);
        polinomPanel.add(polinom1Panel);
        polinomPanel.add(rezultatPanel);

        mainFrame.setContentPane(mainPanel);

    }

    public String getPolinom0TextField() {
        return polinom0TextField.getText();
    }

    public void setPolinom0TextField(String text) {
        this.polinom0TextField .setText(text);
    }

    public String getPolinom1TextField() {
        return polinom1TextField.getText();
    }

    public void setPolinom1TextField(String text) {
        this.polinom1TextField.setText(text);
    }

    public String getRezultatTextField() {
        return rezultatTextField.getText();
    }

    public void setRezultatTextField(String text) {
        this.rezultatTextField.setText(text);
    }

    public void addSumListeren(ActionListener act){
        sumButton.addActionListener( act);
        System.out.println("am adaugat ascultator");
    }

    public void addSubListeren(ActionListener act){
        subButton.addActionListener( act);
        System.out.println("am adaugat ascultator");
    }
    public void addMulListeren(ActionListener act){
        mulButton.addActionListener( act);
        System.out.println("am adaugat ascultator");
    }
    public void addDivListeren(ActionListener act){
        divButton.addActionListener( act);
        System.out.println("am adaugat ascultator");
    }
    public void addIntegrareListeren(ActionListener act){
        integrareButton.addActionListener( act);
        System.out.println("am adaugat ascultator");
    }
    public void addDerivareListeren(ActionListener act){
        derivareButton.addActionListener( act);
        System.out.println("am adaugat ascultator");
    }
}
