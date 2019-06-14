package chapter3.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetAllByNameTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] myAddress = InetAddress.getAllByName("DESKTOP-IIR07UJ");
        InetAddress[] baiduAddresses = InetAddress.getAllByName("www.baidu.com");
        for (int i = 0;i < myAddress.length;i++) {
            InetAddress inetAddress = myAddress[i];
            System.out.println("MyAddress.getHostAddress=" + inetAddress.getHostAddress()
                + " " + inetAddress.getClass().getName());
        }
        System.out.println();
        for (int i = 0;i < baiduAddresses.length;i++) {
            InetAddress inetAddress = baiduAddresses[i];
            System.out.println("BaiduAddress.getHostAddress=" + inetAddress.getHostAddress()
                + " " + inetAddress.getClass().getName());
        }
    }

}
