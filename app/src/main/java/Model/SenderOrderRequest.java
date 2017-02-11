package Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.yourapp.developer.karrierbay.BR;

public   class SenderOrderRequest  extends BaseObservable {

    private int spinWantToSendIdx = 1;

    @Bindable
    public int getSpinWantToSendIdx() {
        return spinWantToSendIdx;
    }

    public void setSpinWantToSendIdx(int spinWantToSendIdx) {
        this.spinWantToSendIdx = spinWantToSendIdx;
        notifyPropertyChanged(BR.spinWantToSendIdx);
    }
    public Sender_order sender_order;

    public Sender_order getSender_order ()
    {
        return sender_order;
    }

    public void setSender_order (Sender_order sender_order)
    {
        this.sender_order = sender_order;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sender_order = "+sender_order+"]";
    }
}