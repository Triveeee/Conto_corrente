package Conto_Corrente_v2;

import javax.swing.*;


public class App extends JFrame {

    public App(){

        Conto_corrente conto_corrente = new Conto_corrente();
        this.setContentPane(new Panel_Conto(conto_corrente));

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.pack();
    }


    public static void main(String[] args) {
        new App();
    }
}
