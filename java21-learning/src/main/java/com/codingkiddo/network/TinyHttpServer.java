package com.codingkiddo.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TinyHttpServer {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(8080);

		System.out.println("HTTP server running at http://localhost:8080");

		while (true) {

			Socket socket = serverSocket.accept();

			handle(socket);
		}
	}

	private static void handle(Socket socket) throws Exception {

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

		String line;

		while ((line = reader.readLine()) != null) {

			System.out.println(line);

			if (line.isEmpty()) {
				break;
			}
		}

		String body = "Hello from Core Java HTTP Server";

		byte[] bodyBytes = body.getBytes(StandardCharsets.UTF_8);

		String headers = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/plain; charset=utf-8\r\n" + "Content-Length: "
				+ bodyBytes.length + "\r\n" + "Connection: close\r\n" + "\r\n";

		OutputStream output = socket.getOutputStream();

		output.write(headers.getBytes(StandardCharsets.UTF_8));

		output.write(bodyBytes);

		output.flush();

		socket.close();
	}
}