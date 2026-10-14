package com.codingkiddo.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleHttpClient {

	public static void main(String[] args) {

		try (Socket socket = new Socket("google.com", 80);
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), false);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

			System.out.println("Connected to: " + socket.getRemoteSocketAddress());

			System.out.println("Local endpoint: " + socket.getLocalSocketAddress());

			writer.print("GET / HTTP/1.1\r\n" 
					+ "Host: google.com\r\n" + "User-Agent: Java-Raw-Socket-Client\r\n"
					+ "Accept: */*\r\n" + "Connection: close\r\n" + "\r\n");
			
			writer.flush();
			
			String line = null;
			while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
}
