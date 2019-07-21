package com.example.assignment_2_04_54;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProductAdd extends Fragment {

    final int ACTIVITY_SELECT_IMAGE = 1234;
    String imgDecodableString;
    ImageView imageView;
    byte[] imgValue;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_additem, container, false);
        final EditText titleField = (EditText) v.findViewById(R.id.editName);
        final EditText contentField = (EditText) v.findViewById(R.id.editPrice);

        Button btnAdd = v.findViewById(R.id.btnAdd);
        Button btnChoose = v.findViewById(R.id.btnChoose);
        imageView = v.findViewById(R.id.img);


        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Fragment newFragment = new ItemListFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });



        return v;
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public byte[] convertImageToByte(Uri uri){
        byte[] data = null;
        try {
            ContentResolver cr = this.getContext().getContentResolver();
            InputStream inputStream = cr.openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == Activity.RESULT_OK) {

        }

            Uri uri = data.getData();

            String[] filePathColumn = { MediaStore.Images.Media.DATA };

                Cursor cursor = this.getContext().getContentResolver().query(uri,
                        filePathColumn, null, null, null);

                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                Glide.with(this)
                        .load(uri)
                        .override(1280, 1280)
                        .centerCrop()
                        .crossFade()
                        .into(imageView);

        Bitmap bitmap = BitmapFactory.decodeFile(imgDecodableString);
        imageView.setImageBitmap(bitmap);
        imgValue = convertImageToByte(uri);
            //imgValue = imageViewToByte(imageView);
        }



//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if(requestCode == REQUEST_CODE_GALLERY && resultCode == Activity.RESULT_OK && data != null){
//            Uri uri = data.getData();
//
//
//                String[] filePathColumn = { MediaStore.Images.Media.DATA };
//
//                Cursor cursor = this.getContext().getContentResolver().query(uri,
//                        filePathColumn, null, null, null);
//
//                cursor.moveToFirst();
//
//                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                imgDecodableString = cursor.getString(columnIndex);
//                cursor.close();
//
//                imageView.setImageBitmap(BitmapFactory
//                        .decodeFile(imgDecodableString));
////                InputStream inputStream = getContentResolver().openInputStream(uri);
////
////
////                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
////                imageView.setImageBitmap(bitmap);
//
//
//        }
//
//        super.onActivityResult(requestCode, resultCode, data);
//    }

}
