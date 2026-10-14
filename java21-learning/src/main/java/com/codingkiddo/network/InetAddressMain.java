package com.codingkiddo.network;

import java.net.InetAddress;

public class InetAddressMain {

    public static void main(String[] args) throws Exception {

        System.out.println("===== LOOKUP 1 =====");

        long start1 = System.nanoTime();

        InetAddress address1 =
                InetAddress.getByName("google.com");

        long end1 = System.nanoTime();

        System.out.println(address1);
        System.out.println(
                "Time: " + (end1 - start1) / 1_000_000.0 + " ms");


        System.out.println();
        System.out.println("===== LOOKUP 2 =====");

        long start2 = System.nanoTime();

        InetAddress address2 =
                InetAddress.getByName("google.com");

        long end2 = System.nanoTime();

        System.out.println(address2);
        System.out.println(
                "Time: " + (end2 - start2) / 1_000_000.0 + " ms");


        Thread.sleep(30_000);
    }
}