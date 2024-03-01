import javax.swing.*;

public class ChatLog {
    
    public JTextArea chat = new JTextArea(30, 50);

    public void addtolog (ChatLog log, String msg) {
        //output message onto log
        log.chat.append(msg);
    }
}
