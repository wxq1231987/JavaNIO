package chapter3.networkinterface;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GetHostAddressTest {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface eachNetworkInterface = networkInterfaces.nextElement();
            System.out.println("getName获得网络设备名称： " + eachNetworkInterface.getName());
            System.out.println("getDisplayName获得网络设备显示名称：" + eachNetworkInterface.getDisplayName());
            System.out.println("getInetAddresses获得网络接口的InetAddress信息：");
            Enumeration<InetAddress> addresses = eachNetworkInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress inetAddress = addresses.nextElement();
                System.out.println("getCanonicalHostName获取此IP地址的完全限定域名="
                        + inetAddress.getCanonicalHostName());
                System.out.println("getHostName获取此IP地址的主机名=" + inetAddress.getHostName());
                System.out.println("getHostAddress获取IP地址字符串=" + inetAddress.getHostAddress());
                System.out.print("getAddress获取原始IP地址=");
                byte[] addressByte = inetAddress.getAddress();
                for (int i = 0;i < addressByte.length;i++) {
                    System.out.print(addressByte[i] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
