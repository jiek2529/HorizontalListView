package com.jk.hlv;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jk.hlv.view.CustomData;
import com.jk.hlv.view.HorizontalListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    HorizontalListView hlv;
    private MyAdapter myAdapter;

    ArrayList<CustomData> list = new ArrayList() {{
        add(new CustomData(Color.LTGRAY, "Light Gray"));
        add(new CustomData(Color.DKGRAY, "Dark Gray"));
        add(
                new CustomData(Color.GREEN, "Green"));
        add(
                new CustomData(Color.LTGRAY, "Light Gray"));
        add(
                new CustomData(Color.WHITE, "White"));
        add(
                new CustomData(Color.RED, "Red"));
        add(
                new CustomData(Color.BLACK, "Black"));
        add(
                new CustomData(Color.CYAN, "Cyan"));
//        add(
//                new CustomData(Color.DKGRAY, "Dark Gray"));
//        add(
//                new CustomData(Color.GREEN, "Green"));
//        add(
//                new CustomData(Color.RED, "Red"));
//        add(
//                new CustomData(Color.LTGRAY, "Light Gray"));
//        add(
//                new CustomData(Color.WHITE, "White"));
//        add(
//                new CustomData(Color.BLACK, "Black"));
//        add(
//                new CustomData(Color.CYAN, "Cyan"));
//        add(
//                new CustomData(Color.DKGRAY, "Dark Gray"));
//        add(
//                new CustomData(Color.GREEN, "Green"));
//        add(
//                new CustomData(Color.LTGRAY, "Light Gray"));
//        add(
//                new CustomData(Color.RED, "Red"));
//        add(
//                new CustomData(Color.WHITE, "White"));
//        add(
//                new CustomData(Color.DKGRAY, "Dark Gray"));
//        add(
//                new CustomData(Color.GREEN, "Green"));
//        add(
//                new CustomData(Color.LTGRAY, "Light Gray"));
//        add(
//                new CustomData(Color.WHITE, "White"));
//        add(
//                new CustomData(Color.RED, "Red"));
//        add(
//                new CustomData(Color.BLACK, "Black"));
//        add(
//                new CustomData(Color.CYAN, "Cyan"));
//        add(
//                new CustomData(Color.DKGRAY, "Dark Gray"));
//        add(
//                new CustomData(Color.GREEN, "Green"));
//        add(
//                new CustomData(Color.LTGRAY, "Light Gray"));
//        add(
//                new CustomData(Color.RED, "Red"));
//        add(
//                new CustomData(Color.WHITE, "White"));
//        add(
//                new CustomData(Color.BLACK, "Black"));
//        add(
//                new CustomData(Color.CYAN, "Cyan"));
//        add(
//                new CustomData(Color.DKGRAY, "Dark Gray"));
//        add(
//                new CustomData(Color.GREEN, "Green"));
//        add(
//                new CustomData(Color.LTGRAY, "Light Gray"));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hlv = (HorizontalListView) findViewById(R.id.hlv);
        myAdapter = new MyAdapter();
        hlv.setAdapter(myAdapter);
        hlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                t("position: " + position);
            }
        });
    }


    public void click_add(View view) {
        list.add(new CustomData(Color.WHITE, "White"));
        list.add(new CustomData(Color.BLACK, "Black"));
        myAdapter.notifyDataSetChanged();
    }

    private void t(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    class MyAdapter extends BaseAdapter {

        private final LayoutInflater mInflater;

        MyAdapter() {
            mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_ll, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tv.setText(list.get(position).getText());
            holder.rootView.setBackgroundColor(list.get(position).getBackgroundColor());
            return convertView;
        }

        public class ViewHolder {
            public View rootView;
            public TextView tv;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.tv = (TextView) rootView.findViewById(R.id.tv);
            }

        }
    }

    private Context getContext() {
        return this;
    }
}
