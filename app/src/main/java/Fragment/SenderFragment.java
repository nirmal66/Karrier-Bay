package Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.yourapp.developer.karrierbay.R;
import com.yourapp.developer.karrierbay.databinding.FragmentSenderBinding;

import Model.CarrierScheduleDetailAttributes;
import Model.ItemAttributes;
import Model.QuoteRequest;
import Model.QuoteResponse;
import Model.SenderOrder;
import Model.SenderOrderItemAttributes;
import Model.SenderOrderResponse;
import activity.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class SenderFragment extends Fragment implements Spinner.OnItemSelectedListener, View.OnClickListener {


    SenderOrder sender = null;
    boolean isFromLocFocused;
    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;
    QuoteRequest quoteRequest = new QuoteRequest();
    CarrierScheduleDetailAttributes carrierAttribute;

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

        carrierAttribute = sender.getCarrierScheduleDetailAttributes();
        binding.setCarrierAttribute(carrierAttribute);
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
        ((EditText) view.findViewById(R.id.etDEPDate)).setOnClickListener(this);
        ((EditText) view.findViewById(R.id.etToDate)).setOnClickListener(this);

        ((EditText) view.findViewById(R.id.etToTime)).setOnClickListener(this);

        ((EditText) view.findViewById(R.id.etDEPTime)).setOnClickListener(this);

        ((EditText) view.findViewById(R.id.et_from_loc)).setOnClickListener(this);

        ((EditText) view.findViewById(R.id.et_To_loc)).setOnClickListener(this);
        view.findViewById(R.id.btn_sender_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                if (sender.isSender) {
                    if (sender.getSpinWantToSendIdx() == 0) {
                        quoteRequest.setBreadth(sender.getSender_order_item_attributes()[0].getItem_attributes().getBreadth());
                        quoteRequest.setHeight(sender.getSender_order_item_attributes()[0].getItem_attributes().getHeight());
                        quoteRequest.setLength(sender.getSender_order_item_attributes()[0].getItem_attributes().getLength());
                        quoteRequest.setItem_weight(sender.getSender_order_item_attributes()[0].getItem_attributes().getWeight());
                    } else {
                        quoteRequest.setItem_value(sender.getSender_order_item_attributes()[0].getQuantity());
                    }


                    Call call = ((MainActivity) getActivity()).apiService.getQuote(quoteRequest);


                    call.enqueue(new Callback<QuoteResponse>() {
                        @Override
                        public void onResponse(Call<QuoteResponse> call, Response<QuoteResponse> response) {

                            if (response.code() == 200) {
                                QuoteResponse quoteResponse = ((QuoteResponse) response.body());
                                final Dialog dialog = new Dialog(getActivity());
                                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                dialog.setContentView(R.layout.quote_popup);

                                sender.getPickupOrderMapping().setAddress_line_1(sender.getFrom_loc());
                                sender.getReceiverOrderMapping().setAddress_line_1(sender.getTo_loc());
                                // set the custom dialog components - text, image and button
                                TextView text = (TextView) dialog.findViewById(R.id.textView2);
                                text.setText("The appropriate charge for your courier is RS." + quoteResponse.quote.getTotal_distance_charge() + " The prices may be vary according to the exact " +
                                        "pick up and delivery points");

                                Button dialogButton = (Button) dialog.findViewById(R.id.btn_continue);
                                ImageView ivPop = (ImageView) dialog.findViewById(R.id.ivPop);

                                // if button is clicked, close the custom dialog
                                dialogButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        ((MainActivity) getActivity()).fragment(new SenderTripScheduleFragment(), "SenderFragment");
                                        dialog.dismiss();
                                    }
                                });

                                dialog.show();

                                // if button is clicked, close the custom dialog
                                ivPop.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                         dialog.dismiss();
                                    }
                                });



                                Log.d("LoginResponse", response.message());


                            } else {
                                Toast.makeText(getActivity(), "Incorrect Request", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<QuoteResponse> call, Throwable t) {
                            Toast.makeText(getActivity(), "Incorrect Request", Toast.LENGTH_LONG).show();
                        }
                    });


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
                    } else {
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


        switch (adapterView.getId()) {
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


            case R.id.spCarrierPassengers:
                carrierAttribute.setPassengercount(selectedValue);
                break;

            default:
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private void openAutocompleteActivity() {
        try {
            // The autocomplete activity requires Google Play Services to be available. The intent
            // builder checks this and throws an exception if it is not the case.
            Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                    .build(getActivity());
            startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);
        } catch (GooglePlayServicesRepairableException e) {
            // Indicates that Google Play Services is either not installed or not up to date. Prompt
            // the user to correct the issue.
            GoogleApiAvailability.getInstance().getErrorDialog(getActivity(), e.getConnectionStatusCode(),
                    0 /* requestCode */).show();
        } catch (GooglePlayServicesNotAvailableException e) {
            // Indicates that Google Play Services is not available and the problem is not easily
            // resolvable.
            String message = "Google Play Services is not available: " +
                    GoogleApiAvailability.getInstance().getErrorString(e.errorCode);

            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_AUTOCOMPLETE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(getActivity(), data);
                if (isFromLocFocused) {
                    sender.setFrom_loc(place.getAddress().toString());
                    quoteRequest.setLat1((place.getLatLng().latitude) + "");
                    quoteRequest.setLong1((place.getLatLng().longitude) + "");
                } else {
                    sender.setTo_loc(place.getAddress().toString());
                    quoteRequest.setLat2((place.getLatLng().latitude) + "");
                    quoteRequest.setLong2((place.getLatLng().longitude) + "");
                }

                Log.i("testing", "Place: " + place.getName() + place.getLatLng() + place.getAddress());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(getActivity(), data);
                // TODO: Handle the error.
                Log.i("testing", status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.etDEPDate:
            case R.id.etToDate:
                ((MainActivity) getActivity()).dateClick(view);
                break;
            case R.id.etToTime:
            case R.id.etDEPTime:
                ((MainActivity) getActivity()).timeClick(view);
                break;

            case R.id.et_from_loc:
                isFromLocFocused = true;
                openAutocompleteActivity();
                break;
            case R.id.et_To_loc:
                isFromLocFocused = false;
                openAutocompleteActivity();
                break;

            default:
                break;
        }
    }
}
