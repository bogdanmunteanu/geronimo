package bogdanmunteanu.ro.geronimo.activities;

import java.util.ArrayList;

import bogdanmunteanu.ro.geronimo.model.Item;

/**
 * Created by Bogdan on 3/12/2018.
 */

public interface MainActivityContract {

    interface View
    {


    }

    interface Presenter
    {
        void attachPresenter(MainActivityContract.View view);

        void detachPresenter();

        boolean isAttached();

        ArrayList<Item> initList();

    }
}
