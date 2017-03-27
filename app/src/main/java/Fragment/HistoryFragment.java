package Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yourapp.developer.karrierbay.R;
import com.yourapp.developer.karrierbay.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.List;

import Adapter.HistoryAdapter;
import Model.SenderOrder;
import Utilities.BaseFragment;
import activity.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FragmentHistoryBinding binding;
    private List<SenderOrder> historyLists = new ArrayList<>();;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_history, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = binding.recyclerViewHistory;

        preparenotificationData();
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        Toast.makeText(getActivity(),"History Fragment",Toast.LENGTH_LONG).show();
    }


    private void preparenotificationData() {
       /* History history = new History("Chennai, TamilNadu", "Madurai, TamilNadu", "250","Document","Delivered");
        historyLists.add(history);
        history = new History("Chennai, TamilNadu", "ooty, TamilNadu", "777","Document","Delivered");
        historyLists.add(history);
        history = new History("Chennai, TamilNadu", "ooty, TamilNadu", "666","Document","Delivered");
        historyLists.add(history);
        history = new History("Chennai, TamilNadu", "ooty, TamilNadu", "888","Tv","Delivered");
        historyLists.add(history);*/

        Call<List<SenderOrder>> call = ((MainActivity)getActivity()).apiService.getMyBayHistory();
        call.enqueue(new Callback<List<SenderOrder>>() {
            @Override
            public void onResponse(Call<List<SenderOrder>> call, Response<List<SenderOrder>> response) {
                historyLists = response.body();
                mAdapter = new HistoryAdapter(historyLists);
            }

            @Override
            public void onFailure(Call<List<SenderOrder>> call, Throwable t) {
                Toast.makeText(getActivity(), "Incorrect Request", Toast.LENGTH_LONG).show();
            }
        });

    }

}
