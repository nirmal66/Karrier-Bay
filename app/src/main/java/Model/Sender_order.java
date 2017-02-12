package Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


/**
 * Created by vel on 11/2/17.
 */

public class Sender_order extends BaseObservable {
    private String to_geo_long;

    private Pickup_order_mapping pickup_order_mapping;

    private Sender_order_item_attributes[] sender_order_item_attributes;

    private Receiver_order_mapping receiver_order_mapping;

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

    public Pickup_order_mapping getPickup_order_mapping() {
        return pickup_order_mapping;
    }

    public void setPickup_order_mapping(Pickup_order_mapping pickup_order_mapping) {
        this.pickup_order_mapping = pickup_order_mapping;
    }

    public Sender_order_item_attributes[] getSender_order_item_attributes() {
        return sender_order_item_attributes;
    }

    public void setSender_order_item_attributes(Sender_order_item_attributes[] sender_order_item_attributes) {
        this.sender_order_item_attributes = sender_order_item_attributes;
    }

    public Receiver_order_mapping getReceiver_order_mapping() {
        return receiver_order_mapping;
    }

    public void setReceiver_order_mapping(Receiver_order_mapping receiver_order_mapping) {
        this.receiver_order_mapping = receiver_order_mapping;
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
//    @Bindable
//    public Pickup_order_mapping getPickup_order_mapping() {
//        if (pickup_order_mapping == null) {
//            pickup_order_mapping = new Pickup_order_mapping();
//        }
//        return pickup_order_mapping;
//    }
//
//    public void setPickup_order_mapping(Pickup_order_mapping pickup_order_mapping) {
//        this.pickup_order_mapping = pickup_order_mapping;
////        notifyPropertyChanged(BR.pickup_order_mapping);
//
//    }
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
//    public Sender_order_item_attributes[] getSender_order_item_attributes() {
//        if (sender_order_item_attributes == null || sender_order_item_attributes.length == 0) {
//            sender_order_item_attributes = new Sender_order_item_attributes[1];
//            sender_order_item_attributes[0] = new Sender_order_item_attributes();
//        }
//        return sender_order_item_attributes;
//    }
//
//    @Bindable
//    public void setSender_order_item_attributes(Sender_order_item_attributes[] sender_order_item_attributes) {
//        this.sender_order_item_attributes = sender_order_item_attributes;
//    }
//
//    @Bindable
//    public Receiver_order_mapping getReceiver_order_mapping() {
//        if (receiver_order_mapping == null) {
//            receiver_order_mapping = new Receiver_order_mapping();
//        }
//
//        return receiver_order_mapping;
//    }
//
//    @Bindable
//    public void setReceiver_order_mapping(Receiver_order_mapping receiver_order_mapping) {
//        this.receiver_order_mapping = receiver_order_mapping;
//    }
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
//        return "ClassPojo [to_geo_long = " + to_geo_long + ", pickup_order_mapping = " + pickup_order_mapping + ", from_geo_lat = " + from_geo_lat + ", from_loc = " + from_loc + ", to_geo_lat = " + to_geo_lat + ", to_loc = " + to_loc + ", from_geo_long = " + from_geo_long + ", isInsured = " + isInsured + ", sender_order_item_attributes = " + sender_order_item_attributes + ", receiver_order_mapping = " + receiver_order_mapping + ", comments = " + comments + "]";
//    }
}