package chapter3.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetLocalHostTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.print("localhost.getAddress地址为=");
        byte[] localHostAddress = inetAddress.getAddress();
        for (int i = 0;i < localHostAddress.length;i++) {
            System.out.print(localHostAddress[i] + " ");
        }
        System.out.println();
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.print("localhost.getLoopbackAddress地址为=");
        byte[] loopbackAddressByte = loopbackAddress.getAddress();
        for (int i = 0;i < loopbackAddressByte.length;i++) {
            System.out.print(loopbackAddressByte[i] + " ");
        }
    }
}
