package Model;

/**
 * Created by vel on 11/2/17.
 */




public class Item_attributes
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

    private String item_weight;

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

    public String getLength ()
    {
        return length;
    }

    public void setLength (String length)
    {
        this.length = length;
    }

    public String getItem_weight ()
    {
        return item_weight;
    }

    public void setItem_weight (String item_weight)
    {
        this.item_weight = item_weight;
    }


}

