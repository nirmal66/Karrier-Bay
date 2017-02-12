package Fragment;

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
import com.yourapp.developer.karrierbay.databinding.FragmentTripSummaryBinding;

import org.json.JSONException;
import org.json.JSONObject;

import Model.ItemAttributes;
import Model.PickupOrderMapping;
import Model.ReceiverOrderMapping;
import Model.SenderOrder;
import Model.SenderOrderItemAttributes;
import Model.SenderOrderRequest;
import Model.SenderOrderResponse;
import Model.User;
import activity.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TripSummaryFragment extends Fragment {


    SenderOrder sender;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.fragment_sender, container, false);
        FragmentTripSummaryBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_trip_summary, container, false);
        View view = binding.getRoot();
        sender = ((MainActivity) getActivity()).sender;
        SenderOrderItemAttributes[] sender_order_item_attributes = sender.getSender_order_item_attributes();
        ItemAttributes item = sender_order_item_attributes[0].getItem_attributes();
        binding.setSender(sender);
        binding.setItem(item);
        PickupOrderMapping pickup = sender.getPickupOrderMapping();
        binding.setPickup(pickup);
        ReceiverOrderMapping delivery = sender.getReceiverOrderMapping();
        binding.setDelivery(delivery);
        SenderOrderItemAttributes senderorderitem = sender_order_item_attributes[0];
        binding.setSenderorderitem(senderorderitem);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>SENDER WALL</font>"));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.btn_sender_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String s = "{\"SenderOrder\":{\"from_loc\":\"Mysore\",\"to_loc\":\"Calicut\",\"comments\":\"Car\",\"from_geo_lat\":\"11.8014\",\"from_geo_long\":\"76.0044\",\"to_geo_lat\":\"12.9716\",\"to_geo_long\":\"77.5946\",\"isInsured\":true,\"receiver_order_mapping\":{\"name\":\"Shuhail\",\"address_line_1\":\"mysore road\",\"address_line_2\":\"Wayanad\",\"phone_1\":\"12121212\",\"phone_2\":\"341356343\",\"landmark\":\"KSRTC\",\"pin\":\"679645\",\"auto_save\":true},\"pickup_order_mapping\":{\"name\":\"Shuhail\",\"address_line_1\":\"mysore road\",\"address_line_2\":\"Wayanad\",\"phone_1\":\"12121212\",\"phone_2\":\"341356343\",\"landmark\":\"KSRTC\",\"pin\":\"679645\",\"auto_save\":true},\"sender_order_item_attributes\":[{\"quantity\":1,\"item_type\":\"Laptop\",\"item_subtype\":\"Pishku\",\"item_attributes\":{\"length\":\"12\",\"breadth\":\"13\",\"height\":\"13\",\"item_weight\":\"122\",\"item_value\":\"12\"}}]}}";
//                Gson gson = new Gson();
                //sender  = gson.fromJson(new JSONObject(s).getString("SenderOrder"),SenderOrder.class);
                SenderOrderRequest senderOrderRequest = new SenderOrderRequest();
                sender.setFrom_geo_lat("11.8014");
                sender.setFrom_geo_long("76.0044");
                sender.setTo_geo_lat("12.9716");
                sender.setTo_geo_long("77.5946");


                senderOrderRequest.setSenderOrder(sender);
                ((MainActivity) getActivity()).fragment(new CarrierListFragment(), "SenderFragment");
//                Call<SenderOrderResponse> call = ((MainActivity) getActivity()).apiService.postSenderOrder(senderOrderRequest);
//                call.enqueue(new Callback<SenderOrderResponse>() {
//                    @Override
//                    public void onResponse(Call<SenderOrderResponse> call, Response<SenderOrderResponse> response) {
//
//                        if (response.code() == 201) {
//                            Log.d("LoginResponse", response.message());
//                            // Log.d("Error",response.body().getErrors().toString());
//                            ((MainActivity) getActivity()).fragment(new CarrierListFragment(), "SenderFragment");
//                        } else {
//                            Toast.makeText(getActivity(), "Incorrect Request", Toast.LENGTH_LONG).show();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<SenderOrderResponse> call, Throwable t) {
//
//                    }
//                });

            }
        });
//        mViewModel.getText().set("Wednesday");
    }


}
