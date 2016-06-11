package uk.co.summermadness.sm16;

import android.app.Application;
import android.widget.Toast;

import com.batch.android.Batch;
import com.batch.android.Config;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import uk.co.summermadness.sm16.MainActivity;

/**
 * Created by Stephen on 10/06/2016.
 */


//For Batch:
// Here's what should go in your Application class, as Batch's setup should be called once, so it should go in your Application class' onCreate() method.
public class SmApp extends Application
// For user notification settings (eg.vibrate, noise,etc) to be updated in your app immediately:  implements SharedPreferences.OnSharedPreferenceChangeListener
{
    // Base class for maintaining global application state. You can provide your own implementation by creating a subclass and specifying the fully-qualified name of this subclass as the "android:name" attribute in your AndroidManifest.xml's <application> tag. The Application class, or your subclass of the Application class, is instantiated before any other class when the process for your application/package is created.
    // Note: There is normally no need to subclass Application. In most situations, static singletons can provide the same functionality in a more modular way. If your singleton needs a global context (for example to register broadcast receivers), include Context.getApplicationContext() as a Context argument when invoking your singleton's getInstance() method.

    // See demo Batch app:  https://github.com/BatchLabs/android-sdk/blob/master/Sample_Project/sample/app/src/main/java/com/batch/android/sample/BatchSampleApplication.java

    @Override
    public void onCreate()
    {
        super.onCreate();

       // Build.VERSION.RELEASE will give you the actual numbers of your version; aka 2.3.3 or 2.2. The problem with using Build.VERSION.SDK_INT is if you have a rooted phone or custom rom, you could have a none standard OS (aka my android is running 2.3.5) and that will return a null when using Build.VERSION.SDK_INT so Build.VERSION.RELEASE will work no matter what!

        if ( (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) // As Batch needs Sdk 9 or above
                //&& checkPlayServices()
                ) { // Needs working version of Google play services.
//            int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable( getApplicationContext() );
//            if(status == ConnectionResult.SUCCESS) {
                //OK
//            }else if(status == ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED){
//                Toast.makeText(context,"please udpate your google play service", Toast.LENGTH_SHORT).show
//            }
//            else {GooglePlayServicesUtil.getErrorDialog(result, this, GOOGLE_PLAY_SERVICE_UPDATE_CODE).show();}

            try {
    Batch.Push.setGCMSenderId("728947298852");
    // TODO : switch to live Batch Api Key before shipping
    Batch.setConfig(new Config("DEV5758A8C3ACEBF5759F912925760")); // development
    // Batch.setConfig(new Config("5758A8C3AAFFD95A4737C42C303D47")); // live
}
catch (Exception e) {
    Toast.makeText(this,"please udpate your google play service", Toast.LENGTH_SHORT).show();
//            }
            }

        }
    }


}




