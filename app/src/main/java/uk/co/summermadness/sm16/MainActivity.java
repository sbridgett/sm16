package uk.co.summermadness.sm16;

// Batch (push notifications) is compatible with Android 2.3 and higher. .

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

import android.app.Application;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
//import android.app.Activity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Collections;
import java.util.List;
//import android.support.v7.app.ActionBar; // when using the Support Library, see: https://developer.android.com/topic/libraries/support-library/setup.html
// when using the support library be sure to use the ProGuard tool for your APK for release, as it removes unused libraries so smaller app.

import uk.co.summermadness.sm16.SmDataArray;

// To retrieve the app version number (set in build.gradle Module:app) use the getPackageInfo(java.lang.String, int) method of PackageManager
// Imports for Batch:
import com.batch.android.Batch;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
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
    private List<String> items;
    private ArrayAdapter<String> adapter;

    private int lastNotificationId = 0;

    static final String STATE_CURRENT_PAGE = "current_page";

    // Defined Array values to show in ListView. (Should use a constructor function).
    // Can store the data in separate class in a separte file (which can be written by python)
    //static final String[][][] data;
    private final static String[][][] data = SmDataArray.data;
    // or in an XML resource file, that is imported in onCreate
    // Can only store One dimensional arrays in arrays.xml resource. Could use JSON within each element, but need to use code for any spaces within the text.
    // data = getResources().getStringArray(R.array.data);
    // could use:
    // ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource (Context context, int textArrayResId, int textViewResId);
    // which Creates a new ArrayAdapter from external resources. The content of the array is obtained through getTextArray(int).
    // See: https://developer.android.com/reference/android/widget/ArrayAdapter.html


    static final int iWelcome=0, iInfo=1, iVenues=2, iSpeakers=3, iFriday=4, iSaturday=5, iSunday=6, iMonday=7, iTuesday=8, iWhatNext=9;
    int iCurrent=-1; // iWelcome; // Start on the welcome page.

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

        // Request code to use when launching the resolution activity
        // private static
        final int PLAY_SERVICES_RESOLUTION_REQUEST = 1001; // or 1972 ???

        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(this);
        if(result == ConnectionResult.SUCCESS) {return true;}
//        if(googleAPI.isUserResolvableError(result)) {
        googleAPI.getErrorDialog(MainActivity.this, result, PLAY_SERVICES_RESOLUTION_REQUEST).show();
        // wait for onActivityResult call (see below)??
//            }
//        else{
        Toast.makeText(getApplicationContext(), googleAPI.getErrorString(result), Toast.LENGTH_LONG).show();
        // public Task<Void> makeGooglePlayServicesAvailable (Activity activity)
        showAlertDialog(MainActivity.this, "Google play services ...", googleAPI.getErrorString(result), false);
//        }
        return false;
    }
// ====================================================================================
// Batch (push notifications)
    @Override
    protected void onStart()
    {
        super.onStart();

        int sdk_version = android.os.Build.VERSION.SDK_INT; // NOTE: This SDK_INT is available since Donut (android 1.6 / API4), previously SDK
        if ( (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) // As Batch needs Sdk 9 or above
                && checkPlayServices() ) {   // Needs working version of Google play services.
try {
    Batch.onStart(this);
}
catch (Exception e){
                Toast.makeText(getApplicationContext(), "On batch start() please udpate your google play service", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStop()
    {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
            Batch.onStop(this);
        }
        super.onStop();
    }

    @Override
    protected void onDestroy()
    {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
            Batch.onDestroy(this);
        }
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
            Batch.onNewIntent(this, intent);
        }
        super.onNewIntent(intent);
    }



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


            showAlertDialog(MainActivity.this, "HTTP result:", result, false);
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


        }
    }

    // Given a URL, establishes an HttpUrlConnection and retrieves
    // the web page content as a InputStream, which it returns as
    // a string.
    private String downloadUrl(String myurl) throws IOException {
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d(DEBUG_TAG, "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

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
            }
        }
    }



    // An InputStream is a readable source of bytes. Once you get an InputStream, it's common to decode or convert it into a target data type. For example, if you were downloading image data, you might decode and display it like this:
    // InputStream is = null;
    // ...
    // Bitmap bitmap = BitmapFactory.decodeStream(is);
    // ImageView imageView = (ImageView) findViewById(R.id.image_view);
    // imageView.setImageBitmap(bitmap);


    // In the example shown above, the InputStream represents the text of a web page. This is how the example converts the InputStream to a string so that the activity can display it in the UI:
// Reads an InputStream and converts it to a String.
    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
// BUT for reading more data can use: http://www.androidauthority.com/use-remote-web-api-within-android-app-617869/
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line).append("\n");
//            }
//            bufferedReader.close();
//            return stringBuilder.toString();
//        }
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
        showAlertDialog(MainActivity.this, "In onCreate()", "Starting onCreate now", false);
        if (toolbar != null) {
            showAlertDialog(MainActivity.this, "OK", "Toolbar already created", false);
            return;
        } // As don't want to recreate ListView when device orientation changes.

        // null check not really needed - but just in case...
        if (savedInstanceState == null) {
            showAlertDialog(MainActivity.this, "State null", "State null", false);
            // initUi();
            //  See more at: http://www.mzan.com/article/456211-activity-restart-on-rotation-android.shtml#sthash.KbTc9Spl.dpuf
            //return;
        }
//  android:configChanges="orientation|keyboard|keyboardHidden|screenSize|screenLayout|uiMode"

        // NOTIFICATION NOT NEEDED AT PRESENT: showNotification("My Notify", "Starting app", 1);
        initialise_user_interface(savedInstanceState);


        //  urlText = (EditText) findViewById(R.id.myUrl);
        //  urlText.getText().toString();
        //String stringUrl = "http://google.com";
        //getDataFromURL(stringUrl);
    }


    protected void initialise_user_interface(Bundle savedInstanceState) {
        showAlertDialog(MainActivity.this, "initialise_user_interface()", "initialise_user_interface", false);
        setContentView(R.layout.activity_main);

        // Toolbar seems better than ActionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar == null) {
            showAlertDialog(MainActivity.this, "Error", "Failed to find the Toolbar", false);
            return;
        }

        toolbar.setTitle("SM16"); // To change title later, need to set initial title before setSupportActionbar(), or in the activity_main.xml toolbar as: app:title="SM16"
        // see: http://stackoverflow.com/questions/26486730/in-android-app-toolbar-settitle-method-has-no-effect-application-name-is-shown

        setSupportActionBar(toolbar);

        items = new ArrayList<String>(); // could optionally pass the number of elements?
        //clear the actual results
        // items.clear();

        ///  Collections.addAll(items, data[iWelcome]); // Collections.addAll() might be faster than items.addAll(welcome) ?
        // public static <T> boolean addAll(Collection<? super T> c, T... elements)
        // Adds all of the specified elements to the specified collection. Elements to be added may be specified individually or as an array. The behavior of this convenience method is identical to that of c.addAll(Arrays.asList(elements)), but this method is likely to run significantly faster under most implementations.
        //   iCurrent = iWelcome;
        // or use a ResourceCursorAdapter to use xml files: https://developer.android.com/reference/android/widget/ResourceCursorAdapter.html
        // ResourceCursorAdapter(Context context, int layout, Cursor c, int flags)
        // then use: setViewResource(layout )

        // Define a new Adapter with parameters: Context, Layout for the row, ID of the TextView to which the data is written, Array of data
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
        // simple_list_item_1
        // simple_list_item_activated_1
        // simple_expandable_list_item_1
        // https://developer.android.com/reference/android/R.layout.html
        // Using the standard supplied layout simple_list_item1. You can create your own layouts and we will see how this is done in a moment.
        // To create own layout: http://www.i-programmer.info/programming/android/7849-android-adventures-listview-and-adapters.html?start=1

        //data = SmDataArray.data;

        if (iCurrent==-1) {setListView(iWelcome);} // or maybe initialise iCurent=iWelcome.

        // Get ListView from XML:
        ListView listView = (ListView) findViewById(R.id.listView);

        //showAlertDialog(MainActivity.this, "Test", "Test dialog again", false);

        showAlertDialog(MainActivity.this, "Test", "Test dialog again",false);

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

                // Show Alert:
                int line_index = position +1; // as the first element is the title for that page.
                String title = data[iCurrent][line_index][0];
                String message = "";
                int image_id = -1;
                switch (data[iCurrent][line_index].length) {
                    case 1: break;
                    case 2:
                        message = "\n"+data[iCurrent][line_index][1];
                        break;
                    case 3:
                        String image_id_string = data[iCurrent][line_index][1];
                        try {
                            image_id = Integer.parseInt(image_id_string);
                        } catch(NumberFormatException nfe) {
                            showAlertDialog(MainActivity.this, "Error", "Could not parse image_id_string to an integer:"+image_id_string, false);
                        }
                        message = "\n"+data[iCurrent][line_index][2];
                        break;
                }

                showCustomDialog(MainActivity.this, title, message, image_id);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // This hook is called whenever an item in your options menu is selected. The default implementation simply returns false to have the normal processing happen (calling the item's Runnable or sending a message to its Handler as appropriate). You can use this method for any items for which you would like to do processing without those other facilities.
        // Derived classes should call through to the base class for it to perform the default menu handling.hello

        int id = item.getItemId(); // could offset this item id to the array data index.
        // int index = -1; // index of the array
        switch(id) {
            //noinspection SimplifiableIfStatement

            case R.id.action_previous: if (iCurrent>0) {setListView(iCurrent-1);} break;
            case R.id.action_next:     if (iCurrent<data.length-1) {setListView(iCurrent+1);} break;
            case R.id.action_today:
                switch(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
                    case Calendar.FRIDAY:   setListView(iFriday);   break;
                    case Calendar.SATURDAY: setListView(iSaturday); break;
                    case Calendar.SUNDAY:   setListView(iSunday);   break;
                    case Calendar.MONDAY:   setListView(iMonday);   break;
                    case Calendar.TUESDAY:  setListView(iTuesday);  break;
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
            case R.id.action_tuesday:  setListView(iTuesday);  break;
            case R.id.action_whatnext: setListView(iWhatNext); break;
            //case R.id.action_register:
            //case R.id.action_sync:
            //case R.id.action_settings:

            // or: startActivity(new Intent(this, CoursesActivity.class)); // see: http://www.intertech.com/Blog/android-action-bar-from-the-options-menu/
            //adapter.notifyDataSetChanged();

            default:
                // If don't recognise the menu item then the super class might have a handler for it:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private boolean setListView(int array_index){
        if ((array_index<0) || (array_index>=data.length)) {return false;}
        iCurrent = array_index;
        toolbar.setTitle("SM16: " + (data[iCurrent].length>0 ? data[iCurrent][0][0] : "") );
        items.clear();
        //Collections.addAll(items, data[array_index]); // Collections.addAll() might be faster than items.addAll(welcome) ?
        for (int i=1; i<data[iCurrent].length; i++) { // i starts at 1, as 0 is the title.
            // if has detail text for the line, then add ' ...' to the line to indicate that can tap line to see detail.
            items.add( data[iCurrent][i].length>1 ? data[iCurrent][i][0]+" ..." : data[iCurrent][i][0] );
        }
        // public static <T> boolean addAll(Collection<? super T> c, T... elements)

        adapter.notifyDataSetChanged();
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
                        dialog.cancel(); // or: dialog.dismiss();
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

    public void showCustomDialog(Context context, String title, String message, int imageId) {  // add image parameter
        //final Context context = this;

        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.mydialog);
        dialog.setTitle(title);

        // set the custom dialog components - text, image and button
        //TextView text = (TextView) dialog.findViewById(R.id.title);
        //text.setText(title);

        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText(message);

        ImageView image = (ImageView) dialog.findViewById(R.id.image);
        if (imageId == -1) {
            // GONE removes the space, whereas Invisible keeps the empty space.
            image .setVisibility(View.GONE); // or: image .setVisibility(View.INVISIBLE);
        }
        else {
            image.setImageResource(imageId);  // for other image
            // image.setImageResource(R.drawable.rachel_hughes_130);  // for other image
            // image.setImageResource(R.mipmap.ic_launcher);
            image .setVisibility(View.VISIBLE);
        }

        Button okButton = (Button) dialog.findViewById(R.id.okbutton);
        // if button is clicked, close the custom dialog
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button nextButton = (Button) dialog.findViewById(R.id.nextbutton);
        // if button is clicked, close the custom dialog
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringUrl = "http://google.com";
                getDataFromURL(stringUrl);

            }
        });


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
    String filename = "myfile";
    //String string = "Hello world!";
    FileOutputStream outputStream;

    try {
        // filename can not contain path separators:
        outputStream = openFileOutput(filename, Context.MODE_PRIVATE | Context.MODE_APPEND); // Throws FileNotFoundException
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
