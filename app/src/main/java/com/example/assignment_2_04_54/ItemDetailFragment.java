package com.example.assignment_2_04_54;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment_2_04_54.dummy.DummyContentItem;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private DummyContentItem.DummyItem mItem;

    public ItemDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = DummyContentItem.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        TextView txt = (TextView) rootView.findViewById(R.id.item_detail);
        ImageView img = (ImageView) rootView.findViewById(R.id.item_preview);
        Typeface font = ResourcesCompat.getFont(this.getContext(), R.font.pop_light);
        txt.setTypeface(font);
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.details);
            ((ImageView) rootView.findViewById(R.id.item_preview)).setBackgroundResource(mItem.image);
        }
        return rootView;
    }
}
