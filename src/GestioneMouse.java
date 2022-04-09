import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class GestioneMouse extends MouseAdapter{
    
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
        JButton bottone = (JButton) e.getSource();

        bottone.setBackground(Color.red);
        bottone.setForeground(Color.yellow);
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton bottone = (JButton) e.getSource();

        bottone.setBackground(null);
        bottone.setForeground(null);

    }
}
