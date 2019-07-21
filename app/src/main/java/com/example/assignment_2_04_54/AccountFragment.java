package com.example.assignment_2_04_54;

import android.Manifest;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class AccountFragment extends Fragment implements View.OnClickListener {
    ImageView imageview;
    final int ACTIVITY_SELECT_IMAGE = 1234;
    String imgDecodableString;
    Button outBtn;
    FrameLayout view2;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        FloatingActionButton fab_call = view.findViewById(R.id.call_btn);
        FloatingActionButton fab_camera = view.findViewById(R.id.camera_btn);
        outBtn = view.findViewById(R.id.signout_btn);
        ImageButton i_map = view.findViewById(R.id.map_btn);
        imageview = view.findViewById(R.id.profile_image);
        view2 = view.findViewById(R.id.item_detail_container);

        fab_call.setOnClickListener(this);
        fab_camera.setOnClickListener(this);
        i_map.setOnClickListener(this);
        outBtn.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.call_btn:
                String phone = "0949998353";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
                break;
            case R.id.camera_btn:
                Intent i = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
                break;
            case R.id.map_btn:
                Fragment newFragment = new MapFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack("tag");
                transaction.commit();
                break;
            case R.id.signout_btn:

                if (MainActivity.mTwoPane == true) {
                    view2.setVisibility(View.GONE);

                    Intent in = new Intent(getActivity(), ListActivity.class);
                    startActivity(in);

                }
                else {
                    Intent in = new Intent(getActivity(), ListActivity.class);
                    startActivity(in);
                }


                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == Activity.RESULT_OK) {
        }
        Uri returnUri;
        returnUri = data.getData();

        Glide.with(this)
                .load(returnUri)
                .override(1280, 1280)
                .centerCrop()
                .crossFade()
                .into(imageview);

    }

}

