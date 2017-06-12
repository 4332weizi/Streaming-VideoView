package com.lyun.widget.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.VideoView;

/**
 * @author 赵尉尉
 * @since 2015/7/9 21:21
 */
public class LYunVideoView extends VideoView implements LYunVideoController.LYunMediaPlayerControl{

    private Context context;

    private AudioManager mAudioManager;
    private boolean fullScreen;

    public LYunVideoView(Context context) {
        super(context);
        init(context);
    }

    public LYunVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LYunVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        this.context = context;
        //音量控制,初始化定义
        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public void setMediaController(LYunVideoController controller) {
        super.setMediaController(controller);

        if(controller!=null){
            controller.setCurrentVolume(mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            controller.setMaxVolume(mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        }
    }

    @Override
    public boolean isFullScreen() {
        return fullScreen;
    }

    @Override
    public void toggleFullScreen() {
        if (fullScreen) {
            ((Activity)context).getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN); // 设置全屏
            fullScreen = false;
        } else {
            ((Activity)context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN); // 设置全屏
            fullScreen = true;
        }
    }

    @Override
    public void turnOnVolume() {

    }

    @Override
    public void turnOffVolume() {

    }

    @Override
    public void changeVolume(int volume) {
        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
    }

}
