package chapter3.networkinterface;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class SupportMulticasts {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
        while (networkInterface.hasMoreElements()) {
            NetworkInterface eachNetworkInterface = networkInterface.nextElement();
            System.out.println("getName获得网络设备名称:" + eachNetworkInterface.getName());
            System.out.println("getDisplayName获得网络设备显示名称：" + eachNetworkInterface.getDisplayName());
            System.out.println("supportMulticast是否支持多地址广播：" + eachNetworkInterface.supportsMulticast());
        }
    }

}
