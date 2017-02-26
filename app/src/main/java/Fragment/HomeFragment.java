package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.yourapp.developer.karrierbay.R;

import Utilities.BaseFragment;
import activity.MainActivity;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class HomeFragment extends BaseFragment {



    private Button beaCarrier, beaSender;
    SenderFragment senderFragment=  new SenderFragment();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        beaCarrier= (Button) view.findViewById(R.id.be_a_carrier);
        beaSender= (Button) view.findViewById(R.id.be_a_sender);

        beaCarrier.setTypeface(mTfSemiBold);
        beaSender.setTypeface(mTfSemiBold);

        beaCarrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putBoolean("isSenderFlow",false);
                senderFragment.setArguments(bundle);
                ((MainActivity) getActivity()).fragment(senderFragment,"MainFragment");
            }
        });

        beaSender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putBoolean("isSenderFlow",true);
                senderFragment.setArguments(bundle);
                ((MainActivity) getActivity()).fragment(senderFragment,"SenderFragment");

           }
        });
    }

}
