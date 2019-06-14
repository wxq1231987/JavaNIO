package chapter3.networkinterface;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GetNetworkInterfaceByTest {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        NetworkInterface networkInterface1 = NetworkInterface.getByIndex(1);
        System.out.println(networkInterface1.getName());
        NetworkInterface networkInterface2 = NetworkInterface.getByName("eth0");
        System.out.println(networkInterface2.getName());
        NetworkInterface networkInterface3 = NetworkInterface.getByInetAddress(InetAddress.getByName("localhost"));
        System.out.println(networkInterface3.getName());
    }

}
