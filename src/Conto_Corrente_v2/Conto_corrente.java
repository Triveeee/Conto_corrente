package Conto_Corrente_v2;

import javax.swing.JPanel;

public class Conto_corrente extends JPanel {

    private double tot_conto = 1000;



    public synchronized void  movimento (double importo , boolean comand){
        if(comand == true){
            tot_conto = tot_conto - importo;
        }
        if(comand == true){
            tot_conto = tot_conto + importo;
        }
    }
    
    public synchronized double getTot_conto() {
        return tot_conto;
    }

}

