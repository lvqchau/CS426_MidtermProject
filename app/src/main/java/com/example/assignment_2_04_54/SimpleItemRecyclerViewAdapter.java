package com.example.assignment_2_04_54;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.assignment_2_04_54.dummy.DummyContentItem;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {
    private final List<DummyContentItem.DummyItem> mValues;
    private Context context;
    public Button mDeleteButton;

    public SimpleItemRecyclerViewAdapter(Context context, List<DummyContentItem.DummyItem> items) {
        this.context = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_content, parent, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mDetail.setText(mValues.get(position).details);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DummyContentItem.DummyItem item = (DummyContentItem.DummyItem) v.getTag();
                if(!MainActivity.mTwoPane){
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    ((MainActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("tag").commit();
                } else {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    ((MainActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragment).commit();
                }
            }
        });

        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValues.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,mValues.size());

            }
        });
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public CardView mCard;
        public TextView mIdView;
        public TextView mContentView;
        public TextView mDetail;
        public Button mDeleteButton;
        public DummyContentItem.DummyItem mItem;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCard = view.findViewById(R.id.cardview_list);
            mDeleteButton = view.findViewById(R.id.remove_btn);
            mIdView = (TextView) view.findViewById(R.id.id_text);
            mContentView = (TextView) view.findViewById(R.id.content);
            mDetail = (TextView) view.findViewById(R.id.detail2);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }



    }
}

