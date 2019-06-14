package chapter3.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByAddressTest2 {

    public static void main(String[] args) throws UnknownHostException {
        byte[] addr = new byte[]{-64, -88, 56, 1};
        InetAddress inetAddress = InetAddress.getByAddress(addr);
        System.out.println("InetAddress.getHostAddress=" + inetAddress.getHostAddress());
        System.out.println("InetAddress.getHostName=" + inetAddress.getHostName());
        System.out.println("InetAddress.getClass().getName()=" + inetAddress.getClass().getName());
    }

}
