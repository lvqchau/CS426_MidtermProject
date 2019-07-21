package com.example.assignment_2_04_54;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment_2_04_54.dummy.DummyContent;
import com.example.assignment_2_04_54.dummy.DummyContent.DummyItem;
import com.example.assignment_2_04_54.dummy.DummyContentItem;

import java.util.List;

public class ContactFragment extends Fragment  {

    public static final String ARG_ITEM_ID = "item_id";

    private DummyContent.DummyItem mItem;
    private RecyclerView mRecycleView;
    private MyContactRecyclerViewAdapter mMyContactRecyclerViewAdapter;

    public ContactFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact_list, container, false);
        mRecycleView = (RecyclerView)rootView.findViewById(R.id.contact_list);
        mMyContactRecyclerViewAdapter = new MyContactRecyclerViewAdapter(getActivity(), DummyContent.ITEMS);
        mRecycleView.setAdapter(mMyContactRecyclerViewAdapter);
        return rootView;
    }
}
