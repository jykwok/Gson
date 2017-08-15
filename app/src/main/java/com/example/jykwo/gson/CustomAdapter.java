package com.example.jykwo.gson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jykwo on 6/11/2017.
 */

public class CustomAdapter extends BaseAdapter{
    private List<Response.DataBean> mJournalitem;
    private Context mContext;
    private LayoutInflater inflater;

    public CustomAdapter(Context mContext,List<Response.DataBean> mJournalitem) {
        this.mContext = mContext;
        this.mJournalitem = mJournalitem;

    }

    @Override
    public int getCount() {
        return mJournalitem.size();
    }

    @Override
    public Object getItem(int position) {
        return mJournalitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.each_list_view,parent, false);

        Response.DataBean item = (Response.DataBean) getItem(position);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView url = (TextView) rowView.findViewById(R.id.url);

        title.setText(item.getTitle());
        url.setText((CharSequence) item.getFulltextUrls());

        return rowView;
    }
}
