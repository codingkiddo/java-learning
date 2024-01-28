package com.example.modren_java_in_action.ch03;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
	public String process(BufferedReader br) throws IOException;
}
