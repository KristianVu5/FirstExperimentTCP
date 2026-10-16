package dev.lab;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class  Sender {

    static void main(String[] args) throws IOException{
        byte[] message1 = "HELLO".getBytes(StandardCharsets.UTF_8);
        byte[] message2 = "WORLD-26621200".getBytes(StandardCharsets.UTF_8);

        try(Socket socket = new Socket("localhost", 5000)) {
            OutputStream out = socket.getOutputStream();
            out.write(message1);
            out .write(message2);
            out.flush();

            System.out.println("Message send");
            System.out.println("Message size: "  + message1.length + " " + message2.length);
            System.out.println("Total message size: "+ message1.length + message2.length);

        }

    }
}
