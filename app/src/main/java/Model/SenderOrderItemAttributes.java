package Model;

import android.databinding.BaseObservable;

/**
 * Created by vel on 11/2/17.
 */

public class SenderOrderItemAttributes extends BaseObservable
{
    private ItemAttributes item_attributes;

    private String quantity;

    public int getItem_subtype_index() {
        return item_subtype_index;
    }

    public void setItem_subtype_index(int item_subtype_index) {
        this.item_subtype_index = item_subtype_index;
    }

    public int getItem_type_index() {
        return item_type_index;
    }

    public void setItem_type_index(int item_type_index) {
        this.item_type_index = item_type_index;
    }

    private String item_subtype;

    private String item_type;

    private int item_type_index;

    private int item_subtype_index;

    public ItemAttributes getItem_attributes ()
    {
        if(item_attributes==null)
        {
            item_attributes=new ItemAttributes();
        }

        return item_attributes;
    }

    public void setItem_attributes (ItemAttributes item_attributes)
    {
        this.item_attributes = item_attributes;
    }

    public String getQuantity ()
    {
        return quantity;
    }

    public void setQuantity (String quantity)
    {
        this.quantity = quantity;
    }

    public String getItem_subtype ()
    {
        return item_subtype;
    }

    public void setItem_subtype (String item_subtype)
    {
        this.item_subtype = item_subtype;
    }

    public String getItem_type ()
    {
        return item_type;
    }

    public void setItem_type (String item_type)
    {
        this.item_type = item_type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [item_attributes = "+item_attributes+", quantity = "+quantity+", item_subtype = "+item_subtype+", item_type = "+item_type+"]";
    }
}

