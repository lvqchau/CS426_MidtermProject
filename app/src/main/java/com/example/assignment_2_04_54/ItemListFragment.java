package com.example.assignment_2_04_54;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.assignment_2_04_54.dummy.DummyContentItem;

import static android.support.constraint.Constraints.TAG;
import static android.view.View.GONE;
import static com.example.assignment_2_04_54.ItemDetailFragment.ARG_ITEM_ID;
import static com.example.assignment_2_04_54.MainActivity.mTwoPane;


public class ItemListFragment extends Fragment implements  View.OnClickListener {
//        implements View.OnClickListener {


    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContentItem.DummyItem mItem;
    private RecyclerView mRecycleView;
    private SimpleItemRecyclerViewAdapter mSimpleItemRecyclerViewAdapter;
    public ItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        mRecycleView = (RecyclerView)view.findViewById(R.id.item_list);
        mSimpleItemRecyclerViewAdapter = new SimpleItemRecyclerViewAdapter(getActivity(), DummyContentItem.ITEMS);
        mRecycleView.setAdapter(mSimpleItemRecyclerViewAdapter);


        FloatingActionButton fab_add = view.findViewById(R.id.add_btn);
        fab_add.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_btn:

                //AddFragment here
                Fragment newFragment = new ProductAdd();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                if (mTwoPane==true) {
                    transaction.replace(R.id.item_detail_container, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else {
                    transaction.replace(R.id.fragment_container, newFragment);
                    transaction.addToBackStack( "tag" );
                    transaction.commit();
                }



                break;
        }
    }
}
