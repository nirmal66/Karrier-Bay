package Model;

/**
 * Created by vel on 28/1/17.
 */


import android.databinding.ObservableArrayList;
        import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DataList {
    public List<User> list = new ArrayList<>();
    private int mTotalCount;

    public DataList() {
        for (mTotalCount =1; mTotalCount <11; ++mTotalCount) {
            add(new User("vel"));
        }
    }

    // Called on add button click
//    public void add(View v) {
//        list.add(new User(android.R.drawable.sym_def_app_icon, "icon_" + mTotalCount++));
//    }

    // Called on remove button click
    public void remove(View v) {
        if (!list.isEmpty()) {
            list.remove(0);
        }
    }

    private void add(User info) {
        list.add(info);
    }
}