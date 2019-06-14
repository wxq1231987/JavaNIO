package chapter3.networkinterface;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GetMtuTest {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            System.out.println("getName获得网络设备名称:" + networkInterface.getName());
            System.out.println("getDisplayName获得网络设备显示名称:" + networkInterface.getDisplayName());
            System.out.println("getMtu获得最大传输单元：" + networkInterface.getMTU());
            System.out.println();
        }
    }
}
