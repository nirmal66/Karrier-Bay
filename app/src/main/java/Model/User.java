package Model;

import android.databinding.ObservableField;

/**
 * Created by vel on 24/1/17.
 */





public class User  {
    private String firstName;
    private String spinCategory="Luggage";
    private int spinCategoryIdx=1;
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

    public int getSpinCategoryIdx() {
        return spinCategoryIdx;
    }

    public void setSpinCategoryIdx(int spinCategoryIdx) {
        this.spinCategoryIdx = spinCategoryIdx;
    }
    private ObservableField<String> text;

    public ObservableField<String> getText() {
        return text;
    }
}