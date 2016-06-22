package uk.co.summermadness.sm16;

//  If your organization has a firewall that restricts the traffic to or from the Internet, you need to configure it to allow connectivity with FCM in order for your Firebase Cloud Messaging client apps to receive messages. The ports to open are: 5228, 5229, and 5230. FCM typically only uses 5228, but it sometimes uses 5229 and 5230. FCM doesn't provide specific IPs, so you should allow your firewall to accept outgoing connections to all IP addresses contained in the IP blocks listed in Google's ASN of 15169.

// Batch (push notifications) is compatible with Android 2.3 and higher.

// Batch - Advanced - Intercepting notifications: https://batch.com/doc/android/advanced/intercepting-notifications.html

// Batch.Push : Unable to use GCM because the Google Play Services library is not integrated correctly or not up-to-date. Please include GooglePlayServices into your app (at least -base and -gcm modules), more info: https://batch.com/
// In gradle.build
// Can see latest versions at: dir C:\Users\HP\AppData\Local\Android\sdk\extras\google\m2repository\com\google\android\gms\play-services
// Error:Execution failed for task ':app:processDebugManifest'.
//> Manifest merger failed : uses-sdk:minSdkVersion 7 cannot be smaller than version 9 declared in library [com.google.android.gms:play-services-base:9.0.0] C:\Users\HP\AndroidStudioProjects\sm16\app\build\intermediates\exploded-aar\com.google.android.gms\play-services-base\9.0.0\AndroidManifest.xml
//        Suggestion: use tools:overrideLibrary="com.google.android.gms.base" to force usage
// I think could test the os version, and only call Batch if 2.3 or greater:

//        String myVersion = android.os.Build.VERSION.RELEASE; // e.g. "2.3"
//        int sdkVersion   = android.os.Build.VERSION.SDK_INT; // e.g. 8

// int currentapiVersion = android.os.Build.VERSION.SDK_INT;
//if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP){
//        // Do something for lollipop and above versions
//        } else{
//        // do something for phones running an SDK before lollipop
//        }
// NOTE: This SDK_INT is available since Donut (android 1.6 / API4)

// Some web APIs support sending the API_KEY through a HTTP header to prevent snooping. This improves security, since an API key sent via the URL can be snooped even though the request is a HTTPS request.
// http://www.androidauthority.com/use-remote-web-api-within-android-app-617869/

//String manufacturer = Build.MANUFACTURER;
//        String model = Build.MODEL;
//        int version = Build.VERSION.SDK_INT;
//        String versionRelease = Build.VERSION.RELEASE;


//import android.app.ActionBar;
import android.app.Application;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
//import android.app.Activity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
//import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Collections;
import java.util.List;
//import android.support.v7.app.ActionBar; // when using the Support Library, see: https://developer.android.com/topic/libraries/support-library/setup.html
// when using the support library be sure to use the ProGuard tool for your APK for release, as it removes unused libraries so smaller app.

import uk.co.summermadness.sm16.SmDataArray;

// To retrieve the app version number (set in build.gradle Module:app) use the getPackageInfo(java.lang.String, int) method of PackageManager
// Imports for Batch:
// import com.batch.android.Batch;

// Check for Google Play - used by batch and GCM and ?Firebase messenging:
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

// For Firebase cloud messenging (has replaced Google cloud messenging)
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

// SQLite database access:
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

// DB actions are:
//   - create database - using data from array.
//   - update data from web (or notification messages) removing any viewed mark from updated rows.
//   - mark row as viewed by user (and update the touched table cell as non-bold)
//   - maintain version info in table - for all versions downloaded to check all received
//   - keep a version number in each row - so don't revert to earlier version
// - Read all 'Contents' rows & colours
// - Read Title for specified content (page number)
// - Read text & image_id for the specified title (line number)
// DB structure:
  //ID, Type/page_code
  // index on page+line which is unique row id



//import com.batch.android.Config;
//import com.batch.android.PushNotificationType;

/* I could add a scroll around my text in my custom dialog, eg:
<ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView
        android:id="@+id/responseView"
        ....>
        </ScrollView>
*/

// See: https://developer.android.com/training/basics/network-ops/connecting.html#http-client


//public class HttpExampleActivity extends Activity {
//    private static final String DEBUG_TAG = "HttpExample";
//    private EditText urlText;
//    private TextView textView;

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
  //      urlText = (EditText) findViewById(R.id.myUrl);
        //textView = (TextView) findViewById(R.id.myText);
//    }
//======




/*
=====================
// The following methods maybe depreciated:
@Override
protected String doInBackground(String... urls) {
        String response = "";
        for (String url : urls) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
        HttpResponse execute = client.execute(httpGet);
        InputStream content = execute.getEntity().getContent();

        BufferedReader buffer = new BufferedReader(
        new InputStreamReader(content));
        String s = "";
        while ((s = buffer.readLine()) != null) {
        response += s;
        }

        } catch (Exception e) {
        e.printStackTrace();
        }
        }
        return response;
        }

@Override
protected void onPostExecute(String result) {
        textView.setText(Html.fromHtml(result));
        }
        }

public void readWebpage(View view) {
        DownloadWebPageTask task = new DownloadWebPageTask();
        task.execute(new String[] { "http://www.google.com" });

        }
        }


======





        This is the code I generally use to download a string from the internet

class RequestTask extends AsyncTask<String, String, String>{

    @Override
// username, password, message, mobile
    protected String doInBackground(String... url) {
        // constants
        int timeoutSocket = 5000;
        int timeoutConnection = 5000;

        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
        HttpClient client = new DefaultHttpClient(httpParameters);

        HttpGet httpget = new HttpGet(url[0]);

        try {
            HttpResponse getResponse = client.execute(httpget);
            final int statusCode = getResponse.getStatusLine().getStatusCode();

            if(statusCode != HttpStatus.SC_OK) {
                Log.w("MyApp", "Download Error: " + statusCode + "| for URL: " + url);
                return null;
            }

            String line = "";
            StringBuilder total = new StringBuilder();

            HttpEntity getResponseEntity = getResponse.getEntity();

            BufferedReader reader = new BufferedReader(new InputStreamReader(getResponseEntity.getContent()));

            while((line = reader.readLine()) != null) {
                total.append(line);
            }

            line = total.toString();
            return line;
        } catch (Exception e) {
            Log.w("MyApp", "Download Exception : " + e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        // do something with result
    }
}

new RequestTask().execute("http://www.your-get-url.com/");
=====

        HttpGet httppost = new HttpGet("http://www.urlOfThePageYouWantToRead.nl/text.txt");
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity ht = response.getEntity();

        BufferedHttpEntity buf = new BufferedHttpEntity(ht);

        InputStream is = buf.getContent();


        BufferedReader r = new BufferedReader(new InputStreamReader(is));

        StringBuilder total = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
        total.append(line + "\n");
        }

        TextView.setText(total);But need background thread or async
=====================
        new GetStringFromUrl().execute("http://www.google.com/");

        new GetStringFromUrl().execute("http://www.google.com/");



        I had to make 'textView' a member of the class and link it through the constructor, because 'findViewById' is not accessable in a AsyncTask. For the rest, works like a charm! – Jonathan V Dec 22 '14 at


==

==================
        Here is a cleaner version to fetch the output of a script from the web:

public String getOnline(String urlString) {
        URLConnection feedUrl;
        try {
        feedUrl = new URL(urlString).openConnection();
        InputStream is = feedUrl.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != null) {
        sb.append(line + "");
        }
        is.close();

        return sb.toString();

        }catch(Exception e){
        e.printStackTrace();
        }

        return null;
        }

        And remember that you cannot download anything from the main thread. It has to be from a separate thread. Use something like:

        new Thread(new Runnable(){
public void run(){

        if(!isNetworkAvailable()){
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.nointernet), Toast.LENGTH_LONG).show();
        return;
        }

        String str=getOnline("http://www.example.com/script.php");

        }
        }).start();
*/
// App launcher icon is from: https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html#foreground.type=image&foreground.space.trim=1&foreground.space.pad=0&foreColor=fff%2C100&crop=0&backgroundShape=square&backColor=293471%2C100&effects=none

// AppCompatActivity - Adds an application activity class that can be used as a base class for activities that use the Support Library action bar implementation.
// see: https://developer.android.com/topic/libraries/support-library/features.html
public class MainActivity extends AppCompatActivity {
//public class MainActivity extends Activity {

    private Toolbar toolbar = null; // Setting to null as way of indicating app not created.
    private ListView listView = null;
    private List<Integer> ids=null, unreads=null, goings=null;
    private List<String> chapters=null, items=null;
    private ArrayAdapter<String> adapter;
    private Dialog dialog = null;
    static final String DBNAME = "sm16db";
    private SQLiteDatabase db = null;
    boolean keepdbopen = true; // To keep db open until this Activites' onDestroy()

    private int lastNotificationId = 0;

    static final String STATE_CURRENT_PAGE = "current_page";

    private static final String TAG = "MainActivity";

    // Defined Array values to show in ListView. (Should use a constructor function).
    // Can store the data in separate class in a separte file (which can be written by python)
    //static final String[][][] data;
    // private final static
    // Can this be modified:
    String[][] data = SmDataArray.data;

    // or in an XML resource file, that is imported in onCreate
    // Can only store One dimensional arrays in arrays.xml resource. Could use JSON within each element, but need to use code for any spaces within the text.
    // data = getResources().getStringArray(R.array.data);
    // could use:
    // ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource (Context context, int textArrayResId, int textViewResId);
    // which Creates a new ArrayAdapter from external resources. The content of the array is obtained through getTextArray(int).
    // See: https://developer.android.com/reference/android/widget/ArrayAdapter.html


    static final int iNone=-2, iContents=-1, iWelcome = 0, iInfo = 1, iVenues = 2, iSpeakers = 3, iFriday = 4, iSaturday = 5, iSunday = 6, iMonday = 7, iWhatNext = 8, iInbox = 9;
    int iCurrent = iNone; // iWelcome; // Start on the welcome page.
    private String current_chapter="", current_title="", current_detail_title="", current_detail_text="";
    private int current_detail_position_in_array = -1, current_detail_rowid = -1, current_detail_unread = -1, current_detail_going = -1;
    int current_detail_image = -1; // or long

    //boolean viewing_a_page = false; // For the onBack() button so when going to a page pops back - should really use another activity for the contents view.

/*
    // static final String STATE_SCORE = "playerScore";
    // static final String STATE_LEVEL = "playerLevel";
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // https://developer.android.com/training/basics/activity-lifecycle/recreating.html
        // When your activity is destroyed because the user presses Back or the activity finishes itself, the system's concept of that Activity instance is gone forever because the behavior indicates the activity is no longer needed. However, if the system destroys the activity due to system constraints (rather than normal app behavior), then although the actual Activity instance is gone, the system remembers that it existed such that if the user navigates back to it, the system creates a new instance of the activity using a set of saved data that describes the state of the activity when it was destroyed. The saved data that the system uses to restore the previous state is called the "instance state" and is a collection of key-value pairs stored in a Bundle object.
        // *** Caution: Your activity will be destroyed and recreated each time the user rotates the screen. When the screen changes orientation, the system destroys and recreates the foreground activity because the screen configuration has changed and your activity might need to load alternative resources (such as the layout).

        // By default, the system uses the Bundle instance state to save information about each View object in your activity layout (such as the text value entered into an EditText object). So, if your activity instance is destroyed and recreated, the state of the layout is restored to its previous state with no code required by you. However, your activity might have more state information that you'd like to restore, such as member variables that track the user's progress in the activity.
        // Note: In order for the Android system to restore the state of the views in your activity, each view must have a unique ID, supplied by the android:id attribute.
        // To save additional data about the activity state, you must override the onSaveInstanceState() callback method. The system calls this method when the user is leaving your activity and passes it the Bundle object that will be saved in the event that your activity is destroyed unexpectedly. If the system must recreate the activity instance later, it passes the same Bundle object to both the onRestoreInstanceState() and onCreate() methods.

            // Save the user's current game state
            //savedInstanceState.putInt(STATE_SCORE, mCurrentScore);
            //savedInstanceState.putInt(STATE_LEVEL, mCurrentLevel);
        savedInstanceState.putInt(STATE_CURRENT_PAGE, iCurrent);

        // Can also use fragments to: https://developer.android.com/guide/topics/resources/runtime-changes.html

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        // mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
        // mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
        iCurrent = savedInstanceState.getInt(STATE_CURRENT_PAGE);
        showAlertDialog(MainActivity.this, "onRestoreState", "iCurrent="+String.valueOf(iCurrent), false);
        if ((iCurrent<0) || (iWelcome>=data.length)) {
            showAlertDialog(MainActivity.this, "onRestoreState out of range", "data.length="+String.valueOf(data.length), false);
            iCurrent=iWelcome;
        }
    }
*/


    private boolean checkPlayServices() {
        // For more info see: https://developers.google.com/android/guides/api-client#handle_connection_failures

        // More examples: http://www.programcreek.com/java-api-examples/index.php?class=com.google.android.gms.common.ConnectionResult&method=startResolutionForResult

        // Request code to use when launching the resolution activity
        // private static
        final int PLAY_SERVICES_RESOLUTION_REQUEST = 1001; // or 1972 ???

        // Check for Google Play Services APK
        // Apps that rely on the Play Services SDK should always check the device for a compatible Google Play services APK before accessing Google Play services features. It is recommended to do this in two places: in the main activity's onCreate() method, and in its onResume() method. The check in onCreate() ensures that the app can't be used without a successful check. The check in onResume() ensures that if the user returns to the running app through some other means, such as through the back button, the check is still performed. If the device doesn't have a compatible Google Play services APK, your app can call GooglePlayServicesUtil.getErrorDialog() to allow users to download the APK from the Google Play Store or enable it in the device's system settings. For a code example, see Setting up Google Play Services.
        // See: http://developer.android.com/google/play-services/setup.html

        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(this);
        if (result == ConnectionResult.SUCCESS) {
            return true;
        }
//        if(googleAPI.isUserResolvableError(result)) {
        googleAPI.getErrorDialog(MainActivity.this, result, PLAY_SERVICES_RESOLUTION_REQUEST).show();
        // wait for onActivityResult call (see below)??
//            }
//        else{
        Toast.makeText(getApplicationContext(), googleAPI.getErrorString(result), Toast.LENGTH_LONG).show();
        // public Task<Void> makeGooglePlayServicesAvailable (Activity activity)
        //showAlertDialog(MainActivity.this, "Google play services ...", googleAPI.getErrorString(result), false);
//        }
        return false;
    }

/*
    // ====================================================================================
// Batch (push notifications)
    @Override
    protected void onStart() {
        super.onStart();

        int sdk_version = android.os.Build.VERSION.SDK_INT; // NOTE: This SDK_INT is available since Donut (android 1.6 / API4), previously SDK
        if ((android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) // As Batch needs Sdk 9 or above
                && checkPlayServices()) {   // Needs working version of Google play services.
            try {
                Batch.onStart(this);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "On batch start() please udpate your google play service", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStop() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
            Batch.onStop(this);
        }
        super.onStop();
    }
*/
    @Override
    protected void onDestroy() {
        // https://developer.android.com/reference/android/app/Activity.html#onDestroy()
        // "Note: do not count on this method being called as a place for saving data! For example, if an activity is editing data in a content provider, those edits should be committed in either onPause() or onSaveInstanceState(Bundle), not here. This method is usually implemented to free resources like threads that are associated with an activity, so that a destroyed activity does not leave such things around while the rest of its application is still running. There are situations where the system will simply kill the activity's hosting process without calling this method (or any others) in it, so it should not be used to do things that are intended to remain around after the process goes away. "
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
    //      Batch.onDestroy(this);
        }
        if ((db!=null) && db.isOpen()) {db.close();} // Close the database.
        super.onDestroy();
    }
/*
    @Override
    protected void onNewIntent(Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
            Batch.onNewIntent(this, intent);
        }
        super.onNewIntent(intent);
    }

    // https://batch.com/doc/android/advanced/general.html#_custom-push-implementation
    // If you have your own implementation of GCM push you may have conflicts with Batch Push. GCM broadcasts the push intent to all broadcast receivers so if you send a push via Batch, your own broadcast receiver will also catch it.
    // To avoid conflict, we provide a helper to detect if a push will be handled by Batch or not, here's how you should implement your own push receiver:
    // BUT I think this is for GCMBroadcastReceiver. onReceive() ie. google cloud messenging, not for firebase cloud messenging
    //@Override
    //public void onReceive(Context context, Intent intent) {
    //    if (Batch.Push.isBatchPush(intent)) {
    //        return;
    //    }
        // Your push implementation
    //}
*/

// ====================================================================================
// My Network pull functions:

    private static final String DEBUG_TAG = "HttpExample";


    // First check if there is a network connection:
    public boolean getDataFromURL(String stringUrl) {
        // Gets the URL from the UI's text field.
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new DownloadWebpageTask().execute(stringUrl);
            return true; // Just means that have connections, but the web result is returned later via Async
        } else {
            showAlertDialog(MainActivity.this, "No connection", "No network connection available.", false);
            return false;
        }
    }

    // Uses AsyncTask to create a task away from the main UI thread. This task takes a
    // URL string and uses it to create an HttpUrlConnection. Once the connection
    // has been established, the AsyncTask downloads the contents of the webpage as
    // an InputStream. Finally, the InputStream is converted into a string, which is
    // displayed in the UI by the AsyncTask's onPostExecute method.
    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {

// Optionally:
//        protected void onPreExecute() {
//            progressBar.setVisibility(View.VISIBLE);
//            responseView.setText("");
//        }

        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
// Optionally:
//                if(response == null) {
//                    response = "THERE WAS AN ERROR";
//                }
//                progressBar.setVisibility(View.GONE);
//                Log.i("INFO", response);
//                responseView.setText(response);
//            }
            if (!appendToFile(result)) {
                showAlertDialog(MainActivity.this, "Append failed", "Append to file failed", false);
            }
/*
            *** Need to fix this code to work with the database:

            showAlertDialog(MainActivity.this, "HTTP result:", result, false);
            boolean update_view = false;
            if (!result.equals("FAILED")) {//  When limit is negative (egt. -1), split(regex, limit), the behaviour of removing trailing blanks from the resulting array is disabled: ".".split("\\.", -1) // returns an array of two blanks, ie ["", ""]
                String[] lines = result.split("\\r?\\n"); // To split on Windows (\r\n) or unix (\n), as is a regexp where \r is optional.
                for (int i = 0; i < lines.length; i++) {  // or: for(String line : lines) {
                    if (lines[i].equals("")) {
                        continue;
                    } // eg. empty line after newline at end of file
                    String[] cols = lines[i].split("\\t"); // one \ is ok as is escaped to tab ?
                    if ((cols.length == 0) || (cols[0].equals(""))) {
                        continue;
                    } // length==0 shouldn't happen?
                    else if (cols[0].equals("END")) {
                        showAlertDialog(MainActivity.this, "found END ok", "Found END in line: " + lines[i], false);
                    } // record that end was found ?
                    else if (cols[0].equals("MAIL")) {
                        showAlertDialog(MainActivity.this, "found MAIL ok", "Found MAIL in line: " + lines[i], false);
                        data[iInbox][2] = cols;
                        if (iCurrent == iInbox) {
                            update_view = true;
                        }
                    } // append to the mail list. Need to add all cols.
                    else {
                        showAlertDialog(MainActivity.this, "Slitting line into nums", "Splitting into nums: '" + cols[0] + "' in line: " + lines[i], false);
                        String[] nums = cols[0].split("\\."); // as expects a regexp, and first \ escapes the second \
                        if (nums.length == 2) {
                            int page = -1, line = -1;
                            try {
                                page = Integer.parseInt(nums[0]);
                            } catch (Exception e) { // raise error
                                showAlertDialog(MainActivity.this, "ParseInt", "Parse page num failed for " + nums[0] + " in line: " + lines[i], false);
                            }
                            try {
                                line = Integer.parseInt(nums[1]);
                            } catch (Exception e) { // raise error
                                showAlertDialog(MainActivity.this, "ParseInt", "Parse line num failed for " + nums[1] + " in line: " + lines[i], false);
                            }
                            if ((page > 0) && (page < data.length)) {
                                if ((line > 0) && (line < data[page].length)) {
                                    data[page][line] = cols;
                                    if (iCurrent == page) {
                                        update_view = true;
                                    }
                                } else {// error msg.
                                    showAlertDialog(MainActivity.this, "Line out of range", "Line " + Integer.toString(line) + " in line: " + lines[i], false);
                                }
                            } else { // error msg.
                                showAlertDialog(MainActivity.this, "Page out of range", "Page " + Integer.toString(page) + " in line: " + lines[i], false);
                            }
                        } else {// alert error
                            showAlertDialog(MainActivity.this, "Nums != 2", "nums.length != 2 in " + nums + " in line: " + lines[i], false);
                        }
                    }
                }
                if (update_view) {
                    setListView(iCurrent, current_page_num, current_title);
                } // as the lines have changed or mail lines added so can't just do:  adapter.notifyDataSetChanged();
            }

            //textView.setText();

// However, there is the equally straightforward (and built into android) org.json package. To parse the returned string into a JSONObject can be achieved with the following code snippet.
//            try {
//                JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
//                String requestID = object.getString("requestId");
//                int likelihood = object.getInt("likelihood");
//                JSONArray photos = object.getJSONArray("photos");
//                ....
//            } catch (JSONException e) {
//                // Appropriate error handling code
//            }

*/
        }
    }

    // Given a URL, establishes an HttpUrlConnection and retrieves
    // the web page content as a InputStream, which it returns as
    // a string.
    private String downloadUrl(String myurl) throws IOException {
        HttpURLConnection conn = null;
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        //int len = 500;
        String contentAsString = "FAILED";

        // Work around pre-Froyo (pre-Android 2.2) bugs in HTTP connection reuse.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.FROYO) { // depreciated: if(Integer.parseInt(Build.VERSION.SDK)<...
            System.setProperty("http.keepAlive", "false");
        }

        try {
            URL url = new URL(myurl);
            conn = (HttpURLConnection) url.openConnection();
            // HttpURLConnection will follow up to five HTTP redirects. It will follow redirects from one origin server to another. This implementation doesn't follow redirects from HTTPS to HTTP or vice versa.
            // If the HTTP response indicates that an error occurred, getInputStream() will throw an IOException. Use getErrorStream() to read the error response. The headers can be read in the normal way using getHeaderFields(),
            // From: https://developer.android.com/reference/java/net/HttpURLConnection.html
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d(DEBUG_TAG, "The response is: " + response);
            if (response == 200) { // 200 OK
                // 304 Not Modified (RFC 7232) - Indicates that the resource has not been modified since the version specified by the request headers If-Modified-Since or If-None-Match. In such case, there is no need to retransmit the resource since the client still has a previously-downloaded copy.[28]

                is = conn.getInputStream();

                // Convert the InputStream into a string
                contentAsString = readIt(is); // , len);
            } else {
                showAlertDialog(MainActivity.this, "Response " + Integer.toString(response), conn.getResponseMessage(), false);
                // getResponseMessage()
                // else conn.getErrorStream()
            }
// or:
//        }
//        catch(Exception e) {
//            Log.e("ERROR", e.getMessage(), e);
//            return null;
//        }
// See: http://www.androidauthority.com/use-remote-web-api-within-android-app-617869/

            // Make sure that the InputStream is closed after the app has finished using it.
        } finally {
            if (is != null) {
                is.close();
            }  // should try try { ..} catch (IOException e) {...}
            if (conn != null) {
                conn.disconnect();
            }
            // To reduce latency, this class may reuse the same underlying Socket for multiple request/response pairs. As a result, HTTP connections may be held open longer than necessary. Calls to disconnect() may return the socket to a pool of connected sockets. This behavior can be disabled by setting the http.keepAlive system property to false before issuing any HTTP requests.
        }
        return contentAsString;
    }


    // An InputStream is a readable source of bytes. Once you get an InputStream, it's common to decode or convert it into a target data type. For example, if you were downloading image data, you might decode and display it like this:
    // InputStream is = null;
    // ...
    // Bitmap bitmap = BitmapFactory.decodeStream(is);
    // ImageView imageView = (ImageView) findViewById(R.id.image_view);
    // imageView.setImageBitmap(bitmap);


    // In the example shown above, the InputStream represents the text of a web page. This is how the example converts the InputStream to a string so that the activity can display it in the UI:
// Reads an InputStream and converts it to a String.
    public String readIt(InputStream stream) throws IOException, UnsupportedEncodingException {   // , int len)
        //Reader reader = null;
        //reader = new InputStreamReader(stream, "UTF-8");
        //char[] buffer = new char[len];
        //reader.read(buffer);
        //return new String(buffer);

// BUT for reading more data can use: http://www.androidauthority.com/use-remote-web-api-within-android-app-617869/
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream, "UTF-8")); // (new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (Exception e) {  // would be  (IOException e) {
            return "FAILED";
        }
//        finally{
//            urlConnection.disconnect();
//        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*
        Add this line to your manifest :-

android:configChanges="orientation|keyboard|keyboardHidden|screenSize|screenLayout|uiMode"
(although screenSize is only needed for Android 3.2+
and this snippet to the activity :-
// see: https://developer.android.com/guide/topics/resources/runtime-changes.html

@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

- See more at: http://www.mzan.com/article/456211-activity-restart-on-rotation-android.shtml#sthash.KbTc9Spl.dpuf
*/
        // However if you want to permanently store the data you would have to use SharedPreferences and SQLite database.

        super.onCreate(savedInstanceState);
// onSaveInstanceState is used to store data only for application lifetime (i.e. temporarily)

        // When this happens, onSaveInstanceState(Bundle outstate) will be called and it's up to your app to add any state data you want to save in outstate.
        // When the user resumes your Activity, onCreate(Bundle savedInstanceState) gets called and savedInstanceState will be non-null if your Activity was terminated in a scenario described above. Your app can then grab the data from savedInstanceState and regenerate your Activity's state to how it was when the user last saw it.
        // Basically in onCreate, when savedInstanceState is null, then it means this is a 'fresh' launch of your Activity. And when it's non-null (if your app saved the data in onSaveInstanceState(...), it means the Activity state needs to be recreated.

        // The data is held in memory only until the application is alive, in other words this data is lost when the application closes, so in your case when you force close the app onSaveInstanceState is not used.
        // from: http://stackoverflow.com/questions/9846817/when-is-the-savedinstancestate-bundle-actually-used
        // showAlertDialog(MainActivity.this, "In onCreate()", "Starting onCreate now", false);
        if (toolbar != null) {
            showAlertDialog(MainActivity.this, "OK", "Toolbar already created", false);
            return;
        } // As don't want to recreate ListView when device orientation changes.

        // null check not really needed - but just in case...
        if (savedInstanceState == null) {
            //showAlertDialog(MainActivity.this, "State null", "State null", false);
            // initUi();
            //  See more at: http://www.mzan.com/article/456211-activity-restart-on-rotation-android.shtml#sthash.KbTc9Spl.dpuf
            //return;
        }

        //data[0][0] = new String[]{"0.0", "Changed!"};

//  android:configChanges="orientation|keyboard|keyboardHidden|screenSize|screenLayout|uiMode"

        // NOTIFICATION NOT NEEDED AT PRESENT: showNotification("My Notify", "Starting app", 1);
        //showAlertDialog(MainActivity.this, "add_array_to_database()", "Calling", false);
        add_array_to_database();

        //showAlertDialog(MainActivity.this, "initialise_user_interface()", "Calling", false);
        initialise_user_interface(savedInstanceState);

        //showAlertDialog(MainActivity.this, "firebase_cloud_messenging()", "Calling", false);

        //int sdk_version = android.os.Build.VERSION.SDK_INT; // NOTE: This SDK_INT is available since Donut (android 1.6 / API4), previously SDK
        if ((android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) // As Batch needs Sdk 9 or above
                && checkPlayServices()) {   // Needs working version of Google play services.
            //try {
                firebase_cloud_messenging();
            //    Batch.onStart(this);
            //} catch (Exception e) {
            //    Toast.makeText(getApplicationContext(), "On batch start() please udpate your google play service", Toast.LENGTH_SHORT).show();
            //}
        }

        //  urlText = (EditText) findViewById(R.id.myUrl);
        //  urlText.getText().toString();
        //String stringUrl = "http://google.com";
        //getDataFromURL(stringUrl);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) { // As Batch needs Sdk 9 or above
             checkPlayServices();   // Needs working version of Google play services - should check this in onCreate and onResume (ie. back button pressed from another app).
        }
    }


    protected void set_current_detail_to_read()
    {
        if (current_detail_unread != 0) {
            set_page_column_in_db(current_detail_rowid, "unread", 0);
            unreads.set(current_detail_position_in_array, 0);
            current_detail_unread = 0;
            adapter.notifyDataSetChanged();
        }
    }

    protected void set_current_detail_to_going(int going)
    {
        if (current_detail_going != going) {
            set_page_column_in_db(current_detail_rowid, "going", going);
            goings.set(current_detail_position_in_array, going);
            current_detail_going = going;
            adapter.notifyDataSetChanged();
        }
    }


    protected void initialise_user_interface(Bundle savedInstanceState) {
        //showAlertDialog(MainActivity.this, "initialise_user_interface()", "initialise_user_interface", false);
        setContentView(R.layout.activity_main);


/*
        // ===========================================================================
        // Good toolbar example code: http://stackoverflow.com/questions/26651602/display-back-arrow-on-toolbar-android
        // especially the last two answers:

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }


    You can still use the AppCompatActivity, you don't need to stop using it just so that you can use a <android.support.v7.widget.Toolbar> in your xml. Just turn off the action bar style as follows:

    First, derive a style from one of the NoActionBar themes that you like in your styles.xml, I used Theme.AppCompat.Light.NoActionBar like so:

    <style name="SuperCoolAppBarActivity" parent="Theme.AppCompat.Light.NoActionBar">
    <item name="colorPrimary">@color/primary</item>

    <!-- colorPrimaryDark is used for the status bar -->
    <item name="colorPrimaryDark">@color/primary_dark</item>
            ...
            ...
    </style>

    In your App's manifest, choose the child style theme you just defined, like so:

    <activity
    android:name=".activity.YourSuperCoolActivity"
    android:label="@string/super_cool"
    android:theme="@style/SuperCoolAppBarActivity">
    </activity>

    In your Activity Xml, if the toolbar is defined like so:

            ...
    <android.support.v7.widget.Toolbar
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
            />
            ...

    Then, and this is the important part, you set the support Action bar to the AppCompatActivity that you're extending, so that the toolbar in your xml, becomes the action bar. I feel that this is a better way, because you can simply do the many things that ActionBar allows, like menus, automatic activity title, item selection handling, etc. without resorting to adding custom click handlers, etc.

    In your Activity's onCreate override, do the following:

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_cool);
        findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        //Your toolbar is now an action bar and you can use it like you always do, for example:
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    // ===========================================================================
*/
        // Toolbar seems better than ActionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar == null) {
            showAlertDialog(MainActivity.this, "Error", "Failed to find the Toolbar", false);
            return;
        }

        toolbar.setTitle("SM16"); // To change title later, need to set initial title before setSupportActionbar(), or in the activity_main.xml toolbar as: app:title="SM16"
        // see: http://stackoverflow.com/questions/26486730/in-android-app-toolbar-settitle-method-has-no-effect-application-name-is-shown

        setSupportActionBar(toolbar);

        // Set initial list capacity to 30 (default is 10):
        ids = new ArrayList<Integer>(30); // is the ids for the items that correspond to the lines in the ListView table
        chapters = new ArrayList<String>(30); // could optionally pass the number of elements?
        items = new ArrayList<String>(30); // could optionally pass the number of elements?
        unreads = new ArrayList<Integer>(30);
        goings = new ArrayList<Integer>(30);
        //clear the actual results
        // ids.clear();
        // items.clear();

        ///  Collections.addAll(items, data[iWelcome]); // Collections.addAll() might be faster than items.addAll(welcome) ?
        // public static <T> boolean addAll(Collection<? super T> c, T... elements)
        // Adds all of the specified elements to the specified collection. Elements to be added may be specified individually or as an array. The behavior of this convenience method is identical to that of c.addAll(Arrays.asList(elements)), but this method is likely to run significantly faster under most implementations.
        //   iCurrent = iWelcome;
        // or use a ResourceCursorAdapter to use xml files: https://developer.android.com/reference/android/widget/ResourceCursorAdapter.html
        // ResourceCursorAdapter(Context context, int layout, Cursor c, int flags)
        // then use: setViewResource(layout )

        // Define a new Adapter with parameters: Context, Layout for the row, ID of the TextView to which the data is written, Array of data
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
        // simple_list_item_1
        // simple_list_item_activated_1
        // simple_expandable_list_item_1
        // https://developer.android.com/reference/android/R.layout.html
        // Using the standard supplied layout simple_list_item1. You can create your own layouts and we will see how this is done in a moment.
        // To create own layout: http://www.i-programmer.info/programming/android/7849-android-adventures-listview-and-adapters.html?start=1

        // To change the text colour programmably:
        // From: http://stackoverflow.com/questions/4533440/android-listview-text-color

        // Can specify this in several ways: https://developer.android.com/reference/android/widget/ArrayAdapter.html
        // "By default this class expects that the provided resource id references a single TextView. If you want to use a more complex layout, use the constructors that also takes a field id. That field id should reference a TextView in the larger layout resource.
        // However the TextView is referenced, it will be filled with the toString() of each object in the array. You can add lists or arrays of custom objects. Override the toString() method of your objects to determine what text will be displayed for the item in the list.
        // To use something other than TextViews for the array display, for instance, ImageViews, or to have some of data besides toString() results fill the views, override getView(int, View, ViewGroup) to return the type of view you want.


        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items){
            // Could make a custom layout for the table rows, see: http://stackoverflow.com/questions/5564789/change-listviews-textcolor
            // or:  http://stackoverflow.com/questions/18903735/how-to-change-the-text-color-of-a-listview-item

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);
                // OR create layout if not given a cached one:
                // View row = convertView;
                //if(row==null){
                //    LayoutInflater inflater=getLayoutInflater();
                //    row=inflater.inflate(R.layout.row, parent, false);
                //}

                TextView textView=(TextView) view.findViewById(android.R.id.text1);
            /*YOUR CHOICE OF COLOR*/
                // && (position<unreads.size() ass ume is correct.
                if (iCurrent>iContents) { // This assumes iCurrent is set BEFORE the ListView is displayed!
                    textView.setTextColor(unreads.get(position)==0 ? Color.BLACK : Color.BLUE);
                    view.setBackgroundColor(goings.get(position)==0 ? Color.WHITE : Color.CYAN);
                }
                else {
                    textView.setTextColor(Color.BLACK);
                    view.setBackgroundColor(Color.WHITE);
                }

// I could also set an icon if the layout has an image view, eg: http://android-er.blogspot.co.uk/2010/06/using-convertview-in-getview-to-make.html
//                ImageView icon=(ImageView)row.findViewById(R.id.icon);
//                if (month[position]=="December"){
//                    icon.setImageResource(R.drawable.icon);
//                }
//                else{
//                    icon.setImageResource(R.drawable.icongray);
//                }

                return view;
            }
        };
        /*SET THE ADAPTER TO LISTVIEW*/
        // setListAdapter(adapter);



        //data = SmDataArray.data;

        if (iCurrent==iNone) {setListView(iContents);} // will initially be the iContents

        // Get ListView from XML:
        listView = (ListView) findViewById(R.id.listView);

        //showAlertDialog(MainActivity.this, "Test", "Test dialog again", false);

        //showAlertDialog(MainActivity.this, "Test", "Test dialog again",false);

        // Assign adapter to ListView
        if (listView == null) {
            showAlertDialog(MainActivity.this, "Error", "Failed to find the ListView", false);
            return;
        }
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView Clicked item index:
                //  int itemPosition = position;

                // ListView Clicked item value
                //String  itemValue = (String) listView.getItemAtPosition(position);

                // Could also do:
                // ((TextView)v).setText("selected"); to set the colour of the text

                //and can scroll to a position in the list using:
                //myList.setSelection(position);
                //where position is the zero based position of the item in the list and you can scroll to show any item using
                // myList.smoothScrollToPosition(position);
                Log.d("ListView", "position="+Integer.toString(position)+"chapters.size="+Integer.toString(chapters.size()));
                //showAlertDialog(MainActivity.this, "Position", "position="+Integer.toString(position)+"chapters.size="+Integer.toString(chapters.size()), false);

                if (iCurrent == iContents) {
                    if (position >= chapters.size()) {showAlertDialog(MainActivity.this, "Position out of range", "position="+Integer.toString(position)+" >= size="+Integer.toString(chapters.size()), false);}
                    setListView(position);
                    return;
                }
                // Show Alert:
/*
                int line_index = position +1; // +1 as the first element in data[iCurrent] is the title for that page.

                String[] line = data[iCurrent][line_index];
                String title = (line.length>1 ? line[1] : ""); // as 0 is the page.line (eg. "1.2")
                String message = (line.length>2) ? "\n"+line[2] : "";
                int image_id = -1;
                if (line.length>3) {
                    String image_id_string = line[3];
                    try {
                        image_id = Integer.parseInt(image_id_string);
                    } catch (NumberFormatException nfe) {
                        showAlertDialog(MainActivity.this, "Error", "Could not parse image_id_string to an integer:" + image_id_string, false);
                    }
                }
*/
/*
                switch (line.length) {
                    case 2: break;
                    case 3:
                        message = "\n"+line[2];
                        break;
                    case 4:
                        String image_id_string = line[3];
                        try {
                            image_id = Integer.parseInt(image_id_string);
                        } catch(NumberFormatException nfe) {
                            showAlertDialog(MainActivity.this, "Error", "Could not parse image_id_string to an integer:"+image_id_string, false);
                        }
                        message = "\n"+line[2];
                        break;
                    default: message="More columns than expected!";
                }
*/

//                showCustomDialog(MainActivity.this, title, message, image_id);

                //showAlertDialog(MainActivity.this, "Position", "position="+Integer.toString(position)+"ids.size="+Integer.toString(ids.size()), false);
                //showAlertDialog(MainActivity.this, "get_details", "position="+Integer.toString(position)+"id=="+Integer.toString(ids.get(position)), false);
                if (get_details_from_database(ids.get(position))) {
                    //showAlertDialog(MainActivity.this, "got_details", "position="+Integer.toString(position)+"id=="+Integer.toString(ids.get(position)), false);
                    current_detail_position_in_array = position; // Useful for the Next button
                    showCustomDialog(MainActivity.this, current_detail_title, current_detail_text, current_detail_image);
                    // should maybe do the following before showing the custom dialog, in case person hit Next very quickly, so would move to next detail - but maybe that is ok.
                    set_current_detail_to_read(); // Uses the current_detail_unread, current_detail_rowid and current_detail_position_in_array
                }

//                Toast toast = Toast.makeText(getApplicationContext(),
//                         title + message + "\nImage: "+String.valueOf(image_id),
////                        "Position :"+position+"  ListItem : " +itemValue ,
//                        Toast.LENGTH_LONG
//                );
//                toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0,0);
//                toast.show();

                // Alternatively: AppCompatDialog - Adds a dialog class that can be used as a base class for AppCompat themed dialogs.
                }

            });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }



public void add_array_to_database() {
    // See: https://developer.android.com/training/basics/data-storage/databases.html
    // Good info about using sqlite in Android: http://stackoverflow.com/questions/433392/how-do-i-use-prepared-statements-in-sqlite-in-android
    eg:
    //String sql = "UPDATE table_name SET column_2=? WHERE column_1=?";
    //SQLiteStatement statement = db.compileStatement(sql);
    //int id = 7;
    //String stringValue = "hi there";
    //statement.bindString(1, stringValue);
    //statement.bindLong(2, id);
    // int numberOfRowsAffected = statement.executeUpdateDelete();
    //showAlertDialog(MainActivity.this, "add_array_to_database()", "Starting", false);

    if (( db == null) || !db.isOpen()) {
        // The following is from Context (as another ordering of these arguments in class Database)
        db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
        // or: db = dbHelper.getWritabledatabase();
    }
    int dataVersion = SmDataArray.dataVersion;
    if (db.getVersion() == dataVersion) {return;}

    showAlertDialog(MainActivity.this, "Recreating database", "Current db.getVersion()="+Integer.toString(db.getVersion())+", but SmDataArray.dataVersion="+Integer.toString(dataVersion), false);
    // execSQL(..) returns void (ie. nothing), but raises exception on error:
    db.execSQL("DROP TABLE IF EXISTS chapter;");    // just for developing
    db.execSQL("DROP TABLE IF EXISTS page;");    // just for developing
    // Sqlite databases also have a 'rowid' field for fast access - "Searching for a record with a specific rowid, or for all records with rowids within a specified range is around twice as fast as a similar search made by specifying any other PRIMARY KEY or indexed value."
    db.execSQL("CREATE TABLE IF NOT EXISTS chapter(chapter TEXT, version INT, title TEXT, colour TEXT, unread INT);");
    db.execSQL("CREATE TABLE IF NOT EXISTS page(page TEXT, version INT, chapter TEXT, title TEXT, detail TEXT, image INT, unread INT, going INT);");
// *** add fields for version and viewed.
// *** add index on type for faster search, and on primary on id.
    // editRollno.getText()

    try {
        db.beginTransaction();
        SQLiteStatement sql_chapter = db.compileStatement("INSERT INTO chapter (chapter,version,title,colour,unread) VALUES(?,?,?,?,1);");
        SQLiteStatement sql_page = db.compileStatement("INSERT INTO page (page,version,chapter,title,detail,image,unread,going) VALUES(?,?,?,?,?,?,1,0);");
        // String stm = "INSERT INTO page VALUES('" + line[0] + "','C', '" + line[1] + "','" + line[2] + "', '');"
        String chapter = "";
        for (int i = 0; i < data.length; i++) {
            String[] line = data[i];

            if (line.length < 3) {showAlertDialog(MainActivity.this, "Data incomplete", "Line id="+(line.length>1 ? line[0] : "")+" has less than three columns", false); continue;}
            if (line.length != 4) {showAlertDialog(MainActivity.this, "Data not fully complete", "Line id="+(line.length>1 ? line[0] : "")+" has less than four columns", false);}

            String page = line[0];  // eg: "1" for Welcome chapter, or "1.02" for a page in the Welcome chapter.
            // Log.d("DB", "ID: " + line[0]);
            // eg: {"1", "Welcome", "red"},
            int dot_position = page.indexOf('.');

            if (dot_position == -1) {
                chapter = page;
                sql_chapter.bindString(1, chapter);   // id. Note these bindString(...) indexes are 1-based positions.
                sql_chapter.bindLong(2, dataVersion); // version of the data to enable updates to this record later.
                sql_chapter.bindString(3, line[1]);  // title
                sql_chapter.bindString(4, line[2]);  // colour
                long rowId = sql_chapter.executeInsert();
            }
            else {
                long image_id = -1;
                if ( (line.length > 3) && !line[3].equals("") ) {
                    String image_id_string = line[3];
                    try {
                        image_id = Integer.parseInt(image_id_string);
                    } catch (NumberFormatException nfe) {
                        showAlertDialog(MainActivity.this, "Error", "Could not parse image_id_string to an integer:" + image_id_string, false);
                    }
                }
                if (!page.substring(0, dot_position).equals(chapter)) // the second param of substring() is the end index exclusive.
                {
                    showAlertDialog(MainActivity.this, "DB create error", "Page: '" + page +"' starts with: '"+ page.substring(0, dot_position) +"' doesn't match chapter: '" + chapter + "' for title='" + line[1] + "'", false);
                }

                sql_page.bindString(1, page);      // id. Note these bindString(...) indexes are 1-based positions.
                sql_page.bindLong(2, dataVersion); // version of the data to enable updates to this record later.
                sql_page.bindString(3, chapter);   // chapter - is foreign key to the chapter table.
                sql_page.bindString(4, line[1]);   // title
                sql_page.bindString(5, line[2]);   // detail
                sql_page.bindLong(6, image_id);    // image
                // stm.bindAllArgsAsStrings(new String[]{line[0], "C", line[1], line[2], ""}); // BUT needs API 11, I've set minTarget to 7
                // db.execSQL("INSERT INTO page VALUES('" + line[0] + "',+"', '" + title + "','" + detail + "', '" +image+ "');");
                long rowId = sql_page.executeInsert();
            }
        }

        db.setTransactionSuccessful();
    } catch (Exception e) {
        Log.w("Exception:", e);
    } finally {
        db.endTransaction();
    }

    db.setVersion(SmDataArray.dataVersion);
    if (!keepdbopen) {db.close(); db = null;} // =null to indicate that it is closed.

    // db.execSQL("UPDATE student SET name='" + editName.getText() + "',marks='" +
    //        editMarks.getText() + "' WHERE rollno='" + editRollno.getText() + "'");

    // In the above code, the openOrCreateDatabase() function is used to open the StudentDB database if it exists or create a new one if it does not exist.
    // The first parameter of this function specifies the name of the database to be opened or created.
    // The second parameter, Context.MODE_PRIVATE indicates that the database file can only be accessed by the calling application or all applications sharing the same user ID.
    // The third parameter is a Cursor factory object which can be left null if not required.
    //showAlertDialog(MainActivity.this, "add_array_to_database()", "Finished", false);
}



    protected void add_notification_to_inbox(String title, String detail)
    {
        // In case the first notification processing occurs before the database is created:
        add_array_to_database();
        if (( db == null) || !db.isOpen()) {
            // The following is from Context (as another ordering of these arguments in class Database)
            db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
            // or: db = dbHelper.getWritabledatabase();
        }
        // Maybe wrap in a transaction, but just autocommit for now.
        // In future set message page, eg: 3.02, etc and version.
        SQLiteStatement sql_page = db.compileStatement("INSERT INTO page (page,version,chapter,title,detail,image,unread,going) VALUES(?,?,?,?,?,?,1,0);");
        sql_page.bindString(1, SmDataArray.inboxChapter);   // + subpage id, eg: 3.02   // id. Note these bindString(...) indexes are 1-based positions.
        sql_page.bindLong(2, 1); // version of the data to enable updates to this record later.
        sql_page.bindString(3, SmDataArray.inboxChapter);   // chapter - is foreign key to the chapter table.
        sql_page.bindString(4, title);    // title
        sql_page.bindString(5, detail);   // detail
        sql_page.bindLong(6, -1);         // image
        // stm.bindAllArgsAsStrings(new String[]{line[0], "C", line[1], line[2], ""}); // BUT needs API 11, I've set minTarget to 7
        // db.execSQL("INSERT INTO page VALUES('" + line[0] + "',+"', '" + title + "','" + detail + "', '" +image+ "');");
        long rowId = sql_page.executeInsert();

    }


    public void get_contents_from_database(List<String> chapters, List<String> items)
    {
        if ((db==null) || !db.isOpen()) {
            // The following is from Context (as another ordering of these arguments in class Database)
            db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
        }
        // NOTE: The rawQuery() SQL string must NOT be terminated with a semicolon:
        Cursor c = db.rawQuery("SELECT chapter, title FROM chapter ORDER BY chapter", null);
        if (c.moveToFirst()) do {
            chapters.add(c.getString(0)); // chapter, eg: "1" for Welcome
            items.add(c.getString(1));    // title, eg: "Welcome"
        } while (c.moveToNext());
        c.close(); // close the cursor.
        if (!keepdbopen) {db.close(); db = null;} // =null to indicate that it is closed.
    }


    public void get_chapter_from_database(String chapter, List<Integer> ids, List<String> items, List<Integer> unreads, List<Integer> goings)
    {
        //showAlertDialog(MainActivity.this, "get_chapter_from_database()", "chapter="+chapter, false);
        // chapter will "1", "2", etc for the chapters.
        if ((db==null) || !db.isOpen()) {
        // The following is from Context (as another ordering of these arguments in class Database)
        db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
        }

        // for parameterised queries, can use db.query(...)
        // Using the faster rowid here:
        // NOTE: The rawQuery() SQL string must NOT be terminated with a semicolon:
        Cursor c = db.rawQuery("SELECT rowid, title, unread, going FROM page WHERE chapter=? ORDER BY page", new String[]{chapter});
        if (c.moveToFirst()) do {
            ids.add(c.getInt(0)); // data[i][0][0] is the number, eg: "1.00"
            items.add(c.getString(1)); // data[i][0][0] is the number, eg: "1.00"
            unreads.add(c.getInt(2)); // if page is unread so far.
            goings.add(c.getInt(3));
        } while (c.moveToNext()); // returns false when past end of data

        //showAlertDialog(MainActivity.this, "got_chapter_from_database()", "chapter="+chapter, false);
        c.close();
        if (!keepdbopen) {db.close(); db = null;} // =null to indicate that it is closed.
    }

    public boolean get_details_from_database(int rowid)
    {
        boolean result;
        if ((db==null) || !db.isOpen()) {
            // The following is from Context (as another ordering of these arguments in Database)
            db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
        }
        //showAlertDialog(MainActivity.this, "get_details_from_database()", "rowid="+Integer.toString(rowid), false);
        // for parameterised queries, can use db.query(...) Quotes around the ? aren't needed:
        Cursor c = db.rawQuery("SELECT title, detail, image, unread, going FROM page WHERE rowid="+Integer.toString(rowid), null );

        if ( c.moveToFirst() && (c.getCount() == 1) ) { // Should never be more than 1 as using rowid. If row was deleted in background sync then would be missing this page.
            current_detail_rowid=rowid;
            current_detail_title=c.getString(0);
            current_detail_text=c.getString(1);
            current_detail_image=c.getInt(2); // or getLong(2)
            current_detail_unread=c.getInt(3); // or getLong(3)
            current_detail_going=c.getInt(4); // or getLong(4)
            //showAlertDialog(MainActivity.this, "got_details_from_database()", "rowid="+Integer.toString(rowid)+" current_detail_title="+current_detail_title, false);
            result = true;
        }
        else {
            showAlertDialog(MainActivity.this, "DB get_detail", "select count (="+Integer.toString(c.getCount())+") != 1 for rowid="+Integer.toString(rowid), false);
            result= false;
        }
        c.close();
        if (!keepdbopen) {db.close(); db = null;} // =null to indicate that it is closed.
        return result;
    }


    public boolean set_page_column_in_db(int rowid, String column, int newValue)
    {
        if ((db==null) || !db.isOpen()) {
            // The following is from Context (as another ordering of these arguments in class Database)
            db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
        }
        ContentValues values = new ContentValues();
        values.put(column,newValue);
        // I'm assumming autocommit, otherwise need to wrap this update inside a transaction:
        int num_updated = db.update("page", values, "rowid=" + Integer.toString(rowid), null); // Tried "_id=" instead of "rowid=", but crashed with message: android.database.sqlite.SQLiteException: no such column: _id (code 1): , while compiling: UPDATE page SET unread=? WHERE _id=40

        if (num_updated!=1) {showAlertDialog(MainActivity.this, "set_page_column_in_db("+column+", "+Integer.toString(rowid)+")", "num_updated (="+Integer.toString(num_updated)+") != 1", false);}

        if (!keepdbopen) {db.close(); db = null;} // =null to indicate that it is closed.
        return (num_updated==1);
    }
/*
Can add Helper class, eg:
    // From: http://www.techotopia.com/index.php/An_Android_Studio_SQLite_Database_Tutorial
    public class MyDBHandler extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "productDB.db";
        private static final String TABLE_PRODUCTS = "products";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_PRODUCTNAME = "productname";
        public static final String COLUMN_QUANTITY = "quantity";

        public MyDBHandler(Context context, String name,
                           SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {

        }

    }

    Next, the onCreate() method needs to be implemented so that the products table is created when the database is first initialized. This involves constructing a SQL CREATE statement containing instructions to create a new table with the appropriate columns and then passing that through to the execSQL() method of the SQLiteDatabase object passed as an argument to onCreate():

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_PRODUCTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PRODUCTNAME
                + " TEXT," + COLUMN_QUANTITY + " INTEGER" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    The onUpgrade() method is called when the handler is invoked with a greater database version number from the one previously used. The exact steps to be performed in this instance will be application specific, so for the purposes of this example we will simply remove the old database and create a new one:

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    All that now remains to be implemented in the MyDBHandler.java handler class are the methods to add, query and remove database table entries.
    The Add Handler Method

    The method to insert database records will be named addProduct() and will take as an argument an instance of our Product data model class. A ContentValues object will be created in the body of the method and primed with key-value pairs for the data columns extracted from the Product object. Next, a reference to the database will be obtained via a call to getWritableDatabase() followed by a call to the insert() method of the returned database object. Finally, once the insertion has been performed, the database needs to be closed:

    public void addProduct(Product product) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.getProductName());
        values.put(COLUMN_QUANTITY, product.getQuantity());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PRODUCTS, null, values);

        db.close();
    }

    ===
*/

@Override
public void onBackPressed() {

    if ( (iCurrent>iContents) && (listView!=null) && (listView.hasWindowFocus()) ) {
        // To go back to Contents if currently viewing the chapters.
        // instead of listView.hasWindowFocus() could test if dialog.isShowing() or alertDialog is showing ....but maybe menu options have effect.
        setListView(iContents);
//    dialog.setOnDismissListener(
//     viewing_a_page = true;
//    dialog.onbackPressed();

// add a popView() function to maintain stact of activities;
//   ( dialog!=null) && (dialog.isShowing()) (alertDialog.... )
//        dialog.setOnDismissListener(
    }
    else {
        super.onBackPressed(); // so closes the dialog or closes the app.
    }
}

    // Icons: https://design.google.com/icons/
    //** Back arrow: http://stackoverflow.com/questions/14545139/android-back-button-in-the-title-bar
    // *** Providing Up Navigation: https://developer.android.com/training/implementing-navigation/ancestral.html

    // R.drawable.abc_ic_ab_back_mtrl_am_alpha f
    // Please note that getResources().getDrawable(...) is deprecated. You should use ContextCompat.getDrawable(context, ...) instead



// **** GOOD: Toolbar v7 support: https://developer.android.com/reference/android/support/v7/widget/Toolbar.html

public void set_back_button(boolean setback) {
// From: https://developer.android.com/reference/android/support/v7/widget/Toolbar.html
// setNavigationContentDescription (CharSequence description)

//        void setNavigationIcon (Drawable icon)  or void setNavigationIcon (int resId)
//        Set the icon to use for the toolbar's navigation button.
//        The navigation button appears at the start of the toolbar if present. Setting an icon will make the navigation button visible.
//        If you use a navigation icon you should also set a description for its action using setNavigationContentDescription(int). This is used for accessibility and tooltips.

//        void setNavigationOnClickListener (View.OnClickListener listener)
//        Set a listener to respond to navigation events.
//        This listener will be called whenever the user clicks the navigation button at the start of the toolbar. An icon must be set for the navigation button to appear.

// **** GOOD Info on toolbar and drawer: http://stackoverflow.com/questions/28263643/tool-bar-setnavigationonclicklistener-breaks-actionbardrawertoggle-functionality
    if (setback) {
        //Toolbar t = activity.getToolbar();
        toolbar.setNavigationContentDescription("Back to main Contents menu"); // for users with poor eyesigh, that user readers.
        toolbar.setNavigationIcon(R.drawable.   ic_arrow_back_white_48dp);  // or void setNavigationIcon (int resId)

        //toggle.setToolbarNavigationClickListener(new View.OnClickListener() {

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For future - a better way would be using a parent activity: https://developer.android.com/training/implementing-navigation/ancestral.html
                onBackPressed();
                // dialog.dismiss();  //                popBackStackToTop(mHostingActivity);
            }
        });
    } else {
        toolbar.setNavigationIcon(null);  // or void setNavigationIcon (int resId)
        toolbar.setNavigationOnClickListener(null); // probably not needed as button not visible so not clickable
    }
}

public void firebase_cloud_messenging()
    {
        // If a notification message is tapped, any data accompanying the notification
        // message is available in the intent extras. In this sample the launcher
        // intent is fired when the notification is tapped, so any accompanying data would
        // be handled here. If you want a different intent fired, set the click_action
        // field of the notification message to the desired intent. The launcher intent
        // is used when no click_action is specified.
        //
        // Handle possible data accompanying notification message.
        // [START handle_data_extras]
        if(getIntent().getExtras() != null)
        {
            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);
                Log.d(TAG, "Key: " + key + " Value: " + value);
                // In future could add message id and version info, so can replace previous messages.
                add_notification_to_inbox(key,value);
            }
        }
        // [END handle_data_extras]

        //Button subscribeButton = (Button) findViewById(R.id.subscribeButton);
        //assert subscribeButton != null;
        //subscribeButton.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick (View v){
        // [START subscribe_topics]

        // "Developers can choose any topic name that matches the regular expression: "/topics/[a-zA-Z0-9-_.~%]+" or "[a-zA-Z0-9-_.~%]{1,900}".

        // *** Good info here on how to send notifications from your own app server: https://firebase.google.com/docs/cloud-messaging/topic-messaging#sending_topic_messages_from_the_serverv
        FirebaseMessaging.getInstance().subscribeToTopic("all");
        // FirebaseMessaging.getInstance().subscribeToTopic("news");

        // To unsubscribe, the client app calls Firebase Cloud Messaging unsubscribeFromTopic() with the topic name.

        // Other topics could use include:  teens, site_team, security, etc ......

        Log.d(TAG, "Subscribed to topic 'all'");
        // [END subscribe_topics]
        //        }
        //});

        //Button logTokenButton = (Button) findViewById(R.id.logTokenButton);
        //assert logTokenButton != null;
        //logTokenButton.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick (View v){
        Log.d(TAG, "InstanceID token: " + FirebaseInstanceId.getInstance().getToken());
        //    }
        //});
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // An alternative to a toolbar is: a tabbed actionbar, but needs fragments, or SherlockActionBar: http://www.intertech.com/Blog/android-action-bar-from-the-options-menu/
        // Dated as 2013: https://www.lynda.com/Android-tutorials/Enabling-action-bar-all-versions-Android/122466/139482-4.html
        // ActionBarCompat: http://antonioleiva.com/actionbarcompat-how-to-use/

        // A search view:   http://antonioleiva.com/actionbarcompat-action-views/

        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu); // as super class may add extra system menu options
        getMenuInflater().inflate(R.menu.menu, menu); // to (optionally) use a resource file, "main.xml"
        /*
        // Can create items dynamically as below: http://www.101apps.co.za/articles/using-menus-in-your-apps-a-tutorial.html
        String title = "@string/action_register";
        int groupId = Menu.NONE; // can group menu items together so that you can make changes to the group; for example, you could set all the items in a group to invisible. Our item does not belong to a group so we pass the NONE constant
        int itemId = Menu.FIRST + menu.size(); // unique ID of the item. We use the constant for Menu.FIRST which is 1. You can use Menu.FIRST + 1 for the next item and so on. Or can use Menu.NONE if don't need an ID.
        int order = Menu.NONE; // or use getOrder() for the last item. eg. use 103 here so that this item follows item two (defined in the main.xml file) which has an order of 102. You can use Menu.NONE if the order of the items is not important
        menu.add(groupId, itemId, order, title);
        */
        return true; // return true so that the menu can be displayed
    }

   // ActionBar actionBar = getActionBar();
   // actionBar.setDisplayHomeAsUpEnabled(true);


    // "Beginning in Android 4.1 (API level 16), you can declare the logical parent of each activity by specifying the android:parentActivityName attribute in the <activity> element.

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // This hook is called whenever an item in your options menu is selected. The default implementation simply returns false to have the normal processing happen (calling the item's Runnable or sending a message to its Handler as appropriate). You can use this method for any items for which you would like to do processing without those other facilities.
        // Derived classes should call through to the base class for it to perform the default menu handling.hello

        int id = item.getItemId(); // could offset this item id to the array data index.
        // int index = -1; // index of the array
/*
        switch(id) {
            //noinspection SimplifiableIfStatement
            case android.R.id.home: setListView(iContents); break; // and turn off the back button.

            case R.id.action_previous: if (iCurrent>-1) {setListView(iCurrent-1);} break; // As -1 is the Contents page.
            case R.id.action_next:     if (iCurrent<data.length-1) {setListView(iCurrent+1);} break;
            case R.id.action_today:
                switch(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
                    case Calendar.FRIDAY:   setListView(iFriday);   break;
                    case Calendar.SATURDAY: setListView(iSaturday); break;
                    case Calendar.SUNDAY:   setListView(iSunday);   break;
                    case Calendar.MONDAY:   setListView(iMonday);   break;
                    //case Calendar.TUESDAY:  setListView(iTuesday);  break;
                    default:                setListView(iWelcome);  break;
                }
                break;
            case R.id.action_welcome:  setListView(iWelcome);  break;
            case R.id.action_info:     setListView(iInfo);     break;
            case R.id.action_venues:   setListView(iVenues);   break;
            case R.id.action_speakers: setListView(iSpeakers); break;
            case R.id.action_friday:   setListView(iFriday);   break;
            case R.id.action_saturday: setListView(iSaturday); break;
            case R.id.action_sunday:   setListView(iSunday);   break;
            case R.id.action_monday:   setListView(iMonday);   break;
            case R.id.action_whatnext: setListView(iWhatNext); break;
            case R.id.action_inbox:    setListView(iInbox); break;
            //case R.id.action_register:
            //case R.id.action_sync:
            //case R.id.action_settings:

            // or: startActivity(new Intent(this, CoursesActivity.class)); // see: http://www.intertech.com/Blog/android-action-bar-from-the-options-menu/
            //adapter.notifyDataSetChanged();

            default:
                // If don't recognise the menu item then the super class might have a handler for it:
                return super.onOptionsItemSelected(item);
        }
*/
        return true;
    }

    private boolean setListView(int array_index) { // }, int chapter, String page_title){
        // if (array_index == iCurrent) {return true;} // as can be reloading, eg if inbox messages have arrived.
        //showAlertDialog(MainActivity.this, "setListView()", "array_index="+Integer.toString(array_index), false);

        if (array_index<-1) {return false;}
        if ( (array_index!=-1) && ((chapters==null) || (array_index>=chapters.size()))) {return false;}

        //showAlertDialog(MainActivity.this, "setListView() 2", "array_index="+Integer.toString(array_index), false);

        if (array_index==-1) {
            current_chapter = "-1"; // or 0 or "C"
            current_title="SM16: Contents";
            chapters.clear();
            items.clear(); // The items visible in the Listview
            get_contents_from_database(chapters, items); // chapter -1 is the chapter table
            //for (int i = 0; i < data.length; i++) { // i starts at 1, as 0 is the title.
            //    // if pages within that section/chapter, then could add ' ...' to the line to indicate that can tap line to see detail.
            //    if ((data[i].length > 0) && (data[i][0].length > 1)) {
            //        items.add(data[i][0][1]); // data[i][0][0] is the number, eg: "1.00"
            //    }
            //}
        }
        else {
            // toolbar.setTitle(((lines.length > 0) && (lines[0].length > 1) ? lines[0][1] : "")); // "SM16: " +
            current_chapter = chapters.get(array_index); // is position);
            current_title = items.get(array_index);
            //showAlertDialog(MainActivity.this, "setListView() 3", "array_index="+Integer.toString(array_index)+" current_chapter="+current_chapter+" current_title="+current_title, false);
            ids.clear(); // the line ids that correspond to the titles in the itemns list
            items.clear();
            unreads.clear();
            goings.clear();
            get_chapter_from_database(current_chapter, ids, items, unreads, goings); // was: "P"+Integer.toString(array_index)
            //showAlertDialog(MainActivity.this, "setListView() 4", "ids="+Integer.toString(ids.size())+" items="+Integer.toString(items.size()), false);
            //String lines[][] = data[iCurrent];

            //   //Collections.addAll(items, data[array_index]); // Collections.addAll() might be faster than items.addAll(welcome) ?
            //for (int i = 1; i < lines.length; i++) { // i starts at 1, as 0 is the title.
            //    // if has detail text for the line, then add ' ...' to the line to indicate that can tap line to see detail.
            //    if (lines[i].length > 1) { // as lines[i][0] is just the row number
            //        items.add(lines[i].length > 2 ? lines[i][1] + " ..." : lines[i][1]); // lines[i][0] is the number, eg: "1.3"
            //    }
            //
            //}
        }

        iCurrent = array_index; // This iCurrent needs set before ListView is drawn (before adapter.notifyDataSetChanged()) as is used by ArrayAdapter's getView
        toolbar.setTitle(current_title); // "SM16: " +
        adapter.notifyDataSetChanged();
        set_back_button(iCurrent>iContents); // To enable the back button in the toolbar
        return true;
    }


    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);     // Set Title
        alertDialog.setMessage(message); // Set Message
        //alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);  // Set icon.
        // or eg: alert.setIcon(R.drawable.send); for an email icon

        // Set OK Button:
        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK",  // BUTTON_POSITIVE, BUTTON_NEGATIVE, or BUTTON_NEUTRAL
              new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int which) {
                      //  dialog.cancel();
                      // or:
                      dialog.dismiss();
              }
        });
        alertDialog.show();

/*
        //  More concise and maybe uses less memory:
        (new AlertDialog.Builder(context))
        .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setButton(DialogInterface.BUTTON_NEUTRAL, "Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                //insert other Alert Dialog Builder methods here
                .show();

        */
    }

    public boolean update_data_from_web() {
        String stringUrl = "http://sbridgett.github.io/sm16updates/update1.txt";
        return getDataFromURL(stringUrl); // Only returns false if cannot connect to web.
    }


    protected void set_custom_dialog_contents(Dialog dialog, String title, String message, int imageId) {
        // Could disable the Next button:
        Button nextButton = (Button) dialog.findViewById(R.id.nextbutton);
        nextButton.setEnabled(current_detail_position_in_array+1 < ids.size());

        Button goButton = (Button) dialog.findViewById(R.id.gobutton);
        goButton.setText(current_detail_going==0 ? " Mark " : "UnMark");

        dialog.setTitle(title);

        // set the custom dialog components - text, image and button
        //TextView titletext = (TextView) dialog.findViewById(R.id.title);
        //titletext.setText(title);

        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText(message);

        ImageView image = (ImageView) dialog.findViewById(R.id.image);
        if (imageId == -1) {
            // GONE removes the space, whereas Invisible keeps the empty space.
            image.setVisibility(View.GONE); // or: image .setVisibility(View.INVISIBLE);
        } else {
            image.setImageResource(imageId);  // for other image
            // image.setImageResource(R.drawable.rachel_hughes_130);  // for other image
            // image.setImageResource(R.mipmap.ic_launcher);
            image.setVisibility(View.VISIBLE);
        }
    }
/*
===========================
    <TextView
    android:id="@+id/mydialogtitle"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:textColor="@color/white"
    android:background="@color/black"
    android:textSize="20sp" />

    and add:

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.setContentView(R.layout.mydialog);
    TextView dialogTitle = (TextView) dialog.findViewById(R.id.mydialogtitle);
    dialogTitle.setText("My dialog title");
==================
// or popup window: http://virenandroid.blogspot.co.uk/2011/11/custom-popupwindow-android.html


//  This is better:  http://stackoverflow.com/questions/14439538/how-can-i-change-the-color-of-alertdialog-title-and-the-color-of-the-line-under
// or: http://stackoverflow.com/questions/820398/android-change-custom-title-view-at-run-time
// http://stackoverflow.com/questions/23006031/how-to-change-dialog-title-font-size
*/

    public void showCustomDialog(Context context, String title, String message, int imageId) {  // add image parameter
        //final Context context = this;
// Setting dialog title: http://stackoverflow.com/questions/9107054/android-alert-dialog-multi-line-title
        // custom dialog

        // was: final Dialog dialog = new Dialog(context);
        // now keeping a reference to dialog in the MainActivity class so can that is it is showing.
        if (dialog==null) {
            dialog = new Dialog(context);
            dialog.setContentView(R.layout.mydialog);

            TextView titleText = (TextView) dialog.findViewById(android.R.id.title);
            titleText.setSingleLine(false); // To enable multi-line title.

            Button okButton = (Button) dialog.findViewById(R.id.okbutton);
            // if button is clicked, close the custom dialog
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            Button nextButton = (Button) dialog.findViewById(R.id.nextbutton);
            // if button is clicked, show next in list:
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (current_detail_position_in_array+1 < ids.size())
                    {
                        if ( get_details_from_database(ids.get(current_detail_position_in_array+1)) ) {
                            current_detail_position_in_array++;
                            set_current_detail_to_read(); // Uses the current_detail_unread, current_detail_rowid and current_detail_position_in_array
                            set_custom_dialog_contents(dialog, current_detail_title, current_detail_text, current_detail_image);
                        }
                    }
                }
            });

/*
                    String stringUrl = "http://sbridgett.github.io/sm16updates/update1.txt";
                    getDataFromURL(stringUrl);
                    update_data_from_web();
*/

        }

        Button goButton = (Button) dialog.findViewById(R.id.gobutton);
        // if button is clicked, close the custom dialog
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button goButt = (Button) dialog.findViewById(R.id.gobutton);  // as complains if use goButton below:
                if (current_detail_going == 0) {
                    set_current_detail_to_going(1);
                    goButt.setText("UnMark");
                } else {
                    set_current_detail_to_going(0);
                    goButt.setText(" Mark ");
                }
            }
        });

        set_custom_dialog_contents(dialog, title, message, imageId);
        dialog.show();
    }


public boolean appendToFile(String str) {

    // Alternatively use a key-value store: https://developer.android.com/training/basics/data-storage/shared-preferences.html


    // calling getFreeSpace() or getTotalSpace(). These methods provide the current available space and the total space in the storage volume, respectively. This information is also useful to avoid filling the storage volume above a certain threshold.

//            However, the system does not guarantee that you can write as many bytes as are indicated by getFreeSpace(). If the number returned is a few MB more than the size of the data you want to save, or if the file system is less than 90% full, then it's probably safe to proceed. Otherwise, you probably shouldn't write to storage.

//    Note: You aren't required to check the amount of available space before you save your file. You can instead try writing the file right away, then catch an IOException if one occurs. You may need to do this if you don't know exactly how much space you need. For example, if you change the file's encoding before you save it by converting a PNG image to JPEG, you won't know the file's size beforehand

// Note: When the user uninstalls your app, the Android system deletes the following:
//  -  All files you saved on internal storage
//  -  All files you saved on external storage using getExternalFilesDir().
//    However, you should manually delete all cached files created with getCacheDir() on a regular basis and also regularly delete other files you no longer need.

    //Either use File:
    //File file;
    //try {
    //    file = new File(context.getFilesDir(), filename);
    //    catch (IOException e) {
    //        // Error while creating file
    //    }
    //    return file;

    // Alternatively, you can call openFileOutput() to get a FileOutputStream that writes to a file in your internal directory. For example, here 's how to write some text to a file:
    String datafilename = "sm16updates.txt";
    //String string = "Hello world!";
    FileOutputStream outputStream;

    try {
        // filename can not contain path separators:
        outputStream = openFileOutput(datafilename, Context.MODE_PRIVATE | Context.MODE_APPEND); // Throws FileNotFoundException
        // mode 	int: Operating mode. Use 0 or MODE_PRIVATE for the default operation, MODE_APPEND to append to an existing file, MODE_WORLD_READABLE and MODE_WORLD_WRITEABLE to control permissions.
// or: FileInputStream openFileInput (String name);  // Throws FileNotFoundException
//  in = new BufferedInputStream(new FileInputStream(file));
        // Use FileReader to read characters, as opposed to bytes, from a file.
// BufferedReader buf = new BufferedReader(new FileReader("file.java"));

        // BufferedWriter buf = new BufferedWriter(new FileWriter("file.java"));
        // write(String str, int offset, int count) // Writes count characters starting at offset in str to this writer.
//  FileWriter(File file, boolean append) // Creates a FileWriter using the File file.
//        finally {
//            if (in != null) {
//                in.close();
//            }
//        }
//    }

//    This stream is not buffered. Most callers should wrap this stream with a BufferedInputStream.

    // or test if file exists using: File file = new File(getExternalFilesDir(null), "DemoFile.jpg");
//        if (file != null) {
//            return file.exists();
//        }


        outputStream.write(str.getBytes());
        outputStream.close();
        return true;
    } catch (Exception e) {  // eg. maybe insufficient space left on device
        e.printStackTrace();
        return false;
    }
}

    public void showNotification(String title, String text, int priority) {
        // From: https://developer.android.com/guide/topics/ui/notifiers/notifications.html
// R.mipmap.ic_launcher

// Can add other options: http://www.tutorialspoint.com/android/android_notifications.htm
//        eg:   setTicker (CharSequence tickerText),  setVibrate (long[] pattern),  setAutoCancel (boolean autoCancel)

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                       .setSmallIcon(R.mipmap.ic_launcher) // // R.drawable.notification_icon
                       .setContentTitle(title)
                       .setContentText(text)
                       .setPriority(priority); // five priority levels, ranging from NotificationCompat.PRIORITY_MIN (-2) to PRIORITY_MAX (2); if not set, the priority defaults to PRIORITY_DEFAULT (0)
        // Creates an explicit intent for an Activity in your app
        // Could set this to another Activity class?
        Intent resultIntent = new Intent(this, MainActivity.class);

        // The stack builder object will contain an artificial back stack for the started Activity.
        // This ensures that navigating backward from the Activity leads out of your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        // Could set this to another Activity class?
        stackBuilder.addParentStack(MainActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // Just using lastNotificationId (if > 0) would allow you to update the last notification:
        mNotificationManager.notify(++lastNotificationId, mBuilder.build());
    }

}


