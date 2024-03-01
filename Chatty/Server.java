
public class Server {

    public static GUI[] makearray(int usernum) {

        GUI[] users = new GUI[usernum];

        for (int i = 0; i < usernum; i++) {
            users[i] = new GUI();
        }

        return users;
    }

    public static void updatelog (String message, int usernum, GUI[] users) {
        
        for (int j = 0; j < usernum; j++) {
            users[j].chatlog.addtolog(users[j].chatlog, message);
        }

    }
}
