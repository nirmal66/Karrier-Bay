package Adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yourapp.developer.karrierbay.BR;
import com.yourapp.developer.karrierbay.R;

import java.util.List;

import Model.SenderOrder;
import Utilities.CustomViewHolder;
import Model.User;

/**
 * Created by carl on 12/1/15.
 */

public class MyAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<SenderOrder> orderList;
private  User user;
    public MyAdapter(List<SenderOrder> orderList,User user) {
        this.orderList = orderList;
        this.user=user;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.row_carrier_list, viewGroup, false);
        
        return new CustomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        ViewDataBinding viewDataBinding = customViewHolder.getViewDataBinding();

        viewDataBinding.setVariable(BR.sender, orderList.get(i));
        viewDataBinding.setVariable(BR.senderitems, orderList.get(i).getSender_order_item()[0]);
        viewDataBinding.setVariable(BR.item,orderList.get(i).getSender_order_item()[0].getItem_attributes());
        viewDataBinding.setVariable(BR.user,user);
    }

    @Override
    public int getItemCount() {
        return (null != orderList ? orderList.size() : 0);
    }
}