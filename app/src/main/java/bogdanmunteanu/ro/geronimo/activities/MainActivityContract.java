package bogdanmunteanu.ro.geronimo.activities;

import java.util.ArrayList;

import bogdanmunteanu.ro.geronimo.model.Item;

/**
 * Main activity contract - link between view and presenter
 * Created by Bogdan Munteanu
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
