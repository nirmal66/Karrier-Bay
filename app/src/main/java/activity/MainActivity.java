package activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.yourapp.developer.karrierbay.R;

import java.util.Calendar;
import java.util.HashMap;

import Fragment.*;
import Model.SenderOrder;
import RetroGit.ApiClient;
import RetroGit.ApiInterface;
import Utilities.SessionManager;

import static Utilities.Utility.hideKeyboard;

/**
 * A login screen that offers login via email/password.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private SessionManager sessionManager;
    private NavigationView navigationView;
    private String tag;
    private HashMap<String,String> user;
    private TextView emailHeader;
    public ApiInterface apiService;
    public SenderOrder sender=new SenderOrder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sessionManager = new SessionManager(getApplicationContext());

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Karrier Bay</font>"));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        View hView = navigationView.getHeaderView(0);
        emailHeader = (TextView)hView.findViewById(R.id.email_header);
        user = sessionManager.getUserDetails();
        emailHeader.setText(user.get(SessionManager.KEY_NAME));
        apiService = ApiClient.getClientWithHeader(this).create(ApiInterface.class);

        fragment(new HomeFragment(), "MainFragment");
    }

    @Override
    public void onBackPressed() {

        hideKeyboard(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            String tag = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
            //Toast.makeText(this,tag,Toast.LENGTH_LONG).show();
            if(tag.equals("MainFragment"))
            {
                finish();
            }

            //super.onBackPressed();
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
                //finish();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        hideKeyboard(this);
        int id = item.getItemId();
       /* if (id == R.id.action_notification)
        {
            fragment(new NotificationFragment(),"NotificationFragment");
            //item.setVisible(false);
        }*/
        if(id == R.id.action_home)
        {
            fragment(new HomeFragment(), "MainFragment");
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        hideKeyboard(this);
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if(id == R.id.nav_contact_us)
        {
            fragment(new ContactFragment(),"ContactFragment");
        }
        if(id == R.id.nav_rate_app)
        {
            //final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
            final String appPackageName = "com.yourapp.batterystatus";
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        }
        if (id == R.id.nav_logout) {
            sessionManager.logoutUser();
            finish();
            //Toast.makeText(getApplicationContext(), "User Login Status: " + sessionManager.checkLogin(), Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public void fragment(Fragment fragment, String transaction) {
        tag = transaction;
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_transaction, fragment, transaction);
        fragmentTransaction.addToBackStack(transaction);
        fragmentTransaction.commit();
        Log.d("backFragment", tag);
    }


 public void dateClick(View view) {
    final EditText et = (EditText) view;
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);

    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    new DatePickerDialog(this,
            new
                    DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker arg0,
                                              int arg1, int arg2, int arg3) {

                            et.setText(arg3 + "-" + arg2 + 1 + "-" + arg1);
                        }
                    }, year, month, day).show();
}

    public void timeClick(View view) {
        final EditText et = (EditText) view;
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                et.setText(selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

}