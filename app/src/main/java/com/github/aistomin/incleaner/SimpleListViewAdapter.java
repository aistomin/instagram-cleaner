package com.github.aistomin.incleaner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.aistomin.incleaner.api.Data;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by aistomin on 06.03.18.
 */
public class SimpleListViewAdapter extends ArrayAdapter<Data> {

    private Context context;
    private ArrayList<Data> data;

    public SimpleListViewAdapter(Context context, int textViewResourceId, ArrayList<Data> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View curView = convertView;
        if (curView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            curView = vi.inflate(R.layout.feed_list_view_item, null);
        }

        TextView tv_user_fullname = (TextView) curView.findViewById(R.id.tv_user_fullname);
        ImageView iv_photo = (ImageView) curView.findViewById(R.id.iv_photo);
        ImageView iv_profile = (ImageView) curView.findViewById(R.id.iv_profile);

        tv_user_fullname.setText(data.get(position).getUser().getName());

        Picasso.with(context)
            .load(data.get(position).getUser().getPicture())
            .resize(100, 100)
            .centerInside()
            .into(iv_profile);
        Picasso.with(context)
            .load(data.get(position).getImages().getResolution().getUrl())
            .into(iv_photo);

        return curView;
    }

    public void clearListView() {
        data.clear();
    }
}
