package com.kay.douban;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListRefreshFragment extends android.support.v4.app.Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout mRefreshLayout;
    private ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_refresh, container, false);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        lv = (ListView) view.findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getData()));
        return view;
    }



    @Override
    public void onRefresh() {
        mRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }

    public List<String> getData() {
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            data.add(i + "");
        }
        return data;

    }
}
