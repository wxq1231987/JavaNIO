package chapter4.inetsocketaddresss.test;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class GetAddress {

    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8088);
        InetAddress inetAddress = inetSocketAddress.getAddress();
        byte[] ipAddress = inetAddress.getAddress();
        for (int i = 0;i < ipAddress.length;i++) {
            System.out.print((byte) ipAddress[i] + " ");
        }
    }

}
