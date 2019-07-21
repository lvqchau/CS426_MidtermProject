package com.example.assignment_2_04_54;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.assignment_2_04_54.dummy.DummyContent;
import com.example.assignment_2_04_54.dummy.DummyContent.DummyItem;
import java.util.List;

public class MyContactRecyclerViewAdapter extends RecyclerView.Adapter<MyContactRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    Context context;

    public MyContactRecyclerViewAdapter(Context context, List<DummyItem> items) {
        this.context = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mPhoneView.setText(mValues.get(position).phoneNumber);
        holder.mContactView.setText(mValues.get(position).contactName);
        holder.mImageView.setImageResource(mValues.get(position).image);
        holder.mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = holder.mPhoneView.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContactView;
        public final TextView mPhoneView;
        public final ImageButton mPhone;
        public final ImageView mImageView;
        public DummyContent.DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id_contact);
            mContactView = (TextView) view.findViewById(R.id.contactname);
            mPhoneView = (TextView) view.findViewById(R.id.phonenumber);
            mPhone = view.findViewById(R.id.contact_call);
            mImageView = view.findViewById(R.id.contact_avatar);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContactView.getText() + "'";
        }
    }
}
