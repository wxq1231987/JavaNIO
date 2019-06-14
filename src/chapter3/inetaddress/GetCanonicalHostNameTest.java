package chapter3.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetCanonicalHostNameTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress baiduAddress = InetAddress.getByName("www.baidu.com");
        System.out.println("baiduAddress.getCanonicalHostName=" + baiduAddress.getCanonicalHostName());
        System.out.println("baiduAddress.getHostName=" + baiduAddress.getHostName());
    }

}
