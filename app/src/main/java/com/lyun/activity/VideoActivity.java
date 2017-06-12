package com.lyun.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;

import com.lyun.widget.media.LYunVideoController;
import com.lyun.widget.media.LYunVideoView;

import net.funol.streaming.R;


public class VideoActivity extends Activity {

    private LYunVideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mVideoView = (LYunVideoView) findViewById(R.id.main_video_view);
        mVideoView.setVideoURI(Uri.parse("http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8"));
        LYunVideoController controller = new LYunVideoController(this,false);
        mVideoView.setMediaController(controller);
        mVideoView.start();
        controller.show();

//        Uri uri = Uri.parse("http://tv.law-cloud.com.cn:8080/vdp/audio/2015/07/08/a201507085PLTD0OHU9BHN998.mp3");
//        final MediaPlayer mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        try {
//            mediaPlayer.setDataSource(getApplicationContext(), uri);
//            mediaPlayer.prepare();
//            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mp) {
//                    mediaPlayer.start();
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
