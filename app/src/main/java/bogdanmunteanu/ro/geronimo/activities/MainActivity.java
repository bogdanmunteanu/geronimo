package bogdanmunteanu.ro.geronimo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


import bogdanmunteanu.ro.geronimo.R;
import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.main_layout)
    RelativeLayout mainLayout;

    @BindView(R.id.add_button)
    Button addButton;

    @BindView(R.id.delete_button)
    Button deleteButton;

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    MainActivityPresenter presenter = new MainActivityPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        toolbarTitle.setText(R.string.app_name);
        //attach the presenter
        presenter.attachPresenter(this);
        //






    }



}
