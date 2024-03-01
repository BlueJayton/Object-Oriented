import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class UserNumGetter implements ActionListener {
    
    public static int usernum;
    public static GUI[]users;
    private JFrame ask = new JFrame();
    private JPanel panel = new JPanel();
    private JTextArea num = new JTextArea();

    public UserNumGetter() {

        ask.setResizable(false);

        JLabel usernum = new JLabel("How many users are there? (Enter numeric symbols only)");
        JLabel blank = new JLabel(" ");
        
        JButton enter = new JButton("Enter");
        enter.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder (30, 30, 10, 30));
        panel.setLayout(new GridLayout(2, 2));

        panel.add(usernum);
        panel.add(blank);
        panel.add(num);
        panel.add(enter);

        ask.add(panel, BorderLayout.CENTER);
        ask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ask.setTitle("Number of Users");
        ask.pack();
        ask.setVisible(true);

    }

    @Override
    public void actionPerformed (ActionEvent r) {

        ask.dispose();

        usernum = Integer.parseInt(num.getText());

        users = new GUI[usernum];

        users = Server.makearray(usernum);

    }
}
