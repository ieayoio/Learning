import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ieayoio on 2017/3/7.
 */
public class GetIP {

    /**
     * 获取用户的Ip和主机名
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: "+addr.getHostAddress());
                String hostname = addr.getHostName();
        System.out.println("Local host name: "+hostname);
    }
}
