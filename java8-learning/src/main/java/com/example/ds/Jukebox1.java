package com.example.ds;

import java.util.ArrayList;
import java.util.List;

public class Jukebox1 {
	public static void main(String[] args) {
		new Jukebox1().go();
	}

	public void go() {
		List<String> songList = MockSongs.getSongStrings();
		System.out.println(songList);
	}
}

class MockSongs {
	public static List<String> getSongStrings() {
//		In the real you'll often see Java Code that returns the interface type ( List ) and hides the implementation type ( ArrayList )
		List<String> songs = new ArrayList<>();
		songs.add("somersault");
		songs.add("cassidy");
		songs.add("$10");
		songs.add("havana");
		songs.add("Cassidy");
		songs.add("50 Ways");
		return songs;
	}
}


/* OUTPUT:  

[somersault, cassidy, $10, havana, Cassidy, 50 Ways]  -----> This is definitely NOT alphabetical!!!

*/
