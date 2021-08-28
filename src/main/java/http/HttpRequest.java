package http;

import java.io.*;
import java.net.Socket;

public class HttpRequest {

    public static void main(String[] args) {

        Socket socket = null;
        try {
            socket = new Socket("www.google.com", 80);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream pw = new PrintStream(socket.getOutputStream());

        pw.println("GET / HTTP/1.1");

        pw.println("Host: www.google.com");
        pw.println("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_0)"
                + " AppleWebKit/537.36 (KHTML, like Gecko)"
                + " Chrome/30.0.1599.101 Safari/537.36");

        pw.println();
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }

        socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
