package chapter4.bindspecifiedaddressandbacklog.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Run {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        InetAddress localhost2 = InetAddress.getByName("localhost");
        System.out.println(localhost == localhost2);
        System.out.println(localhost.getHostAddress());
        System.out.println(localhost2.getHostAddress());
        System.out.println(localhost.getHostName());
        System.out.println(localhost2.getHostName());
    }

}
