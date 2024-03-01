package com.mino.networkmonitoring.dicovery;

import java.net.*;

public class PortScanner {

    public static void scan(String host, int startPort, int endPort) {
        /*int startPort = 1;
        int endPort = 65535;*/

        for (int port = startPort; port <= endPort; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(host, port), 1000); // Timeout in milliseconds
                socket.close();
                System.out.println("Port " + port + " is open");
            } catch (Exception ex) {
                // Port is likely closed or filtered
            }
        }
    }
}
