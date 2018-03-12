package bogdanmunteanu.ro.geronimo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import bogdanmunteanu.ro.geronimo.R;
import bogdanmunteanu.ro.geronimo.model.Item;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bogdan on 3/12/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterHolder>{

    private Context context;
    private ArrayList<Item> items;

    public RecyclerAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new RecyclerAdapter.AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, int position) {


        //Load image
        Picasso.with(context)
                .load(items.get(position).imageUrl)
                .fit()
                .error(R.drawable.ic_signal_wifi_off)
                .into(holder.image);

        holder.title.setText("Beautiful image");
        holder.subtitle.setText(items.get(position).imageUrl);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    static class AdapterHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.subtitle)
        TextView subtitle;

        @BindView(R.id.details_btn)
        Button detailsBtn;

        @BindView(R.id.share_btn)
        Button shareBtn;

        AdapterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

