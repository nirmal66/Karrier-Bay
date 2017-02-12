package Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.yourapp.developer.karrierbay.BR;


/**
 * Created by vel on 11/2/17.
 */

public class SenderOrder extends BaseObservable {
    private String to_geo_long;
    private int spinWantToSendIdx = 1;

    @Bindable
    public int getSpinWantToSendIdx() {
        return spinWantToSendIdx;
    }

    public void setSpinWantToSendIdx(int spinWantToSendIdx) {
        this.spinWantToSendIdx = spinWantToSendIdx;
        notifyPropertyChanged(BR.spinWantToSendIdx);
    }
    @SerializedName("pickup_orderMapping")
    private PickupOrderMapping pickupOrderMapping;

    private SenderOrderItemAttributes[] sender_order_item_attributes;
    @SerializedName("receiver_orderMapping")
    private ReceiverOrderMapping receiverOrderMapping;

    private String from_geo_lat;

    private String from_loc;

    private int from_loc_index;

    private String to_geo_lat;

    public String getTo_geo_long() {
        return to_geo_long;
    }

    public void setTo_geo_long(String to_geo_long) {
        this.to_geo_long = to_geo_long;
    }

    @Bindable
    public PickupOrderMapping getPickupOrderMapping() {
        if (pickupOrderMapping == null) {
            pickupOrderMapping = new PickupOrderMapping();
        }
        return pickupOrderMapping;
    }

    public void setPickupOrderMapping(PickupOrderMapping pickupOrderMapping) {
        this.pickupOrderMapping = pickupOrderMapping;


    }


    public SenderOrderItemAttributes[] getSender_order_item_attributes() {
        if (sender_order_item_attributes == null || sender_order_item_attributes.length == 0) {
            sender_order_item_attributes = new SenderOrderItemAttributes[1];
            sender_order_item_attributes[0] = new SenderOrderItemAttributes();
        }
        return sender_order_item_attributes;
    }

    public void setSender_order_item_attributes(SenderOrderItemAttributes[] sender_order_item_attributes) {
        this.sender_order_item_attributes = sender_order_item_attributes;
    }

    @Bindable
    public ReceiverOrderMapping getReceiverOrderMapping() {
        if (receiverOrderMapping == null) {
            receiverOrderMapping = new ReceiverOrderMapping();
        }

        return receiverOrderMapping;
    }

    @Bindable
    public void setReceiverOrderMapping(ReceiverOrderMapping receiverOrderMapping) {
        this.receiverOrderMapping = receiverOrderMapping;
    }


    public String getFrom_geo_lat() {
        return from_geo_lat;
    }

    public void setFrom_geo_lat(String from_geo_lat) {
        this.from_geo_lat = from_geo_lat;
    }

    public String getFrom_loc() {
        return from_loc;
    }

    public void setFrom_loc(String from_loc) {
        this.from_loc = from_loc;
    }

    public int getFrom_loc_index() {
        return from_loc_index;
    }

    public void setFrom_loc_index(int from_loc_index) {
        this.from_loc_index = from_loc_index;
    }

    public String getTo_geo_lat() {
        return to_geo_lat;
    }

    public void setTo_geo_lat(String to_geo_lat) {
        this.to_geo_lat = to_geo_lat;
    }
//
//    @Bindable
//    public int getFrom_loc_index() {
//        return from_loc_index;
//    }
//
//    @Bindable
//    public void setFrom_loc_index(int from_loc_index) {
//        this.from_loc_index = from_loc_index;
//    }
//
//    private String to_loc;
//
//    private int to_loc_index;
//
//    @Bindable
//    public int getTo_loc_index() {
//        return to_loc_index;
//    }
//
//    @Bindable
//    public void setTo_loc_index(int to_loc_index) {
//        this.to_loc_index = to_loc_index;
//    }
//
//    private String from_geo_long;
//
//    private String isInsured;
//
//
//    private String comments;
//
//    @Bindable
//    public String getTo_geo_long() {
//        return to_geo_long;
//    }
//
//    @Bindable
//    public void setTo_geo_long(String to_geo_long) {
//        this.to_geo_long = to_geo_long;
//    }
//

//
//    @Bindable
//    public String getFrom_geo_lat() {
//        return from_geo_lat;
//    }
//
//    @Bindable
//    public void setFrom_geo_lat(String from_geo_lat) {
//        this.from_geo_lat = from_geo_lat;
//    }
//
//    @Bindable
//    public String getFrom_loc() {
//        return from_loc;
//    }
//
//    @Bindable
//    public void setFrom_loc(String from_loc) {
//        this.from_loc = from_loc;
//    }
//
//    @Bindable
//    public String getTo_geo_lat() {
//        return to_geo_lat;
//    }
//
//    @Bindable
//    public void setTo_geo_lat(String to_geo_lat) {
//        this.to_geo_lat = to_geo_lat;
//    }
//
//    @Bindable
//    public String getTo_loc() {
//        return to_loc;
//    }
//
//    @Bindable
//    public void setTo_loc(String to_loc) {
//        this.to_loc = to_loc;
//    }
//
//    @Bindable
//    public String getFrom_geo_long() {
//        return from_geo_long;
//    }
//
//    @Bindable
//    public void setFrom_geo_long(String from_geo_long) {
//        this.from_geo_long = from_geo_long;
//    }
//
//    @Bindable
//    public String getIsInsured() {
//        return isInsured;
//    }
//
//    @Bindable
//    public void setIsInsured(String isInsured) {
//        this.isInsured = isInsured;
//    }
//
//    @Bindable
//    public SenderOrderItemAttributes[] getSender_order_item_attributes() {
//        if (sender_order_item_attributes == null || sender_order_item_attributes.length == 0) {
//            sender_order_item_attributes = new SenderOrderItemAttributes[1];
//            sender_order_item_attributes[0] = new SenderOrderItemAttributes();
//        }
//        return sender_order_item_attributes;
//    }
//
//    @Bindable
//    public void setSender_order_item_attributes(SenderOrderItemAttributes[] sender_order_item_attributes) {
//        this.sender_order_item_attributes = sender_order_item_attributes;
//    }
//

//
//    @Bindable
//    public String getComments() {
//        return comments;
//    }
//
//    @Bindable
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    @Override
//    @Bindable
//    public String toString() {
//        return "ClassPojo [to_geo_long = " + to_geo_long + ", pickupOrderMapping = " + pickupOrderMapping + ", from_geo_lat = " + from_geo_lat + ", from_loc = " + from_loc + ", to_geo_lat = " + to_geo_lat + ", to_loc = " + to_loc + ", from_geo_long = " + from_geo_long + ", isInsured = " + isInsured + ", sender_order_item_attributes = " + sender_order_item_attributes + ", receiverOrderMapping = " + receiverOrderMapping + ", comments = " + comments + "]";
//    }
}