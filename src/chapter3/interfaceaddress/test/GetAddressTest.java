package chapter3.interfaceaddress.test;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class GetAddressTest {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
        while (networkInterface.hasMoreElements()) {
            NetworkInterface each = networkInterface.nextElement();
            System.out.println("getName获得网络设备名称:" + each.getName());
            System.out.println("getDisplayName获得网络设备显示名称:" + each.getDisplayName());
            List<InterfaceAddress> addressList = each.getInterfaceAddresses();
            for (int i = 0;i < addressList.size();i++) {
                InterfaceAddress eachInterfaceAddress = addressList.get(i);
                InetAddress address = eachInterfaceAddress.getAddress();
                if (address != null) {
                    System.out.println("address.getAddress()=" + address.getHostAddress());
                }
                address = eachInterfaceAddress.getBroadcast();
                if (address != null) {
                    System.out.println("address.getBroadcast()=" + address.getHostAddress());
                }
                System.out.println("getNetworkPrefixLength()=" + eachInterfaceAddress.getNetworkPrefixLength());
            }
            System.out.println();
        }
    }
}
