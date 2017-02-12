package Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.yourapp.developer.karrierbay.R;
import com.yourapp.developer.karrierbay.databinding.FragmentSenderBinding;

import Model.ItemAttributes;
import Model.SenderOrder;
import Model.SenderOrderItemAttributes;
import activity.MainActivity;

public class SenderFragment extends Fragment  implements Spinner.OnItemSelectedListener  {


    SenderOrder sender=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.fragment_sender, container, false);
        FragmentSenderBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sender, container, false);
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        sender = ((MainActivity) getActivity()).sender;
        SenderOrderItemAttributes[] sender_order_item_attributes= sender.getSender_order_item_attributes();
        ItemAttributes item= sender_order_item_attributes[0].getItem_attributes();
        item.setWeight("200");
        binding.setSender(sender);
        binding.setItem(item);
//        user.getText().set("Lugggage");
       ((MainActivity)getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>SENDER TRIP SCHEDULE</font>"));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((Spinner) view.findViewById(R.id.sp_from_loc)).setOnItemSelectedListener(this);;
        ((Spinner) view.findViewById(R.id.sp_To_loc)).setOnItemSelectedListener(this);;
        ((Spinner) view.findViewById(R.id.spinWantTo)).setOnItemSelectedListener(this);;
        ((Spinner) view.findViewById(R.id.sp_sub_type)).setOnItemSelectedListener(this);;
        ((Spinner) view.findViewById(R.id.spinHeight)).setOnItemSelectedListener(this);;
        ((Spinner) view.findViewById(R.id.spinWidth)).setOnItemSelectedListener(this);;
        ((Spinner) view.findViewById(R.id.spinBand)).setOnItemSelectedListener(this);;
        ((Spinner) view.findViewById(R.id.spinSeat)).setOnItemSelectedListener(this);;

        view.findViewById(R.id.btn_sender_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              ((MainActivity) getActivity()).fragment(new SenderTripScheduleFragment(),"SenderFragment");
//String s="{\"SenderOrder\":{\"from_loc\":\"Mysore\",\"to_loc\":\"Calicut\",\"comments\":\"Car\",\"from_geo_lat\":\"11.8014\",\"from_geo_long\":\"76.0044\",\"to_geo_lat\":\"12.9716\",\"to_geo_long\":\"77.5946\",\"isInsured\":true,\"receiver_order_mapping\":{\"name\":\"Shuhail\",\"address_line_1\":\"mysore road\",\"address_line_2\":\"Wayanad\",\"phone_1\":\"12121212\",\"phone_2\":\"341356343\",\"landmark\":\"KSRTC\",\"pin\":\"679645\",\"auto_save\":true},\"pickup_order_mapping\":{\"name\":\"Shuhail\",\"address_line_1\":\"mysore road\",\"address_line_2\":\"Wayanad\",\"phone_1\":\"12121212\",\"phone_2\":\"341356343\",\"landmark\":\"KSRTC\",\"pin\":\"679645\",\"auto_save\":true},\"sender_order_item_attributes\":[{\"quantity\":1,\"item_type\":\"Laptop\",\"item_subtype\":\"Pishku\",\"item_attributes\":{\"length\":\"12\",\"breadth\":\"13\",\"height\":\"13\",\"item_weight\":\"122\",\"item_value\":\"12\"}}]}}";
//        Gson gson=new Gson();
//                try {
//
//
//                sender.SenderOrder  = gson.fromJson(new JSONObject(s).getString("SenderOrder"),SenderOrder.class);
//                Call<SenderOrderResponse> call =((MainActivity) getActivity()).apiService.postSenderOrder(sender);
//                call.enqueue(new Callback<SenderOrderResponse>() {
//                    @Override
//                    public void onResponse(Call<SenderOrderResponse> call, Response<SenderOrderResponse> response) {
//
//                        if (response.code() == 200) {
//                            Log.d("LoginResponse", response.message());
//                            // Log.d("Error",response.body().getErrors().toString());
//
//
//                        } else {
//                            Toast.makeText(getActivity(), "Password Incorrect", Toast.LENGTH_LONG).show();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<SenderOrderResponse> call, Throwable t) {
//
//                    }
//                });
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
          }
        });
//        mViewModel.getText().set("Wednesday");
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedValue= adapterView.getSelectedItem().toString();

        SenderOrderItemAttributes[] sender_order_item_attributes= sender.getSender_order_item_attributes();
        ItemAttributes item_attributes= sender_order_item_attributes[0].getItem_attributes();
        switch (adapterView.getId())
        {
             case R.id.sp_from_loc:
                 sender.setFrom_loc(selectedValue);
                break;
            case R.id.sp_To_loc:
            //    sender.SenderOrder.setTo_loc(selectedValue);
                break;
            case R.id.spinWantTo:

                sender_order_item_attributes[0].setItem_type(selectedValue);
                sender.setSpinWantToSendIdx(i);
                break;
            case R.id.sp_sub_type:
                 sender_order_item_attributes[0].setItem_subtype(selectedValue);
                break;
            case R.id.spinHeight:
                item_attributes.setHeight(selectedValue);
                break;
            case R.id.spinWidth:
                item_attributes.setLength(selectedValue);
                break;
            case R.id.spinBand:
                item_attributes.setBreadth(selectedValue);
                break;
            case R.id.spinSeat:
                sender_order_item_attributes[0].setQuantity(selectedValue);
                break;



            default:
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
