package cz.zcu.qwerty;

import java.net.*;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String argv[]) throws Exception
    {
        if (argv.length < 3) {
            System.out.print("Zadej parametry: adresa port {telo zpravy}");
        }

        String address = argv[0];

        int port = Integer.valueOf(argv[1]);

        String message = String.join(" ", Arrays.copyOfRange(argv,2,argv.length));

        Socket socket = new Socket(address, port);

        OutputStream os = socket.getOutputStream();
        os.write(message.getBytes());

        InputStream is = socket.getInputStream();
        byte[] message_back = new byte[message.getBytes().length];
        is.read(message_back);
        String output = new String(message_back, "ISO-8859-1");
        System.out.println("Message Received: " +  output);

        is.close();
        os.close();

        socket.close();
    }
}