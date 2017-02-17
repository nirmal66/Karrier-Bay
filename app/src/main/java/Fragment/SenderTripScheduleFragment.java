package Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yourapp.developer.karrierbay.R;
import com.yourapp.developer.karrierbay.databinding.FragmentPickupDeliveryScheduleBinding;

import Model.PickupOrderMapping;
import Model.ReceiverOrderMapping;
import Model.SenderOrder;
import activity.MainActivity;

public class SenderTripScheduleFragment extends Fragment {


    SenderOrder sender;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentPickupDeliveryScheduleBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pickup_delivery_schedule, container, false);
        View view = binding.getRoot();
        sender = ((MainActivity) getActivity()).sender;
        binding.setSender(sender);
        PickupOrderMapping pickup = sender.getPickupOrderMapping();
        binding.setPickup(pickup);
        ReceiverOrderMapping delivery = sender.getReceiverOrderMapping();
        binding.setDelivery(delivery);
        return view;

        // Initialize recycler view
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>SENDER TRIP SCHEDULE</font>"));

        view.findViewById(R.id.btn_sender_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).fragment(new TripSummaryFragment(), "SenderFragment");

            }
        });
    }

}

