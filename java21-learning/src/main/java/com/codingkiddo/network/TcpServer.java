package com.codingkiddo.network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Stream;

public class TcpServer {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(8080);

		System.out.println("Server started on port 8080");

		Socket socket = serverSocket.accept();

		System.out.println("Client connected");
		System.out.println("Remote address: " + socket.getRemoteSocketAddress());

		InputStream input = socket.getInputStream();

		OutputStream output = socket.getOutputStream();

		byte[] buffer = new byte[1024];

		int bytesRead = input.read(buffer);

		String message = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);

		System.out.println("Received:");
		System.out.println(bytesRead);
		Stream.of(buffer).forEach(b -> System.out.println(b));
		System.out.println(message);

		String response = "Hello from Java TCP Server";

		output.write(response.getBytes(StandardCharsets.UTF_8));

		output.flush();

		socket.close();
		serverSocket.close();
	}
}