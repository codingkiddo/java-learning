package com.codingkiddo.network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

public class ServerMain1 {

	public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("google.com", 80)) {
            socket.setSoTimeout(5_000);

            System.out.println("TCP connection established.");
            System.out.println("Remote: " + socket.getRemoteSocketAddress());

            OutputStream output = socket.getOutputStream();
            InputStream input = socket.getInputStream();

            byte[] outgoing =
                    "Hello Google\n".getBytes(StandardCharsets.UTF_8);

            output.write(outgoing);
            output.flush();

            System.out.println("Sent raw bytes: " + outgoing.length);

            byte[] incoming = new byte[1024];

            try {
                int bytesRead = input.read(incoming);

                if (bytesRead == -1) {
                    System.out.println("Google closed the connection.");
                } else {
                    System.out.println("Received bytes: " + bytesRead);
                    System.out.println(
                            new String(
                                    incoming,
                                    0,
                                    bytesRead,
                                    StandardCharsets.UTF_8
                            )
                    );
                }
            } catch (SocketTimeoutException exception) {
                System.out.println("No response received.");
            }
        }
    }

}
