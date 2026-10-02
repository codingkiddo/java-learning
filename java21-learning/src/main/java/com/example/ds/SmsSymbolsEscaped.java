package com.example.ds;

public class SmsSymbolsEscaped {

	public static void main(String[] args) {

		String heartSymbol = "\u03BE"; // Unicode escape for a heart symbol
        String smileyFace = "\uD83D\uDE0A"; // Unicode escape for a smiley face (surrogate pair)
        System.out.println("Heart: " + heartSymbol);
        System.out.println("Smiley: " + smileyFace);

        
	}

}
