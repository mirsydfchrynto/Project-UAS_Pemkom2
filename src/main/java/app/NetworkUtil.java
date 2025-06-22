package app;

import java.io.IOException;
import java.net.InetAddress;

public class NetworkUtil {

    public static boolean isInternetAvailable() {
        try {
            InetAddress address = InetAddress.getByName("poltekharber.ac.id");
            return address.isReachable(2000); // timeout 2 detik
        } catch (IOException e) {
            return false;
        }
    }
}
