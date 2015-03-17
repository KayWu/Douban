package com.kay.douban;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class PagerFragment extends android.support.v4.app.Fragment {
    private int pageNum;
    private TextView tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View pager = inflater.inflate(R.layout.pager_fragment, container, false);

        tv = (TextView) pager.findViewById(R.id.tv);
        Bundle bundle = getArguments();
        pageNum = bundle.getInt("page_num");
        tv.setText("" + pageNum);
        return pager;
    }


}
