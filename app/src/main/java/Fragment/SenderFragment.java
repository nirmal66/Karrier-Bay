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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.yourapp.developer.karrierbay.R;
import com.yourapp.developer.karrierbay.databinding.FragmentSenderBinding;

import Model.CarrierScheduleDetailAttributes;
import Model.ItemAttributes;
import Model.SenderOrder;
import Model.SenderOrderItemAttributes;
import activity.MainActivity;

public class SenderFragment extends Fragment implements Spinner.OnItemSelectedListener, View.OnFocusChangeListener {


    SenderOrder sender = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.fragment_sender, container, false);
        FragmentSenderBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sender, container, false);
        View view = binding.getRoot();

        //here data must be an instance of the class MarsDataProvider
        sender = ((MainActivity) getActivity()).sender;
        SenderOrderItemAttributes[] sender_order_item_attributes = sender.getSender_order_item_attributes();
        ItemAttributes item = sender_order_item_attributes[0].getItem_attributes();
        binding.setSender(sender);
        binding.setItem(item);
//        user.getText().set("Lugggage");

        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sender.isSender = getArguments().getBoolean("isSenderFlow");
        if (sender.isSender) {
            ((MainActivity) getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>SENDER TRIP SCHEDULE</font>"));
        } else {
            ((MainActivity) getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>CARRIER TRIP SCHEDULE</font>"));

        }
        ((Spinner) view.findViewById(R.id.sp_from_loc)).setOnItemSelectedListener(this);
        ;
        ((Spinner) view.findViewById(R.id.sp_To_loc)).setOnItemSelectedListener(this);
        ;
        ((Spinner) view.findViewById(R.id.spinWantTo)).setOnItemSelectedListener(this);
        ;
        ((Spinner) view.findViewById(R.id.sp_sub_type)).setOnItemSelectedListener(this);
        ;
        ((Spinner) view.findViewById(R.id.spinHeight)).setOnItemSelectedListener(this);
        ;
        ((Spinner) view.findViewById(R.id.spinWidth)).setOnItemSelectedListener(this);
        ;
        ((Spinner) view.findViewById(R.id.spinBand)).setOnItemSelectedListener(this);
        ;
        ((Spinner) view.findViewById(R.id.spinSeat)).setOnItemSelectedListener(this);

        ((Spinner) view.findViewById(R.id.spCarrierPassengers)).setOnItemSelectedListener(this);
        ;
        ((Spinner) view.findViewById(R.id.spCarrierCapacity)).setOnItemSelectedListener(this);
        ((EditText) view.findViewById(R.id.etDEPDate)).setOnFocusChangeListener(this);
        ((EditText) view.findViewById(R.id.etToDate)).setOnFocusChangeListener(this);

        ((EditText) view.findViewById(R.id.etToTime)).setOnFocusChangeListener(this);

        ((EditText) view.findViewById(R.id.etDEPTime)).setOnFocusChangeListener(this);

        view.findViewById(R.id.btn_sender_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                if (sender.isSender) {
                    ((MainActivity) getActivity()).fragment(new SenderTripScheduleFragment(), "SenderFragment");
                } else {

                    sender.getCarrierScheduleDetailAttributes().setStart_time(getDate(sender.getFromDate(), sender.getFromTime()));
                    sender.getCarrierScheduleDetailAttributes().setEnd_time(getDate(sender.getToDate(), sender.getToTime()));

                    if (((CheckBox) view.findViewById(R.id.cbarticle)).isChecked() && ((CheckBox) view.findViewById(R.id.cbpassenger)).isChecked()) {
                        sender.getCarrierScheduleDetailAttributes().setMode("Article & Passenger");
                    } else if (((CheckBox) view.findViewById(R.id.cbarticle)).isChecked()) {
                        sender.getCarrierScheduleDetailAttributes().setMode("Article");
                        sender.getCarrierScheduleDetailAttributes().setPassengercount(null);
                    } else if (((CheckBox) view.findViewById(R.id.cbpassenger)).isChecked()) {
                        sender.getCarrierScheduleDetailAttributes().setMode("Passenger");
                        sender.getCarrierScheduleDetailAttributes().setCapacity(null);
                    }else{
                        return;
                    }


                    ((MainActivity) getActivity()).fragment(new TripSummaryFragment(), "SenderFragment");

                }

            }
        });

    }

    public String getDate(String date, String time) {
//    2016-09-08T12:00:00.000Z

        date = "10-01-2017";
        String a[] = date.split("-");
        time = "06:50";
        return a[2] + "-" + a[1] + "-" + a[0] + "T" + time + "00.000Z";
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedValue = adapterView.getSelectedItem().toString();

        SenderOrderItemAttributes[] sender_order_item_attributes = sender.getSender_order_item_attributes();
        ItemAttributes item_attributes = sender_order_item_attributes[0].getItem_attributes();

        CarrierScheduleDetailAttributes carrierScheduleDetailAttributes = sender.getCarrierScheduleDetailAttributes();
        switch (adapterView.getId()) {
            case R.id.sp_from_loc:
                sender.setFrom_loc(selectedValue);
                break;
            case R.id.sp_To_loc:
                sender.setTo_loc(selectedValue);
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

            case R.id.spCarrierCapacity:
                carrierScheduleDetailAttributes.setCapacity(selectedValue);
                break;
            case R.id.spCarrierPassengers:
                carrierScheduleDetailAttributes.setPassengercount(selectedValue);
                break;

            default:
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            switch (view.getId()) {
                case R.id.etDEPDate:
                case R.id.etToDate:
                    ((MainActivity) getActivity()).dateClick(view);
                    break;
                case R.id.etToTime:
                case R.id.etDEPTime:
                    ((MainActivity) getActivity()).timeClick(view);
                    break;
                default:
                    break;
            }
        }
    }
}
