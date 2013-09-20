package com.jaynewstrom.touchdelegatebug;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.FrameLayout;

import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Views;

public class MainActivity extends Activity {

    @InjectView(R.id.check_box) CheckBox checkBox;
    @InjectView(R.id.frame_layout) FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        Views.inject(this);

        ViewHelper.expandTouchArea(this.frameLayout, this.checkBox, 50);
    }

    @OnClick(R.id.frame_layout)
    void onFrameClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("The frame has been clicked");
        builder.show();
    }
}
