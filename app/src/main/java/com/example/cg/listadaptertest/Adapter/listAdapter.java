package com.example.cg.listadaptertest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cg.listadaptertest.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16 0016.
 */
public class listAdapter extends BaseAdapter {

    private List<String> list_data;
    private LayoutInflater inflater;

    public listAdapter(List<String> list_data, Context context) {
        this.list_data = list_data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list_data.size();
    }

    @Override
    public Object getItem(int i) {
        return list_data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        myInfo mInfo;
        if(view==null)
        {
            mInfo = new myInfo();
            view = inflater.inflate(R.layout.list_item,null);
            mInfo.name = (TextView)view.findViewById(R.id.name);

            view.setTag(mInfo);
        }
        else
        {
            mInfo = (myInfo) view.getTag();
        }

        mInfo.name.setText(list_data.get(i));

        return view;
    }

    class myInfo
    {
        TextView name;
    }
}
