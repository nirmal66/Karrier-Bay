package Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yourapp.developer.karrierbay.R;

import Adapter.MyAdapter;
import Model.DataList;

public class CarrierListFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.carrier_mainlayout, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     //   RowCarrierListBinding binding = DataBindingUtil.inflate(inflater, R.layout.row_carrier_list, container, false);

      RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
       mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        MyAdapter mAdapter = new MyAdapter(new DataList().list);
        mRecyclerView.setAdapter(mAdapter);
//
//        FragmentDemoBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_demo, container, false);
//        final UserViewModel userViewModel = new UserViewModel();
//        userViewModel.setUser(new User("王浩", "12345678912", 24, true));
//        binding.setFragmentUserViewModel(userViewModel);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                userViewModel.setUser(new User("新用户名哈哈", "12345678912", 24, false));
//            }
//        }, 3000);

//        return binding.getRoot();

    }

}
