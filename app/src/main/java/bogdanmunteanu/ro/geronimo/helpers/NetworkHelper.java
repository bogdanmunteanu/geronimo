package bogdanmunteanu.ro.geronimo.helpers;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Bogdan on 3/12/2018.
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
