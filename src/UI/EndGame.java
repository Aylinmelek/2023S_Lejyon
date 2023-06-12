package UI;
import java.awt.*;    
import javax.swing.*;

public class EndGame extends JLayeredPane {
	public 
    JLabel lblEnd = new JLabel("GAME OVER!", SwingConstants.CENTER);
    JLabel lblWin;// = new JLabel("... Won!", SwingConstants.CENTER);

    public boolean endMode = false;

    public EndGame(String winnerName) {
        super();
        lblWin = new JLabel(winnerName + " Won!", SwingConstants.CENTER); 
        initialize();
        addElements();
        
    }

    public void initialize() {
        setBackground(Color.DARK_GRAY);
        setBounds(0, 54, 873, 451);
        setLayout(new BorderLayout());
    }

    public void addElements() {
        lblEnd.setForeground(Color.LIGHT_GRAY);
        lblEnd.setFont(new Font("Kokonor", Font.PLAIN, 40));
        lblEnd.setBackground(Color.DARK_GRAY);
        lblEnd.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblWin.setForeground(Color.LIGHT_GRAY);
        lblWin.setFont(new Font("Kokonor", Font.PLAIN, 40));
        lblWin.setBackground(Color.DARK_GRAY);
        lblWin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false); 
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalGlue()); 
        panel.add(lblEnd);
        panel.add(lblWin);
        panel.add(Box.createVerticalGlue());

        add(panel, BorderLayout.CENTER);
    }


}
