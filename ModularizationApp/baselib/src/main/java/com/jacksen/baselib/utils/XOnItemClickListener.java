package com.jacksen.baselib.utils;

import android.view.View;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by jacksen on 2017/7/27.
 */

public abstract class XOnItemClickListener implements RecyclerArrayAdapter.OnItemClickListener {

    public abstract void onItemClick(View view, int position);

    @Override
    public void onItemClick(int position) {

    }
}
