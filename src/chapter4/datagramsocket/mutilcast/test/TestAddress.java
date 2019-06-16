package chapter4.datagramsocket.mutilcast.test;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

public class TestAddress {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface each = interfaces.nextElement();
            System.out.println("Name:" + each.getName());
            System.out.println("DisplayName:" + each.getDisplayName());
            List<InterfaceAddress> interfaceAddres = each.getInterfaceAddresses();
            for(InterfaceAddress eachInterfaceAddr:interfaceAddres) {
                InetAddress inetAddr = eachInterfaceAddr.getAddress();
                InetAddress broadcastAddr = eachInterfaceAddr.getBroadcast();
                if (inetAddr != null) {
                    System.out.println("--Address:" + eachInterfaceAddr.getAddress().getHostAddress());
                }
                if (broadcastAddr != null) {
                    System.out.println("--Broadcast:" + eachInterfaceAddr.getBroadcast().getHostAddress());
                }
            }
        }
        System.out.println("");
    }
}
