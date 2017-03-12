package activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

import com.google.gson.Gson;
import com.yourapp.developer.karrierbay.R;

import java.util.Calendar;
import java.util.HashMap;

import Fragment.ContactFragment;
import Fragment.HomeFragment;
import Fragment.ProfileFragment;
import Model.Constants;
import Model.QuoteRequest;
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
    private HashMap<String, String> user;
    private TextView emailHeader,nameHeader;
    public ApiInterface apiService;
    public SenderOrder sender = new SenderOrder();
    public QuoteRequest quoteRequest = new QuoteRequest();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sessionManager = new SessionManager(getApplicationContext());
        //Sender flow
        String s = "{\"carrier_schedule_detail_attributes\":{},\"fromDate\":\"5-3-2017\",\"fromTime\":\"13:52\",\"from_geo_lat\":\"11.8014\",\"from_geo_long\":\"76.0044\",\"from_loc\":\"Rajapalayam, Tamil Nadu, India\",\"pickup_order_mapping\":{\"address_line_1\":\"hshshsh\",\"address_line_2\":\"Rajapalayam, Tamil Nadu, India\",\"fullAdress\":\"hshhs\\ngsg\\nhshshsh\\nRajapalayam, Tamil Nadu, India\\n9894100115\",\"landmark\":\"gsg\",\"name\":\"hshhs\",\"phone_1\":\"9894100115\"},\"receiver_order_mapping\":{\"address_line_1\":\"gah\",\"address_line_2\":\"Chennai, Tamil Nadu, India\",\"fullAdress\":\"nsjsj\\ngs\\ngah\\nChennai, Tamil Nadu, India\\n9894100445\",\"landmark\":\"gs\",\"name\":\"nsjsj\",\"phone_1\":\"9894100445\"},\"sender_order_item_attributes\":[{\"end_time\":\"2017-04-05T08:22:49.072\",\"item_attributes\":{\"breadth\":\"64\",\"height\":\"54\",\"length\":\"64\",\"volumetricfullDetails\":\"64  64  54\\n\",\"item_weight\":\"21\",\"breadthIndex\":0},\"item_subtype\":\"Electronic Item\",\"item_type\":\"Article\",\"start_time\":\"2017-04-05T08:22:49.070\",\"item_subtype_index\":0,\"item_type_index\":0}],\"toDate\":\"5-3-2017\",\"toTime\":\"13:52\",\"to_geo_lat\":\"12.9716\",\"to_geo_long\":\"77.5946\",\"to_loc\":\"Chennai, Tamil Nadu, India\",\"user\":{},\"from_loc_index\":0,\"isSender\":true,\"spinWantToSendIdx\":0}";
        String quot = "{\"breadth\":\"64\",\"height\":\"54\",\"item_weight\":\"21\",\"lat1\":\"9.465337699999997\",\"lat2\":\"13.082680199999997\",\"length\":\"64\",\"long1\":\"77.5275463\",\"long2\":\"80.2707184\"}";

        Gson gson = new Gson();
        try {
            sender = gson.fromJson(s, SenderOrder.class);
            quoteRequest = gson.fromJson(quot, QuoteRequest.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Karrier Bay</font>"));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        View hView = navigationView.getHeaderView(0);

        emailHeader = (TextView) hView.findViewById(R.id.email_header);
        nameHeader = (TextView) hView.findViewById(R.id.name_header);
        user = sessionManager.getUserDetails();
        emailHeader.setText(user.get(SessionManager.KEY_EMAIL));
        nameHeader.setText(user.get(SessionManager.KEY_NAME));

        hView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment(new ProfileFragment(), "ProfileFragment");
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });


        fragment(new HomeFragment(), "MainFragment");
    }
    @Override
    protected void onResume() {
        apiService = ApiClient.getClientWithHeader(this).create(ApiInterface.class);

        super.onResume();
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
            if (tag.equals("MainFragment")) {
                finish();
            } else if (tag.equals(Constants.DETAILSFRAGMENT)) {
                FragmentManager fm = getSupportFragmentManager();
                for (int i = 1; i < fm.getBackStackEntryCount(); ++i) {
                    fm.popBackStack();
                }
                sender = new SenderOrder();
                quoteRequest = new QuoteRequest();
                fragment(new HomeFragment(), "MainFragment");
            }

            //super.onBackPressed();
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
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
        if (id == R.id.action_home) {
            sender = new SenderOrder();
            quoteRequest = new QuoteRequest();
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

        if (id == R.id.nav_contact_us) {
            fragment(new ContactFragment(), "ContactFragment");
        }
        if (id == R.id.nav_rate_app) {
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

                                et.setText(arg3 + "-" + (arg2 + 1) + "-" + arg1);
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