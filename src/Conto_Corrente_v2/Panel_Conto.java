package Conto_Corrente_v2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_Conto extends JPanel implements Runnable {

    private boolean comand;
    private boolean cond;

    private double tot_conto;
    private JRadioButton b1;
    private JRadioButton b2;
    private JButton start;
  
    private JTextField txt1;

    private JLabel lbl1;

    private Thread t1;
    private Thread t2;

    private Conto_corrente conto_corrente;

    public Panel_Conto(Conto_corrente conto_corrente){
        this.conto_corrente = conto_corrente;


        tot_conto = 1000;
        comand = true;
        cond = false;
        
        ButtonGroup group = new ButtonGroup();
        b1 = new JRadioButton("prelevamento" , true);
        b1.addActionListener(new GestioneBottone());
        b2 = new JRadioButton("versamento");
        b2.addActionListener(new GestioneBottone());
        start = new JButton("start");
        start.addActionListener(new GestioneBottone());

        txt1 = new JTextField("inserisci importo" , 10);

        lbl1 = new  JLabel("CONTO = " + tot_conto);

        t1 = new Thread(this , "T1");
        t2 = new Thread(this , "T2");

        group.add(b1);
        group.add(b2);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(p1);
        this.add(p2);

        Box box = Box.createVerticalBox();
        p1.setLayout(new GridLayout( 0 , 2 , 5 ,5 ));
        p1.add(txt1);
        p1.add(box);

        p1.setMaximumSize(new Dimension(200 ,200));

        box.add(b1);
        box.add(b2);

        p2.add(lbl1);
        p2.add(start);

        t1.start();
        t2.start();
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
            //true --> inizo
            //false --> stop
            if(e.getSource().equals(start)){
                cond = true;
            }
            
        }

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        while(true){
            lbl1.setText("CONTO = " + tot_conto);

            synchronized(conto_corrente){
                try {
                    if(cond == true){
                        tot_conto = conto_corrente.movimento(Double.parseDouble(txt1.getText()) , comand);
                        System.out.println(Thread.currentThread().getName());
                        cond = false;
                    }
    
                    Thread.sleep(100);
    
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Errore  " + e, "Errore", JOptionPane.ERROR_MESSAGE);
                    cond = false;
    
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            }
        
    }

}

