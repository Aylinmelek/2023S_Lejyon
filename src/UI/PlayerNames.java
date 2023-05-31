package UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerNames extends JFrame {
    private JLayeredPane layeredPane;
    private DefaultListModel<String> listModel;
    private JList<String> userList;
    private JTextField textField;
    private JButton btnLogin;
    private int playerNumber = 0;
    

    public PlayerNames() {
        layeredPane = new JLayeredPane();
        listModel = new DefaultListModel<>();
        userList = new JList<>(listModel);
        textField = new JTextField(20);
        btnLogin = new JButton("Login");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                if (!username.isEmpty()) {
                    playerNumber++;
                    listModel.addElement("Player " + playerNumber + ": " + username);
                    textField.setText("");
                }
            }
        });

        userList.setCellRenderer(new UserListCellRenderer());

        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setBounds(10, 10, 300, 200);

        textField.setBounds(10, 220, 200, 20);
        btnLogin.setBounds(220, 220, 100, 20);

        layeredPane.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(textField, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(btnLogin, JLayeredPane.DEFAULT_LAYER);

        setContentPane(layeredPane);
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dynamic Layered Panel Example");
        setLocationRelativeTo(null);
    }

    private class UserListCellRenderer extends DefaultListCellRenderer {
        private Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setOpaque(true);
            label.setBackground(colors[index % colors.length]);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            return label;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	PlayerNames example = new PlayerNames();
                example.setVisible(true);
            }
        });
    }
}

