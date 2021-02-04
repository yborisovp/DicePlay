package invoke.jetters.diceplay.auth_reg.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class DataBaseConnector {

    private final BufferedReader reader;
    private final OutputStreamWriter writer;


    public DataBaseConnector() throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8080);

        reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        writer = new OutputStreamWriter(clientSocket.getOutputStream());
    }

    public boolean requestToLogin(User user) throws IOException {

        writer.write("login\n" + user.getLogin() + "\n" + user.getPassword() + "\n");
        writer.flush();

        return reader.readLine().equals("accept");
    }

    public boolean requestToRegistration(User user) throws IOException {
        writer.write("register\n" + user.getLogin() + "\n" + user.getPassword() + "\n");
        writer.flush();

        return reader.readLine().equals("accept");
    }


}



