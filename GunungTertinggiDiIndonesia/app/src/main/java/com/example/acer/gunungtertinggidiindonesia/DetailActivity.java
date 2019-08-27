package com.example.acer.gunungtertinggidiindonesia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DetailActivity extends AppCompatActivity {

    TextView deskripsi;
    TextView tinggi;
    TextView lokasi;
    TextView kondisi;
    ImageView gmaps;
    ImageView gimage;
    ImageView foto;

    String mName, mPhoto, mDesc, mTinggi, mLoc, mKondisi, mGmaps, mGimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Mountain mountain = getIntent().getParcelableExtra("Mountain");
        mName = mountain.getName();
        setActionBarTitle(mName);

        mPhoto = mountain.getPhoto();
        mDesc = mountain.getDesc();
        mTinggi = mountain.getTinggi();
        mLoc = mountain.getLokasi();
        mKondisi = mountain.getKondisi();
        mGmaps = mountain.getGmaps();
        mGimage = mountain.getGimage();


        foto = findViewById(R.id.img_item_photo);
        Glide.with(this).load(mPhoto).apply(new RequestOptions().override(200,150)).into(foto);

        lokasi = findViewById(R.id.tv_item_loc);
        lokasi.setText(mLoc);

        tinggi = findViewById(R.id.tv_item_height);
        tinggi.setText(mTinggi);

        kondisi = findViewById(R.id.tv_item_eruption);
        kondisi.setText(mKondisi);

        deskripsi = findViewById(R.id.tv_item_desc);
        deskripsi.setText(mDesc);

        gmaps = findViewById(R.id.img_gmaps);
        gimage = findViewById(R.id.img_search);
    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void onClickGmaps(View view) {
        Uri gmmIntentUri = Uri.parse("https://plus.codes/"+ mGmaps);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void onClickSearch(View view) throws UnsupportedEncodingException {
        String escapedQuery = URLEncoder.encode(mGimage, "UTF-8");
        Uri uri = Uri.parse("https://www.google.com/search?tbm=isch&q=" + escapedQuery);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
