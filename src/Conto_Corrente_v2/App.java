package Conto_Corrente_v2;

import javax.swing.*;


public class App extends JFrame {

    public App(){
        Conto_Corrente conto_corrente = new Conto_Corrente();
        this.setContentPane(new Panel_Conto(conto_corrente));

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.pack();
    }


    public static void main(String[] args) {
        new App();
    }
}
