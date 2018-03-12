package bogdanmunteanu.ro.geronimo.activities;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import bogdanmunteanu.ro.geronimo.model.Item;

/**
 * Created by Bogdan on 3/12/2018.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;

    @Override
    public void attachPresenter(MainActivityContract.View listener) {
        this.view=listener;
    }

    @Override
    public void detachPresenter() {
        view=null;
    }

    @Override
    public boolean isAttached() {
        return view !=null;
    }

    @Override
    public ArrayList<Item> initList() {
       ArrayList<Item> items =  new ArrayList<>();
       for(int i = 0;i<5;i++)
       {
           items.add(new Item("Beautiful image"));
           Log.d(this.getClass().getSimpleName(),items.get(i).toString());
       }
       return items;
    }



}
