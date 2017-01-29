package Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.yourapp.developer.karrierbay.BR;

/**
 * Created by vel on 24/1/17.
 */





public class User  extends BaseObservable{
    private String firstName;
    private String spinCategory="Luggage";
    private int spinWantToSendIdx =1;
    public User(String firstName) {
        this.firstName = firstName;
        text = new ObservableField<>();
     }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSpinCategory() {
        return spinCategory;
    }

    public void setSpinCategory(String spinCategory) {
        this.spinCategory = spinCategory;
    }
    @Bindable
    public int getSpinWantToSendIdx() {
        return spinWantToSendIdx;
    }

    public void setSpinWantToSendIdx(int spinWantToSendIdx) {
        this.spinWantToSendIdx = spinWantToSendIdx;
        notifyPropertyChanged(BR.spinWantToSendIdx);
    }
    private ObservableField<String> text;

    public ObservableField<String> getText() {
        return text;
    }
}