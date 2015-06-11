package cn.xgame.gen;

import java.io.IOException;
import java.net.InetAddress;

import x.javaplus.ip.IPSeeker;

public class IpTest {
	public static void main(String[] args) throws IOException {
		String IP = "119.75.217.56";
        String dataFile = "qqwry.dat";
        
        IPSeeker.I.init( dataFile );
        
        
        String country = IPSeeker.I.getAddress(IP);
        
        System.out.println( IPSeeker.I.getCountry( "192.168.1.135" ) );
        
        System.out.println(country);
        
        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println(ip);
	}
}
