package bogdanmunteanu.ro.geronimo.helpers;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Bogdan Munteanu
 * Helper class for determining connection state of the device
 * <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 */

public class NetworkHelper {

        public static boolean isNetworkAvailable(Activity context) {
            final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
            if (connectivityManager == null) {
                return false;
            }
            return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
        }
}
