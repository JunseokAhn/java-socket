import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader BR = null;
        BufferedReader BR2 = null;
        PrintWriter PW = null;

        InetAddress address = null;

        try {
            address = InetAddress.getByName("localhost");
            socket = new Socket(address, 5555);
            BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BR2 = new BufferedReader(new InputStreamReader(System.in));
            PW = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

            System.out.println(socket.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            System.out.println("send message : ");
            String line = BR2.readLine();
            System.out.println(line);
            PW.println(line);
            PW.flush();

            String line2 = BR.readLine();
            System.out.println("receive message : " + line2);
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
