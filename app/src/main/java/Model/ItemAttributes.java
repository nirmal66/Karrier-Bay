package Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.yourapp.developer.karrierbay.BR;

/**
 * Created by vel on 11/2/17.
 */




public class ItemAttributes extends BaseObservable
{
    private String breadth;

    private int breadthIndex;

    private String height;

    private int heightIndex;

    public int getBreadthIndex() {
        return breadthIndex;
    }

    public void setBreadthIndex(int breadthIndex) {
        this.breadthIndex = breadthIndex;
    }

    public int getHeightIndex() {
        return heightIndex;
    }

    public void setHeightIndex(int heightIndex) {
        this.heightIndex = heightIndex;
    }

    public int getLengthIndex() {
        return lengthIndex;
    }

    public void setLengthIndex(int lengthIndex) {
        this.lengthIndex = lengthIndex;
    }

    private String item_value;


    private String length;

    private int lengthIndex;

    @SerializedName("item_weight")
    private String weight;

    public String getBreadth ()
    {
        return breadth;
    }

    public void setBreadth (String breadth)
    {
        this.breadth = breadth;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getItem_value ()
    {
        return item_value;
    }

    public void setItem_value (String item_value)
    {
        this.item_value = item_value;
    }
    @Bindable
    public String getLength ()
    {
        return length;
    }

    public void setLength (String length)
    {
        this.length = length;
        notifyPropertyChanged(BR.length);
    }
    @Bindable
    public String getWeight()
    {
        return weight;
    }
    public void setWeight(String weight)
    {
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
    }


}

