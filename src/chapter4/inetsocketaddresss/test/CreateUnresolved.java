package chapter4.inetsocketaddresss.test;

import java.net.InetSocketAddress;

public class CreateUnresolved {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("www.baidu.com", 80);
        System.out.println(inetSocketAddress.isUnresolved());

        System.out.println();

        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("www.baidu.comlsdjfk", 80);
        System.out.println(inetSocketAddress2.isUnresolved());
        System.out.println();

        InetSocketAddress inetSocketAddress3 = InetSocketAddress.createUnresolved("www.baidu.com", 80);
        System.out.println(inetSocketAddress3.isUnresolved());

        System.out.println();

        InetSocketAddress inetSocketAddress4 = InetSocketAddress.createUnresolved("www.baidu.comlsdjfk", 80);
        System.out.println(inetSocketAddress4.isUnresolved());
    }
}
