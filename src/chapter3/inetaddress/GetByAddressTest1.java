package chapter3.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByAddressTest1 {

    public static void main(String[] args) throws UnknownHostException {
        byte[] addr = new byte[]{-64, -8, 56, 1};
        InetAddress myAddress = InetAddress.getByAddress(addr);
        System.out.println("MyAddress.getHostAddress()=" + myAddress.getHostAddress());
        System.out.println("MyAddress.getHostName()=" + myAddress.getHostName());
        System.out.println("MyAddress.getClass().getName()=" + myAddress.getClass().getName());

    }

}
