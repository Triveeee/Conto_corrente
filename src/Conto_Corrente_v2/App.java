package Conto_Corrente_v2;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class App extends JFrame implements Runnable {

    private boolean comand = true;
    
    private JRadioButton b1;
    private JRadioButton b2;
    private JButton start;
  
    private JTextField txt1;

    private JLabel lbl1;

    private double tot_conto = 1000;

    private Thread t1;
    private Thread t2;

    private Conto_corrente conto_corrente;

    
    public App(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        ButtonGroup group = new ButtonGroup();

        b1 = new JRadioButton("prelevamento" , true);
        b1.addActionListener(new GestioneBottone());
        b2 = new JRadioButton("versamento");
        b2.addActionListener(new GestioneBottone());
        start = new JButton("start");
        start.addActionListener(new GestioneBottone());

        txt1 = new JTextField("inserisci importo" , 10);

        lbl1 = new  JLabel("CONTO = " + tot_conto);

        t1 = new Thread(this);
        t2 = new Thread(this);

        conto_corrente = new Conto_corrente();

        group.add(b1);
        group.add(b2);

        Container container = this.getContentPane();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        container.add(p1);
        container.add(p2);

        p1.add(txt1);
        p1.add(b1);
        p1.add(b2);

        p2.add(lbl1);
        p2.add(start);

        this.pack();
    }
    public class GestioneBottone implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //true --> prelevamento
            //false --> versamento
            if(e.getSource().equals(b1)){
                comand = true;
            }
            if(e.getSource().equals(b2)){
                comand = false;
            }
            if(e.getSource().equals(start)){
                t1.start();
                t2.start();
            }
            
        }

    }

    @Override
    public void run() {
        try {
            conto_corrente.movimento(Double.parseDouble(txt1.getText()), comand);
            lbl1.setText("CONTO = " + conto_corrente.getTot_conto());
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }

    public static void main(String[] args) {
        new App();
    }
}
