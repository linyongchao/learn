package my.learn.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * IpUtil
 *
 * @author
 * @return
 **/
public class IpUtil {

    private static final Logger log = LoggerFactory.getLogger(IpUtil.class);

    /**
     * Windows判断标准
     **/
    private static final String WIN = "windows";

    /**
     * 判断当前操作是否Windows.
     *
     * @return true---是Windows操作系统
     */
    public static boolean isWindows() {
        boolean isWindows = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf(WIN) > -1) {
            isWindows = true;
        }
        return isWindows;
    }

    /**
     * 获取本机IP地址，并自动区分Windows还是Linux操作系统
     *
     * @return String
     */
    public static String getLocalIp() {
        InetAddress ip;
        List<InetAddress> innerIpList = new ArrayList<>();
        try {
            // 如果是Windows操作系统
            if (isWindows()) {
                ip = InetAddress.getLocalHost();
                innerIpList.add(ip);
            } else {
                // 如果是Linux操作系统
                Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
                while (netInterfaces.hasMoreElements()) {
                    NetworkInterface ni = netInterfaces.nextElement();
                    // 遍历所有ip
                    Enumeration<InetAddress> ips = ni.getInetAddresses();
                    while (ips.hasMoreElements()) {
                        ip = ips.nextElement();
                        if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                                && ip.getHostAddress().indexOf(":") == -1) {
                            innerIpList.add(ip);
                            log.info("Register Service Ip=" + ip);
                        } else {
                            log.info("Skip Service Ip=" + ip);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("get local ip error:", e);
        }
        return innerIpList.size() > 0 ? innerIpList.get(0).getHostAddress() : "";
    }
}
