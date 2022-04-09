
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame implements Runnable {

    private JButton bottone1;
    private JButton bottone2;

    public App(){

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        bottone1 = new JButton("Prelevamento");
        bottone2 = new JButton("Versamento");

        bottone1.setActionCommand("prelevamento");
        bottone1.addMouseListener(new GestioneMouse());
        bottone1.addActionListener(new GestioneBottone());
        bottone2.setActionCommand("Versamento");
        bottone2.addMouseListener(new GestioneMouse());
        bottone2.addActionListener(new GestioneBottone());

        Container container = this.getContentPane();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(p1);
        container.add(p2);


        p1.add(bottone1);
        p2.add(bottone2);


        this.pack();
    }

    public class GestioneBottone implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }

    }



    public static void main(String[] args) {
        new App();
    }



    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

}
