package Model;

public final class SenderOrderRequest {
    public final Sender_order sender_order;

    public SenderOrderRequest(Sender_order sender_order){
        this.sender_order = sender_order;
    }

    public static final class Sender_order {
        public final String from_loc;
        public final String to_loc;
        public final String comments;
        public final String from_geo_lat;
        public final String from_geo_long;
        public final String to_geo_lat;
        public final String to_geo_long;
        public final boolean isInsured;
        public final Receiver_order_mapping receiver_order_mapping;
        public final Pickup_order_mapping pickup_order_mapping;
        public final Sender_order_item_attribute sender_order_item_attributes[];

        public Sender_order(String from_loc, String to_loc, String comments, String from_geo_lat, String from_geo_long, String to_geo_lat, String to_geo_long, boolean isInsured, Receiver_order_mapping receiver_order_mapping, Pickup_order_mapping pickup_order_mapping, Sender_order_item_attribute[] sender_order_item_attributes){
            this.from_loc = from_loc;
            this.to_loc = to_loc;
            this.comments = comments;
            this.from_geo_lat = from_geo_lat;
            this.from_geo_long = from_geo_long;
            this.to_geo_lat = to_geo_lat;
            this.to_geo_long = to_geo_long;
            this.isInsured = isInsured;
            this.receiver_order_mapping = receiver_order_mapping;
            this.pickup_order_mapping = pickup_order_mapping;
            this.sender_order_item_attributes = sender_order_item_attributes;
        }

        public static final class Receiver_order_mapping {
            public final String name;
            public final String address_line_1;
            public final String address_line_2;
            public final String phone_1;
            public final String phone_2;
            public final String landmark;
            public final String pin;
            public final boolean auto_save;

            public Receiver_order_mapping(String name, String address_line_1, String address_line_2, String phone_1, String phone_2, String landmark, String pin, boolean auto_save){
                this.name = name;
                this.address_line_1 = address_line_1;
                this.address_line_2 = address_line_2;
                this.phone_1 = phone_1;
                this.phone_2 = phone_2;
                this.landmark = landmark;
                this.pin = pin;
                this.auto_save = auto_save;
            }
        }

        public static final class Pickup_order_mapping {
            public final String name;
            public final String address_line_1;
            public final String address_line_2;
            public final String phone_1;
            public final String phone_2;
            public final String landmark;
            public final String pin;
            public final boolean auto_save;

            public Pickup_order_mapping(String name, String address_line_1, String address_line_2, String phone_1, String phone_2, String landmark, String pin, boolean auto_save){
                this.name = name;
                this.address_line_1 = address_line_1;
                this.address_line_2 = address_line_2;
                this.phone_1 = phone_1;
                this.phone_2 = phone_2;
                this.landmark = landmark;
                this.pin = pin;
                this.auto_save = auto_save;
            }
        }

        public static final class Sender_order_item_attribute {
            public final long quantity;
            public final String item_type;
            public final String item_subtype;
            public final Item_attributes item_attributes;

            public Sender_order_item_attribute(long quantity, String item_type, String item_subtype, Item_attributes item_attributes){
                this.quantity = quantity;
                this.item_type = item_type;
                this.item_subtype = item_subtype;
                this.item_attributes = item_attributes;
            }

            public static final class Item_attributes {
                public final String length;
                public final String breadth;
                public final String height;
                public final String item_weight;
                public final String item_value;

                public Item_attributes(String length, String breadth, String height, String item_weight, String item_value){
                    this.length = length;
                    this.breadth = breadth;
                    this.height = height;
                    this.item_weight = item_weight;
                    this.item_value = item_value;
                }
            }
        }
    }
}