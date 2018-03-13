package bogdanmunteanu.ro.geronimo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import bogdanmunteanu.ro.geronimo.R;
import bogdanmunteanu.ro.geronimo.model.Item;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bogdan Munteanu
 * Adapter that controls data and child views in recyclerview
 * Includes a static class that holds data references for child views
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
    public void onBindViewHolder(final AdapterHolder holder, final int position) {


        //Load image
        Picasso.with(context)
                .load(items.get(position).imageUrl)
                .fit()
                .error(R.drawable.ic_signal_wifi_off)
                .into(holder.image);

        holder.title.setText("Beautiful image");
        holder.subtitle.setText(items.get(position).imageUrl);

        holder.detailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,items.get(position).title+" "+items.get(position).imageUrl,Toast.LENGTH_LONG);
            }
        });

        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, items.get(position).title+" "+items.get(position).imageUrl);
                    context.startActivity(Intent.createChooser(sharingIntent, "Share"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem()
    {
        items.add(1,new Item("Beautiful image"));
        this.notifyDataSetChanged();
    }

    public void removeItem()
    {
        items.remove(0);
        this.notifyDataSetChanged();
    }

    public void resetList()
    {
        items.clear();
        for (int i=0;i<5;i++)
        {
            items.add(new Item("Beautiful image"));
        }
        this.notifyDataSetChanged();
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

