package com.andy.statusexample;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus && Build.VERSION.SDK_INT > 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    /**
     * SYSTEM_UI_FLAG_FULLSCREEN此flag表示全屏的意思，也就是会将状态栏隐藏
     **/
    protected void status_one() {
        if (Build.VERSION.SDK_INT > 21) {   //判断当前调试机的Android SDK版本是否大于21(Android 5.0)
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
    }

    /**
     * SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN and SYSTEM_UI_FLAG_LAYOUT_STABLE
     * 这两个flag结合可以让应用的主体内容占用系统状态栏的空间
     **/
    protected void status_two() {
        if (Build.VERSION.SDK_INT > 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);   //set statusbar is transparent
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
    }

    /**
     * SYSTEM_UI_FLAG_HIDE_NAVIGATION and SYSTEM_UI_FLAG_FULLSCREEN
     * 这两个flag结合可以让应用的状态栏和导航栏同时隐藏
     **/
    protected void status_three() {
        if (Build.VERSION.SDK_INT > 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
    }

    /**
     * SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN and SYSTEM_UI_FLAG_LAYOUT_STABLE
     * 这两个flag结合可以让应用的主体内容占用系统状态栏的空间加上SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
     * 表示可以占用系统的导航栏
     **/
    protected void status_four() {
        if (Build.VERSION.SDK_INT > 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);   //set statusbar is transparent
            getWindow().setNavigationBarColor(Color.TRANSPARENT);   //set navigationbar is transparent
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
    }
}
