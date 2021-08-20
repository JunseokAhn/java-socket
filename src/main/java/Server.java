import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        Socket socket = null;
        ServerSocket serverSocket = null;
        BufferedReader BR = null;
        PrintWriter PW = null;

        try {
            serverSocket = new ServerSocket(5555);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("port is opened.");
        }


        try {
            System.out.println("server open");
            socket = serverSocket.accept();

            BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PW = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

            String line = null;
            line = BR.readLine();

            System.out.println("receive : " + line);

            PW.println("i received your message");
            PW.flush();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
