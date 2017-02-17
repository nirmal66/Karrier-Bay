package Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by vel on 16/2/17.
 */

public class CarrierScheduleDetailAttributes extends BaseObservable {
    private String end_time;

    private String capacity;

    private String start_time;

    private String mode;

    public String getPassengercount() {
        return passengercount;
    }

    public void setPassengercount(String passengercount) {
        this.passengercount = passengercount;
    }

    private String passengercount;

    public String getEnd_time ()
    {
        return end_time;
    }

    public void setEnd_time (String end_time)
    {
        this.end_time = end_time;
    }

    public String getCapacity ()
    {
        return capacity;
    }

    public void setCapacity (String capacity)
    {
        this.capacity = capacity;
    }

    public String getStart_time ()
    {
        return start_time;
    }

    public void setStart_time (String start_time)
    {
        this.start_time = start_time;
    }

    public String getMode ()
    {
        return mode;
    }

    public void setMode (String mode)
    {
        this.mode = mode;
    }

}
