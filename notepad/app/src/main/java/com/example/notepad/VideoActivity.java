package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.notepad.R;

public class VideoActivity extends AppCompatActivity {
    VideoView vv;
    static final int REQUEST_VIDEO_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        vv=findViewById(R.id.vv);
    }

    public void takeVideo(View view) {
        Intent intent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_VIDEO_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //1.获取数据uri
        super.onActivityResult(requestCode, resultCode, intent);
        Uri videoUri = intent.getData();
        //2.实例化媒体控制器
        MediaController controller = new MediaController(this);
        //3.设置播放源
        vv.setVideoURI(videoUri);
        //4.媒体控制器与视频控件相互关联
        controller.setMediaPlayer(vv);
        vv.setMediaController(controller);
    }

    public void backVideo(View view) {
        VideoActivity.this.finish();
    }
}
