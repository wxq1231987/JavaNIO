package chapter3.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByNameTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress myAddress = InetAddress.getByName("DESKTOP-IIR07UJ");
        InetAddress baiduAddress = InetAddress.getByName("www.baidu.com");
        InetAddress localhostAddress = InetAddress.getByName("localhost");
        InetAddress wangxuqinAddress = InetAddress.getByName("www.csdn.com");
        System.out.println(myAddress.getClass().getName() + "," + myAddress.getHostAddress());
        System.out.println(baiduAddress.getClass().getName() + "," + baiduAddress.getHostAddress());
        System.out.println(localhostAddress.getClass().getName() + "," + localhostAddress.getHostAddress());
        System.out.println(wangxuqinAddress.getClass().getName() + "," + wangxuqinAddress.getHostAddress());
    }

}
