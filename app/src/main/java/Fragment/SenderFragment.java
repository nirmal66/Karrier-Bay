package Fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yourapp.developer.karrierbay.R;
import com.yourapp.developer.karrierbay.databinding.FragmentSenderBinding;

import org.json.JSONException;
import org.json.JSONObject;

import Model.LoginRequest;
import Model.LoginResponse;
import Model.SenderOrderRequest;
import Model.SenderOrderResponse;
import Model.Sender_order;
import Model.User;
import activity.LoginActivity;
import activity.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SenderFragment extends Fragment {


    SenderOrderRequest sender=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.fragment_sender, container, false);
        FragmentSenderBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sender, container, false);
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        sender=new SenderOrderRequest();
        binding.setSender(sender);
//        user.getText().set("Lugggage");
       ((MainActivity)getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>SENDER TRIP SCHEDULE</font>"));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      Spinner sp= (Spinner) view.findViewById(R.id.spinWantTo);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sender.setSpinWantToSendIdx(i);
//                Toast.makeText(getContext(),user.getSpinWantToSendIdx()+"",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        view.findViewById(R.id.btn_sender_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  ((MainActivity) getActivity()).fragment(new SenderTripScheduleFragment(),"SenderFragment");
String s="{\"sender_order\":{\"from_loc\":\"Mysore\",\"to_loc\":\"Calicut\",\"comments\":\"Car\",\"from_geo_lat\":\"11.8014\",\"from_geo_long\":\"76.0044\",\"to_geo_lat\":\"12.9716\",\"to_geo_long\":\"77.5946\",\"isInsured\":true,\"receiver_order_mapping\":{\"name\":\"Shuhail\",\"address_line_1\":\"mysore road\",\"address_line_2\":\"Wayanad\",\"phone_1\":\"12121212\",\"phone_2\":\"341356343\",\"landmark\":\"KSRTC\",\"pin\":\"679645\",\"auto_save\":true},\"pickup_order_mapping\":{\"name\":\"Shuhail\",\"address_line_1\":\"mysore road\",\"address_line_2\":\"Wayanad\",\"phone_1\":\"12121212\",\"phone_2\":\"341356343\",\"landmark\":\"KSRTC\",\"pin\":\"679645\",\"auto_save\":true},\"sender_order_item_attributes\":[{\"quantity\":1,\"item_type\":\"Laptop\",\"item_subtype\":\"Pishku\",\"item_attributes\":{\"length\":\"12\",\"breadth\":\"13\",\"height\":\"13\",\"item_weight\":\"122\",\"item_value\":\"12\"}}]}}";
        Gson gson=new Gson();
                try {


                sender.sender_order  = gson.fromJson(new JSONObject(s).getString("sender_order"),Sender_order.class);
                Call<SenderOrderResponse> call =((MainActivity) getActivity()).apiService.postSenderOrder(sender);
                call.enqueue(new Callback<SenderOrderResponse>() {
                    @Override
                    public void onResponse(Call<SenderOrderResponse> call, Response<SenderOrderResponse> response) {

                        if (response.code() == 200) {
                            Log.d("LoginResponse", response.message());
                            // Log.d("Error",response.body().getErrors().toString());


                        } else {
                            Toast.makeText(getActivity(), "Password Incorrect", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<SenderOrderResponse> call, Throwable t) {

                    }
                });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
//        mViewModel.getText().set("Wednesday");
    }


}
