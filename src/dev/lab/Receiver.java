package dev.lab;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.in;

public class Receiver {

    static void main(String[] args) throws IOException {

        int bufferSize = args.length > 0 ? Integer.parseInt(args[0]) : 8;

        if(bufferSize <= 0) {
            throw   new IllegalArgumentException("Buffer size must be positive");
        }

       try(
               ServerSocket serverSocket = new ServerSocket(5000, bufferSize);
               Socket socket = serverSocket.accept();
               InputStream in = socket.getInputStream();
        ){
           byte[] buffer = new byte[bufferSize];
           int count = 0;
           int totalCounter =0;

           while((count = in.read(buffer)) != -1) {

               totalCounter += count;

               for(int i = 0; i < count; i++ ) {
                   System.out.printf("%02X",buffer[i] & 0xFF);
                   System.out.println();
               }
           }
           System.out.println("Total message size: " + totalCounter);
        }

    }
}
