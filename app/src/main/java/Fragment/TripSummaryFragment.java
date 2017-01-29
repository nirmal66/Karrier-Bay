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
import android.widget.Toast;

import com.yourapp.developer.karrierbay.R;
import com.yourapp.developer.karrierbay.databinding.FragmentSenderBinding;
import com.yourapp.developer.karrierbay.databinding.FragmentTripSummaryBinding;

import Model.User;
import activity.MainActivity;

public class TripSummaryFragment extends Fragment {


    User user=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.fragment_sender, container, false);
        FragmentTripSummaryBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_trip_summary, container, false);
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
          user=new User("Vel");
        binding.setUser(user);
        user.getText().set("Lugggage");
       ((MainActivity)getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>SENDER WALL</font>"));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.btn_sender_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).fragment(new CarrierListFragment(),"SenderFragment");
            }
        });
//        mViewModel.getText().set("Wednesday");
    }


}
