
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel mainpanel = new JPanel();
    private JPanel chatpanel = new JPanel();
    private JPanel senderpanel = new JPanel();
    private JTextArea messageinput = new JTextArea( 3, 50);
    private JTextField nameinput = new JTextField();  
    ChatLog chatlog = new ChatLog();

    public GUI() {

        frame.setResizable(false);

        JButton button = new JButton("Send");
        button.addActionListener(this);

        chatlog.chat.setEditable(false);     
        JScrollPane chatlogscroll = new JScrollPane(chatlog.chat); 

        mainpanel.setBorder(BorderFactory.createEmptyBorder (30, 30, 10, 30));
        mainpanel.setLayout(new BorderLayout());

        chatpanel.setBorder(BorderFactory.createEmptyBorder (0, 0, 15, 0));
        chatpanel.setLayout(new BoxLayout(chatpanel, BoxLayout.Y_AXIS));
        JLabel talk = new JLabel("Chat: ");
        chatpanel.add(talk);
        chatpanel.add(chatlogscroll);
        JLabel msg = new JLabel("Message: ");
        chatpanel.add(msg);
        chatpanel.add(messageinput);

        senderpanel.setLayout(new GridLayout(2, 2));
        JLabel sender = new JLabel("Sender: ");
        senderpanel.add(sender);
        JLabel blank = new JLabel(" ");
        senderpanel.add(blank);
        senderpanel.add(nameinput);
        senderpanel.add(button);

        mainpanel.add(chatpanel);
        mainpanel.add(senderpanel, BorderLayout.PAGE_END);

        frame.add(mainpanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chatty");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent r) {
        //get message and name
        User curr = new User();
        curr.name = nameinput.getText();
        curr.msg = messageinput.getText();
        curr.msg = curr.name + ": " + curr.msg + "\n";

        Server.updatelog(curr.msg, UserNumGetter.usernum, UserNumGetter.users);

        messageinput.selectAll();
        messageinput.replaceSelection("");
    }
}