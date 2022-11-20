package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ShowPicture extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_picture);
        img = (ImageView)findViewById(R.id.iv_showPic);
        Intent intent = this.getIntent();
        String imgPath = intent.getStringExtra("imgPath");
        Bitmap bm = BitmapFactory.decodeFile(imgPath);
        img.setImageBitmap(bm);
    }

    public void back_show_pic(View view) {
        ShowPicture.this.finish();
    }
}