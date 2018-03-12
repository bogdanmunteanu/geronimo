package bogdanmunteanu.ro.geronimo.activities;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;



import bogdanmunteanu.ro.geronimo.R;
import bogdanmunteanu.ro.geronimo.adapters.RecyclerAdapter;

import bogdanmunteanu.ro.geronimo.helpers.NetworkHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    public static int CONNECTION_REQUEST = 99;

    @BindView(R.id.main_layout)
    RelativeLayout mainLayout;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    MainActivityPresenter presenter = new MainActivityPresenter();
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //toolbarTitle.setText(R.string.app_name);
        //attach the presenter
        presenter.attachPresenter(this);
        //prepare recyclerview list
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //prepare list of elements
        adapter = new RecyclerAdapter(this,presenter.initList());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        if(!NetworkHelper.isNetworkAvailable(this))
        {
            Snackbar snackbar = Snackbar
                    .make(mainLayout, "There is no Internet connection.", Snackbar.LENGTH_INDEFINITE)
                    .setAction("GO TO SETTINGS", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                            startActivityForResult(intent,CONNECTION_REQUEST);
                        }
                    });

            snackbar.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
                adapter.addItem();
                return true;
            }

            case R.id.action_remove: {
                adapter.removeItem();
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onPause() {
        presenter.detachPresenter();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachPresenter(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(requestCode == CONNECTION_REQUEST && resultCode == Activity.RESULT_OK)
       {
            adapter.resetList();
       }
    }
}
