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
           items.add(new Item("Beautiful image",getRandomPictureUrl(),getRandomPictureUrl()));
           Log.d(this.getClass().getSimpleName(),items.get(i).toString());
       }
       return items;
    }

    public static String  getRandomPictureUrl()
    {
        String url = "http://picsum.photos/500/300/?image=";
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(1000);
        StringBuilder builder = new StringBuilder();
        builder.append(url);
        builder.append(randomNumber);
        return builder.toString();
    }

}
