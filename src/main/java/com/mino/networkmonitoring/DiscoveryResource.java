package com.mino.networkmonitoring;

import com.mino.networkmonitoring.dicovery.SubnetScanner;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.ArrayList;
import java.util.List;

@Path("/hello-world")
public class DiscoveryResource {
    @GET
    @Produces("text/plain")
    public String discover() {
        String subnet = "192.168.1.0";

        List<String> ipList = new ArrayList<>();
        System.out.println("Start Scanning...");
        System.out.println("Subnet "+subnet);
        SubnetScanner.scan(subnet);

        return "Subnet Scanned...";
    }
}