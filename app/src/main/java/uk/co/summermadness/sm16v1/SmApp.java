package uk.co.summermadness.sm16v1;

import android.app.Application;
import android.content.SharedPreferences;
//import android.preference.PreferenceManager;
//import android.util.Log;
//import android.widget.Toast;

// For Batch messenging:
//import com.batch.android.Batch;
//import com.batch.android.Config;
//import com.batch.android.PushNotificationType;


/**
 * Created by Stephen on 10/06/2016.
 */

// For Firebase Cloud Messenging (replaced Google cloud messenging)
// https://firebase.google.com/docs/cloud-messaging/
// Using FCM, you can notify a client app that new email or other data is available to sync. You can send notifications to drive user reengagement and retention. For use cases such as instant messaging, a message can transfer a payload of up to 4KB to a client app.
// FCM includes the Notifications console, which you can use to send notifications to client apps.
// Firebase Notifications is built on Firebase Cloud Messaging and shares the same FCM SDK for client development
    
//For Batch:
// Here's what should go in your Application class, as Batch's setup should be called once, so it should go in your Application class' onCreate() method.
public class SmApp extends Application implements SharedPreferences.OnSharedPreferenceChangeListener
// For user notification settings (eg.vibrate, noise,etc) to be updated in your app immediately:  implements SharedPreferences.OnSharedPreferenceChangeListener
{
    // Base class for maintaining global application state. You can provide your own implementation by creating a subclass and specifying the fully-qualified name of this subclass as the "android:name" attribute in your AndroidManifest.xml's <application> tag. The Application class, or your subclass of the Application class, is instantiated before any other class when the process for your application/package is created.
    // Note: There is normally no need to subclass Application. In most situations, static singletons can provide the same functionality in a more modular way. If your singleton needs a global context (for example to register broadcast receivers), include Context.getApplicationContext() as a Context argument when invoking your singleton's getInstance() method.

    // See demo Batch app:  https://github.com/BatchLabs/android-sdk/blob/master/Sample_Project/sample/app/src/main/java/com/batch/android/sample/BatchSampleApplication.java

    // From: https://github.com/BatchLabs/android-sdk/blob/master/Sample_Project/sample/app/src/main/java/com/batch/android/sample/BatchSampleApplication.java
    private static final String TAG = "Sm16Application";

    //private static final String PREF_NOTIF_ALERT = "notifications_alert";
    //private static final String PREF_NOTIF_SOUND = "notifications_sound";
    //private static final String PREF_NOTIF_VIBRATE = "notifications_vibrate";
    //private static final String PREF_NOTIF_LIGHTS = "notifications_lights";


    @Override
    public void onCreate()
    {
        super.onCreate();

// These Notification preference settings were for Batch
        //PreferenceManager.setDefaultValues(this, R.  xml.settings_notification, false);

        // BUT these notification settings maybe internal to that Batch app, rather than Android.
        // Subscribe to notification changes so that changes in NotificationSettingsActivity
        // are automatically reflected in Batch immediately
        //PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
        // Batch.Push.setSmallIconResourceId(R.drawable.ic_notification_icon);
        //updateNotificationSettings();

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

/*
            try {
// The setConfig function should be called only once during your application lifetime to set up the SDK. If you work with one activity, you can add it to the onCreate of that Activity, otherwise the onCreate of your Application will function properly as well.
// Although later says: Be sure to setup Batch Config and Push related configurations in your Application onCreate, not in an Activity. This is important because when you receive a notification, your activity may not be initialized.
// So I think if batch config in an activity, activity needs to start and run for whole duration of the program.
    Batch.Push.setGCMSenderId("728947298852");
    // TODO : switch to live Batch Api Key before shipping
// You'll find the API keys needed to set up the SDK in Batch's settings (Settings → Integration):
    Batch.setConfig(new Config("DEV5758A8C3ACEBF5759F912925760")); // development
    // Batch.setConfig(new Config("5758A8C3AAFFD95A4737C42C303D47")); // live
}
catch (Exception e) {
    Toast.makeText(this,"please udpate your google play service", Toast.LENGTH_SHORT).show();
//            }
            }
*/

        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
//            updateNotificationSettings();
    }

    private void updateNotificationSettings()
        {
/*
            Log.i(TAG, "Updating Batch notification settings");

            final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

            EnumSet<PushNotificationType> pushNotificationTypes = EnumSet.allOf(PushNotificationType.class);

            if (!prefs.getBoolean(PREF_NOTIF_ALERT, true))
            {
                // Removing ALERT is enough, no sound or vibration will be emitted.
                pushNotificationTypes.remove(PushNotificationType.ALERT);
            }
            if (!prefs.getBoolean(PREF_NOTIF_SOUND, true))
            {
                pushNotificationTypes.remove(PushNotificationType.SOUND);
            }
            if (!prefs.getBoolean(PREF_NOTIF_VIBRATE, true))
            {
                pushNotificationTypes.remove(PushNotificationType.VIBRATE);
            }
            if (!prefs.getBoolean(PREF_NOTIF_LIGHTS, true))
            {
                pushNotificationTypes.remove(PushNotificationType.LIGHTS);
            }

            Batch.Push.setNotificationsType(pushNotificationTypes);
*/
        }

}




