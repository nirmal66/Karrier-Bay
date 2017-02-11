package Utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import Model.LoginResponse;
import activity.LoginActivity;
import okhttp3.Headers;
import retrofit2.Response;


/**
 * Created by nirmal.ku on 11/7/2016.
 */
public class SessionManager {
    public SharedPreferences sharedPreferences;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    // Sharedpref file name
    private static final String PREF_NAME = "KarrierBay";
    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";
    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    public static final String ACCESS_TOKEN = "Access-Token";
    public static final String CLIENT = "Client";
    // Constructor
    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String email, String name, Headers headers){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        // Storing name in pref
        editor.putString(KEY_NAME, name);
        // Storing email in pref
        editor.putString(KEY_EMAIL, email);
        // commit changes
        editor.putString(ACCESS_TOKEN, headers.get("access-token"));

        editor.putString(CLIENT,headers.get("client")); ;

        editor.commit();
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean checkLogin(){
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public HashMap<String,String> getUserDetails()
    {
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, sharedPreferences.getString(KEY_NAME, null));

        // user email id
        user.put(KEY_EMAIL, sharedPreferences.getString(KEY_EMAIL, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }


    }
