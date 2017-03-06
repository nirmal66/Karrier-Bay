package Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yourapp.developer.karrierbay.R;

import Model.QuoteRequest;
import Model.SenderOrder;
import Utilities.BaseFragment;
import activity.MainActivity;

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
         ((MainActivity) getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Karrier Bay</font>"));
        beaCarrier.setTypeface(mTfSemiBold);
        beaSender.setTypeface(mTfSemiBold);

        beaCarrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putBoolean("isSenderFlow",false);
                senderFragment.setArguments(bundle);
                ((MainActivity) getActivity()).fragment(senderFragment,"senderFragment");
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
