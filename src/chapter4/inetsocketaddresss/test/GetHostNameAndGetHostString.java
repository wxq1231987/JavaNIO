package chapter4.inetsocketaddresss.test;

import java.net.InetSocketAddress;

public class GetHostNameAndGetHostString {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("192.168.56.1", 80);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("wwww.baidu.com", 80);
        System.out.println(inetSocketAddress1.getHostName());
        System.out.println(inetSocketAddress1.getHostString());
        System.out.println(inetSocketAddress2.getHostName());
        System.out.println(inetSocketAddress2.getHostString());

        System.out.println();

        InetSocketAddress inetSocketAddress3 = new InetSocketAddress("192.168.56.1", 8088);
        InetSocketAddress inetSocketAddress4 = new InetSocketAddress("192.168.56.1", 8088);
        System.out.println(inetSocketAddress3.getHostString());
        System.out.println(inetSocketAddress3.getHostName());
        System.out.println(inetSocketAddress4.getHostString());
        System.out.println(inetSocketAddress4.getHostName());
    }
}
