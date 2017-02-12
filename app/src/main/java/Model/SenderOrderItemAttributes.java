package Model;

import android.databinding.BaseObservable;

/**
 * Created by vel on 11/2/17.
 */

public class SenderOrderItemAttributes extends BaseObservable {
    private ItemAttributes item_attributes;
    private String total_amount;


    private String id;

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    private String updated_at;

    private String tax;

    private String img;

    private String created_at;


    private String order_id;

    private String unit_price;


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

    public ItemAttributes getItem_attributes() {
        if (item_attributes == null) {
            item_attributes = new ItemAttributes();
        }

        return item_attributes;
    }

    public void setItem_attributes(ItemAttributes item_attributes) {
        this.item_attributes = item_attributes;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItem_subtype() {
        return item_subtype;
    }

    public void setItem_subtype(String item_subtype) {
        this.item_subtype = item_subtype;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    @Override
    public String toString() {
        return "ClassPojo [item_attributes = " + item_attributes + ", quantity = " + quantity + ", item_subtype = " + item_subtype + ", item_type = " + item_type + "]";
    }
}

