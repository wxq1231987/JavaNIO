package chapter3.networkinterface;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GetHardwareAddressTest {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            System.out.println("getName获得网络设备名称：" + networkInterface.getName());
            System.out.println("getDisplayName获得网络设备显示名称：" + networkInterface.getDisplayName());
            System.out.print("getHardwareInterface获得网卡的物理地址=");
            byte[] address = networkInterface.getHardwareAddress();
            if (address != null && address.length != 0) {
                for (int i = 0;i < address.length;i++) {
                    System.out.print(address[i] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
