package Model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;
import com.yourapp.developer.karrierbay.BR;

public   class SenderOrderRequest  extends BaseObservable {

//    private int spinWantToSendIdx = 1;
//
//    @Bindable
//    public int getSpinWantToSendIdx() {
//        return spinWantToSendIdx;
//    }
//
//    public void setSpinWantToSendIdx(int spinWantToSendIdx) {
//        this.spinWantToSendIdx = spinWantToSendIdx;
//        notifyPropertyChanged(BR.spinWantToSendIdx);
//    }
    @SerializedName("sender_order")
    public SenderOrder SenderOrder;

    public SenderOrder getSenderOrder()
    {
        if(SenderOrder ==null)
        {
            SenderOrder =new SenderOrder();
        }
        return SenderOrder;
    }

    public void setSenderOrder(SenderOrder SenderOrder)
    {
        this.SenderOrder = SenderOrder;
        notifyPropertyChanged(BR.sender);
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SenderOrder = "+ SenderOrder +"]";
    }
}