package com.example.core_java_string_operations2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharacterEncodingExamples {

	public static void main(String[] args) throws IOException {
		System.out.println(StandardCharsets.US_ASCII);
		System.setProperty("file.encoding", "US_ASCII");
		String line = "The fa��ade pattern is a software design pattern.";
		System.out.println(decodeText(line, StandardCharsets.US_ASCII, CodingErrorAction.REPLACE));
		System.out.println(decodeText(line, StandardCharsets.UTF_8, CodingErrorAction.REPLACE));

		// Returns a string of character encoding
		// using the getProperty() method
		String defaultencoding = System.getProperty("file.encoding");

		// Return the above string of character encoded
		System.out.println("Default Charset: " + defaultencoding);

		// Getting character encoding by InputStreamReader
		// using the getCharacterEncoding() method
		System.out.println("Default Charset by InputStreamReader: " + getCharacterEncoding());

		// Getting character encoding by java.nio.charset
		// using the default charset() method
		System.out.println("Default Charset: " + Charset.defaultCharset());

		int someChar = "�".codePointAt(0);
		System.out.println("someChar: " + someChar);

//		for (int i = 0; i < line.length(); i++) {
//			int codePoint = line.codePointAt(i);
//			// Skip over the second char in a surrogate pair
//			if (codePoint > 0xffff) {
//				i++;
//			}
//			System.out.println(codePoint);
//		}

		System.out.println(convertToBinary("�", "US-ASCII"));
		System.out.println(convertToBinary("�", "UTF-8"));
		System.out.println(convertToBinary("�", "UTF-16"));
		System.out.println(convertToBinary("�", "UTF-32"));
	}

	// Method 1
	// To encode the characters
	public static String getCharacterEncoding() {

		// Creating and initializing byte array
		// with some random character say it be N

		// Here N = w
		byte[] byte_array = { 'w' };

		// Creating an object of inputStream
		InputStream instream = new ByteArrayInputStream(byte_array);

		// Now, opening new file input stream reader
		InputStreamReader streamreader = new InputStreamReader(instream);

		String defaultCharset = streamreader.getEncoding();

		// Returning the default character encoded
		// Here it is for N = 'w'
		return defaultCharset;
	}

	static String decodeText(String input, Charset charset, CodingErrorAction codingErrorAction) throws IOException {
		CharsetDecoder charsetDecoder = charset.newDecoder();
		charsetDecoder.onMalformedInput(codingErrorAction);
		return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes()), charsetDecoder))
				.readLine();
	}

	static String convertToBinary(String input, String encoding) throws UnsupportedEncodingException {
		byte[] encoded_input = Charset.forName(encoding).encode(input).array();
		return IntStream.range(0, encoded_input.length).map(i -> encoded_input[i])
				.mapToObj(e -> Integer.toBinaryString(e ^ 255))
				.map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0")).collect(Collectors.joining(" "));
	}

}
