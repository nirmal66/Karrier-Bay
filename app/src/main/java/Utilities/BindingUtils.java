package Utilities;

import android.databinding.BindingAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import Model.User;

/**
 * Created by vel on 28/1/17.
 */

public class BindingUtils
{
    @BindingAdapter({"bind:selection"})
    public static void setSelection(Spinner spinner, int position)
    {
        Toast.makeText(spinner.getContext(),"Selected",Toast.LENGTH_LONG).show();
        spinner.setSelection(position);
    }

}