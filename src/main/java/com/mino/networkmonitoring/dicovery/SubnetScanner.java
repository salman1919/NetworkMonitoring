package com.mino.networkmonitoring.dicovery;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SubnetScanner {
    public static void scan(String subnet) {
        subnet = subnet.substring(0,subnet.lastIndexOf('.'));
//        String subnet = "192.168.1"; // Define your subnet here without the last octet
        int startHost = 1;
        int endHost = 68; // Assuming a typical subnet mask

        int portToScan = 80; // Example port to scan

        for (int i = startHost; i <= endHost; i++) {
            String host = subnet + "." + i;

            System.out.println();
            System.out.println("Scanning : "+host);

            try {
                InetAddress address = InetAddress.getByName(host);
                if (address.isReachable(4000)) { // Timeout in milliseconds
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(host, portToScan), 4000); // Timeout in milliseconds
                    socket.close();
                    System.out.println(host + " is reachable on port " + portToScan);
                }
            } catch (Exception ex) {
                // Host is likely unreachable or port is closed
                System.out.println(ex);
                System.out.println(host + " Not Live");
            }
            System.out.println();
        }
    }
}
