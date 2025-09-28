package com.codingkiddo.net;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;


public class RetrievesTheMACAddresses {

	public static void main(String[] args) throws SocketException {
		System.out.println(getMacAddresses());
	}

	private static String getMacAddresses() throws SocketException { 
		Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
		List<String> macAddress = new ArrayList<>();
		while ( networkInterfaces.hasMoreElements() ) {
			NetworkInterface  network = networkInterfaces.nextElement();
			System.out.println(network.getHardwareAddress() + ":" + network.getDisplayName());
			byte[] macArray = network.getHardwareAddress();
			if ( ArrayUtils.isNotEmpty(macArray) ) {
				macAddress.add(StringUtils.toEncodedString(macArray, StandardCharsets.UTF_8));
			}
		}
		Collections.sort(macAddress);
		return StringUtils.join(macAddress);
	}
}
